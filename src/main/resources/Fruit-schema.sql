drop table if exists fruit CASCADE;
create table fruit
(
	id bigint not null auto_increment, 
	colour varchar(255), 
	fruit_type varchar(255), 
	price double precision not null, 
	primary key (id)
);

