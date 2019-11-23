package com.example.customerservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.web.client.RestTemplate;

import javax.jms.ConnectionFactory;

/**
 * RestTemplate 使用@LoadBalanced注解实现负载均衡访问
 */
@Configuration
public class ConfigBean {
    private static Logger logger= LoggerFactory.getLogger(ConfigBean.class);
    @Bean
    @LoadBalanced
    public RestTemplate RestTemplate(){
        return new RestTemplate();
    }


    //topic MQ监听需要配置
    @Bean
    public JmsListenerContainerFactory<DefaultMessageListenerContainer> topListenFactory(ConnectionFactory connectionFactory){
        logger.info("-------JmsListenerContainerFactory 初始化Bean--------");
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory=new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setPubSubDomain(true);
        defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        return  defaultJmsListenerContainerFactory;

    }
}
