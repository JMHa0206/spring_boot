package com.kedu.study.controllers.EDMS;

import com.kedu.study.dto.EDMSDTO;
import com.kedu.study.dto.EDMSFileDTO;
import com.kedu.study.dto.EDMSHistoryDTO;
import com.kedu.study.service.EDMS.EDMSEmpService;
import com.kedu.study.service.EDMS.EDMSFileService;
import com.kedu.study.service.EDMS.EDMSHistoryService;
import com.kedu.study.service.EDMS.EDMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/edms")
public class EDMSController {

    @Autowired
    private EDMSService edmsService;

    @Autowired
    private EDMSFileService edmsFileService;

    @Autowired
    private EDMSEmpService edmsEmpService;

    @Autowired
    private EDMSHistoryService edmsHistoryService;

    @PostMapping("/register")
    public ResponseEntity<String> registerEDMS(@RequestBody EDMSDTO edmsDTO) {
        try {
            int result = edmsService.insertEDMS(edmsDTO);
            System.out.println("\uD83D\uDCE9 문서 등록 요청: " + edmsDTO.getEdmsTitle());
            System.out.println("📌 등록 후 edmsId 확인: " + edmsDTO.getEdmsId());

            if (edmsDTO.getAttachments() != null && edmsDTO.getEdmsId() != null) {
                edmsFileService.updateFileParentSeq(edmsDTO.getEdmsId(), edmsDTO.getAttachments());
                System.out.println("📎 파일 연결 완료: " + edmsDTO.getAttachments());
            } else {
                System.out.println("⚠ 파일 연결 없음 또는 edmsId 없음");
            }

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
        int empCodeId = edmsEmpService.getEmpCodeIdByLoginId(loginId);
        System.out.println("🧾 [대기 문서] loginId=" + loginId + " / empCodeId=" + empCodeId);
        List<EDMSDTO> result = edmsService.getPendingApprovals(empCodeId);
        System.out.println("📥 대기 문서 수: " + result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/mydrafts")
    public ResponseEntity<List<EDMSDTO>> getMyDrafts(@RequestAttribute("userId") String loginId) {
        int empCodeId = edmsEmpService.getEmpCodeIdByLoginId(loginId);
        System.out.println("✍️ [기안 문서] loginId=" + loginId + " / empCodeId=" + empCodeId);
        List<EDMSDTO> result = edmsService.getMyDrafts(empCodeId);
        System.out.println("📝 기안 문서 수: " + result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/completed")
    public ResponseEntity<List<EDMSDTO>> getCompletedDocs(@RequestAttribute("userId") String loginId) {
        int empCodeId = edmsEmpService.getEmpCodeIdByLoginId(loginId);
        System.out.println("✅ [완료 문서] loginId=" + loginId + " / empCodeId=" + empCodeId);
        List<EDMSDTO> result = edmsService.getCompletedDocs(empCodeId);
        System.out.println("✅ 완료 문서 수: " + result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/rejected")
    public ResponseEntity<List<EDMSDTO>> getRejectedDocs(@RequestAttribute("userId") String loginId) {
        int empCodeId = edmsEmpService.getEmpCodeIdByLoginId(loginId);
        System.out.println("❌ [반려 문서] loginId=" + loginId + " / empCodeId=" + empCodeId);
        List<EDMSDTO> result = edmsService.getRejectedDocs(empCodeId);
        System.out.println("❌ 반려 문서 수: " + result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/department/ref")
    public ResponseEntity<List<EDMSDTO>> getRefDocs(@RequestAttribute("userId") String loginId) {
        int deptId = edmsEmpService.getDeptIdByLoginId(loginId);
        System.out.println("📂 [부서 참조 문서] loginId=" + loginId + " / deptId=" + deptId);
        List<EDMSDTO> result = edmsService.getDeptRefDocs(deptId);
        System.out.println("📂 참조 문서 수: " + result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/department/created")
    public ResponseEntity<List<EDMSDTO>> getDeptCreatedDocs(@RequestAttribute("userId") String loginId) {
        int deptId = edmsEmpService.getDeptIdByLoginId(loginId);
        System.out.println("🏢 [부서 생산 문서] loginId=" + loginId + " / deptId=" + deptId);
        List<EDMSDTO> result = edmsService.getDeptCreatedDocs(deptId);
        System.out.println("🏢 생산 문서 수: " + result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EDMSDTO> getEdmsDetail(@PathVariable Long id) {
        System.out.println("📢 문서 상세 요청: ID=" + id);
        EDMSDTO result = edmsService.getEdmsDetail(id);
        if (result == null) {
            System.out.println("❌ 문서 없음 for id: " + id);
            return ResponseEntity.notFound().build();
        }
        System.out.println("✅ 문서 확인됨: " + result.getEdmsTitle());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{docId}/history")
    public ResponseEntity<List<EDMSHistoryDTO>> getApprovalHistory(@PathVariable("docId") Long docId) {
        System.out.println("📜 이력 요청 docId: " + docId);
        List<EDMSHistoryDTO> history = edmsHistoryService.getApprovalHistory(docId);
        if (history == null || history.isEmpty()) {
            System.out.println("📭 이력 없음: 빈 리스트 반환");
            return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(history);
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<String> approveDocument(@PathVariable Long id, @RequestAttribute("userId") String loginId) {
        System.out.println("🧾 결재 요청: ID=" + id + " / loginId=" + loginId);
        int empCodeId = edmsEmpService.getEmpCodeIdByLoginId(loginId);
        System.out.println("🧑‍💼 empCodeId: " + empCodeId);
        boolean result = edmsService.approveDocument(id, empCodeId);
        return result ? ResponseEntity.ok("결재 완료") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("결재 실패");
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<String> rejectDocument(@PathVariable Long id, @RequestAttribute("userId") String loginId, @RequestBody String reason) {
        System.out.println("📤 반려 요청: ID=" + id + " / loginId=" + loginId + " / 사유=" + reason);
        int empCodeId = edmsEmpService.getEmpCodeIdByLoginId(loginId);
        boolean result = edmsService.rejectDocument(id, empCodeId, reason);
        return result ? ResponseEntity.ok("반려 완료") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("반려 실패");
    }
}
