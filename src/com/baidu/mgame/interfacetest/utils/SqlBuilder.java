package com.baidu.mgame.interfacetest.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @Title: SqlBuilder.java
 * @Description: 用于拼接复杂查询SQL
 * @author maolei
 * @date 2015年5月11日 上午10:55:49
 * @version V1.0
 */
public class SqlBuilder {

    private StringBuilder sql;

    public SqlBuilder() {
        this.sql = new StringBuilder();
    }

    /**
     * 拼接空格
     */
    public void appendBlank() {
        this.sql.append(" ");
    }

    /**
     * 拼接select
     */
    public void appendSelect(String...names) {
        this.sql.append(" SELECT ");
        if (null == names) {
            return;
        }

        for (String name : names) {
            this.sql.append(name).append(",");
        }
        this.sql.deleteCharAt(this.sql.length() - 1);
        this.sql.append(" ");
    }

    /**
     * 拼接select *
     */
    public void appendSelectAll() {
        this.sql.append(" SELECT * ");
    }

    /**
     * 拼接from
     */
    public void appendFrom(String...tables) {
        this.sql.append(" FROM ");
        if (null == tables) {
            return;
        }

        for (String table : tables) {
            this.sql.append(table).append(",");
        }
        this.sql.deleteCharAt(this.sql.length() - 1);
        this.sql.append(" ");
    }

    /**
     * 拼接INNER JOIN
     *
     * @param t1 表名1
     * @param a1 别名1
     * @param t2 表名2
     * @param a2 别名2
     */
    public void appendInnerJoin(String t1, String a1, String t2, String a2) {
        if (StringUtils.isBlank(t1) || StringUtils.isBlank(t2)) {
            return;
        }
        this.appendJoin(t1, a1, t2, a2, " INNER JOIN ");
    }

    /**
     * 拼接LEFT JOIN
     *
     * @param t1 表名1
     * @param a1 别名1
     * @param t2 表名2
     * @param a2 别名2
     */
    public void appendLeftJoin(String t1, String a1, String t2, String a2) {
        if (StringUtils.isBlank(t1) || StringUtils.isBlank(t2)) {
            return;
        }
        this.appendJoin(t1, a1, t2, a2, " LEFT JOIN ");
    }

    /**
     * 拼接RIGHT JOIN
     *
     * @param t1 表名1
     * @param a1 别名1
     * @param t2 表名2
     * @param a2 别名2
     */
    public void appendRightJoin(String t1, String a1, String t2, String a2) {
        if (StringUtils.isBlank(t1) || StringUtils.isBlank(t2)) {
            return;
        }
        this.appendJoin(t1, a1, t2, a2, " RIGHT JOIN ");
    }

    /**
     * 拼接OUTER JOIN MYSQL不支持
     *
     * @param t1 表名1
     * @param a1 别名1
     * @param t2 表名2
     * @param a2 别名2
     */
    // public void appendOuterJoin(String t1, String a1, String t2, String a2) {
    // if (StringUtils.isBlank(t1) || StringUtils.isBlank(t2)) {
    // return;
    // }
    // this.appendJoin(t1, a1, t2, a2, " OUTER JOIN ");
    // }

    private void appendJoin(String t1, String a1, String t2, String a2, String jointype) {
        this.sql.append(t1);
        if (StringUtils.isNotBlank(a1)) {
            this.sql.append(" ").append(a1);
        }
        this.sql.append(jointype);
        this.sql.append(t2);
        if (StringUtils.isNotBlank(a2)) {
            this.sql.append(" ").append(a2);
        }
        this.sql.append(" ");
    }

    public void appendOn() {
        this.sql.append(" ON ");
    }

    public void appendOn(String name1, String name2) {
        this.sql.append(" ON ");
        this.sql.append(name1);
        this.sql.append(" = ");
        this.sql.append(name2);
    }

    /**
     * 拼接where
     */
    public void appendWhere() {
        this.sql.append(" WHERE ");
    }

    /**
     * 拼接and
     */
    public void appendAnd() {
        this.sql.append(" AND ");
    }

    /**
     * 拼接or
     */
    public void appendOr() {
        this.sql.append(" OR ");
    }

