package com.vijayhealth.controller.user;

import com.vijayhealth.entity.user.UserDetailEntity;
import com.vijayhealth.service.user.UserDetailService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("user")
public class UserDetailsController {

    private final UserDetailService userDetailService;

    public UserDetailsController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    public UserDetailEntity createUserDetail(@RequestBody UserDetailEntity userDetail){
        return userDetailService.createUserDetail(userDetail);
    }
}
