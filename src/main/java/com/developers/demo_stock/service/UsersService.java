package com.developers.demo_stock.service;


import java.util.Optional;

import com.developers.demo_stock.entity.Users;
import com.developers.demo_stock.entity.Person;



public interface UsersService {
	    public Iterable<Users> getAllUsers();

	    public void save(Users user);

	    public void delete(Integer id);

	    public Optional<Users> findById(Integer id);
	    
	    public Iterable<Person> findAllPerson();
	
}
