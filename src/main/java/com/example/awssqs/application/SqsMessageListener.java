package com.example.awssqs.application;

import com.example.awssqs.dto.SendMailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class SqsMessageListener {

    @SqsListener(value = "testQueue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void listen(@Payload SendMailDTO sendMailDTO,
                       @Headers Map<String, String> headers) {
        log.info("{}", sendMailDTO);
        log.info("{}", headers);
    }

}
