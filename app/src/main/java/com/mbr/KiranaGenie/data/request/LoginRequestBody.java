package com.mbr.KiranaGenie.data.request;

import java.io.Serializable;

public class LoginRequestBody implements Serializable {
    String email;
    String password;

    public LoginRequestBody(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
