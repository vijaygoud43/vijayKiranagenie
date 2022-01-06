package com.mbr.KiranaGenie.Model;

import com.mbr.KiranaGenie.Activities.User;

public class LoginResponseModel {
    private String success,statusCode,message,customer_id,session_id,expires_at,firstname, lastname, email, password, confirm, telephone;

    public LoginResponseModel( String message, String success, String statusCode, String customer_id, String session_id, String expires_at,String firstname, String lastname, String email, String password, String confirm, String telephone) {

        this.message = message;
        this.success = success;
        this.statusCode = statusCode;
        this.customer_id = customer_id;
        this.session_id = session_id;
        this.expires_at = expires_at;

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
        this.telephone = telephone;

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirm() {
        return confirm;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
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

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(String expires_at) {
        this.expires_at = expires_at;
    }

}
