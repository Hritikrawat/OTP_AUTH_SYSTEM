package com.otp_system.user_service.controllers;

import com.otp_system.user_service.DTO.VerificationReq;
import com.otp_system.user_service.Enitity.Users;
import com.otp_system.user_service.Repository.UsersRepo;
import com.otp_system.user_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/generate")
    public ResponseEntity<?> generateOtp(@RequestParam(name="P_no") String Mno )
    {
        LOGGER.info("Controller received mobile: '{}'", Mno);
        String otp = userService.generateOtp(Mno.replace("/","").trim());
        LOGGER.info("OTP is {}",otp);
        return new ResponseEntity<>(otp, HttpStatus.OK);

    }


    @PostMapping("/verify")
    public void verifyOtp(@RequestBody VerificationReq verificationReq)
    {
        userService.VerifyOtp(verificationReq.getMobile(),verificationReq.getOtp());
    }




//    @PostMapping("/saveNumber")
//    public ResponseEntity<?> saveNumber(@RequestParam(name = "mobile") Users u)
//    {
//        userService.saveUser(mobile);
//    }

    @GetMapping("/allNumbers")
    public ResponseEntity<List<Users>> getNumbers(){
           return userService.getAll();
    }
}
