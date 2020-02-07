package com.developers.demo_stock.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.Users;
import com.developers.demo_stock.entity.Person;
import com.developers.demo_stock.repository.UsersRepository;
import com.developers.demo_stock.repository.PersonRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepo;
    
    
    @Autowired
    PersonRepository personRepo;

    @Autowired
    BCryptPasswordEncoder encoder; 
    
    @Override
    @Transactional(readOnly = true)
    public Iterable<Users> getAllUsers() {
        return usersRepo.findAll();
    }

    @Override
    @Transactional
    public void save(Users users) {
        users.setPassword(encoder.encode(users.getPassword()));
        usersRepo.save(users);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        usersRepo.deleteById(id);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Users> findById(Integer id) {
        return usersRepo.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Person> findAllPerson() {
        return personRepo.findAll();
    }

    

}
