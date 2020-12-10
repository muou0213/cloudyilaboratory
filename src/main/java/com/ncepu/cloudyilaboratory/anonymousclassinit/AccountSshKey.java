package com.ncepu.cloudyilaboratory.anonymousclassinit;

import lombok.Data;

@Data
public class AccountSshKey {
    private int seq;
    private String sshPublicKey;
    private String encodedKey;
    private String algorithm;
    private String comment;
    private boolean valid;
}
