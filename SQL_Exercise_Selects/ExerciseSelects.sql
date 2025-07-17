USE simpleschool;

-- 1
SELECT 'All for one, and one for all';
-- 2
SELECT concat('All for one,', 'and one for all');
-- 3
SELECT 6 + 6;
-- 4
SELECT 5 / 2;
-- 5
SELECT 5.0 / 2.0;
-- 6 
SELECT 6 / 4, 6 % 4;
-- 7
 SELECT pow(6,2);
-- 8
SELECT * FROM building;
-- 9
SELECT PeriodName, StartTime, EndTime FROM period;
-- 10
SELECT count(*) from grade;
-- 11
SELECT concat(CourseName, ' (', CreditHours, ')')
FROM course;
-- 12
SELECT concat(FirstName, ' ', LastName) 
FROM teacher
LIMIT 5;
-- 13
SELECT count(*) FROM room;
-- 14
SELECT '-2,147,483,648 to 2,147,483,647';
-- 15
SELECT Description FROM room; -- Gives extra info. on the type of room. Null is a normal classroom I believe, while other values indicate the room being something else (ex. Gym / Lab)
-- 16
SELECT COUNT(DISTINCT SubjectID) FROM subject; -- SubjectID is PK, so distinct is redudant, but I'm still using it regardless.
-- 17
SELECT COUNT(*) FROM gradetype;
-- 18
SELECT GradeTypeID, GradeTypeName FROM gradetype;
-- 19
SELECT DISTINCT gi.GradeTypeID, gt.GradeTypeName from gradeitem gi
INNER JOIN gradetype gt ON gt.GradeTypeID = gi.GradeTypeID;
-- 20
SELECT GradeTypeID, GradeTypeName from gradetype
WHERE GradeTypeID NOT IN (SELECT GradeTypeID FROM gradeitem);