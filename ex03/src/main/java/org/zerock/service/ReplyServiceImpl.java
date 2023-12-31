package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper mapper;

	@Override
	public int register(ReplyVO vo) {
		return mapper.insert(vo);
	}

	@Override
	public List<ReplyVO> getList(Long bno) {
		return mapper.getList(bno);
	}

	@Override
	public int remove(Long rno) {
		
		return mapper.delete(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		
		return mapper.update(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		
		return mapper.get(rno);
	}

	@Override
	public Long bnoCount() {
		return mapper.bnoCount();
	}

	@Override
	public Long rCount() {
		return mapper.rCount();
	}

	@Override
	public Long todayCount() {
		return mapper.todayCount();
	}

	@Override
	public List<ReplyVO> todayReply() {
		return mapper.todayReply();
	}


}
