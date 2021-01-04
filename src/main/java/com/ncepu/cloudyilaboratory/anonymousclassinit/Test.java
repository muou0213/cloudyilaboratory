package com.ncepu.cloudyilaboratory.anonymousclassinit;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

    public AccountSshKey convertToAccountSshKey(UserSshKey userSshKey) {
        return new AccountSshKey() {
            {
                setSeq(userSshKey.getId().intValue());
                setValid(true);
                setAlgorithm(userSshKey.getPublicKeyType());
                setEncodedKey(userSshKey.getPublicKey());
                setComment(userSshKey.getPublicKeyComment());
            }
        };

    }

    public static void main(String[] args) throws JsonProcessingException {
        UserSshKey userSshKey = new UserSshKey();
        userSshKey.setId(1);
        userSshKey.setFullPublicKey("full-public-key");
        userSshKey.setPublicKey("public-key");
        userSshKey.setPublicKeyComment("comment");
        userSshKey.setPublicKeyType("public-key-type");
        userSshKey.setUserName("username");

        Test t = new Test();
        AccountSshKey accountSshKey = t.convertToAccountSshKey(userSshKey);

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(accountSshKey);

        System.out.println(s);
    }
}
