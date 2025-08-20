package com.example.VoxPopuli.repository.impl;

import com.example.VoxPopuli.model.PollOption;
import com.example.VoxPopuli.repository.PollOptionRepository;
import com.example.VoxPopuli.repository.exceptions.DatabaseErrorException;
import com.example.VoxPopuli.repository.mappers.PollOptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@Primary
public class mySqlPollOptionRepo implements PollOptionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PollOption> getAllPollOptions() {
        String sql = "SELECT * FROM poll_options";

        try {
            return jdbcTemplate.query(sql, PollOptionMapper.pollOptionRowMapper());
        } catch (Exception ex) {
            throw new DatabaseErrorException();
        }
    }

    @Override
    public List<PollOption> getAllPollOptionsForPoll(Integer pollId) {
        String sql = "SELECT * FROM poll_options WHERE poll_id = ?";

        try {
            return jdbcTemplate.query(sql, PollOptionMapper.pollOptionRowMapper(), pollId);
        } catch (Exception ex) {
            throw new DatabaseErrorException();
        }
    }

    @Override
    public Optional<PollOption> getCertainPollOptionFromPoll(Integer pollId, Integer optionNumber) {
        String sql = "SELECT * FROM poll_options WHERE poll_id = ? AND option_number = ?";

        try {
            PollOption po = jdbcTemplate.queryForObject(sql, PollOptionMapper.pollOptionRowMapper(), pollId, optionNumber);
            return Optional.of(po);
        } catch (EmptyResultDataAccessException ex) { // If no user found with this id.
            return Optional.empty();
        } catch (Exception ex) {
            throw new DatabaseErrorException();
        }
    }
}
