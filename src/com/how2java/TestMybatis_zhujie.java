package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.how2java.mapper.CategoryMapper_dyn;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;


/*注解方式的基本CRUD查询 测试*/
public class TestMybatis_zhujie {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        CategoryMapper_dyn mapper = session.getMapper(CategoryMapper_dyn.class);

//        add(mapper);
//        delete(mapper);
//        get(mapper);
//        update(mapper);
//        update2(mapper);
        listAll(mapper);

        session.commit();
        session.close();

    }

    private static void update(CategoryMapper mapper) {
        Category c= mapper.get(2);
        c.setName("修改了的Category名稱");
        mapper.update(c);
        listAll(mapper);
    }

    private static void update2(CategoryMapper mapper) {
        Map<String,Object> params = new HashMap<>();
        params.put("id",3);
        params.put("name", "category3");
        mapper.update2(params);
        listAll(mapper);
    }

    private static void get(CategoryMapper mapper) {
        Category c= mapper.get(3);
        System.out.println(c.getName());
    }

    private static void delete(CategoryMapper mapper) {
        mapper.delete(4);
        listAll(mapper);
    }

    private static void add(CategoryMapper mapper) {
        Category c = new Category();
        c.setName("category4");
        c.setId(4);
        mapper.add(c);
        listAll(mapper);
    }

    private static void listAll(CategoryMapper_dyn mapper) {
        List<Category> cs = mapper.list();
        for (Category c : cs) {
            System.out.println(c.getName());
        }
    }
}