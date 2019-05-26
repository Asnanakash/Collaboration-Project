package com.coll.dao;

import com.coll.model.UserDetail;

public interface UserDAO
{
	public boolean registerUser(UserDetail user);
	public boolean updateUserDetail(UserDetail user);
	public boolean deleteUserDetail(UserDetail user);
	public UserDetail getUser(String username);
	public boolean makeOffLine(UserDetail user);
	public boolean makeOnLine(UserDetail user);
	public boolean approveUser(UserDetail user);
	public boolean rejectUser(UserDetail user);
}
