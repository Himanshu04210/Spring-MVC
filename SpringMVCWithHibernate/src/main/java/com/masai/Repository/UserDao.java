package com.masai.Repository;

import java.util.List;

import com.masai.Entities.Users;

public interface UserDao {
	public Users registerUser(Users user);
	public List<Users> getAllUsers();
	public Users findUserByEmail(String email);
}
