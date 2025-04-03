package com.kedu.study.dao;

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
        activityDTO.setAttendance_id(attendancedto.getAttendance_id()); // 여기서 attendance_id를 가져옴	인데 왜 안되냐고 시ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ.
        activityDTO.setActivity_type("출근");
        activityDTO.setStart_time(attendancedto.getCheck_in_time());
        activityDTO.setEnd_time(attendancedto.getCheck_in_time());
        activityDTO.setActivity_hours(0.0);

        if (result > 0) {
            mybatis.insert(nameSpace + ".insertActivity", activityDTO);
        }
        
        return result;
    }

    
    public int checkOut(AttendanceDTO attendancedto) {
        int result = mybatis.update(nameSpace + ".checkOut", attendancedto);
        if (result > 0) {
            mybatis.insert(nameSpace + ".updatetActivity", attendancedto);
        }
        return result;
    }
}
