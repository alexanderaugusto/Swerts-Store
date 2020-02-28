package br.inatel.swertsstore.util;

/*
    *** CLASSE WEB SERVICE CEP ***

Objetivo: Retorna os dados da busca do CEP. 

*/

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Webservicecep {
    // Atributos
    private String resultado;
    private String resultado_txt;
    private String uf;
    private String cidade;
    private String bairro;
    private String tipo_logradouro;
    private String logradouro;
    
    // Getters e Setters
    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado_txt() {
        return resultado_txt;
    }

    public void setResultado_txt(String resultado_txt) {
        this.resultado_txt = resultado_txt;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTipo_logradouro() {
        return tipo_logradouro;
    }

    public void setTipo_logradouro(String tipo_logradouro) {
        this.tipo_logradouro = tipo_logradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
