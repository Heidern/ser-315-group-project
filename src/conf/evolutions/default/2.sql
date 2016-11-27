# --- Sample dataset

# --- !Ups

insert into user (user_type, username, first_name, last_name, email_address) values ('student', 'john.doe', 'John', 'Doe', 'john@doe.com');
# --- !Downs

delete from user;
