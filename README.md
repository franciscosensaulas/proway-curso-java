Proprietario
    id
    nome
    cpf
    email
    senha

Cliente
    id
    nome
    cnpj
    

Conta
    id
    tipo [Pounpança, Corrente] (ENUM)
    nome
    proprietario
    saldo

Entradas
    id
    nome
    valor
    data estimada
    data efetiva
    conta
    status

Saidas
    id
    nome
    valor
    data estimava
    data efetivada
    conta
    status

Extrato
    histórico