package com.kedu.study.dao.EDMS;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.EDMSCategoryDTO;

@Repository
public class EDMSCategoryDAO {
	
	@Autowired
    private SqlSession mybatis;

    private static final String NAMESPACE = "EDMSCategory";

    public List<EDMSCategoryDTO> findAllCategories() {
        return mybatis.selectList(NAMESPACE + ".findAllCategories");
    }

    public EDMSCategoryDTO findCategoryById(int categoryId) {
        return mybatis.selectOne(NAMESPACE + ".findCategoryById", categoryId);
    }

    public void insertCategory(EDMSCategoryDTO category) {
    	mybatis.insert(NAMESPACE + ".insertCategory", category);
    }

    public void updateCategory(EDMSCategoryDTO category) {
    	mybatis.update(NAMESPACE + ".updateCategory", category);
    }

    public void deleteCategory(int categoryId) {
    	mybatis.delete(NAMESPACE + ".deleteCategory", categoryId);
    }
}

