package com.vijayhealth.utill;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Enums {

    @Getter
   @RequiredArgsConstructor
   public enum Feature{
       Book("Book"),User("User");
        private final String message;
   }


}
