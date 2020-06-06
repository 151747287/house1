package com.house.service.impl;

import com.house.entity.Users;
import com.house.entity.UsersExample;
import com.house.mapper.UsersMapper;
import com.house.service.UserService;
import com.house.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired (required = false)
    private UsersMapper usersMapper;
    @Override
    public int regUser(Users users) {
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users Login(String username, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password
        ));
        List<Users>list=usersMapper.selectByExample(usersExample);

        if(list!=null && list.size()==1){
            return list.get(0);  //返回第一个对象
        }
        else
            return null;
    }
}
