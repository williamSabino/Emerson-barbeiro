create table agenda(
id bigint auto_increment,
nome varchar(100) not null,
data date not null,
hora time not null,
degrade tinyint,
tesoura tinyint,
barba tinyint,
test1 tinyint,
test2 tinyint,
outros tinyint,

primary key(id)
);