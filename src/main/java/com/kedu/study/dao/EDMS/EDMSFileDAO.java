package com.kedu.study.dao.EDMS;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.EDMSFileDTO;

@Repository
public class EDMSFileDAO {
	
	@Autowired
    private SqlSession mybatis;

    private static final String NAMESPACE = "EDMSfile";

    public List<EDMSFileDTO> findAllFiles() {
        return mybatis.selectList(NAMESPACE + ".findAllFiles");
    }

    public EDMSFileDTO findFileById(int fileId) {
        return mybatis.selectOne(NAMESPACE + ".findFileById", fileId);
    }

    public void insertFile(EDMSFileDTO file) {
    	mybatis.insert(NAMESPACE + ".insertFile", file);
    }

    public void updateFile(EDMSFileDTO file) {
    	mybatis.update(NAMESPACE + ".updateFile", file);
    }

    public void deleteFile(int fileId) {
    	mybatis.delete(NAMESPACE + ".deleteFile", fileId);
    }
}
