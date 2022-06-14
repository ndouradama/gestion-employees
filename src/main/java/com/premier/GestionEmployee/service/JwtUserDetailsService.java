package com.premier.GestionEmployee.service;

import java.util.ArrayList;
import java.util.Optional;

import com.premier.GestionEmployee.model.Employees;
import com.premier.GestionEmployee.model.Users;
import com.premier.GestionEmployee.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public Iterable<Users> getUsers() {
		return usersRepository.findAll();
	}
	public Optional<Users> getUsers(Long id) {
        return usersRepository.findById(id);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User (user.getUsername(), user.getPassword(),
				new ArrayList<>());}

		public Users saveUsers(Users users) {
			users.setPassword(bcryptEncoder.encode(users.getPassword()));
			return usersRepository.save(users);


	}
}