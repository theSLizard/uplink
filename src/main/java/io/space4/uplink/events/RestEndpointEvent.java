package io.space4.uplink.events;

import org.springframework.context.ApplicationEvent;

public class RestEndpointEvent extends ApplicationEvent {
    private String message;

    public RestEndpointEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}