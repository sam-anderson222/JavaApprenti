USE casting_exercise;

-- (1)
-- MySQL doesn't have a title case function (Ex: INITCAP()) and I'm writing one myself.
-- Database is case-insensitive!
-- SELECT * FROM customers WHERE First_Name = 'JOHN';

-- (2)
-- In the orders table, order_total needs to be casted as it is VARCHAR instead of a DECIMAL
SELECT CAST(order_total AS DECIMAL(10,2)) AS formatted_total FROM orders;

-- (3)
SELECT date_format(order_date, '%M %d, %Y') AS order_date,
FORMAT(CAST(order_total AS DECIMAL(10,2)), 2) AS order_total
FROM orders;
