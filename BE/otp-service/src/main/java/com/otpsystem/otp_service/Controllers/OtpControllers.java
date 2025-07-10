package com.otpsystem.otp_service.Controllers;

import com.otpsystem.otp_service.DTO.VerifyReq;
import com.otpsystem.otp_service.otpservice.OtpService;
import com.otpsystem.otp_service.otpservice.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
public class OtpControllers {


    private static  final Logger log = LoggerFactory.getLogger(OtpService.class);
    @Autowired
    private OtpService otpService;

    @Autowired
    private SmsService smsService;


    @PostMapping("/generate")
//    public void generateOtp(@RequestParam("mobile") String mobile)
    public String generateOtp(@RequestParam String mobile)
    {
            //Generating OTP
            String otp = otpService.generateOtp(mobile);
            log.info("Otp generated {}",otp);

            //sending the otp to mobile
            boolean b = smsService.sendOtp(mobile,otp);
            if(b)
            {
                return "OTP has been Sent to "+mobile.substring(0,5)+"XXXX";
            }
            return "Failed to send OTP";
    }
    @PostMapping("/verifyOtp")
    public String verifyOtp(@RequestBody VerifyReq vf)
    {
        boolean valid = otpService.verifyOtp(vf);
        return valid?"Verified":"Wrong OTP";
    }



}
