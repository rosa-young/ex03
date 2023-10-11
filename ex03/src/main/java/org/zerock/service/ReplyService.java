package org.zerock.service;

import java.util.List;

import org.zerock.domain.ReplyVO;

public interface ReplyService {
	
	//댓글등록
		int register(ReplyVO vo);
	//해당글에 대한 댓글보기
		List<ReplyVO> getList(Long bno);
	//댓글삭제
		int remove(Long rno);
	//댓글수정
		int modify(ReplyVO vo);
	//댓글 한개 보기
		ReplyVO get(Long rno); //get /replies/2
	//댓글달린 글 개수
	    Long bnoCount();
	//리플이 가장 많은 글번호
		Long rCount();
	//오늘 리플 개수
		Long todayCount();
	//오늘 리플
		List<ReplyVO> todayReply();

		
	
	

}
