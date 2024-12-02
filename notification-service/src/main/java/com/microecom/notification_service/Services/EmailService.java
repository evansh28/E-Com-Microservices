package com.microecom.notification_service.Services;

import static com.microecom.notification_service.Models.EmailTemplates.ORDER_CONFIRMATION;
import static com.microecom.notification_service.Models.EmailTemplates.PAYMENT_CONFIRMATION;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.mail.javamail.MimeMessageHelper.MULTIPART_MODE_RELATED;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.microecom.notification_service.Models.EmailTemplates;
import com.microecom.notification_service.Models.Product;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendPaymentSuccessfullemail(String destinationEmal, String customerName, BigDecimal amount,
            String orderrefrence) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, MULTIPART_MODE_RELATED, UTF_8.name());

        messageHelper.setFrom("devanshindoriya@gmail.com");

        final String tenplates = EmailTemplates.PAYMENT_CONFIRMATION.getTemplate();

        Map<String, Object> variables = new HashMap<>();

        variables.put("CustomerName", customerName);
        variables.put("amount", amount);
        variables.put("OrderRefrence", orderrefrence);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(PAYMENT_CONFIRMATION.getSubject());

        try{
            String htmlTemplate = templateEngine.process(tenplates, context);
            messageHelper.setText(htmlTemplate);

            messageHelper.setTo(destinationEmal);
            mailSender.send(message);
            log.info("Email Successfully sent");
        }
        catch(MessagingException e){
            log.warn("Cannot sent email");
        }

    }

    @Async
    public void sendOrderSuccessfullemail(String destinationEmal, String customerName, BigDecimal amount,
            String orderrefrence, List<Product> products) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, MULTIPART_MODE_RELATED, UTF_8.name());

        messageHelper.setFrom("devanshindoriya@gmail.com");

        final String tenplates = EmailTemplates.ORDER_CONFIRMATION.getTemplate();

        Map<String, Object> variables = new HashMap<>();

        variables.put("CustomerName", customerName);
        variables.put("totalAmount", amount);
        variables.put("OrderRefrence", orderrefrence);
        variables.put("products", products);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(ORDER_CONFIRMATION.getSubject());

        try{
            String htmlTemplate = templateEngine.process(tenplates, context);
            messageHelper.setText(htmlTemplate);

            messageHelper.setTo(destinationEmal);
            mailSender.send(message);
            log.info("Email Successfully sent");
        }
        catch(MessagingException e){
            log.warn("Cannot sent email");
        }

    }

}
