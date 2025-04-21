package com.kedu.study.dao.EDMS;

import com.kedu.study.dto.EDMSFileDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<String> getAllSysFileNames() {
        return mybatis.selectList(NAMESPACE + ".getAllSysFileNames");
    }

    public EDMSFileDTO findBySysName(String sysName) {
        return mybatis.selectOne(NAMESPACE + ".findBySysName", sysName);
    }

    public List<EDMSFileDTO> findFilesByParentSeq(Long parentSeq) {
        return mybatis.selectList(NAMESPACE + ".getFilesByParentSeq", parentSeq);
    }

    public void updateFileParentSeq(Map<String, Object> params) {
        mybatis.update(NAMESPACE + ".updateFileParentSeq", params);
    }
}
