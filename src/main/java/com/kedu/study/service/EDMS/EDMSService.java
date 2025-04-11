// EDMSService.java
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
    private EDMSHistoryService historyService;

    public int insertEDMS(EDMSDTO edms) {
        return daoe.insertEDMS(edms);
    }

    public List<EDMSDTO> getPendingApprovals(int empCodeId) {
        return daoe.getPendingApproval(empCodeId);
    }

    public List<EDMSDTO> getMyDrafts(int empCodeId) {
        return daoe.getMyDrafts(empCodeId);
    }

    public EDMSDTO getEdmsDetail(Long id) {
        return daoe.getEdmsDetail(id);
    }

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

    private int getCurrentLevel(EDMSDTO doc, int empCodeId) {
        if (doc.getLevel1() != null && doc.getLevel1().equals(empCodeId)) return 1;
        if (doc.getLevel2() != null && doc.getLevel2().equals(empCodeId)) return 2;
        if (doc.getLevel3() != null && doc.getLevel3().equals(empCodeId)) return 3;
        if (doc.getLevel4() != null && doc.getLevel4().equals(empCodeId)) return 4;
        if (doc.getFinalLevel() != null && doc.getFinalLevel().equals(empCodeId)) return 5;
        return -1;
    }

    private boolean isFinalApprover(EDMSDTO doc, int empCodeId) {
        return doc.getFinalLevel() != null && doc.getFinalLevel().equals(empCodeId);
    }
}