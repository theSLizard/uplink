package io.space4.uplink.pods;

import configuration.UplinkConfigs;
import io.space4.uplink.configuration.BootParams;
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
        return bootParams;
    }

    @GetMapping("/config")
    public UplinkConfigs get_config()
    {
        return uplinkConfigs;
    }

    @GetMapping("/status")
    public String status()
    {
        return "::: Agent pods are up and waiting for connections....";
    }

    @GetMapping("/hello")
    public String hello()
    {
        return bootUpMessage;
    }

}
