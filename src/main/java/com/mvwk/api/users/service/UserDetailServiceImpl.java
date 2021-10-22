package com.mvwk.api.users.service;

import java.util.HashSet;
import java.util.Set;

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

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserVO userVo = userDao.findUser(username);
		
        User currentUser = null;
        if (userVo != null) {

            Set<GrantedAuthority> grantedAuthorities = new HashSet<>(2);

            grantedAuthorities.add(new SimpleGrantedAuthority(
            		userVo.isUserAdmin() ? UserRole.ADMIN.getValue() : UserRole.MEMBER.getValue()));
            System.out.println(userVo.getUserId());
            currentUser = new User(userVo.getUserId(), userVo.getUserPw(), grantedAuthorities);
        }

        return currentUser;
	}
}
