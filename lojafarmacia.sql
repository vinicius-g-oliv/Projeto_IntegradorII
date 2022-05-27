create database if not exists lojafarmacia;

use lojafarmacia;


/* Tabela de cliente desenvolvida com os mesmos campos da tela de cliente*/
create table cliente
(
	id_cliente  int not null primary key auto_increment,
	nome        varchar (100) not null,
	cpf        varchar (11) not null,
	date        date not null,
	email       varchar(100) not null,
	sexo        varchar(20)  not null,
	cep         numeric(10) not null,
	endereco    varchar(150) not null, 
	numero      int not null,
	complemento varchar(100) null,
	estadoCivil varchar(30) not null
);



/* Tabela de produto desenvolvida conforme os campos da tela de produto, adicionando também um campo id_produto como chave primária*/
create table produto
(
	id_produto          int not null primary key auto_increment,
	codigo              varchar(10) not null,
	nome                varchar(50) not null,
	preco               numeric(18,2) not null,
	quantidadeEstoque   int not null)
;



/* Tabela de Venda desenvolvida conforma os campos da tela de venda */
create table venda
(
	id_venda    int not null primary key auto_increment,
	id_cliente  int not null, foreign key (id_cliente) references Cliente (id_cliente),
	dataVenda   date not null,
	valor       numeric(18,2) default 0.00
);


/* Na Tabela ItemVenda foi alterado o campo (valor) para (valorUnitario) e adicionado o campo de valor Total, para
armazernar as informações de preço dos produtos */
create table item_venda
(
	id_itemVenda    int not null primary key auto_increment,
	id_venda        int not null, foreign key (id_venda) references Venda (id_venda),
	id_produto      int not null, foreign key (id_produto) references Produto (id_produto),
	quantidade      int not null,
	valorUnitario   numeric (18,2) not null,
	valorTotal      numeric (18,2) not null
);



/* Trigger desenvolvida para automatizar o processo de controle de estoque, assim que um produto for adicionado
na tabela de itemVenda, o mesmo será alterado na tabela de produto de forma automática não necessitando de realizar
o processo via código */
delimiter$

create trigger ItemVendaEstoque_I after insert
    on ItemVenda
    for each row
        begin
            update Produto set quantidadeEstoque = quantidadeEstoque - new.quantidade
            where produto.id_produto = new.id_produto;
        end$
delimiter;



/* Trigger desenvolvida para automatizar o processo de controle de estoque, quando houver uma exclusão de uma venda,
ele retornará as quantidades dos produtos que foram retirados do estoque */
delimiter$

create trigger ItemVendaEstoque_D before delete
    on ItemVenda
    for each row
        begin
            update Produto set quantidadeEstoque = quantidadeEstoque + old.quantidade
            where produto.id_produto = old.id_produto;
        end$
delimiter;



/* Triger desenvolvida para automatizar o processo de exclusão de uma venda, devido as tabelas terem relacionamento (foreign key),
com isso teria de ser excluído primeiro o item e depois a venda, com essa trigger, esse processo já será feito automaticamente,
não necessitando um retrabalho */
delimiter$
create trigger ItemVenda_D before delete
    on Venda
    for each row
        begin
            delete from ItemVenda where itemVenda.id_venda = old.id_venda;
        end$$
delimiter;



/* Trigger desenvolvida para automatizar o processo de somatória do valor total da venda, independente de quantos
produtos foram adicionados a uma venda, ele irá realizar a soma corretamente de forma automática assim que um novo
produto for adicionado na tabela ItemVenda */
delimiter$
create trigger ItemVenda_ValorTotal after insert
    on ItemVenda
    for each row
        begin
            update Venda v
            join (select iv.id_venda as vendaItem , sum(iv.valorTotal) as ValorTotal
            from ItemVenda iv
            group by vendaItem
                 ) iv on v.id_venda = iv.vendaItem
                     and v.id_venda = new.id_venda

            set v.valor = iv.valorTotal;
        end$
delimiter;


/* Criação de uma view para o relatório Analitico ao invés de uma tabela, pois assim a dinâmica do relatório fica mais
prática e podem ser utilizados apenas alguns campos, e ela será sempre alimentada com as informações que estão dentro
das tabelas de venda */ 
create view RelatorioAnalitico
as

select distinct
        cliente.nome            as NomeCliente,
        produto.codigo          as CodigoProduto,
        produto.nome            as Produto,
        venda.id_venda          as IDVenda,
        venda.dataVenda         as DataVenda,
        venda.valor             as ValorVenda,
        itemVenda.quantidade    as QtdeVenda,
        itemVenda.valorUnitario as ValorUnitario,
        itemVenda.valorTotal    as ValorTotal,
        produto.preco           as PrecoProduto,
        produto.quantidadeEstoque as Estoque

from Venda
join ItemVenda on venda.id_venda = ItemVenda.id_venda
join Produto on ItemVenda.id_produto = produto.id_produto
join Cliente on venda.id_cliente = cliente.id_cliente;



/* Criação de uma view para o relatório ao invés de uma tabela, pois assim a dinâmica do relatório fica mais
prática e podem ser utilizados apenas alguns campos, e ela será sempre alimentada com as informações que estão dentro
das tabelas de venda */ 
create view Relatorio
as

select distinct
        cliente.nome            as NomeCliente,
        produto.codigo          as CodigoProduto,
        produto.nome            as Produto,
        venda.id_venda          as IDVenda,
        venda.dataVenda         as DataVenda,
        venda.valor             as ValorVenda

from Venda
join ItemVenda on venda.id_venda = ItemVenda.id_venda
join Produto on ItemVenda.id_produto = produto.id_produto
join Cliente on venda.id_cliente = cliente.id_cliente;