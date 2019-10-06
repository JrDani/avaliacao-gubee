create table target_market(
	id bigint primary key auto_increment,
	name varchar(500) not null
)engine=InnoDB default charset=utf8;

create table stack(
	id bigint primary key auto_increment,
	name varchar(50) not null
)engine=InnoDB default charset=utf8;

create table product(
	id bigint primary key auto_increment,
	product_name varchar(255) not null,
	description varchar(255) not null	
)engine=InnoDB default charset=utf8;
	
create table product_targetmarket(
	id bigint primary key auto_increment,
	product_id bigint not null,
	target_market_id bigint not null,
	foreign key (product_id) references product(id),
	foreign key (target_market_id) references target_market(id)
)engine=InnoDB default charset=utf8;	

create table product_stack(
	id bigint primary key auto_increment,
	product_id bigint not null,
	stack_id bigint not null,
	foreign key (product_id) references product(id),
	foreign key (stack_id) references stack(id)
)engine=InnoDB default charset=utf8;	
