package com.how2java.mapper;

import com.how2java.pojo.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CategoryMapper {
    @Insert("insert into how2java.category_ (id, name) values (#{id}, #{name}")
    public void add(Category category);

    @Delete("delete from how2java.category_ where id = #{id}")
    public void delete(int id);

    @Select("select * from how2java.category_ where id = #{id}")
    public Category get(int id);

    @Update("update how2java.category_ set name = #{name} where id = #{id}")
    public void update(Category category);

    @Select("select * from how2java.category_")
    public List<Category> list();
}
