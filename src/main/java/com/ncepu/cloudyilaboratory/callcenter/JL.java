package com.ncepu.cloudyilaboratory.callcenter;

public class JL extends User {

    public JL() {
        super();
        title =  Title.JL;
    }

    @Override
    public void handleCall() {

    }

    @Override
    public boolean canHandle() {
        return false;
    }
}
