package com.example.awssqs.application;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.example.awssqs.dto.SendMailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class SqsMessageSender {

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public SqsMessageSender(AmazonSQS amazonSQS) {
        this.queueMessagingTemplate = new QueueMessagingTemplate((AmazonSQSAsync) amazonSQS);
    }

    public void send(String message) {
        Message<String> sendMessage = MessageBuilder.withPayload(message).build();
        queueMessagingTemplate.send("testQueue", sendMessage);
    }

    public void sendMail(SendMailDTO sendMailDTO) {
        queueMessagingTemplate.convertAndSend("testQueue", sendMailDTO);
    }

}
