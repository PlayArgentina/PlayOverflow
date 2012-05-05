# --- First database schema

# --- !Ups

create table questions (
  id                        bigint not null,
  title                      varchar(255),
  description				 varchar(500),
  tags						 varchar(500),
  publish_date				 timestamp,
  user_id					bigint not null,
  constraint pk_question primary key (id))
;

create table users (
  id                        bigint not null,
  username                      varchar(255),
  password                varchar(255),
  constraint pk_users primary key (id))
;

create sequence questions_seq start with 1000;

create sequence users_seq start with 1000;

alter table questions add constraint fk_questions_users_1 foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_questions_users_1 on questions (user_id);


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists questions;

drop table if exists users;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists questions_seq;

drop sequence if exists users_seq;

