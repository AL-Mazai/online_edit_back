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



}
