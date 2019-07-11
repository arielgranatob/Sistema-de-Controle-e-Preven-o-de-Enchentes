/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Endereco;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author italo
 */
public class EnderecosDAOTest {

    public EnderecosDAOTest() {
    }

    /**
     * Test of add method, of class UsuariosDAO.
     */
    @Test
    @Ignore
    public void inserir() {

        Endereco endereco = new Endereco();
        endereco.setPais("Brasil");
        endereco.setEstado("MG");
        endereco.setCidade("Rio Pomba");
        endereco.setRegiao("Sudeste");
        endereco.setBairro("ITAOCA");
        EnderecosDAO enderecosdao = new EnderecosDAO();

        enderecosdao.add(endereco);
    }

    @Test
    @Ignore
    public void update() {

        Endereco endereco = new Endereco();
        endereco.setPais("Brasil");
        endereco.setEstado("MG");
        endereco.setCidade("Rio Pomba");
        endereco.setRegiao("Sudeste");
        endereco.setBairro("ITAOCA");
        endereco.setId(7);
        EnderecosDAO enderecosdao = new EnderecosDAO();

        enderecosdao.update(endereco);
    }

    @Test
    @Ignore
    public void delete() {

        Endereco endereco = new Endereco();
        endereco.setId(7);
        EnderecosDAO enderecosdao = new EnderecosDAO();
        enderecosdao.delete(endereco);
    }

    /**
     * Test of update method, of class UsuariosDAO.
     */
    @Test
    public void list() {

        String sql = "SELECT * FROM endereco";
        ArrayList<Endereco> arrayEndereco = new ArrayList<Endereco>();
        EnderecosDAO enderecosDAO = new EnderecosDAO();
        arrayEndereco = enderecosDAO.consulta(sql);

        for (int i = 0; i < arrayEndereco.size(); i++) {

            System.out.println(arrayEndereco.get(i).getId());
            System.out.println(arrayEndereco.get(i).getPais());
            System.out.println(arrayEndereco.get(i).getRegiao());
            System.out.println(arrayEndereco.get(i).getEstado());
            System.out.println(arrayEndereco.get(i).getBairro());
            System.out.println(arrayEndereco.get(i).getCidade());

        }

    }
}
