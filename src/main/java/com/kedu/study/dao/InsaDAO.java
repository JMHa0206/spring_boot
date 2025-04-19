package com.kedu.study.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.AbsentDTO;
import com.kedu.study.dto.BirtdaylistDTO;
import com.kedu.study.dto.DepartmentAttendanceDTO;
import com.kedu.study.dto.Departsimple;
import com.kedu.study.dto.LeaveDTO;
import com.kedu.study.dto.OvertimeDTO;
import com.kedu.study.dto.TripDTO;

@Repository
public class InsaDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	private static final String nameSpace = "InsaMapper";

	// 연차
	public Map<String, Object> getAnnualSummary(String userId) {
		return mybatis.selectOne(nameSpace + ".getAnnualSummary", userId);
	}

	// 연속 근속일
	public Map<String, Object> getWeeklyStats(String userId) {
		return mybatis.selectOne(nameSpace + ".getWeeklyStats", userId);
	}

	// 출근 평균
	public String getAvgCheckIn(String userId) {
		return mybatis.selectOne(nameSpace + ".getAvgCheckIn", userId);
	}

	// 퇴근 평균
	public String getAvgCheckOut(String userId) {
		return mybatis.selectOne(nameSpace + ".getAvgCheckOut", userId);
	}

	// 주간 근무
	public int getConsecutiveWorkDays(String userId) {
		Integer result = mybatis.selectOne(nameSpace + ".getConsecutiveWorkDays", userId);
		return result != null ? result : 0;
	}

	public List<TripDTO> getTodayTrips() {
		return mybatis.selectList(nameSpace + ".getTodayTrips");
	}

	public List<LeaveDTO> getTodayLeaves() {
		return mybatis.selectList(nameSpace + ".getTodayLeaves");
	}

	public List<AbsentDTO> getAbsentEmployees() {
		return mybatis.selectList(nameSpace + ".getAbsentEmployees");
	}

	public List<OvertimeDTO> getMonthlyOvertimeList() {
		return mybatis.selectList(nameSpace + ".getMonthlyOvertimeList");
	}
	// 부서 선택
	public List<Departsimple> getAllDepartments(){
		return mybatis.selectList(nameSpace+".getAllDepartments");
	}

	// 부서 출근 출력
	public List<DepartmentAttendanceDTO> getDepartments(int deptId, int offset, int size) {
		Map<String, Object> params = new HashMap<>();
		params.put("deptId", deptId);
		params.put("offset", offset);
		params.put("size", size);
		System.out.println(params+": 파라미터");
		
		return mybatis.selectList(nameSpace+".getDepartments", params);
	}
	// 메인 페이지에서 생일자 뽑기 
	public List<BirtdaylistDTO> getbirtday(){
		return mybatis.selectList(nameSpace+".getbirtday");
	}
	
	public void generateAnnualForAllEmployees() {
	    mybatis.insert(nameSpace+".insertAnnualForAll");
	}


}