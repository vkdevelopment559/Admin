package com.vijayhealth.service.user;

import com.vijayhealth.entity.Delete.DeleteResponse;
import com.vijayhealth.entity.user.UserDetailEntity;
import com.vijayhealth.entity.user.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailService {
    UserDetailEntity createUserDetail(UserDetailEntity userDetail) throws Exception;

    Optional<UserDetailEntity> FetchUserDetailByResId(Long resId);

    DeleteResponse deleteUserDetailByResId(Long resId);
    UserDetailEntity updateUserDetail(UserDetailEntity userDetailEntity) throws Exception;

    UserDetails FetchUserDetail();
}
