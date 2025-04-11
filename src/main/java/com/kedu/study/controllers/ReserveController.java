package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.RescTypeDTO;
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
}
