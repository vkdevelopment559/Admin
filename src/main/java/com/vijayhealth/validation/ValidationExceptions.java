package com.vijayhealth.validation;

import com.vijayhealth.utill.Enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ValidationExceptions {

    @Getter
    public static class BookException extends RuntimeException{

        private final Enums.Feature feature;

        public BookException(Enums.Feature feature,String message) {
            super(message);
            this.feature = feature;
        }
    }

}
