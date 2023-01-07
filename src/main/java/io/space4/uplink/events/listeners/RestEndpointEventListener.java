package io.space4.uplink.events.listeners;

import io.space4.uplink.events.RestEndpointEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class RestEndpointEventListener implements ApplicationListener<RestEndpointEvent> {

    @Override
    public void onApplicationEvent(RestEndpointEvent event) {
        System.out.println("::: Received spring custom event --> " + event.getMessage());
    }

}
