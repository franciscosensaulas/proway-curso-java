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
	("Viacredi", 1, 1000.00, "Conta dos joguinhos");
/* Consultar os registros da tabela de contas */
SELECT id, nome, tipo, saldo, descricao FROM contas;


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

