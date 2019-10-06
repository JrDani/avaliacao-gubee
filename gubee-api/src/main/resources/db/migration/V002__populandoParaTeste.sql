insert into stack(name) values ('Java 10');
insert into stack(name) values ('Kotlin');
insert into stack(name) values ('Kafka');
insert into stack(name) values ('Event Stream');
insert into stack(name) values ('Redis');
insert into stack(name) values ('MongoDB');
insert into stack(name) values ('NodeJS');
insert into stack(name) values ('Big Data Analytics');
insert into stack(name) values ('Hadoop');
insert into stack(name) values ('Pig');
insert into stack(name) values ('Cassandra');

insert into target_market(name) values ('Ecommerce');
insert into target_market(name) values ('ERP');
insert into target_market(name) values ('Lojista que não desejam possuir ecommerce');
insert into target_market(name) values ('Loja fisica');
insert into target_market(name) values ('Telecom');
insert into target_market(name) values ('Venda direta');
insert into target_market(name) values ('Mobile First');
insert into target_market(name) values ('Digital Onboarding');

insert into product(product_name, description) values ('Gubee Integrador', 'Ferramenta de integração para marketplaces');
insert into product(product_name, description) values ('Gubee Fretes', 'Ferramenta para gestão e calculo de fretes');
insert into product(product_name, description) values ('Gubee AntiFraude', 'Ferramenta especialistas em detecção e prevenção à fraude');

insert into product_stack(product_id, stack_id) values (1, 1);
insert into product_stack(product_id, stack_id) values (1, 2);
insert into product_stack(product_id, stack_id) values (1, 3);
insert into product_stack(product_id, stack_id) values (1, 4);
insert into product_stack(product_id, stack_id) values (1, 5);
insert into product_stack(product_id, stack_id) values (1, 6);

insert into product_stack(product_id, stack_id) values (2, 6);
insert into product_stack(product_id, stack_id) values (2, 7);

insert into product_stack(product_id, stack_id) values (3, 8);
insert into product_stack(product_id, stack_id) values (3, 9);
insert into product_stack(product_id, stack_id) values (3, 3);
insert into product_stack(product_id, stack_id) values (3, 10);
insert into product_stack(product_id, stack_id) values (3, 11);

insert into product_targetmarket(product_id, target_market_id) values (1, 1);
insert into product_targetmarket(product_id, target_market_id) values (1, 2);
insert into product_targetmarket(product_id, target_market_id) values (1, 3);

insert into product_targetmarket(product_id, target_market_id) values (2, 1);
insert into product_targetmarket(product_id, target_market_id) values (2, 2);
insert into product_targetmarket(product_id, target_market_id) values (2, 4);

insert into product_targetmarket(product_id, target_market_id) values (3, 1);
insert into product_targetmarket(product_id, target_market_id) values (3, 5);
insert into product_targetmarket(product_id, target_market_id) values (3, 6);
insert into product_targetmarket(product_id, target_market_id) values (3, 7);
insert into product_targetmarket(product_id, target_market_id) values (3, 8);
