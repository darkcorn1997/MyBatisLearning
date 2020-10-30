package com.how2java.mapper;

import com.how2java.pojo.Category;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/*注解方式的连接查询*/
public interface CategoryMapper2 {
    @Select("select * from how2java.category_")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "products", javaType = List.class, column = "id", many = @Many(select =
                    "com.how2java.mapper.ProductMapper2.listByCategory"))
    })

    public List<Category> list();
}
