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
public class Enchente {

    private int id;
    private int idEndereco;
    private int idRio;
    private String data;
    private String estacao;

    public Enchente() {

    }

    public Enchente(int id, int idEndereco, int idRio, String data, String estacao) {
        this.id = id;
        this.idEndereco = idEndereco;
        this.idRio = idRio;
        this.data = data;
        this.estacao = estacao;
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
     * @return the idEndereco
     */
    public int getIdEndereco() {
        return idEndereco;
    }

    /**
     * @param idEndereco the idEndereco to set
     */
    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
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

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the estacao
     */
    public String getEstacao() {
        return estacao;
    }

    /**
     * @param estacao the estacao to set
     */
    public void setEstacao(String estacao) {
        this.estacao = estacao;
    }

}
