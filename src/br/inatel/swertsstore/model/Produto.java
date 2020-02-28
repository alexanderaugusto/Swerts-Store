package br.inatel.swertsstore.model;

/*
    *** CLASSE PRODUTO***

Objetivo: Armazenar os dados dos produtos.  

*/

public class Produto {
    //Atributos
    private int codigo;
    private String tipo;
    private float preco;
    private String marca;
    private String modelo;
    private String cor;
    private String titulo;
    private int quantidade;
    private byte[] imagem;
    private int quantidadeCompra;

    //Construtor 
    public Produto(int codigo, String tipo, float preco, String marca, String modelo, String cor, String titulo, int quantidade, 
            byte[] imagem) {
        
        this.codigo = codigo;
        this.tipo = tipo;
        this.preco = preco;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.imagem = imagem;
    }
    
    public Produto(int codigo, String tipo, float preco, String marca, String modelo, String cor, String titulo, int quantidade, 
            byte[] imagem, int quantidadeCompra) {
        
        this.codigo = codigo;
        this.tipo = tipo;
        this.preco = preco;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.imagem = imagem;
        this.quantidadeCompra = quantidadeCompra;
    }
    
    //Getters e Setters 
    public int getQuantidadeCompra() {
        return quantidadeCompra;
    }

    public void setQuantidadeCompra(int quantidadeCompra) {
        this.quantidadeCompra = quantidadeCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
       
     public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
