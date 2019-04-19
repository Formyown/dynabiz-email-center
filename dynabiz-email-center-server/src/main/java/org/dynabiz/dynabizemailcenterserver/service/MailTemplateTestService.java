package org.dynabiz.dynabizemailcenterserver.service;


import org.springframework.stereotype.Service;

@Service
public class MailTemplateTestService {
    private MailTemplateTestDataRepository repository;

    public void upload(@Validated UploadTemplateTestDataTransfer dto) {
        MailTemplateTestData data = new MailTemplateTestData();
        dto.mapTo(data);
        repository.save(data);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void modify(String id, @Validated UploadTemplateTestDataTransfer transfer) {
        MailTemplateTestData testData = Assert.notNull(repository.findById(id), RepositoryException.notFound());
        transfer.mapTo(testData);
        repository.save(testData);
    }

    public Page<MailTemplateTestData> getAll(PageRequestTransfer pageable) {
        return repository.findAll(pageable);
    }

    public MailTemplateTestService(MailTemplateTestDataRepository repository) {
        this.repository = repository;
    }

}
