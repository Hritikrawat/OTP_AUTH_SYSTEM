package com.otp_system.user_service.service;

import com.otp_system.user_service.DTO.VerificationReq;
import com.otp_system.user_service.Enitity.Users;
import com.otp_system.user_service.Exception.UserNotFoundException;
import com.otp_system.user_service.Repository.UsersRepo;
import org.apache.juli.logging.Log;
import org.bson.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UsersRepo usersRepo;

//    public UserService(UsersRepo usersRepo) {
//        this.usersRepo = usersRepo;
//    }


    public String generateOtp(String Mno) {
        LOGGER.info("Searching for user with mobile: {}", Mno);

        LOGGER.info("Mno: [{}]", Mno);
//        LOGGER.info("Trimmed Mno: [{}]", Mno.trim());

        System.out.println(Mno);

        //This line is is hcekcing if the number is registered (in db or not if not then no otp willl be shared)
//        Users user = usersRepo.findByMobile(Mno)
//              .orElseThrow(()-> new UserNotFoundException(Mno));


        LOGGER.info("Calling OTP service");

        String url = "http://localhost:8081/otp/generate?mobile=" + Mno;
        RestTemplate r = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<>(null);

        ResponseEntity<String> res = r.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        return res.getBody();

    }


    public ResponseEntity<List<Users>> getAll() {
        List<Users> ls = usersRepo.findAll();
        if (ls.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(ls);
    }

    public String VerifyOtp(String mobile, String otp) {

        VerificationReq verifyReq = new VerificationReq(mobile, otp);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<VerificationReq> httpEntity = new HttpEntity<>(verifyReq, headers);


        String url = "http://localhost/8081/otp/verifyOtp";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> res = restTemplate.exchange(
                url,
                HttpMethod.POST,
                httpEntity,
                String.class
        );
        return res.getBody();

    }

//
}
