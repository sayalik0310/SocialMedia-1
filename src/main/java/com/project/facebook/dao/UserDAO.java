package com.project.facebook.dao;

import com.project.facebook.models.User;

public interface UserDAO {

	void login(String mail, String pass);

	void signup(User user);

	void updateProfile(String mail);

	void deleteProfile(String mail);

	void viewAllPosts(String mail);

	void showTimeline(String mail);

	void searchProfle(String next);

}
