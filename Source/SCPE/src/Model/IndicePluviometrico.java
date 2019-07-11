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
public class IndicePluviometrico {

    private int id;
    private int idEndereco;
    private double medida;
    private String periodo;
    private String estacao;
    private String data;

    public IndicePluviometrico() {

    }

    public IndicePluviometrico(int id, int idEndereco, double medida, String periodo, String estacao, String data) {
        this.id = id;
        this.idEndereco = idEndereco;
        this.medida = medida;
        this.periodo = periodo;
        this.estacao = estacao;
        this.data = data;
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
     * @return the medida
     */
    public double getMedida() {
        return medida;
    }

    /**
     * @param medida the medida to set
     */
    public void setMedida(double medida) {
        this.medida = medida;
    }

    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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

}
