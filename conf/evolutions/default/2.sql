# --- Sample dataset

# --- !Ups
insert into users (id,username,password) values (  1,'derfarg','123456');

insert into questions (id,title,description,tags,user_id, publish_date) values (  1,'Apple Inc.','App fixture description','fixure',1, '1991-01-01');
insert into questions (id,title,description,tags,user_id, publish_date) values (  2,'Thinking Machines','App fixture description','fixure',1, '2011-01-01');
insert into questions (id,title,description,tags,user_id, publish_date) values (  3,'RCA','App fixture description','fixure',1, '2091-01-01');
insert into questions (id,title,description,tags,user_id, publish_date) values (  4,'Netronics','App fixture description','fixure',1, null);
insert into questions (id,title,description,tags,user_id, publish_date) values (  5,'Tandy Corporation','App fixture description','fixure',1, '1891-01-01');
insert into questions (id,title,description,tags,user_id, publish_date) values (  6,'Commodore International','App fixture description','fixure',1, '1991-01-01');
insert into questions (id,title,description,tags,user_id, publish_date) values (  7,'MOS Technology','App fixture description','fixure',1, '1987-01-01');
insert into questions (id,title,description,tags,user_id, publish_date) values (  8,'Micro Instrumentation and Telemetry Systems','App fixture description','fixure',1,'1991-01-20');
# --- !Downs



delete from questions;

