DROP DATABASE IF EXISTS grana_certa;
/* Cria um banco de dados chamado 'grana_certa'*/
CREATE DATABASE grana_certa;
/* Define que iremos trabalhar utilizando o bd criado*/
USE grana_certa;
/* Criar a tabela de contas */
CREATE TABLE contas(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    tipo TINYINT NOT NULL,
    saldo DOUBLE NOT NULL,
    descricao text
);
/* Criando um registro na tabela de contas */ 
INSERT INTO contas (nome, tipo, saldo, descricao) VALUES 
	("Viacredi", 1, 1000.00, "Conta dos joguinhos"),
    ("Banco do Brasil", 1, 2500.00, "Conta principal da empresa"),
    ("Caixa Econômica", 2, 800.00, "Conta usada para folha de pagamento"),
    ("Itaú", 1, 1500.50, "Reserva para investimentos futuros"),
    ("Nubank", 2, 120.75, "Conta digital de testes"),
    ("Bradesco", 1, 3150.00, "Conta corrente da diretoria");
/* Consultar os registros da tabela de contas */
SELECT id, nome, tipo, saldo, descricao FROM contas;


CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(20) NOT NULL
);

-- Inserção de alguns clientes
INSERT INTO clientes (nome, cnpj) VALUES
    ('Empresa Alpha', '12.345.678/0001-90'),
    ('Beta Soluções LTDA', '98.765.432/0001-10'),
    ('Gamma Corp', '11.222.333/0001-55');

-- Verificar dados inseridos
SELECT * FROM clientes;


CREATE TABLE contas_receber_pagar(
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    id_conta INT NOT NULL,
    
    nome VARCHAR(100) NOT NULL,
    tipo TINYINT NOT NULL,
    valor DOUBLE NOT NULL,
    data_prevista DATE NOT NULL,
    data_realizada DATE,
    status TINYINT NOT NULL,
    registro_ativo BIT DEFAULT(1) NOT NULL,
    
    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    /*
    created_at
    created_by
    updated_at
    updated_by
    deleted_at
    deleted_by
    */

    /* Chaves estrangeiras que relacionam a tabela com outra(s) tabela(s) 
    FOREIGN KEY(coluna_fk_tabela_filha) REFERENCES tabela_pai(coluna_pk_tabela_pai)
    FK e PK tem que ser do mesmo tipo, exemplo INT nas duas tabelas
    */
    FOREIGN KEY(id_cliente) REFERENCES clientes(id),
    FOREIGN KEY(id_conta) REFERENCES contas(id)
);

-- Inserindo 20 contas a pagar/receber com nomes ajustados e status diversificados
-- Inserindo 20 contas a pagar/receber com nomes ajustados e status diversificados

INSERT INTO contas_receber_pagar (
    id_cliente, id_conta, nome, tipo, valor, data_prevista, status, data_realizada
) VALUES
(2, 4, 'Comissão de vendas', 0, 2000.0, '2025-09-28', 0, NULL),
(1, 4, 'Telefone fixo', 1, 80.0, '2025-09-05', 1, '2025-09-05'),
(2, 1, 'Venda de bicicleta', 0, 250.0, '2025-09-12', 1, '2025-09-12'),
(2, 2, 'Água', 1, 150.0, '2025-09-03', 1, '2025-09-03'),
(2, 5, 'Aluguel', 1, 1200.0, '2025-09-10', 0, NULL),
(1, 5, 'Escola das crianças', 1, 500.0, '2025-09-25', 1, '2025-09-25'),
(2, 2, 'Plano de saúde', 1, 350.0, '2025-09-08', 2, '2025-09-08'),
(1, 3, 'Financiamento de imóvel', 1, 1200.0, '2025-09-10', 1, '2025-09-10'),
(3, 4, 'Prestação do carro', 1, 800.0, '2025-09-22', 2, '2025-09-22'),
(2, 2, 'Aluguel de imóvel', 0, 1500.0, '2025-09-05', 0, NULL),
(3, 1, 'Supermercado', 1, 450.0, '2025-09-08', 0, NULL),
(1, 5, 'Venda de móveis usados', 0, 850.0, '2025-09-30', 1, '2025-09-30'),
(2, 3, 'TV a cabo', 1, 200.0, '2025-09-18', 0, NULL),
(2, 5, 'Venda de móveis usados', 0, 1800.0, '2025-09-12', 2, '2025-09-12'),
(3, 3, 'Salário de freelancer', 0, 3500.0, '2025-09-10', 1, '2025-09-10'),
(1, 2, 'Consultoria pessoal', 0, 3000.0, '2025-09-20', 0, NULL),
(3, 3, 'Curso online', 0, 1000.0, '2025-09-25', 1, '2025-09-25'),
(1, 2, 'Gás de cozinha', 1, 100.0, '2025-09-15', 1, '2025-09-15'),
(3, 3, 'Internet', 1, 120.0, '2025-09-07', 2, '2025-09-07'),
(1, 1, 'Energia elétrica', 1, 350.0, '2025-08-18', 0, NULL),
(1, 4, 'Venda de celular usado', 0, 1200.0, '2025-08-30', 0, NULL),
(3, 1, 'Condomínio', 1, 600.0, '2025-09-03', 0, NULL),
(1, 1, 'Venda de Xbox', 0, 2000.0, '2025-08-15', 1, '2025-08-15');


-- Consultar todas as transações inseridas
SELECT 
    crp.id,
    c.nome AS cliente_nome,
    ct.nome AS conta_nome,
    crp.nome AS transacao_nome,
    crp.tipo,
    crp.valor,
    crp.data_prevista,
    crp.data_realizada,
    crp.status,
    crp.registro_ativo,
    crp.data_criacao
FROM 
    contas_receber_pagar crp
JOIN 
    clientes c ON crp.id_cliente = c.id
JOIN 
    contas ct ON crp.id_conta = ct.id;



/*
Tipos de dados:
	- INT para campos de número inteiro na casa dos 2 bilhões
    - TINYINT para campos de numero inteiro de -128..127
    - DOUBLE para campos de número real ex.: 20,30
    - VARCHAR para campos de texto
    - TEXT para campos de texto 
    - Outros tipos de dados
PRIMARY KEY: chave primária da tabela (identificador único da tabela)
AUTO_INCREMENT: gerar automaticamente a chave primária
NOT NULL: torna o campo obrigatório
*/

