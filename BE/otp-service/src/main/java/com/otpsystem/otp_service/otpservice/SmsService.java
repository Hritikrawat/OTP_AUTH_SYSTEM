package com.otpsystem.otp_service.otpservice;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class SmsService {

        @Value("${twilio.sid}")
        private String ACCOUNT_SID;

        @Value("${twilio.token}")
        private String AUTH_TOKEN;

        @Value("${twilio.number}")
        private String TWILIO_NUMBER;

        private Logger log = LoggerFactory.getLogger(SmsService.class);

        public boolean sendOtp(String mobile,String otp) {
            try{
                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                Message message = Message.creator(new com.twilio.type.PhoneNumber("+91"+mobile),
                                new com.twilio.type.PhoneNumber(TWILIO_NUMBER),
                                "Your OTP for verification is "+otp)
                        .create();
                log.info("{} is your OTP SENT TO {}",otp,mobile);
                return true;
//                System.out.println(message.getBody());
            }

            catch(Exception e)
            {
                log.error("Failed to send OTP ",e.getMessage());
                return false;
            }
        }




}
