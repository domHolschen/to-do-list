create table if not exists Tasks (
    id identity,
    task_name varchar(50) not null,
    task_description varchar(200) not null,
    task_due_date date not null
);