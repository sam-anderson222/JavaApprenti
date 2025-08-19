package com.example.VoxPopuli.repository.impl;

import com.example.VoxPopuli.model.User;
import com.example.VoxPopuli.model.UserLogInAttempt;
import com.example.VoxPopuli.repository.UserRepository;
import com.example.VoxPopuli.repository.exceptions.DatabaseErrorException;
import com.example.VoxPopuli.repository.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class mySqlUserRepo implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUsers() throws DatabaseErrorException {
        String sql = "SELECT * FROM users";

        try {
            return jdbcTemplate.query(sql, UserMapper.userRowMapper());
        } catch (Exception ex) {
            throw new DatabaseErrorException();
        }
    }

    @Override
    public Optional<User> getUserById(Integer userId) throws DatabaseErrorException {
        String sql = "SELECT * FROM users WHERE user_id = ?";

        try {
            User u = jdbcTemplate.queryForObject(sql, UserMapper.userRowMapper(), userId);
            return Optional.of(u);
        } catch (EmptyResultDataAccessException ex) { // If no user found with this id.
            return Optional.empty();
        }
        catch (Exception ex) {
            throw new DatabaseErrorException();
        }
    }

    @Override
    public Optional<User> logIn(UserLogInAttempt logInInfo) {
        String sql = "SELECT * FROM users WHERE username = ? AND BINARY user_password = ?";

        try {
            User u = jdbcTemplate.queryForObject(sql, UserMapper.userRowMapper(), logInInfo.getUsername(), logInInfo.getUserPassword());
            return Optional.of(u);
        }  catch (EmptyResultDataAccessException ex) { // If invalid log in details, then return this.
            return Optional.empty();
        }
        catch (Exception ex) {
            throw new DatabaseErrorException();
        }
    }

    @Override
    public User registerUser(User user) {
        return null;
    }

    @Override
    public User updateRegisteredUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUserById(Integer userId) {
        return false;
    }
}
