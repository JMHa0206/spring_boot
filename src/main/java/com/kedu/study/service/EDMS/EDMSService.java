package com.kedu.study.service.EDMS;

import com.kedu.study.dao.EDMS.EDMSDAO;
import com.kedu.study.dto.EDMSDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EDMSService {

    @Autowired
    private EDMSDAO daoe;

    @Autowired
    private EDMSFileService fileService;

    @Autowired
    private EDMSHistoryService historyService;

    // 📌 전자결재 등록
    public int insertEDMS(EDMSDTO edms) {
        int result = daoe.insertEDMS(edms);
        System.out.println("✅ insertEDMS 결과: " + result);
        System.out.println("✅ edmsId 반환 확인: " + edms.getEdmsId());

        Long edmsId = edms.getEdmsId();

        // ✅ 참조 부서 등록
        if (edms.getRefDeptList() != null && !edms.getRefDeptList().isEmpty()) {
            daoe.insertRefDepartments(edms.getEdmsId(), edms.getRefDeptList());
            System.out.println("📎 참조부서 저장: " + edms.getRefDeptList());
        }
        if (edms.getRecvDeptList() != null && !edms.getRecvDeptList().isEmpty()) {
            daoe.insertRecvDepartments(edms.getEdmsId(), edms.getRecvDeptList());
            System.out.println("📩 수신부서 저장: " + edms.getRecvDeptList());
        }

        return result;
    }

    // 📌 파일 parent_seq 갱신
    public void updateFileParentSeq(String sysName, Long edmsId) {
        if (sysName != null && edmsId != null) {
            fileService.updateFileParentSeq(sysName, edmsId);
        }
    }

    // 📌 결재 승인 처리
    public boolean approveDocument(Long id, int empCodeId) {
        if (empCodeId <= 0) throw new IllegalArgumentException("Invalid empCodeId: " + empCodeId);

        EDMSDTO doc = getEdmsDetail(id);
        int level = getCurrentLevel(doc, empCodeId);
        if (level == -1) return false;

        if (isFinalApprover(doc, empCodeId) && !historyService.hasAllPriorApprovals(id, level)) {
            return false;
        }

        historyService.recordApproval(id, empCodeId, "APPROVED", level, null);

        if (isFinalApprover(doc, empCodeId)) {
            daoe.updateStateCode(id, 4); // 완료
        } else {
            daoe.updateStateCode(id, 2); // 진행중
        }
        return true;
    }

    // 📌 반려 처리
    public boolean rejectDocument(Long id, int empCodeId, String reason) {
        if (empCodeId <= 0) throw new IllegalArgumentException("Invalid empCodeId: " + empCodeId);

        EDMSDTO doc = getEdmsDetail(id);
        int level = getCurrentLevel(doc, empCodeId);
        if (level == -1) return false;

        historyService.recordApproval(id, empCodeId, "REJECTED", level, reason);
        daoe.updateStateCode(id, 3);
        daoe.updateRejectReason(id, reason);
        return true;
    }

    // 📌 현재 결재자의 단계
    private int getCurrentLevel(EDMSDTO doc, int empCodeId) {
        if (doc.getLevel1() != null && doc.getLevel1().equals(empCodeId)) return 1;
        if (doc.getLevel2() != null && doc.getLevel2().equals(empCodeId)) return 2;
        if (doc.getLevel3() != null && doc.getLevel3().equals(empCodeId)) return 3;
        if (doc.getLevel4() != null && doc.getLevel4().equals(empCodeId)) return 4;
        if (doc.getFinalLevel() != null && doc.getFinalLevel().equals(empCodeId)) return 5;
        return -1;
    }

    // 📌 최종 결재자인지 체크
    private boolean isFinalApprover(EDMSDTO doc, int empCodeId) {
        return doc.getFinalLevel() != null && doc.getFinalLevel().equals(empCodeId);
    }

    public EDMSDTO getEdmsDetail(Long id) {
        return daoe.getEdmsDetail(id);
    }

    public List<EDMSDTO> getPendingApprovals(int empCodeId) {
        return daoe.getPendingApproval(empCodeId);
    }

    public List<EDMSDTO> getMyDrafts(int empCodeId) {
        return daoe.getMyDrafts(empCodeId);
    }

    public List<EDMSDTO> getCompletedDocs(int empCodeId) {
        return daoe.getCompletedDocs(empCodeId);
    }

    public List<EDMSDTO> getRejectedDocs(int empCodeId) {
        return daoe.getRejectedDocs(empCodeId);
    }

    public List<EDMSDTO> getDeptRefDocs(int deptId) {
        return daoe.getDeptRefDocs(deptId);
    }

    public List<EDMSDTO> getDeptCreatedDocs(int deptId) {
        return daoe.getDeptCreatedDocs(deptId);
    }
}
