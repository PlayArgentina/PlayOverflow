# --- Sample dataset

# --- !Ups
insert into user (id,username,password) values (3,'cris','123456');
insert into user (id,username,password) values (4,'daniel','123456');

# --- !Downs

delete from user;

