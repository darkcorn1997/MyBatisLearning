package com.how2java.mapper;

import com.how2java.CategoryDynaSqlProvider;
import com.how2java.pojo.Category;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
import java.util.Map;

/*注解方式的动态CRUD查询*/
public interface CategoryMapper_dyn {

    @InsertProvider(type = CategoryDynaSqlProvider.class,method="add")
    public void add(Category category);

    @DeleteProvider(type=CategoryDynaSqlProvider.class,method="delete")
    public void delete(int id);

    @SelectProvider(type=CategoryDynaSqlProvider.class,method="get")
    public Category get(int id);

    @UpdateProvider(type=CategoryDynaSqlProvider.class,method="update")
    public void update(Category category);

    @UpdateProvider(type = CategoryDynaSqlProvider.class,method="update")
    public void update2(Map<String,Object> map);

    @SelectProvider(type=CategoryDynaSqlProvider.class,method="list")
    public List<Category> list();
}
