package io.space4.uplink.pods;

import configuration.UplinkConfigs;
import io.space4.uplink.collections.MyWorkerCollection;
import io.space4.uplink.collections.workers.SpecialWorker1;
import io.space4.uplink.collections.workers.SpecialWorker2;
import io.space4.uplink.configuration.BootParams;
import io.space4.uplink.events.publishers.RestEndpointEventPublisher;
import io.space4.uplink.interfaces.MyFunctionalInterface;
import io.space4.uplink.interfaces.MyWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
@RequestMapping("/agent-pods")
public class AgentPods {
    UplinkConfigs uplinkConfigs;

    @Autowired
    BootParams bootParams;

    @Autowired
    private RestEndpointEventPublisher restEndpointEventPublisher;

    @Autowired
    public void setUplinkConfigs(UplinkConfigs uplinkConfigs) {
        this.uplinkConfigs = uplinkConfigs;
    }

    @Value("${hellomessage:boot message not defined}")
    private String bootUpMessage;

    @Value("${config.client.version: config client version not defined}")
    private String configVersion;

    @GetMapping("/bootparams")
    public BootParams get_boot_params()
    {
         restEndpointEventPublisher.publishCustomEvent(">>> Get BootParams i/f was hit !!");
        return bootParams;
    }

    @GetMapping("/functional")
    public String doSomeFunctional()
    {

        MyWorker worker1 = () -> { System.out.println("I am Worker 1"); return true;
        };

        MyWorker worker2 = () -> { System.out.println("I am Worker 2"); return false;
        };

        // how it works
        MyFunctionalInterface fun1 = new MyFunctionalInterface() {
            @Override
            public boolean myMethod(MyWorker worker) {
                return worker.doStuff();
            }
		};

        // how we can write it
        MyFunctionalInterface fun2 = w -> w.doStuff();


        // how we can use it
        fun1.myMethod(worker1);
        fun1.myMethod(worker2);

        // how we can use it
        fun2.myMethod(worker1);
        fun2.myMethod(worker2);

        // or even
        fun2.myMethod(() -> {
            System.out.println("I am Worker 3");
            return true;
        });

        String returnString = fun1.myMethod(worker2) + " + "
                + fun2.myMethod(worker1) + "+"
                + fun1.myMethod(()-> false);

        return   returnString;

    }

    @GetMapping("/collections")
    public boolean run_collections()
    {

        // we could have injected this here but irrelevant at this point
        MyWorkerCollection collection = new MyWorkerCollection();

        MyWorker worker1 = () -> { System.out.println("I am Worker 1"); return true;
        };

        collection.addWorker(worker1);

        SpecialWorker1 specialWorker1 = new SpecialWorker1();
        SpecialWorker2 specialWorker2 = new SpecialWorker2();

        collection.addSpecialWorker(specialWorker1);
        collection.addSpecialWorker(specialWorker2);

        // add worker using lambda
        collection.addWorker(() -> { System.out.println("I am just a normal hard working worker."); return false; });

        // return outcome (for now)
        return collection.doSomeWork();
    }


    @GetMapping("/config")
    public UplinkConfigs get_config()
    {
        restEndpointEventPublisher.publishCustomEvent(">>> Get Config i/f was hit !!");
        return uplinkConfigs;
    }

    @GetMapping("/status")
    public String status()
    {
        restEndpointEventPublisher.publishCustomEvent(">>> Get Status i/f was hit !!");
        return "::: Agent pods are up and waiting for connections....";
    }

    @GetMapping("/hello")
    public String hello()
    {
        restEndpointEventPublisher.publishCustomEvent(">>> Hello i/f was hit !!");
        return bootUpMessage;
    }

}
