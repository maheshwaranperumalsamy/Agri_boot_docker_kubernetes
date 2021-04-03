package com.agri.service;

import com.agri.domain.Former;
import com.agri.repository.FormerRepository;
import com.agri.request.FormerRequest;
import com.agri.response.FormerResponse;
import com.agri.transformer.FormerTransformer;
import com.agri.validator.FormerValidator;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class FormerServiceImpl implements FormerService {

    private final FormerRepository repository;
    private final FormerTransformer transformer;
    private final FormerValidator validator;

    @Autowired
    public FormerServiceImpl(
        final FormerRepository repository,
        final FormerTransformer transformer,
        final FormerValidator validator) {
        this.repository = repository;
        this.transformer = transformer;
        this.validator = validator;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FormerResponse addFormer(final FormerRequest request) {
        validator.validateCreate(request);
        return transformer.transform(repository.save(transformer.transform(request)));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FormerResponse updateFormer(final FormerRequest request) {
        validator.validateUpdate(request);
        final Former existingFormer = repository.findById(request.getFormerId()).orElse(null);
        final Former transformedFormer = transformer.transform(request);
        transformedFormer.setFormerId(existingFormer.getFormerId());
        return transformer.transform(repository.save(transformedFormer));
    }

    @Override
    public List<FormerResponse> searchFormer(final Map<String, String> searchParams) {
        /*
        final QFormer former = QFormer.former;
        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (!StringUtils.isEmpty(searchParams.get("formerName"))) {
            booleanBuilder.and(former.farmersName.like(searchParams.get("formerName")));
        }*/
        return transformer.transform(Lists.newArrayList(repository.findAll()));
    }
}
