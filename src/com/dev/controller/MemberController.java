package com.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	//회원가입 서비스 처리 controller
	
	@RequestMapping("memberInsert.do")
	public String insert(MemberVO member, Model model){ //다음페이지로 가기전 데이터저장(스프링)
		service.memberInsert(member);
		model.addAttribute("id",member.getId());
		return "memberInsertOutput";
	 
	
	}
	/*public String insert(MemberVO member, HttpServletRequest req){ //다음페이지로 가기전 데이터저장(표준)
		service.memberInsert(member);
		req.setAttribute("id",member.getId());
		return "memberInsertOutput";
		
		
	}*/
	@RequestMapping("memberList.do")
	public String list(Model model){
		List<MemberVO> list = service.memberList();
		model.addAttribute("list",list);
		return "memberListOutput";
	}
	
	@RequestMapping("updateInput.do")
	public String updateInput(){
		return "memberUpdate";
		
	}

	@RequestMapping("deleteInput.do")
	public String deleteInput(){
		return "memberDelete";
		
	}
	
	@RequestMapping("searchInput.do")
	public String searchInput(){
		return "memberSearch";
		
	}
	@RequestMapping("memberSearch.do")
	public String memberSearch(String id, String job, RedirectAttributes ra){
		MemberVO member = service.memberSearch(id);
		ra.addFlashAttribute("member", member);
		String path = null;
		if(job.equals("search")){
			path="redirect:searchInput.do";
		}
		else if(job.equals("delete")){
			path="redirect:/deleteInput.do";
		}
		else if(job.equals("update")){
			path="redirect:/updateInput.do";
		}
		
		return path;
	}
	@RequestMapping("memberUpdate.do")
	public String memberUpdate(MemberVO member, Model model){
		service.memberUpdate(member);
		model.addAttribute("id",member.getId());
		return "memberUpdateOutput";
		
		
	}
	@RequestMapping("memberDelete.do")
	public String memberDelete(String id){
		service.memberDelete(id);
		return "memberDeleteOutput";
		
	}
	
	
}
