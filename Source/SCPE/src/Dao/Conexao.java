/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author italo
 */
public class Conexao {

    private static Connection conn = null;

    private Conexao() {
        String userName = "arielgranato_adminSCPE";
        String password = "admscpe123";
        String url = "jdbc:mysql://arielgranato.com.br:3306/arielgranato_SCPE";
        String driver = "com.mysql.jdbc.Driver";
        // String driver = "org.mariadb.jdbc.Driver";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection conexao() {
        if (conn == null) {
            new Conexao();
            return conn;
        } else {
            return conn;
        }
    }
}