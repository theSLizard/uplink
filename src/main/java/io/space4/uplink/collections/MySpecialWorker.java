package io.space4.uplink.collections;

import io.space4.uplink.interfaces.MyWorker;

public class MySpecialWorker implements MyWorker {

    protected void doSomeSpecialStuff()
    {
        System.out.println("::: >> I am the *MySpecialWorker* and I am doing some special stuff !!");
    }
    @Override
    public boolean doStuff() {
        this.doSomeSpecialStuff();
        return true;
    }
}
