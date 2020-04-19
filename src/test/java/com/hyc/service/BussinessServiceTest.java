package com.hyc.service; 

import com.hyc.dao.UserMapper;
import com.hyc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/** 
* BussinessService Tester. 
* 
* @author zhangzb10
* @version 1.0 
*/ 

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BussinessServiceTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSaveAll() throws Exception { 
    
    } 

    @Test
    public void testSaveProduct() throws Exception { 
    
    } 

    @Test
    public void testSaveUser() throws Exception { 
    
    } 

    @Test
    public void testFindAll() throws Exception {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    } 

    @Test
    public void testSelectById() throws Exception { 
    
    } 

    @Test
    public void testSelectByAge() throws Exception { 
    
    } 


} 
