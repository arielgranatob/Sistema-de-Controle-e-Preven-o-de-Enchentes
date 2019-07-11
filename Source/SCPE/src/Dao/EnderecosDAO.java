/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dao.Conexao;
import Model.Endereco;
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
public class EnderecosDAO implements InterfaceDAO {

    private String sql;
    private Connection conn;

    //Função para adicionar PESSOA
    public void add(Object obj) {
        try {

            Endereco endereco = (Endereco) obj;
            sql = "INSERT INTO endereco (paisEndereco, estadoEndereco, reigaoEndereco, cidadeEndereco, bairroEndereco) VALUES (?, ?, ?, ?, ?)";

            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, endereco.getPais());
            stmt.setString(2, endereco.getEstado());
            stmt.setString(3, endereco.getRegiao());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getBairro());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "ENDERECO CADASTRADO COM SUCESSO!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Impossível executar o comando SQL\n" + error);
        }
    }

    //Função para editar PESSOA
    public void update(Object obj) {
        try {

            Endereco endereco = (Endereco) obj;
            sql = "UPDATE endereco SET paisEndereco = ?, estadoEndereco = ?, reigaoEndereco = ?, cidadeEndereco = ?, bairroEndereco = ? WHERE idEndereco = ?";

            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            //Pegando o os dados pessoais do objeto PESSOA
            stmt.setString(1, endereco.getPais());
            stmt.setString(2, endereco.getEstado());
            stmt.setString(3, endereco.getRegiao());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getBairro());
            stmt.setInt(6, endereco.getId());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "ENDEREÇO EDITADO COM SUCESSO!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "IMPOSSÍVEL EXECUTAR O COMANDO SQL\n" + error);
        }
    }

    //Função para deletar PESSOA
    public void delete(Object obj) {
        try {

            Endereco endereco = (Endereco) obj;
            sql = "DELETE FROM endereco WHERE idEndereco = ?";
            conn = Conexao.conexao();

            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, endereco.getId());
            stmt.execute();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Impossível executar o comando SQL\n" + error);
        }
    }

    //Função para buscar PESSOAS
    public ArrayList consulta(String sql) {
        ArrayList<Endereco> arrayEnderecos = new ArrayList();
        try {

            conn = Conexao.conexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("idEndereco"));
                endereco.setPais(rs.getString("paisEndereco"));
                endereco.setEstado(rs.getString("estadoEndereco"));
                endereco.setRegiao(rs.getString("reigaoEndereco"));
                endereco.setCidade(rs.getString("cidadeEndereco"));
                endereco.setBairro(rs.getString("bairroEndereco"));
                arrayEnderecos.add(endereco);
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arrayEnderecos;
    }
}
