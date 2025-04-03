package com.kedu.study.service.EDMS;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kedu.study.dao.EDMS.EDMSSignOffDAO;
import com.kedu.study.dto.EDMSSignOffDTO;

@Service
public class EDMSSignOffService {

    private final EDMSSignOffDAO edmssignOffDAO;

    public EDMSSignOffService(EDMSSignOffDAO edmssignOffDAO) {
        this.edmssignOffDAO = edmssignOffDAO;
    }

    public List<EDMSSignOffDTO> getAllSignOffs() {
        return edmssignOffDAO.findAllSignOffs();
    }

    public EDMSSignOffDTO getSignOffById(int signId) {
        return edmssignOffDAO.findSignOffById(signId);
    }

    public void createSignOff(EDMSSignOffDTO signOff) {
        edmssignOffDAO.insertSignOff(signOff);
    }

    public void updateSignOff(EDMSSignOffDTO signOff) {
        edmssignOffDAO.updateSignOff(signOff);
    }

    public void deleteSignOff(int signId) {
        edmssignOffDAO.deleteSignOff(signId);
    }
}

