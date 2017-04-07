package com.bookwebsystem.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.bookwebsystem.dao.UserDao;
import com.bookwebsystem.model.User;
import com.bookwebsystem.service.UserService;
import com.bookwebsystem.vo.UserVo;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public User getUserByUserName(String userName) {
		return userDao.getByUserName(userName);
	}

	@Override
	public void addUser(UserVo userVo) {
		User oldUser=userDao.getByUserName(userVo.getUserName());
		if(oldUser!=null)throw new RuntimeException("该用户名已经被注册");
		oldUser=new User();
		oldUser.setAge(userVo.getAge());
		oldUser.setEmail(userVo.getEmail());
		oldUser.setPassWord(userVo.getPassWord());
		oldUser.setRealName(userVo.getRealName());
		oldUser.setSex(userVo.getSex());
		oldUser.setTelephone(userVo.getTelephone());
		oldUser.setUserName(userVo.getUserName());
		userDao.addUser(oldUser);
	}
	
}
