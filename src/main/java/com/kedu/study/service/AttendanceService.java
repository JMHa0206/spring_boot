package com.kedu.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kedu.study.dao.AttendanceDAO;
import com.kedu.study.dto.AttendanceDTO;

import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceDAO ADao;

    public int checkIn(AttendanceDTO attendancedto) {
        LocalDateTime checkInTime = attendancedto.getCheck_in_time().toLocalDateTime();

        double workHours = 0;
        double overtimeHours = 0; 


        attendancedto.setWork_hours(workHours);
        attendancedto.setOvertime_hours(overtimeHours);

        return ADao.checkIn(attendancedto);
    }

    public int checkOut(AttendanceDTO attendancedto) {
        // 출근 시간이 null인 경우 처리
        if (attendancedto.getCheck_in_time() == null) {
            throw new IllegalArgumentException("출근 시간이 기록되지 않았습니다.");
        }

        // 퇴근 시간이 null인 경우 현재 시간을 퇴근 시간으로 설정
        if (attendancedto.getCheck_out_time() == null) {
            attendancedto.setCheck_out_time(Timestamp.valueOf(LocalDateTime.now()));  // 현재 시간을 퇴근 시간으로 설정
        }

        // 출근 시간과 퇴근 시간 변환
        LocalDateTime checkInTime = attendancedto.getCheck_in_time().toLocalDateTime();
        LocalDateTime checkOutTime = attendancedto.getCheck_out_time().toLocalDateTime();

        // 근무 시간 계산 (분 단위 차이)
        long workMinutes = ChronoUnit.MINUTES.between(checkInTime, checkOutTime);
        double workHours = workMinutes / 60.0;

        // 초과 근무 시간 계산
        double overtimeHours = 0;
        if (workHours > 8) {
            overtimeHours = workHours - 8;
        }

        // DTO에 계산된 근무 시간 및 초과 근무 시간 세팅
        attendancedto.setWork_hours(workHours);
        attendancedto.setOvertime_hours(overtimeHours);

        // DB에 퇴근 시간 및 근무 시간 업데이트
        return ADao.checkOut(attendancedto);
    }

}
