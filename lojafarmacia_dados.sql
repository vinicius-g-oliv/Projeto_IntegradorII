-- inserir dados de exemplo
-- inserir clientes;
-- inserir produtos;
-- inserir venda;
-- inserir item_venda;

insert into cliente (nome, cpf, date, email, sexo, cep, endereco, numero, complemento, estadoCivil) values
    ('João', '75858755410', '2000-01-01', 'email.joão@.com', 'Masculino', '12345678', 'Rua João', '123', 'Casa', 'Solteiro'),
    ('Maria', '91814476989', '2000-01-01', 'email.maria@.com', 'Feminino', '12345678', 'Rua Maria', '123', 'Casa', 'Solteiro'),
    ('Pedro', '82090142693', '2000-01-01', 'email.pedro@.com', 'Masculino', '12345678', 'Rua Pedro', '123', 'Casa', 'Solteiro'),
    ('Ana', '03935086172', '2000-01-01', 'email.ana@.com', 'Feminino', '12345678', 'Rua Ana', '123', 'Casa', 'Solteiro');

insert into produto (nome, preco, quantidade_estoque) values
    ('Advil', '12.00', '100'),
    ('Ibuprofeno', '12.00', '100'),
    ('Dipirona', '12.00', '100'),
    ('Paracetamol', '12.00', '100'),
    ('Fraldas', '12.00', '100'),
    ('Shampoo', '12.00', '100'),
    ('Sabonete', '12.00', '100'),
    ('Desodorante', '12.00', '100'),
    ('Creme dental', '12.00', '100'),
    ('Banho', '12.00', '100'),
    ('Creme dental', '12.00', '100');

insert into item_venda (id_venda, id_produto, quantidade, valor_unitario) VALUES
    (1, 1, 1, 12.00),
    (1, 2, 1, 12.00),
    (1, 3, 1, 12.00),
    (1, 4, 1, 12.00),
    (1, 5, 1, 12.00),
    (1, 6, 1, 12.00),
    (1, 7, 1, 12.00),
    (1, 8, 1, 12.00),
    (1, 9, 1, 12.00),
    (1, 10, 1, 12.00);

insert into venda (id_cliente, data_venda, valor) VALUES
    (1, '2000-01-01', '12.00'),
    (2, '2000-01-01', '12.00'),
    (3, '2000-01-01', '12.00'),
    (4, '2000-01-01', '12.00');

