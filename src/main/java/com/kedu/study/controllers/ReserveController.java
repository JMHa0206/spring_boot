package com.kedu.study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.service.ReserveService;

@RestController
@RequestMapping("/reserve")
public class ReserveController {
	@Autowired
	private ReserveService rServ;
	
	@PostMapping("/addReserve")
	public ResponseEntity<?> addReserve(@RequestBody resvInput){
		
	}
}
