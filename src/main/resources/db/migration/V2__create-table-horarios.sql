create table horarios(
id bigint auto_increment,
data date not null,
hora time not null,
agendado tinyint,
nome varchar(100),

primary key(id)
);