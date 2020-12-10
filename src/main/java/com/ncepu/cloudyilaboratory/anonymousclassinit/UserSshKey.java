package com.ncepu.cloudyilaboratory.anonymousclassinit;

import lombok.Data;

@Data
public class UserSshKey {
    private Integer id;

    private String userName;

    private String publicKeyType;

    private String publicKey;

    private String publicKeyComment;

    private String fullPublicKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPublicKeyType() {
        return publicKeyType;
    }

    public void setPublicKeyType(String publicKeyType) {
        this.publicKeyType = publicKeyType;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPublicKeyComment() {
        return publicKeyComment;
    }

    public void setPublicKeyComment(String publicKeyComment) {
        this.publicKeyComment = publicKeyComment;
    }

    public String getFullPublicKey() {
        return fullPublicKey;
    }

    public void setFullPublicKey(String fullPublicKey) {
        this.fullPublicKey = fullPublicKey;
    }
}
