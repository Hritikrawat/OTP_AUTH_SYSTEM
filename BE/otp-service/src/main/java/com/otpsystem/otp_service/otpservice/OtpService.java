package com.otpsystem.otp_service.otpservice;

import com.otpsystem.otp_service.DTO.VerifyReq;
import com.otpsystem.otp_service.Entity.OTPs;
import com.otpsystem.otp_service.otpRepo.OtpRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.http.HttpHeaders;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class OtpService {

    private static final Logger log = LoggerFactory.getLogger(OtpService.class);
    @Autowired
    private OtpRepo otpRepo;


    public String generateOtp(String mobile)
    {
//        String otp = (new Random().nextInt(899999)+10).toString();     //cant use toString to primitive types

        log.info("GENERATING OTP AND TEMP ID");
        String otp = String.valueOf(new Random().nextInt(899999) + 10);
        String tempId = (UUID.randomUUID()).toString();

        //mongo saves date as date
//        Date d = new Date();
        OTPs data = new OTPs();
        data.setTempId(tempId);
        data.setOtp(otp);
        data.setMobile(mobile);
        data.setCreatedAt(new Date());

        //logging date just for checking
        ZonedDateTime logTime = data.getCreatedAt().toInstant().atZone(ZoneId.of("Asia/Kolkata"));
        log.info("created at {}",logTime);

        otpRepo.save(data);
        log.info("Otp details are saved");
        return otp;
    }

    public boolean verifyOtp(VerifyReq vf)
    {
//        String validate ="";
        OTPs otp = otpRepo.findByMobile(vf.getMobile()).orElse(new OTPs());
        log.info("Docuemnt is {}",otp);
        return vf.getOtp().equals(otp.getOtp())?true:false;

    }

}
