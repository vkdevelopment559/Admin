package com.vijayhealth.entity.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class UserDetails {

  private  List<UserDetailEntity>  userDetails;
}
