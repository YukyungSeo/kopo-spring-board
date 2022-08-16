select * from board;

drop table t_board;
create table t_board(
    no number(5) primary key
    , title varchar2(100) not null
    , writer varchar2(100) not null
    , content varchar2(1000) not null
    , view_cnt number(5) default 0
    , reg_date date default sysdate
);

drop sequence seq_t_board_no;
create sequence seq_t_board_no nocache;
commit;

insert into t_board(no, title, writer, content) values(seq_t_board_no.nextval, '우영우', '동그라미', '우투더영투더우');
commit;

select * from t_board;