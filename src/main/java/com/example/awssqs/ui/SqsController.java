package com.example.awssqs.ui;

import com.example.awssqs.application.SqsMessageSender;
import com.example.awssqs.dto.SendMailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SqsController {

    private final SqsMessageSender sqsMessageSender;

    @GetMapping(value = "sqs/send")
    public String send(@RequestParam String message) {
        sqsMessageSender.send(message);
        return "Success";
    }

    @PostMapping(value = "sqs/send-mail")
    public String sendMail(@RequestBody SendMailDTO sendMailDTO) {
        sqsMessageSender.sendMail(sendMailDTO);
        return "Success";
    }

}
