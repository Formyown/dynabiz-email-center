package org.dynabiz.dynabizemailcenterserver.service;


import org.dynabiz.dynabizemailcenterserver.repository.MailTemplateTestDataRepository;
import org.dynabiz.dynabizemailcenterserver.vos.dto.UploadTemplateTestDataTransfer;
import org.dynabiz.dynabizemailcenterserver.vos.entity.MailTemplateTestData;
import org.dynabiz.mapper.ObjectMapper;
import org.dynabiz.std.exception.RepositoryException;
import org.dynabiz.util.Assert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class MailTemplateTestService {
    private MailTemplateTestDataRepository repository;

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

    public MailTemplateTestService(MailTemplateTestDataRepository repository) {
        this.repository = repository;
    }

}
