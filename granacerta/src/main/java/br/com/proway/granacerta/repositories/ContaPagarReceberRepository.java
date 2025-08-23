/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.proway.granacerta.repositories;

import br.com.proway.granacerta.bancodados.BancoDadosUtil;
import br.com.proway.granacerta.bean.Cliente;
import br.com.proway.granacerta.bean.Conta;
import br.com.proway.granacerta.bean.ContaPagarReceber;
import br.com.proway.granacerta.enums.ContaStatusEnum;
import br.com.proway.granacerta.enums.ContaTipoEnum;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francisco.sens
 */
public class ContaPagarReceberRepository implements ContaPagarReceberRepositoryInterface {

    @Override
    public void adicionar(ContaPagarReceber conta) throws SQLException {
        try (Connection conexao = BancoDadosUtil.getConnection()) {
            String sql = """
                         INSERT INTO contas_receber_pagar (
                            id_cliente,
                            id_conta,
                            nome,
                            tipo,
                            valor,
                            data_prevista,
                            status
                         ) VALUES (?, ?, ?, ?, ?, ?, ?);
                         """;
            var preparadorDeSql = conexao.prepareStatement(sql);
            preparadorDeSql.setInt(1, conta.getCliente().getId());
            preparadorDeSql.setInt(2, conta.getConta().getId());
            preparadorDeSql.setString(3, conta.getNome());
            preparadorDeSql.setInt(4, conta.getTipo().getCode());
            preparadorDeSql.setDouble(5, conta.getValor());
            preparadorDeSql.setDate(6, Date.valueOf(conta.getDataPrevista()));
            preparadorDeSql.setInt(7, conta.getStatus().getCode());
            preparadorDeSql.execute();
        }
    }

    @Override
    public List<ContaPagarReceber> obterTodos() throws SQLException {
        var contasPagarReceber = new ArrayList<ContaPagarReceber>();
        try (var conexao = BancoDadosUtil.getConnection()) {
            String sql = """
                         SELECT 
                             crp.id,
                             c.id AS cliente_id,
                             c.nome AS cliente_nome,
                             ct.id AS conta_id,
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
                         """;
            var preparadorSql = conexao.prepareStatement(sql);

            var registros = preparadorSql.executeQuery();
            while (registros.next()) {
                ContaPagarReceber contaPagarReceber = new ContaPagarReceber();
                contaPagarReceber.setId(registros.getInt("id"));
                contaPagarReceber.setValor(registros.getDouble("valor"));
                contaPagarReceber.setNome(registros.getString("transacao_nome"));
                contaPagarReceber.setRegistroAtivo(registros.getBoolean("registro_ativo"));
                contaPagarReceber.setTipo(ContaTipoEnum.fromCode(registros.getInt("tipo")));
                contaPagarReceber.setStatus(ContaStatusEnum.fromCode(registros.getInt("status")));
                contaPagarReceber.setDataPrevista(
                        registros.getDate("data_prevista").toLocalDate());
                contaPagarReceber.setDataHoraCriacao(
                        registros.getTimestamp("data_criacao").toLocalDateTime());
                var dataRealizadaBanco = registros.getDate("data_realizada");
                if (dataRealizadaBanco != null) {
                    contaPagarReceber.setDataRealizada(dataRealizadaBanco.toLocalDate());
                }
                var cliente = new Cliente();
                cliente.setId(registros.getInt("cliente_id"));
                cliente.setNome(registros.getString("cliente_nome"));
                contaPagarReceber.setCliente(cliente);
                
                var conta = new Conta();
                conta.setId(registros.getInt("conta_id"));
                conta.setNome(registros.getString("conta_nome"));
                contaPagarReceber.setConta(conta);
                
                contasPagarReceber.add(contaPagarReceber);
            }
        }
        return contasPagarReceber;
    }

    @Override
    public ContaPagarReceber obterPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(ContaPagarReceber conta) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void apagar(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
