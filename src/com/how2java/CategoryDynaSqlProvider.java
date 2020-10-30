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
}
