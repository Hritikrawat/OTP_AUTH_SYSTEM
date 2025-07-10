package com.otpsystem.otp_service.DTO;

public class VerifyReq {
    String mobile;
    String otp;
    VerifyReq(){}
    public VerifyReq(String mobile, String otp) {
        this.mobile = mobile;
        this.otp = otp;
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
}
