package com.kedu.study.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.kedu.study.dto.BoardDTO;
import com.kedu.study.dto.BoardFileDTO;
import com.kedu.study.service.BoardService;
import com.kedu.study.service.BoardFileService;

@RestController
public class BoardFileController {

    @Autowired
    private BoardFileService boardFileService;

    @Autowired
    private BoardService boardService; 

    @GetMapping("/files")
    @ResponseBody
    public ResponseEntity<List<BoardFileDTO>> getFiles(@RequestParam("post_id") int postId) {
    	   System.out.println("✅ 파일 요청 들어온 post_id: " + postId);
        List<BoardFileDTO> files = boardFileService.getFilesByPostId(postId);
        System.out.println("✅ 반환할 파일 리스트 size: " + files.size());
        return ResponseEntity.ok(files);
    }
    
    //upload 부분
    @PostMapping("/board/filedownload")
    public ResponseEntity<String> insertPostWithFiles(
        @RequestParam("post_title") String postTitle,
        @RequestParam("post_content") String postContent,
        @RequestParam("post_writer") int postWriter,
        @RequestParam("post_tag") String postTag,
        @RequestParam("post_per") String postPer,
        @RequestParam("parent_board") int parentBoard,
        @RequestParam("post_view") int postView,
        @RequestParam("post_like") int postLike,
        @RequestParam(value = "files", required = false) MultipartFile[] files
    ) {
        try {
            // 1. 게시글 저장
            BoardDTO board = new BoardDTO();
            board.setPost_title(postTitle);
            board.setPost_content(postContent);
            board.setPost_writer(postWriter);
            board.setPost_tag(postTag);
            board.setPost_per(postPer);
            board.setParent_board(parentBoard);
            board.setPost_view(postView);
            board.setPost_like(postLike);

            boardService.insertBoard(board); 
           int postId = board.getPost_id(); 

            // 2. 파일 저장
            if (files != null) {
                for (MultipartFile file : files) {
                    if (!file.isEmpty()) {
                        String uploadDir = "C:/uploads/";
                        File dir = new File(uploadDir);
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        String uuid = UUID.randomUUID().toString();
                        String sysname = uuid + "-" + file.getOriginalFilename();
                        File saveFile = new File(uploadDir + sysname);
                        file.transferTo(saveFile); // 실제 파일 저장

                        BoardFileDTO fileDTO = new BoardFileDTO();
                        fileDTO.setParent_post(postId); // 게시글 ID 연결
                        fileDTO.setB_oriname(file.getOriginalFilename());
                        fileDTO.setB_sysname(sysname);

                        boardFileService.insertBoardFile(fileDTO); // ✅ 파일 정보를 files 테이블에 저장
                    }
                }
            }

            return ResponseEntity.ok("등록 완료");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("등록 실패");
        }
    }

    //다운로드 부분
    @GetMapping("/download/{sysname}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String sysname, @RequestParam("oriname") String oriname) {
        try {
            String uploadDir = "C:/uploads/";
            Path filePath = Paths.get(uploadDir).resolve(sysname);

            Resource resource = new FileSystemResource(filePath.toFile());

            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            String encodedOriName = java.net.URLEncoder.encode(oriname, "UTF-8").replaceAll("\\+", "%20");

            return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename*=UTF-8''" + encodedOriName)
                .body(resource);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
    
    
    //파일이 여러개일때 zip형태로 다운로드
    @GetMapping("/download/all/{postId}")
    public ResponseEntity<Resource> downloadAllFiles(@PathVariable int postId) throws IOException {
        List<BoardFileDTO> files = boardFileService.getFilesByPostId(postId);

        // 압축 파일 경로
        String zipFilePath = "C:/uploads/temp_" + UUID.randomUUID() + ".zip";

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath))) {
            for (BoardFileDTO file : files) {
                File sourceFile = new File("C:/uploads/" + file.getB_sysname());
                if (sourceFile.exists()) {
                    zos.putNextEntry(new ZipEntry(file.getB_oriname()));
                    Files.copy(sourceFile.toPath(), zos);
                    zos.closeEntry();
                }
            }
        }

        Resource zipResource = new FileSystemResource(zipFilePath);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=files.zip")
                .body(zipResource);
    }
    
    
    //파일 수정시 기존 파일 삭제 후 다시 파일 넣기
    @PutMapping("/board/updateWithFiles")
    public ResponseEntity<String> updatePostWithFiles(
 
        @RequestParam("post_id") int postId,
        @RequestParam("post_title") String title,
        @RequestParam("post_content") String content,
        @RequestParam(value = "post_writer") Integer postWriter, // ✅ 추가
        @RequestParam(value = "post_per", defaultValue = "공개") String postPer, // ✅ 추가
        @RequestParam(value = "post_tag", defaultValue = "") String postTag,    // ✅ 추가
        @RequestParam(value = "deleted_files", required = false) List<Integer> deletedFileIds,
        @RequestParam(value = "files", required = false) MultipartFile[] files
    ) {
        // 1. 게시글 업데이트
    	 BoardDTO board = new BoardDTO();
    	  board.setPost_id(postId);
    	    board.setPost_title(title);
    	    board.setPost_content(content);
    	    board.setPost_writer(postWriter);
    	    board.setPost_per(postPer);
    	    board.setPost_tag(postTag);
    	    
        boardService.updateBoard(board);

        // 2. 삭제할 파일 DB에서 제거
        if (deletedFileIds != null) {
            for (Integer fileId : deletedFileIds) {
                boardFileService.deleteFileById(fileId); // DB 삭제
            }
        }

        // 3. 새 파일 업로드
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String uploadDir = "C:/uploads/";
                    File dir = new File(uploadDir);
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    String uuid = UUID.randomUUID().toString();
                    String sysname = uuid + "-" + file.getOriginalFilename();
                    File saveFile = new File(uploadDir + sysname);
                    try {
                        file.transferTo(saveFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return ResponseEntity.status(500).body("파일 업로드 실패");
                    }

                    BoardFileDTO fileDTO = new BoardFileDTO();
                    fileDTO.setParent_post(postId);
                    fileDTO.setB_oriname(file.getOriginalFilename());
                    fileDTO.setB_sysname(sysname);
                    boardFileService.insertBoardFile(fileDTO);
                }
            }
        }

        return ResponseEntity.ok("수정 완료");
    }
    
    
    
    
}