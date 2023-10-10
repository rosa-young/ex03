package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.ReplyVO;


public interface ReplyMapper {
	//1.쓰고
	int insert(ReplyVO vo);
	//2.읽고
	List<ReplyVO> getList(Long bno);
	//3.수정하고
	int update(ReplyVO vo);
	//4.지우고
	int delete(Long rno);
	
	//댓글 한줄 보기
	ReplyVO get(Long rno);
	
	//리플이 달린 글갯수
	Long bnoCount();
	//리플이 가장 많은 글번호
	Long rCount();

}
