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

    public String getCustomKey1() {
        return customKey1;
    }

    public void setCustomKey1(String customKey1) {
        this.customKey1 = customKey1;
    }

    @Value("${s4key1}")
    private String  customKey1;

    public String getCustomKey2() {
        return customKey2;
    }

    public void setCustomKey2(String customKey2) {
        this.customKey2 = customKey2;
    }

    @Value("${s4key2}")
    private String  customKey2;

    public String getCustomKey3() {
        return customKey3;
    }

    public void setCustomKey3(String customKey3) {
        this.customKey3 = customKey3;
    }

    @Value("${s4key3}")
    private String  customKey3;

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
