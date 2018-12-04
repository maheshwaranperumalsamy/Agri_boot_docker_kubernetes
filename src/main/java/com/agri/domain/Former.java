package com.agri.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the FORMER database table.
 */
@Entity
@Table(name = "FORMER")
public class Former implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "FORMER_ID", unique = true, nullable = false)
    private Integer formerId;

    @Column(name = "AADHAR_NUMBER", nullable = false)
    private int aadharNumber;

    @Column(name = "BANK_IFSC_CODE", length = 20)
    private String bankIfscCode;

    @Column(name = "CASTE", length = 250)
    private String caste;

    @Column(name = "CREATED_BY", nullable = false, length = 250)
    private String createdBy;

    @Column(name = "CREATED_DATE", nullable = false)
    private Timestamp createdDate;

    @Column(name = "MODULE", nullable = false, length = 250)
    private String district;

    @Column(name = "EDUCATION", length = 250)
    private String education;

    @Column(name = "FARMERS_NAME", nullable = false, length = 250)
    private String farmersName;

    @Column(name = "GENDER", nullable = false, length = 10)
    private String gender;

    @Column(name = "HOUSE_HOLD_SIZE")
    private int houseHoldSize;

    @Column(name = "MODIFIED_BY", nullable = false, length = 250)
    private String modifiedBy;

    @Column(name = "MODIFIED_DATE", nullable = false)
    private Timestamp modifiedDate;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private int phoneNumber;

    @Column(name = "SHARE_AMOUNT")
    private int shareAmount;

    @Column(name = "TOTAL_LAND_HOLDING")
    private int totalLandHolding;

    //bi-directional many-to-one association to Fpo
    @ManyToOne
    @JoinColumn(name = "FPO_ID", nullable = false)
    private Fpo fpo;

    //bi-directional many-to-one association to Village
    @ManyToOne
    @JoinColumn(name = "VILLAGE_ID", nullable = false)
    private Village village;

    //bi-directional many-to-one association to Fig
    @ManyToOne
    @JoinColumn(name = "FIG_ID", nullable = false)
    private Fig fig;

    //bi-directional many-to-one association to Land
    @OneToMany(mappedBy = "former")
    private Set<Land> lands;

    //bi-directional many-to-one association to QuestionsAnswer
    @OneToMany(mappedBy = "former")
    private Set<QuestionsAnswer> questionsAnswers;

    public Former() {
    }

    public int getFormerId() {
        return this.formerId;
    }

    public void setFormerId(final int formerId) {
        this.formerId = formerId;
    }

    public int getAadharNumber() {
        return this.aadharNumber;
    }

    public void setAadharNumber(final int aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getBankIfscCode() {
        return this.bankIfscCode;
    }

    public void setBankIfscCode(final String bankIfscCode) {
        this.bankIfscCode = bankIfscCode;
    }

    public String getCaste() {
        return this.caste;
    }

    public void setCaste(final String caste) {
        this.caste = caste;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(final Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(final String district) {
        this.district = district;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(final String education) {
        this.education = education;
    }

    public String getFarmersName() {
        return this.farmersName;
    }

    public void setFarmersName(final String farmersName) {
        this.farmersName = farmersName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public int getHouseHoldSize() {
        return this.houseHoldSize;
    }

    public void setHouseHoldSize(final int houseHoldSize) {
        this.houseHoldSize = houseHoldSize;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(final int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getShareAmount() {
        return this.shareAmount;
    }

    public void setShareAmount(final int shareAmount) {
        this.shareAmount = shareAmount;
    }

    public int getTotalLandHolding() {
        return this.totalLandHolding;
    }

    public void setTotalLandHolding(final int totalLandHolding) {
        this.totalLandHolding = totalLandHolding;
    }

    public Fpo getFpo() {
        return this.fpo;
    }

    public void setFpo(final Fpo fpo) {
        this.fpo = fpo;
    }

    public Village getVillage() {
        return this.village;
    }

    public void setVillage(final Village village) {
        this.village = village;
    }

    public Fig getFig() {
        return this.fig;
    }

    public void setFig(final Fig fig) {
        this.fig = fig;
    }

    public Set<Land> getLands() {
        return this.lands;
    }

    public void setLands(final Set<Land> lands) {
        this.lands = lands;
    }

    public Land addLand(final Land land) {
        getLands().add(land);
        land.setFormer(this);

        return land;
    }

    public Land removeLand(final Land land) {
        getLands().remove(land);
        land.setFormer(null);

        return land;
    }

    public Set<QuestionsAnswer> getQuestionsAnswers() {
        return this.questionsAnswers;
    }

    public void setQuestionsAnswers(final Set<QuestionsAnswer> questionsAnswers) {
        this.questionsAnswers = questionsAnswers;
    }

    public QuestionsAnswer addQuestionsAnswer(final QuestionsAnswer questionsAnswer) {
        getQuestionsAnswers().add(questionsAnswer);
        questionsAnswer.setFormer(this);

        return questionsAnswer;
    }

    public QuestionsAnswer removeQuestionsAnswer(final QuestionsAnswer questionsAnswer) {
        getQuestionsAnswers().remove(questionsAnswer);
        questionsAnswer.setFormer(null);

        return questionsAnswer;
    }

}