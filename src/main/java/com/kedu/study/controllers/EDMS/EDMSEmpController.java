package com.kedu.study.controllers.EDMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.ApproverInfoDTO;
import com.kedu.study.service.EDMS.EDMSEmpService;

@RestController
@RequestMapping("/api/employee")
public class EDMSEmpController {
	
    @Autowired
    private EDMSEmpService eServ;

    @GetMapping("/code")
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
    @GetMapping("/list")
    public ResponseEntity<List<ApproverInfoDTO>> getEmployeList(){
    	List<ApproverInfoDTO> eList = eServ.getEmployeeList();
    	return ResponseEntity.ok(eList);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApproverInfoDTO> getEmployeeById(@PathVariable("id") int id) {
        ApproverInfoDTO emp = eServ.getEmployeeById(id);
        if (emp != null) {
            return ResponseEntity.ok(emp);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
