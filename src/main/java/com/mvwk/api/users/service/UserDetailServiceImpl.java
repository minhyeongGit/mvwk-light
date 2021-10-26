package com.mvwk.api.users.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mvwk.api.users.dao.UserDAO;
import com.mvwk.api.users.domain.UserVO;
import com.mvwk.api.users.util.UserRole;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info("## loadUserByUsername ##");
		
		UserVO userVo = userDao.getUser(username);
		
        User currentUser = null;
        if (userVo != null) {

            Set<GrantedAuthority> grantedAuthorities = new HashSet<>(2);

            grantedAuthorities.add(new SimpleGrantedAuthority(
            		userVo.isUserAdmin() ? UserRole.ADMIN.getValue() : UserRole.MEMBER.getValue()));
            currentUser = new User(userVo.getUserId(), userVo.getUserPw(), grantedAuthorities);
        }

        return currentUser;
	}
}
