DROP TRIGGER phd_garden_order;
DROP TRIGGER phd_garden_customer; 
DROP TRIGGER phd_garden_stock; 


drop table translation_product;
drop table translation_category;
drop table language;
drop table discount;
drop table order_line;
drop table product;
drop table category;
drop table customer_order;
drop table customer;


/*CREATE SCHEMA `phd_garden` DEFAULT CHARACTER SET utf8;
use phd_garden;*/

SET default_storage_engine=InnoDB;

CREATE TABLE customer (
	id int primary key auto_increment,
	authorities varchar(500) NOT NULL,
	non_expired tinyint(1),
	non_locked tinyint(1),
	credentials_non_expired tinyint(1),
	enabled tinyint(1),
	username varchar(30) NOT NULL UNIQUE,
	password varchar(200) NOT NULL,
    registration_date date,
    firstname varchar(50) NOT NULL,
    lastname varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    phone varchar(50),
    birthdate date,
    gender varchar(30) NOT NULL,
    street varchar(50) NOT NULL,
    house_number varchar(5) NOT NULL,
    postalcode int(5) NOT NULL,
    locality varchar(50) NOT NULL,
	CHECK(email LIKE '%@%.%')
);

create table customer_order (
	id int primary key auto_increment,
    order_date date,
    paid TINYINT(1),
    
    customer_id int not null references customer(id)
);

create table category (
	id int primary key auto_increment,
    url_image varchar(30) unique
);

create table product (
	id int primary key auto_increment,
    price decimal(6,2) not null,
    url_image varchar(30) unique,
    stock int(10),
    
    category_id int not null references category(id),
    CHECK(price > 0),
	CHECK(stock >= 0)
);

create table order_line (
	id int primary key auto_increment,
    quantity int(10) not null,
    unit_price decimal(6,2) not null,

    order_id int not null references customer_order(id),
    product_id int not null references product(id),
    CHECK(quantity > 0)
);



create table discount (
	id int primary key auto_increment,
    percentage int(3) not null,
    start_date date,
    end_date date,
    
    category_id int references category(id),
    product_id int references product(id),
    CHECK(percentage > 0)
);


create table language (
	id int primary key auto_increment,
    language_name varchar(30) NOT NULL,
    language_code varchar(4) NOT NULL
);

create table translation_category (
	category_id int not null,
    language_id int not null,
    category_name varchar(30) NOT NULL,
    
    PRIMARY KEY (category_id, language_id)
);

create table translation_product (
	product_id int not null,
    language_id int not null,
    product_name varchar(30) NOT NULL,
    description varchar(150),
    
    PRIMARY KEY (product_id, language_id)
);

ALTER TABLE translation_category ADD CONSTRAINT FK_translationCategory_ProductCategory FOREIGN KEY (category_id) REFERENCES category (id);
ALTER TABLE translation_category ADD CONSTRAINT FK_translationCategory_Language FOREIGN KEY (language_id) REFERENCES language (id);
ALTER TABLE translation_product ADD CONSTRAINT FK_translationProduct_Product FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE translation_product ADD CONSTRAINT FK_translationProduct_Language FOREIGN KEY (language_id) REFERENCES language (id);



create TRIGGER phd_garden_customer
    before INSERT on customer
    for each row
	set new.registration_date = now();
    

create TRIGGER phd_garden_order
    before INSERT on customer_order
    for each row
	set new.order_date = now();


/*TODO TESTS*/
delimiter $
	create TRIGGER phd_garden_stock
	after insert on customer_order
	FOR EACH ROW
	BEGIN
		IF (customer_order.paid = true) THEN
			IF (order_line.product_id = product.id) THEN
				update product set stock = product.stock - phd_garden.order_line.quantity;
			END IF;
		END IF;
	END;
$

