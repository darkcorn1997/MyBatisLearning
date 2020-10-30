package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.how2java.mapper.CategoryMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;


/*注解方式的连接查询 一对N 测试*/
public class TestMybatis_zhujie2 {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        CategoryMapper2 mapper = session.getMapper(CategoryMapper2.class);

        listAll(mapper);

        session.commit();
        session.close();

    }

    private static void listAll(CategoryMapper2 mapper) {
        List<Category> cs = mapper.list();
        for (Category c : cs) {
            System.out.println(c.getName());
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t"+p.getName());
            }
        }
    }
}