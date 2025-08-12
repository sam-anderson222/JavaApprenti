package com.example.VoxPopuli.repository;

import com.example.VoxPopuli.model.Poll;

import java.util.List;
import java.util.Optional;

public interface PollRepository {
    List<Poll> getAllPolls();
    Optional<Poll> getPollById(Integer pollId);
}
