/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ariel
 */
public class Relatorio {

    private String cidade;
    private String estado;
    private String periodo;
    private String medida;
    private String bairro;    


    public Relatorio() {

    }

    public Relatorio(String cidade, String estado, String periodo, String medida, String bairro) {
        this.cidade = cidade;
        this.estado = estado;
        this.periodo = periodo;
        this.medida = medida;
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
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
     * @return the medida
     */
    public String getMedida() {
        return medida;
    }

    /**
     * @param medida the medida to set
     */
    public void setMedida(String medida) {
        this.medida = medida;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Object getRegiao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}