package io.space4.uplink.events.listeners;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class WebServerUpEventListener {
    @Async
    @EventListener
    public void handleContextStart(WebServerInitializedEvent wse) {
        System.out.println("::: --> Web Service Started  Event --> ON PORT: " + wse.getWebServer().getPort());
    }
}