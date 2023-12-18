package com.example.stage4e.Interfaces;

import com.example.stage4e.Entities.Email;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import java.util.List;

public interface EmailServiceInterface {

    public void sendWelcomeEmail(String to, String subject, String message) throws MessagingException;

    public void sendEmail(String toEmail,String Subject, String body);

    public List<Email> gethistory(int  a);

    public void sendEmaill(SimpleMailMessage message);

    void sendEmailTemplate (String to ,String email);

    public void sendCodeByMail(Email email);
}
