package com.kedu.study.dao.EDMS;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.EDMSSignOffDTO;

@Repository
public class EDMSSignOffDAO {
	
	@Autowired
    private SqlSession mybatis;

    private static final String NAMESPACE = "EDMSSignOff";

    public List<EDMSSignOffDTO> findAllSignOffs() {
        return mybatis.selectList(NAMESPACE + ".findAllSignOffs");
    }

    public EDMSSignOffDTO findSignOffById(int signId) {
        return mybatis.selectOne(NAMESPACE + ".findSignOffById", signId);
    }

    public void insertSignOff(EDMSSignOffDTO signOff) {
    	mybatis.insert(NAMESPACE + ".insertSignOff", signOff);
    }

    public void updateSignOff(EDMSSignOffDTO signOff) {
    	mybatis.update(NAMESPACE + ".updateSignOff", signOff);
    }

    public void deleteSignOff(int signId) {
    	mybatis.delete(NAMESPACE + ".deleteSignOff", signId);
    }
}
