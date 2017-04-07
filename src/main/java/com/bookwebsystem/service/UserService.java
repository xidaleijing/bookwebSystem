package com.bookwebsystem.service;

import com.bookwebsystem.model.User;
import com.bookwebsystem.vo.UserVo;

public interface UserService {
	
	public User getUserByUserName(String userName);
	
	/**
	 * 添加用户
	 * @param userVo
	 */
	public void addUser(UserVo userVo);

}
