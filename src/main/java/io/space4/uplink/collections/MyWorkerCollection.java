package io.space4.uplink.collections;

import io.space4.uplink.interfaces.MyWorker;
import io.space4.uplink.collections.MySpecialWorker;

import java.util.ArrayList;

public class MyWorkerCollection {

    private ArrayList <MyWorker> workers = new ArrayList<MyWorker>();

    public boolean addWorker(MyWorker worker)
    {
        return workers.add(worker);
    }

    public <T extends MySpecialWorker> boolean  addSpecialWorker (T  worker)
    {
        return workers.add(worker);
    }

    public boolean doSomeWork()
    {

        boolean retValue = false;

        for(MyWorker worker: workers)
        {
            retValue = worker.doStuff();
        }

        return retValue;
    }

}

