DROP TABLE IF EXISTS follow;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS course;


CREATE TABLE student (
    student_id INT PRIMARY KEY,
    firstname VARCHAR NOT NULL,
    lastname VARCHAR NOT NULL
);

CREATE TABLE course (
    course_id INT PRIMARY KEY,
    title VARCHAR NOT NULL,
    description VARCHAR NOT NULL
);

CREATE TABLE follow (
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    evaluation INT CHECK (evaluation>=0 AND evaluation<=20),
    CONSTRAINT PK_FOLLOW PRIMARY KEY(student_id,course_id),
    CONSTRAINT FK_STUDENT FOREIGN KEY (student_id) REFERENCES STUDENT(student_id),
    CONSTRAINT FK_COURSE FOREIGN KEY (course_id) REFERENCES COURSE(course_id)
);

INSERT INTO student VALUES(1,'Yoann','PERIQUOI');
INSERT INTO student VALUES(2,'Matteo','ORDRENNEAU');
INSERT INTO student VALUES(3,'Duane','CARPIO');
INSERT INTO student VALUES(4,'Matthis','HOULES');
INSERT INTO student VALUES(5,'Thomas','HAMMON');
INSERT INTO student VALUES(6,'Yassine','SMARA');
INSERT INTO student VALUES(7,'Erwan','BESTARD');
INSERT INTO student VALUES(8,'Pierre','LAFON');
INSERT INTO student VALUES(9,'Donovan','BRUN');

INSERT INTO course VALUES(1,'Software Design','Design patterns and Spring framework');
INSERT INTO course VALUES(2,'Maths Basics','Basics Maths normally seen during preparatory class');

INSERT INTO follow VALUES(1,1,NULL);
INSERT INTO follow VALUES(1,2,NULL);
INSERT INTO follow VALUES(2,1,NULL);
INSERT INTO follow VALUES(2,2,NULL);
INSERT INTO follow VALUES(3,1,NULL);
INSERT INTO follow VALUES(3,2,NULL);
INSERT INTO follow VALUES(4,1,NULL);
INSERT INTO follow VALUES(4,2,NULL);
INSERT INTO follow VALUES(5,1,NULL);
INSERT INTO follow VALUES(5,2,NULL);
INSERT INTO follow VALUES(6,1,NULL);
INSERT INTO follow VALUES(6,2,NULL);
INSERT INTO follow VALUES(7,1,NULL);
INSERT INTO follow VALUES(7,2,NULL);
INSERT INTO follow VALUES(8,1,NULL);
INSERT INTO follow VALUES(8,2,NULL);
INSERT INTO follow VALUES(9,1,NULL);
INSERT INTO follow VALUES(9,2,NULL);