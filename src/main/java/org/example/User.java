/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.example;

public class User {
    private String name;
    private String surName;
    private String email;
    private String phoNo;
    private String passWord;

public User (){

}
    public User(String name, String surName, String email, String phoNo, String passWord) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.phoNo = phoNo;
        this.passWord = passWord;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoNo(String phoNo) {
        this.phoNo = phoNo;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoNo() {
        return phoNo;
    }

    public String getPassWord() {
        return passWord;
    }
}
