package org.dynabiz.dynabizemailcenterserver.service;


import org.dynabiz.dynabizemailcenterserver.repository.MailTemplateRepository;
import org.dynabiz.dynabizemailcenterserver.vos.dto.UploadTemplateTransfer;
import org.dynabiz.dynabizemailcenterserver.vos.entity.MailTemplate;
import org.dynabiz.mapper.ObjectMapper;
import org.dynabiz.std.exception.PermissionException;
import org.dynabiz.std.exception.RepositoryException;
import org.dynabiz.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class MailTemplateService {
    private MailTemplateRepository mailTemplateRepository;

    public void uploadTemplate(UploadTemplateTransfer template){
        Assert.beTrue(!mailTemplateRepository.existsById(template.getName()), RepositoryException.ITEM_EXISTS);
        MailTemplate mailTemplate = ObjectMapper.mapFrom(MailTemplate.class, template);
        mailTemplate.setCreateAt(new Date());
        mailTemplate.setModifyAt(new Date());
        mailTemplateRepository.save(mailTemplate);
    }

    public void deleteTemplate(String id){
        Assert.beTrue(mailTemplateRepository.existsById(id), RepositoryException.ITEM_NOT_FOUND);
        mailTemplateRepository.deleteById(id);
    }

    public void modifyTemplate(String id, UploadTemplateTransfer template){
        mailTemplateRepository.findById(id).orElseThrow(()->RepositoryException.ITEM_NOT_FOUND);
        MailTemplate mailTemplate = ObjectMapper.mapFrom(MailTemplate.class, template);
        mailTemplate.setModifyAt(new Date());
        mailTemplateRepository.save(mailTemplate);
    }

    public Page<MailTemplate> getTemplates(Pageable pageRequestTransfer){
        return mailTemplateRepository.findAll(pageRequestTransfer);
    }

    @Autowired
    public MailTemplateService(MailTemplateRepository mailTemplateRepository) {
        this.mailTemplateRepository = mailTemplateRepository;
    }
}
