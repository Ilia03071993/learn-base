CREATE TABLE passports
(
    id     int primary key NOT NULL,
    number int,
    series int
);

CREATE TABLE persons
(
    id          int primary key NOT NULL,
    name        varchar(50)     NOT NULL,
    passport_id int,
    constraint passport_fk
        foreign key (passport_id) references passports (id)
);

CREATE TABLE departments
(
    id   int primary key NOT NULL,
    name varchar(50)     NOT NULL
);

CREATE TABLE employees
(
    id            int primary key NOT NULL,
    name          varchar(50)     NOT NULL,
    job           varchar(50)     NOT NULL,
    department_id int,
    constraint department_fk
        foreign key (department_id) references departments (id)
);

CREATE TABLE students
(
    id   int primary key NOT NULL,
    name varchar(50)     NOT NULL
);

CREATE TABLE courses
(
    id   int primary key NOT NULL,
    name varchar(50)     NOT NULL
);

CREATE TABLE students_courses
(
    student_id int,
    course_id  int,
    primary key (student_id, course_id),
    constraint student_fk
        foreign key (student_id) references students (id),
    constraint course_fk
        foreign key (course_id) references courses (id)
);