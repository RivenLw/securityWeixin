package com.Riven.ssm.po;

/**
 * null
 * 
 * @author wcyong
 * 
 * @date 2018-04-21
 */
public class TorfQuestion {
    private String questionId;

    private String questionContent;

    private String answer;

    private String solution;

    private String isdelete;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution == null ? null : solution.trim();
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete == null ? null : isdelete.trim();
    }

	@Override
	public String toString() {
		return "TorfQuestion [questionId=" + questionId + ", questionContent=" + questionContent + ", answer=" + answer
				+ ", solution=" + solution + ", isdelete=" + isdelete + "]";
	}
}