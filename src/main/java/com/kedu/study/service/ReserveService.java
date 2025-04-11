package com.kedu.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.ReserveDAO;

@Service
public class ReserveService {
	@Autowired
	private ReserveDAO rDao;

}
