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


-- Inserindo uma conta a receber (tipo = 0)
INSERT INTO contas_receber_pagar (
    id_cliente, id_conta, nome, tipo, valor, data_prevista, status
) VALUES (
    1, -- Empresa Alpha
    1, -- Viacredi
    'Recebimento de serviços prestados',
    0, -- Conta a receber
    1500.00,
    '2025-08-25',
    0 -- Status pendente (por exemplo)
);

-- Inserindo uma conta a pagar (tipo = 1)
INSERT INTO contas_receber_pagar (
    id_cliente, id_conta, nome, tipo, valor, data_prevista, status
) VALUES (
    2, -- Beta Soluções LTDA
    3, -- Caixa Econômica
    'Pagamento de fornecedor de TI',
    1, -- Conta a pagar
    850.00,
    '2025-08-20',
    0 -- Status pendente (por exemplo)
);




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

