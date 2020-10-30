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


//<!--xml方式的基本CRUD查询 测试-->
public class TestMybatis {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();

        /*
        List<Category> c3= session.selectList("listCategoryByName", "co");
        for (Category c:c3) {
            System.out.println("模糊查询" + c.getName());
        } */

        Category c = new Category();
        c.setId(4);
        c.setName("category4");
        session.insert("addCategory", c);

        session.delete("deleteCategory", c);
        session.delete("deleteCategory", 4);


        Category c1 = session.selectOne("getCategory", 2);
        c1.setName("category2");
        session.update("updateCategory", c1);


        Map<String,Object> params = new HashMap<>();
        params.put("id",3);
        params.put("name", "category3"); //selectList方法只接受一个参数对象，所以需要把多个参数放在Map里
        List<Category> c2 = session.selectList("listCategoryByIdAndName", params);
        for (Category category:c2) {
            System.out.println("多条件查询"+ category.getName());
        }

        session.update("updateCategory", params);

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