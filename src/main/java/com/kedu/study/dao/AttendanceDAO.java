package com.kedu.study.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.AttendanceDTO;


@Repository
public class AttendanceDAO {
    @Autowired
    private SqlSessionTemplate mybatis;
    
    private static final String nameSpace = "AttendanceMapper";
    
    public int checkIn(AttendanceDTO attendancedto) {
        int result = mybatis.insert(nameSpace + ".checkIn", attendancedto);
        if (result > 0) {
            mybatis.insert(nameSpace + ".insertActivity", attendancedto);
        }
        return result;
    }
}
