package com.mvwk.api.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvwk.api.users.dao.UserDAO;
import com.mvwk.api.users.domain.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	// 회원가입
	@Override
	public void createUser(UserVO userVO) {
		userDAO.createUser(userVO);
	}
	
	// 회원탈퇴
	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}
	
	// 회원 정보 수정
	@Override
	public void updateUser(UserVO user) {
		// TODO Auto-generated method stub
		
	}
	
	// 아이디 찾기
	@Override
	public UserVO findId(String userName, String userMail) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 비밀번호 찾기
	@Override
	public UserVO findPw(String userId, String userName, String userMail) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 전체회원 리스트
	@Override
	public List<UserVO> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 회원정보 가져오기
	@Override
	public UserVO getUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
