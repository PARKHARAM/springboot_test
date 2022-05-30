package com.example.demo.vo;

import lombok.Data;

import java.util.Collection;
import java.util.Collections;

@Data
public class UserVo{
    private int userNo;
    private String userId;
    private String userPw;
    private String userName;
    private String userAuth;
    private String appendDate;
    private String updateDate;
}
