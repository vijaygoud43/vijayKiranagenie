package com.mbr.KiranaGenie.data.request;

import java.io.Serializable;

public class RegisterRequestBody implements Serializable {
    String firstname;
    String lastname;
    String email;
    String password;
    String confirm;
    String telephone;
    Boolean agree;
    String session_id;



    public RegisterRequestBody(String firstname, String lastname, String email, String password, String confirm, String telephone,Boolean agree,String session_id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
        this.telephone = telephone;
        this.agree = agree;
        this.session_id=session_id;
    }

    public RegisterRequestBody(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
