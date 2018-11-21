package com.aps.env.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HbNodeAlarmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HbNodeAlarmExample() {
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

        public Criteria andGuidIsNull() {
            addCriterion("GUID is null");
            return (Criteria) this;
        }

        public Criteria andGuidIsNotNull() {
            addCriterion("GUID is not null");
            return (Criteria) this;
        }

        public Criteria andGuidEqualTo(String value) {
            addCriterion("GUID =", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidNotEqualTo(String value) {
            addCriterion("GUID <>", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidGreaterThan(String value) {
            addCriterion("GUID >", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidGreaterThanOrEqualTo(String value) {
            addCriterion("GUID >=", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidLessThan(String value) {
            addCriterion("GUID <", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidLessThanOrEqualTo(String value) {
            addCriterion("GUID <=", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidLike(String value) {
            addCriterion("GUID like", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidNotLike(String value) {
            addCriterion("GUID not like", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidIn(List<String> values) {
            addCriterion("GUID in", values, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidNotIn(List<String> values) {
            addCriterion("GUID not in", values, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidBetween(String value1, String value2) {
            addCriterion("GUID between", value1, value2, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidNotBetween(String value1, String value2) {
            addCriterion("GUID not between", value1, value2, "guid");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNull() {
            addCriterion("NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(Integer value) {
            addCriterion("NODE_ID =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(Integer value) {
            addCriterion("NODE_ID <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(Integer value) {
            addCriterion("NODE_ID >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("NODE_ID >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(Integer value) {
            addCriterion("NODE_ID <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("NODE_ID <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<Integer> values) {
            addCriterion("NODE_ID in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<Integer> values) {
            addCriterion("NODE_ID not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("NODE_ID between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("NODE_ID not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeMnIsNull() {
            addCriterion("NODE_MN is null");
            return (Criteria) this;
        }

        public Criteria andNodeMnIsNotNull() {
            addCriterion("NODE_MN is not null");
            return (Criteria) this;
        }

        public Criteria andNodeMnEqualTo(String value) {
            addCriterion("NODE_MN =", value, "nodeMn");
            return (Criteria) this;
        }

        public Criteria andNodeMnNotEqualTo(String value) {
            addCriterion("NODE_MN <>", value, "nodeMn");
            return (Criteria) this;
        }

        public Criteria andNodeMnGreaterThan(String value) {
            addCriterion("NODE_MN >", value, "nodeMn");
            return (Criteria) this;
        }

        public Criteria andNodeMnGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_MN >=", value, "nodeMn");
            return (Criteria) this;
        }

        public Criteria andNodeMnLessThan(String value) {
            addCriterion("NODE_MN <", value, "nodeMn");
            return (Criteria) this;
        }

        public Criteria andNodeMnLessThanOrEqualTo(String value) {
            addCriterion("NODE_MN <=", value, "nodeMn");
            return (Criteria) this;
        }

        public Criteria andNodeMnLike(String value) {
            addCriterion("NODE_MN like", value, "nodeMn");
            return (Criteria) this;
        }

        public Criteria andNodeMnNotLike(String value) {
            addCriterion("NODE_MN not like", value, "nodeMn");
            return (Criteria) this;
        }

        public Criteria andNodeMnIn(List<String> values) {
            addCriterion("NODE_MN in", values, "nodeMn");
            return (Criteria) this;
        }

        public Criteria andNodeMnNotIn(List<String> values) {
            addCriterion("NODE_MN not in", values, "nodeMn");
            return (Criteria) this;
        }

        public Criteria andNodeMnBetween(String value1, String value2) {
            addCriterion("NODE_MN between", value1, value2, "nodeMn");
            return (Criteria) this;
        }

        public Criteria andNodeMnNotBetween(String value1, String value2) {
            addCriterion("NODE_MN not between", value1, value2, "nodeMn");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNull() {
            addCriterion("NODE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNotNull() {
            addCriterion("NODE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNameEqualTo(String value) {
            addCriterion("NODE_NAME =", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotEqualTo(String value) {
            addCriterion("NODE_NAME <>", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThan(String value) {
            addCriterion("NODE_NAME >", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_NAME >=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThan(String value) {
            addCriterion("NODE_NAME <", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThanOrEqualTo(String value) {
            addCriterion("NODE_NAME <=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLike(String value) {
            addCriterion("NODE_NAME like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotLike(String value) {
            addCriterion("NODE_NAME not like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameIn(List<String> values) {
            addCriterion("NODE_NAME in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotIn(List<String> values) {
            addCriterion("NODE_NAME not in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameBetween(String value1, String value2) {
            addCriterion("NODE_NAME between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotBetween(String value1, String value2) {
            addCriterion("NODE_NAME not between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNull() {
            addCriterion("ITEM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNotNull() {
            addCriterion("ITEM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andItemCodeEqualTo(String value) {
            addCriterion("ITEM_CODE =", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotEqualTo(String value) {
            addCriterion("ITEM_CODE <>", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThan(String value) {
            addCriterion("ITEM_CODE >", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_CODE >=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThan(String value) {
            addCriterion("ITEM_CODE <", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThanOrEqualTo(String value) {
            addCriterion("ITEM_CODE <=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLike(String value) {
            addCriterion("ITEM_CODE like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotLike(String value) {
            addCriterion("ITEM_CODE not like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeIn(List<String> values) {
            addCriterion("ITEM_CODE in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotIn(List<String> values) {
            addCriterion("ITEM_CODE not in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeBetween(String value1, String value2) {
            addCriterion("ITEM_CODE between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotBetween(String value1, String value2) {
            addCriterion("ITEM_CODE not between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("ITEM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("ITEM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("ITEM_NAME =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("ITEM_NAME <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("ITEM_NAME >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("ITEM_NAME <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("ITEM_NAME like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("ITEM_NAME not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("ITEM_NAME in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("ITEM_NAME not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("ITEM_NAME between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("ITEM_NAME not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemValueIsNull() {
            addCriterion("ITEM_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andItemValueIsNotNull() {
            addCriterion("ITEM_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andItemValueEqualTo(String value) {
            addCriterion("ITEM_VALUE =", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueNotEqualTo(String value) {
            addCriterion("ITEM_VALUE <>", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueGreaterThan(String value) {
            addCriterion("ITEM_VALUE >", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_VALUE >=", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueLessThan(String value) {
            addCriterion("ITEM_VALUE <", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueLessThanOrEqualTo(String value) {
            addCriterion("ITEM_VALUE <=", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueLike(String value) {
            addCriterion("ITEM_VALUE like", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueNotLike(String value) {
            addCriterion("ITEM_VALUE not like", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueIn(List<String> values) {
            addCriterion("ITEM_VALUE in", values, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueNotIn(List<String> values) {
            addCriterion("ITEM_VALUE not in", values, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueBetween(String value1, String value2) {
            addCriterion("ITEM_VALUE between", value1, value2, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueNotBetween(String value1, String value2) {
            addCriterion("ITEM_VALUE not between", value1, value2, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemDateIsNull() {
            addCriterion("ITEM_DATE is null");
            return (Criteria) this;
        }

        public Criteria andItemDateIsNotNull() {
            addCriterion("ITEM_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andItemDateEqualTo(String value) {
            addCriterion("ITEM_DATE =", value, "itemDate");
            return (Criteria) this;
        }

        public Criteria andItemDateNotEqualTo(String value) {
            addCriterion("ITEM_DATE <>", value, "itemDate");
            return (Criteria) this;
        }

        public Criteria andItemDateGreaterThan(String value) {
            addCriterion("ITEM_DATE >", value, "itemDate");
            return (Criteria) this;
        }

        public Criteria andItemDateGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_DATE >=", value, "itemDate");
            return (Criteria) this;
        }

        public Criteria andItemDateLessThan(String value) {
            addCriterion("ITEM_DATE <", value, "itemDate");
            return (Criteria) this;
        }

        public Criteria andItemDateLessThanOrEqualTo(String value) {
            addCriterion("ITEM_DATE <=", value, "itemDate");
            return (Criteria) this;
        }

        public Criteria andItemDateLike(String value) {
            addCriterion("ITEM_DATE like", value, "itemDate");
            return (Criteria) this;
        }

        public Criteria andItemDateNotLike(String value) {
            addCriterion("ITEM_DATE not like", value, "itemDate");
            return (Criteria) this;
        }

        public Criteria andItemDateIn(List<String> values) {
            addCriterion("ITEM_DATE in", values, "itemDate");
            return (Criteria) this;
        }

        public Criteria andItemDateNotIn(List<String> values) {
            addCriterion("ITEM_DATE not in", values, "itemDate");
            return (Criteria) this;
        }

        public Criteria andItemDateBetween(String value1, String value2) {
            addCriterion("ITEM_DATE between", value1, value2, "itemDate");
            return (Criteria) this;
        }

        public Criteria andItemDateNotBetween(String value1, String value2) {
            addCriterion("ITEM_DATE not between", value1, value2, "itemDate");
            return (Criteria) this;
        }

        public Criteria andItemAlarmIsNull() {
            addCriterion("ITEM_ALARM is null");
            return (Criteria) this;
        }

        public Criteria andItemAlarmIsNotNull() {
            addCriterion("ITEM_ALARM is not null");
            return (Criteria) this;
        }

        public Criteria andItemAlarmEqualTo(String value) {
            addCriterion("ITEM_ALARM =", value, "itemAlarm");
            return (Criteria) this;
        }

        public Criteria andItemAlarmNotEqualTo(String value) {
            addCriterion("ITEM_ALARM <>", value, "itemAlarm");
            return (Criteria) this;
        }

        public Criteria andItemAlarmGreaterThan(String value) {
            addCriterion("ITEM_ALARM >", value, "itemAlarm");
            return (Criteria) this;
        }

        public Criteria andItemAlarmGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_ALARM >=", value, "itemAlarm");
            return (Criteria) this;
        }

        public Criteria andItemAlarmLessThan(String value) {
            addCriterion("ITEM_ALARM <", value, "itemAlarm");
            return (Criteria) this;
        }

        public Criteria andItemAlarmLessThanOrEqualTo(String value) {
            addCriterion("ITEM_ALARM <=", value, "itemAlarm");
            return (Criteria) this;
        }

        public Criteria andItemAlarmLike(String value) {
            addCriterion("ITEM_ALARM like", value, "itemAlarm");
            return (Criteria) this;
        }

        public Criteria andItemAlarmNotLike(String value) {
            addCriterion("ITEM_ALARM not like", value, "itemAlarm");
            return (Criteria) this;
        }

        public Criteria andItemAlarmIn(List<String> values) {
            addCriterion("ITEM_ALARM in", values, "itemAlarm");
            return (Criteria) this;
        }

        public Criteria andItemAlarmNotIn(List<String> values) {
            addCriterion("ITEM_ALARM not in", values, "itemAlarm");
            return (Criteria) this;
        }

        public Criteria andItemAlarmBetween(String value1, String value2) {
            addCriterion("ITEM_ALARM between", value1, value2, "itemAlarm");
            return (Criteria) this;
        }

        public Criteria andItemAlarmNotBetween(String value1, String value2) {
            addCriterion("ITEM_ALARM not between", value1, value2, "itemAlarm");
            return (Criteria) this;
        }

        public Criteria andItemPhoneIsNull() {
            addCriterion("ITEM_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andItemPhoneIsNotNull() {
            addCriterion("ITEM_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andItemPhoneEqualTo(String value) {
            addCriterion("ITEM_PHONE =", value, "itemPhone");
            return (Criteria) this;
        }

        public Criteria andItemPhoneNotEqualTo(String value) {
            addCriterion("ITEM_PHONE <>", value, "itemPhone");
            return (Criteria) this;
        }

        public Criteria andItemPhoneGreaterThan(String value) {
            addCriterion("ITEM_PHONE >", value, "itemPhone");
            return (Criteria) this;
        }

        public Criteria andItemPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_PHONE >=", value, "itemPhone");
            return (Criteria) this;
        }

        public Criteria andItemPhoneLessThan(String value) {
            addCriterion("ITEM_PHONE <", value, "itemPhone");
            return (Criteria) this;
        }

        public Criteria andItemPhoneLessThanOrEqualTo(String value) {
            addCriterion("ITEM_PHONE <=", value, "itemPhone");
            return (Criteria) this;
        }

        public Criteria andItemPhoneLike(String value) {
            addCriterion("ITEM_PHONE like", value, "itemPhone");
            return (Criteria) this;
        }

        public Criteria andItemPhoneNotLike(String value) {
            addCriterion("ITEM_PHONE not like", value, "itemPhone");
            return (Criteria) this;
        }

        public Criteria andItemPhoneIn(List<String> values) {
            addCriterion("ITEM_PHONE in", values, "itemPhone");
            return (Criteria) this;
        }

        public Criteria andItemPhoneNotIn(List<String> values) {
            addCriterion("ITEM_PHONE not in", values, "itemPhone");
            return (Criteria) this;
        }

        public Criteria andItemPhoneBetween(String value1, String value2) {
            addCriterion("ITEM_PHONE between", value1, value2, "itemPhone");
            return (Criteria) this;
        }

        public Criteria andItemPhoneNotBetween(String value1, String value2) {
            addCriterion("ITEM_PHONE not between", value1, value2, "itemPhone");
            return (Criteria) this;
        }

        public Criteria andPrflagIsNull() {
            addCriterion("PRFLAG is null");
            return (Criteria) this;
        }

        public Criteria andPrflagIsNotNull() {
            addCriterion("PRFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andPrflagEqualTo(Integer value) {
            addCriterion("PRFLAG =", value, "prflag");
            return (Criteria) this;
        }

        public Criteria andPrflagNotEqualTo(Integer value) {
            addCriterion("PRFLAG <>", value, "prflag");
            return (Criteria) this;
        }

        public Criteria andPrflagGreaterThan(Integer value) {
            addCriterion("PRFLAG >", value, "prflag");
            return (Criteria) this;
        }

        public Criteria andPrflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRFLAG >=", value, "prflag");
            return (Criteria) this;
        }

        public Criteria andPrflagLessThan(Integer value) {
            addCriterion("PRFLAG <", value, "prflag");
            return (Criteria) this;
        }

        public Criteria andPrflagLessThanOrEqualTo(Integer value) {
            addCriterion("PRFLAG <=", value, "prflag");
            return (Criteria) this;
        }

        public Criteria andPrflagIn(List<Integer> values) {
            addCriterion("PRFLAG in", values, "prflag");
            return (Criteria) this;
        }

        public Criteria andPrflagNotIn(List<Integer> values) {
            addCriterion("PRFLAG not in", values, "prflag");
            return (Criteria) this;
        }

        public Criteria andPrflagBetween(Integer value1, Integer value2) {
            addCriterion("PRFLAG between", value1, value2, "prflag");
            return (Criteria) this;
        }

        public Criteria andPrflagNotBetween(Integer value1, Integer value2) {
            addCriterion("PRFLAG not between", value1, value2, "prflag");
            return (Criteria) this;
        }

        public Criteria andPrgroupIsNull() {
            addCriterion("PRGROUP is null");
            return (Criteria) this;
        }

        public Criteria andPrgroupIsNotNull() {
            addCriterion("PRGROUP is not null");
            return (Criteria) this;
        }

        public Criteria andPrgroupEqualTo(String value) {
            addCriterion("PRGROUP =", value, "prgroup");
            return (Criteria) this;
        }

        public Criteria andPrgroupNotEqualTo(String value) {
            addCriterion("PRGROUP <>", value, "prgroup");
            return (Criteria) this;
        }

        public Criteria andPrgroupGreaterThan(String value) {
            addCriterion("PRGROUP >", value, "prgroup");
            return (Criteria) this;
        }

        public Criteria andPrgroupGreaterThanOrEqualTo(String value) {
            addCriterion("PRGROUP >=", value, "prgroup");
            return (Criteria) this;
        }

        public Criteria andPrgroupLessThan(String value) {
            addCriterion("PRGROUP <", value, "prgroup");
            return (Criteria) this;
        }

        public Criteria andPrgroupLessThanOrEqualTo(String value) {
            addCriterion("PRGROUP <=", value, "prgroup");
            return (Criteria) this;
        }

        public Criteria andPrgroupLike(String value) {
            addCriterion("PRGROUP like", value, "prgroup");
            return (Criteria) this;
        }

        public Criteria andPrgroupNotLike(String value) {
            addCriterion("PRGROUP not like", value, "prgroup");
            return (Criteria) this;
        }

        public Criteria andPrgroupIn(List<String> values) {
            addCriterion("PRGROUP in", values, "prgroup");
            return (Criteria) this;
        }

        public Criteria andPrgroupNotIn(List<String> values) {
            addCriterion("PRGROUP not in", values, "prgroup");
            return (Criteria) this;
        }

        public Criteria andPrgroupBetween(String value1, String value2) {
            addCriterion("PRGROUP between", value1, value2, "prgroup");
            return (Criteria) this;
        }

        public Criteria andPrgroupNotBetween(String value1, String value2) {
            addCriterion("PRGROUP not between", value1, value2, "prgroup");
            return (Criteria) this;
        }

        public Criteria andPrtypeIsNull() {
            addCriterion("PRTYPE is null");
            return (Criteria) this;
        }

        public Criteria andPrtypeIsNotNull() {
            addCriterion("PRTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPrtypeEqualTo(String value) {
            addCriterion("PRTYPE =", value, "prtype");
            return (Criteria) this;
        }

        public Criteria andPrtypeNotEqualTo(String value) {
            addCriterion("PRTYPE <>", value, "prtype");
            return (Criteria) this;
        }

        public Criteria andPrtypeGreaterThan(String value) {
            addCriterion("PRTYPE >", value, "prtype");
            return (Criteria) this;
        }

        public Criteria andPrtypeGreaterThanOrEqualTo(String value) {
            addCriterion("PRTYPE >=", value, "prtype");
            return (Criteria) this;
        }

        public Criteria andPrtypeLessThan(String value) {
            addCriterion("PRTYPE <", value, "prtype");
            return (Criteria) this;
        }

        public Criteria andPrtypeLessThanOrEqualTo(String value) {
            addCriterion("PRTYPE <=", value, "prtype");
            return (Criteria) this;
        }

        public Criteria andPrtypeLike(String value) {
            addCriterion("PRTYPE like", value, "prtype");
            return (Criteria) this;
        }

        public Criteria andPrtypeNotLike(String value) {
            addCriterion("PRTYPE not like", value, "prtype");
            return (Criteria) this;
        }

        public Criteria andPrtypeIn(List<String> values) {
            addCriterion("PRTYPE in", values, "prtype");
            return (Criteria) this;
        }

        public Criteria andPrtypeNotIn(List<String> values) {
            addCriterion("PRTYPE not in", values, "prtype");
            return (Criteria) this;
        }

        public Criteria andPrtypeBetween(String value1, String value2) {
            addCriterion("PRTYPE between", value1, value2, "prtype");
            return (Criteria) this;
        }

        public Criteria andPrtypeNotBetween(String value1, String value2) {
            addCriterion("PRTYPE not between", value1, value2, "prtype");
            return (Criteria) this;
        }

        public Criteria andProperty0IsNull() {
            addCriterion("PROPERTY0 is null");
            return (Criteria) this;
        }

        public Criteria andProperty0IsNotNull() {
            addCriterion("PROPERTY0 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty0EqualTo(String value) {
            addCriterion("PROPERTY0 =", value, "property0");
            return (Criteria) this;
        }

        public Criteria andProperty0NotEqualTo(String value) {
            addCriterion("PROPERTY0 <>", value, "property0");
            return (Criteria) this;
        }

        public Criteria andProperty0GreaterThan(String value) {
            addCriterion("PROPERTY0 >", value, "property0");
            return (Criteria) this;
        }

        public Criteria andProperty0GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY0 >=", value, "property0");
            return (Criteria) this;
        }

        public Criteria andProperty0LessThan(String value) {
            addCriterion("PROPERTY0 <", value, "property0");
            return (Criteria) this;
        }

        public Criteria andProperty0LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY0 <=", value, "property0");
            return (Criteria) this;
        }

        public Criteria andProperty0Like(String value) {
            addCriterion("PROPERTY0 like", value, "property0");
            return (Criteria) this;
        }

        public Criteria andProperty0NotLike(String value) {
            addCriterion("PROPERTY0 not like", value, "property0");
            return (Criteria) this;
        }

        public Criteria andProperty0In(List<String> values) {
            addCriterion("PROPERTY0 in", values, "property0");
            return (Criteria) this;
        }

        public Criteria andProperty0NotIn(List<String> values) {
            addCriterion("PROPERTY0 not in", values, "property0");
            return (Criteria) this;
        }

        public Criteria andProperty0Between(String value1, String value2) {
            addCriterion("PROPERTY0 between", value1, value2, "property0");
            return (Criteria) this;
        }

        public Criteria andProperty0NotBetween(String value1, String value2) {
            addCriterion("PROPERTY0 not between", value1, value2, "property0");
            return (Criteria) this;
        }

        public Criteria andProperty1IsNull() {
            addCriterion("PROPERTY1 is null");
            return (Criteria) this;
        }

        public Criteria andProperty1IsNotNull() {
            addCriterion("PROPERTY1 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty1EqualTo(String value) {
            addCriterion("PROPERTY1 =", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1NotEqualTo(String value) {
            addCriterion("PROPERTY1 <>", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1GreaterThan(String value) {
            addCriterion("PROPERTY1 >", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY1 >=", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1LessThan(String value) {
            addCriterion("PROPERTY1 <", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY1 <=", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1Like(String value) {
            addCriterion("PROPERTY1 like", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1NotLike(String value) {
            addCriterion("PROPERTY1 not like", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1In(List<String> values) {
            addCriterion("PROPERTY1 in", values, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1NotIn(List<String> values) {
            addCriterion("PROPERTY1 not in", values, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1Between(String value1, String value2) {
            addCriterion("PROPERTY1 between", value1, value2, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1NotBetween(String value1, String value2) {
            addCriterion("PROPERTY1 not between", value1, value2, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty2IsNull() {
            addCriterion("PROPERTY2 is null");
            return (Criteria) this;
        }

        public Criteria andProperty2IsNotNull() {
            addCriterion("PROPERTY2 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty2EqualTo(String value) {
            addCriterion("PROPERTY2 =", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2NotEqualTo(String value) {
            addCriterion("PROPERTY2 <>", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2GreaterThan(String value) {
            addCriterion("PROPERTY2 >", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY2 >=", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2LessThan(String value) {
            addCriterion("PROPERTY2 <", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY2 <=", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2Like(String value) {
            addCriterion("PROPERTY2 like", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2NotLike(String value) {
            addCriterion("PROPERTY2 not like", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2In(List<String> values) {
            addCriterion("PROPERTY2 in", values, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2NotIn(List<String> values) {
            addCriterion("PROPERTY2 not in", values, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2Between(String value1, String value2) {
            addCriterion("PROPERTY2 between", value1, value2, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2NotBetween(String value1, String value2) {
            addCriterion("PROPERTY2 not between", value1, value2, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty3IsNull() {
            addCriterion("PROPERTY3 is null");
            return (Criteria) this;
        }

        public Criteria andProperty3IsNotNull() {
            addCriterion("PROPERTY3 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty3EqualTo(String value) {
            addCriterion("PROPERTY3 =", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3NotEqualTo(String value) {
            addCriterion("PROPERTY3 <>", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3GreaterThan(String value) {
            addCriterion("PROPERTY3 >", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY3 >=", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3LessThan(String value) {
            addCriterion("PROPERTY3 <", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY3 <=", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3Like(String value) {
            addCriterion("PROPERTY3 like", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3NotLike(String value) {
            addCriterion("PROPERTY3 not like", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3In(List<String> values) {
            addCriterion("PROPERTY3 in", values, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3NotIn(List<String> values) {
            addCriterion("PROPERTY3 not in", values, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3Between(String value1, String value2) {
            addCriterion("PROPERTY3 between", value1, value2, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3NotBetween(String value1, String value2) {
            addCriterion("PROPERTY3 not between", value1, value2, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty4IsNull() {
            addCriterion("PROPERTY4 is null");
            return (Criteria) this;
        }

        public Criteria andProperty4IsNotNull() {
            addCriterion("PROPERTY4 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty4EqualTo(String value) {
            addCriterion("PROPERTY4 =", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4NotEqualTo(String value) {
            addCriterion("PROPERTY4 <>", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4GreaterThan(String value) {
            addCriterion("PROPERTY4 >", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY4 >=", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4LessThan(String value) {
            addCriterion("PROPERTY4 <", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY4 <=", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4Like(String value) {
            addCriterion("PROPERTY4 like", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4NotLike(String value) {
            addCriterion("PROPERTY4 not like", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4In(List<String> values) {
            addCriterion("PROPERTY4 in", values, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4NotIn(List<String> values) {
            addCriterion("PROPERTY4 not in", values, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4Between(String value1, String value2) {
            addCriterion("PROPERTY4 between", value1, value2, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4NotBetween(String value1, String value2) {
            addCriterion("PROPERTY4 not between", value1, value2, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty5IsNull() {
            addCriterion("PROPERTY5 is null");
            return (Criteria) this;
        }

        public Criteria andProperty5IsNotNull() {
            addCriterion("PROPERTY5 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty5EqualTo(String value) {
            addCriterion("PROPERTY5 =", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5NotEqualTo(String value) {
            addCriterion("PROPERTY5 <>", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5GreaterThan(String value) {
            addCriterion("PROPERTY5 >", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY5 >=", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5LessThan(String value) {
            addCriterion("PROPERTY5 <", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY5 <=", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5Like(String value) {
            addCriterion("PROPERTY5 like", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5NotLike(String value) {
            addCriterion("PROPERTY5 not like", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5In(List<String> values) {
            addCriterion("PROPERTY5 in", values, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5NotIn(List<String> values) {
            addCriterion("PROPERTY5 not in", values, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5Between(String value1, String value2) {
            addCriterion("PROPERTY5 between", value1, value2, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5NotBetween(String value1, String value2) {
            addCriterion("PROPERTY5 not between", value1, value2, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty6IsNull() {
            addCriterion("PROPERTY6 is null");
            return (Criteria) this;
        }

        public Criteria andProperty6IsNotNull() {
            addCriterion("PROPERTY6 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty6EqualTo(String value) {
            addCriterion("PROPERTY6 =", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6NotEqualTo(String value) {
            addCriterion("PROPERTY6 <>", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6GreaterThan(String value) {
            addCriterion("PROPERTY6 >", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY6 >=", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6LessThan(String value) {
            addCriterion("PROPERTY6 <", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY6 <=", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6Like(String value) {
            addCriterion("PROPERTY6 like", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6NotLike(String value) {
            addCriterion("PROPERTY6 not like", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6In(List<String> values) {
            addCriterion("PROPERTY6 in", values, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6NotIn(List<String> values) {
            addCriterion("PROPERTY6 not in", values, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6Between(String value1, String value2) {
            addCriterion("PROPERTY6 between", value1, value2, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6NotBetween(String value1, String value2) {
            addCriterion("PROPERTY6 not between", value1, value2, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty7IsNull() {
            addCriterion("PROPERTY7 is null");
            return (Criteria) this;
        }

        public Criteria andProperty7IsNotNull() {
            addCriterion("PROPERTY7 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty7EqualTo(String value) {
            addCriterion("PROPERTY7 =", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7NotEqualTo(String value) {
            addCriterion("PROPERTY7 <>", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7GreaterThan(String value) {
            addCriterion("PROPERTY7 >", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY7 >=", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7LessThan(String value) {
            addCriterion("PROPERTY7 <", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY7 <=", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7Like(String value) {
            addCriterion("PROPERTY7 like", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7NotLike(String value) {
            addCriterion("PROPERTY7 not like", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7In(List<String> values) {
            addCriterion("PROPERTY7 in", values, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7NotIn(List<String> values) {
            addCriterion("PROPERTY7 not in", values, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7Between(String value1, String value2) {
            addCriterion("PROPERTY7 between", value1, value2, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7NotBetween(String value1, String value2) {
            addCriterion("PROPERTY7 not between", value1, value2, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty8IsNull() {
            addCriterion("PROPERTY8 is null");
            return (Criteria) this;
        }

        public Criteria andProperty8IsNotNull() {
            addCriterion("PROPERTY8 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty8EqualTo(String value) {
            addCriterion("PROPERTY8 =", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8NotEqualTo(String value) {
            addCriterion("PROPERTY8 <>", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8GreaterThan(String value) {
            addCriterion("PROPERTY8 >", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY8 >=", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8LessThan(String value) {
            addCriterion("PROPERTY8 <", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY8 <=", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8Like(String value) {
            addCriterion("PROPERTY8 like", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8NotLike(String value) {
            addCriterion("PROPERTY8 not like", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8In(List<String> values) {
            addCriterion("PROPERTY8 in", values, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8NotIn(List<String> values) {
            addCriterion("PROPERTY8 not in", values, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8Between(String value1, String value2) {
            addCriterion("PROPERTY8 between", value1, value2, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8NotBetween(String value1, String value2) {
            addCriterion("PROPERTY8 not between", value1, value2, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty9IsNull() {
            addCriterion("PROPERTY9 is null");
            return (Criteria) this;
        }

        public Criteria andProperty9IsNotNull() {
            addCriterion("PROPERTY9 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty9EqualTo(String value) {
            addCriterion("PROPERTY9 =", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9NotEqualTo(String value) {
            addCriterion("PROPERTY9 <>", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9GreaterThan(String value) {
            addCriterion("PROPERTY9 >", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY9 >=", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9LessThan(String value) {
            addCriterion("PROPERTY9 <", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY9 <=", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9Like(String value) {
            addCriterion("PROPERTY9 like", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9NotLike(String value) {
            addCriterion("PROPERTY9 not like", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9In(List<String> values) {
            addCriterion("PROPERTY9 in", values, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9NotIn(List<String> values) {
            addCriterion("PROPERTY9 not in", values, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9Between(String value1, String value2) {
            addCriterion("PROPERTY9 between", value1, value2, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9NotBetween(String value1, String value2) {
            addCriterion("PROPERTY9 not between", value1, value2, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty10IsNull() {
            addCriterion("PROPERTY10 is null");
            return (Criteria) this;
        }

        public Criteria andProperty10IsNotNull() {
            addCriterion("PROPERTY10 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty10EqualTo(BigDecimal value) {
            addCriterion("PROPERTY10 =", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY10 <>", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY10 >", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY10 >=", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10LessThan(BigDecimal value) {
            addCriterion("PROPERTY10 <", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY10 <=", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10In(List<BigDecimal> values) {
            addCriterion("PROPERTY10 in", values, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY10 not in", values, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY10 between", value1, value2, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY10 not between", value1, value2, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty11IsNull() {
            addCriterion("PROPERTY11 is null");
            return (Criteria) this;
        }

        public Criteria andProperty11IsNotNull() {
            addCriterion("PROPERTY11 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty11EqualTo(BigDecimal value) {
            addCriterion("PROPERTY11 =", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY11 <>", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY11 >", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY11 >=", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11LessThan(BigDecimal value) {
            addCriterion("PROPERTY11 <", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY11 <=", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11In(List<BigDecimal> values) {
            addCriterion("PROPERTY11 in", values, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY11 not in", values, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY11 between", value1, value2, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY11 not between", value1, value2, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty12IsNull() {
            addCriterion("PROPERTY12 is null");
            return (Criteria) this;
        }

        public Criteria andProperty12IsNotNull() {
            addCriterion("PROPERTY12 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty12EqualTo(BigDecimal value) {
            addCriterion("PROPERTY12 =", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY12 <>", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY12 >", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY12 >=", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12LessThan(BigDecimal value) {
            addCriterion("PROPERTY12 <", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY12 <=", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12In(List<BigDecimal> values) {
            addCriterion("PROPERTY12 in", values, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY12 not in", values, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY12 between", value1, value2, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY12 not between", value1, value2, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty13IsNull() {
            addCriterion("PROPERTY13 is null");
            return (Criteria) this;
        }

        public Criteria andProperty13IsNotNull() {
            addCriterion("PROPERTY13 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty13EqualTo(BigDecimal value) {
            addCriterion("PROPERTY13 =", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY13 <>", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY13 >", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY13 >=", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13LessThan(BigDecimal value) {
            addCriterion("PROPERTY13 <", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY13 <=", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13In(List<BigDecimal> values) {
            addCriterion("PROPERTY13 in", values, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY13 not in", values, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY13 between", value1, value2, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY13 not between", value1, value2, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty14IsNull() {
            addCriterion("PROPERTY14 is null");
            return (Criteria) this;
        }

        public Criteria andProperty14IsNotNull() {
            addCriterion("PROPERTY14 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty14EqualTo(BigDecimal value) {
            addCriterion("PROPERTY14 =", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY14 <>", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY14 >", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY14 >=", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14LessThan(BigDecimal value) {
            addCriterion("PROPERTY14 <", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY14 <=", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14In(List<BigDecimal> values) {
            addCriterion("PROPERTY14 in", values, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY14 not in", values, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY14 between", value1, value2, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY14 not between", value1, value2, "property14");
            return (Criteria) this;
        }

        public Criteria andPrinfIsNull() {
            addCriterion("PRINF is null");
            return (Criteria) this;
        }

        public Criteria andPrinfIsNotNull() {
            addCriterion("PRINF is not null");
            return (Criteria) this;
        }

        public Criteria andPrinfEqualTo(String value) {
            addCriterion("PRINF =", value, "prinf");
            return (Criteria) this;
        }

        public Criteria andPrinfNotEqualTo(String value) {
            addCriterion("PRINF <>", value, "prinf");
            return (Criteria) this;
        }

        public Criteria andPrinfGreaterThan(String value) {
            addCriterion("PRINF >", value, "prinf");
            return (Criteria) this;
        }

        public Criteria andPrinfGreaterThanOrEqualTo(String value) {
            addCriterion("PRINF >=", value, "prinf");
            return (Criteria) this;
        }

        public Criteria andPrinfLessThan(String value) {
            addCriterion("PRINF <", value, "prinf");
            return (Criteria) this;
        }

        public Criteria andPrinfLessThanOrEqualTo(String value) {
            addCriterion("PRINF <=", value, "prinf");
            return (Criteria) this;
        }

        public Criteria andPrinfLike(String value) {
            addCriterion("PRINF like", value, "prinf");
            return (Criteria) this;
        }

        public Criteria andPrinfNotLike(String value) {
            addCriterion("PRINF not like", value, "prinf");
            return (Criteria) this;
        }

        public Criteria andPrinfIn(List<String> values) {
            addCriterion("PRINF in", values, "prinf");
            return (Criteria) this;
        }

        public Criteria andPrinfNotIn(List<String> values) {
            addCriterion("PRINF not in", values, "prinf");
            return (Criteria) this;
        }

        public Criteria andPrinfBetween(String value1, String value2) {
            addCriterion("PRINF between", value1, value2, "prinf");
            return (Criteria) this;
        }

        public Criteria andPrinfNotBetween(String value1, String value2) {
            addCriterion("PRINF not between", value1, value2, "prinf");
            return (Criteria) this;
        }

        public Criteria andPrexpIsNull() {
            addCriterion("PREXP is null");
            return (Criteria) this;
        }

        public Criteria andPrexpIsNotNull() {
            addCriterion("PREXP is not null");
            return (Criteria) this;
        }

        public Criteria andPrexpEqualTo(String value) {
            addCriterion("PREXP =", value, "prexp");
            return (Criteria) this;
        }

        public Criteria andPrexpNotEqualTo(String value) {
            addCriterion("PREXP <>", value, "prexp");
            return (Criteria) this;
        }

        public Criteria andPrexpGreaterThan(String value) {
            addCriterion("PREXP >", value, "prexp");
            return (Criteria) this;
        }

        public Criteria andPrexpGreaterThanOrEqualTo(String value) {
            addCriterion("PREXP >=", value, "prexp");
            return (Criteria) this;
        }

        public Criteria andPrexpLessThan(String value) {
            addCriterion("PREXP <", value, "prexp");
            return (Criteria) this;
        }

        public Criteria andPrexpLessThanOrEqualTo(String value) {
            addCriterion("PREXP <=", value, "prexp");
            return (Criteria) this;
        }

        public Criteria andPrexpLike(String value) {
            addCriterion("PREXP like", value, "prexp");
            return (Criteria) this;
        }

        public Criteria andPrexpNotLike(String value) {
            addCriterion("PREXP not like", value, "prexp");
            return (Criteria) this;
        }

        public Criteria andPrexpIn(List<String> values) {
            addCriterion("PREXP in", values, "prexp");
            return (Criteria) this;
        }

        public Criteria andPrexpNotIn(List<String> values) {
            addCriterion("PREXP not in", values, "prexp");
            return (Criteria) this;
        }

        public Criteria andPrexpBetween(String value1, String value2) {
            addCriterion("PREXP between", value1, value2, "prexp");
            return (Criteria) this;
        }

        public Criteria andPrexpNotBetween(String value1, String value2) {
            addCriterion("PREXP not between", value1, value2, "prexp");
            return (Criteria) this;
        }

        public Criteria andItimeIsNull() {
            addCriterion("ITIME is null");
            return (Criteria) this;
        }

        public Criteria andItimeIsNotNull() {
            addCriterion("ITIME is not null");
            return (Criteria) this;
        }

        public Criteria andItimeEqualTo(Date value) {
            addCriterion("ITIME =", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeNotEqualTo(Date value) {
            addCriterion("ITIME <>", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeGreaterThan(Date value) {
            addCriterion("ITIME >", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ITIME >=", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeLessThan(Date value) {
            addCriterion("ITIME <", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeLessThanOrEqualTo(Date value) {
            addCriterion("ITIME <=", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeIn(List<Date> values) {
            addCriterion("ITIME in", values, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeNotIn(List<Date> values) {
            addCriterion("ITIME not in", values, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeBetween(Date value1, Date value2) {
            addCriterion("ITIME between", value1, value2, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeNotBetween(Date value1, Date value2) {
            addCriterion("ITIME not between", value1, value2, "itime");
            return (Criteria) this;
        }

        public Criteria andIshiftIsNull() {
            addCriterion("ISHIFT is null");
            return (Criteria) this;
        }

        public Criteria andIshiftIsNotNull() {
            addCriterion("ISHIFT is not null");
            return (Criteria) this;
        }

        public Criteria andIshiftEqualTo(String value) {
            addCriterion("ISHIFT =", value, "ishift");
            return (Criteria) this;
        }

        public Criteria andIshiftNotEqualTo(String value) {
            addCriterion("ISHIFT <>", value, "ishift");
            return (Criteria) this;
        }

        public Criteria andIshiftGreaterThan(String value) {
            addCriterion("ISHIFT >", value, "ishift");
            return (Criteria) this;
        }

        public Criteria andIshiftGreaterThanOrEqualTo(String value) {
            addCriterion("ISHIFT >=", value, "ishift");
            return (Criteria) this;
        }

        public Criteria andIshiftLessThan(String value) {
            addCriterion("ISHIFT <", value, "ishift");
            return (Criteria) this;
        }

        public Criteria andIshiftLessThanOrEqualTo(String value) {
            addCriterion("ISHIFT <=", value, "ishift");
            return (Criteria) this;
        }

        public Criteria andIshiftLike(String value) {
            addCriterion("ISHIFT like", value, "ishift");
            return (Criteria) this;
        }

        public Criteria andIshiftNotLike(String value) {
            addCriterion("ISHIFT not like", value, "ishift");
            return (Criteria) this;
        }

        public Criteria andIshiftIn(List<String> values) {
            addCriterion("ISHIFT in", values, "ishift");
            return (Criteria) this;
        }

        public Criteria andIshiftNotIn(List<String> values) {
            addCriterion("ISHIFT not in", values, "ishift");
            return (Criteria) this;
        }

        public Criteria andIshiftBetween(String value1, String value2) {
            addCriterion("ISHIFT between", value1, value2, "ishift");
            return (Criteria) this;
        }

        public Criteria andIshiftNotBetween(String value1, String value2) {
            addCriterion("ISHIFT not between", value1, value2, "ishift");
            return (Criteria) this;
        }

        public Criteria andIgroupIsNull() {
            addCriterion("IGROUP is null");
            return (Criteria) this;
        }

        public Criteria andIgroupIsNotNull() {
            addCriterion("IGROUP is not null");
            return (Criteria) this;
        }

        public Criteria andIgroupEqualTo(String value) {
            addCriterion("IGROUP =", value, "igroup");
            return (Criteria) this;
        }

        public Criteria andIgroupNotEqualTo(String value) {
            addCriterion("IGROUP <>", value, "igroup");
            return (Criteria) this;
        }

        public Criteria andIgroupGreaterThan(String value) {
            addCriterion("IGROUP >", value, "igroup");
            return (Criteria) this;
        }

        public Criteria andIgroupGreaterThanOrEqualTo(String value) {
            addCriterion("IGROUP >=", value, "igroup");
            return (Criteria) this;
        }

        public Criteria andIgroupLessThan(String value) {
            addCriterion("IGROUP <", value, "igroup");
            return (Criteria) this;
        }

        public Criteria andIgroupLessThanOrEqualTo(String value) {
            addCriterion("IGROUP <=", value, "igroup");
            return (Criteria) this;
        }

        public Criteria andIgroupLike(String value) {
            addCriterion("IGROUP like", value, "igroup");
            return (Criteria) this;
        }

        public Criteria andIgroupNotLike(String value) {
            addCriterion("IGROUP not like", value, "igroup");
            return (Criteria) this;
        }

        public Criteria andIgroupIn(List<String> values) {
            addCriterion("IGROUP in", values, "igroup");
            return (Criteria) this;
        }

        public Criteria andIgroupNotIn(List<String> values) {
            addCriterion("IGROUP not in", values, "igroup");
            return (Criteria) this;
        }

        public Criteria andIgroupBetween(String value1, String value2) {
            addCriterion("IGROUP between", value1, value2, "igroup");
            return (Criteria) this;
        }

        public Criteria andIgroupNotBetween(String value1, String value2) {
            addCriterion("IGROUP not between", value1, value2, "igroup");
            return (Criteria) this;
        }

        public Criteria andIpersonIsNull() {
            addCriterion("IPERSON is null");
            return (Criteria) this;
        }

        public Criteria andIpersonIsNotNull() {
            addCriterion("IPERSON is not null");
            return (Criteria) this;
        }

        public Criteria andIpersonEqualTo(Integer value) {
            addCriterion("IPERSON =", value, "iperson");
            return (Criteria) this;
        }

        public Criteria andIpersonNotEqualTo(Integer value) {
            addCriterion("IPERSON <>", value, "iperson");
            return (Criteria) this;
        }

        public Criteria andIpersonGreaterThan(Integer value) {
            addCriterion("IPERSON >", value, "iperson");
            return (Criteria) this;
        }

        public Criteria andIpersonGreaterThanOrEqualTo(Integer value) {
            addCriterion("IPERSON >=", value, "iperson");
            return (Criteria) this;
        }

        public Criteria andIpersonLessThan(Integer value) {
            addCriterion("IPERSON <", value, "iperson");
            return (Criteria) this;
        }

        public Criteria andIpersonLessThanOrEqualTo(Integer value) {
            addCriterion("IPERSON <=", value, "iperson");
            return (Criteria) this;
        }

        public Criteria andIpersonIn(List<Integer> values) {
            addCriterion("IPERSON in", values, "iperson");
            return (Criteria) this;
        }

        public Criteria andIpersonNotIn(List<Integer> values) {
            addCriterion("IPERSON not in", values, "iperson");
            return (Criteria) this;
        }

        public Criteria andIpersonBetween(Integer value1, Integer value2) {
            addCriterion("IPERSON between", value1, value2, "iperson");
            return (Criteria) this;
        }

        public Criteria andIpersonNotBetween(Integer value1, Integer value2) {
            addCriterion("IPERSON not between", value1, value2, "iperson");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNull() {
            addCriterion("UTIME is null");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNotNull() {
            addCriterion("UTIME is not null");
            return (Criteria) this;
        }

        public Criteria andUtimeEqualTo(Date value) {
            addCriterion("UTIME =", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotEqualTo(Date value) {
            addCriterion("UTIME <>", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThan(Date value) {
            addCriterion("UTIME >", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UTIME >=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThan(Date value) {
            addCriterion("UTIME <", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThanOrEqualTo(Date value) {
            addCriterion("UTIME <=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeIn(List<Date> values) {
            addCriterion("UTIME in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotIn(List<Date> values) {
            addCriterion("UTIME not in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeBetween(Date value1, Date value2) {
            addCriterion("UTIME between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotBetween(Date value1, Date value2) {
            addCriterion("UTIME not between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andUshiftIsNull() {
            addCriterion("USHIFT is null");
            return (Criteria) this;
        }

        public Criteria andUshiftIsNotNull() {
            addCriterion("USHIFT is not null");
            return (Criteria) this;
        }

        public Criteria andUshiftEqualTo(String value) {
            addCriterion("USHIFT =", value, "ushift");
            return (Criteria) this;
        }

        public Criteria andUshiftNotEqualTo(String value) {
            addCriterion("USHIFT <>", value, "ushift");
            return (Criteria) this;
        }

        public Criteria andUshiftGreaterThan(String value) {
            addCriterion("USHIFT >", value, "ushift");
            return (Criteria) this;
        }

        public Criteria andUshiftGreaterThanOrEqualTo(String value) {
            addCriterion("USHIFT >=", value, "ushift");
            return (Criteria) this;
        }

        public Criteria andUshiftLessThan(String value) {
            addCriterion("USHIFT <", value, "ushift");
            return (Criteria) this;
        }

        public Criteria andUshiftLessThanOrEqualTo(String value) {
            addCriterion("USHIFT <=", value, "ushift");
            return (Criteria) this;
        }

        public Criteria andUshiftLike(String value) {
            addCriterion("USHIFT like", value, "ushift");
            return (Criteria) this;
        }

        public Criteria andUshiftNotLike(String value) {
            addCriterion("USHIFT not like", value, "ushift");
            return (Criteria) this;
        }

        public Criteria andUshiftIn(List<String> values) {
            addCriterion("USHIFT in", values, "ushift");
            return (Criteria) this;
        }

        public Criteria andUshiftNotIn(List<String> values) {
            addCriterion("USHIFT not in", values, "ushift");
            return (Criteria) this;
        }

        public Criteria andUshiftBetween(String value1, String value2) {
            addCriterion("USHIFT between", value1, value2, "ushift");
            return (Criteria) this;
        }

        public Criteria andUshiftNotBetween(String value1, String value2) {
            addCriterion("USHIFT not between", value1, value2, "ushift");
            return (Criteria) this;
        }

        public Criteria andUgroupIsNull() {
            addCriterion("UGROUP is null");
            return (Criteria) this;
        }

        public Criteria andUgroupIsNotNull() {
            addCriterion("UGROUP is not null");
            return (Criteria) this;
        }

        public Criteria andUgroupEqualTo(String value) {
            addCriterion("UGROUP =", value, "ugroup");
            return (Criteria) this;
        }

        public Criteria andUgroupNotEqualTo(String value) {
            addCriterion("UGROUP <>", value, "ugroup");
            return (Criteria) this;
        }

        public Criteria andUgroupGreaterThan(String value) {
            addCriterion("UGROUP >", value, "ugroup");
            return (Criteria) this;
        }

        public Criteria andUgroupGreaterThanOrEqualTo(String value) {
            addCriterion("UGROUP >=", value, "ugroup");
            return (Criteria) this;
        }

        public Criteria andUgroupLessThan(String value) {
            addCriterion("UGROUP <", value, "ugroup");
            return (Criteria) this;
        }

        public Criteria andUgroupLessThanOrEqualTo(String value) {
            addCriterion("UGROUP <=", value, "ugroup");
            return (Criteria) this;
        }

        public Criteria andUgroupLike(String value) {
            addCriterion("UGROUP like", value, "ugroup");
            return (Criteria) this;
        }

        public Criteria andUgroupNotLike(String value) {
            addCriterion("UGROUP not like", value, "ugroup");
            return (Criteria) this;
        }

        public Criteria andUgroupIn(List<String> values) {
            addCriterion("UGROUP in", values, "ugroup");
            return (Criteria) this;
        }

        public Criteria andUgroupNotIn(List<String> values) {
            addCriterion("UGROUP not in", values, "ugroup");
            return (Criteria) this;
        }

        public Criteria andUgroupBetween(String value1, String value2) {
            addCriterion("UGROUP between", value1, value2, "ugroup");
            return (Criteria) this;
        }

        public Criteria andUgroupNotBetween(String value1, String value2) {
            addCriterion("UGROUP not between", value1, value2, "ugroup");
            return (Criteria) this;
        }

        public Criteria andUpersonIsNull() {
            addCriterion("UPERSON is null");
            return (Criteria) this;
        }

        public Criteria andUpersonIsNotNull() {
            addCriterion("UPERSON is not null");
            return (Criteria) this;
        }

        public Criteria andUpersonEqualTo(Integer value) {
            addCriterion("UPERSON =", value, "uperson");
            return (Criteria) this;
        }

        public Criteria andUpersonNotEqualTo(Integer value) {
            addCriterion("UPERSON <>", value, "uperson");
            return (Criteria) this;
        }

        public Criteria andUpersonGreaterThan(Integer value) {
            addCriterion("UPERSON >", value, "uperson");
            return (Criteria) this;
        }

        public Criteria andUpersonGreaterThanOrEqualTo(Integer value) {
            addCriterion("UPERSON >=", value, "uperson");
            return (Criteria) this;
        }

        public Criteria andUpersonLessThan(Integer value) {
            addCriterion("UPERSON <", value, "uperson");
            return (Criteria) this;
        }

        public Criteria andUpersonLessThanOrEqualTo(Integer value) {
            addCriterion("UPERSON <=", value, "uperson");
            return (Criteria) this;
        }

        public Criteria andUpersonIn(List<Integer> values) {
            addCriterion("UPERSON in", values, "uperson");
            return (Criteria) this;
        }

        public Criteria andUpersonNotIn(List<Integer> values) {
            addCriterion("UPERSON not in", values, "uperson");
            return (Criteria) this;
        }

        public Criteria andUpersonBetween(Integer value1, Integer value2) {
            addCriterion("UPERSON between", value1, value2, "uperson");
            return (Criteria) this;
        }

        public Criteria andUpersonNotBetween(Integer value1, Integer value2) {
            addCriterion("UPERSON not between", value1, value2, "uperson");
            return (Criteria) this;
        }

        public Criteria andUfromIsNull() {
            addCriterion("UFROM is null");
            return (Criteria) this;
        }

        public Criteria andUfromIsNotNull() {
            addCriterion("UFROM is not null");
            return (Criteria) this;
        }

        public Criteria andUfromEqualTo(String value) {
            addCriterion("UFROM =", value, "ufrom");
            return (Criteria) this;
        }

        public Criteria andUfromNotEqualTo(String value) {
            addCriterion("UFROM <>", value, "ufrom");
            return (Criteria) this;
        }

        public Criteria andUfromGreaterThan(String value) {
            addCriterion("UFROM >", value, "ufrom");
            return (Criteria) this;
        }

        public Criteria andUfromGreaterThanOrEqualTo(String value) {
            addCriterion("UFROM >=", value, "ufrom");
            return (Criteria) this;
        }

        public Criteria andUfromLessThan(String value) {
            addCriterion("UFROM <", value, "ufrom");
            return (Criteria) this;
        }

        public Criteria andUfromLessThanOrEqualTo(String value) {
            addCriterion("UFROM <=", value, "ufrom");
            return (Criteria) this;
        }

        public Criteria andUfromLike(String value) {
            addCriterion("UFROM like", value, "ufrom");
            return (Criteria) this;
        }

        public Criteria andUfromNotLike(String value) {
            addCriterion("UFROM not like", value, "ufrom");
            return (Criteria) this;
        }

        public Criteria andUfromIn(List<String> values) {
            addCriterion("UFROM in", values, "ufrom");
            return (Criteria) this;
        }

        public Criteria andUfromNotIn(List<String> values) {
            addCriterion("UFROM not in", values, "ufrom");
            return (Criteria) this;
        }

        public Criteria andUfromBetween(String value1, String value2) {
            addCriterion("UFROM between", value1, value2, "ufrom");
            return (Criteria) this;
        }

        public Criteria andUfromNotBetween(String value1, String value2) {
            addCriterion("UFROM not between", value1, value2, "ufrom");
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