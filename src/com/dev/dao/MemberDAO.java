package com.dev.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.vo.MemberVO;
@Repository
public class MemberDAO {
	@Autowired
	private SqlSession session;

	public void memberInsert(MemberVO member) {
		session.insert("member.insert",member);
	}

	public MemberVO memberSearch(String id) {
		return session.selectOne("member.search",id);
		
	}

	public void memberUpdate(MemberVO member) {
		session.update("member.update",member);

	}

	public void memberDelete(String id) {
		session.delete("member.delete",id);
	}

	public List<MemberVO> memberList() {

		return session.selectList("member.list");
		
	}

}
