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

import com.kedu.study.dto.EDMSCategoryDTO;
import com.kedu.study.service.EDMS.EDMSCategoryService;

@RestController
@RequestMapping("/api/category")
public class EDMSCategoryController {

    @Autowired
    private EDMSCategoryService edmsCategoryService;

    @GetMapping
    public ResponseEntity<List<EDMSCategoryDTO>> getAllCategories() {
        List<EDMSCategoryDTO> result = edmsCategoryService.getAllCategories();
        System.out.println("🔍 categories loaded: " + result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EDMSCategoryDTO> getCategory(@PathVariable("id") int id) {
        return ResponseEntity.ok(edmsCategoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestBody EDMSCategoryDTO category) {
        edmsCategoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateCategory(@RequestBody EDMSCategoryDTO category) {
        edmsCategoryService.updateCategory(category);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") int id) {
        edmsCategoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}

