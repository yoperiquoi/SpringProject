CREATE TABLE Student (
                         STUDENT_ID INT PRIMARY KEY,
                         FIRSTNAME VARCHAR NOT NULL,
                         LASTNAME VARCHAR NOT NULL
);

CREATE TABLE course (
                        COURSE_ID INT PRIMARY KEY,
                        TITLE VARCHAR NOT NULL,
                        DESCRIPTION VARCHAR NOT NULL
);

CREATE TABLE follow (
                        STUDENT_ID INT NOT NULL,
                        COURSE_ID INT NOT NULL,
                        evaluation INT CHECK (evaluation>=0 AND evaluation<=20),
                        CONSTRAINT PK_Follow PRIMARY KEY(STUDENT_ID,COURSE_ID),
                        CONSTRAINT FK_Student FOREIGN KEY (STUDENT_ID) REFERENCES Student(STUDENT_ID),
                        CONSTRAINT FK_Course FOREIGN KEY (COURSE_ID) REFERENCES course(COURSE_ID)
);