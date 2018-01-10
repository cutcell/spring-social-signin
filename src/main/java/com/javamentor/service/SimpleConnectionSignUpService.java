package com.javamentor.service;

import com.javamentor.dao.UsersDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

public class SimpleConnectionSignUpService implements ConnectionSignUp {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleConnectionSignUpService.class);

    private UsersDao usersDao;

    public SimpleConnectionSignUpService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public String execute(Connection<?> connection) {

        UserProfile profile = connection.fetchUserProfile();

        LOGGER.debug("Fetched profile id: {}", profile.getId());
        LOGGER.debug("Fetched profile username: {}", profile.getUsername());

        usersDao.createUser(profile.getUsername());

        return profile.getUsername();
    }
}
