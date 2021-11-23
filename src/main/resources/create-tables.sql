DROP TABLE Student;
DROP TABLE Course;
DROP TABLE Follow;

CREATE TABLE Student (
    student_id SERIAL PRIMARY KEY,
    firstname VARCHAR NOT NULL,
    lastname VARCHAR NOT NULL
);

CREATE TABLE Course (
    course_id SERIAL PRIMARY KEY,
    title VARCHAR NOT NULL,
    description VARCHAR NOT NULL
);

CREATE TABLE Follow (
    student_id SERIAL NOT NULL,
    course_id SERIAL NOT NULL,
    evaluation INT NOT NULL CHECK (evaluation>=0 AND evaluation<=20),
    CONSTRAINT PK_Follow PRIMARY KEY(student_id,course_id),
    CONSTRAINT FK_Student FOREIGN KEY (student_id) REFERENCES Student(student_id),
    CONSTRAINT FK_Course FOREIGN KEY (course_id) REFERENCES Course(course_id)
);



INSERT INTO Student VALUES(1,'Yoann','PERIQUOI');
INSERT INTO Student VALUES(2,'Matteo','ORDRENNEAU');
INSERT INTO Student VALUES(3,'Jules','CARPIO');
INSERT INTO Student VALUES(4,'Matthis','HOULES');
INSERT INTO Student VALUES(5,'Thomas','HAMMON');
INSERT INTO Student VALUES(6,'Yassine','SMARA');
INSERT INTO Student VALUES(7,'Erwan','BESTARD');
INSERT INTO Student VALUES(8,'Pierre','LAFON');
INSERT INTO Student VALUES(9,'Donovan','BRUN');

INSERT INTO Course VALUES(1,'Software Design','Design patterns and Spring framework');
INSERT INTO Course VALUES(2,'Maths Basics','Basics Maths normally seen during preparatory class');

INSERT INTO Follow VALUES(1,1,18);
INSERT INTO Follow VALUES(1,2,2);
INSERT INTO Follow VALUES(2,1,11);
INSERT INTO Follow VALUES(2,2,5);
INSERT INTO Follow VALUES(3,1,12);
INSERT INTO Follow VALUES(3,2,5);
INSERT INTO Follow VALUES(4,1,11);
INSERT INTO Follow VALUES(4,2,17);
INSERT INTO Follow VALUES(5,1,16);
INSERT INTO Follow VALUES(5,2,4);
INSERT INTO Follow VALUES(6,1,8);
INSERT INTO Follow VALUES(6,2,12);
INSERT INTO Follow VALUES(7,1,14);
INSERT INTO Follow VALUES(7,2,9);
INSERT INTO Follow VALUES(8,1,10);
INSERT INTO Follow VALUES(8,2,11);
INSERT INTO Follow VALUES(9,1,4);
INSERT INTO Follow VALUES(9,2,17);
