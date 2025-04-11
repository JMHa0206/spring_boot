package com.kedu.study.service;

import java.util.List;

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
    
    public List<BoardFileDTO> getFilesByPostId(int postId) {
        return boardFileDAO.selectFilesByPostId(postId);
    }
    public void deleteFileById(int fileId) {
        boardFileDAO.deleteFileById(fileId);  // DAO 호출
    }
    
}
