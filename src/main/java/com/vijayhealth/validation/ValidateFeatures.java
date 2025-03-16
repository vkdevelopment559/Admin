package com.vijayhealth.validation;

import com.vijayhealth.utill.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ValidateFeatures {

    public ResponseEntity<?> validateFeatures(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            List<String> fieldNames = new ArrayList<>();
            for (ObjectError error : errors) {
                fieldNames.add(((FieldError) error).getField());
            }
            String errorMessage = Constants.field + String.join(Constants.comma_operator, fieldNames) + Constants.missing;
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put(Constants.error, Constants.mandatory_field);
            errorResponse.put(Constants.message, errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        return null;
    }
}
