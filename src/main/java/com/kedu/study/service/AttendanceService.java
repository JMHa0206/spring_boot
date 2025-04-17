package com.kedu.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kedu.study.dao.AttendanceDAO;
import com.kedu.study.dto.ActivityDTO;
import com.kedu.study.dto.AttendanceDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceDAO ADao;

    public Timestamp getTodayCheckIn(String userId) {
        return ADao.getTodayCheckIn(userId);
    }

    public Timestamp getTodayCheckOut(String userId) {
        return ADao.getTodayCheckOut(userId);
    }

    public int checkIn(AttendanceDTO attendancedto) {
        LocalDateTime checkInTime = LocalDateTime.now().withNano(0);
        attendancedto.setCheck_in_time(Timestamp.valueOf(checkInTime));
        attendancedto.setRecord_date(Timestamp.valueOf(checkInTime));
        attendancedto.setWork_hours(0.0);
        attendancedto.setOvertime_hours(0.0);

        int result = ADao.checkIn(attendancedto);

        // ✅ 출근 activity 기록
        ActivityDTO activity = new ActivityDTO();
        activity.setAttendance_id(attendancedto.getAttendance_id());
        activity.setActivity_type("출근");
        activity.setStart_time(attendancedto.getCheck_in_time());
        activity.setEnd_time(null);
        activity.setActivity_hours(0.0);
        ADao.insertActivity(activity);

        return result;
    }

    public int checkOut(AttendanceDTO attendancedto) {
        // 출근 기록 가져오기
        Timestamp checkInTimestamp = ADao.getTodayCheckIn(attendancedto.getEmp_loginId());
        if (checkInTimestamp == null) {
            throw new IllegalArgumentException("출근 기록이 없습니다.");
        }

        attendancedto.setCheck_in_time(checkInTimestamp);
        attendancedto.setCheck_out_time(Timestamp.valueOf(LocalDateTime.now().withNano(0)));
        attendancedto.setRecord_date(Timestamp.valueOf(LocalDateTime.now()));

        LocalDateTime checkInTime = checkInTimestamp.toLocalDateTime();
        LocalDateTime checkOutTime = attendancedto.getCheck_out_time().toLocalDateTime();

        long workMinutes = ChronoUnit.MINUTES.between(checkInTime, checkOutTime);
        double workHours = workMinutes / 60.0;
        double overtimeHours = workHours > 8 ? workHours - 8 : 0;

        attendancedto.setWork_hours(workHours);
        attendancedto.setOvertime_hours(overtimeHours);

        int result = ADao.checkOut(attendancedto);

        // ✅ 출근 ID 다시 조회
        Integer attendanceId = ADao.findTodayAttendanceId(attendancedto.getEmp_loginId());

        // ✅ 퇴근 activity 기록
        ActivityDTO activity = new ActivityDTO();
        activity.setAttendance_id(attendanceId);
        activity.setActivity_type("퇴근");
        activity.setStart_time(attendancedto.getCheck_out_time());
        activity.setEnd_time(attendancedto.getCheck_out_time());
        activity.setActivity_hours(0.0);
        ADao.insertActivity(activity);

        if (result > 0) {
            System.out.println("퇴근 기록과 근무 시간이 DB에 성공적으로 업데이트되었습니다.");
        } else {
            System.out.println("퇴근 기록 업데이트 실패");
        }

        return result;
    }

    public Integer findTodayAttendanceId(String userId) {
        return ADao.findTodayAttendanceId(userId);
    }

    public void handleActivityChange(ActivityDTO dto) {
        // 외근 또는 업무인 경우에만 이전 활동 종료
        if ("외근".equals(dto.getActivity_type()) || "업무".equals(dto.getActivity_type())) {
            ADao.endLastActivity(dto.getAttendance_id());
        }

        // 새 활동은 end_time 없이 시작
        dto.setEnd_time(null);
        dto.setActivity_hours(0.0);
        ADao.insertActivity(dto);
    }
}
