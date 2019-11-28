/*
drop table translation;
drop table language;
drop table discount;
drop table order_line;
drop table product;
drop table category;
drop table customer_order;
drop table customer;
*/

CREATE SCHEMA `phd_garden` DEFAULT CHARACTER SET utf8;
use phd_garden;

CREATE TABLE customer (
	id int primary key auto_increment,
	authorities varchar(500) NOT NULL,
	non_expired tinyint(1),
	non_locked tinyint(1),
	credentials_non_expired tinyint(1),
	enabled tinyint(1),
	username varchar(30) NOT NULL UNIQUE,
	password varchar(200) NOT NULL,
    firstname varchar(50) NOT NULL,
    lastname varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    phone varchar(50),
    birthdate date,
    gender varchar(30) NOT NULL,
    street varchar(50) NOT NULL,
    house_number varchar(5) NOT NULL,
    postalcode int(5) NOT NULL,
    locality varchar(50) NOT NULL
)ENGINE=INNODB;

create table customer_order (
	id int primary key auto_increment,
    order_date date,
    
    customer_id int not null references customer(id)
)ENGINE=INNODB;

create table category (
	id int primary key auto_increment,
    category_name varchar(30) NOT NULL
    
)ENGINE=INNODB;

create table product (
	id int primary key auto_increment,
    product_name varchar(30) NOT NULL,
    price decimal(6,2) not null,
    description varchar(30),
    
    category_id int not null references category(id)
)ENGINE=INNODB;

create table order_line (
	id int primary key auto_increment,
    quantity int(2) not null,
    unit_price decimal(6,2) not null,

    order_line_id int not null references customer_order(id),
    product_id int not null references product(id)
)ENGINE=INNODB;

create table discount (
	id int primary key auto_increment,
    percentage varchar(30) not null,
    startDate date not null,
    endDate date not null,
    
    category_id int references category(id),
    product_id int references product(id)
)ENGINE=INNODB;


create table language (
	id int primary key auto_increment,
    language_name varchar(30) NOT NULL
    
)ENGINE=INNODB;

create table translation (
	id int primary key auto_increment,
    content varchar(30),
    
    language_id int not null references language(id),
    category_id int not null references category(id)    
)ENGINE=INNODB;