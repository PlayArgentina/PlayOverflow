# --- First database schema

# --- !Ups

create table question (
  id                        bigint not null,
  title                      varchar(255),
  description				 varchar(500),
  tags						 varchar(500),
  publish_date				 timestamp,
  user_id					bigint not null,
  constraint pk_question primary key (id))
;

create table user (
  id                        bigint not null,
  username                      varchar(255),
  password                varchar(255),
  constraint pk_user primary key (id))
;

create sequence questions_seq start with 1000;

create sequence user_seq start with 1000;

alter table question add constraint fk_questions_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_questions_user_1 on question (user_id);


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists question;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists questions_seq;

drop sequence if exists users_seq;

