show databases;
create database farmacia;
use farmacia;
desc produtos;

create table produtos (
    codigo int(5) unsigned not null primary key auto_increment,
    descricao varchar(50),
    precodecompra float(8),
    percentualdelucro float(8),
    precodevenda float(8),
    categoria varchar(50)
);

select * from produtos where categoria ="remedio";
select * from produtos where categoria ="higiene";
select * from produtos;