    /**
     * 拼接distinct
     */
    public void appendDistinct() {
        this.sql.append(" DISTINCT ");
    }

    /**
     * 拼接字符串
     *
     * @param str
     */
    public void appendStr(String str) {
        if (StringUtils.isBlank(str)) {
            return;
        }
        this.sql.append(str);
    }

    /**
     * 拼接字符串等于条件
     *
     * @param name
     * @param value
     */
    public void appendEqual(String name, String value) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(value)) {
            return;
        }
        this.sql.append(name).append(" = '").append(value).append("'");
    }

    /**
     * 拼接int等于条件
     *
     * @param name
     * @param value
     */
    public void appendEqual(String name, int value) {
        if (StringUtils.isBlank(name)) {
            return;
        }
        this.sql.append(name).append(" = ").append(value);
    }

    /**
     * 拼接char等于条件
     *
     * @param name
     * @param value
     */
    public void appendEqual(String name, char value) {
        if (StringUtils.isBlank(name)) {
            return;
        }
        this.sql.append(name).append(" = '").append(value).append("'");
    }

    /**
     * 拼接long等于条件
     *
     * @param name
     * @param value
     */
    public void appendEqual(String name, long value) {
        if (StringUtils.isBlank(name)) {
            return;
        }
        this.sql.append(name).append(" = ").append(value);
    }

    /**
     * 拼接double等于条件
     *
     * @param name
     * @param value
     */
    public void appendEqual(String name, double value) {
        if (StringUtils.isBlank(name)) {
            return;
        }
        this.sql.append(name).append(" = ").append(value);
    }

    /**
     * 拼接float等于条件
     *
     * @param name
     * @param value
     */
    public void appendEqual(String name, float value) {
        if (StringUtils.isBlank(name)) {
            return;
        }
        this.sql.append(name).append(" = ").append(value);
    }

    /**
     * 拼接IN条件，IN效率较差，尽量不要超过200个值
     *
     * @param name
     * @param values
     */
    public void appendIn(String name, String[] values) {
        if (StringUtils.isBlank(name)) {
            return;
        }
        if (null == values || values.length < 1) {
            return;
        }
        this.sql.append(" ").append(name).append(" IN ").append("(");
        for (String value : values) {
            this.sql.append("'").append(value).append("',");
        }
        this.sql.deleteCharAt(this.sql.length() - 1);
        this.sql.append(") ");
    }

    /**
     * 拼接IN条件
     *
     * @param name
     * @param values
     */
    public void appendIn(String name, int[] values) {
        if (StringUtils.isBlank(name)) {
            return;
        }
        if (null == values || values.length < 1) {
            return;
        }
        this.sql.append(" ").append(name).append(" IN ").append("(");
        for (int value : values) {
            this.sql.append(value).append(",");
        }
        this.sql.deleteCharAt(this.sql.length() - 1);
        this.sql.append(") ");
    }

    /**
     * 拼接IN条件
     *
     * @param name
     * @param values
     */
    public void appendIn(String name, Integer[] values) {
        if (StringUtils.isBlank(name)) {
            return;
        }
        if (null == values || values.length < 1) {
            return;
        }
        this.sql.append(" ").append(name).append(" IN ").append("(");
        for (Integer value : values) {
            this.sql.append(value).append(",");
        }
        this.sql.deleteCharAt(this.sql.length() - 1);
        this.sql.append(") ");
    }

    /**
     * 拼接排序条件，true-正序，false-倒序
     *
     * @param name
     * @param isAsc
     */
    public void appendOrderBy(String name, boolean isAsc) {
        if (StringUtils.isBlank(name)) {
            return;
        }
        this.sql.append(" ORDER BY ").append(name);
        if (isAsc) {
            this.sql.append(" ASC ");
        } else {
            this.sql.append(" DESC ");
        }
    }

    /**
     * 拼接limit条件，start-start+1为起始行，count-为行数
     *
     * @param start
     * @param count
     */
    public void appendLimit(int start, int count) {
        if (start < 0 || count <= 0) {
            return;
        }
        this.sql.append(" LIMIT ").append(start).append(",").append(count);
    }

    @Override
    public String toString() {
        return this.sql.toString();
    }

}
