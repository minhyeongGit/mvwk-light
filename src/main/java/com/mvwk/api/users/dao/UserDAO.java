package com.mvwk.api.users.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mvwk.api.users.domain.UserVO;

@Mapper
public interface UserDAO {
	
	UserVO findUser(@Param("userId") String userId);
	
}
