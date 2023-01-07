package MyConfigs;

import MyBeans.MyTestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyTestConfig {
    @Bean(name = "myTestBean-v2")
    public MyTestBean getMyTestBean() {
        return new MyTestBean();
    }
}