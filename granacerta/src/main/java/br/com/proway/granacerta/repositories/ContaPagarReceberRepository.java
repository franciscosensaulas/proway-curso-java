/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.proway.granacerta.repositories;

import br.com.proway.granacerta.bancodados.BancoDadosUtil;
import br.com.proway.granacerta.bean.ContaPagarReceber;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author francisco.sens
 */
public class ContaPagarReceberRepository  implements ContaPagarReceberRepositoryInterface{

    @Override
    public void adicionar(ContaPagarReceber conta) throws SQLException {
        try(Connection conexao = BancoDadosUtil.getConnection()){
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
