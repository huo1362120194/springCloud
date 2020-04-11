package com.service.impl;

import com.service.MessageProviderService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


@EnableBinding(Source.class)
public class MessageProviderServiceImpl implements MessageProviderService {

    @Resource
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {
        String message = UUID.randomUUID().toString();
        System.out.println("message: " + message);
        output.send(MessageBuilder.withPayload(message).build());
        return message;
    }
}
