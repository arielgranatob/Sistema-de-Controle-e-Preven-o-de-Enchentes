/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel
 */
public class RelatoriosDAO implements InterfaceDAO {

    private String sql;
    private Connection conn;

    @Override
    public void add(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList consulta(String sql) {
        ArrayList<Relatorio> arrayRelatorios = new ArrayList();
        try {

            conn = Conexao.conexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Relatorio relatorio = new Relatorio();
                relatorio.setPeriodo(rs.getString("periodoIndicePluviometrico"));
                relatorio.setCidade(rs.getString("cidadeEndereco"));
                relatorio.setBairro(rs.getString("bairroEndereco"));
                relatorio.setEstado(rs.getString("estadoEndereco"));
                relatorio.setMedida(rs.getString("medidaIndicePluviometrico"));
                arrayRelatorios.add(relatorio);
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arrayRelatorios;
    }

}
