create sequence if not exists todo_seq
increment by 1
start with 1;

create table if not exists todo(
    todo_id varchar(36) primary key,
    todo_title varchar(30),
    todo_detail varchar(100),
    finished boolean, 
    updated_at timestamp,
    created_at timestamp
);

insert into todo (todo_id, todo_title, todo_detail, finished, updated_at, created_at) values (todo_seq.nextval, 'init_todo', 'init_detail', false, current_timestamp, current_timestamp);
