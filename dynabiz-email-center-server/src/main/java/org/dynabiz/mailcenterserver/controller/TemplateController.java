package org.dynabiz.mailcenterserver.controller;


import org.dynabiz.mailcenterserver.service.TemplateService;
import org.dynabiz.mailcenterserver.vos.dto.UploadTemplateTransfer;
import org.dynabiz.mailcenterserver.vos.entity.MailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequestMapping("mail/template")
@RestController
public class TemplateController {
    private TemplateService templateService;

    /**
     * 上传邮件模板
     * @param template
     */
    @PostMapping
    public void uploadTemplate(UploadTemplateTransfer template){
        templateService.uploadTemplate(template);
    }

    /**
     * 删除邮件模板
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteTemplate(@PathVariable String id){
        templateService.deleteTemplate(id);
    }

    /**
     * 修改邮件模板
     * @param template
     */
    @PutMapping("/{id}")
    public void modifyTemplate(@PathVariable String id, UploadTemplateTransfer template){
        templateService.modifyTemplate(id, template);
    }

    /**
     * 获取所有模板
     * @param pageRequest 分页信息
     * @return Page<MailTemplate>
     */
    @GetMapping
    public Page<MailTemplate> getAllTemplates(Pageable pageRequest){
        return templateService.getTemplates(pageRequest);
    }

    @Autowired
    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }
}
