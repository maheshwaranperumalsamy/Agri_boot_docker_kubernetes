package com.agri.transformer;

import com.agri.domain.Fig;
import com.agri.domain.Former;
import com.agri.domain.Fpo;
import com.agri.domain.QuestionsAnswer;
import com.agri.domain.Village;
import com.agri.request.FormerRequest;
import com.agri.request.QuestionsAnswerRequest;
import com.agri.response.FormerResponse;
import com.agri.response.QuestionsAnswerResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FormerTransformer {

    public Former transform(final FormerRequest request) {
        final Former former = new Former();
        former.setAadharNumber(request.getAadharNumber());
        former.setBankIfscCode(request.getBankIfscCode());
        former.setCaste(request.getCaste());
        former.setDistrict(request.getDistrict());
        final Fig fig = new Fig();
        fig.setFigId(request.getFigId());
        former.setFig(fig);
        former.setFarmersName(request.getFarmersName());
        final Fpo fpo = new Fpo();
        fpo.setFpoId(request.getFpoId());
        former.setFpo(fpo);
        former.setEducation(request.getEducation());
        former.setCreatedBy(request.getUserId());
        former.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        former.setGender(request.getGender());
        former.setHouseHoldSize(request.getHouseHoldSize());
        former.setShareAmount(request.getShareAmount());
        former.setModifiedBy(request.getUserId());
        former.setModifiedDate(former.getCreatedDate());
        former.setPhoneNumber(request.getPhoneNumber());
        final Village village = new Village();
        village.setVillageId(request.getVillageId());
        former.setVillage(village);
        former.setQuestionsAnswers(transform(request.getQuestionsAnswerRequests(), former));
        return former;
    }

    private Set<QuestionsAnswer> transform(final Set<QuestionsAnswerRequest> requests, final Former former) {
        if (CollectionUtils.isEmpty(requests)) {
            return Collections.emptySet();
        }
        return requests.stream().map(request -> {
            if (StringUtils.isEmpty(request.getAnswer())) {
                return null;
            } else {
                final QuestionsAnswer questionsAnswer = new QuestionsAnswer();
                questionsAnswer.setFormer(former);
                questionsAnswer.setQuestion(request.getQuestion());
                questionsAnswer.setAnswer(request.getAnswer());
                return questionsAnswer;
            }
        }).filter(Objects::nonNull).collect(Collectors.toSet());
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
        builder.setFigId(dbObject.getFig().getFigId());
        builder.setFarmersName(dbObject.getFarmersName());
        builder.setFpoId(dbObject.getFpo().getFpoId());
        builder.setEducation(dbObject.getEducation());
        builder.setGender(dbObject.getGender());
        builder.setHouseHoldSize(dbObject.getHouseHoldSize());
        builder.setShareAmount(dbObject.getShareAmount());
        builder.setPhoneNumber(dbObject.getPhoneNumber());
        builder.setFormerId(dbObject.getFormerId());
        builder.setVillageId(dbObject.getVillage().getVillageId());
        builder.setQuestionsAnswers(transform(dbObject.getQuestionsAnswers()));
        return builder.build();
    }

    private Set<QuestionsAnswerResponse> transform(final Set<QuestionsAnswer> dbObject) {
        if (CollectionUtils.isEmpty(dbObject)) {
            return Collections.emptySet();
        }
        return dbObject.stream().map(request -> {
            if (StringUtils.isEmpty(request.getAnswer())) {
                return null;
            } else {
                final QuestionsAnswerResponse.Builder builder = new QuestionsAnswerResponse.Builder();
                builder.setQuestion(request.getQuestion());
                builder.setAnswer(request.getAnswer());
                return builder.builder();
            }
        }).filter(Objects::nonNull).collect(Collectors.toSet());
    }

}
