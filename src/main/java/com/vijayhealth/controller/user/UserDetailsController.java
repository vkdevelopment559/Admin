package com.vijayhealth.controller.user;

import com.vijayhealth.entity.Delete.DeleteResponse;
import com.vijayhealth.entity.user.UserDetailEntity;
import com.vijayhealth.entity.user.UserDetails;
import com.vijayhealth.service.user.UserDetailService;
import com.vijayhealth.validation.ValidateFeatures;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserDetailsController {

    private final UserDetailService userDetailService;
    private final ValidateFeatures validateFeatures;

    public UserDetailsController(UserDetailService userDetailService, ValidateFeatures validateFeatures) {
        this.userDetailService = userDetailService;
        this.validateFeatures = validateFeatures;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUserDetail(@Valid @RequestBody UserDetailEntity userDetail,BindingResult bindingResult) throws Exception {
        ResponseEntity<?> validateResponse = validateFeatures.validateFeatures(bindingResult);
        return validateResponse != null ? validateResponse : ResponseEntity.ok(userDetailService.createUserDetail(userDetail));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserDetail(@Valid @RequestBody UserDetailEntity userDetail, BindingResult bindingResult) throws Exception {
        ResponseEntity<?> validationResponse =validateFeatures.validateFeatures(bindingResult);
        return validationResponse !=null ? validationResponse : ResponseEntity.ok(userDetailService.updateUserDetail(userDetail));
    }

    @GetMapping("/fetch/{resId}")
    public Optional<UserDetailEntity> FetchUserDetailByResId(@PathVariable Long resId){
     return userDetailService.FetchUserDetailByResId(resId);
    }

    @GetMapping("/fetch")
    public UserDetails FetchAllUserDetail(){
        return userDetailService.FetchUserDetail();
    }

    @DeleteMapping("/delete/{resId}")
    public DeleteResponse deleteUserDetailByResId(@PathVariable Long resId){
        return userDetailService.deleteUserDetailByResId(resId);
    }


}
