package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyerMapperTests {
	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testInsert() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(100L);
		vo.setReply("댓글테스트");
		vo.setReplyer("영");
		mapper.insert(vo);
	}
	
	@Test
	public void testUpdate() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(3L);
		vo.setReply("수정댓글테스트");
		mapper.update(vo);
	}
	
	@Test
	public void testDelete() {
		ReplyVO vo = new ReplyVO();
		mapper.delete(4L);
	}
	
	@Test
	public void testList() {
		mapper.getList(100L).forEach(x->log.info(x));
	}

	@Test
	public void testGet() {
		mapper.get(1L);
	}
	
	
}
