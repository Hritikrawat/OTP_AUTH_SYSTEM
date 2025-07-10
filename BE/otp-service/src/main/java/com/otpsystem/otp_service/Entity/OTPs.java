package com.otpsystem.otp_service.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Document(collection = "otps")
public class OTPs {


    private String tempId;

    private String mobile;

    private String otp;

    @Indexed(expireAfter = "10s" )
    private Date createdAt;

//    public void populateCreatedAt(){
//        this.createdAt = Date.from(Instant.now());
//    }

    public OTPs(){}
    public OTPs(String tempId, String mobile, String otp, Date createdAt) {
        this.tempId = tempId;
        this.mobile = mobile;
        this.otp = otp;
        this.createdAt = createdAt;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "OTPs{" +
                "tempId='" + tempId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", otp='" + otp + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
