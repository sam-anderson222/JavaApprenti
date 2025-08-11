USE vox_populi;

INSERT INTO users (username, user_password) VALUES 
("TestUser1", "TestPassword1"),
("TestUser2", "TestPassword2"),
("TestUser3", "TestPassword3");

INSERT INTO poll (poll_author, poll_title, poll_description) VALUES
(1, "Coke Or Pepsi?", "The age old question: Coke Vs. Pepsi?"),
(2, "Which Season Do You Think is Best?", "Cold or Hot? Which season of the year do you like the most?"),
(3, "Best Genre of Music?", "Pick which genre of music you like the most!"),
(1, "Best Soda Brand?", "Which soft drink brand do you like more?");

INSERT INTO poll_options (poll_id, option_number, option_name) VALUES
(1, 1, "Coke"),
(1, 2, "Pepsi"),
(2, 1, "Winter"),
(2, 2, "Spring"),
(2, 3, "Summer"),
(2, 4, "Autumn"),
(3, 1, "Rock"),
(3, 2, "Pop"),
(3, 3, "Rap"),
(3, 4, "Classical"),
(3, 5, "Jazz"),
(3, 6, "R&B"),
(3, 7, "Country"),
(4, 1, "Coke"), -- Notice how coke can be used as an option across different polls, but can't be used twice or more in the same poll.
(4, 2, "Pepsi"),
(4, 3, "Dr.Pepper"),
(4, 4, "Sprite"),
(4, 5, "Fanta");

SELECT * FROM users;

SELECT * FROM poll
INNER JOIN users u ON poll_author = user_id;

SELECT * FROM poll_options;

SELECT * FROM poll_options WHERE poll_id = 3;

