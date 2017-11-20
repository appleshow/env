package com.aps.env.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HbEnterpriseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HbEnterpriseExample() {
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

        public Criteria andEnterpriseIdIsNull() {
            addCriterion("ENTERPRISE_ID is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNotNull() {
            addCriterion("ENTERPRISE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdEqualTo(Integer value) {
            addCriterion("ENTERPRISE_ID =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(Integer value) {
            addCriterion("ENTERPRISE_ID <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(Integer value) {
            addCriterion("ENTERPRISE_ID >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ENTERPRISE_ID >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(Integer value) {
            addCriterion("ENTERPRISE_ID <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(Integer value) {
            addCriterion("ENTERPRISE_ID <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<Integer> values) {
            addCriterion("ENTERPRISE_ID in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<Integer> values) {
            addCriterion("ENTERPRISE_ID not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(Integer value1, Integer value2) {
            addCriterion("ENTERPRISE_ID between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ENTERPRISE_ID not between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNull() {
            addCriterion("ENTERPRISE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNotNull() {
            addCriterion("ENTERPRISE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameEqualTo(String value) {
            addCriterion("ENTERPRISE_NAME =", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotEqualTo(String value) {
            addCriterion("ENTERPRISE_NAME <>", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThan(String value) {
            addCriterion("ENTERPRISE_NAME >", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_NAME >=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThan(String value) {
            addCriterion("ENTERPRISE_NAME <", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_NAME <=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLike(String value) {
            addCriterion("ENTERPRISE_NAME like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotLike(String value) {
            addCriterion("ENTERPRISE_NAME not like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIn(List<String> values) {
            addCriterion("ENTERPRISE_NAME in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotIn(List<String> values) {
            addCriterion("ENTERPRISE_NAME not in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_NAME between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_NAME not between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionIsNull() {
            addCriterion("ENTERPRISE_REGION is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionIsNotNull() {
            addCriterion("ENTERPRISE_REGION is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionEqualTo(String value) {
            addCriterion("ENTERPRISE_REGION =", value, "enterpriseRegion");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionNotEqualTo(String value) {
            addCriterion("ENTERPRISE_REGION <>", value, "enterpriseRegion");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionGreaterThan(String value) {
            addCriterion("ENTERPRISE_REGION >", value, "enterpriseRegion");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_REGION >=", value, "enterpriseRegion");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionLessThan(String value) {
            addCriterion("ENTERPRISE_REGION <", value, "enterpriseRegion");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_REGION <=", value, "enterpriseRegion");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionLike(String value) {
            addCriterion("ENTERPRISE_REGION like", value, "enterpriseRegion");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionNotLike(String value) {
            addCriterion("ENTERPRISE_REGION not like", value, "enterpriseRegion");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionIn(List<String> values) {
            addCriterion("ENTERPRISE_REGION in", values, "enterpriseRegion");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionNotIn(List<String> values) {
            addCriterion("ENTERPRISE_REGION not in", values, "enterpriseRegion");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_REGION between", value1, value2, "enterpriseRegion");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegionNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_REGION not between", value1, value2, "enterpriseRegion");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIsNull() {
            addCriterion("ENTERPRISE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIsNotNull() {
            addCriterion("ENTERPRISE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeEqualTo(Integer value) {
            addCriterion("ENTERPRISE_TYPE =", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotEqualTo(Integer value) {
            addCriterion("ENTERPRISE_TYPE <>", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThan(Integer value) {
            addCriterion("ENTERPRISE_TYPE >", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ENTERPRISE_TYPE >=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThan(Integer value) {
            addCriterion("ENTERPRISE_TYPE <", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ENTERPRISE_TYPE <=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIn(List<Integer> values) {
            addCriterion("ENTERPRISE_TYPE in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotIn(List<Integer> values) {
            addCriterion("ENTERPRISE_TYPE not in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeBetween(Integer value1, Integer value2) {
            addCriterion("ENTERPRISE_TYPE between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ENTERPRISE_TYPE not between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTradeIsNull() {
            addCriterion("ENTERPRISE_TRADE is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTradeIsNotNull() {
            addCriterion("ENTERPRISE_TRADE is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTradeEqualTo(Integer value) {
            addCriterion("ENTERPRISE_TRADE =", value, "enterpriseTrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTradeNotEqualTo(Integer value) {
            addCriterion("ENTERPRISE_TRADE <>", value, "enterpriseTrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTradeGreaterThan(Integer value) {
            addCriterion("ENTERPRISE_TRADE >", value, "enterpriseTrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ENTERPRISE_TRADE >=", value, "enterpriseTrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTradeLessThan(Integer value) {
            addCriterion("ENTERPRISE_TRADE <", value, "enterpriseTrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTradeLessThanOrEqualTo(Integer value) {
            addCriterion("ENTERPRISE_TRADE <=", value, "enterpriseTrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTradeIn(List<Integer> values) {
            addCriterion("ENTERPRISE_TRADE in", values, "enterpriseTrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTradeNotIn(List<Integer> values) {
            addCriterion("ENTERPRISE_TRADE not in", values, "enterpriseTrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTradeBetween(Integer value1, Integer value2) {
            addCriterion("ENTERPRISE_TRADE between", value1, value2, "enterpriseTrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTradeNotBetween(Integer value1, Integer value2) {
            addCriterion("ENTERPRISE_TRADE not between", value1, value2, "enterpriseTrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressIsNull() {
            addCriterion("ENTERPRISE_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressIsNotNull() {
            addCriterion("ENTERPRISE_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressEqualTo(String value) {
            addCriterion("ENTERPRISE_ADDRESS =", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressNotEqualTo(String value) {
            addCriterion("ENTERPRISE_ADDRESS <>", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressGreaterThan(String value) {
            addCriterion("ENTERPRISE_ADDRESS >", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_ADDRESS >=", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressLessThan(String value) {
            addCriterion("ENTERPRISE_ADDRESS <", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_ADDRESS <=", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressLike(String value) {
            addCriterion("ENTERPRISE_ADDRESS like", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressNotLike(String value) {
            addCriterion("ENTERPRISE_ADDRESS not like", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressIn(List<String> values) {
            addCriterion("ENTERPRISE_ADDRESS in", values, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressNotIn(List<String> values) {
            addCriterion("ENTERPRISE_ADDRESS not in", values, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_ADDRESS between", value1, value2, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_ADDRESS not between", value1, value2, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneIsNull() {
            addCriterion("ENTERPRISE_LEGAL_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneIsNotNull() {
            addCriterion("ENTERPRISE_LEGAL_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneEqualTo(String value) {
            addCriterion("ENTERPRISE_LEGAL_PHONE =", value, "enterpriseLegalPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneNotEqualTo(String value) {
            addCriterion("ENTERPRISE_LEGAL_PHONE <>", value, "enterpriseLegalPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneGreaterThan(String value) {
            addCriterion("ENTERPRISE_LEGAL_PHONE >", value, "enterpriseLegalPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_LEGAL_PHONE >=", value, "enterpriseLegalPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneLessThan(String value) {
            addCriterion("ENTERPRISE_LEGAL_PHONE <", value, "enterpriseLegalPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_LEGAL_PHONE <=", value, "enterpriseLegalPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneLike(String value) {
            addCriterion("ENTERPRISE_LEGAL_PHONE like", value, "enterpriseLegalPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneNotLike(String value) {
            addCriterion("ENTERPRISE_LEGAL_PHONE not like", value, "enterpriseLegalPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneIn(List<String> values) {
            addCriterion("ENTERPRISE_LEGAL_PHONE in", values, "enterpriseLegalPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneNotIn(List<String> values) {
            addCriterion("ENTERPRISE_LEGAL_PHONE not in", values, "enterpriseLegalPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_LEGAL_PHONE between", value1, value2, "enterpriseLegalPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPhoneNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_LEGAL_PHONE not between", value1, value2, "enterpriseLegalPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonIsNull() {
            addCriterion("ENTERPRISE_ENV_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonIsNotNull() {
            addCriterion("ENTERPRISE_ENV_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonEqualTo(String value) {
            addCriterion("ENTERPRISE_ENV_PERSON =", value, "enterpriseEnvPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonNotEqualTo(String value) {
            addCriterion("ENTERPRISE_ENV_PERSON <>", value, "enterpriseEnvPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonGreaterThan(String value) {
            addCriterion("ENTERPRISE_ENV_PERSON >", value, "enterpriseEnvPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_ENV_PERSON >=", value, "enterpriseEnvPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonLessThan(String value) {
            addCriterion("ENTERPRISE_ENV_PERSON <", value, "enterpriseEnvPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_ENV_PERSON <=", value, "enterpriseEnvPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonLike(String value) {
            addCriterion("ENTERPRISE_ENV_PERSON like", value, "enterpriseEnvPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonNotLike(String value) {
            addCriterion("ENTERPRISE_ENV_PERSON not like", value, "enterpriseEnvPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonIn(List<String> values) {
            addCriterion("ENTERPRISE_ENV_PERSON in", values, "enterpriseEnvPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonNotIn(List<String> values) {
            addCriterion("ENTERPRISE_ENV_PERSON not in", values, "enterpriseEnvPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_ENV_PERSON between", value1, value2, "enterpriseEnvPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPersonNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_ENV_PERSON not between", value1, value2, "enterpriseEnvPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneIsNull() {
            addCriterion("ENTERPRISE_ENV_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneIsNotNull() {
            addCriterion("ENTERPRISE_ENV_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneEqualTo(String value) {
            addCriterion("ENTERPRISE_ENV_PHONE =", value, "enterpriseEnvPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneNotEqualTo(String value) {
            addCriterion("ENTERPRISE_ENV_PHONE <>", value, "enterpriseEnvPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneGreaterThan(String value) {
            addCriterion("ENTERPRISE_ENV_PHONE >", value, "enterpriseEnvPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_ENV_PHONE >=", value, "enterpriseEnvPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneLessThan(String value) {
            addCriterion("ENTERPRISE_ENV_PHONE <", value, "enterpriseEnvPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_ENV_PHONE <=", value, "enterpriseEnvPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneLike(String value) {
            addCriterion("ENTERPRISE_ENV_PHONE like", value, "enterpriseEnvPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneNotLike(String value) {
            addCriterion("ENTERPRISE_ENV_PHONE not like", value, "enterpriseEnvPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneIn(List<String> values) {
            addCriterion("ENTERPRISE_ENV_PHONE in", values, "enterpriseEnvPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneNotIn(List<String> values) {
            addCriterion("ENTERPRISE_ENV_PHONE not in", values, "enterpriseEnvPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_ENV_PHONE between", value1, value2, "enterpriseEnvPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEnvPhoneNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_ENV_PHONE not between", value1, value2, "enterpriseEnvPhone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonIsNull() {
            addCriterion("ENTERPRISE_LEGAL_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonIsNotNull() {
            addCriterion("ENTERPRISE_LEGAL_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonEqualTo(String value) {
            addCriterion("ENTERPRISE_LEGAL_PERSON =", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonNotEqualTo(String value) {
            addCriterion("ENTERPRISE_LEGAL_PERSON <>", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonGreaterThan(String value) {
            addCriterion("ENTERPRISE_LEGAL_PERSON >", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_LEGAL_PERSON >=", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonLessThan(String value) {
            addCriterion("ENTERPRISE_LEGAL_PERSON <", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_LEGAL_PERSON <=", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonLike(String value) {
            addCriterion("ENTERPRISE_LEGAL_PERSON like", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonNotLike(String value) {
            addCriterion("ENTERPRISE_LEGAL_PERSON not like", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonIn(List<String> values) {
            addCriterion("ENTERPRISE_LEGAL_PERSON in", values, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonNotIn(List<String> values) {
            addCriterion("ENTERPRISE_LEGAL_PERSON not in", values, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_LEGAL_PERSON between", value1, value2, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_LEGAL_PERSON not between", value1, value2, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelIsNull() {
            addCriterion("ENTERPRISE_CML_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelIsNotNull() {
            addCriterion("ENTERPRISE_CML_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelEqualTo(String value) {
            addCriterion("ENTERPRISE_CML_LEVEL =", value, "enterpriseCmlLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelNotEqualTo(String value) {
            addCriterion("ENTERPRISE_CML_LEVEL <>", value, "enterpriseCmlLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelGreaterThan(String value) {
            addCriterion("ENTERPRISE_CML_LEVEL >", value, "enterpriseCmlLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_CML_LEVEL >=", value, "enterpriseCmlLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelLessThan(String value) {
            addCriterion("ENTERPRISE_CML_LEVEL <", value, "enterpriseCmlLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_CML_LEVEL <=", value, "enterpriseCmlLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelLike(String value) {
            addCriterion("ENTERPRISE_CML_LEVEL like", value, "enterpriseCmlLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelNotLike(String value) {
            addCriterion("ENTERPRISE_CML_LEVEL not like", value, "enterpriseCmlLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelIn(List<String> values) {
            addCriterion("ENTERPRISE_CML_LEVEL in", values, "enterpriseCmlLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelNotIn(List<String> values) {
            addCriterion("ENTERPRISE_CML_LEVEL not in", values, "enterpriseCmlLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_CML_LEVEL between", value1, value2, "enterpriseCmlLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlLevelNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_CML_LEVEL not between", value1, value2, "enterpriseCmlLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeIsNull() {
            addCriterion("ENTERPRISE_CML_GRADE is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeIsNotNull() {
            addCriterion("ENTERPRISE_CML_GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeEqualTo(String value) {
            addCriterion("ENTERPRISE_CML_GRADE =", value, "enterpriseCmlGrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeNotEqualTo(String value) {
            addCriterion("ENTERPRISE_CML_GRADE <>", value, "enterpriseCmlGrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeGreaterThan(String value) {
            addCriterion("ENTERPRISE_CML_GRADE >", value, "enterpriseCmlGrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_CML_GRADE >=", value, "enterpriseCmlGrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeLessThan(String value) {
            addCriterion("ENTERPRISE_CML_GRADE <", value, "enterpriseCmlGrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_CML_GRADE <=", value, "enterpriseCmlGrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeLike(String value) {
            addCriterion("ENTERPRISE_CML_GRADE like", value, "enterpriseCmlGrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeNotLike(String value) {
            addCriterion("ENTERPRISE_CML_GRADE not like", value, "enterpriseCmlGrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeIn(List<String> values) {
            addCriterion("ENTERPRISE_CML_GRADE in", values, "enterpriseCmlGrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeNotIn(List<String> values) {
            addCriterion("ENTERPRISE_CML_GRADE not in", values, "enterpriseCmlGrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_CML_GRADE between", value1, value2, "enterpriseCmlGrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlGradeNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_CML_GRADE not between", value1, value2, "enterpriseCmlGrade");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlAmountIsNull() {
            addCriterion("ENTERPRISE_CML_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlAmountIsNotNull() {
            addCriterion("ENTERPRISE_CML_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlAmountEqualTo(BigDecimal value) {
            addCriterion("ENTERPRISE_CML_AMOUNT =", value, "enterpriseCmlAmount");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlAmountNotEqualTo(BigDecimal value) {
            addCriterion("ENTERPRISE_CML_AMOUNT <>", value, "enterpriseCmlAmount");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlAmountGreaterThan(BigDecimal value) {
            addCriterion("ENTERPRISE_CML_AMOUNT >", value, "enterpriseCmlAmount");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENTERPRISE_CML_AMOUNT >=", value, "enterpriseCmlAmount");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlAmountLessThan(BigDecimal value) {
            addCriterion("ENTERPRISE_CML_AMOUNT <", value, "enterpriseCmlAmount");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENTERPRISE_CML_AMOUNT <=", value, "enterpriseCmlAmount");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlAmountIn(List<BigDecimal> values) {
            addCriterion("ENTERPRISE_CML_AMOUNT in", values, "enterpriseCmlAmount");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlAmountNotIn(List<BigDecimal> values) {
            addCriterion("ENTERPRISE_CML_AMOUNT not in", values, "enterpriseCmlAmount");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENTERPRISE_CML_AMOUNT between", value1, value2, "enterpriseCmlAmount");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCmlAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENTERPRISE_CML_AMOUNT not between", value1, value2, "enterpriseCmlAmount");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlIsNull() {
            addCriterion("ENTERPRISE_URL is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlIsNotNull() {
            addCriterion("ENTERPRISE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlEqualTo(String value) {
            addCriterion("ENTERPRISE_URL =", value, "enterpriseUrl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlNotEqualTo(String value) {
            addCriterion("ENTERPRISE_URL <>", value, "enterpriseUrl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlGreaterThan(String value) {
            addCriterion("ENTERPRISE_URL >", value, "enterpriseUrl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_URL >=", value, "enterpriseUrl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlLessThan(String value) {
            addCriterion("ENTERPRISE_URL <", value, "enterpriseUrl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_URL <=", value, "enterpriseUrl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlLike(String value) {
            addCriterion("ENTERPRISE_URL like", value, "enterpriseUrl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlNotLike(String value) {
            addCriterion("ENTERPRISE_URL not like", value, "enterpriseUrl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlIn(List<String> values) {
            addCriterion("ENTERPRISE_URL in", values, "enterpriseUrl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlNotIn(List<String> values) {
            addCriterion("ENTERPRISE_URL not in", values, "enterpriseUrl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_URL between", value1, value2, "enterpriseUrl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUrlNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_URL not between", value1, value2, "enterpriseUrl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescIsNull() {
            addCriterion("ENTERPRISE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescIsNotNull() {
            addCriterion("ENTERPRISE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescEqualTo(String value) {
            addCriterion("ENTERPRISE_DESC =", value, "enterpriseDesc");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescNotEqualTo(String value) {
            addCriterion("ENTERPRISE_DESC <>", value, "enterpriseDesc");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescGreaterThan(String value) {
            addCriterion("ENTERPRISE_DESC >", value, "enterpriseDesc");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_DESC >=", value, "enterpriseDesc");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescLessThan(String value) {
            addCriterion("ENTERPRISE_DESC <", value, "enterpriseDesc");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_DESC <=", value, "enterpriseDesc");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescLike(String value) {
            addCriterion("ENTERPRISE_DESC like", value, "enterpriseDesc");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescNotLike(String value) {
            addCriterion("ENTERPRISE_DESC not like", value, "enterpriseDesc");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescIn(List<String> values) {
            addCriterion("ENTERPRISE_DESC in", values, "enterpriseDesc");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescNotIn(List<String> values) {
            addCriterion("ENTERPRISE_DESC not in", values, "enterpriseDesc");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_DESC between", value1, value2, "enterpriseDesc");
            return (Criteria) this;
        }

        public Criteria andEnterpriseDescNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_DESC not between", value1, value2, "enterpriseDesc");
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