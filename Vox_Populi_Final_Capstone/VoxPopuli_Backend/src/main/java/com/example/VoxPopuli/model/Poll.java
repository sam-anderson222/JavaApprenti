package com.example.VoxPopuli.model;

public class Poll {
    private Integer pollId;
    private Integer pollAuthor;
    private String pollTitle;
    private String pollDescription;

    public Poll() {}

    public Poll (Integer pollId, Integer pollAuthor, String pollTitle, String pollDescription) {
        this.pollId = pollId;
        this.pollAuthor = pollAuthor;
        this.pollTitle = pollTitle;
        this.pollDescription = pollDescription;
    }

    // Getters

    public Integer getPollId() {
        return pollId;
    }

    public Integer getPollAuthor() {
        return pollAuthor;
    }

    public String getPollDescription() {
        return pollDescription;
    }

    public String getPollTitle() {
        return pollTitle;
    }

    // Setters


    public void setPollId(Integer pollId) {
        this.pollId = pollId;
    }

    public void setPollAuthor(Integer pollAuthor) {
        this.pollAuthor = pollAuthor;
    }

    public void setPollTitle(String pollTitle) {
        this.pollTitle = pollTitle;
    }

    public void setPollDescription(String pollDescription) {
        this.pollDescription = pollDescription;
    }

    @Override
    public String toString() {
        return String.format("Poll{pollID=%d, pollAuthor=%d, pollTitle=%s, pollDescription=%s}", pollId, pollAuthor, pollTitle, pollDescription);
    }
}
