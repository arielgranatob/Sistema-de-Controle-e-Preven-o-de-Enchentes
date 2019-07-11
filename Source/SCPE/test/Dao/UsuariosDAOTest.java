/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Usuario;
import Dao.UsuariosDAO;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author italo
 */
public class UsuariosDAOTest {

    public UsuariosDAOTest() {
    }

    /**
     * Test of add method, of class UsuariosDAO.
     */
    @Test
    @Ignore
    public void inserir() {

        Usuario usuario = new Usuario();
        usuario.setNome("italo");
        usuario.setCpf("13057876684");
        usuario.setEmail("italorodriguesbp@hotmail.com");
        usuario.setEndereco("Rua José Victor");
        usuario.setLogin("italodois");
        usuario.setNumeroRegistro("3232");
        usuario.setSenha("123123");

        UsuariosDAO usuariosdao = new UsuariosDAO();

        usuariosdao.add(usuario);
    }

    /**
     * Test of update method, of class UsuariosDAO.
     */
    @Test
    @Ignore
    public void update() {

        Usuario usuario = new Usuario();
        usuario.setNome("italo");
        usuario.setCpf("13057876684");
        usuario.setEmail("italorodriguesbp@hotmail.com");
        usuario.setEndereco("Rua José Victor");
        usuario.setLogin("italotres");
        usuario.setNumeroRegistro("3232");
        usuario.setSenha("123123");
        usuario.setId(5);

        UsuariosDAO usuariosdao = new UsuariosDAO();

        usuariosdao.update(usuario);

    }

    @Test
    @Ignore
    public void delete() {
        Usuario usuario = new Usuario();
        usuario.setId(4);

        UsuariosDAO usuariosdao = new UsuariosDAO();

        usuariosdao.delete(usuario);

    }

    @Test
    public void list() {

        String sql = "SELECT * FROM Usuario";
        ArrayList<Usuario> arrayUsuarios = new ArrayList<Usuario>();
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        arrayUsuarios = usuariosDAO.consulta(sql);

        for (int i = 0; i < arrayUsuarios.size(); i++) {

            System.out.println(arrayUsuarios.get(i).getId());
            System.out.println(arrayUsuarios.get(i).getNome());
            System.out.println(arrayUsuarios.get(i).getEmail());
            System.out.println(arrayUsuarios.get(i).getLogin());
            System.out.println(arrayUsuarios.get(i).getSenha());
            System.out.println(arrayUsuarios.get(i).getEndereco());
            System.out.println(arrayUsuarios.get(i).getCpf());
            System.out.println(arrayUsuarios.get(i).getNumeroRegistro());

        }

    }

}
