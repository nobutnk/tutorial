begin;

-- delete all tables
DELETE FROM account;
DELETE FROM users;
DELETE FROM todo_category;
DELETE FROM todo;
DELETE FROM article;
DELETE FROM item_category;
DELETE FROM item;
DELETE FROM cart_item;
DELETE FROM cart;
DELETE FROM order_items;
DELETE FROM orders;

-- account
INSERT INTO account (id, username, password, admin, enabled, updated_at, created_at)
    SELECT id, username, password, admin, enabled, current_timestamp, current_timestamp
        FROM csvread('classpath:sql/account.csv');
ALTER SEQUENCE account_seq RESTART WITH 200;
-- users
INSERT INTO users (id, first_name, last_name, birthday, updated_at, created_at)
    SELECT id, first_name, last_name, birthday, current_timestamp, current_timestamp
        FROM csvread('classpath:sql/users.csv');

-- todo list
INSERT INTO todo (todo_id, todo_title, todo_category, todo_detail, due_date, public, finished, updated_at, created_at)
    SELECT todo_id, todo_title, todo_category, todo_detail, due_date, public, finished, current_timestamp, current_timestamp
        FROM csvread('classpath:sql/todo.csv');

ALTER SEQUENCE todo_seq RESTART WITH 200;

-- todo category
INSERT INTO todo_category (todo_category_id, todo_category_name, updated_at, created_at)
    SELECT todo_category_id, todo_category_name, current_timestamp, current_timestamp
        FROM csvread('classpath:sql/todo_category.csv');

-- item list
insert into item (item_code, item_name, item_category, finished, updated_at, created_at) values (item_seq.nextval, 'item_1', '1', false, current_timestamp, current_timestamp);
insert into item (item_code, item_name, item_category, finished, updated_at, created_at) values (item_seq.nextval, 'item_2', '2', false, current_timestamp, current_timestamp);
insert into item (item_code, item_name, item_category, finished, updated_at, created_at) values (item_seq.nextval, 'item_3', '3', false, current_timestamp, current_timestamp);
insert into item (item_code, item_name, item_category, finished, updated_at, created_at) values (item_seq.nextval, 'item_4', '2', false, current_timestamp, current_timestamp);
insert into item (item_code, item_name, item_category, finished, updated_at, created_at) values (item_seq.nextval, 'item_5', '3', false, current_timestamp, current_timestamp);

-- item category
insert into item_category (item_category_id, item_category_name, updated_at, created_at) values (item_category_seq.nextval, 'books', current_timestamp, current_timestamp);
insert into item_category (item_category_id, item_category_name, updated_at, created_at) values (item_category_seq.nextval, '家電', current_timestamp, current_timestamp);
insert into item_category (item_category_id, item_category_name, updated_at, created_at) values (item_category_seq.nextval, 'インテリア', current_timestamp, current_timestamp);


commit;