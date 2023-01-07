package MyBeans;

import org.springframework.beans.factory.BeanNameAware;

public class MyTestBean implements BeanNameAware {
    public MyTestBean() {
        System.out.println("::: MyTestBean - constructor");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("::: MyTestBean - actual name is:" + name);
    }
}

