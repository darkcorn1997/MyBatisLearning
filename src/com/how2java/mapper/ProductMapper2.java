package com.how2java.mapper;

import com.how2java.pojo.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ProductMapper2 {
    /*注解方式的连接查询 一对N*/
    @Select("select * from how2java.product_ where cid = #{cid}")
    List<Product> listByCategory(int cid);

    /*注解方式的连接查询 N对一*/
    @Select("select * from how2java.product_")
    @Results({
            @Result(property = "category", column = "cid", one = @One(select = "com.how2java.mapper.CategoryMapper2.listByProduct"))
    })
    List<Product> list();
}
