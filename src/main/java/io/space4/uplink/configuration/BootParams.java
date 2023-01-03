package io.space4.uplink.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/*
server.port=0
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
spring.application.name=uplink-service
eureka.instance.instance-id=${spring.application.name}:${instanceId:${random.value}}
hellomessage = "hello, I was configured using spring cloud config"
 */

@ConfigurationProperties
public class BootParams {

    @Value("${server.port}")
    private Integer serverPort;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaClientServiceUrlDefaultZone;

    @Value("${spring.application.name}")
    private String springApplicationName;

    @Value("${eureka.instance.instance-id}")
    private String eurekaInstanceInstanceId;

    @Value("${hellomessage:boot message not defined}")
    private String helloMessage;

    public Integer getServerPort() {
        return serverPort;
    }

    public String getEurekaClientServiceUrlDefaultZone() {
        return eurekaClientServiceUrlDefaultZone;
    }

    public String getSpringApplicationName() {
        return springApplicationName;
    }

    public String getEurekaInstanceInstanceId() {
        return eurekaInstanceInstanceId;
    }

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }

    public void setSpringApplicationName(String springApplicationName) {
        this.springApplicationName = springApplicationName;
    }

    public void setEurekaClientServiceUrlDefaultZone(String eurekaClientServiceUrlDefaultZone) {
        this.eurekaClientServiceUrlDefaultZone = eurekaClientServiceUrlDefaultZone;
    }

    public void setEurekaInstanceInstanceId(String eurekaInstanceInstanceId) {
        this.eurekaInstanceInstanceId = eurekaInstanceInstanceId;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }
}
