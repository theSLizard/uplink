package io.space4.uplink.interfaces;

@FunctionalInterface
public interface MyFunctionalInterface {

    public boolean myMethod(MyWorker worker);

    //default boolean defaultMethod(MyWorker worker) {
    //    return worker.doStuff();
    //}

}

