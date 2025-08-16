Contas Pagar Lista
Contas Pagar Cadastro
    nome *
    Tipo (entrada/saída) *
    id conta *
    id cliente *
    valor *
    data prevista *
    data realizada
    status *
    registro_ativo *

ContasPagarReceberJframe
Filtros:
- Filtrar Por tipo (Entrada, Saída, Ambas)
- Filtrar Por Cliente (SELECT tabela de clientes)
- Filtrar Por Conta (SELECT tabela de contas)
- Filtrar Por Status
- Filtrar Por Nome (utilizando LIKE) Bat% %Bat %Bat%

Ordenação:
- Por Coluna (nome, cliente, valor, conta) 
- Por Órdem (A-Z, Z-A)

Paginação
- Anterior Página
- Primeira Página
- Próxima Página
- Última Página

Totalizadores:
- Apresentar "Página 1 de 100 páginas"
- * Total das Entradas
- * Total das Saídas

JTable

Exclusão física (DELETE FROM tabela WHERE id = ?)
Exclusão lógica (ativo = false, ativo = true (UPDATE tabela SET ativo = false WHERE id = ?))
SELECT * FROM entradas_saidas
SELECT COUNT(*) FORM entradas_saidas
