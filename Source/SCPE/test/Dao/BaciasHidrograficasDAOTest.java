/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.BaciaHidrografica;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author italo
 */
public class BaciasHidrograficasDAOTest {

    public BaciasHidrograficasDAOTest() {
    }

    /**
     * Test of add method, of class UsuariosDAO.
     */
    @Test
    public void inserir() {

        BaciaHidrografica baciahidrografica = new BaciaHidrografica();
        baciahidrografica.setNome("Bacia do Teste");
        baciahidrografica.setArea(3213213);

        BaciasHidrograficasDAO baciashidrograficasdao = new BaciasHidrograficasDAO();

        baciashidrograficasdao.add(baciahidrografica);
    }

    @Test
    public void update() {

        BaciaHidrografica baciahidrografica = new BaciaHidrografica();
        baciahidrografica.setNome("Bacia do Teste");
        baciahidrografica.setArea(3213213);
        baciahidrografica.setId(4);

        BaciasHidrograficasDAO baciashidrograficasdao = new BaciasHidrograficasDAO();

        baciashidrograficasdao.update(baciahidrografica);
    }

    @Test
    public void delete() {

        BaciaHidrografica baciahidrografica = new BaciaHidrografica();
        baciahidrografica.setId(1);

        BaciasHidrograficasDAO baciashidrograficasdao = new BaciasHidrograficasDAO();

        baciashidrograficasdao.delete(baciahidrografica);
    }

    @Test
    public void list() {

        String sql = "SELECT * FROM baciaHidrografica";
        ArrayList<BaciaHidrografica> arrayBaciaHidrografica = new ArrayList<BaciaHidrografica>();
        BaciasHidrograficasDAO baciashidrograficasdao = new BaciasHidrograficasDAO();
        arrayBaciaHidrografica = baciashidrograficasdao.consulta(sql);

        for (int i = 0; i < arrayBaciaHidrografica.size(); i++) {
            System.out.println(arrayBaciaHidrografica.get(i).getId());
            System.out.println(arrayBaciaHidrografica.get(i).getNome());
            System.out.println(arrayBaciaHidrografica.get(i).getArea());
        }

    }
}
