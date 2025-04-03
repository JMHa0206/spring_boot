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

import com.kedu.study.dto.EDMSFileDTO;
import com.kedu.study.service.EDMS.EDMSFileService;

@RestController
@RequestMapping("/api/files")
public class EDMSFileController {

    private final EDMSFileService edmsFileService;

    @Autowired
    public EDMSFileController(EDMSFileService edmsFileService) {
        this.edmsFileService = edmsFileService;
    }

    @GetMapping
    public ResponseEntity<List<EDMSFileDTO>> getAllFiles() {
        return ResponseEntity.ok(edmsFileService.getAllFiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EDMSFileDTO> getFile(@PathVariable("id") int id) {
        return ResponseEntity.ok(edmsFileService.getFileById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createFile(@RequestBody EDMSFileDTO file) {
        edmsFileService.createFile(file);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateFile(@RequestBody EDMSFileDTO file) {
        edmsFileService.updateFile(file);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable("id") int id) {
        edmsFileService.deleteFile(id);
        return ResponseEntity.ok().build();
    }
}