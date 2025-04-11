package com.kedu.study.controllers.EDMS;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kedu.study.dto.EDMSDTO;
import com.kedu.study.dto.EDMSHistoryDTO;
import com.kedu.study.service.EDMS.EDMSEmpService;
import com.kedu.study.service.EDMS.EDMSHistoryService;
import com.kedu.study.service.EDMS.EDMSService;

@RestController
@RequestMapping("/api/edms")
public class EDMSController {

    @Autowired
    private EDMSService edmsService;

    @Autowired
    private EDMSEmpService edmsEmpServ;

    @Autowired
    private EDMSHistoryService edmsHisServ;

    @PostMapping("/register")
    public ResponseEntity<String> registerEDMS(@RequestBody EDMSDTO edmsDTO) {
        try {
            int result = edmsService.insertEDMS(edmsDTO);
            return result > 0
                    ? ResponseEntity.ok("전자결재 등록 성공")
                    : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("전자결재 등록 실패: DB 처리 실패");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류 발생: " + e.getMessage());
        }
    }

    @GetMapping("/waiting")
    public ResponseEntity<List<EDMSDTO>> getMyPendingApprovals(@RequestAttribute("userId") String loginId) {
        int empCodeId = edmsEmpServ.getEmpCodeIdByLoginId(loginId);
        System.out.println("🧾 대기 결재자 ID: " + empCodeId);
        List<EDMSDTO> result = edmsService.getPendingApprovals(empCodeId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/mydrafts")
    public ResponseEntity<List<EDMSDTO>> getMyDrafts(@RequestAttribute("userId") String loginId) {
        int empCodeId = edmsEmpServ.getEmpCodeIdByLoginId(loginId);
        System.out.println("✍️ 기안자 ID: " + empCodeId);
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

    @PostMapping("/{id}/approve")
    public ResponseEntity<String> approveDocument(
        @PathVariable Long id,
        @RequestAttribute("userId") String loginId) {

        System.out.println("🧾 들어온 결재 요청 ID: " + id);
        System.out.println("🙋‍♂️ 로그인한 사용자 ID (loginId): " + loginId);

        int empCodeId = edmsEmpServ.getEmpCodeIdByLoginId(loginId);

        System.out.println("🧑‍💼 매핑된 사원코드 ID (empCodeId): " + empCodeId);

        boolean result = edmsService.approveDocument(id, empCodeId);

        return result
            ? ResponseEntity.ok("결재 완료")
            : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("결재 실패");
    }


    @PostMapping("/{id}/reject")
    public ResponseEntity<String> rejectDocument(@PathVariable Long id,
                                                 @RequestAttribute("userId") String loginId,
                                                 @RequestBody String reason) {
        int empCodeId = edmsEmpServ.getEmpCodeIdByLoginId(loginId);
        boolean result = edmsService.rejectDocument(id, empCodeId, reason);
        return result
                ? ResponseEntity.ok("반려 완료")
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("반려 실패");
    }

    // ✅ 404 방지 버전: 결재 이력 없을 경우에도 200 OK + 빈 배열
    @GetMapping("/{docId}/history")
    public ResponseEntity<List<EDMSHistoryDTO>> getApprovalHistory(@PathVariable("docId") Long docId) {
        System.out.println("📜 이력 요청 docId: " + docId);
        List<EDMSHistoryDTO> history = edmsHisServ.getApprovalHistory(docId);
        if (history == null || history.isEmpty()) {
            System.out.println("📭 이력 없음: 빈 리스트 반환");
            return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(history);
    }
}
