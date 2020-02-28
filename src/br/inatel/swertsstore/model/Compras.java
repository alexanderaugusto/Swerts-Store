package br.inatel.swertsstore.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    *** CLASSE COMPRAS ***

Objetivo: Guardar os dados das compras realiza pelo usuário. 

 */
public class Compras extends Produto {

    //Atributos
    private String nomeUsuario;
    private String dataCompra;

    //Construtor 
    public Compras(int codigo, String tipo, float preco, String marca, String modelo, String cor, String titulo, int quantidade,
            byte[] imagem, String nomeUsuario, String dataCompra) {
        super(codigo, tipo, preco, marca, modelo, cor, titulo, quantidade, imagem);
        this.nomeUsuario = nomeUsuario;
        this.dataCompra = dataCompra;
    }

    //Getters e Setters
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public static Comparator<Produto> descricao = new Comparator<Produto>() {
        @Override
        public int compare(Produto p1, Produto p2) {
            return p1.getTitulo().compareTo(p2.getTitulo());
        }
    };

    public static Comparator<Produto> maiorPreco = new Comparator<Produto>() {
        @Override
        public int compare(Produto p1, Produto p2) {
            if (p1.getPreco() > p2.getPreco()) {
                return -1;
            } else if (p1.getPreco() < p2.getPreco()) {
                return 1;
            } else {
                return 0;
            }
        }
    };
    
    public static Comparator<Produto> menorPreco = new Comparator<Produto>() {
        @Override
        public int compare(Produto p1, Produto p2) {
            if (p1.getPreco() > p2.getPreco()) {
                return 1;
            } else if (p1.getPreco() < p2.getPreco()) {
                return -1;
            } else {
                return 0;
            }
        }
    };
    
    public static Comparator<Compras> data = new Comparator<Compras>() {
        @Override
        public int compare(Compras c1, Compras c2) {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Calendar dataAtual = new GregorianCalendar();
            Calendar dataPrevistaEntrega = new GregorianCalendar();
            
            try {
                dataAtual.setTime(format.parse(c1.getDataCompra()));
                dataPrevistaEntrega.setTime(format.parse(c2.getDataCompra()));
            } catch (ParseException ex) {
                System.out.println("Erro = " + ex);
            }
            if(dataAtual.getTimeInMillis() > dataPrevistaEntrega.getTimeInMillis())
                return 1;
            else if(dataAtual.getTimeInMillis() < dataPrevistaEntrega.getTimeInMillis())
                return -1;
            else
                return 0;          
        }       
    };
}
