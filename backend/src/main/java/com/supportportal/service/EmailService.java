package com.supportportal.service;

import org.springframework.stereotype.Service;

import javax.mail.Session;
import java.util.Properties;

import static com.supportportal.constant.EmailConstant.*;

@Service
public class EmailService {

    private Session getEmailSession() {
        Properties properties = System.getProperties();
        properties.put(SMTP_HOST, GMAIL_SMTP_SERVER);
        properties.put(SMTP_AUTH, true);
        properties.put(SMTP_PORT, DEFAULT_PORT);
        properties.put(SMTP_STARTTLS_ENABLE, true);
        properties.put(SMTP_STARTTLS_REQUIRED, true);
        return Session.getInstance(properties, null)
    }
}
