//package com.premier.GestionEmployee.service;
//
//import com.premier.GestionEmployee.model.Employees;
//import com.premier.GestionEmployee.model.Users;
//import com.premier.GestionEmployee.repository.EmployeesRepository;
//import com.premier.GestionEmployee.repository.UsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Optional;
//
//public class UsersService {
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    public Optional<Users> getUsers(Long id) {
//        return usersRepository.findById(id);
//    }
//
//    public Iterable<Users> getUsers() {
//        return usersRepository.findAll();
//    }
//
//    public void deleteUsers(final Long id) {
//        usersRepository.deleteById(id);
//    }
//
//    public Users saveUsers(Users users) {
//        Users savedUsers = (Users) usersRepository.save(users);
//        return savedUsers;
//    }
//}
