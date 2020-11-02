package com.how2java;

import org.apache.ibatis.jdbc.SQL;

//动态sql语句
public class CategoryDynaSqlProvider {
    public String list() {
        return new SQL()
                .SELECT("*")
                .FROM("how2java.category_")
                .toString();
    }

    public String get() {
        return new SQL()
                .SELECT("*")
                .FROM("how2java.category_")
                .WHERE("id=#{id}")
                .toString();
    }

    public String add() {
        return new SQL()
                .INSERT_INTO("how2java.category_")
                .VALUES("name", "#{name}")
                .toString();
    }

    public String update(){
        return new SQL()
                .UPDATE("how2java.category_")
                .SET("name=#{name}")
                .WHERE("id=#{id}")
                .toString();
    }
    public String delete(){
        return new SQL()
                .DELETE_FROM("how2java.category_")
                .WHERE("id=#{id}")
                .toString();
    }

    private String selectPersonSql() {
        return new SQL() {{
            SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME");
            SELECT("P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON");
            FROM("PERSON P");
            FROM("ACCOUNT A");
            INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID");
            INNER_JOIN("COMPANY C on D.COMPANY_ID = C.ID");
            WHERE("P.ID = A.ID");
            WHERE("P.FIRST_NAME like ?");
            OR();
            WHERE("P.LAST_NAME like ?");
            GROUP_BY("P.ID");
            HAVING("P.LAST_NAME like ?");
            OR();
            HAVING("P.FIRST_NAME like ?");
            ORDER_BY("P.ID");
            ORDER_BY("P.FULL_NAME");
        }}.toString();
    }
}
