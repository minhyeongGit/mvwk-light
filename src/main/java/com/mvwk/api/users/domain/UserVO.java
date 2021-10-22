package com.mvwk.api.users.domain;

import java.util.Date;

import lombok.Data;

@Data
public class UserVO {
    private String userId;
    private String userPw;
    private String userName;
    private Date userBirth;
    private int userGender;
    private String userMail;
    private String userCellNum;
    private String userMbti;
    private boolean userAdmin;
}
