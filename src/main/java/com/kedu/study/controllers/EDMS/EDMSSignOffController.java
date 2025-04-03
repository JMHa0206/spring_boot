package com.kedu.study.controllers.EDMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.kedu.study.dto.EDMSSignOffDTO;
import com.kedu.study.service.EDMS.EDMSSignOffService;

@RestController
@RequestMapping("/api/signoff")
public class EDMSSignOffController {

    private final EDMSSignOffService edmssignOffService;

    @Autowired
    public EDMSSignOffController(EDMSSignOffService edmssignOffService) {
        this.edmssignOffService = edmssignOffService;
    }

    @GetMapping
    public ResponseEntity<List<EDMSSignOffDTO>> getAllSignOffs() {
        return ResponseEntity.ok(edmssignOffService.getAllSignOffs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EDMSSignOffDTO> getSignOff(@PathVariable("id") int id) {
        return ResponseEntity.ok(edmssignOffService.getSignOffById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createSignOff(@RequestBody EDMSSignOffDTO signOff) {
        edmssignOffService.createSignOff(signOff);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateSignOff(@RequestBody EDMSSignOffDTO signOff) {
        edmssignOffService.updateSignOff(signOff);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSignOff(@PathVariable("id") int id) {
        edmssignOffService.deleteSignOff(id);
        return ResponseEntity.ok().build();
    }
}
