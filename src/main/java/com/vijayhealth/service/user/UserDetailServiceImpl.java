package com.vijayhealth.service.user;


import com.vijayhealth.entity.Delete.DeleteResponse;
import com.vijayhealth.entity.user.UserDetailEntity;
import com.vijayhealth.entity.user.UserDetails;
import com.vijayhealth.helper.PasswordEncryption;
import com.vijayhealth.helper.RandomIdGenerator;
import com.vijayhealth.repository.UserDetailRepository;
import com.vijayhealth.utill.Constants;
import com.vijayhealth.utill.Enums;
import com.vijayhealth.validation.ValidationExceptions;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        userDetail.setFirstName(userDetail.getFirstName());
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

    @Override
    public Optional<UserDetailEntity> FetchUserDetailByResId(Long resId) {
        return userDetailRepository.findByResId(resId);
    }

    @Override
    public DeleteResponse deleteUserDetailByResId(Long resId) {
        Optional<UserDetailEntity> existingUser = userDetailRepository.findByResId(resId);
        if (existingUser.isEmpty()){
         throw  new ValidationExceptions.BookException(Enums.Feature.Book,resId.toString());
        }
        LocalDateTime currentDatetime = LocalDateTime.now();
        UserDetailEntity deleteUserDetail = new UserDetailEntity();
        BeanUtils.copyProperties(existingUser.get(),deleteUserDetail);
        deleteUserDetail.setId(null);
        deleteUserDetail.setResPublishedAt(existingUser.get().getResPublishedAt());
        deleteUserDetail.setResUpdatedAt(currentDatetime);
        deleteUserDetail.setResDeletedAt(currentDatetime);
        deleteUserDetail.setResDeleted(true);
        deleteUserDetail.setResId(existingUser.get().getResId());
        userDetailRepository.save(deleteUserDetail);
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setMessage(Constants.deleteResponse(Enums.Feature.Book,resId.toString()));
        deleteResponse.setStatus(Constants.SUCCESSFULLY_DELETED);
        return deleteResponse;
    }

    @Override
    public UserDetailEntity updateUserDetail(UserDetailEntity userDetailEntity) throws Exception {
        Optional<UserDetailEntity> existingUser = userDetailRepository.findByResId(userDetailEntity.getResId());
        if (existingUser.isEmpty()){
            throw  new ValidationExceptions.BookException(Enums.Feature.Book,userDetailEntity.getResId().toString());
        }
        LocalDateTime currentDatetime = LocalDateTime.now();
        UserDetailEntity updateUser = new UserDetailEntity();
        BeanUtils.copyProperties(existingUser.get(),updateUser);
        updateUser.setId(null);
        updateUser.setFirstName(updateUser.getFirstName());
        updateUser.setLastName(userDetailEntity.getLastName());
        updateUser.setEmail(userDetailEntity.getEmail());
        updateUser.setPassword(PasswordEncryption.encrypt(userDetailEntity.getPassword(),secretKey));
        updateUser.setAccessToken(updateUser.getAccessToken());
        updateUser.setResPublishedAt(existingUser.get().getResPublishedAt());
        updateUser.setResUpdatedAt(currentDatetime);
        updateUser.setResDeleted(false);
        updateUser.setResId(existingUser.get().getResId());
       return userDetailRepository.save(updateUser);
    }

    @Override
    public UserDetails FetchUserDetail() {
        UserDetails details = new UserDetails();
         details.setUserDetails(userDetailRepository.findAllUserDetails());
       return details;
    }

}
