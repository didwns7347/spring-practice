package com.bit.springpractice.beandefinition;

import com.bit.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac=
            new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean(){
        String[] beanDefnames = ac.getBeanDefinitionNames();
        for(String beanDefName:beanDefnames){
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefName);
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefName: "+beanDefName+" beanDefinition: "+beanDefinition);
            }
        }
    }


}
