package com.example.studentapp;

public class Allclub {

    String UserName;
    String Email;
    public  Allclub(){}

    public Allclub(String userName, String email, String logo) {
        UserName = userName;
        Email = email;
        Logo = logo;
    }

    String Logo;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }
}
