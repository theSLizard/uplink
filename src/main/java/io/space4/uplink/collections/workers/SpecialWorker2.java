package io.space4.uplink.collections.workers;

import io.space4.uplink.collections.MySpecialWorker;

public class SpecialWorker2 extends MySpecialWorker {

    @Override
    protected final void doSomeSpecialStuff()
    {
        System.out.println("::: >> I am the *SpecialWorker-2* and I am doing some special stuff !!");
    }
}
