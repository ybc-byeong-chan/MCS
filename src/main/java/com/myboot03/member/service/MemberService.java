package com.myboot03.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myboot03.member.vo.MemberVO;

public interface MemberService {
	public List listMembers() throws DataAccessException;

	int addMember(MemberVO memberVO) throws DataAccessException;

	int removeMember(String id) throws DataAccessException;

	public int mod(MemberVO memberVO)throws DataAccessException;

	public MemberVO selectMemberById(String id) throws DataAccessException;

	public MemberVO login(MemberVO memberVO) throws DataAccessException;
}
