package org.zerock.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/**")
@AllArgsConstructor
public class BoardController {
	
	BoardService service; //생성자 주입
	ReplyService replyService;
	
	@GetMapping("/list") //전체 목록 board/list (get)
	public void list(Model model,Criteria cri) {
		log.info("list url 요청..");
		model.addAttribute("list", service.getList(cri)); //글목록
		model.addAttribute("pageMaker", new PageDTO(cri, service.count(cri))); //페이지바 정보
		model.addAttribute("now", service.now());
		model.addAttribute("bnoCount", replyService.bnoCount());
		model.addAttribute("rCount", replyService.rCount());
		// ->board/list/jsp
		
	}
	
	//등록(작성글-BoardVO) board/reguster (post)  <-입력화면(get)
	@PostMapping("/register")
	public String register(BoardVO vo,RedirectAttributes rttr) {
		log.info("===========register url post 요청"+vo);
		service.register(vo);
		rttr.addFlashAttribute("oper","create");
		rttr.addFlashAttribute("result",vo.getBno()); //why? 데이터(작성글번호) 한번만 전송.(새로고침 도배방지)
		return "redirect:/board/list"; //why? redirect가 없으면 jsp이고,
		                               //redirect가 있으면 요청.		
	}
	
	@GetMapping("/register")
	
		public void register() {
		
	}
	
	@GetMapping("/remove")//비번 화면 요청
	public void remove(Long bno, Model model) {
		model.addAttribute("bno",bno);
	}
	
	@GetMapping("/modify")
	public void modify(Long bno, Model model, Criteria cri) {
		model.addAttribute("board",service.get(bno));
		model.addAttribute("cri", cri);
	}
	
	
		
	//조회(글번호-bno) board.get (get)
	@GetMapping("/get")
	public void get(Long bno, Model model,Criteria cri) {
		log.info("글상세보기 url요청");
		model.addAttribute("board",service.get(bno));
		model.addAttribute("cri", cri);
		// ->board/get.jsp
	}	
	
	//삭제(글번호-bon) board/remove (post)  <-입력화면(get)
	@PostMapping("/remove")
	public String remove(Long bno,RedirectAttributes rttr, Criteria cri,String pw) {
		log.info("삭제 url요청");
		log.info("입력된 패스워드:"+pw);
		if(pw.equals("1234")) {		
			if(service.remove(bno)) {//이상없으면 result 이름으로 success전송.
				rttr.addFlashAttribute("oper","remove");
				rttr.addFlashAttribute("result", bno);			
		}
		return "redirect:/board/list";
	}else {
		rttr.addFlashAttribute("flag","fail");
		return "redirect:/board/remove?bno="+bno;
	} 
	
	}


		
	//수정(수정글-BoardVO) board/modify (post)  <-입력화면(get)
	@PostMapping("/modify")
	public String modify(BoardVO vo,RedirectAttributes rttr, Criteria cri) {
		log.info("글수정 url요청");
			
			if(service.modify(vo)) {
				rttr.addFlashAttribute("oper","modify");
				rttr.addFlashAttribute("result",vo.getBno());
		}
		return "redirect:/board/list?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount();
	}
	
	//좋아요 처리
	@GetMapping("/good")
	public String good(Long bno) {
		service.good(bno);	
		return "redirect:/board/list";
	}
	
	@PostMapping("/board/newsearch/{page}/{amount}")
	public List<BoardVO> getList(@PathVariable("page") int page,
			@PathVariable("amount") int amount, @RequestBody Criteria cri){
		
		cri.setAmount(amount);
		cri.setPageNum(page);
		return service.getList(cri);
	} 

	@GetMapping("/newsearch")
	public void newSearch() {
		
	}
	
	@GetMapping("/newReply")
	public void newReply() {
		
	}
	
	@GetMapping("/bestboard")
	public void bestboard() {
		
	}
	
	
	
	


}
