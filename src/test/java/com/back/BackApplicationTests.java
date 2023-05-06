package com.back;

import com.back.mapper.DocumentMapper;
import com.back.mapper.UserMapper;
import com.back.pojo.Document;
import com.back.pojo.User;
import com.back.service.UserService;
import com.back.service.impl.UserServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@SpringBootTest
class BackApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DocumentMapper documentMapper;

    @Test
    public void getAllUserTest(){
        List<User> userList = userService.getAllUser();
        System.out.println(userList);
    }

    @Test
    public void addUserTest(){
        User user = new User();
        user.setUserId(12);
        user.setUserName("zzw");
        user.setPassword("123");
        int isSuccessAdd = userMapper.insertUser(user);
        System.out.println(isSuccessAdd);
    }

    @Test
    public void testAdd() throws IOException {
//获取参数
//doc_id,doc_name,doc_content,type,created_time,status

        int doc_id=1;
        String doc_name="波导";
        String doc_content="战斗机";
        String type="docx";
        Date created_time=new Date(2003,8,11);
        boolean status=true;

//        封装对象
        Document document=new Document();
        document.setDocId(doc_id);
        document.setDocName(doc_name);
        document.setDocContent(doc_content);
        document.setType(type);
        document.setCreatedTime(created_time);
        document.setStatus(status);

        int r=documentMapper.insertDoc(document);
        int id=document.getDocId();
        System.out.println(id+","+r);
//        提交事务
//        sqlSession.commit();
//
//        sqlSession.close();
    }

}
