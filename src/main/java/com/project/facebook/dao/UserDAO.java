package com.project.facebook.dao;

import com.project.facebook.models.User;

public interface UserDAO {

	void login(String mail, String pass);

	void signup(User user);

}
