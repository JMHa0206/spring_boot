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
    
    public int checkIn(AttendanceDTO attendancedto) {
        int result = mybatis.insert(nameSpace + ".checkIn", attendancedto);

        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setAttendance_id(attendancedto.getAttendance_id()); // attendance_id 가져오기
        activityDTO.setActivity_type("출근");
        activityDTO.setStart_time(attendancedto.getCheck_in_time()); // 출근 시간
        activityDTO.setEnd_time(attendancedto.getCheck_in_time()); // 출근 시 end_time 설정 불필요

        // 활동 시간을 따로 설정하지 않더라도 insertActivity에 바로 넘겨줍니다.
        activityDTO.setActivity_hours(0.0); // 출근 활동은 활동 시간이 0

        if (result > 0) {
            mybatis.insert(nameSpace + ".insertActivity", activityDTO); // 출근 활동 등록
        }

        return result;
    }
    
    public Timestamp getTodayCheckIn(String emp_loginId) {
        return mybatis.selectOne(nameSpace + ".getTodayCheckIn", emp_loginId);
    }
    public Integer findTodayAttendanceId(String emp_loginId) {
		return mybatis.selectOne(nameSpace+".findTodayAttendanceId", emp_loginId);
	}



    
    public int checkOut(AttendanceDTO attendancedto) {
        // 퇴근 기록 업데이트
        int result = mybatis.update(nameSpace + ".checkOut", attendancedto);

        // 퇴근 활동 등록 (근무 시간 및 퇴근 시간 기록)
        if (result > 0) {
            ActivityDTO activityDTO = new ActivityDTO();
            activityDTO.setAttendance_id(attendancedto.getAttendance_id()); // 해당 attendance_id
            activityDTO.setActivity_type("퇴근");
            activityDTO.setStart_time(attendancedto.getCheck_in_time());  // 출근 시간
            activityDTO.setEnd_time(attendancedto.getCheck_out_time());  // 퇴근 시간
            activityDTO.setActivity_hours(attendancedto.getWork_hours()); // 활동 시간 (근무 시간)

            // 퇴근 활동 기록
            mybatis.insert(nameSpace + ".updatetActivity", activityDTO);
        }

        return result;
    }
    
    public int outing(ActivityDTO activitydto) {
    	return mybatis.insert(nameSpace+".outing", activitydto);
    }
    public int work(ActivityDTO activitydto) {
    	return mybatis.insert(nameSpace+".work", activitydto);
    }

}
