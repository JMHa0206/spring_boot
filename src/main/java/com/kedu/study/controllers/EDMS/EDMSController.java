// 📁 EDMSController.java
package com.kedu.study.controllers.EDMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.EDMSDTO;
import com.kedu.study.service.EDMS.EDMSEmpService;
import com.kedu.study.service.EDMS.EDMSService;

@RestController
@RequestMapping("/api/edms")
public class EDMSController {

    @Autowired
    private EDMSService edmsService;
    @Autowired
    private EDMSEmpService edmsEmpServ;

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
    
    @GetMapping("/waiting")
    public ResponseEntity<List<EDMSDTO>> getMyPendingApprovals(@RequestAttribute("userId") String loginId) {
        int empCodeId = edmsEmpServ.getEmpCodeIdByLoginId(loginId);
        System.out.println(empCodeId);
    	List<EDMSDTO> result = edmsService.getPendingApprovals(empCodeId);
        return ResponseEntity.ok(result);
    }

    // ✅ 내가 기안한 문서들
    @GetMapping("/mydrafts")
    public ResponseEntity<List<EDMSDTO>> getMyDrafts(@RequestAttribute("userId") String loginId) {
        int empCodeId = edmsEmpServ.getEmpCodeIdByLoginId(loginId);
        System.out.println(empCodeId);
        List<EDMSDTO> result = edmsService.getMyDrafts(empCodeId);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EDMSDTO> getEdmsDetail(@PathVariable Long id) {
        System.out.println("📢 들어온 ID: " + id);
        EDMSDTO result = edmsService.getEdmsDetail(id);
        if (result == null) {
            System.out.println("❌ 데이터 없음 for id: " + id);
            return ResponseEntity.notFound().build();
        }
        System.out.println("✅ 데이터 찾음: " + result.getEdmsTitle());
        return ResponseEntity.ok(result);
    }
    
    
}
