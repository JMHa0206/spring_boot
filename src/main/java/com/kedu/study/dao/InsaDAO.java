package com.kedu.study.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsaDAO {
    // 주간 출근일수, 총 근무 시간, 초과 근무 시간
    Map<String, Object> getWeeklyStats(String userId);

//    // 평균 출근 시간
//    String getAvgCheckIn(String userId);
//
//    // 평균 퇴근 시간
//    String getAvgCheckOut(String userId);
    String getAvgCheckIn(String userId);   // 출근 시간
    String getAvgCheckOut(String userId);  // 퇴근 시간


    // 연속 근무 일수
    int getConsecutiveWorkDays(String userId);

    // 연차 요약 정보
    Map<String, Object> getAnnualSummary(String userId);
}
