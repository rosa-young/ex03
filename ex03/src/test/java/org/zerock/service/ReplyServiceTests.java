package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;
import org.zerock.mapper.ReplyerMapperTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {
	
	@Autowired
	private ReplyService service;
	
	@Test
	public void allInOne() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(100L);
		vo.setReply("서비스테스트");
		vo.setReplyer("young");
		service.register(vo);
		
		vo.setRno(3L);
		vo.setReply("서비스테스트1");
		vo.setReplyer("young1");
		service.modify(vo);
		
		service.getList(100L).forEach(x->log.info(x));
		
		service.remove(7L);
		
		
	}

}
