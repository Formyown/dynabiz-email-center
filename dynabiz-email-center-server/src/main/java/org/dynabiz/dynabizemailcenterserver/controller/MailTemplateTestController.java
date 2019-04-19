package org.dynabiz.dynabizemailcenterserver.controller;



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
    public void uploadTemplate(@Validated UploadTemplateTestDataTransfer data, BindingResult bindingResult){
        testService.upload(data);
    }

    /**
     * 删除测试数据
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteTemplate(@PathVariable @NotBlank String id){
        testService.delete(id);
    }

    /**
     * 修改测试数据
     * @param template
     */
    @PutMapping()
    public void modifyTemplate(@NotBlank String id , @Validated UploadTemplateTestDataTransfer template,
                               BindingResult bindingResult){

        testService.modify(id, template);
    }

    /**
     * 获取测试数据
     * @param pageRequestTransfer 分页信息
     * @return Page<MailTemplate>
     */
    @GetMapping
    public Page<MailTemplateTestData> getAllTemplates(PageRequestTransfer pageRequestTransfer){
        return testService.getAll(pageRequestTransfer);
    }

    public MailTemplateTestController(MailTemplateTestService testService) {
        this.testService = testService;
    }
}
