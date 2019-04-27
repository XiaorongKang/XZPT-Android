package com.djylrz.xzpt.bean;


import java.io.Serializable;

public class Resume implements Serializable {

    private static final long serialVersionUID = 1L;
    private long resumeId;
    private String userId;
    private String telephone;
    private String userName;
    private String headUrl;
    private String email;
    private long sex;
    private long highestEducation;
    private String occupation;
    private String presentCity;
    private String expectedCity;
    private String degree;
    private String certificate;
    private String projectExperience;
    private String practicalExperience;
    private String selfEvaluation;
    private long resumeStatus;


    public long getResumeId() {
        return resumeId;
    }

    public void setResumeId(long resumeId) {
        this.resumeId = resumeId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public long getSex() {
        return sex;
    }

    public void setSex(long sex) {
        this.sex = sex;
    }


    public long getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(long highestEducation) {
        this.highestEducation = highestEducation;
    }


    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    public String getPresentCity() {
        return presentCity;
    }

    public void setPresentCity(String presentCity) {
        this.presentCity = presentCity;
    }


    public String getExpectedCity() {
        return expectedCity;
    }

    public void setExpectedCity(String expectedCity) {
        this.expectedCity = expectedCity;
    }


    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }


    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }


    public String getProjectExperience() {
        return projectExperience;
    }

    public void setProjectExperience(String projectExperience) {
        this.projectExperience = projectExperience;
    }


    public String getPracticalExperience() {
        return practicalExperience;
    }

    public void setPracticalExperience(String practicalExperience) {
        this.practicalExperience = practicalExperience;
    }


    public String getSelfEvaluation() {
        return selfEvaluation;
    }

    public void setSelfEvaluation(String selfEvaluation) {
        this.selfEvaluation = selfEvaluation;
    }


    public long getResumeStatus() {
        return resumeStatus;
    }

    public void setResumeStatus(long resumeStatus) {
        this.resumeStatus = resumeStatus;
    }

}
