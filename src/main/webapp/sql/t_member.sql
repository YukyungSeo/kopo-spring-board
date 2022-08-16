select * from t_member;

drop table t_member;
create table t_member(
    id varchar2(100) primary key
    , password varchar2(100) not null
    , name VARCHAR2(100) not null
);

insert into t_member(id, password, name) values('admin', 'admin', '°ü¸®ÀÚ');