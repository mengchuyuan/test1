package com.xxxx.service;

import com.xxxx.entity.Files;
import com.xxxx.mapper.FilesMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FilesServiceImpl implements FilesService{
    @Override
    public List<Files> selectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        FilesMapper filesMapper = sqlSession.getMapper(FilesMapper.class);
        List<Files> files = filesMapper.selectAll();
        return  files;

    }
}
