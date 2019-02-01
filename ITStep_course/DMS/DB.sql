create schema filestorage;

use filestorage;

create table files (
id int(10) unsigned auto_increment NOT NULL ,
fileuri varchar(250) NOT NULL,
password varchar(250) NOT NULL,
PRIMARY KEY (id)
);
