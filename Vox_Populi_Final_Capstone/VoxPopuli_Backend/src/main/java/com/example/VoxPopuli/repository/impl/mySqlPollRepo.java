package com.example.VoxPopuli.repository.impl;

import com.example.VoxPopuli.model.Poll;
import com.example.VoxPopuli.model.User;
import com.example.VoxPopuli.repository.PollRepository;
import com.example.VoxPopuli.repository.exceptions.DatabaseErrorException;
import com.example.VoxPopuli.repository.mappers.PollMapper;
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
public class mySqlPollRepo implements PollRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Poll> getAllPolls() {
        String sql = "SELECT * FROM poll";

        try {
            return jdbcTemplate.query(sql, PollMapper.pollRowMapper());
        } catch (Exception ex) {
            throw new DatabaseErrorException();
        }
    }

    @Override
    public Optional<Poll> getPollById(Integer pollId) {
        String sql = "SELECT * FROM poll WHERE poll_id = ?";

        try {
            Poll poll = jdbcTemplate.queryForObject(sql, PollMapper.pollRowMapper(), pollId);
            return Optional.of(poll);
        } catch (EmptyResultDataAccessException ex) { // If no user found with this id.
            return Optional.empty();
        } catch (Exception ex) {
            throw new DatabaseErrorException();
        }
    }
}
