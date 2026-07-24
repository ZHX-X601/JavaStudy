package com.zhang;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserServiceTest {

//    @BeforeAll
//    public static void beforeAll(){
//        System.out.println("beforeall");
//    }
//    @AfterAll
//    public static void afterAll(){
//        System.out.println("afterAll");
//    }
//
//    @BeforeEach
//    public void beforeEach(){
//        System.out.println("beforeEach");
//    }
//    @AfterEach
//    public void afterEach(){
//        System.out.println("afterEach");
//    }



    @Test
    @DisplayName("测试单个身份证号的年龄获取")//为测试方法添加名称
    public void testgetAge(){
        UserService u = new UserService();
        int age=u.getAge("611022200206128943");
        System.out.println(age);
    }

//    测试单个身份证号的性别获取
    @Test
    @DisplayName("测试单个身份证号的性别获取")//为测试方法添加名称
    public void testgetGende1(){
        UserService u = new UserService();
        String gender=u.getGender("611022200206128943");
        Assertions.assertEquals("女",gender,"性别获取逻辑错误");
        System.out.println(gender);
    }

//    参数化测试: 测试多个身份证号的性别获取
    @DisplayName("测试多个身份证号的性别获取")//为测试方法添加名称
    @ParameterizedTest
    @ValueSource(strings = {"611022200206128943","611022200206128944"})
    public void testgetGende2(String idCard){
        UserService u = new UserService();
        String gender=u.getGender(idCard);
        Assertions.assertEquals("女",gender,"性别获取逻辑错误");
        System.out.println(gender);
    }

    @Test
    @DisplayName("测试异常处理")//为测试方法添加名称
    public void testException(){
        UserService u = new UserService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            u.getAge(null);
        });
    }

}
