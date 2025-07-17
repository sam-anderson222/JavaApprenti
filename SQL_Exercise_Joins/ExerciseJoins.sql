-- 1
SELECT CourseName, CreditHours, subject.SubjectName FROM course
INNER JOIN subject ON course.SubjectID = subject.SubjectID
WHERE SubjectName = 'History'
ORDER BY CourseName;

-- 2
SELECT CourseName, CreditHours, s.SubjectName FROM course c
LEFT JOIN subject s ON c.SubjectID = s.SubjectID
WHERE SubjectName = 'History'
ORDER BY CourseName;

-- 3
SELECT CourseName, CreditHours, s.SubjectName FROM course c
INNER JOIN subject s ON c.SubjectID = s.SubjectID
WHERE SubjectName = 'History'
ORDER BY CourseName;

-- 4
SELECT CourseName, CreditHours, SubjectName FROM course c
INNER JOIN subject s ON c.SubjectID = s.SubjectID
WHERE SubjectName Like '%Art%'
ORDER BY SubjectName, CourseName;

-- 5
SELECT RoomNumber, Description, BuildingName FROM room r
INNER JOIN building b ON b.BuildingID = r.BuildingID
WHERE Description IS NULL;

-- 6
SELECT CourseName FROM course c
INNER JOIN section s ON s.CourseID = c.CourseID
INNER JOIN teacher t ON t.TeacherID = s.TeacherID
WHERE t.FirstName = 'Geno' AND t.LastName = 'Booy';

