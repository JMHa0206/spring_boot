
// EDMSHistoryDAO.java
package com.kedu.study.dao.EDMS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.EDMSHistoryDTO;

@Repository
public class EDMSHistoryDAO {

    @Autowired
    public SqlSession mybatis;

    public static final String namespace = "edmsMapper";

    public void insertHistory(EDMSHistoryDTO history) {
        Map<String, Object> params = new HashMap<>();
        params.put("edmsId", history.getEdmsId());
        params.put("approverId", history.getApproverId()); // ✅ 이름 통일
        params.put("action", history.getAction());
        params.put("stepLevel", history.getStepLevel());
        params.put("reason", history.getReason());
        params.put("actionDate", history.getActionDate());

        mybatis.insert(namespace + ".insertApprovalHistory", params);
    }

    public boolean checkPriorApprovals(Long edmsId, int currentLevel) {
        Map<String, Object> param = new HashMap<>();
        param.put("edmsId", edmsId);
        param.put("currentLevel", currentLevel);
        Integer count = mybatis.selectOne(namespace + ".hasAllPriorApprovals", param);
        return count == 0;
    }

    public List<EDMSHistoryDTO> getApprovalHistory(Long docId) {
        return mybatis.selectList(namespace + ".getApprovalHistory", docId);
    }
}
