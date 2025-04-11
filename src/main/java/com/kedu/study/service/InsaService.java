package com.kedu.study.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.InsaDAO;
import com.kedu.study.dto.WorkSummaryDTO;

@Service
public class InsaService {
    
    @Autowired
    private InsaDAO IDao;
    
    public WorkSummaryDTO getWeeklySummary(String userId) {
        WorkSummaryDTO dto = new WorkSummaryDTO();
        System.out.println("1");
        // 출근한 날 수, 총 근무 시간, 초과 근무 시간 (null-safe)
        Map<String, Object> workStats = IDao.getWeeklyStats(userId);
        if (workStats != null) {
            dto.setWeeklyWorkedDays(
                workStats.get("worked_days") != null ? (int) workStats.get("worked_days") : 0
            );
            dto.setWeeklyWorkHours(
                workStats.get("total_hours") != null ? (double) workStats.get("total_hours") : 0.0
            );
            dto.setTotalOvertime(
                workStats.get("overtime_hours") != null ? (double) workStats.get("overtime_hours") : 0.0
            );
        } else {
            dto.setWeeklyWorkedDays(0);
            dto.setWeeklyWorkHours(0.0);
            dto.setTotalOvertime(0.0);
        }

        // 평균 출근/퇴근 시간
        String avgIn = IDao.getAvgCheckIn(userId);
        String avgOut = IDao.getAvgCheckOut(userId);
        dto.setAverageCheckIn(avgIn != null ? avgIn : "-");
        dto.setAverageCheckOut(avgOut != null ? avgOut : "-");

        // 연속 근무 일수
        Integer consecutive = IDao.getConsecutiveWorkDays(userId);
        dto.setConsecutiveDays(consecutive != null ? consecutive : 0);

        // 연차 요약 정보 (null-safe)
        Map<String, Object> annual = IDao.getAnnualSummary(userId);
        if (annual != null) {
            dto.setTotalAnnual(
                annual.get("total") != null ? (int) annual.get("total") : 0
            );
            dto.setUsedAnnual(
                annual.get("used") != null ? (int) annual.get("used") : 0
            );
            dto.setRemainingAnnual(
                annual.get("remaining") != null ? (int) annual.get("remaining") : 0
            );
            dto.setExpiringThisYear(
                annual.get("expiring") != null ? (int) annual.get("expiring") : 0
            );
        } else {
            dto.setTotalAnnual(0);
            dto.setUsedAnnual(0);
            dto.setRemainingAnnual(0);
            dto.setExpiringThisYear(0);
        }

        return dto;
    }
}
