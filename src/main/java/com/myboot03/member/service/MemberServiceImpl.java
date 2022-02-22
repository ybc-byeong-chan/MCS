package com.myboot03.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myboot03.member.dao.MemberDAO;
import com.myboot03.member.vo.MemberVO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;


	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMemberList();
		return membersList;
	}

	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		return memberDAO.insertMember(memberVO);
	}

	@Override
	public int removeMember(String id) throws DataAccessException {
		return memberDAO.deleteMember(id);
	}
	
	@Override
	public int mod(MemberVO memberVO) throws DataAccessException {
		return memberDAO.updateMember(memberVO);
	}

	@Override
	public MemberVO selectMemberById(String id) throws DataAccessException {
		return memberDAO.selectMemberById(id);
	}

	@Override
	public MemberVO login(MemberVO memberVO) throws DataAccessException{
		return memberDAO.loginById(memberVO);
	}
	
}
