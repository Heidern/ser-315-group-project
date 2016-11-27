# --- First database schema

# --- !Ups

create table user (
  id bigint not null identity,
  created date not null default (CURRENT_DATE),
  type varchar(15) not null,
  username varchar(255) not null,
  first_name varchar(255),
  last_name varchar(255),
  email_address varchar(512) not null,
  constraint pk_user primary key (id)
);

create table subject (
  id bigint not null identity,
  name varchar(255) not null,
  abbreviation varchar(4) not null,
  constraint pk_subject primary key (id)
);

create table course (
  id bigint not null identity,
  subject_id bigint not null,
  title varchar(255) not null,
  course_number int not null,
  units int not null,
  description varchar(1024),
  constraint pk_course primary key (id)
);

create table class (
  id bigint not null identity,
  course_id bigint not null,
  number int not null,
  constraint pk_class primary key (id)
);

create table class_student (
  class_id bigint not null,
  student_id bigint not null
);

create table class_instructor (
  class_id bigint not null,
  instructor_id bigint not null
);

create table note (
  id bigint not null identity,
  student_id bigint not null,
  class_id bigint not null,
  title varchar(255),
  contents varchar(max),
  constraint pk_note primary key (id)
);

-- alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
--create index ix_computer_company_1 on computer (company_id);


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

