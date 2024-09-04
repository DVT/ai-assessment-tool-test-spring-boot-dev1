package com.hackerrank.stocktrade.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.stocktrade.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
