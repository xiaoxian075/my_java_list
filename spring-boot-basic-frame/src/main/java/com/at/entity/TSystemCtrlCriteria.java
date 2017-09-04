package com.at.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSystemCtrlCriteria extends com.at.frame.mybatis.EntityCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSystemCtrlCriteria() {
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

        public Criteria andCtrlNameIsNull() {
            addCriterion("ctrl_name is null");
            return (Criteria) this;
        }

        public Criteria andCtrlNameIsNotNull() {
            addCriterion("ctrl_name is not null");
            return (Criteria) this;
        }

        public Criteria andCtrlNameEqualTo(String value) {
            addCriterion("ctrl_name =", value, "ctrlName");
            return (Criteria) this;
        }

        public Criteria andCtrlNameNotEqualTo(String value) {
            addCriterion("ctrl_name <>", value, "ctrlName");
            return (Criteria) this;
        }

        public Criteria andCtrlNameGreaterThan(String value) {
            addCriterion("ctrl_name >", value, "ctrlName");
            return (Criteria) this;
        }

        public Criteria andCtrlNameGreaterThanOrEqualTo(String value) {
            addCriterion("ctrl_name >=", value, "ctrlName");
            return (Criteria) this;
        }

        public Criteria andCtrlNameLessThan(String value) {
            addCriterion("ctrl_name <", value, "ctrlName");
            return (Criteria) this;
        }

        public Criteria andCtrlNameLessThanOrEqualTo(String value) {
            addCriterion("ctrl_name <=", value, "ctrlName");
            return (Criteria) this;
        }

        public Criteria andCtrlNameLike(String value) {
            addCriterion("ctrl_name like", value, "ctrlName");
            return (Criteria) this;
        }

        public Criteria andCtrlNameNotLike(String value) {
            addCriterion("ctrl_name not like", value, "ctrlName");
            return (Criteria) this;
        }

        public Criteria andCtrlNameIn(List<String> values) {
            addCriterion("ctrl_name in", values, "ctrlName");
            return (Criteria) this;
        }

        public Criteria andCtrlNameNotIn(List<String> values) {
            addCriterion("ctrl_name not in", values, "ctrlName");
            return (Criteria) this;
        }

        public Criteria andCtrlNameBetween(String value1, String value2) {
            addCriterion("ctrl_name between", value1, value2, "ctrlName");
            return (Criteria) this;
        }

        public Criteria andCtrlNameNotBetween(String value1, String value2) {
            addCriterion("ctrl_name not between", value1, value2, "ctrlName");
            return (Criteria) this;
        }

        public Criteria andCtrlDescIsNull() {
            addCriterion("ctrl_desc is null");
            return (Criteria) this;
        }

        public Criteria andCtrlDescIsNotNull() {
            addCriterion("ctrl_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCtrlDescEqualTo(String value) {
            addCriterion("ctrl_desc =", value, "ctrlDesc");
            return (Criteria) this;
        }

        public Criteria andCtrlDescNotEqualTo(String value) {
            addCriterion("ctrl_desc <>", value, "ctrlDesc");
            return (Criteria) this;
        }

        public Criteria andCtrlDescGreaterThan(String value) {
            addCriterion("ctrl_desc >", value, "ctrlDesc");
            return (Criteria) this;
        }

        public Criteria andCtrlDescGreaterThanOrEqualTo(String value) {
            addCriterion("ctrl_desc >=", value, "ctrlDesc");
            return (Criteria) this;
        }

        public Criteria andCtrlDescLessThan(String value) {
            addCriterion("ctrl_desc <", value, "ctrlDesc");
            return (Criteria) this;
        }

        public Criteria andCtrlDescLessThanOrEqualTo(String value) {
            addCriterion("ctrl_desc <=", value, "ctrlDesc");
            return (Criteria) this;
        }

        public Criteria andCtrlDescLike(String value) {
            addCriterion("ctrl_desc like", value, "ctrlDesc");
            return (Criteria) this;
        }

        public Criteria andCtrlDescNotLike(String value) {
            addCriterion("ctrl_desc not like", value, "ctrlDesc");
            return (Criteria) this;
        }

        public Criteria andCtrlDescIn(List<String> values) {
            addCriterion("ctrl_desc in", values, "ctrlDesc");
            return (Criteria) this;
        }

        public Criteria andCtrlDescNotIn(List<String> values) {
            addCriterion("ctrl_desc not in", values, "ctrlDesc");
            return (Criteria) this;
        }

        public Criteria andCtrlDescBetween(String value1, String value2) {
            addCriterion("ctrl_desc between", value1, value2, "ctrlDesc");
            return (Criteria) this;
        }

        public Criteria andCtrlDescNotBetween(String value1, String value2) {
            addCriterion("ctrl_desc not between", value1, value2, "ctrlDesc");
            return (Criteria) this;
        }

        public Criteria andCtrlVersionIsNull() {
            addCriterion("ctrl_version is null");
            return (Criteria) this;
        }

        public Criteria andCtrlVersionIsNotNull() {
            addCriterion("ctrl_version is not null");
            return (Criteria) this;
        }

        public Criteria andCtrlVersionEqualTo(Integer value) {
            addCriterion("ctrl_version =", value, "ctrlVersion");
            return (Criteria) this;
        }

        public Criteria andCtrlVersionNotEqualTo(Integer value) {
            addCriterion("ctrl_version <>", value, "ctrlVersion");
            return (Criteria) this;
        }

        public Criteria andCtrlVersionGreaterThan(Integer value) {
            addCriterion("ctrl_version >", value, "ctrlVersion");
            return (Criteria) this;
        }

        public Criteria andCtrlVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("ctrl_version >=", value, "ctrlVersion");
            return (Criteria) this;
        }

        public Criteria andCtrlVersionLessThan(Integer value) {
            addCriterion("ctrl_version <", value, "ctrlVersion");
            return (Criteria) this;
        }

        public Criteria andCtrlVersionLessThanOrEqualTo(Integer value) {
            addCriterion("ctrl_version <=", value, "ctrlVersion");
            return (Criteria) this;
        }

        public Criteria andCtrlVersionIn(List<Integer> values) {
            addCriterion("ctrl_version in", values, "ctrlVersion");
            return (Criteria) this;
        }

        public Criteria andCtrlVersionNotIn(List<Integer> values) {
            addCriterion("ctrl_version not in", values, "ctrlVersion");
            return (Criteria) this;
        }

        public Criteria andCtrlVersionBetween(Integer value1, Integer value2) {
            addCriterion("ctrl_version between", value1, value2, "ctrlVersion");
            return (Criteria) this;
        }

        public Criteria andCtrlVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("ctrl_version not between", value1, value2, "ctrlVersion");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlIsNull() {
            addCriterion("ctrl_url is null");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlIsNotNull() {
            addCriterion("ctrl_url is not null");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlEqualTo(String value) {
            addCriterion("ctrl_url =", value, "ctrlUrl");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlNotEqualTo(String value) {
            addCriterion("ctrl_url <>", value, "ctrlUrl");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlGreaterThan(String value) {
            addCriterion("ctrl_url >", value, "ctrlUrl");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ctrl_url >=", value, "ctrlUrl");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlLessThan(String value) {
            addCriterion("ctrl_url <", value, "ctrlUrl");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlLessThanOrEqualTo(String value) {
            addCriterion("ctrl_url <=", value, "ctrlUrl");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlLike(String value) {
            addCriterion("ctrl_url like", value, "ctrlUrl");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlNotLike(String value) {
            addCriterion("ctrl_url not like", value, "ctrlUrl");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlIn(List<String> values) {
            addCriterion("ctrl_url in", values, "ctrlUrl");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlNotIn(List<String> values) {
            addCriterion("ctrl_url not in", values, "ctrlUrl");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlBetween(String value1, String value2) {
            addCriterion("ctrl_url between", value1, value2, "ctrlUrl");
            return (Criteria) this;
        }

        public Criteria andCtrlUrlNotBetween(String value1, String value2) {
            addCriterion("ctrl_url not between", value1, value2, "ctrlUrl");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
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