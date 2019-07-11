/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dao.Conexao;
import Model.BaciaHidrografica;
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
public class BaciasHidrograficasDAO implements InterfaceDAO {

    private String sql;
    private Connection conn;

    //Função para adicionar PESSOA
    public void add(Object obj) {
        try {

            BaciaHidrografica baciahidrografica = (BaciaHidrografica) obj;
            sql = "INSERT INTO baciaHidrografica (nomeBaciaHidrografica, areaBaciaHidrografica) VALUES (?, ?)";

            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, baciahidrografica.getNome());
            stmt.setDouble(2, baciahidrografica.getArea());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "ENDERECO CADASTRADO COM SUCESSO!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Impossível executar o comando SQL\n" + error);
        }
    }

    //Função para editar PESSOA
    public void update(Object obj) {
        try {

            BaciaHidrografica baciahidrografica = (BaciaHidrografica) obj;
            sql = "UPDATE baciaHidrografica SET nomeBaciaHidrografica = ?, areaBaciaHidrografica = ? WHERE idBaciaHidografica = ?";

            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            //Pegando o os dados pessoais do objeto PESSOA
            stmt.setString(1, baciahidrografica.getNome());
            stmt.setDouble(2, baciahidrografica.getArea());
            stmt.setInt(3, baciahidrografica.getId());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "BACIA HIDROGRAFICA EDITADA COM SUCESSO!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "IMPOSSÍVEL EXECUTAR O COMANDO SQL\n" + error);
        }
    }

    //Função para deletar PESSOA
    public void delete(Object obj) {
        try {

            BaciaHidrografica baciahidrografica = (BaciaHidrografica) obj;
            int codBacia = baciahidrografica.getId();

            PreparedStatement stmt;
            PreparedStatement stmtVerificaRios;
            PreparedStatement stmtRios;
            conn = Conexao.conexao();

            stmtVerificaRios = conn.prepareStatement("SELECT * FROM rio WHERE idBaciaHidografica = ?");
            stmtVerificaRios.setInt(1, codBacia);
            stmtVerificaRios.executeQuery();
            ResultSet rs = stmtVerificaRios.getResultSet();
            rs.last();
            int rows = rs.getRow();

            if (rows > 0) {
                Object[] opcoes = {"SIM", "NÃO"};
                JOptionPane.showMessageDialog(null, "Impossível Excluir a Bacia Hidrografica! Existem: " + rows + " rios nessa Bacia Hidrografica!");
                int confirmaDelete = JOptionPane.showOptionDialog(null, "DESEJA REALMENTE DELETAR OS RIOS RELACIONADOS A ESSA BACIA E A BACIA?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                if (confirmaDelete == 0) {
                    stmtRios = conn.prepareStatement("DELETE FROM rio WHERE idBaciaHidografica = ?");
                    stmtRios.setInt(1, codBacia);
                    stmtRios.execute();

                    stmt = conn.prepareStatement("DELETE FROM baciaHidrografica WHERE idBaciaHidografica = ?");
                    stmt.setInt(1, codBacia);
                    stmt.execute();
                }
            } else {
                stmt = conn.prepareStatement("DELETE FROM baciaHidrografica WHERE idBaciaHidografica = ?");
                stmt.setInt(1, codBacia);
                stmt.execute();
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Impossível executar o comando SQL\n" + error);
        }
    }

    //Função para buscar PESSOAS
    public ArrayList consulta(String sql) {
        ArrayList<BaciaHidrografica> arrayBaciaHidrografica = new ArrayList();
        try {

            conn = Conexao.conexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                BaciaHidrografica baciahidrografica = new BaciaHidrografica();
                baciahidrografica.setId(rs.getInt("idBaciaHidografica"));
                baciahidrografica.setNome(rs.getString("nomeBaciaHidrografica"));
                baciahidrografica.setArea(rs.getDouble("areaBaciaHidrografica"));
                arrayBaciaHidrografica.add(baciahidrografica);

            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arrayBaciaHidrografica;
    }
}
