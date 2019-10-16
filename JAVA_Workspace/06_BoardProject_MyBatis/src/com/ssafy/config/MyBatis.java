package com.ssafy.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatis {
    // mybatis.xml 위치
    private final static String RESOURCE = "com/ssafy/config/SqlMapConfig.xml";
    private static SqlSessionFactory sqlMapper = null;
    // MyBatis 세션을 얻는 메소드
    public static SqlSession getSqlSession() {
         if (sqlMapper == null) {
               Reader reader= null;
               try {
                     // mybatis.xml 자원을 얻는다.
                     reader = Resources.getResourceAsReader(RESOURCE);
                     sqlMapper = new SqlSessionFactoryBuilder().build(reader);
                     
               } catch (IOException e) {
                     e.printStackTrace();
               }finally {
            	   if(reader!=null) {
            		   try{reader.close();}catch(Exception e) {}
            	   }
               }
         }
         return sqlMapper.openSession();
    }
}

