package com.kedu.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.BoardFileDAO;
import com.kedu.study.dto.BoardFileDTO;

@Service
public class BoardFileService {
	@Autowired
    private BoardFileDAO boardFileDAO;

    // 파일을 DB에 저장
    public void insertBoardFile(BoardFileDTO boardFileDTO) {
        boardFileDAO.insertBoardFile(boardFileDTO);
    }
}
아....정말...하기...싫다......ㅎ