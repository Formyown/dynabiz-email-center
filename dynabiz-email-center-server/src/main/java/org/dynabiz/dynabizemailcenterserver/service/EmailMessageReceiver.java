package org.dynabiz.dynabizemailcenterserver.service;

import com.as.common.Assert;
import com.as.exception.RepositoryException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.timescodes.dawn.timescodingdawnmsmainmailifv1.repository.MailTemplateRepository;
import com.timescodes.dawn.timescodingdawnmsmainmailifv1.vos.dto.SendEmailTransfer;
import com.timescodes.dawn.timescodingdawnmsmainmailifv1.vos.entity.MailTemplate;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;


@Component
@PropertySource(value = {"classpath:/application.yaml"})
public class EmailMessageReceiver {
    private static final Logger logger = LoggerFactory.getLogger(EmailMessageReceiver.class);

    private JavaMailSender mailSender;
    private ObjectMapper mapper;

    private MailTemplateRepository templateRepository;
    @Value("${mail.fromMail.addr}")
    private String from;

    public void handleMessage(String jsonMsg){

        try {

            SendEmailTransfer message = mapper.readValue(jsonMsg, SendEmailTransfer.class);


            MailTemplate mailTemplate = Assert.notNull(templateRepository.findByName(message.getName()),
                    RepositoryException.notFound());

            Configuration config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
            StringTemplateLoader stringLoader = new StringTemplateLoader();
            stringLoader.putTemplate("CONTENT_TEMPLATE", mailTemplate.getContentTemplate());
            stringLoader.putTemplate("TITLE_TEMPLATE", mailTemplate.getTitleTemplate());
            config.setTemplateLoader(stringLoader);


            Map dataEntity = mapper.readValue(message.getData(), Map.class);


            Template contentTemplate = config.getTemplate("CONTENT_TEMPLATE","utf-8");
            Template titleTemplate = config.getTemplate("TITLE_TEMPLATE","utf-8");

            StringWriter contentWriter = new StringWriter();
            contentTemplate.process(dataEntity, contentWriter);

            StringWriter titleWriter = new StringWriter();
            titleTemplate.process(dataEntity, titleWriter);

            sendEmail(message.getEmail(), titleWriter.toString(), contentWriter.toString());
        } catch (IOException | TemplateException e) {
            logger.error(e.toString());
        }

    }

    private void sendEmail(String email, String title, String body){
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject(title);
            helper.setText(body, true);
            mailSender.send(message);
        } catch (Exception e) {
            logger.info("Send email error :" + e.toString());
            return;
        }
        logger.info("Send email to " + email + " " + title);
    }

    public EmailMessageReceiver(JavaMailSender mailSender, ObjectMapper mapper, MailTemplateRepository templateRepository) {
        this.mailSender = mailSender;
        this.mapper = mapper;
        this.templateRepository = templateRepository;
    }
}
