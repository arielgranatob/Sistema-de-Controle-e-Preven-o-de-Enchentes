/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author italo
 */
public class LoginDAO {

    private String sql;
    private Connection conn;

    public int logar(String usuario, String senha) {
        int logou = 0;
        try {

            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT * FROM Usuario WHERE loginUsuario = ? AND senhaUsuario = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.first()) {

                logou = (rs.getInt("nivelPrivilegioUsuario"));

            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return logou;
    }

}
