package com.kedu.study.controllers.EDMS;

import com.kedu.study.dto.EDMSFileDTO;
import com.kedu.study.service.EDMS.EDMSFileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/api/files")
public class EDMSFileController {

    private static final String uploadDir = "C:/upload/edmsfiles";
    private final EDMSFileService edmsFileService;

    public EDMSFileController(EDMSFileService edmsFileService) {
        this.edmsFileService = edmsFileService;
    }

    // 📤 파일 업로드
    @PostMapping("/upload")
    public ResponseEntity<?> handleUpload(@RequestParam("files") List<MultipartFile> files) {
        List<String> uploadedSysNames = new ArrayList<>();
        System.out.println("📥 파일 업로드 요청 수신: 총 " + files.size() + "개");

        try {
            Files.createDirectories(Paths.get(uploadDir));

            for (MultipartFile file : files) {
                String originalName = file.getOriginalFilename();
                String sysName = generateUniqueName(originalName);
                String fullPath = Paths.get(uploadDir, sysName).toString();

                System.out.println("📂 저장 경로: " + fullPath);

                file.transferTo(new File(fullPath));

                EDMSFileDTO fileDto = new EDMSFileDTO();
                fileDto.setEdmsOriName(originalName);
                fileDto.setEdmsSysName(sysName);
                fileDto.setParentSeq(0L); // 최초 연결 없음

                edmsFileService.createFile(fileDto);
                uploadedSysNames.add(sysName);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("파일 저장 실패: " + e.getMessage());
        }

        System.out.println("✅ 업로드 완료 파일 리스트: " + uploadedSysNames);
        return ResponseEntity.ok(uploadedSysNames);
    }

    // 📎 파일 문서 연결
    @PostMapping("/update-parent")
    public ResponseEntity<?> updateParentSeq(@RequestBody ParentUpdateRequest request) {
        try {
            System.out.println("🔗 문서 연결 요청 - edmsId: " + request.getEdmsId());
            System.out.println("📎 연결 대상 파일: " + request.getFileSysNames());

            if (request.getFileSysNames() == null || request.getFileSysNames().isEmpty()) {
                return ResponseEntity.badRequest().body("파일 목록이 비어 있습니다.");
            }

            edmsFileService.updateFileParentSeq(request.getEdmsId(), request.getFileSysNames());
            System.out.println("✅ 파일 연결 성공");

            return ResponseEntity.ok("파일 연결 완료");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("문서 연결 실패: " + e.getMessage());
        }
    }

    // 📥 다운로드
    @GetMapping("/download/{sysName}")
    public ResponseEntity<FileSystemResource> download(@PathVariable String sysName, HttpServletResponse response) throws IOException {
        System.out.println("📤 다운로드 요청: " + sysName);

        EDMSFileDTO fileDto = edmsFileService.findBySysName(sysName);
        if (fileDto == null) {
            System.out.println("❌ 파일 정보 없음 - sysName: " + sysName);
            return ResponseEntity.notFound().build();
        }

        File file = new File(Paths.get(uploadDir, sysName).toString());
        if (!file.exists()) {
            System.out.println("❌ 물리적 파일 없음: " + file.getPath());
            return ResponseEntity.notFound().build();
        }

        String encodedName = URLEncoder.encode(fileDto.getEdmsOriName(), StandardCharsets.UTF_8);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + encodedName)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new FileSystemResource(file));
    }

    // 📄 특정 문서에 연결된 파일들 조회
    @GetMapping("/by-edms/{edmsId}")
    public ResponseEntity<List<EDMSFileDTO>> getFilesByEdmsId(@PathVariable Long edmsId) {
        System.out.println("📨 파일 조회 요청 수신 - edmsId: " + edmsId);

        if (edmsId == null || edmsId <= 0) {
            System.out.println("❌ 잘못된 edmsId 입력됨: " + edmsId);
            return ResponseEntity.badRequest().build();
        }

        List<EDMSFileDTO> files = edmsFileService.getFilesByParentSeq(edmsId);

        if (files == null || files.isEmpty()) {
            System.out.println("❌ 조회된 파일 없음 - edmsId: " + edmsId);
            return ResponseEntity.notFound().build();
        }

        System.out.println("✅ 조회된 파일 수: " + files.size());
        for (EDMSFileDTO f : files) {
            System.out.println(" - 파일: " + f.getEdmsSysName() + " | " + f.getEdmsOriName() + " | parentSeq: " + f.getParentSeq());
        }

        return ResponseEntity.ok(files);
    }

    private String generateUniqueName(String originalName) {
        String ext = "";
        int dotIdx = originalName.lastIndexOf(".");
        if (dotIdx > -1) {
            ext = originalName.substring(dotIdx);
        }
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + "_" + UUID.randomUUID() + ext;
    }

    // 🧾 요청 DTO
    public static class ParentUpdateRequest {
        private List<String> fileSysNames;
        private Long edmsId;

        public List<String> getFileSysNames() {
            return fileSysNames;
        }

        public void setFileSysNames(List<String> fileSysNames) {
            this.fileSysNames = fileSysNames;
        }

        public Long getEdmsId() {
            return edmsId;
        }

        public void setEdmsId(Long edmsId) {
            this.edmsId = edmsId;
        }
    }
}
