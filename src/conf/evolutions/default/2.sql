# --- Sample dataset

# --- !Ups

insert into user (type, username, first_name, last_name, email_address) values ('student', 'john.doe', 'John', 'Doe', 'john@doe.com');

insert into subject (name, abbreviation) values ('Software Engineering', 'SER');
insert into subject (name, abbreviation) values ('Mathematics', 'MAT');
insert into subject (name, abbreviation) values ('English', 'ENG');

insert into course (subject_id, title, course_number, units, description) values (1, 'Software Design', 315, 3, 'Learn the principles of software design.');
insert into course (subject_id, title, course_number, units, description) values (1, 'Software Testing', 216, 3, 'Learn the principles of software testing.');
insert into course (subject_id, title, course_number, units, description) values (2, 'Discrete Mathematics', 320, 3, 'Learn the principles of discrete math.');

insert into class (course_id, number) values (1, 1000);
insert into class (course_id, number) values (1, 1001);
insert into class (course_id, number) values (2, 2000);
insert into class (course_id, number) values (2, 2001);
insert into class (course_id, number) values (2, 2002);
insert into class (course_id, number) values (2, 2002);

insert into class_student (class_id, student_id) values (1, 1);
insert into class_student (class_id, student_id) values (3, 1);

insert into note (student_id, class_id, title, contents) values (1, 1, 'Some title', 'This is the first note!');
insert into note (student_id, class_id, title, contents) values (1, 1, 'Some title 2', 'This is the second note!');
insert into note (student_id, class_id, title, contents) values (1, 3, 'Some title 3', 'This is the first note for the second course!');

# --- !Downs

delete from user;
