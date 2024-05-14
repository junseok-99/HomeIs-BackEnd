package com.homeis.user.model.service;

import java.util.List;

import com.homeis.user.dto.DongCode;
import com.homeis.user.dto.User;

public interface UserService {
	String login(User loginInfo);
	int register(User userInfo);
	User idExist(String userId);
	User getUserInfo(String id);
	int updateUserInfo(User user);
	int deleteUser(String userId);
	List<DongCode> getInterestArea(String userId);
}
