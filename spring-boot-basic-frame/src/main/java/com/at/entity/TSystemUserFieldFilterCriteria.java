package com.at.entity;

import java.util.ArrayList;
import java.util.List;

public class TSystemUserFieldFilterCriteria extends com.at.frame.mybatis.EntityCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSystemUserFieldFilterCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdIsNull() {
            addCriterion("ctrl_id is null");
            return (Criteria) this;
        }

        public Criteria andCtrlIdIsNotNull() {
            addCriterion("ctrl_id is not null");
            return (Criteria) this;
        }

        public Criteria andCtrlIdEqualTo(Integer value) {
            addCriterion("ctrl_id =", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdNotEqualTo(Integer value) {
            addCriterion("ctrl_id <>", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdGreaterThan(Integer value) {
            addCriterion("ctrl_id >", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ctrl_id >=", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdLessThan(Integer value) {
            addCriterion("ctrl_id <", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdLessThanOrEqualTo(Integer value) {
            addCriterion("ctrl_id <=", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdIn(List<Integer> values) {
            addCriterion("ctrl_id in", values, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdNotIn(List<Integer> values) {
            addCriterion("ctrl_id not in", values, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdBetween(Integer value1, Integer value2) {
            addCriterion("ctrl_id between", value1, value2, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ctrl_id not between", value1, value2, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andMethodIdIsNull() {
            addCriterion("method_id is null");
            return (Criteria) this;
        }

        public Criteria andMethodIdIsNotNull() {
            addCriterion("method_id is not null");
            return (Criteria) this;
        }

        public Criteria andMethodIdEqualTo(Integer value) {
            addCriterion("method_id =", value, "methodId");
            return (Criteria) this;
        }

        public Criteria andMethodIdNotEqualTo(Integer value) {
            addCriterion("method_id <>", value, "methodId");
            return (Criteria) this;
        }

        public Criteria andMethodIdGreaterThan(Integer value) {
            addCriterion("method_id >", value, "methodId");
            return (Criteria) this;
        }

        public Criteria andMethodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("method_id >=", value, "methodId");
            return (Criteria) this;
        }

        public Criteria andMethodIdLessThan(Integer value) {
            addCriterion("method_id <", value, "methodId");
            return (Criteria) this;
        }

        public Criteria andMethodIdLessThanOrEqualTo(Integer value) {
            addCriterion("method_id <=", value, "methodId");
            return (Criteria) this;
        }

        public Criteria andMethodIdIn(List<Integer> values) {
            addCriterion("method_id in", values, "methodId");
            return (Criteria) this;
        }

        public Criteria andMethodIdNotIn(List<Integer> values) {
            addCriterion("method_id not in", values, "methodId");
            return (Criteria) this;
        }

        public Criteria andMethodIdBetween(Integer value1, Integer value2) {
            addCriterion("method_id between", value1, value2, "methodId");
            return (Criteria) this;
        }

        public Criteria andMethodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("method_id not between", value1, value2, "methodId");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsIsNull() {
            addCriterion("filter_fields is null");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsIsNotNull() {
            addCriterion("filter_fields is not null");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsEqualTo(String value) {
            addCriterion("filter_fields =", value, "filterFields");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsNotEqualTo(String value) {
            addCriterion("filter_fields <>", value, "filterFields");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsGreaterThan(String value) {
            addCriterion("filter_fields >", value, "filterFields");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsGreaterThanOrEqualTo(String value) {
            addCriterion("filter_fields >=", value, "filterFields");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsLessThan(String value) {
            addCriterion("filter_fields <", value, "filterFields");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsLessThanOrEqualTo(String value) {
            addCriterion("filter_fields <=", value, "filterFields");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsLike(String value) {
            addCriterion("filter_fields like", value, "filterFields");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsNotLike(String value) {
            addCriterion("filter_fields not like", value, "filterFields");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsIn(List<String> values) {
            addCriterion("filter_fields in", values, "filterFields");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsNotIn(List<String> values) {
            addCriterion("filter_fields not in", values, "filterFields");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsBetween(String value1, String value2) {
            addCriterion("filter_fields between", value1, value2, "filterFields");
            return (Criteria) this;
        }

        public Criteria andFilterFieldsNotBetween(String value1, String value2) {
            addCriterion("filter_fields not between", value1, value2, "filterFields");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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