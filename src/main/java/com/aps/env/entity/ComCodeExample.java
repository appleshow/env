package com.aps.env.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComCodeExample() {
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

        public Criteria andCodeTypeIsNull() {
            addCriterion("CODE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIsNotNull() {
            addCriterion("CODE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeTypeEqualTo(String value) {
            addCriterion("CODE_TYPE =", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNotEqualTo(String value) {
            addCriterion("CODE_TYPE <>", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeGreaterThan(String value) {
            addCriterion("CODE_TYPE >", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE_TYPE >=", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeLessThan(String value) {
            addCriterion("CODE_TYPE <", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeLessThanOrEqualTo(String value) {
            addCriterion("CODE_TYPE <=", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeLike(String value) {
            addCriterion("CODE_TYPE like", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNotLike(String value) {
            addCriterion("CODE_TYPE not like", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIn(List<String> values) {
            addCriterion("CODE_TYPE in", values, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNotIn(List<String> values) {
            addCriterion("CODE_TYPE not in", values, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeBetween(String value1, String value2) {
            addCriterion("CODE_TYPE between", value1, value2, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNotBetween(String value1, String value2) {
            addCriterion("CODE_TYPE not between", value1, value2, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeValueIsNull() {
            addCriterion("CODE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andCodeValueIsNotNull() {
            addCriterion("CODE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeValueEqualTo(String value) {
            addCriterion("CODE_VALUE =", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueNotEqualTo(String value) {
            addCriterion("CODE_VALUE <>", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueGreaterThan(String value) {
            addCriterion("CODE_VALUE >", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueGreaterThanOrEqualTo(String value) {
            addCriterion("CODE_VALUE >=", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueLessThan(String value) {
            addCriterion("CODE_VALUE <", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueLessThanOrEqualTo(String value) {
            addCriterion("CODE_VALUE <=", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueLike(String value) {
            addCriterion("CODE_VALUE like", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueNotLike(String value) {
            addCriterion("CODE_VALUE not like", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueIn(List<String> values) {
            addCriterion("CODE_VALUE in", values, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueNotIn(List<String> values) {
            addCriterion("CODE_VALUE not in", values, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueBetween(String value1, String value2) {
            addCriterion("CODE_VALUE between", value1, value2, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueNotBetween(String value1, String value2) {
            addCriterion("CODE_VALUE not between", value1, value2, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeNameIsNull() {
            addCriterion("CODE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCodeNameIsNotNull() {
            addCriterion("CODE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCodeNameEqualTo(String value) {
            addCriterion("CODE_NAME =", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameNotEqualTo(String value) {
            addCriterion("CODE_NAME <>", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameGreaterThan(String value) {
            addCriterion("CODE_NAME >", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("CODE_NAME >=", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameLessThan(String value) {
            addCriterion("CODE_NAME <", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameLessThanOrEqualTo(String value) {
            addCriterion("CODE_NAME <=", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameLike(String value) {
            addCriterion("CODE_NAME like", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameNotLike(String value) {
            addCriterion("CODE_NAME not like", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameIn(List<String> values) {
            addCriterion("CODE_NAME in", values, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameNotIn(List<String> values) {
            addCriterion("CODE_NAME not in", values, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameBetween(String value1, String value2) {
            addCriterion("CODE_NAME between", value1, value2, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameNotBetween(String value1, String value2) {
            addCriterion("CODE_NAME not between", value1, value2, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeName1IsNull() {
            addCriterion("CODE_NAME1 is null");
            return (Criteria) this;
        }

        public Criteria andCodeName1IsNotNull() {
            addCriterion("CODE_NAME1 is not null");
            return (Criteria) this;
        }

        public Criteria andCodeName1EqualTo(String value) {
            addCriterion("CODE_NAME1 =", value, "codeName1");
            return (Criteria) this;
        }

        public Criteria andCodeName1NotEqualTo(String value) {
            addCriterion("CODE_NAME1 <>", value, "codeName1");
            return (Criteria) this;
        }

        public Criteria andCodeName1GreaterThan(String value) {
            addCriterion("CODE_NAME1 >", value, "codeName1");
            return (Criteria) this;
        }

        public Criteria andCodeName1GreaterThanOrEqualTo(String value) {
            addCriterion("CODE_NAME1 >=", value, "codeName1");
            return (Criteria) this;
        }

        public Criteria andCodeName1LessThan(String value) {
            addCriterion("CODE_NAME1 <", value, "codeName1");
            return (Criteria) this;
        }

        public Criteria andCodeName1LessThanOrEqualTo(String value) {
            addCriterion("CODE_NAME1 <=", value, "codeName1");
            return (Criteria) this;
        }

        public Criteria andCodeName1Like(String value) {
            addCriterion("CODE_NAME1 like", value, "codeName1");
            return (Criteria) this;
        }

        public Criteria andCodeName1NotLike(String value) {
            addCriterion("CODE_NAME1 not like", value, "codeName1");
            return (Criteria) this;
        }

        public Criteria andCodeName1In(List<String> values) {
            addCriterion("CODE_NAME1 in", values, "codeName1");
            return (Criteria) this;
        }

        public Criteria andCodeName1NotIn(List<String> values) {
            addCriterion("CODE_NAME1 not in", values, "codeName1");
            return (Criteria) this;
        }

        public Criteria andCodeName1Between(String value1, String value2) {
            addCriterion("CODE_NAME1 between", value1, value2, "codeName1");
            return (Criteria) this;
        }

        public Criteria andCodeName1NotBetween(String value1, String value2) {
            addCriterion("CODE_NAME1 not between", value1, value2, "codeName1");
            return (Criteria) this;
        }

        public Criteria andCodeName2IsNull() {
            addCriterion("CODE_NAME2 is null");
            return (Criteria) this;
        }

        public Criteria andCodeName2IsNotNull() {
            addCriterion("CODE_NAME2 is not null");
            return (Criteria) this;
        }

        public Criteria andCodeName2EqualTo(String value) {
            addCriterion("CODE_NAME2 =", value, "codeName2");
            return (Criteria) this;
        }

        public Criteria andCodeName2NotEqualTo(String value) {
            addCriterion("CODE_NAME2 <>", value, "codeName2");
            return (Criteria) this;
        }

        public Criteria andCodeName2GreaterThan(String value) {
            addCriterion("CODE_NAME2 >", value, "codeName2");
            return (Criteria) this;
        }

        public Criteria andCodeName2GreaterThanOrEqualTo(String value) {
            addCriterion("CODE_NAME2 >=", value, "codeName2");
            return (Criteria) this;
        }

        public Criteria andCodeName2LessThan(String value) {
            addCriterion("CODE_NAME2 <", value, "codeName2");
            return (Criteria) this;
        }

        public Criteria andCodeName2LessThanOrEqualTo(String value) {
            addCriterion("CODE_NAME2 <=", value, "codeName2");
            return (Criteria) this;
        }

        public Criteria andCodeName2Like(String value) {
            addCriterion("CODE_NAME2 like", value, "codeName2");
            return (Criteria) this;
        }

        public Criteria andCodeName2NotLike(String value) {
            addCriterion("CODE_NAME2 not like", value, "codeName2");
            return (Criteria) this;
        }

        public Criteria andCodeName2In(List<String> values) {
            addCriterion("CODE_NAME2 in", values, "codeName2");
            return (Criteria) this;
        }

        public Criteria andCodeName2NotIn(List<String> values) {
            addCriterion("CODE_NAME2 not in", values, "codeName2");
            return (Criteria) this;
        }

        public Criteria andCodeName2Between(String value1, String value2) {
            addCriterion("CODE_NAME2 between", value1, value2, "codeName2");
            return (Criteria) this;
        }

        public Criteria andCodeName2NotBetween(String value1, String value2) {
            addCriterion("CODE_NAME2 not between", value1, value2, "codeName2");
            return (Criteria) this;
        }

        public Criteria andCodeName3IsNull() {
            addCriterion("CODE_NAME3 is null");
            return (Criteria) this;
        }

        public Criteria andCodeName3IsNotNull() {
            addCriterion("CODE_NAME3 is not null");
            return (Criteria) this;
        }

        public Criteria andCodeName3EqualTo(String value) {
            addCriterion("CODE_NAME3 =", value, "codeName3");
            return (Criteria) this;
        }

        public Criteria andCodeName3NotEqualTo(String value) {
            addCriterion("CODE_NAME3 <>", value, "codeName3");
            return (Criteria) this;
        }

        public Criteria andCodeName3GreaterThan(String value) {
            addCriterion("CODE_NAME3 >", value, "codeName3");
            return (Criteria) this;
        }

        public Criteria andCodeName3GreaterThanOrEqualTo(String value) {
            addCriterion("CODE_NAME3 >=", value, "codeName3");
            return (Criteria) this;
        }

        public Criteria andCodeName3LessThan(String value) {
            addCriterion("CODE_NAME3 <", value, "codeName3");
            return (Criteria) this;
        }

        public Criteria andCodeName3LessThanOrEqualTo(String value) {
            addCriterion("CODE_NAME3 <=", value, "codeName3");
            return (Criteria) this;
        }

        public Criteria andCodeName3Like(String value) {
            addCriterion("CODE_NAME3 like", value, "codeName3");
            return (Criteria) this;
        }

        public Criteria andCodeName3NotLike(String value) {
            addCriterion("CODE_NAME3 not like", value, "codeName3");
            return (Criteria) this;
        }

        public Criteria andCodeName3In(List<String> values) {
            addCriterion("CODE_NAME3 in", values, "codeName3");
            return (Criteria) this;
        }

        public Criteria andCodeName3NotIn(List<String> values) {
            addCriterion("CODE_NAME3 not in", values, "codeName3");
            return (Criteria) this;
        }

        public Criteria andCodeName3Between(String value1, String value2) {
            addCriterion("CODE_NAME3 between", value1, value2, "codeName3");
            return (Criteria) this;
        }

        public Criteria andCodeName3NotBetween(String value1, String value2) {
            addCriterion("CODE_NAME3 not between", value1, value2, "codeName3");
            return (Criteria) this;
        }

        public Criteria andCodeName4IsNull() {
            addCriterion("CODE_NAME4 is null");
            return (Criteria) this;
        }

        public Criteria andCodeName4IsNotNull() {
            addCriterion("CODE_NAME4 is not null");
            return (Criteria) this;
        }

        public Criteria andCodeName4EqualTo(String value) {
            addCriterion("CODE_NAME4 =", value, "codeName4");
            return (Criteria) this;
        }

        public Criteria andCodeName4NotEqualTo(String value) {
            addCriterion("CODE_NAME4 <>", value, "codeName4");
            return (Criteria) this;
        }

        public Criteria andCodeName4GreaterThan(String value) {
            addCriterion("CODE_NAME4 >", value, "codeName4");
            return (Criteria) this;
        }

        public Criteria andCodeName4GreaterThanOrEqualTo(String value) {
            addCriterion("CODE_NAME4 >=", value, "codeName4");
            return (Criteria) this;
        }

        public Criteria andCodeName4LessThan(String value) {
            addCriterion("CODE_NAME4 <", value, "codeName4");
            return (Criteria) this;
        }

        public Criteria andCodeName4LessThanOrEqualTo(String value) {
            addCriterion("CODE_NAME4 <=", value, "codeName4");
            return (Criteria) this;
        }

        public Criteria andCodeName4Like(String value) {
            addCriterion("CODE_NAME4 like", value, "codeName4");
            return (Criteria) this;
        }

        public Criteria andCodeName4NotLike(String value) {
            addCriterion("CODE_NAME4 not like", value, "codeName4");
            return (Criteria) this;
        }

        public Criteria andCodeName4In(List<String> values) {
            addCriterion("CODE_NAME4 in", values, "codeName4");
            return (Criteria) this;
        }

        public Criteria andCodeName4NotIn(List<String> values) {
            addCriterion("CODE_NAME4 not in", values, "codeName4");
            return (Criteria) this;
        }

        public Criteria andCodeName4Between(String value1, String value2) {
            addCriterion("CODE_NAME4 between", value1, value2, "codeName4");
            return (Criteria) this;
        }

        public Criteria andCodeName4NotBetween(String value1, String value2) {
            addCriterion("CODE_NAME4 not between", value1, value2, "codeName4");
            return (Criteria) this;
        }

        public Criteria andCodeName5IsNull() {
            addCriterion("CODE_NAME5 is null");
            return (Criteria) this;
        }

        public Criteria andCodeName5IsNotNull() {
            addCriterion("CODE_NAME5 is not null");
            return (Criteria) this;
        }

        public Criteria andCodeName5EqualTo(String value) {
            addCriterion("CODE_NAME5 =", value, "codeName5");
            return (Criteria) this;
        }

        public Criteria andCodeName5NotEqualTo(String value) {
            addCriterion("CODE_NAME5 <>", value, "codeName5");
            return (Criteria) this;
        }

        public Criteria andCodeName5GreaterThan(String value) {
            addCriterion("CODE_NAME5 >", value, "codeName5");
            return (Criteria) this;
        }

        public Criteria andCodeName5GreaterThanOrEqualTo(String value) {
            addCriterion("CODE_NAME5 >=", value, "codeName5");
            return (Criteria) this;
        }

        public Criteria andCodeName5LessThan(String value) {
            addCriterion("CODE_NAME5 <", value, "codeName5");
            return (Criteria) this;
        }

        public Criteria andCodeName5LessThanOrEqualTo(String value) {
            addCriterion("CODE_NAME5 <=", value, "codeName5");
            return (Criteria) this;
        }

        public Criteria andCodeName5Like(String value) {
            addCriterion("CODE_NAME5 like", value, "codeName5");
            return (Criteria) this;
        }

        public Criteria andCodeName5NotLike(String value) {
            addCriterion("CODE_NAME5 not like", value, "codeName5");
            return (Criteria) this;
        }

        public Criteria andCodeName5In(List<String> values) {
            addCriterion("CODE_NAME5 in", values, "codeName5");
            return (Criteria) this;
        }

        public Criteria andCodeName5NotIn(List<String> values) {
            addCriterion("CODE_NAME5 not in", values, "codeName5");
            return (Criteria) this;
        }

        public Criteria andCodeName5Between(String value1, String value2) {
            addCriterion("CODE_NAME5 between", value1, value2, "codeName5");
            return (Criteria) this;
        }

        public Criteria andCodeName5NotBetween(String value1, String value2) {
            addCriterion("CODE_NAME5 not between", value1, value2, "codeName5");
            return (Criteria) this;
        }

        public Criteria andCodeDescIsNull() {
            addCriterion("CODE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andCodeDescIsNotNull() {
            addCriterion("CODE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andCodeDescEqualTo(String value) {
            addCriterion("CODE_DESC =", value, "codeDesc");
            return (Criteria) this;
        }

        public Criteria andCodeDescNotEqualTo(String value) {
            addCriterion("CODE_DESC <>", value, "codeDesc");
            return (Criteria) this;
        }

        public Criteria andCodeDescGreaterThan(String value) {
            addCriterion("CODE_DESC >", value, "codeDesc");
            return (Criteria) this;
        }

        public Criteria andCodeDescGreaterThanOrEqualTo(String value) {
            addCriterion("CODE_DESC >=", value, "codeDesc");
            return (Criteria) this;
        }

        public Criteria andCodeDescLessThan(String value) {
            addCriterion("CODE_DESC <", value, "codeDesc");
            return (Criteria) this;
        }

        public Criteria andCodeDescLessThanOrEqualTo(String value) {
            addCriterion("CODE_DESC <=", value, "codeDesc");
            return (Criteria) this;
        }

        public Criteria andCodeDescLike(String value) {
            addCriterion("CODE_DESC like", value, "codeDesc");
            return (Criteria) this;
        }

        public Criteria andCodeDescNotLike(String value) {
            addCriterion("CODE_DESC not like", value, "codeDesc");
            return (Criteria) this;
        }

        public Criteria andCodeDescIn(List<String> values) {
            addCriterion("CODE_DESC in", values, "codeDesc");
            return (Criteria) this;
        }

        public Criteria andCodeDescNotIn(List<String> values) {
            addCriterion("CODE_DESC not in", values, "codeDesc");
            return (Criteria) this;
        }

        public Criteria andCodeDescBetween(String value1, String value2) {
            addCriterion("CODE_DESC between", value1, value2, "codeDesc");
            return (Criteria) this;
        }

        public Criteria andCodeDescNotBetween(String value1, String value2) {
            addCriterion("CODE_DESC not between", value1, value2, "codeDesc");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1IsNull() {
            addCriterion("CODE_DESC1 is null");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1IsNotNull() {
            addCriterion("CODE_DESC1 is not null");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1EqualTo(String value) {
            addCriterion("CODE_DESC1 =", value, "codeDesc1");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1NotEqualTo(String value) {
            addCriterion("CODE_DESC1 <>", value, "codeDesc1");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1GreaterThan(String value) {
            addCriterion("CODE_DESC1 >", value, "codeDesc1");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1GreaterThanOrEqualTo(String value) {
            addCriterion("CODE_DESC1 >=", value, "codeDesc1");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1LessThan(String value) {
            addCriterion("CODE_DESC1 <", value, "codeDesc1");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1LessThanOrEqualTo(String value) {
            addCriterion("CODE_DESC1 <=", value, "codeDesc1");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1Like(String value) {
            addCriterion("CODE_DESC1 like", value, "codeDesc1");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1NotLike(String value) {
            addCriterion("CODE_DESC1 not like", value, "codeDesc1");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1In(List<String> values) {
            addCriterion("CODE_DESC1 in", values, "codeDesc1");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1NotIn(List<String> values) {
            addCriterion("CODE_DESC1 not in", values, "codeDesc1");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1Between(String value1, String value2) {
            addCriterion("CODE_DESC1 between", value1, value2, "codeDesc1");
            return (Criteria) this;
        }

        public Criteria andCodeDesc1NotBetween(String value1, String value2) {
            addCriterion("CODE_DESC1 not between", value1, value2, "codeDesc1");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2IsNull() {
            addCriterion("CODE_DESC2 is null");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2IsNotNull() {
            addCriterion("CODE_DESC2 is not null");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2EqualTo(String value) {
            addCriterion("CODE_DESC2 =", value, "codeDesc2");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2NotEqualTo(String value) {
            addCriterion("CODE_DESC2 <>", value, "codeDesc2");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2GreaterThan(String value) {
            addCriterion("CODE_DESC2 >", value, "codeDesc2");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2GreaterThanOrEqualTo(String value) {
            addCriterion("CODE_DESC2 >=", value, "codeDesc2");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2LessThan(String value) {
            addCriterion("CODE_DESC2 <", value, "codeDesc2");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2LessThanOrEqualTo(String value) {
            addCriterion("CODE_DESC2 <=", value, "codeDesc2");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2Like(String value) {
            addCriterion("CODE_DESC2 like", value, "codeDesc2");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2NotLike(String value) {
            addCriterion("CODE_DESC2 not like", value, "codeDesc2");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2In(List<String> values) {
            addCriterion("CODE_DESC2 in", values, "codeDesc2");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2NotIn(List<String> values) {
            addCriterion("CODE_DESC2 not in", values, "codeDesc2");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2Between(String value1, String value2) {
            addCriterion("CODE_DESC2 between", value1, value2, "codeDesc2");
            return (Criteria) this;
        }

        public Criteria andCodeDesc2NotBetween(String value1, String value2) {
            addCriterion("CODE_DESC2 not between", value1, value2, "codeDesc2");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3IsNull() {
            addCriterion("CODE_DESC3 is null");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3IsNotNull() {
            addCriterion("CODE_DESC3 is not null");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3EqualTo(String value) {
            addCriterion("CODE_DESC3 =", value, "codeDesc3");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3NotEqualTo(String value) {
            addCriterion("CODE_DESC3 <>", value, "codeDesc3");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3GreaterThan(String value) {
            addCriterion("CODE_DESC3 >", value, "codeDesc3");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3GreaterThanOrEqualTo(String value) {
            addCriterion("CODE_DESC3 >=", value, "codeDesc3");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3LessThan(String value) {
            addCriterion("CODE_DESC3 <", value, "codeDesc3");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3LessThanOrEqualTo(String value) {
            addCriterion("CODE_DESC3 <=", value, "codeDesc3");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3Like(String value) {
            addCriterion("CODE_DESC3 like", value, "codeDesc3");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3NotLike(String value) {
            addCriterion("CODE_DESC3 not like", value, "codeDesc3");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3In(List<String> values) {
            addCriterion("CODE_DESC3 in", values, "codeDesc3");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3NotIn(List<String> values) {
            addCriterion("CODE_DESC3 not in", values, "codeDesc3");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3Between(String value1, String value2) {
            addCriterion("CODE_DESC3 between", value1, value2, "codeDesc3");
            return (Criteria) this;
        }

        public Criteria andCodeDesc3NotBetween(String value1, String value2) {
            addCriterion("CODE_DESC3 not between", value1, value2, "codeDesc3");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4IsNull() {
            addCriterion("CODE_DESC4 is null");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4IsNotNull() {
            addCriterion("CODE_DESC4 is not null");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4EqualTo(String value) {
            addCriterion("CODE_DESC4 =", value, "codeDesc4");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4NotEqualTo(String value) {
            addCriterion("CODE_DESC4 <>", value, "codeDesc4");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4GreaterThan(String value) {
            addCriterion("CODE_DESC4 >", value, "codeDesc4");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4GreaterThanOrEqualTo(String value) {
            addCriterion("CODE_DESC4 >=", value, "codeDesc4");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4LessThan(String value) {
            addCriterion("CODE_DESC4 <", value, "codeDesc4");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4LessThanOrEqualTo(String value) {
            addCriterion("CODE_DESC4 <=", value, "codeDesc4");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4Like(String value) {
            addCriterion("CODE_DESC4 like", value, "codeDesc4");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4NotLike(String value) {
            addCriterion("CODE_DESC4 not like", value, "codeDesc4");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4In(List<String> values) {
            addCriterion("CODE_DESC4 in", values, "codeDesc4");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4NotIn(List<String> values) {
            addCriterion("CODE_DESC4 not in", values, "codeDesc4");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4Between(String value1, String value2) {
            addCriterion("CODE_DESC4 between", value1, value2, "codeDesc4");
            return (Criteria) this;
        }

        public Criteria andCodeDesc4NotBetween(String value1, String value2) {
            addCriterion("CODE_DESC4 not between", value1, value2, "codeDesc4");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5IsNull() {
            addCriterion("CODE_DESC5 is null");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5IsNotNull() {
            addCriterion("CODE_DESC5 is not null");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5EqualTo(String value) {
            addCriterion("CODE_DESC5 =", value, "codeDesc5");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5NotEqualTo(String value) {
            addCriterion("CODE_DESC5 <>", value, "codeDesc5");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5GreaterThan(String value) {
            addCriterion("CODE_DESC5 >", value, "codeDesc5");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5GreaterThanOrEqualTo(String value) {
            addCriterion("CODE_DESC5 >=", value, "codeDesc5");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5LessThan(String value) {
            addCriterion("CODE_DESC5 <", value, "codeDesc5");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5LessThanOrEqualTo(String value) {
            addCriterion("CODE_DESC5 <=", value, "codeDesc5");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5Like(String value) {
            addCriterion("CODE_DESC5 like", value, "codeDesc5");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5NotLike(String value) {
            addCriterion("CODE_DESC5 not like", value, "codeDesc5");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5In(List<String> values) {
            addCriterion("CODE_DESC5 in", values, "codeDesc5");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5NotIn(List<String> values) {
            addCriterion("CODE_DESC5 not in", values, "codeDesc5");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5Between(String value1, String value2) {
            addCriterion("CODE_DESC5 between", value1, value2, "codeDesc5");
            return (Criteria) this;
        }

        public Criteria andCodeDesc5NotBetween(String value1, String value2) {
            addCriterion("CODE_DESC5 not between", value1, value2, "codeDesc5");
            return (Criteria) this;
        }

        public Criteria andCodeIndexIsNull() {
            addCriterion("CODE_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andCodeIndexIsNotNull() {
            addCriterion("CODE_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andCodeIndexEqualTo(Integer value) {
            addCriterion("CODE_INDEX =", value, "codeIndex");
            return (Criteria) this;
        }

        public Criteria andCodeIndexNotEqualTo(Integer value) {
            addCriterion("CODE_INDEX <>", value, "codeIndex");
            return (Criteria) this;
        }

        public Criteria andCodeIndexGreaterThan(Integer value) {
            addCriterion("CODE_INDEX >", value, "codeIndex");
            return (Criteria) this;
        }

        public Criteria andCodeIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("CODE_INDEX >=", value, "codeIndex");
            return (Criteria) this;
        }

        public Criteria andCodeIndexLessThan(Integer value) {
            addCriterion("CODE_INDEX <", value, "codeIndex");
            return (Criteria) this;
        }

        public Criteria andCodeIndexLessThanOrEqualTo(Integer value) {
            addCriterion("CODE_INDEX <=", value, "codeIndex");
            return (Criteria) this;
        }

        public Criteria andCodeIndexIn(List<Integer> values) {
            addCriterion("CODE_INDEX in", values, "codeIndex");
            return (Criteria) this;
        }

        public Criteria andCodeIndexNotIn(List<Integer> values) {
            addCriterion("CODE_INDEX not in", values, "codeIndex");
            return (Criteria) this;
        }

        public Criteria andCodeIndexBetween(Integer value1, Integer value2) {
            addCriterion("CODE_INDEX between", value1, value2, "codeIndex");
            return (Criteria) this;
        }

        public Criteria andCodeIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("CODE_INDEX not between", value1, value2, "codeIndex");
            return (Criteria) this;
        }

        public Criteria andCodeSeqIsNull() {
            addCriterion("CODE_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andCodeSeqIsNotNull() {
            addCriterion("CODE_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andCodeSeqEqualTo(Integer value) {
            addCriterion("CODE_SEQ =", value, "codeSeq");
            return (Criteria) this;
        }

        public Criteria andCodeSeqNotEqualTo(Integer value) {
            addCriterion("CODE_SEQ <>", value, "codeSeq");
            return (Criteria) this;
        }

        public Criteria andCodeSeqGreaterThan(Integer value) {
            addCriterion("CODE_SEQ >", value, "codeSeq");
            return (Criteria) this;
        }

        public Criteria andCodeSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("CODE_SEQ >=", value, "codeSeq");
            return (Criteria) this;
        }

        public Criteria andCodeSeqLessThan(Integer value) {
            addCriterion("CODE_SEQ <", value, "codeSeq");
            return (Criteria) this;
        }

        public Criteria andCodeSeqLessThanOrEqualTo(Integer value) {
            addCriterion("CODE_SEQ <=", value, "codeSeq");
            return (Criteria) this;
        }

        public Criteria andCodeSeqIn(List<Integer> values) {
            addCriterion("CODE_SEQ in", values, "codeSeq");
            return (Criteria) this;
        }

        public Criteria andCodeSeqNotIn(List<Integer> values) {
            addCriterion("CODE_SEQ not in", values, "codeSeq");
            return (Criteria) this;
        }

        public Criteria andCodeSeqBetween(Integer value1, Integer value2) {
            addCriterion("CODE_SEQ between", value1, value2, "codeSeq");
            return (Criteria) this;
        }

        public Criteria andCodeSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("CODE_SEQ not between", value1, value2, "codeSeq");
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

        public Criteria andPrclassIsNull() {
            addCriterion("PRCLASS is null");
            return (Criteria) this;
        }

        public Criteria andPrclassIsNotNull() {
            addCriterion("PRCLASS is not null");
            return (Criteria) this;
        }

        public Criteria andPrclassEqualTo(String value) {
            addCriterion("PRCLASS =", value, "prclass");
            return (Criteria) this;
        }

        public Criteria andPrclassNotEqualTo(String value) {
            addCriterion("PRCLASS <>", value, "prclass");
            return (Criteria) this;
        }

        public Criteria andPrclassGreaterThan(String value) {
            addCriterion("PRCLASS >", value, "prclass");
            return (Criteria) this;
        }

        public Criteria andPrclassGreaterThanOrEqualTo(String value) {
            addCriterion("PRCLASS >=", value, "prclass");
            return (Criteria) this;
        }

        public Criteria andPrclassLessThan(String value) {
            addCriterion("PRCLASS <", value, "prclass");
            return (Criteria) this;
        }

        public Criteria andPrclassLessThanOrEqualTo(String value) {
            addCriterion("PRCLASS <=", value, "prclass");
            return (Criteria) this;
        }

        public Criteria andPrclassLike(String value) {
            addCriterion("PRCLASS like", value, "prclass");
            return (Criteria) this;
        }

        public Criteria andPrclassNotLike(String value) {
            addCriterion("PRCLASS not like", value, "prclass");
            return (Criteria) this;
        }

        public Criteria andPrclassIn(List<String> values) {
            addCriterion("PRCLASS in", values, "prclass");
            return (Criteria) this;
        }

        public Criteria andPrclassNotIn(List<String> values) {
            addCriterion("PRCLASS not in", values, "prclass");
            return (Criteria) this;
        }

        public Criteria andPrclassBetween(String value1, String value2) {
            addCriterion("PRCLASS between", value1, value2, "prclass");
            return (Criteria) this;
        }

        public Criteria andPrclassNotBetween(String value1, String value2) {
            addCriterion("PRCLASS not between", value1, value2, "prclass");
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

        public Criteria andProperty15IsNull() {
            addCriterion("PROPERTY15 is null");
            return (Criteria) this;
        }

        public Criteria andProperty15IsNotNull() {
            addCriterion("PROPERTY15 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty15EqualTo(BigDecimal value) {
            addCriterion("PROPERTY15 =", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY15 <>", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY15 >", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY15 >=", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15LessThan(BigDecimal value) {
            addCriterion("PROPERTY15 <", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY15 <=", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15In(List<BigDecimal> values) {
            addCriterion("PROPERTY15 in", values, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY15 not in", values, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY15 between", value1, value2, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY15 not between", value1, value2, "property15");
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