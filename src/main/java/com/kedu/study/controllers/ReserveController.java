package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.RescTypeDTO;
import com.kedu.study.dto.ReserveDTO;
import com.kedu.study.dto.ResourceDTO;
import com.kedu.study.service.ReserveService;



@RestController
@RequestMapping("/reserve")
public class ReserveController {
	@Autowired
	private ReserveService rServ;
	
	@GetMapping("/resourceType")
	public ResponseEntity<List<RescTypeDTO>> getResources(){
		List<RescTypeDTO> list = rServ.getResources();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/resources")
	public ResponseEntity<List<ResourceDTO>> resourceList(){
		List<ResourceDTO> list = rServ.resourceList();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/addReserve")
	public ResponseEntity<?> addReserve(@RequestBody ReserveDTO reservation){
		if (rServ.isOverlapping(reservation)) {
		    return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 해당 시간대에 예약이 존재합니다.");
		}
		rServ.addReserve(reservation);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/reservations")
	public ResponseEntity<List<ReserveDTO>> getAllResv(){
		
		List<ReserveDTO> list = rServ.getAllResv();
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		rServ.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/myResv/{id}")
	public ResponseEntity<List<ReserveDTO>> getMyResv(@PathVariable int id){
		List<ReserveDTO> list = rServ.getMyResv(id);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/getEmpName/{empId}")
	public ResponseEntity<String> getEmpName(@PathVariable int empId){
		String empName = rServ.getEmpName(empId);
		return ResponseEntity.ok(empName);
	}
	
	@GetMapping("/getDetail/{resvId}")
	public ResponseEntity<ReserveDTO> getDetail(@PathVariable int resvId){
		System.out.println(resvId);
		ReserveDTO resvDetail = rServ.getDetail(resvId);
		System.out.println("날짜 : " + resvDetail.getResv_date() + " 시작 : " + resvDetail.getResv_stime() + " 시작 : " + resvDetail.getResv_etime());
		return ResponseEntity.ok(resvDetail);
	}
	
}
