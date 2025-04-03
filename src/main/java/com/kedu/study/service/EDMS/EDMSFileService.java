package com.kedu.study.service.EDMS;

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
