package com.kedu.study.controllers.EDMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.EDMSFormDTO;
import com.kedu.study.service.EDMS.EDMSFormService;

@RestController
@RequestMapping("/api/forms")
public class EDMSFormController {
	
	@Autowired
    private EDMSFormService edmsFserv;

    
    @GetMapping
    public ResponseEntity<List<EDMSFormDTO>> getFormList(){
    	List<EDMSFormDTO> flist = edmsFserv.getAllForms();
    	return ResponseEntity.ok(flist);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EDMSFormDTO> getForm(@PathVariable("id") int id) {
        return ResponseEntity.ok(edmsFserv.getFormById(id));
    }
}
