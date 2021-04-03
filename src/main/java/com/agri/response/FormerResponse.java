package com.agri.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Set;

/**
 * The Response class for the FORMER.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FormerResponse.Builder.class)
public class FormerResponse {

    private final Integer formerId;
    private final int aadharNumber;
    private final String bankIfscCode;
    private final String caste;
    private final String district;
    private final String education;
    private final String farmersName;
    private final String gender;
    private final int houseHoldSize;
    private final String userId;
    private final int phoneNumber;
    private final int shareAmount;
    private final int totalLandHolding;
    private final int fpoId;
    private final int villageId;
    private final int figId;

    public FormerResponse(final Builder builder) {
        this.formerId = builder.formerId;
        this.aadharNumber = builder.aadharNumber;
        this.bankIfscCode = builder.bankIfscCode;
        this.caste = builder.caste;
        this.district = builder.district;
        this.education = builder.education;
        this.farmersName = builder.farmersName;
        this.gender = builder.gender;
        this.houseHoldSize = builder.houseHoldSize;
        this.userId = builder.userId;
        this.phoneNumber = builder.phoneNumber;
        this.shareAmount = builder.shareAmount;
        this.totalLandHolding = builder.totalLandHolding;
        this.fpoId = builder.fpoId;
        this.villageId = builder.villageId;
        this.figId = builder.figId;
    }

    public Integer getFormerId() {
        return formerId;
    }

    public int getAadharNumber() {
        return aadharNumber;
    }

    public String getBankIfscCode() {
        return bankIfscCode;
    }

    public String getCaste() {
        return caste;
    }

    public String getUserId() {
        return userId;
    }

    public String getDistrict() {
        return district;
    }

    public String getEducation() {
        return education;
    }

    public String getFarmersName() {
        return farmersName;
    }

    public String getGender() {
        return gender;
    }

    public int getHouseHoldSize() {
        return houseHoldSize;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getShareAmount() {
        return shareAmount;
    }

    public int getTotalLandHolding() {
        return totalLandHolding;
    }

    public int getFpoId() {
        return fpoId;
    }

    public int getVillageId() {
        return villageId;
    }

    public int getFigId() {
        return figId;
    }


    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
    public static class Builder {
        private Integer formerId;
        private int aadharNumber;
        private String bankIfscCode;
        private String caste;
        private String district;
        private String education;
        private String farmersName;
        private String gender;
        private int houseHoldSize;
        private String userId;
        private int phoneNumber;
        private int shareAmount;
        private int totalLandHolding;
        private int fpoId;
        private int villageId;
        private int figId;

        public Builder setFormerId(final Integer formerId) {
            this.formerId = formerId;
            return this;
        }

        public Builder setAadharNumber(final int aadharNumber) {
            this.aadharNumber = aadharNumber;
            return this;
        }

        public Builder setBankIfscCode(final String bankIfscCode) {
            this.bankIfscCode = bankIfscCode;
            return this;
        }

        public Builder setCaste(final String caste) {
            this.caste = caste;
            return this;
        }

        public Builder setDistrict(final String district) {
            this.district = district;
            return this;
        }

        public Builder setEducation(final String education) {
            this.education = education;
            return this;
        }

        public Builder setFarmersName(final String farmersName) {
            this.farmersName = farmersName;
            return this;
        }

        public Builder setGender(final String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setHouseHoldSize(final int houseHoldSize) {
            this.houseHoldSize = houseHoldSize;
            return this;
        }

        public Builder setUserId(final String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setPhoneNumber(final int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setShareAmount(final int shareAmount) {
            this.shareAmount = shareAmount;
            return this;
        }

        public Builder setTotalLandHolding(final int totalLandHolding) {
            this.totalLandHolding = totalLandHolding;
            return this;
        }

        public Builder setFpoId(final int fpoId) {
            this.fpoId = fpoId;
            return this;
        }

        public Builder setVillageId(final int villageId) {
            this.villageId = villageId;
            return this;
        }

        public Builder setFigId(final int figId) {
            this.figId = figId;
            return this;
        }


        public FormerResponse build() {
            return new FormerResponse(this);
        }
    }
}