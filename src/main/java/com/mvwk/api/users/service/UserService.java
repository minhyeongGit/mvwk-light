package com.mvwk.api.users.service;

import java.util.List;

import com.mvwk.api.users.domain.UserVO;

public interface UserService {
	
	// 회원 등록
	void createUser(UserVO userVO);
	
    // 회원 삭제
    void deleteUser(String userId);

    // 회원 조회
    UserVO getUser(String userId);

    // 회원정보 수정 메소드
    void updateUser(UserVO user);

    // 아이디 찾기 메소드
    UserVO findId(String userName, String userMail);

    // 비밀번호 찾기 메소드
    UserVO findPw(String userId, String userName, String userMail);

    // 회원 전체 조회
    List<UserVO> getAllUser();
}
