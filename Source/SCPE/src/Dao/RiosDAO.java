/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dao.Conexao;
import Model.Endereco;
import Model.Rio;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author italo
 */
public class RiosDAO implements InterfaceDAO {

    private String sql;
    private Connection conn;

    //Função para adicionar PESSOA
    public void add(Object obj) {
        try {

            Rio rio = (Rio) obj;
            sql = "INSERT INTO rio (idEndereco, idBaciaHidografica, nomeRio) VALUES (?, ?, ?)";

            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, rio.getIdEndereco());
            stmt.setInt(2, rio.getIdBaciaHidrografica());
            stmt.setString(3, rio.getNome());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "RIO CADASTRADO COM SUCESSO!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Impossível executar o comando SQL\n" + error);
        }
    }

    //Função para editar PESSOA
    public void update(Object obj) {
        try {

            Rio rio = (Rio) obj;
            sql = "UPDATE rio SET idEndereco = ?, idBaciaHidografica = ?, nomeRio = ? WHERE idRio = ?";

            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            //Pegando o os dados pessoais do objeto PESSOA
            stmt.setInt(1, rio.getIdEndereco());
            stmt.setInt(2, rio.getIdBaciaHidrografica());
            stmt.setString(3, rio.getNome());
            stmt.setInt(4, rio.getId());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "RIO EDITADO COM SUCESSO!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "IMPOSSÍVEL EXECUTAR O COMANDO SQL\n" + error);
        }
    }

    //Função para deletar PESSOA
    public void delete(Object obj) {
        try {

            Rio rio = (Rio) obj;
            sql = "DELETE FROM rio WHERE idRio = ?";
            conn = Conexao.conexao();

            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, rio.getId());
            stmt.execute();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Impossível executar o comando SQL\n" + error);
        }
    }

    //Função para buscar PESSOAS
    public ArrayList consulta(String sql) {
        ArrayList<Rio> arrayRios = new ArrayList();
        try {

            conn = Conexao.conexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Rio rio = new Rio();
                rio.setId(rs.getInt("idRio"));
                rio.setIdEndereco(rs.getInt("idEndereco"));
                rio.setIdBaciaHidrografica(rs.getInt("idBaciaHidografica"));
                rio.setNomeEndereco(rs.getString("paisEndereco") + ", " + rs.getString("estadoEndereco") + ", " + rs.getString("reigaoEndereco") + ", " + rs.getString("cidadeEndereco") + ", " + rs.getString("bairroEndereco"));
                rio.setNomeBaciaHidrografica(rs.getString("nomeBaciaHidrografica"));
                rio.setNome(rs.getString("nomeRio"));

                arrayRios.add(rio);
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arrayRios;
    }
}
