package com.example.userservice.service;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.Queue;
import javax.jms.Topic;

public interface MqSendService {
    void SendMsgP2p(Queue p2p, String msg);
    void SendMsgTopic(Topic topic, String msg);
}
