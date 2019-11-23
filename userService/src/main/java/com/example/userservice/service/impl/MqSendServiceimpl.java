package com.example.userservice.service.impl;

import com.example.userservice.service.MqSendService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;

@Service
public class MqSendServiceimpl implements MqSendService {
    private static Logger logger= LoggerFactory.getLogger(MqSendServiceimpl.class);

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void SendMsgP2p(Queue p2p,String msg) {
        jmsMessagingTemplate.convertAndSend(p2p,msg);
        logger.info("----send msg p2p success!");
    }

    @Override
    public void SendMsgTopic(Topic topic, String msg) {

        jmsMessagingTemplate.convertAndSend(topic,msg);
        logger.info("----send msg topic success!");
    }
}
