package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.DepartDTO;
import com.kedu.study.dto.EmployeeDTO;
import com.kedu.study.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService eServ;
	
	@GetMapping("/selectAllEmps")
	public ResponseEntity<List<EmployeeDTO>> selectAllEmps(){
		List<EmployeeDTO> empList = eServ.selectAllEmps();
		return ResponseEntity.ok(empList);
	}
	
	@GetMapping("/selectAllDepts")
	public ResponseEntity<List<DepartDTO>> selectAllDepts(){
		List<DepartDTO> deptList = eServ.selectAllDepts();
		return ResponseEntity.ok(deptList);
	}

}
