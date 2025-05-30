create table passports
(
    id     int primary key not null,
    number int,
    series int
);

create table persons
(
    id          int primary key not null,
    name        varchar(50)     not null,
    passport_id int,
    constraint passport_fk
        foreign key (passport_id) references passports (id)
);

create table departments
(
    id   int primary key not null,
    name varchar(50)     not null
);

create table employees
(
    id            int primary key not null,
    name          varchar(50)     not null,
    job           varchar(50)     not null,
    department_id int,
    constraint department_fk
        foreign key (department_id) references departments (id)
);

create table students
(
    id   int primary key not null,
    name varchar(50)     not null
);

create table courses
(
    id   int primary key not null,
    name varchar(50)     not null
);

create table students_courses
(
    student_id int,
    course_id  int,
    primary key (student_id, course_id),
    constraint student_fk
        foreign key (student_id) references students (id),
    constraint course_fk
        foreign key (course_id) references courses (id)
);

create table users
(
    id         int primary key,
    username   varchar(50)  not null,
    password   varchar(150) not null,
    email      varchar(50),
    is_blocked boolean
);

create table roles
(
    id   int primary key,
    name varchar(50) not null
);

create table users_roles
(
    user_id int,
    role_id int,
    primary key (user_id, role_id),
    constraint user_fk
        foreign key (user_id) references users (id),
    constraint role_fk
        foreign key (role_id) references roles (id)
);