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
public class Rio {

    private int id;
    private int idEndereco;
    private int idBaciaHidrografica;
    private String nome;
    private String nomeEndereco;
    private String nomeBaciaHidrografica;

    public Rio() {

    }

    public Rio(int id, int idEndereco, int idBaciaHidrografica, String nome) {
        this.id = id;
        this.idEndereco = idEndereco;
        this.idBaciaHidrografica = idBaciaHidrografica;
        this.nome = nome;
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
     * @return the idBaciaHidrografica
     */
    public int getIdBaciaHidrografica() {
        return idBaciaHidrografica;
    }

    /**
     * @param idBaciaHidrografica the idBaciaHidrografica to set
     */
    public void setIdBaciaHidrografica(int idBaciaHidrografica) {
        this.idBaciaHidrografica = idBaciaHidrografica;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nomeEndereco
     */
    public String getNomeEndereco() {
        return nomeEndereco;
    }

    /**
     * @param nomeEndereco the nomeEndereco to set
     */
    public void setNomeEndereco(String nomeEndereco) {
        this.nomeEndereco = nomeEndereco;
    }

    /**
     * @return the nomeBaciaHidrografica
     */
    public String getNomeBaciaHidrografica() {
        return nomeBaciaHidrografica;
    }

    /**
     * @param nomeBaciaHidrografica the nomeBaciaHidrografica to set
     */
    public void setNomeBaciaHidrografica(String nomeBaciaHidrografica) {
        this.nomeBaciaHidrografica = nomeBaciaHidrografica;
    }

}
