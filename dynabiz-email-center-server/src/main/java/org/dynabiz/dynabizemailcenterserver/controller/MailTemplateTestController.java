package org.dynabiz.dynabizemailcenterserver.controller;


import org.dynabiz.dynabizemailcenterserver.service.MailTemplateTestService;
import org.dynabiz.dynabizemailcenterserver.vos.dto.UploadTemplateTestDataTransfer;
import org.dynabiz.dynabizemailcenterserver.vos.entity.MailTemplateTestData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("mail/template/test")
@RestController
@Validated
public class MailTemplateTestController {
    private MailTemplateTestService testService;
    /**
     * 上传测试数据
     * @param data
     */
    @PostMapping
    public void uploadTemplate(@Validated UploadTemplateTestDataTransfer data){
        testService.upload(data);
    }

    /**
     * 删除测试数据
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteTemplate(@PathVariable String id){
        testService.delete(id);
    }

    /**
     * 修改测试数据
     * @param template
     */
    @PutMapping()
    public void modifyTemplate(String id , @Validated UploadTemplateTestDataTransfer template,
                               BindingResult bindingResult){

        testService.modify(id, template);
    }

    /**
     * 获取测试数据
     * @param pageRequest 分页信息
     * @return Page<MailTemplate>
     */
    @GetMapping
    public Page<MailTemplateTestData> getAllTemplates(Pageable pageRequest){
        return testService.getAll(pageRequest);
    }

    public MailTemplateTestController(MailTemplateTestService testService) {
        this.testService = testService;
    }
}
