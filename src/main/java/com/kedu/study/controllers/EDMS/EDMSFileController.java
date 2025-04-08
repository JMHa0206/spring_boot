// 📁 FileUploadController.java
package com.kedu.study.controllers.EDMS;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/files")
public class EDMSFileController {

    @PostMapping("/upload")
    public ResponseEntity<?> handleUpload(@RequestParam("files") List<MultipartFile> files) {
        try {
            List<String> storedFileIds = new ArrayList<>();
            for (MultipartFile file : files) {
                // 실제 저장 처리 로직 필요함
                System.out.println("업로드 파일: " + file.getOriginalFilename());
                storedFileIds.add(file.getOriginalFilename());
            }
            return ResponseEntity.ok().body(new UploadResponse(storedFileIds));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("파일 업로드 실패: " + e.getMessage());
        }
    }

    static class UploadResponse {
        public List<String> fileIds;

        public UploadResponse(List<String> fileIds) {
            this.fileIds = fileIds;
        }
    }
}
