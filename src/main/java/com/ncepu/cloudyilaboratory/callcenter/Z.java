package com.ncepu.cloudyilaboratory.callcenter;

public class Z extends User {

    public Z() {
        super();
        title =  Title.Z;
    }

    @Override
    public void handleCall() {

    }

    @Override
    public boolean canHandle() {
        return false;
    }
}
