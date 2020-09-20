package com.teamcp.cleanpos;

import com.google.gson.annotations.SerializedName;

public class Count {
    @SerializedName("userId")
    private String userId;
    @SerializedName("userPwd")
    private String userPwd;
    @SerializedName("userEmail")
    private String userEmail;
    @SerializedName("userName")
    private String userName;
    @SerializedName("userBirthY")
    private String userBirthY;
    @SerializedName("userBirthM")
    private String userBirthM;
    @SerializedName("userBirthD")
    private String userBirthD;
    @SerializedName("phoneNum")
    private String phoneNum;
    @SerializedName("address")
    private String address;
    @SerializedName("userNickname")
    private String userNickname;
    @SerializedName("userGender")
    private String userGender;

    public Count() {
    }

    public Count(String userId,
                 String userPwd,
                 String userEmail,
                 String userName,
                 String userBirthY,
                 String userBirthM,
                 String userBirthD,
                 String phoneNum,
                 String address,
                 String userNickname,
                 String userGender) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userBirthY = userBirthY;
        this.userBirthM = userBirthM;
        this.userBirthD = userBirthD;
        this.phoneNum = phoneNum;
        this.address = address;
        this.userNickname = userNickname;
        this.userGender = userGender;
    }

    @Override
    public String toString() {
        return "Count{" +
                "userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userBirthY='" + userBirthY + '\'' +
                ", userBirthM='" + userBirthM + '\'' +
                ", userBirthD='" + userBirthD + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userGender='" + userGender + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBirthY() {
        return userBirthY;
    }

    public void setUserBirthY(String userBirthY) {
        this.userBirthY = userBirthY;
    }

    public String getUserBirthM() {
        return userBirthM;
    }

    public void setUserBirthM(String userBirthM) {
        this.userBirthM = userBirthM;
    }

    public String getUserBirthD() {
        return userBirthD;
    }

    public void setUserBirthD(String userBirthD) {
        this.userBirthD = userBirthD;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
}
