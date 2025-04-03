package com.kedu.study.service.EDMS;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kedu.study.dao.EDMS.EDMSFileDAO;
import com.kedu.study.dto.EDMSFileDTO;

@Service
public class EDMSFileService {

    private final EDMSFileDAO edmsFileDAO;

    public EDMSFileService(EDMSFileDAO edmsFileDAO) {
        this.edmsFileDAO = edmsFileDAO;
    }

    public List<EDMSFileDTO> getAllFiles() {
        return edmsFileDAO.findAllFiles();
    }

    public EDMSFileDTO getFileById(int fileId) {
        return edmsFileDAO.findFileById(fileId);
    }

    public void createFile(EDMSFileDTO file) {
        edmsFileDAO.insertFile(file);
    }

    public void updateFile(EDMSFileDTO file) {
        edmsFileDAO.updateFile(file);
    }

    public void deleteFile(int fileId) {
        edmsFileDAO.deleteFile(fileId);
    }
}
