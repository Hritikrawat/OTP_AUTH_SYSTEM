package com.otpsystem.otp_service.otpRepo;

import com.otpsystem.otp_service.Entity.OTPs;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OtpRepo extends MongoRepository<OTPs,String>
{
    Optional<OTPs> findByMobile(String mobile);
}
