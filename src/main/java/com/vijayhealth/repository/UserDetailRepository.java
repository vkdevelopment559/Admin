package com.vijayhealth.repository;

import com.vijayhealth.entity.user.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailEntity,Integer> {

    @Query("SELECT ce FROM UserDetailEntity ce WHERE ce.resDeleted = false AND ce.resId = :resId AND ce.resId NOT IN (SELECT ce2.resId FROM UserDetailEntity ce2 WHERE ce2.resDeleted = true ORDER BY ce2.resDeletedAt, ce2.resUpdatedAt DESC) AND (ce.resId, ce.resUpdatedAt) IN (SELECT ce3.resId, MAX(ce3.resUpdatedAt) AS maxUpdatedAt FROM UserDetailEntity ce3 WHERE ce3.resDeleted = false GROUP BY ce3.resId) ORDER BY ce.resUpdatedAt DESC")
    Optional<UserDetailEntity> findByResId(Long resId);

    @Query("SELECT ce FROM UserDetailEntity ce WHERE ce.resDeleted = false AND ce.resId NOT IN (SELECT ce2.resId FROM UserDetailEntity ce2 WHERE ce2.resDeleted = true ORDER BY ce2.resDeletedAt, ce2.resUpdatedAt DESC) AND (ce.resId, ce.resUpdatedAt) IN (SELECT ce3.resId, MAX(ce3.resUpdatedAt) AS maxUpdatedAt FROM UserDetailEntity ce3 WHERE ce3.resDeleted = false GROUP BY ce3.resId) ORDER BY ce.resUpdatedAt DESC")
    List<UserDetailEntity> findAllUserDetails();
}
