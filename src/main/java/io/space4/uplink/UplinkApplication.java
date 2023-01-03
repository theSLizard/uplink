package io.space4.uplink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(basePackages = {"configuration", "io.space4.uplink.pods"})
@ConfigurationPropertiesScan({"configuration", "io.space4.uplink.configuration"})
public class UplinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(UplinkApplication.class, args);
	}

}
