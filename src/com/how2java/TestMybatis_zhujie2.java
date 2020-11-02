package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.how2java.mapper.CategoryMapper2;
import com.how2java.mapper.ProductMapper2;
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
        ProductMapper2 mapper2 = session.getMapper(ProductMapper2.class);

        listAll_1_N(mapper);
        listAll_N_1(mapper2);

        session.commit();
        session.close();

    }

    private static void listAll_1_N(CategoryMapper2 mapper) {
        List<Category> cs = mapper.list();
        for (Category c : cs) {
            System.out.println(c);
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t"+p);
            }
        }
    }

    private static void listAll_N_1(ProductMapper2 mapper2) {
        List<Product> ps = mapper2.list();
        for (Product p:ps) {
            System.out.println(p + "\t对应的分类是:\t" + p.getCategory());
        }
    }
}