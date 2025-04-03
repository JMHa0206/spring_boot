package com.kedu.study.controllers.EDMS;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.EDMSFormDTO;
import com.kedu.study.service.EDMS.EDMSFormService;

@RestController
@RequestMapping("/api/forms")
public class EDMSFormController {

    private final EDMSFormService edmsFormService;

    public EDMSFormController(EDMSFormService edmsFormService) {
        this.edmsFormService = edmsFormService;
    }

    @GetMapping
    public List<EDMSFormDTO> getAllForms() {
        return edmsFormService.getAllForms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EDMSFormDTO> getForm(@PathVariable("id") int id) {
        return ResponseEntity.ok(edmsFormService.getFormById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createForm(@RequestBody EDMSFormDTO form) {
        edmsFormService.createForm(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateForm(@RequestBody EDMSFormDTO form) {
        edmsFormService.updateForm(form);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForm(@PathVariable("id") int id) {
        edmsFormService.deleteForm(id);
        return ResponseEntity.ok().build();
    }
}
