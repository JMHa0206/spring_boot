// 📁 EDMSController.java
package com.kedu.study.controllers.EDMS;

import com.kedu.study.dto.EDMSDTO;
import com.kedu.study.service.EDMS.EDMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/edms")
public class EDMSController {

    @Autowired
    private EDMSService edmsService;

    @PostMapping("/register")
    public ResponseEntity<String> registerEDMS(@RequestBody EDMSDTO edmsDTO) {
        try {
            int result = edmsService.insertEDMS(edmsDTO);
            if (result > 0) {
                return ResponseEntity.ok("전자결재 등록 성공");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("전자결재 등록 실패: DB 처리 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("서버 오류 발생: " + e.getMessage());
        }
    }
}
