/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dao.Conexao;
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
public class UsuariosDAO implements InterfaceDAO {

    private String sql;
    private Connection conn;

    //Função para adicionar PESSOA
    public void add(Object obj) {
        try {

            Usuario usuario = (Usuario) obj;
            sql = "INSERT INTO Usuario (nomeUsuario, emailUsuario, loginUsuario, senhaUsuario, enderecoUsuario, cpfUsuario, numeroRegistoUsuario, nivelPrivilegioUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getEndereco());
            stmt.setString(6, usuario.getCpf());
            stmt.setString(7, usuario.getNumeroRegistro());
            stmt.setInt(8, 1);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "USÚARIO CADASTRADO COM SUCESSO!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Impossível executar o comando SQL\n" + error);
        }
    }

    //Função para editar PESSOA
    public void update(Object obj) {
        try {

            Usuario usuario = (Usuario) obj;
            sql = "UPDATE Usuario SET nomeUsuario = ?, emailUsuario = ?, loginUsuario = ?, enderecoUsuario = ?, cpfUsuario = ?, numeroRegistoUsuario = ?  WHERE idUsuario = ?";

            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            //Pegando o os dados pessoais do objeto PESSOA
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getEndereco());
            stmt.setString(5, usuario.getCpf());
            stmt.setString(6, usuario.getNumeroRegistro());
            stmt.setInt(7, usuario.getId());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "USUARIO EDITADO COM SUCESSO!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "IMPOSSÍVEL EXECUTAR O COMANDO SQL\n" + error);
        }
    }

    //Função para deletar PESSOA
    public void delete(Object obj) {
        try {

            Usuario usuario = (Usuario) obj;
            sql = "DELETE FROM Usuario WHERE idUsuario = ?";
            conn = Conexao.conexao();

            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            stmt.execute();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Impossível executar o comando SQL\n" + error);
        }
    }

    //Função para buscar PESSOAS
    public ArrayList consulta(String sql) {
        ArrayList<Usuario> arrayUsuarios = new ArrayList();
        try {

            conn = Conexao.conexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nomeUsuario"));
                usuario.setEmail(rs.getString("emailUsuario"));
                usuario.setLogin(rs.getString("loginUsuario"));
                usuario.setSenha(rs.getString("senhaUsuario"));
                usuario.setEndereco(rs.getString("enderecoUsuario"));
                usuario.setCpf(rs.getString("cpfUsuario"));
                usuario.setNumeroRegistro(rs.getString("numeroRegistoUsuario"));
                arrayUsuarios.add(usuario);
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arrayUsuarios;
    }
}
