package com.mbr.KiranaGenie.Model;

public class RegisterResponseModel {

    private String success,statusCode,message;

    public RegisterResponseModel(String success, String statusCode, String message) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
