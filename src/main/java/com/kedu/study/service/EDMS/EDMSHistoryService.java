// EDMSHistoryService.java
package com.kedu.study.service.EDMS;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.EDMS.EDMSHistoryDAO;
import com.kedu.study.dto.EDMSHistoryDTO;

@Service
public class EDMSHistoryService {

    @Autowired
    private EDMSHistoryDAO historyDAO;

    public void recordApproval(Long edmsId, int empCodeId, String type, int stepLevel, String reason) {
        if (empCodeId <= 0) throw new IllegalArgumentException("empCodeId is missing or invalid");

        EDMSHistoryDTO history = new EDMSHistoryDTO();
        history.setEdmsId(edmsId);
        history.setApproverId(empCodeId);
        history.setAction(type);
        history.setStepLevel(stepLevel);
        history.setReason(reason);
        history.setActionDate(new Date());

        historyDAO.insertHistory(history);
    }

    public boolean hasAllPriorApprovals(Long edmsId, int currentLevel) {
        return historyDAO.checkPriorApprovals(edmsId, currentLevel);
    }

    public List<EDMSHistoryDTO> getApprovalHistory(Long docId) {
        return historyDAO.getApprovalHistory(docId);
    }
}