package com.how2java;
 
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.how2java.pojo.Category;

public class TestMybatis {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();

        /*Category c = new Category();
        c.setId(40);
        c.setName("corn40");
        session.insert("addCategory", c);

        Category c1 = new Category();
        c1.setId(9);
        session.delete("deleteCategory", c1);

        Category c2 = session.selectOne("getCategory", 8);
        c2.setName("修改");
        session.update("updateCategory", c2);

        List<Category> c3= session.selectList("listCategoryByName", "co");
        for (Category c:c3) {
            System.out.println("模糊查询" + c.getName());
        } */

        Map<String,Object> params = new HashMap<>();
        params.put("id",2);
        params.put("name", "cat"); //selectList方法只接受一个参数对象，所以需要把多个参数放在Map里
        List<Category> c4 = session.selectList("listCategoryByIdAndName", params);
        for (Category c:c4) {
            System.out.println("多条件查询"+ c.getName());
        }

        listALL(session);
        session.commit();
        session.close();
    }

    private static void listALL(SqlSession session) {
        List<Category> cs=session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getName());
        }
    }
}