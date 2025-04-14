package com.kedu.study.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.AbsentDTO;
import com.kedu.study.dto.LeaveDTO;
import com.kedu.study.dto.TripDTO;

@Repository
public class InsaDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	private static final String nameSpace = "InsaMapper";

	//연차
	public Map<String, Object> getAnnualSummary(String userId) {
		return mybatis.selectOne(nameSpace + ".getAnnualSummary", userId);
	}

	//연속 근속일
	public Map<String, Object> getWeeklyStats(String userId) {
		return mybatis.selectOne(nameSpace + ".getWeeklyStats", userId);
	}

	//출근 평균
	public String getAvgCheckIn(String userId) {
		return mybatis.selectOne(nameSpace + ".getAvgCheckIn", userId);
	}

	//퇴근 평균
	public String getAvgCheckOut(String userId) {
		return mybatis.selectOne(nameSpace + ".getAvgCheckOut", userId);
	}

	//주간 근무
	public int getConsecutiveWorkDays(String userId) {
		Integer result = mybatis.selectOne(nameSpace + ".getConsecutiveWorkDays", userId);
		return result != null ? result : 0;
	}
	
	public List<TripDTO> getTodayTrips() {
	    return mybatis.selectList(nameSpace+".getTodayTrips");
	}

	public List<LeaveDTO> getTodayLeaves() {
	    return mybatis.selectList(nameSpace+".getTodayLeaves");
	}

	public List<AbsentDTO> getAbsentEmployees() {
	    return mybatis.selectList(nameSpace+".getAbsentEmployees");
	}
	

}