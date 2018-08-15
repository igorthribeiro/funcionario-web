/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kasolution.funcionario.dao;

/**
 *
 * @author 130955800299
 */
public class DaoException extends Exception {
    
    public DaoException() {
        super();
    }
    
    public DaoException(String message) {
        super(message);
    }
    
    public DaoException(Throwable cause) {
        super(cause);
    }
    
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }    
}
