package com.how2java.mapper;

import com.how2java.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


/*注解方式的基本CRUD查询*/
public interface CategoryMapper {
    @Insert("insert into how2java.category_ (id, name) values (#{id}, #{name})")
    void add(Category category);

    @Delete("delete from how2java.category_ where id = #{id}")
    void delete(int id);

    @Select("select * from how2java.category_ where id = #{id}")
    Category get(int id);

    @Update("update how2java.category_ set name = #{name} where id = #{id}")
    void update(Category category);

    @Update("update how2java.category_ set name = #{name} where id = #{id}")
    void update2(Map<String, Object> map);

    @Select("select * from how2java.category_")
    List<Category> list();

    @Select(" select * from category_ limit #{start},#{count}")
    List<Category> listByPage(@Param("start") int start, @Param("count")int count);
}
