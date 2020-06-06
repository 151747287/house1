package com.house.service;


import com.house.entity.Users;

/**
 * @author 王建兵
 * @Classname DistrictService
 * @Description TODO
 * @Date 2020/2/25 16:36
 * @Created by Administrator
 */
public interface UserService {
 public int regUser(Users users);



 public Users Login(String username,String password);
}
