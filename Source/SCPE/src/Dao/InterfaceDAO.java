/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.ArrayList;

/**
 *
 * @author italo
 */
//Interface para modelo de funções que cada DAO deve obrigatoriamente seguir
public interface InterfaceDAO {

    public void add(Object obj);

    public void update(Object obj);

    public void delete(Object obj);

    public ArrayList consulta(String sql);
}
