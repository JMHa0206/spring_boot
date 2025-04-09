package com.kedu.study.controllers.EDMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.service.EDMS.EDMSEmpService;

@RestController
@RequestMapping("/api")
public class EDMSEmpController {
	
    @Autowired
    private EDMSEmpService eServ;

    @GetMapping("/employee/code")
    public ResponseEntity<Integer> getEmpCodeByLoginId(@RequestAttribute("userId") String loginId) {
        if (loginId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        try {
            int codeId = eServ.getEmpCodeIdByLoginId(loginId);
            return ResponseEntity.ok(codeId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
