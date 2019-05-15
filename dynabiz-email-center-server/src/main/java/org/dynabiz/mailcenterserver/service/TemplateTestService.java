package org.dynabiz.mailcenterserver.service;


import org.dynabiz.mailcenterserver.repository.TemplateTestDataRepository;
import org.dynabiz.mailcenterserver.vos.dto.UploadTemplateTestDataTransfer;
import org.dynabiz.mailcenterserver.vos.entity.MailTemplateTestData;
import org.dynabiz.mapper.ObjectMapper;
import org.dynabiz.std.exception.RepositoryException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class TemplateTestService {
    private TemplateTestDataRepository repository;

    public void upload(UploadTemplateTestDataTransfer dto) {
        repository.save(ObjectMapper.mapFrom(MailTemplateTestData.class, dto));
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void modify(String id, @Validated UploadTemplateTestDataTransfer transfer) {
        repository.findById(id).orElseThrow(()->RepositoryException.ITEM_NOT_FOUND);
        repository.save(ObjectMapper.mapFrom(MailTemplateTestData.class,transfer));
    }

    public Page<MailTemplateTestData> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public TemplateTestService(TemplateTestDataRepository repository) {
        this.repository = repository;
    }

}
