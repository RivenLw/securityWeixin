package com.Riven.ssm.po;

/**
 * null
 * 
 * @author wcyong
 * 
 * @date 2018-04-18
 */
public class AnswerRecord {
    private Integer recordId;

    private String openid;

    private String startTime;

    private String endTime;

    private String questionSum;

    private String trueQuestions;

    private String falseQuestion;

    private String answerStatus;

    private String recordStatus;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getQuestionSum() {
        return questionSum;
    }

    public void setQuestionSum(String questionSum) {
        this.questionSum = questionSum == null ? null : questionSum.trim();
    }

    public String getTrueQuestions() {
        return trueQuestions;
    }

    public void setTrueQuestions(String trueQuestions) {
        this.trueQuestions = trueQuestions == null ? null : trueQuestions.trim();
    }

    public String getFalseQuestion() {
        return falseQuestion;
    }

    public void setFalseQuestion(String falseQuestion) {
        this.falseQuestion = falseQuestion == null ? null : falseQuestion.trim();
    }

    public String getAnswerStatus() {
        return answerStatus;
    }

    public void setAnswerStatus(String answerStatus) {
        this.answerStatus = answerStatus == null ? null : answerStatus.trim();
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }
}