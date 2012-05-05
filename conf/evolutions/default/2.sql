# --- Sample dataset

# --- !Ups
insert into user (id,username,password) values (  1,'derfarg','123456');
insert into user (id,username,password) values (  2,'marcosnils','123456');

insert into question (id,title,description,tags,user_id, publish_date) values (  1,'Macintosh','App fixture description','fixure',1, '1991-01-01');
insert into question (id,title,description,tags,user_id, publish_date) values (  2,'Thinking Machines','App fixture description','fixure',1, '2011-01-01');
insert into question (id,title,description,tags,user_id, publish_date) values (  5,'Tandy Corporation','App fixture description','fixure',1, '1891-01-01');
insert into question (id,title,description,tags,user_id, publish_date) values (  6,'Commodore International','App fixture description','fixure',1, '1991-01-01');
insert into question (id,title,description,tags,user_id, publish_date) values (  7,'MOS Technology','App fixture description','fixure',1, '1987-01-01');
insert into question (id,title,description,tags,user_id, publish_date) values (  8,'Micro Instrumentation and Telemetry Systems','App fixture description','fixure',1,'1991-01-20');

insert into answer (id,description,user_id, question_id) values (  1,'App fixture answer',2,1);
insert into answer (id,description,user_id, question_id) values (  2,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s, when an unknown printer took a galley of type and',1,1);
insert into answer (id,description,user_id, question_id) values (  3,'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum',2,1);


# --- !Downs

delete from answer;

delete from question;

