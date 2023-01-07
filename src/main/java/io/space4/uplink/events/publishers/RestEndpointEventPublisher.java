package io.space4.uplink.events.publishers;

import io.space4.uplink.events.RestEndpointEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class RestEndpointEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String message) {
        System.out.println("Publishing custom event. ");
        RestEndpointEvent customSpringEvent = new RestEndpointEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}
