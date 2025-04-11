package com.kedu.study.dto;

public class WorkSummaryDTO {
	private int weeklyWorkedDays;	// 출근한 날 수
    private double weeklyWorkHours;	
    private String averageCheckIn;
    private String averageCheckOut;
    private int consecutiveDays;
    private int totalAnnual;
    private int usedAnnual;
    private int remainingAnnual;
    private int expiringThisYear;
    private double totalOvertime;
    
    public WorkSummaryDTO() {}
    
	public WorkSummaryDTO(int weeklyWorkedDays, double weeklyWorkHours, String averageCheckIn, String averageCheckOut,
			int consecutiveDays, int totalAnnual, int usedAnnual, int remainingAnnual, int expiringThisYear,
			double totalOvertime) {
		super();
		this.weeklyWorkedDays = weeklyWorkedDays;
		this.weeklyWorkHours = weeklyWorkHours;
		this.averageCheckIn = averageCheckIn;
		this.averageCheckOut = averageCheckOut;
		this.consecutiveDays = consecutiveDays;
		this.totalAnnual = totalAnnual;
		this.usedAnnual = usedAnnual;
		this.remainingAnnual = remainingAnnual;
		this.expiringThisYear = expiringThisYear;
		this.totalOvertime = totalOvertime;
	}
	
	public int getWeeklyWorkedDays() {
		return weeklyWorkedDays;
	}
	public void setWeeklyWorkedDays(int weeklyWorkedDays) {
		this.weeklyWorkedDays = weeklyWorkedDays;
	}
	public double getWeeklyWorkHours() {
		return weeklyWorkHours;
	}
	public void setWeeklyWorkHours(double weeklyWorkHours) {
		this.weeklyWorkHours = weeklyWorkHours;
	}
	public String getAverageCheckIn() {
		return averageCheckIn;
	}
	public void setAverageCheckIn(String averageCheckIn) {
		this.averageCheckIn = averageCheckIn;
	}
	public String getAverageCheckOut() {
		return averageCheckOut;
	}
	public void setAverageCheckOut(String averageCheckOut) {
		this.averageCheckOut = averageCheckOut;
	}
	public int getConsecutiveDays() {
		return consecutiveDays;
	}
	public void setConsecutiveDays(int consecutiveDays) {
		this.consecutiveDays = consecutiveDays;
	}
	public int getTotalAnnual() {
		return totalAnnual;
	}
	public void setTotalAnnual(int totalAnnual) {
		this.totalAnnual = totalAnnual;
	}
	public int getUsedAnnual() {
		return usedAnnual;
	}
	public void setUsedAnnual(int usedAnnual) {
		this.usedAnnual = usedAnnual;
	}
	public int getRemainingAnnual() {
		return remainingAnnual;
	}
	public void setRemainingAnnual(int remainingAnnual) {
		this.remainingAnnual = remainingAnnual;
	}
	public int getExpiringThisYear() {
		return expiringThisYear;
	}
	public void setExpiringThisYear(int expiringThisYear) {
		this.expiringThisYear = expiringThisYear;
	}
	public double getTotalOvertime() {
		return totalOvertime;
	}
	public void setTotalOvertime(double totalOvertime) {
		this.totalOvertime = totalOvertime;
	}
    
}
