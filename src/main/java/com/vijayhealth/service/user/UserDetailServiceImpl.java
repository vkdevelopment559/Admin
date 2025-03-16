package com.vijayhealth.service.user;


import com.vijayhealth.entity.user.UserDetailEntity;
import com.vijayhealth.repository.UserDetailRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserDetailServiceImpl implements UserDetailService{

    private final UserDetailRepository userDetailRepository;
    private final EntityManager entityManager;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository, EntityManager entityManager) {
        this.userDetailRepository = userDetailRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public UserDetailEntity createUserDetail(UserDetailEntity userDetail) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        userDetail.setFirstName(userDetail.getLastName());
        userDetail.setLastName(userDetail.getLastName());
        userDetail.setEmail(userDetail.getEmail());
        userDetail.setPassword(userDetail.getPassword());
        userDetail.setAccessToken(userDetail.getAccessToken());
        userDetail.setResPublishedAt(currentDateTime);
        userDetail.setResUpdatedAt(currentDateTime);
        userDetail.setResDeleted(false);
        UserDetailEntity saveUser=userDetailRepository.save(userDetail);
        entityManager.refresh(saveUser);
        return saveUser;
    }
}
