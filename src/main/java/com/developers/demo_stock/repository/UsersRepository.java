package com.developers.demo_stock.repository;


import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.developers.demo_stock.entity.Users;


@Repository
public interface UsersRepository extends CrudRepository<Users, Integer>{
    Users findByUsername(String username);
        
    
}
