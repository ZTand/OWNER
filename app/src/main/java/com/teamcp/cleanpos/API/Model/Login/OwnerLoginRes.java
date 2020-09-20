package com.teamcp.cleanpos.API.Model.Login;

public class OwnerLoginRes {
    private int code;
    private OwnerLoginMessageRes ownerLoginMessageRes;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public OwnerLoginMessageRes getOwnerLoginMessageRes() {
        return ownerLoginMessageRes;
    }

    public void setOwnerLoginMessageRes(OwnerLoginMessageRes ownerLoginMessageRes) {
        this.ownerLoginMessageRes = ownerLoginMessageRes;
    }
}
