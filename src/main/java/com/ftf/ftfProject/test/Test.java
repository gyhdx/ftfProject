package com.ftf.ftfProject.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;

public class Test {

    public static void main(String[] args) throws Exception {
        //com.ftf.ftfProject.service.impl.MessageServiceImpl
        //dao/UserDao.xml
//        BufferedReader reader = new BufferedReader(new FileReader("E:\\java\\idea\\project\\ftfProject\\src\\main\\resources\\dao\\UserDao.xml"));
        InputStream resourceAsStream = Test.class.getClassLoader().getResourceAsStream("dao/UserDao.xml");
        System.out.println((char) resourceAsStream.read());
//        System.out.println(reader.readLine());
    }
}
