package com.vijayhealth.repository;

import com.vijayhealth.entity.user.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailEntity,Integer> {
}
