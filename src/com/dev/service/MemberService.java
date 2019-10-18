package com.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.dao.MemberDAO;
import com.dev.vo.MemberVO;
@Service
public class MemberService {

	@Autowired
	public MemberDAO dao;
	
	



	public void memberInsert(MemberVO member) {
		dao.memberInsert(member);
	}

	public MemberVO memberSearch(String id) {
		MemberVO member = dao.memberSearch(id);
		return member;
	}

	public void memberUpdate(MemberVO member) {
		dao.memberUpdate(member);
	}

	public void memberDelete(String id) {
		dao.memberDelete(id);
	}

	public List<MemberVO> memberList() {
		List<MemberVO> list = dao.memberList();
		return list;
	}

}
