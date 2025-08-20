package com.example.VoxPopuli.repository.impl;

import com.example.VoxPopuli.model.*;
import com.example.VoxPopuli.repository.PollOptionRepository;
import com.example.VoxPopuli.repository.PollRepository;
import com.example.VoxPopuli.repository.exceptions.DatabaseErrorException;
import com.example.VoxPopuli.repository.mappers.PollMapper;
import com.example.VoxPopuli.repository.mappers.PollOptionMapper;
import com.example.VoxPopuli.repository.mappers.PollOverviewMapper;
import com.example.VoxPopuli.repository.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Repository
@Primary
public class mySqlPollRepo implements PollRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PollOptionRepository pollOptionRepository;

    @Override
    public List<Poll> getAllPolls() {
        try {
            return jdbcTemplate.execute("{CALL get_all_polls_with_options()}",
                    (CallableStatementCallback<List<Poll>>) cs -> {
                        boolean hasResults = cs.execute();
                        HashMap<Integer, Poll> polls = new HashMap<>();

                        // Get all polls
                        if (hasResults) {
                            try (ResultSet rs = cs.getResultSet()) {
                                while (rs.next()) {
                                    Poll p = PollMapper.pollRowMapper().mapRow(rs, 1);

                                    polls.put(p.getPollId(), p);
                                }
                            }
                        }

                        hasResults = cs.getMoreResults();

                        if (hasResults) {
                            try (ResultSet rs = cs.getResultSet()) {
                                while (rs.next()) {
                                    PollOption po = PollOptionMapper.pollOptionRowMapper().mapRow(rs,1);

                                    polls.get(po.getPollId()).addOption(po);
                                }
                            }
                        }

                        return new ArrayList<>(polls.values());

                    });
        } catch (Exception ex) {
            throw new DatabaseErrorException();
        }
    }

    @Override
    public Optional<Poll> getPollById(Integer pollId) {
        String sql = "SELECT * FROM poll WHERE poll_id = ?";

        try {
            Poll poll = jdbcTemplate.queryForObject(sql, PollMapper.pollRowMapper(), pollId); // Get poll object
            poll.setOptions(pollOptionRepository.getAllPollOptionsForPoll(poll.getPollId())); // Get options for poll.
            return Optional.of(poll);
        } catch (EmptyResultDataAccessException ex) { // If no user found with this id.
            return Optional.empty();
        } catch (Exception ex) {
            throw new DatabaseErrorException();
        }
    }

    @Override
    public List<PollOverview> getAllPollOverviews() {
        try {
            return jdbcTemplate.execute("{CALL get_poll_overviews()}",
                    (CallableStatementCallback<List<PollOverview>>) cs -> {
                        boolean hasResults = cs.execute();

                        HashMap<Integer, PollOverview> overviews = new HashMap<>();

                        // Get poll overview info
                        if (hasResults) {
                            try (ResultSet rs = cs.getResultSet()) {
                                while (rs.next()) {
                                    PollOverview pollOverview = PollOverviewMapper.pollOverviewRowMapper().mapRow(rs, 1);

                                    overviews.put(pollOverview.getPollId(), pollOverview);
                                }
                            }
                        }

                        // Get total votes on each poll.
                        hasResults = cs.getMoreResults();

                        if (hasResults) {
                            try (ResultSet rs = cs.getResultSet()) {
                                while (rs.next()) {
                                    Integer pollId = rs.getInt("poll_id");
                                    Integer pollVotes = rs.getInt("votes");

                                    overviews.get(pollId).setVotesOnPoll(pollVotes);
                                }
                            }
                        }

                        return new ArrayList<>(overviews.values());

                    });
        } catch (Exception ex) {
            throw new DatabaseErrorException();
        }
    }

    @Override
    public boolean savePoll(Poll poll) {
        return false;
    }
}
