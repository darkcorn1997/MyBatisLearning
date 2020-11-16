package com.how2java.mapper;

import com.how2java.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface CategoryMapper2 {
    /*注解方式的连接查询 一对N*/
    @Select("select * from how2java.category_")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "products", javaType = List.class, column = "id", many = @Many(select =
                    "com.how2java.mapper.ProductMapper2.listByCategory"))
    })
    List<Category> list();

    /*注解方式的连接查询 N对一*/
    @Select("select * from how2java.category_ where id = #{id}")
    Category listByProduct(int id);
}

