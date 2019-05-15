package org.dynabiz.mailcenterserver.service;


import org.dynabiz.mailcenterserver.repository.TemplateRepository;
import org.dynabiz.mailcenterserver.vos.dto.UploadTemplateTransfer;
import org.dynabiz.mailcenterserver.vos.entity.MailTemplate;
import org.dynabiz.mapper.ObjectMapper;
import org.dynabiz.std.exception.RepositoryException;
import org.dynabiz.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TemplateService {
    private TemplateRepository templateRepository;

    public void uploadTemplate(UploadTemplateTransfer template){
        Assert.beTrue(!templateRepository.existsById(template.getName()), RepositoryException.ITEM_EXISTS);
        MailTemplate mailTemplate = ObjectMapper.mapFrom(MailTemplate.class, template);
        mailTemplate.setCreateAt(new Date());
        mailTemplate.setModifyAt(new Date());
        templateRepository.save(mailTemplate);
    }

    public void deleteTemplate(String id){
        Assert.beTrue(templateRepository.existsById(id), RepositoryException.ITEM_NOT_FOUND);
        templateRepository.deleteById(id);
    }

    public void modifyTemplate(String id, UploadTemplateTransfer template){
        templateRepository.findById(id).orElseThrow(()->RepositoryException.ITEM_NOT_FOUND);
        MailTemplate mailTemplate = ObjectMapper.mapFrom(MailTemplate.class, template);
        mailTemplate.setModifyAt(new Date());
        templateRepository.save(mailTemplate);
    }

    public Page<MailTemplate> getTemplates(Pageable pageRequestTransfer){
        return templateRepository.findAll(pageRequestTransfer);
    }

    @Autowired
    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }
}
