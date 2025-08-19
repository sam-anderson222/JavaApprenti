USE vox_populi;

DROP PROCEDURE IF EXISTS get_poll_overviews;

DELIMITER //

CREATE PROCEDURE get_poll_overviews()
BEGIN
	SELECT poll_id, poll_author, username, poll_title, poll_description FROM poll
    INNER JOIN users ON users.user_id = poll.poll_author;
	SELECT poll_id, COUNT(*) AS votes FROM poll_votes GROUP BY poll_id;
END //