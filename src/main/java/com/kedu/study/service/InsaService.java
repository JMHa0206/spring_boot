package com.kedu.study.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.InsaDAO;
import com.kedu.study.dto.AbsentDTO;
import com.kedu.study.dto.AdminSummaryDTO;
import com.kedu.study.dto.LeaveDTO;
import com.kedu.study.dto.TripDTO;
import com.kedu.study.dto.WorkSummaryDTO;

@Service
public class InsaService {

	@Autowired
	private InsaDAO IDao;

	public WorkSummaryDTO getWeeklySummary(String userId) {
		WorkSummaryDTO dto = new WorkSummaryDTO();

		// 주간 근무 현황
		Map<String, Object> stats = IDao.getWeeklyStats(userId);
		if (stats != null) {
			dto.setWeeklyWorkedDays(((Number) stats.getOrDefault("WORKED_DAYS", 0)).intValue());
			dto.setWeeklyWorkHours(((Number) stats.getOrDefault("TOTAL_HOURS", 0)).doubleValue());
			dto.setTotalOvertime(((Number) stats.getOrDefault("OVERTIME_HOURS", 0)).doubleValue());
		}

		// 평균 출퇴근
		dto.setAverageCheckIn(IDao.getAvgCheckIn(userId));
		dto.setAverageCheckOut(IDao.getAvgCheckOut(userId));

		// 연속 근무
		dto.setConsecutiveDays(IDao.getConsecutiveWorkDays(userId));

		// 연차
		Map<String, Object> annual = IDao.getAnnualSummary(userId);
		if (annual != null) {
		    dto.setTotalAnnual(((Number) annual.getOrDefault("totalAnnual", 0)).intValue());
		    dto.setUsedAnnual(((Number) annual.getOrDefault("usedAnnual", 0)).intValue());
		    dto.setRemainingAnnual(((Number) annual.getOrDefault("remainingAnnual", 0)).intValue());
		    dto.setExpiringThisYear(((Number) annual.getOrDefault("expiringThisYear", 0)).intValue());
		}


		return dto;
	}

	public AdminSummaryDTO getAdminSummary() {
		AdminSummaryDTO dto = new AdminSummaryDTO();

		List<TripDTO> trips = IDao.getTodayTrips();
		List<LeaveDTO> leaves = IDao.getTodayLeaves(); // 추후 구현 or dummy
		List<AbsentDTO> absents = IDao.getAbsentEmployees();

		dto.setPersonalBusinessTrips(trips);
		dto.setDepartmentLeaves(leaves);
		dto.setNotCheckedInToday(absents);

		return dto;
	}

}
