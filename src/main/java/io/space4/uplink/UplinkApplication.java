package io.space4.uplink;

import java.util.*;

import com.netflix.discovery.converters.Auto;
import io.space4.uplink.events.publishers.RestEndpointEventPublisher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"configuration", "events",
		"io.space4.uplink.configuration",
		"io.space4.uplink.events",
		"io.space4.uplink.pods",
		"MyConfigs", "MyBeans"})
@ConfigurationPropertiesScan({"configuration", "io.space4.uplink.configuration", "MyConfigs"})
public class UplinkApplication implements BeanNameAware, ApplicationContextAware {

	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(UplinkApplication.class, args);
	}

	@Override
	public void setBeanName(String name) {

		System.out.println("::: Uplink application - Bean name: " + name);

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("::: Uplink application - Application context - display message " + applicationContext.getDisplayName());
		System.out.println("::: Uplink application - Bean definition names : \n " + applicationContext.getBeanDefinitionNames());

		this.applicationContext = applicationContext;

		Date date = new Date(applicationContext.getStartupDate());
		System.out.println("::: Startup date is: " + date);

		try{

			Object customRepo = applicationContext.getBean("myTestBean-v2");
			if (customRepo != null)
			{
				System.out.println("::: Object found");
			}
			else
			{
				System.out.println("XXX: Object NOT found");
			}

		}
		catch (Exception ex)
		{
			System.out.println("XXX: exception caught: " + ex.getMessage());
		}

	}
}
