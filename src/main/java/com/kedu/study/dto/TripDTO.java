package com.kedu.study.dto;
	// 외근 했냐?
public class TripDTO {
	private String empName;   // 직원 이름
    private String tripDate;      // 출장 날짜
    private String location;  // 출장 장소 (지금은 '출장지'라고 하드코딩됨)
    
    public TripDTO() {}
    
	public TripDTO(String empName, String tripDate, String location) {
		super();
		this.empName = empName;
		this.tripDate = tripDate;
		this.location = location;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDate() {
		return tripDate;
	}
	public void setDate(String tripDate) {
		this.tripDate = tripDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
