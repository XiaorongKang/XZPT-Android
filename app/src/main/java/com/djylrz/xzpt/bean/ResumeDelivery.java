package com.djylrz.xzpt.bean;


import java.io.Serializable;

public class ResumeDelivery implements Serializable {

    private static final long serialVersionUID = 1L;
    private long resumeDeliveryId;
    private long recruitmentId;
    private String userId;
    private long resumeId;
    private long deliveryStatus;


    public long getResumeDeliveryId() {
        return resumeDeliveryId;
    }

    public void setResumeDeliveryId(long resumeDeliveryId) {
        this.resumeDeliveryId = resumeDeliveryId;
    }


    public long getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(long recruitmentId) {
        this.recruitmentId = recruitmentId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public long getResumeId() {
        return resumeId;
    }

    public void setResumeId(long resumeId) {
        this.resumeId = resumeId;
    }


    public long getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(long deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

}
