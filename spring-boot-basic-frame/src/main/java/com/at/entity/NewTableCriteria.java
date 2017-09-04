package com.at.entity;

import java.util.ArrayList;
import java.util.List;

public class NewTableCriteria extends com.at.frame.mybatis.EntityCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewTableCriteria() {
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

        public Criteria andIdnewTableIsNull() {
            addCriterion("idnew_table is null");
            return (Criteria) this;
        }

        public Criteria andIdnewTableIsNotNull() {
            addCriterion("idnew_table is not null");
            return (Criteria) this;
        }

        public Criteria andIdnewTableEqualTo(Integer value) {
            addCriterion("idnew_table =", value, "idnewTable");
            return (Criteria) this;
        }

        public Criteria andIdnewTableNotEqualTo(Integer value) {
            addCriterion("idnew_table <>", value, "idnewTable");
            return (Criteria) this;
        }

        public Criteria andIdnewTableGreaterThan(Integer value) {
            addCriterion("idnew_table >", value, "idnewTable");
            return (Criteria) this;
        }

        public Criteria andIdnewTableGreaterThanOrEqualTo(Integer value) {
            addCriterion("idnew_table >=", value, "idnewTable");
            return (Criteria) this;
        }

        public Criteria andIdnewTableLessThan(Integer value) {
            addCriterion("idnew_table <", value, "idnewTable");
            return (Criteria) this;
        }

        public Criteria andIdnewTableLessThanOrEqualTo(Integer value) {
            addCriterion("idnew_table <=", value, "idnewTable");
            return (Criteria) this;
        }

        public Criteria andIdnewTableIn(List<Integer> values) {
            addCriterion("idnew_table in", values, "idnewTable");
            return (Criteria) this;
        }

        public Criteria andIdnewTableNotIn(List<Integer> values) {
            addCriterion("idnew_table not in", values, "idnewTable");
            return (Criteria) this;
        }

        public Criteria andIdnewTableBetween(Integer value1, Integer value2) {
            addCriterion("idnew_table between", value1, value2, "idnewTable");
            return (Criteria) this;
        }

        public Criteria andIdnewTableNotBetween(Integer value1, Integer value2) {
            addCriterion("idnew_table not between", value1, value2, "idnewTable");
            return (Criteria) this;
        }

        public Criteria andNewTablecolIsNull() {
            addCriterion("new_tablecol is null");
            return (Criteria) this;
        }

        public Criteria andNewTablecolIsNotNull() {
            addCriterion("new_tablecol is not null");
            return (Criteria) this;
        }

        public Criteria andNewTablecolEqualTo(String value) {
            addCriterion("new_tablecol =", value, "newTablecol");
            return (Criteria) this;
        }

        public Criteria andNewTablecolNotEqualTo(String value) {
            addCriterion("new_tablecol <>", value, "newTablecol");
            return (Criteria) this;
        }

        public Criteria andNewTablecolGreaterThan(String value) {
            addCriterion("new_tablecol >", value, "newTablecol");
            return (Criteria) this;
        }

        public Criteria andNewTablecolGreaterThanOrEqualTo(String value) {
            addCriterion("new_tablecol >=", value, "newTablecol");
            return (Criteria) this;
        }

        public Criteria andNewTablecolLessThan(String value) {
            addCriterion("new_tablecol <", value, "newTablecol");
            return (Criteria) this;
        }

        public Criteria andNewTablecolLessThanOrEqualTo(String value) {
            addCriterion("new_tablecol <=", value, "newTablecol");
            return (Criteria) this;
        }

        public Criteria andNewTablecolLike(String value) {
            addCriterion("new_tablecol like", value, "newTablecol");
            return (Criteria) this;
        }

        public Criteria andNewTablecolNotLike(String value) {
            addCriterion("new_tablecol not like", value, "newTablecol");
            return (Criteria) this;
        }

        public Criteria andNewTablecolIn(List<String> values) {
            addCriterion("new_tablecol in", values, "newTablecol");
            return (Criteria) this;
        }

        public Criteria andNewTablecolNotIn(List<String> values) {
            addCriterion("new_tablecol not in", values, "newTablecol");
            return (Criteria) this;
        }

        public Criteria andNewTablecolBetween(String value1, String value2) {
            addCriterion("new_tablecol between", value1, value2, "newTablecol");
            return (Criteria) this;
        }

        public Criteria andNewTablecolNotBetween(String value1, String value2) {
            addCriterion("new_tablecol not between", value1, value2, "newTablecol");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1IsNull() {
            addCriterion("new_tablecol1 is null");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1IsNotNull() {
            addCriterion("new_tablecol1 is not null");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1EqualTo(String value) {
            addCriterion("new_tablecol1 =", value, "newTablecol1");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1NotEqualTo(String value) {
            addCriterion("new_tablecol1 <>", value, "newTablecol1");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1GreaterThan(String value) {
            addCriterion("new_tablecol1 >", value, "newTablecol1");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1GreaterThanOrEqualTo(String value) {
            addCriterion("new_tablecol1 >=", value, "newTablecol1");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1LessThan(String value) {
            addCriterion("new_tablecol1 <", value, "newTablecol1");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1LessThanOrEqualTo(String value) {
            addCriterion("new_tablecol1 <=", value, "newTablecol1");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1Like(String value) {
            addCriterion("new_tablecol1 like", value, "newTablecol1");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1NotLike(String value) {
            addCriterion("new_tablecol1 not like", value, "newTablecol1");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1In(List<String> values) {
            addCriterion("new_tablecol1 in", values, "newTablecol1");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1NotIn(List<String> values) {
            addCriterion("new_tablecol1 not in", values, "newTablecol1");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1Between(String value1, String value2) {
            addCriterion("new_tablecol1 between", value1, value2, "newTablecol1");
            return (Criteria) this;
        }

        public Criteria andNewTablecol1NotBetween(String value1, String value2) {
            addCriterion("new_tablecol1 not between", value1, value2, "newTablecol1");
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