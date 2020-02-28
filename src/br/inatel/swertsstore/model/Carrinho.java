package br.inatel.swertsstore.model;

/*
    *** CLASSE CARRINHO ***

Objetivo: Criar um carrinho onde será armazenado os items selecionados pelo cliente, afim de realizar a compra.  

*/

import java.util.ArrayList;

public class Carrinho {
    //Atributos
    private int id;
    private String emailUsuario;
    //Lista do tipo produtos para armazenar os produtos do carrinho. 
    private ArrayList <Produto> listaDeProduto = new ArrayList<>();

    //Método para adicionar produto na lista.
    public void add(Produto produto){
        this.listaDeProduto.add(produto);
    }
    //Getter e Setters
    public ArrayList<Produto> getListaDeProduto() {
        return listaDeProduto;
    }

    public void setListaDeProduto(ArrayList<Produto> listaDeProduto) {
        this.listaDeProduto = listaDeProduto;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }    
}
