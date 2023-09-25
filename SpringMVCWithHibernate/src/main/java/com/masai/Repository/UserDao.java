package com.masai.Repository;

import java.util.List;

import com.masai.Entities.Users;
import com.masai.Entities.VaccinatedUsers;

public interface UserDao {
	public Users registerUser(Users user);
	public List<Users> getAllUsers();
	public Users findUserByEmail(String email);
	public Users deleteUserById(int userId);
	
	public VaccinatedUsers addVaccinatedUser(VaccinatedUsers vaccinatedUsers);
	public List<VaccinatedUsers> getAllVaccinatedUsers();
}
