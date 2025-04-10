package com.kedu.study.service.EDMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.EDMS.EDMSCategoryDAO;
import com.kedu.study.dto.EDMSCategoryDTO;

@Service
public class EDMSCategoryService {

	@Autowired
    private EDMSCategoryDAO edmsCategoryDAO;

    public List<EDMSCategoryDTO> getAllCategories() {
        return edmsCategoryDAO.findAllCategories();
    }

    public EDMSCategoryDTO getCategoryById(int categoryId) {
        return edmsCategoryDAO.findCategoryById(categoryId);
    }

    public void createCategory(EDMSCategoryDTO category) {
        edmsCategoryDAO.insertCategory(category);
    }

    public void updateCategory(EDMSCategoryDTO category) {
        edmsCategoryDAO.updateCategory(category);
    }

    public void deleteCategory(int categoryId) {
        edmsCategoryDAO.deleteCategory(categoryId);
    }
}

