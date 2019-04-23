package org.dynabiz.dynabizemailcenterserver.controller;


import org.dynabiz.dynabizemailcenterserver.service.MailTemplateService;
import org.dynabiz.dynabizemailcenterserver.vos.dto.UploadTemplateTransfer;
import org.dynabiz.dynabizemailcenterserver.vos.entity.MailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequestMapping("mail/template")
@RestController
public class MailTemplateController {
    private MailTemplateService mailTemplateService;

    /**
     * 上传邮件模板
     * @param template
     */
    @PostMapping
    public void uploadTemplate(UploadTemplateTransfer template){
        mailTemplateService.uploadTemplate(template);
    }

    /**
     * 删除邮件模板
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteTemplate(@PathVariable String id){
        mailTemplateService.deleteTemplate(id);
    }

    /**
     * 修改邮件模板
     * @param template
     */
    @PutMapping("/{id}")
    public void modifyTemplate(@PathVariable String id, UploadTemplateTransfer template){
        mailTemplateService.modifyTemplate(id, template);
    }

    /**
     * 获取所有模板
     * @param pageRequest 分页信息
     * @return Page<MailTemplate>
     */
    @GetMapping
    public Page<MailTemplate> getAllTemplates(Pageable pageRequest){
        return mailTemplateService.getTemplates(pageRequest);
    }

    @Autowired
    public MailTemplateController(MailTemplateService mailTemplateService) {
        this.mailTemplateService = mailTemplateService;
    }
}
