package com.company.handlinguserauthentication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.handlinguserauthentication.entity.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer>{

}
