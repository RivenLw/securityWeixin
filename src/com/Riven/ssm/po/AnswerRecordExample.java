package com.Riven.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class AnswerRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnswerRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * null
     * 
     * @author wcyong
     * 
     * @date 2018-04-24
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRecordIdIsNull() {
            addCriterion("RECORD_ID is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("RECORD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Integer value) {
            addCriterion("RECORD_ID =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Integer value) {
            addCriterion("RECORD_ID <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Integer value) {
            addCriterion("RECORD_ID >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECORD_ID >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Integer value) {
            addCriterion("RECORD_ID <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("RECORD_ID <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Integer> values) {
            addCriterion("RECORD_ID in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Integer> values) {
            addCriterion("RECORD_ID not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("RECORD_ID between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RECORD_ID not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("OPENID is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("OPENID is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("OPENID =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("OPENID <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("OPENID >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("OPENID >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("OPENID <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("OPENID <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("OPENID like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("OPENID not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("OPENID in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("OPENID not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("OPENID between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("OPENID not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("START_TIME like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("START_TIME not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("END_TIME like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("END_TIME not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andQuestionSumIsNull() {
            addCriterion("QUESTION_SUM is null");
            return (Criteria) this;
        }

        public Criteria andQuestionSumIsNotNull() {
            addCriterion("QUESTION_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionSumEqualTo(String value) {
            addCriterion("QUESTION_SUM =", value, "questionSum");
            return (Criteria) this;
        }

        public Criteria andQuestionSumNotEqualTo(String value) {
            addCriterion("QUESTION_SUM <>", value, "questionSum");
            return (Criteria) this;
        }

        public Criteria andQuestionSumGreaterThan(String value) {
            addCriterion("QUESTION_SUM >", value, "questionSum");
            return (Criteria) this;
        }

        public Criteria andQuestionSumGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_SUM >=", value, "questionSum");
            return (Criteria) this;
        }

        public Criteria andQuestionSumLessThan(String value) {
            addCriterion("QUESTION_SUM <", value, "questionSum");
            return (Criteria) this;
        }

        public Criteria andQuestionSumLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_SUM <=", value, "questionSum");
            return (Criteria) this;
        }

        public Criteria andQuestionSumLike(String value) {
            addCriterion("QUESTION_SUM like", value, "questionSum");
            return (Criteria) this;
        }

        public Criteria andQuestionSumNotLike(String value) {
            addCriterion("QUESTION_SUM not like", value, "questionSum");
            return (Criteria) this;
        }

        public Criteria andQuestionSumIn(List<String> values) {
            addCriterion("QUESTION_SUM in", values, "questionSum");
            return (Criteria) this;
        }

        public Criteria andQuestionSumNotIn(List<String> values) {
            addCriterion("QUESTION_SUM not in", values, "questionSum");
            return (Criteria) this;
        }

        public Criteria andQuestionSumBetween(String value1, String value2) {
            addCriterion("QUESTION_SUM between", value1, value2, "questionSum");
            return (Criteria) this;
        }

        public Criteria andQuestionSumNotBetween(String value1, String value2) {
            addCriterion("QUESTION_SUM not between", value1, value2, "questionSum");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsIsNull() {
            addCriterion("TRUE_QUESTIONS is null");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsIsNotNull() {
            addCriterion("TRUE_QUESTIONS is not null");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsEqualTo(String value) {
            addCriterion("TRUE_QUESTIONS =", value, "trueQuestions");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsNotEqualTo(String value) {
            addCriterion("TRUE_QUESTIONS <>", value, "trueQuestions");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsGreaterThan(String value) {
            addCriterion("TRUE_QUESTIONS >", value, "trueQuestions");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsGreaterThanOrEqualTo(String value) {
            addCriterion("TRUE_QUESTIONS >=", value, "trueQuestions");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsLessThan(String value) {
            addCriterion("TRUE_QUESTIONS <", value, "trueQuestions");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsLessThanOrEqualTo(String value) {
            addCriterion("TRUE_QUESTIONS <=", value, "trueQuestions");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsLike(String value) {
            addCriterion("TRUE_QUESTIONS like", value, "trueQuestions");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsNotLike(String value) {
            addCriterion("TRUE_QUESTIONS not like", value, "trueQuestions");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsIn(List<String> values) {
            addCriterion("TRUE_QUESTIONS in", values, "trueQuestions");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsNotIn(List<String> values) {
            addCriterion("TRUE_QUESTIONS not in", values, "trueQuestions");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsBetween(String value1, String value2) {
            addCriterion("TRUE_QUESTIONS between", value1, value2, "trueQuestions");
            return (Criteria) this;
        }

        public Criteria andTrueQuestionsNotBetween(String value1, String value2) {
            addCriterion("TRUE_QUESTIONS not between", value1, value2, "trueQuestions");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionIsNull() {
            addCriterion("FALSE_QUESTION is null");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionIsNotNull() {
            addCriterion("FALSE_QUESTION is not null");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionEqualTo(String value) {
            addCriterion("FALSE_QUESTION =", value, "falseQuestion");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionNotEqualTo(String value) {
            addCriterion("FALSE_QUESTION <>", value, "falseQuestion");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionGreaterThan(String value) {
            addCriterion("FALSE_QUESTION >", value, "falseQuestion");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("FALSE_QUESTION >=", value, "falseQuestion");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionLessThan(String value) {
            addCriterion("FALSE_QUESTION <", value, "falseQuestion");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionLessThanOrEqualTo(String value) {
            addCriterion("FALSE_QUESTION <=", value, "falseQuestion");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionLike(String value) {
            addCriterion("FALSE_QUESTION like", value, "falseQuestion");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionNotLike(String value) {
            addCriterion("FALSE_QUESTION not like", value, "falseQuestion");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionIn(List<String> values) {
            addCriterion("FALSE_QUESTION in", values, "falseQuestion");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionNotIn(List<String> values) {
            addCriterion("FALSE_QUESTION not in", values, "falseQuestion");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionBetween(String value1, String value2) {
            addCriterion("FALSE_QUESTION between", value1, value2, "falseQuestion");
            return (Criteria) this;
        }

        public Criteria andFalseQuestionNotBetween(String value1, String value2) {
            addCriterion("FALSE_QUESTION not between", value1, value2, "falseQuestion");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusIsNull() {
            addCriterion("ANSWER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusIsNotNull() {
            addCriterion("ANSWER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusEqualTo(String value) {
            addCriterion("ANSWER_STATUS =", value, "answerStatus");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusNotEqualTo(String value) {
            addCriterion("ANSWER_STATUS <>", value, "answerStatus");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusGreaterThan(String value) {
            addCriterion("ANSWER_STATUS >", value, "answerStatus");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ANSWER_STATUS >=", value, "answerStatus");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusLessThan(String value) {
            addCriterion("ANSWER_STATUS <", value, "answerStatus");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusLessThanOrEqualTo(String value) {
            addCriterion("ANSWER_STATUS <=", value, "answerStatus");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusLike(String value) {
            addCriterion("ANSWER_STATUS like", value, "answerStatus");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusNotLike(String value) {
            addCriterion("ANSWER_STATUS not like", value, "answerStatus");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusIn(List<String> values) {
            addCriterion("ANSWER_STATUS in", values, "answerStatus");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusNotIn(List<String> values) {
            addCriterion("ANSWER_STATUS not in", values, "answerStatus");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusBetween(String value1, String value2) {
            addCriterion("ANSWER_STATUS between", value1, value2, "answerStatus");
            return (Criteria) this;
        }

        public Criteria andAnswerStatusNotBetween(String value1, String value2) {
            addCriterion("ANSWER_STATUS not between", value1, value2, "answerStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("RECORD_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("RECORD_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(String value) {
            addCriterion("RECORD_STATUS =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(String value) {
            addCriterion("RECORD_STATUS <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(String value) {
            addCriterion("RECORD_STATUS >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(String value) {
            addCriterion("RECORD_STATUS >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(String value) {
            addCriterion("RECORD_STATUS <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(String value) {
            addCriterion("RECORD_STATUS <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLike(String value) {
            addCriterion("RECORD_STATUS like", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotLike(String value) {
            addCriterion("RECORD_STATUS not like", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<String> values) {
            addCriterion("RECORD_STATUS in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<String> values) {
            addCriterion("RECORD_STATUS not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(String value1, String value2) {
            addCriterion("RECORD_STATUS between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(String value1, String value2) {
            addCriterion("RECORD_STATUS not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("NICKNAME is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("NICKNAME is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("NICKNAME =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("NICKNAME <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("NICKNAME >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("NICKNAME >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("NICKNAME <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("NICKNAME <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("NICKNAME like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("NICKNAME not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("NICKNAME in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("NICKNAME not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("NICKNAME between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("NICKNAME not between", value1, value2, "nickname");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * null
     * 
     * @author wcyong
     * 
     * @date 2018-04-24
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}