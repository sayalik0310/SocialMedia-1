package com.project.facebook.dao;

import com.project.facebook.models.Posts;

public interface PostDAO {
	
	void createPost(Posts post);
	void viewPosts();
}
