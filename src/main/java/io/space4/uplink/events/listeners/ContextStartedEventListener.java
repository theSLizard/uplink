package io.space4.uplink.events.listeners;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ContextStartedEventListener {
    @Async
    @EventListener
    public void handleContextStart(ContextStartedEvent cse) {
        System.out.println("::: --> Handling context started event.");
    }
}

