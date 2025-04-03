package com.kedu.study.controllers.EDMS;

import com.kedu.study.dto.EDMSDTO;
import com.kedu.study.service.EDMS.EDMSService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/edms")
public class EDMSController {

    @Autowired
    private EDMSService eServ;

    // 전자결재 등록 (등록 폼에서 넘어온 JSON 또는 Form 데이터 처리)
    @PostMapping("/register")
    public ResponseEntity<String> registerEDMS(@RequestBody EDMSDTO edms) {
        try {
            int result = eServ.insertEDMS(edms);

            if (result > 0) {
                return ResponseEntity.ok("전자결재가 성공적으로 등록되었습니다.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                     .body("전자결재 등록 실패");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("서버 오류 발생: " + e.getMessage());
        }
    }
    
    
    
}
