package com.company.springsecurity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.springsecurity.entity.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer>{

}
