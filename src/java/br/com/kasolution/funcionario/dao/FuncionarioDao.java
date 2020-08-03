/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kasolution.funcionario.dao;

import br.com.kasolution.funcionario.modelo.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 130955800299
 */
public class FuncionarioDao implements Dao<Funcionario> {

    private static final String SQL_INSERT = "INSERT INTO FUNCIONARIO (NOME, SEXO, IDADE, CIDADE, ESTADO, SALARIO)"
            + " VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE FUNCIONARIO SET "
            + " NOME = ?, "
            + " SEXO = ?, "
            + " IDADE = ?, "
            + " CIDADE = ?, "
            + " ESTADO = ?, "
            + " SALARIO = ? "
            + " WHERE CODIGO = ? ";
    private static final String SQL_DELETE = "DELETE FROM FUNCIONARIO WHERE CODIGO = ?";
    private static final String SQL_QUERY_ALL = "SELECT CODIGO, NOME, SEXO, IDADE, CIDADE,"
            + " ESTADO, SALARIO FROM FUNCIONARIO";
    private static final String SQL_QUERY_ONE = "SELECT CODIGO, NOME, SEXO, IDADE, CIDADE,"
            + " ESTADO, SALARIO FROM FUNCIONARIO WHERE CODIGO = ?";

    private Connection con;

    public FuncionarioDao() {
        String url = "jdbc:mysql://localhost:3306/HRWEB?useTimezone=true&serverTimezone=UTC";
        String username = "root";
        String password = "oracle_4U";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao obter conexão com o MySQL ! " + ex.getMessage());
        }//fim try
    }//fim metodo

    @Override
    public void salvar(Funcionario t) throws DaoException {
        //NOME, SEXO, IDADE, CIDADE, ESTADO, SALARIO
        try (PreparedStatement stmt = con.prepareStatement(SQL_INSERT)) {
            stmt.setString(1, t.getNome());
            stmt.setString(2, String.valueOf(t.getSexo()));
            stmt.setInt(3, t.getIdade());
            stmt.setString(4, t.getCidade());
            stmt.setString(5, t.getEstado());
            stmt.setDouble(6, t.getSalario());
            int qtdLinhas = stmt.executeUpdate();

            if (qtdLinhas != 1) {
                throw new DaoException("Erro ao INSERIR funcionario! Retorno != (1)");
            }
        } catch (SQLException ex) {
            throw new DaoException("Erro ao INSERIR Funcionario! " + ex.getMessage());
        }
    }//fim salvar

    @Override
    public void atualizar(Funcionario t) throws DaoException {
        try (PreparedStatement stmt = con.prepareStatement(SQL_UPDATE)) {
            stmt.setString(1, t.getNome());
            stmt.setString(2, String.valueOf(t.getSexo()));
            stmt.setInt(3, t.getIdade());
            stmt.setString(4, t.getCidade());
            stmt.setString(5, t.getEstado());
            stmt.setDouble(6, t.getSalario());
            stmt.setInt(7, t.getCodigo());
            int qtdLinhas = stmt.executeUpdate();

            if (qtdLinhas != 1) {
                throw new DaoException("Erro ao ATUALIZAR funcionario! Retorno != (1)");
            }

        } catch (SQLException ex) {
            throw new DaoException("Erro ao ATUALIZAR Funcionario! " + ex.getMessage());
        }
    }//fim atualizar

    @Override
    public boolean excluir(Funcionario t) throws DaoException {
        try (PreparedStatement stmt = con.prepareStatement(SQL_DELETE)) {
            stmt.setInt(1, t.getCodigo());
            return stmt.execute();
        } catch (SQLException ex) {
            throw new DaoException("Erro ao EXCLUIR Funcionario! " + ex.getMessage());
        }
    }//fim excluir

    @Override
    public Funcionario buscarId(int id) throws DaoException {
        //NOME, SEXO, IDADE, CIDADE, ESTADO, SALARIO
        Funcionario f = null;
        try (PreparedStatement stmt = con.prepareStatement(SQL_QUERY_ONE)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    f = ormFuncionario(rs);
                }
            } catch (SQLException ex) {
                throw new DaoException("Erro ao BUSCAR FUNCIONARIO POR ID! " + ex.getMessage());
            }
            return f;
        } catch (SQLException ex) {
            throw new DaoException("Erro ao  BUSCAR FUNCIONARIO POR ID! " + ex.getMessage());
        }
    }//fim buscarId

    @Override
    public List<Funcionario> buscarTodos() throws DaoException {
        //NOME, SEXO, IDADE, CIDADE, ESTADO, SALARIO
        List<Funcionario> fs = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(SQL_QUERY_ALL)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    fs.add(ormFuncionario(rs));
                }
            } catch (SQLException ex) {
                throw new DaoException("Erro ao BUSCAR FUNCIONARIOS! " + ex.getMessage());
            }
            return fs;
        } catch (SQLException ex) {
            throw new DaoException("Erro ao BUSCAR FUNCIONARIOS! " + ex.getMessage());
        }
    }//fim buscarTodos

    @Override
    public void close() throws DaoException {
        try {
            con.close();
        } catch (SQLException ex) {
            throw new DaoException("Erro ao encerrar conexão com o BD!" + ex.getMessage());
        }
    }

    private Funcionario ormFuncionario(ResultSet rs) throws SQLException {
        return new Funcionario(rs.getInt("CODIGO"),
                rs.getString("NOME"),
                rs.getString("SEXO").charAt(0),
                rs.getInt("IDADE"),
                rs.getString("CIDADE"),
                rs.getString("ESTADO"),
                rs.getDouble("SALARIO"));
    }
}
