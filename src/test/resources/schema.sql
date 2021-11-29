DROP TABLE IF EXISTS Follow;
DROP TABLE IF EXISTS Student;
DROP TABLE IF EXISTS Course;


CREATE TABLE Student(
                         student_id INT PRIMARY KEY,
                         firstname VARCHAR NOT NULL,
                         lastname VARCHAR NOT NULL
);

CREATE TABLE Course(
                        course_id INT PRIMARY KEY,
                        title VARCHAR NOT NULL,
                        description VARCHAR NOT NULL
);

CREATE TABLE Follow(
                        student_id INT NOT NULL,
                        course_id INT NOT NULL,
                        evaluation INT CHECK (evaluation>=0 AND evaluation<=20),
                        CONSTRAINT PK_Follow PRIMARY KEY(student_id,course_id),
                        CONSTRAINT FK_Student FOREIGN KEY (student_id) REFERENCES Student(student_id),
                        CONSTRAINT FK_Course FOREIGN KEY (course_id) REFERENCES Course(course_id)
);