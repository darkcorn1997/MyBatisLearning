package com.how2java.mapper;

import com.how2java.pojo.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/*注解方式的连接查询 一对N*/
public interface ProductMapper2 {
    @Select("select * from how2java.product_ where cid = #{id}")
    public List<Product> listByCategory(int cid);
}
