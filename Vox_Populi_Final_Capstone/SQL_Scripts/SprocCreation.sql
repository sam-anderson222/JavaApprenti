USE vox_populi;

DROP PROCEDURE IF EXISTS get_poll_overviews;
DROP PROCEDURE IF EXISTS get_all_polls_with_options;

DELIMITER //

CREATE PROCEDURE get_poll_overviews()
BEGIN
	SELECT poll_id, poll_author, username, poll_title, poll_description FROM poll
    INNER JOIN users ON users.user_id = poll.poll_author;
	SELECT poll_id, COUNT(*) AS votes FROM poll_votes GROUP BY poll_id;
END //

CREATE PROCEDURE get_all_polls_with_options()
BEGIN
	SELECT * FROM poll;
    SELECT * FROM poll_options ORDER BY poll_id, option_number;
END //