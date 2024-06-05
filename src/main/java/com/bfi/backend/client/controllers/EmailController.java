package com.bfi.backend.client.controllers;
import com.bfi.backend.client.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendSimpleMessage(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
        return "Email sent successfully!";
    }
}



