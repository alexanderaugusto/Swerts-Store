package br.inatel.swertsstore.util;

/*
    *** CLASSE FINALIZAR COMPRA ***

Objetivo: Armazenar os dados para realizar a finalização da compra. 

*/

public class FinalizarCompra {
    //Atributos 
    private String precoTotal;
    private String tipoEnvio;
    private String prazoEnvio;
    private String valorFrete;

    // Construtor
    public FinalizarCompra(String precoTotal, String tipoEnvio, String prazoEnvio, String valorFrete) {
        this.precoTotal = precoTotal;
        this.tipoEnvio = tipoEnvio;
        this.prazoEnvio = prazoEnvio;
        this.valorFrete = valorFrete;
    }
    
    //Getters e Setters 
    public String getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(String precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public String getPrazoEnvio() {
        return prazoEnvio;
    }

    public void setPrazoEnvio(String prazoEnvio) {
        this.prazoEnvio = prazoEnvio;
    }

    public String getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(String valorFrete) {
        this.valorFrete = valorFrete;
    }

  
}
