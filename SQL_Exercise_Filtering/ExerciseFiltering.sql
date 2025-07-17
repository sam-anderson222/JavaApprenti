USE simpleschool;

-- 1
SELECT StudentID, LastName, FirstName FROM student
WHERE LastName LIKE 'Cr%';
-- 2
SELECT * FROM course
WHERE SubjectID = 1 OR SubjectID = 2 OR SubjectID = 4;
-- 3
SELECT * FROM course
WHERE SubjectID IN (1,2,4);
-- 4
SELECT * FROM student
WHERE StudentID = 42;
-- 5
SELECT * FROM student
WHERE FirstName LIKE 'C%';
-- 6
SELECT * FROM student
WHERE FirstName BETWEEN 'Ce' AND 'Cf';
-- 7 
SELECT FirstName FROM student
LIMIT 10;
-- 8
SELECT * FROM student
LIMIT 10;
-- 9
SELECT * FROM student
ORDER BY LastName DESC
LIMIT 5;

