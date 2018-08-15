/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kasolution.funcionario.dao;

import java.util.List;

/**
 *
 * @author 130955800299
 */
public interface Dao<T> extends AutoCloseable {
    
    public void salvar(T t) throws DaoException;
    public void atualizar(T t) throws DaoException;
    public boolean excluir(T t) throws DaoException;
    public T buscarId(int id) throws DaoException;
    public List<T> buscarTodos() throws DaoException;  
    public void close() throws DaoException;
    
}
