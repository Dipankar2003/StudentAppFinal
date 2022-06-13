package com.example.studentapp;

public class Model {
    private String Logo,UserName,Email;

    public Model(String logo, String userName, String email) {
        Logo = logo;
        UserName = userName;
        Email = email;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

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


//    private String header;
//    private String desc;
//    private  int imgname;
//
//    public String getHeader() {
//        return header;
//    }
//
//    public void setHeader(String header) {
//        this.header = header;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
//    public int getImgname() {
//        return imgname;
//    }
//
//    public void setImgname(int imgname) {
//        this.imgname = imgname;
//    }
}
