package com.kedu.study.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
// 스케줄러 라는 것으로 InsaService 에서 generateAnnualLeaveForAllEmployees 를 먼저 실행하기 위해 넣은 코드
@SpringBootApplication
@EnableScheduling
public class YourApplication {
    public static void main(String[] args) {
        SpringApplication.run(YourApplication.class, args);
    }
}