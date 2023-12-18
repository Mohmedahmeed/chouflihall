package com.example.stage4e.Service;

import com.example.stage4e.Auth.Code;
import com.example.stage4e.Entities.Email;
import com.example.stage4e.Interfaces.EmailServiceInterface;
import com.example.stage4e.Repository.EmailRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@Slf4j
@AllArgsConstructor
public class EmailServiceImp implements EmailServiceInterface {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private EmailRepository EmailRepository;

    private final Code code;

    @Override
    public void sendEmail(String toEmail, String Subject, String body){

        log.info("sending mail to {} ,subject is :{}",toEmail,Subject);
        SimpleMailMessage message =  new SimpleMailMessage();
        message.setFrom("7andahmed@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(Subject);

        javaMailSender.send(message);

        Email mailingcontent= new Email();
        mailingcontent.setBody(body);
        mailingcontent.setSubject(Subject);
        mailingcontent.setToEmail(toEmail);
        EmailRepository.save(mailingcontent);
    }

    @Override
    public List<Email> gethistory(int a) {
        return null;
    }

    @Override
    public void sendEmaill(SimpleMailMessage message) {
        javaMailSender.send(message);
        Email mailingcontent= new Email();
        mailingcontent.setBody(message.getText());
        mailingcontent.setSubject(message.getSubject());
        mailingcontent.setToEmail(message.getReplyTo());
        EmailRepository.save(mailingcontent);
    }


    public void sendWelcomeEmail(String to, String subject, String message) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
        messageHelper.setSubject(subject);
        messageHelper.setTo(to);

        Context context = new Context();
        context.setVariable("subject", subject);
        context.setVariable("message", message);
        String content = templateEngine.process("welcomeMail", context);

        messageHelper.setText(content, true);
        javaMailSender.send(mimeMessage);
    }

    @Override
    @Async
    public void sendEmailTemplate(String to, String email) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "utf-8");
            message.setTo(to);
            message.setSubject(" Registration Confirmation mail ");
            message.setText(email, true);
            message.setFrom("7andahmed@gmail.com");
            javaMailSender.send(mimeMessage);
        }
        catch (MessagingException e)  {
            throw new IllegalStateException("failed to send email");
        }
    }


    @Async
    public void sendCodeByMail(Email email){


            try {
                String codeValue=email.getCode();
                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setFrom("7andahmed@gmail.com");
                simpleMailMessage.setTo(email.getToEmail());
                simpleMailMessage.setSubject("Active code");
                simpleMailMessage.setText(codeValue);
                javaMailSender.send(simpleMailMessage);
            }
            catch (Exception e){
                System.out.println("ma mchetch");
                System.out.println(email.getToEmail());
                System.out.println(email.getCode());
            }

    }



}
