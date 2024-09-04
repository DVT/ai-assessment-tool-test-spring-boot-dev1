package com.demo.dev1.stocktrade.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.dev1.stocktrade.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
