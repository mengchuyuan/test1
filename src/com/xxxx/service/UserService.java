package com.xxxx.service;

import com.xxxx.entity.User;
import com.xxxx.entity.vo.MessageModel;
import com.xxxx.mapper.UserMapper;
import com.xxxx.util.GetSqlSession;
import com.xxxx.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.File;

public class UserService {
    public MessageModel userLogin(String uname, String upwd) {
        MessageModel messageModel = new MessageModel();

        User u = new User();
        u.setUserId(uname);
        u.setUserPwd(upwd);
        messageModel.setObject(u);


        if (uname == null || StringUtil.isEmpty(upwd)) {
            messageModel.setCode(0);
            messageModel.setMsg("用户名与密码不能为空！");
            return messageModel;
        }

        SqlSession session = GetSqlSession.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName(uname);




        if (user == null) {
            messageModel.setMsg("用户不存在！！");
            messageModel.setCode(0);

            return messageModel;
        }

        if (!upwd.equals(user.getUserPwd())) {
            messageModel.setCode(0);
            messageModel.setMsg("用户密码不正确！");
            return messageModel;
        }
        messageModel.setObject(user);


        return messageModel;
    }
}