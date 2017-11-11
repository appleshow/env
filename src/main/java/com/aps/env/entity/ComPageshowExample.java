package com.aps.env.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComPageshowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComPageshowExample() {
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

        public Criteria andPageIdIsNull() {
            addCriterion("PAGE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPageIdIsNotNull() {
            addCriterion("PAGE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPageIdEqualTo(Integer value) {
            addCriterion("PAGE_ID =", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotEqualTo(Integer value) {
            addCriterion("PAGE_ID <>", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdGreaterThan(Integer value) {
            addCriterion("PAGE_ID >", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PAGE_ID >=", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdLessThan(Integer value) {
            addCriterion("PAGE_ID <", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdLessThanOrEqualTo(Integer value) {
            addCriterion("PAGE_ID <=", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdIn(List<Integer> values) {
            addCriterion("PAGE_ID in", values, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotIn(List<Integer> values) {
            addCriterion("PAGE_ID not in", values, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdBetween(Integer value1, Integer value2) {
            addCriterion("PAGE_ID between", value1, value2, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PAGE_ID not between", value1, value2, "pageId");
            return (Criteria) this;
        }

        public Criteria andColumnIdIsNull() {
            addCriterion("COLUMN_ID is null");
            return (Criteria) this;
        }

        public Criteria andColumnIdIsNotNull() {
            addCriterion("COLUMN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andColumnIdEqualTo(String value) {
            addCriterion("COLUMN_ID =", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdNotEqualTo(String value) {
            addCriterion("COLUMN_ID <>", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdGreaterThan(String value) {
            addCriterion("COLUMN_ID >", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdGreaterThanOrEqualTo(String value) {
            addCriterion("COLUMN_ID >=", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdLessThan(String value) {
            addCriterion("COLUMN_ID <", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdLessThanOrEqualTo(String value) {
            addCriterion("COLUMN_ID <=", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdLike(String value) {
            addCriterion("COLUMN_ID like", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdNotLike(String value) {
            addCriterion("COLUMN_ID not like", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdIn(List<String> values) {
            addCriterion("COLUMN_ID in", values, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdNotIn(List<String> values) {
            addCriterion("COLUMN_ID not in", values, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdBetween(String value1, String value2) {
            addCriterion("COLUMN_ID between", value1, value2, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdNotBetween(String value1, String value2) {
            addCriterion("COLUMN_ID not between", value1, value2, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnNameIsNull() {
            addCriterion("COLUMN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andColumnNameIsNotNull() {
            addCriterion("COLUMN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andColumnNameEqualTo(String value) {
            addCriterion("COLUMN_NAME =", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotEqualTo(String value) {
            addCriterion("COLUMN_NAME <>", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThan(String value) {
            addCriterion("COLUMN_NAME >", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThanOrEqualTo(String value) {
            addCriterion("COLUMN_NAME >=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThan(String value) {
            addCriterion("COLUMN_NAME <", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThanOrEqualTo(String value) {
            addCriterion("COLUMN_NAME <=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLike(String value) {
            addCriterion("COLUMN_NAME like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotLike(String value) {
            addCriterion("COLUMN_NAME not like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameIn(List<String> values) {
            addCriterion("COLUMN_NAME in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotIn(List<String> values) {
            addCriterion("COLUMN_NAME not in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameBetween(String value1, String value2) {
            addCriterion("COLUMN_NAME between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotBetween(String value1, String value2) {
            addCriterion("COLUMN_NAME not between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnCountIsNull() {
            addCriterion("COLUMN_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andColumnCountIsNotNull() {
            addCriterion("COLUMN_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andColumnCountEqualTo(Integer value) {
            addCriterion("COLUMN_COUNT =", value, "columnCount");
            return (Criteria) this;
        }

        public Criteria andColumnCountNotEqualTo(Integer value) {
            addCriterion("COLUMN_COUNT <>", value, "columnCount");
            return (Criteria) this;
        }

        public Criteria andColumnCountGreaterThan(Integer value) {
            addCriterion("COLUMN_COUNT >", value, "columnCount");
            return (Criteria) this;
        }

        public Criteria andColumnCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_COUNT >=", value, "columnCount");
            return (Criteria) this;
        }

        public Criteria andColumnCountLessThan(Integer value) {
            addCriterion("COLUMN_COUNT <", value, "columnCount");
            return (Criteria) this;
        }

        public Criteria andColumnCountLessThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_COUNT <=", value, "columnCount");
            return (Criteria) this;
        }

        public Criteria andColumnCountIn(List<Integer> values) {
            addCriterion("COLUMN_COUNT in", values, "columnCount");
            return (Criteria) this;
        }

        public Criteria andColumnCountNotIn(List<Integer> values) {
            addCriterion("COLUMN_COUNT not in", values, "columnCount");
            return (Criteria) this;
        }

        public Criteria andColumnCountBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_COUNT between", value1, value2, "columnCount");
            return (Criteria) this;
        }

        public Criteria andColumnCountNotBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_COUNT not between", value1, value2, "columnCount");
            return (Criteria) this;
        }

        public Criteria andColumnPrimaryIsNull() {
            addCriterion("COLUMN_PRIMARY is null");
            return (Criteria) this;
        }

        public Criteria andColumnPrimaryIsNotNull() {
            addCriterion("COLUMN_PRIMARY is not null");
            return (Criteria) this;
        }

        public Criteria andColumnPrimaryEqualTo(Integer value) {
            addCriterion("COLUMN_PRIMARY =", value, "columnPrimary");
            return (Criteria) this;
        }

        public Criteria andColumnPrimaryNotEqualTo(Integer value) {
            addCriterion("COLUMN_PRIMARY <>", value, "columnPrimary");
            return (Criteria) this;
        }

        public Criteria andColumnPrimaryGreaterThan(Integer value) {
            addCriterion("COLUMN_PRIMARY >", value, "columnPrimary");
            return (Criteria) this;
        }

        public Criteria andColumnPrimaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_PRIMARY >=", value, "columnPrimary");
            return (Criteria) this;
        }

        public Criteria andColumnPrimaryLessThan(Integer value) {
            addCriterion("COLUMN_PRIMARY <", value, "columnPrimary");
            return (Criteria) this;
        }

        public Criteria andColumnPrimaryLessThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_PRIMARY <=", value, "columnPrimary");
            return (Criteria) this;
        }

        public Criteria andColumnPrimaryIn(List<Integer> values) {
            addCriterion("COLUMN_PRIMARY in", values, "columnPrimary");
            return (Criteria) this;
        }

        public Criteria andColumnPrimaryNotIn(List<Integer> values) {
            addCriterion("COLUMN_PRIMARY not in", values, "columnPrimary");
            return (Criteria) this;
        }

        public Criteria andColumnPrimaryBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_PRIMARY between", value1, value2, "columnPrimary");
            return (Criteria) this;
        }

        public Criteria andColumnPrimaryNotBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_PRIMARY not between", value1, value2, "columnPrimary");
            return (Criteria) this;
        }

        public Criteria andColumnEditIsNull() {
            addCriterion("COLUMN_EDIT is null");
            return (Criteria) this;
        }

        public Criteria andColumnEditIsNotNull() {
            addCriterion("COLUMN_EDIT is not null");
            return (Criteria) this;
        }

        public Criteria andColumnEditEqualTo(Integer value) {
            addCriterion("COLUMN_EDIT =", value, "columnEdit");
            return (Criteria) this;
        }

        public Criteria andColumnEditNotEqualTo(Integer value) {
            addCriterion("COLUMN_EDIT <>", value, "columnEdit");
            return (Criteria) this;
        }

        public Criteria andColumnEditGreaterThan(Integer value) {
            addCriterion("COLUMN_EDIT >", value, "columnEdit");
            return (Criteria) this;
        }

        public Criteria andColumnEditGreaterThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_EDIT >=", value, "columnEdit");
            return (Criteria) this;
        }

        public Criteria andColumnEditLessThan(Integer value) {
            addCriterion("COLUMN_EDIT <", value, "columnEdit");
            return (Criteria) this;
        }

        public Criteria andColumnEditLessThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_EDIT <=", value, "columnEdit");
            return (Criteria) this;
        }

        public Criteria andColumnEditIn(List<Integer> values) {
            addCriterion("COLUMN_EDIT in", values, "columnEdit");
            return (Criteria) this;
        }

        public Criteria andColumnEditNotIn(List<Integer> values) {
            addCriterion("COLUMN_EDIT not in", values, "columnEdit");
            return (Criteria) this;
        }

        public Criteria andColumnEditBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_EDIT between", value1, value2, "columnEdit");
            return (Criteria) this;
        }

        public Criteria andColumnEditNotBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_EDIT not between", value1, value2, "columnEdit");
            return (Criteria) this;
        }

        public Criteria andColumnUpdateIsNull() {
            addCriterion("COLUMN_UPDATE is null");
            return (Criteria) this;
        }

        public Criteria andColumnUpdateIsNotNull() {
            addCriterion("COLUMN_UPDATE is not null");
            return (Criteria) this;
        }

        public Criteria andColumnUpdateEqualTo(Integer value) {
            addCriterion("COLUMN_UPDATE =", value, "columnUpdate");
            return (Criteria) this;
        }

        public Criteria andColumnUpdateNotEqualTo(Integer value) {
            addCriterion("COLUMN_UPDATE <>", value, "columnUpdate");
            return (Criteria) this;
        }

        public Criteria andColumnUpdateGreaterThan(Integer value) {
            addCriterion("COLUMN_UPDATE >", value, "columnUpdate");
            return (Criteria) this;
        }

        public Criteria andColumnUpdateGreaterThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_UPDATE >=", value, "columnUpdate");
            return (Criteria) this;
        }

        public Criteria andColumnUpdateLessThan(Integer value) {
            addCriterion("COLUMN_UPDATE <", value, "columnUpdate");
            return (Criteria) this;
        }

        public Criteria andColumnUpdateLessThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_UPDATE <=", value, "columnUpdate");
            return (Criteria) this;
        }

        public Criteria andColumnUpdateIn(List<Integer> values) {
            addCriterion("COLUMN_UPDATE in", values, "columnUpdate");
            return (Criteria) this;
        }

        public Criteria andColumnUpdateNotIn(List<Integer> values) {
            addCriterion("COLUMN_UPDATE not in", values, "columnUpdate");
            return (Criteria) this;
        }

        public Criteria andColumnUpdateBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_UPDATE between", value1, value2, "columnUpdate");
            return (Criteria) this;
        }

        public Criteria andColumnUpdateNotBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_UPDATE not between", value1, value2, "columnUpdate");
            return (Criteria) this;
        }

        public Criteria andColumnSortIsNull() {
            addCriterion("COLUMN_SORT is null");
            return (Criteria) this;
        }

        public Criteria andColumnSortIsNotNull() {
            addCriterion("COLUMN_SORT is not null");
            return (Criteria) this;
        }

        public Criteria andColumnSortEqualTo(Integer value) {
            addCriterion("COLUMN_SORT =", value, "columnSort");
            return (Criteria) this;
        }

        public Criteria andColumnSortNotEqualTo(Integer value) {
            addCriterion("COLUMN_SORT <>", value, "columnSort");
            return (Criteria) this;
        }

        public Criteria andColumnSortGreaterThan(Integer value) {
            addCriterion("COLUMN_SORT >", value, "columnSort");
            return (Criteria) this;
        }

        public Criteria andColumnSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_SORT >=", value, "columnSort");
            return (Criteria) this;
        }

        public Criteria andColumnSortLessThan(Integer value) {
            addCriterion("COLUMN_SORT <", value, "columnSort");
            return (Criteria) this;
        }

        public Criteria andColumnSortLessThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_SORT <=", value, "columnSort");
            return (Criteria) this;
        }

        public Criteria andColumnSortIn(List<Integer> values) {
            addCriterion("COLUMN_SORT in", values, "columnSort");
            return (Criteria) this;
        }

        public Criteria andColumnSortNotIn(List<Integer> values) {
            addCriterion("COLUMN_SORT not in", values, "columnSort");
            return (Criteria) this;
        }

        public Criteria andColumnSortBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_SORT between", value1, value2, "columnSort");
            return (Criteria) this;
        }

        public Criteria andColumnSortNotBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_SORT not between", value1, value2, "columnSort");
            return (Criteria) this;
        }

        public Criteria andColumnWidthIsNull() {
            addCriterion("COLUMN_WIDTH is null");
            return (Criteria) this;
        }

        public Criteria andColumnWidthIsNotNull() {
            addCriterion("COLUMN_WIDTH is not null");
            return (Criteria) this;
        }

        public Criteria andColumnWidthEqualTo(Integer value) {
            addCriterion("COLUMN_WIDTH =", value, "columnWidth");
            return (Criteria) this;
        }

        public Criteria andColumnWidthNotEqualTo(Integer value) {
            addCriterion("COLUMN_WIDTH <>", value, "columnWidth");
            return (Criteria) this;
        }

        public Criteria andColumnWidthGreaterThan(Integer value) {
            addCriterion("COLUMN_WIDTH >", value, "columnWidth");
            return (Criteria) this;
        }

        public Criteria andColumnWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_WIDTH >=", value, "columnWidth");
            return (Criteria) this;
        }

        public Criteria andColumnWidthLessThan(Integer value) {
            addCriterion("COLUMN_WIDTH <", value, "columnWidth");
            return (Criteria) this;
        }

        public Criteria andColumnWidthLessThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_WIDTH <=", value, "columnWidth");
            return (Criteria) this;
        }

        public Criteria andColumnWidthIn(List<Integer> values) {
            addCriterion("COLUMN_WIDTH in", values, "columnWidth");
            return (Criteria) this;
        }

        public Criteria andColumnWidthNotIn(List<Integer> values) {
            addCriterion("COLUMN_WIDTH not in", values, "columnWidth");
            return (Criteria) this;
        }

        public Criteria andColumnWidthBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_WIDTH between", value1, value2, "columnWidth");
            return (Criteria) this;
        }

        public Criteria andColumnWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_WIDTH not between", value1, value2, "columnWidth");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIsNull() {
            addCriterion("COLUMN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIsNotNull() {
            addCriterion("COLUMN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andColumnTypeEqualTo(String value) {
            addCriterion("COLUMN_TYPE =", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotEqualTo(String value) {
            addCriterion("COLUMN_TYPE <>", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeGreaterThan(String value) {
            addCriterion("COLUMN_TYPE >", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("COLUMN_TYPE >=", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLessThan(String value) {
            addCriterion("COLUMN_TYPE <", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLessThanOrEqualTo(String value) {
            addCriterion("COLUMN_TYPE <=", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLike(String value) {
            addCriterion("COLUMN_TYPE like", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotLike(String value) {
            addCriterion("COLUMN_TYPE not like", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIn(List<String> values) {
            addCriterion("COLUMN_TYPE in", values, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotIn(List<String> values) {
            addCriterion("COLUMN_TYPE not in", values, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeBetween(String value1, String value2) {
            addCriterion("COLUMN_TYPE between", value1, value2, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotBetween(String value1, String value2) {
            addCriterion("COLUMN_TYPE not between", value1, value2, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnAlignIsNull() {
            addCriterion("COLUMN_ALIGN is null");
            return (Criteria) this;
        }

        public Criteria andColumnAlignIsNotNull() {
            addCriterion("COLUMN_ALIGN is not null");
            return (Criteria) this;
        }

        public Criteria andColumnAlignEqualTo(Integer value) {
            addCriterion("COLUMN_ALIGN =", value, "columnAlign");
            return (Criteria) this;
        }

        public Criteria andColumnAlignNotEqualTo(Integer value) {
            addCriterion("COLUMN_ALIGN <>", value, "columnAlign");
            return (Criteria) this;
        }

        public Criteria andColumnAlignGreaterThan(Integer value) {
            addCriterion("COLUMN_ALIGN >", value, "columnAlign");
            return (Criteria) this;
        }

        public Criteria andColumnAlignGreaterThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_ALIGN >=", value, "columnAlign");
            return (Criteria) this;
        }

        public Criteria andColumnAlignLessThan(Integer value) {
            addCriterion("COLUMN_ALIGN <", value, "columnAlign");
            return (Criteria) this;
        }

        public Criteria andColumnAlignLessThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_ALIGN <=", value, "columnAlign");
            return (Criteria) this;
        }

        public Criteria andColumnAlignIn(List<Integer> values) {
            addCriterion("COLUMN_ALIGN in", values, "columnAlign");
            return (Criteria) this;
        }

        public Criteria andColumnAlignNotIn(List<Integer> values) {
            addCriterion("COLUMN_ALIGN not in", values, "columnAlign");
            return (Criteria) this;
        }

        public Criteria andColumnAlignBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_ALIGN between", value1, value2, "columnAlign");
            return (Criteria) this;
        }

        public Criteria andColumnAlignNotBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_ALIGN not between", value1, value2, "columnAlign");
            return (Criteria) this;
        }

        public Criteria andColumnMergeIsNull() {
            addCriterion("COLUMN_MERGE is null");
            return (Criteria) this;
        }

        public Criteria andColumnMergeIsNotNull() {
            addCriterion("COLUMN_MERGE is not null");
            return (Criteria) this;
        }

        public Criteria andColumnMergeEqualTo(Integer value) {
            addCriterion("COLUMN_MERGE =", value, "columnMerge");
            return (Criteria) this;
        }

        public Criteria andColumnMergeNotEqualTo(Integer value) {
            addCriterion("COLUMN_MERGE <>", value, "columnMerge");
            return (Criteria) this;
        }

        public Criteria andColumnMergeGreaterThan(Integer value) {
            addCriterion("COLUMN_MERGE >", value, "columnMerge");
            return (Criteria) this;
        }

        public Criteria andColumnMergeGreaterThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_MERGE >=", value, "columnMerge");
            return (Criteria) this;
        }

        public Criteria andColumnMergeLessThan(Integer value) {
            addCriterion("COLUMN_MERGE <", value, "columnMerge");
            return (Criteria) this;
        }

        public Criteria andColumnMergeLessThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_MERGE <=", value, "columnMerge");
            return (Criteria) this;
        }

        public Criteria andColumnMergeIn(List<Integer> values) {
            addCriterion("COLUMN_MERGE in", values, "columnMerge");
            return (Criteria) this;
        }

        public Criteria andColumnMergeNotIn(List<Integer> values) {
            addCriterion("COLUMN_MERGE not in", values, "columnMerge");
            return (Criteria) this;
        }

        public Criteria andColumnMergeBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_MERGE between", value1, value2, "columnMerge");
            return (Criteria) this;
        }

        public Criteria andColumnMergeNotBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_MERGE not between", value1, value2, "columnMerge");
            return (Criteria) this;
        }

        public Criteria andColumnEditorIsNull() {
            addCriterion("COLUMN_EDITOR is null");
            return (Criteria) this;
        }

        public Criteria andColumnEditorIsNotNull() {
            addCriterion("COLUMN_EDITOR is not null");
            return (Criteria) this;
        }

        public Criteria andColumnEditorEqualTo(String value) {
            addCriterion("COLUMN_EDITOR =", value, "columnEditor");
            return (Criteria) this;
        }

        public Criteria andColumnEditorNotEqualTo(String value) {
            addCriterion("COLUMN_EDITOR <>", value, "columnEditor");
            return (Criteria) this;
        }

        public Criteria andColumnEditorGreaterThan(String value) {
            addCriterion("COLUMN_EDITOR >", value, "columnEditor");
            return (Criteria) this;
        }

        public Criteria andColumnEditorGreaterThanOrEqualTo(String value) {
            addCriterion("COLUMN_EDITOR >=", value, "columnEditor");
            return (Criteria) this;
        }

        public Criteria andColumnEditorLessThan(String value) {
            addCriterion("COLUMN_EDITOR <", value, "columnEditor");
            return (Criteria) this;
        }

        public Criteria andColumnEditorLessThanOrEqualTo(String value) {
            addCriterion("COLUMN_EDITOR <=", value, "columnEditor");
            return (Criteria) this;
        }

        public Criteria andColumnEditorLike(String value) {
            addCriterion("COLUMN_EDITOR like", value, "columnEditor");
            return (Criteria) this;
        }

        public Criteria andColumnEditorNotLike(String value) {
            addCriterion("COLUMN_EDITOR not like", value, "columnEditor");
            return (Criteria) this;
        }

        public Criteria andColumnEditorIn(List<String> values) {
            addCriterion("COLUMN_EDITOR in", values, "columnEditor");
            return (Criteria) this;
        }

        public Criteria andColumnEditorNotIn(List<String> values) {
            addCriterion("COLUMN_EDITOR not in", values, "columnEditor");
            return (Criteria) this;
        }

        public Criteria andColumnEditorBetween(String value1, String value2) {
            addCriterion("COLUMN_EDITOR between", value1, value2, "columnEditor");
            return (Criteria) this;
        }

        public Criteria andColumnEditorNotBetween(String value1, String value2) {
            addCriterion("COLUMN_EDITOR not between", value1, value2, "columnEditor");
            return (Criteria) this;
        }

        public Criteria andColumnHideIsNull() {
            addCriterion("COLUMN_HIDE is null");
            return (Criteria) this;
        }

        public Criteria andColumnHideIsNotNull() {
            addCriterion("COLUMN_HIDE is not null");
            return (Criteria) this;
        }

        public Criteria andColumnHideEqualTo(Integer value) {
            addCriterion("COLUMN_HIDE =", value, "columnHide");
            return (Criteria) this;
        }

        public Criteria andColumnHideNotEqualTo(Integer value) {
            addCriterion("COLUMN_HIDE <>", value, "columnHide");
            return (Criteria) this;
        }

        public Criteria andColumnHideGreaterThan(Integer value) {
            addCriterion("COLUMN_HIDE >", value, "columnHide");
            return (Criteria) this;
        }

        public Criteria andColumnHideGreaterThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_HIDE >=", value, "columnHide");
            return (Criteria) this;
        }

        public Criteria andColumnHideLessThan(Integer value) {
            addCriterion("COLUMN_HIDE <", value, "columnHide");
            return (Criteria) this;
        }

        public Criteria andColumnHideLessThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_HIDE <=", value, "columnHide");
            return (Criteria) this;
        }

        public Criteria andColumnHideIn(List<Integer> values) {
            addCriterion("COLUMN_HIDE in", values, "columnHide");
            return (Criteria) this;
        }

        public Criteria andColumnHideNotIn(List<Integer> values) {
            addCriterion("COLUMN_HIDE not in", values, "columnHide");
            return (Criteria) this;
        }

        public Criteria andColumnHideBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_HIDE between", value1, value2, "columnHide");
            return (Criteria) this;
        }

        public Criteria andColumnHideNotBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_HIDE not between", value1, value2, "columnHide");
            return (Criteria) this;
        }

        public Criteria andColumnIndexIsNull() {
            addCriterion("COLUMN_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andColumnIndexIsNotNull() {
            addCriterion("COLUMN_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andColumnIndexEqualTo(Integer value) {
            addCriterion("COLUMN_INDEX =", value, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexNotEqualTo(Integer value) {
            addCriterion("COLUMN_INDEX <>", value, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexGreaterThan(Integer value) {
            addCriterion("COLUMN_INDEX >", value, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_INDEX >=", value, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexLessThan(Integer value) {
            addCriterion("COLUMN_INDEX <", value, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexLessThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_INDEX <=", value, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexIn(List<Integer> values) {
            addCriterion("COLUMN_INDEX in", values, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexNotIn(List<Integer> values) {
            addCriterion("COLUMN_INDEX not in", values, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_INDEX between", value1, value2, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_INDEX not between", value1, value2, "columnIndex");
            return (Criteria) this;
        }

        public Criteria andColumnLockIsNull() {
            addCriterion("COLUMN_LOCK is null");
            return (Criteria) this;
        }

        public Criteria andColumnLockIsNotNull() {
            addCriterion("COLUMN_LOCK is not null");
            return (Criteria) this;
        }

        public Criteria andColumnLockEqualTo(Integer value) {
            addCriterion("COLUMN_LOCK =", value, "columnLock");
            return (Criteria) this;
        }

        public Criteria andColumnLockNotEqualTo(Integer value) {
            addCriterion("COLUMN_LOCK <>", value, "columnLock");
            return (Criteria) this;
        }

        public Criteria andColumnLockGreaterThan(Integer value) {
            addCriterion("COLUMN_LOCK >", value, "columnLock");
            return (Criteria) this;
        }

        public Criteria andColumnLockGreaterThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_LOCK >=", value, "columnLock");
            return (Criteria) this;
        }

        public Criteria andColumnLockLessThan(Integer value) {
            addCriterion("COLUMN_LOCK <", value, "columnLock");
            return (Criteria) this;
        }

        public Criteria andColumnLockLessThanOrEqualTo(Integer value) {
            addCriterion("COLUMN_LOCK <=", value, "columnLock");
            return (Criteria) this;
        }

        public Criteria andColumnLockIn(List<Integer> values) {
            addCriterion("COLUMN_LOCK in", values, "columnLock");
            return (Criteria) this;
        }

        public Criteria andColumnLockNotIn(List<Integer> values) {
            addCriterion("COLUMN_LOCK not in", values, "columnLock");
            return (Criteria) this;
        }

        public Criteria andColumnLockBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_LOCK between", value1, value2, "columnLock");
            return (Criteria) this;
        }

        public Criteria andColumnLockNotBetween(Integer value1, Integer value2) {
            addCriterion("COLUMN_LOCK not between", value1, value2, "columnLock");
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