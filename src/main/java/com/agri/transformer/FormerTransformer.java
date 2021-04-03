package com.agri.transformer;

import com.agri.domain.Former;
import com.agri.request.FormerRequest;
import com.agri.response.FormerResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FormerTransformer {

    public Former transform(final FormerRequest request) {
        final Former former = new Former();
        former.setAadharNumber(request.getAadharNumber());
        former.setBankIfscCode(request.getBankIfscCode());
        former.setCaste(request.getCaste());
        former.setDistrict(request.getDistrict());
        former.setFarmersName(request.getFarmersName());
        former.setEducation(request.getEducation());
        former.setCreatedBy(request.getUserId());
        former.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        former.setGender(request.getGender());
        former.setHouseHoldSize(request.getHouseHoldSize());
        former.setShareAmount(request.getShareAmount());
        former.setModifiedBy(request.getUserId());
        former.setModifiedDate(former.getCreatedDate());
        former.setPhoneNumber(request.getPhoneNumber());
        return former;
    }

    public List<FormerResponse> transform(final List<Former> formers) {
        if (CollectionUtils.isEmpty(formers)) {
            return Collections.emptyList();
        }
        return formers.stream().map(this::transform).collect(Collectors.toList());
    }

    public FormerResponse transform(final Former dbObject) {
        final FormerResponse.Builder builder = new FormerResponse.Builder();
        builder.setAadharNumber(dbObject.getAadharNumber());
        builder.setBankIfscCode(dbObject.getBankIfscCode());
        builder.setCaste(dbObject.getCaste());
        builder.setDistrict(dbObject.getDistrict());
        builder.setFarmersName(dbObject.getFarmersName());
        builder.setEducation(dbObject.getEducation());
        builder.setGender(dbObject.getGender());
        builder.setHouseHoldSize(dbObject.getHouseHoldSize());
        builder.setShareAmount(dbObject.getShareAmount());
        builder.setPhoneNumber(dbObject.getPhoneNumber());
        builder.setFormerId(dbObject.getFormerId());
        return builder.build();
    }

}
