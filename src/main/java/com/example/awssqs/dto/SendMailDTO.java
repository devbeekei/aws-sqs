package com.example.awssqs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SendMailDTO {
    private String receiveMail;
    private String subject;
    private String contents;
}
