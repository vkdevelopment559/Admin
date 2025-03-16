package com.vijayhealth.service.user;


import com.vijayhealth.entity.user.UserDetailEntity;
import com.vijayhealth.helper.PasswordEncryption;
import com.vijayhealth.helper.RandomIdGenerator;
import com.vijayhealth.repository.UserDetailRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;

@Service
public class UserDetailServiceImpl implements UserDetailService{

    private final UserDetailRepository userDetailRepository;
    private final EntityManager entityManager;
    private final SecretKey secretKey;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository, EntityManager entityManager, RandomIdGenerator randomDigitGenerator, SecretKey secretKey) {
        this.userDetailRepository = userDetailRepository;
        this.entityManager = entityManager;
        this.secretKey = secretKey;
    }

    @Override
    @Transactional
    public UserDetailEntity createUserDetail(UserDetailEntity userDetail) throws Exception {
        LocalDateTime currentDateTime = LocalDateTime.now();
        userDetail.setFirstName(userDetail.getLastName());
        userDetail.setLastName(userDetail.getLastName());
        userDetail.setEmail(userDetail.getEmail());
        userDetail.setPassword(PasswordEncryption.encrypt(userDetail.getPassword(),secretKey));
        userDetail.setAccessToken(RandomIdGenerator.RandomDigitGenerator());
        userDetail.setResPublishedAt(currentDateTime);
        userDetail.setResUpdatedAt(currentDateTime);
        userDetail.setResDeleted(false);
        UserDetailEntity saveUser=userDetailRepository.save(userDetail);
        entityManager.refresh(saveUser);
        return saveUser;
    }
}
