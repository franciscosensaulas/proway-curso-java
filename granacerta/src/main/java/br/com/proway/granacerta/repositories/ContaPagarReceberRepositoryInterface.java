/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.proway.granacerta.repositories;

import br.com.proway.granacerta.bean.ContaPagarReceber;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author francisco.sens
 */
public interface ContaPagarReceberRepositoryInterface {
    void adicionar(ContaPagarReceber conta) throws SQLException;
    List<ContaPagarReceber> obterTodos() throws SQLException;
    ContaPagarReceber obterPorId(int id) throws SQLException;
    void editar(ContaPagarReceber conta) throws SQLException;
    void apagar(int id) throws SQLException;
}
