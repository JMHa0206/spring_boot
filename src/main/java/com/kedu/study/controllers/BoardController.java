package com.kedu.study.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.BoardDTO;
import com.kedu.study.service.BoardService;


@RestController
@RequestMapping("/board")
public class BoardController {

	 	@Autowired
	    private BoardService boardService;

	 	
	 	//테이블 전체를 불러오는 부분
	    @GetMapping
	    public ResponseEntity<List<BoardDTO>> getBoardList() {
	    	List<BoardDTO> list= boardService.selectAll();
	        return ResponseEntity.ok(list);
	    }
	    
	    //insert부분
	    @PostMapping("/insert")
		public ResponseEntity<Void> insertBoard(@RequestBody BoardDTO post) {
			boardService.insertBoard(post);
			return ResponseEntity.ok().build();
		}
	    
	    
	    
	    //board_id로 제목이랑 내용불러오는 부분
	    @GetMapping("/{post_id}")
	    public ResponseEntity<BoardDTO> getBoardById(@PathVariable int post_id) {
	    	BoardDTO blist = boardService.getBoardById(post_id);
	    	return ResponseEntity.ok(blist);
	    		
	    }
	    
	    //수정부분
	    @PutMapping("/update")
	    public ResponseEntity<Void> updateBoard(@RequestBody BoardDTO post) {
	        boardService.updateBoard(post); // Service 호출
	        return ResponseEntity.ok().build(); // 성공 응답
	    }
	    
	    //삭제부분
	    @DeleteMapping("/{post_id}")
	    public ResponseEntity<Void> deleteBoard(@PathVariable int post_id){
	    	boardService.deleteBoard(post_id);
	    	return ResponseEntity.ok().build();
	    }
	    
	 // 게시글 조회수 증가
	    @GetMapping("/increaseViewCount/{post_id}")
	    public String increaseViewCount(@PathVariable int post_id) {
	        boardService.increaseViewCount(post_id);  // 서비스에서 조회수 증가
	        return "조회수가 증가했습니다.";
	    }
	    
	    //추천수 증가 
	    @PostMapping("/increaseLikeCount/{post_id}")
	    public String increaseLikeCount(@PathVariable int post_id) {
	    	boardService.increaseLikeCount(post_id);
	    	return "좋아요수가 증가했습니다";
	    }
	    
	    //네비게이터
	    @PostMapping("/navigator")
	    public ResponseEntity<Map<String, Object>> getPagedList(@RequestBody Map<String,Object> request) {
	    	System.out.println(request);
	    	int page = (int)request.get("page");
	    	int size = (int)request.get("size");
	    	int parentBoard = (int)request.get("parent_board");
	    	
	    	
	        int offset = (page - 1) * size;

	        // ✅ 여기! parentBoard를 포함한 버전으로 호출해야 함!
	        List<BoardDTO> list = boardService.getBoardList(offset, size, parentBoard);
	        
	        int totalCount = boardService.getBoardCount(parentBoard);
	        int totalPages = (int) Math.ceil((double) totalCount / size);

	        Map<String, Object> result = new HashMap<>();
	        result.put("list", list);
	        result.put("totalPages", totalPages);

	        return ResponseEntity.ok(result);
	    }
	    
	    
//	    @PostMapping("/increaseLikeCount/{post_Id}")
//	    public ResponseEntity<String> increaseLikeCount(
//	            @PathVariable int post_Id,
//	            @RequestBody LikeRequest likeRequest) {
//	        int userId = likeRequest.getUserId();
//
//	        boolean alreadyLiked = likeService.hasUserLikedPost(userId, post_Id);
//
//	        if (alreadyLiked) {
//	            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already liked");
//	        }
//
//	        likeService.addLike(userId, post_Id); // insert into post_like + update post.like_count
//	        return ResponseEntity.ok("Like added");
//	    }
//	    

}


