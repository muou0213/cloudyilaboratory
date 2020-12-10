package com.ncepu.cloudyilaboratory.callcenter;

public class J extends User {

    public J() {
        super();
        title =  Title.J;
    }

    @Override
    public void handleCall() {

    }

    @Override
    public boolean canHandle() {
        return false;
    }
}
