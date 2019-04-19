package org.dynabiz.dynabizemailcenterserver.service;

import com.as.common.Assert;
import com.as.exception.PermissionException;
import com.as.exception.RepositoryException;
import com.as.web.data.pageable.PageRequestTransfer;
import com.timescodes.dawn.timescodingdawnmsmainmailifv1.repository.MailTemplateRepository;
import com.timescodes.dawn.timescodingdawnmsmainmailifv1.vos.dto.UploadTemplateTransfer;
import com.timescodes.dawn.timescodingdawnmsmainmailifv1.vos.entity.MailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MailTemplateService {
    private MailTemplateRepository mailTemplateRepository;
    private RedisTemplate redisTemplate;


    public void uploadTemplate(UploadTemplateTransfer template){
        Assert.beTrue(!mailTemplateRepository.existsById(template.getName()), PermissionException.illegal());
        MailTemplate mailTemplate = new MailTemplate();
        template.mapTo(mailTemplate);
        mailTemplate.setCreateAt(new Date());
        mailTemplate.setModifyAt(new Date());
        mailTemplateRepository.save(mailTemplate);
    }

    public void deleteTemplate(String id){
        Assert.beTrue(mailTemplateRepository.existsById(id), RepositoryException.notFound());
        mailTemplateRepository.deleteById(id);
    }

    public void modifyTemplate(String id, UploadTemplateTransfer template){
        MailTemplate mailTemplate = Assert.notNull(mailTemplateRepository.findById(id), RepositoryException.notFound());
        template.mapTo(mailTemplate);
        mailTemplate.setModifyAt(new Date());
        mailTemplateRepository.save(mailTemplate);
    }

    public Page<MailTemplate> getTemplates(PageRequestTransfer pageRequestTransfer){
        return mailTemplateRepository.findAll(pageRequestTransfer);
    }

    @Autowired
    public MailTemplateService(MailTemplateRepository mailTemplateRepository, RedisTemplate redisTemplate) {
        this.mailTemplateRepository = mailTemplateRepository;
        this.redisTemplate = redisTemplate;
    }
}
