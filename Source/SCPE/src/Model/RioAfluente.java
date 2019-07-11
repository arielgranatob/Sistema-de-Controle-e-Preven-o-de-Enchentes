/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author italo
 */
public class RioAfluente {

    private int id;
    private int idRio;

    public RioAfluente() {

    }

    public RioAfluente(int id, int idRio) {
        this.id = id;
        this.idRio = idRio;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idRio
     */
    public int getIdRio() {
        return idRio;
    }

    /**
     * @param idRio the idRio to set
     */
    public void setIdRio(int idRio) {
        this.idRio = idRio;
    }

}
