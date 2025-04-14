package com.kedu.study.dto;

import java.util.List;
	// 조휘영 인사과 전용 페이지 모음집
public class AdminSummaryDTO {
	private List<TripDTO> personalBusinessTrips;
    private List<LeaveDTO> departmentLeaves;
    private List<AbsentDTO> notCheckedInToday;
    
    public AdminSummaryDTO() {}
    
	public AdminSummaryDTO(List<TripDTO> personalBusinessTrips, List<LeaveDTO> departmentLeaves,
			List<AbsentDTO> notCheckedInToday) {
		super();
		this.personalBusinessTrips = personalBusinessTrips;
		this.departmentLeaves = departmentLeaves;
		this.notCheckedInToday = notCheckedInToday;
	}
	public List<TripDTO> getPersonalBusinessTrips() {
		return personalBusinessTrips;
	}
	public void setPersonalBusinessTrips(List<TripDTO> personalBusinessTrips) {
		this.personalBusinessTrips = personalBusinessTrips;
	}
	public List<LeaveDTO> getDepartmentLeaves() {
		return departmentLeaves;
	}
	public void setDepartmentLeaves(List<LeaveDTO> departmentLeaves) {
		this.departmentLeaves = departmentLeaves;
	}
	public List<AbsentDTO> getNotCheckedInToday() {
		return notCheckedInToday;
	}
	public void setNotCheckedInToday(List<AbsentDTO> notCheckedInToday) {
		this.notCheckedInToday = notCheckedInToday;
	}
}
