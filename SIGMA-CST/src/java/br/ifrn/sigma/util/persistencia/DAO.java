/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.sigma.util.persistencia;

import java.sql.Connection;

/**
 *
 * @author Yuri
 */
public abstract class DAO {  
    protected Connection con;
    public Connection getConection(){
        return this.con;
    }     
}
