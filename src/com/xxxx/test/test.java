package com.xxxx.test;

import com.xxxx.entity.Files;
import com.xxxx.entity.User;
import com.xxxx.mapper.FilesMapper;
import com.xxxx.mapper.UserMapper;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class test {
    public static void main(String[] args) {
        SqlSession session= GetSqlSession.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName("1");
        System.out.println(user);

        SqlSession session1= GetSqlSession.createSqlSession();
        FilesMapper filesMapper = session1.getMapper(FilesMapper.class);
        Files file = filesMapper.queryUserById("1");
        System.out.println(file);
    }
}