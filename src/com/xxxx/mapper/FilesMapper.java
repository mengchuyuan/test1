package com.xxxx.mapper;

import com.xxxx.entity.Files;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FilesMapper {
    public  Files queryUserById(String userId);
    @Select("select * from files")

    List<Files> selectAll();
}
