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
                        CONSTRAINT pk_follow PRIMARY KEY(student_id,course_id),
                        CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES student(student_id),
                        CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES course(course_id)
);