package com.kedu.study.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.ScheduleDTO;

@RestController
@RequestMapping("work")
public class attendanceController {
	
	@PostMapping("/checkIn")
	public String checkIn(@RequestBody ScheduleDTO checkInRequest) {

		LocalDateTime checkInTime = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String formattedTime = checkInTime.format(formatter);

		System.out.println("출근 시간: " + formattedTime);

		return "출근 시간을 기록했습니다: " + formattedTime;
	}

	@PostMapping("/checkOut")
	public String checkOut(@RequestBody ScheduleDTO checkOutRequest) {

		LocalDateTime checkOutTime = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String formattedTime = checkOutTime.format(formatter);

		System.out.println("퇴근 시간: " + formattedTime);

		return "퇴근 시간을 기록했습니다: " + formattedTime;
	}

	@PostMapping("/work")
	public String work(@RequestBody ScheduleDTO workRequest) {

		LocalDateTime workTime = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String formattedTime = workTime.format(formatter);

		System.out.println("업무 시간: " + formattedTime);

		return "업무 시간을 기록했습니다: " + formattedTime;
	}

	@PostMapping("/outing")
	public String outing(@RequestBody ScheduleDTO outingRequest) {

		LocalDateTime outingTime = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String formattedTime = outingTime.format(formatter);

		System.out.println("외근 시간: " + formattedTime);

		return "외근 시간을 기록했습니다: " + formattedTime;
	}

}
