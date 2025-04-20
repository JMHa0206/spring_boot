package com.kedu.study.service.EDMS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kedu.study.dao.EDMS.EDMSFileDAO;
import com.kedu.study.dto.EDMSFileDTO;

@Service
public class EDMSFileService {

    private final EDMSFileDAO edmsFileDAO;

    public EDMSFileService(EDMSFileDAO edmsFileDAO) {
        this.edmsFileDAO = edmsFileDAO;
    }

    // 🔍 전체 파일 조회
    public List<EDMSFileDTO> getAllFiles() {
        List<EDMSFileDTO> list = edmsFileDAO.findAllFiles();
        System.out.println("📋 전체 파일 조회: " + (list != null ? list.size() : "null"));
        return list;
    }

    // 🔍 ID로 단일 파일 조회
    public EDMSFileDTO getFileById(int fileId) {
        EDMSFileDTO dto = edmsFileDAO.findFileById(fileId);
        System.out.println("🔍 ID로 파일 조회: " + fileId + " -> " + (dto != null ? dto.getEdmsSysName() : "없음"));
        return dto;
    }

    // 📥 파일 등록
    public void createFile(EDMSFileDTO file) {
        System.out.println("📥 파일 등록 시도: " + file.getEdmsOriName() + " / sys: " + file.getEdmsSysName());
        edmsFileDAO.insertFile(file);
        System.out.println("✅ 파일 등록 완료");
    }

    // ✏️ 파일 정보 업데이트
    public void updateFile(EDMSFileDTO file) {
        System.out.println("✏️ 파일 업데이트: ID=" + file.getEdmsFileId());
        edmsFileDAO.updateFile(file);
    }

    // 🗑️ 파일 삭제
    public void deleteFile(int fileId) {
        System.out.println("🗑️ 파일 삭제: " + fileId);
        edmsFileDAO.deleteFile(fileId);
    }

    // 🔍 시스템 파일명으로 파일 조회
    public EDMSFileDTO findBySysName(String sysName) {
        EDMSFileDTO dto = edmsFileDAO.findBySysName(sysName);
        System.out.println("🔍 시스템 파일명 조회: " + sysName + " -> " + (dto != null ? dto.getEdmsFileId() : "없음"));
        return dto;
    }

    // 🔍 문서 ID로 파일 리스트 조회
    public List<EDMSFileDTO> getFilesByParentSeq(Long edmsId) {
        System.out.println("📨 parentSeq 파일 조회 요청: edmsId=" + edmsId);
        List<EDMSFileDTO> result = edmsFileDAO.findFilesByParentSeq(edmsId);
        System.out.println("🔎 결과 개수: " + (result != null ? result.size() : "null"));
        return result;
    }

    // 📃 전체 시스템 파일명 조회
    public List<String> getAllSysFileNames() {
        return edmsFileDAO.getAllSysFileNames();
    }

    // 🔗 문서 등록 후 파일 parent_seq 업데이트
    public void updateFileParentSeq(Long parentSeq, List<String> sysNames) {
        if (sysNames == null || sysNames.isEmpty()) {
            System.out.println("⚠️ 연결할 파일 이름이 비어있음. parentSeq: " + parentSeq);
            return;
        }

        System.out.println("📎 parentSeq 업데이트 실행: parentSeq = " + parentSeq);
        System.out.println("📄 연결 대상 파일 목록:");
        sysNames.forEach(name -> System.out.println(" - " + name));

        Map<String, Object> params = new HashMap<>();
        params.put("parentSeq", parentSeq);
        params.put("sysNames", sysNames);

        edmsFileDAO.updateFileParentSeq(params);
        System.out.println("✅ parentSeq 업데이트 완료");
    }
}
