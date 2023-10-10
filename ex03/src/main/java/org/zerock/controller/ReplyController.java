package org.zerock.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@AllArgsConstructor
@RequestMapping("/replies/")
public class ReplyController {
	
	private ReplyService service;
	
	@PostMapping(value="/new", 
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> urlNew(@RequestBody ReplyVO vo) {		
		log.info("등록해야할 댓글정보:"+vo);
		int count=service.register(vo);
		if(count==1) {
			//댓글이 등록되면 success 문자를 보내고 상태는 200(정상)
			return new ResponseEntity<>("success",HttpStatus.OK);
		}else {
		//실패하면 아무것도 안보내고 500에러
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//HttpStatus.BAD_REQUEST 400에러
		//HttpStatus.UNSUPPORTED_MEDIA_TYPE 415에러
	}
	
	//ex  /replies/7
	@DeleteMapping(value="/{rno}",produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> urlDelete(@PathVariable("rno")Long rno) {
		int count=service.remove(rno);
		if(count==1) {
			//삭제성공 success 문자를 보내고 상태는 200(정상)
			return new ResponseEntity<>("success",HttpStatus.OK);
		}else {
			//삭제 실패하면 아무것도 안보내고 500에러 (418)
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}		
	}
	
	@PutMapping("/{rno}") //수정
	public ResponseEntity<String> urlPut(@PathVariable("rno") Long rno, @RequestBody ReplyVO vo) {
		vo.setRno(rno);
		return service.modify(vo)==1
				? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);	
	}
	
	//ex  /replies/pages/100
	@GetMapping(value="/pages/{bno}")
	public List<ReplyVO> urlList(@PathVariable("bno")Long bno){
		return service.getList(bno);
	}
	
	@GetMapping("/{rno}")
	public ReplyVO get(@PathVariable("rno") Long rno) {
		return service.get(rno);
	}
	
	@GetMapping("/{bno}")
	public ReplyVO count(@PathVariable("bno") Long bno) {
		return service.get(bno);
	}

	

}
