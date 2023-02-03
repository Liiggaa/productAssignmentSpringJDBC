SET GLOBAL time_zone = '+2:00';

DROP DATABASE IF EXISTS spring_product;
CREATE DATABASE spring_product;

USE spring_product;

CREATE TABLE product(
id int not null auto_increment,
name text not null,
description text,
quantity int,
price double,
isAvailable boolean default false,
primary key (id)
)