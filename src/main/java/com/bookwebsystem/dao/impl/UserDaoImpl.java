package com.bookwebsystem.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bookwebsystem.dao.UserDao;
import com.bookwebsystem.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User getByUserName(String userName) {
		String hql=" from "+User.class.getName()+" t where t.userName=:userName ";
		Map<String, Object> mapParams=new HashMap<String,Object>();
		mapParams.put("userName", userName);
		return getSingleObject(hql, mapParams);
	}

	@Override
	public void addUser(User user) {
		addObj(user);
	}

}
