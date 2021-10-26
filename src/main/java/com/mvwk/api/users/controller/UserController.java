package com.mvwk.api.users.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvwk.api.users.dao.UserDAO;
import com.mvwk.api.users.domain.UserVO;
import com.mvwk.api.users.service.UserService;

@Controller
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDAO userDAO;
	
	// 초기화면 페이지
	@GetMapping("/")
	public String indexPage() {
		return "/index";
	}

	// 로그인 페이지 이동
	@GetMapping("/login")
	public String loginGet() {
		return "/login";
	}
	
	// 회원가입 페이지 이동
	@GetMapping("/join")
	public String joinPage() {
		return "/join";
	}
	
	// 회원가입 -> 패스워드 암호화 및 DB 인서트
	@PostMapping("/join")
	public String createUser(UserVO userVO) {
		userVO.setUserPw(passwordEncoder.encode(userVO.getUserPw()));
		userService.createUser(userVO);
		return "redirect:/login";
	}
	
    // 로그인 성공시 이동할 페이지
    @RequestMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal User currentUser, Map<String, Object> model,
                               SecurityContextHolderAwareRequestWrapper requestWrapper) {
        log.info("currentUser = " + currentUser);
        String nextPage = null;
        if (currentUser == null) {
            model.put("message", "유효하지 않은 데이터");
            nextPage = "redirect:/denied";
        } else {
            if (requestWrapper.isUserInRole("ADMIN")) {
                nextPage = "redirect:/admin/admin_index";
            } else {
                model.put("currentUserId", currentUser.getUsername());
                nextPage = "redirect:/main";
            }
        }
        return nextPage;
    }
    
    @GetMapping("/main")
    public String mainPage() {
    	return "redirect:/main";
    }
    
    
}
