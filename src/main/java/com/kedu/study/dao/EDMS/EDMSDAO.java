package com.kedu.study.dao.EDMS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.EDMSDTO;

@Repository
public class EDMSDAO {
	
    @Autowired
    public SqlSession mybatis;
    
    public static final String namespace = "edmsMapper";
    // 전자결재 저장
    public int insertEDMS(EDMSDTO edms) {
        return mybatis.insert(namespace+".insertEDMS", edms);
    }
    // 기타 필요 시 여기에 더 추가: updateEDMS, selectEDMSList, getEDMSDetail 등
	public List<EDMSDTO> getPendingApproval(int empCodeId) {
		return mybatis.selectList(namespace+".getPendingList",empCodeId);
	}
	public List<EDMSDTO> getMyDrafts(int empCodeId) {
		return mybatis.selectList(namespace+".getMyDrafts",empCodeId);
	}
	public EDMSDTO getEdmsDetail(Long id) {
		return mybatis.selectOne(namespace+".getEdmsDetail",id);
	}
	public boolean rejectDocument(Long id, int empCodeId, String reason) {
		int result = mybatis.update(namespace+".rejectDocument",Map.of("id",id,"empCodeId",empCodeId,"reason",reason));
		return result >0 ;
	}
	public boolean approveDocument(Long id, int empCodeId) {
		int result = mybatis.update(namespace+".approveDocument",Map.of("id",id,"empCodeId",empCodeId)); 
		return result >0 ;
	}
	public void updateStateCode(Long edmsId, int stateCode) {
	    mybatis.update(namespace + ".updateStateCode", Map.of("edmsId", edmsId, "stateCode", stateCode));
	}

	public void updateRejectReason(Long edmsId, String reason) {
	    mybatis.update(namespace + ".updateRejectReason", Map.of("edmsId", edmsId, "reason", reason));
	}

}
