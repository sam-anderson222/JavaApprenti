package com.example.VoxPopuli.repository;

import com.example.VoxPopuli.model.PollOption;

import java.util.List;
import java.util.Optional;

public interface PollOptionRepository {
    List<PollOption> getAllPollOptionsForPoll(Integer pollId);
    Optional<PollOption> getCertainPollOptionFromPoll(Integer pollId, Integer optionNumber);
}
