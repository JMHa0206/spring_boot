package com.kedu.study.dao.EDMS;

import java.util.List;

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

}
