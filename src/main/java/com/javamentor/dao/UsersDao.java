package com.javamentor.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createUser(String userId) {

        jdbcTemplate.update("INSERT into users(username,password,enabled) values(?,?,true)",userId, "");
        jdbcTemplate.update("INSERT into authorities(username,authority) values(?,?)",userId,"USER");

    }

}
