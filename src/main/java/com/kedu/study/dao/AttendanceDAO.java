package com.kedu.study.dao;

import java.sql.Timestamp;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.ActivityDTO;
import com.kedu.study.dto.AttendanceDTO;

@Repository
public class AttendanceDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    private static final String nameSpace = "AttendanceMapper";

    public int checkIn(AttendanceDTO dto) {
        return mybatis.insert(nameSpace + ".checkIn", dto);
    }

    public int checkOut(AttendanceDTO dto) {
        return mybatis.update(nameSpace + ".checkOut", dto);
    }

    public Timestamp getTodayCheckIn(String emp_loginId) {
        return mybatis.selectOne(nameSpace + ".getTodayCheckIn", emp_loginId);
    }
    public Timestamp getTodayCheckOut(String emp_loginId) {
        return mybatis.selectOne(nameSpace + ".getTodayCheckOut", emp_loginId);
    }

    public Integer findTodayAttendanceId(String emp_loginId) {
        return mybatis.selectOne(nameSpace + ".findTodayAttendanceId", emp_loginId);
    }

    public void insertActivity(ActivityDTO dto) {
        mybatis.insert(nameSpace + ".insertActivity", dto);
    }

    public void endLastActivity(int attendance_id) {
        mybatis.update(nameSpace + ".endLastActivity", attendance_id);
    }
}
