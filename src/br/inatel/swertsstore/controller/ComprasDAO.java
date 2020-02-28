package br.inatel.swertsstore.controller;

/*
    *** CLASSE COMPRAS DAO ***

Objetivo: Classe para realizar a conexão com o servidor do BANCO DE DADOS, afim de armazenar os dados das compras.  

*/

import br.inatel.swertsstore.model.Compras;
import br.inatel.swertsstore.model.Produto;
import br.inatel.swertsstore.model.Usuario;
import br.inatel.swertsstore.view.TelaAlerta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

public class ComprasDAO {

    private PreparedStatement pst; // objeto responsável por preparar as consultas DINAMICAS
    private Statement st; // objeto responsável por executar as consultas STATICAS
    private ResultSet rs; // objeto responsável por referencia a tabela resultante da busca
    private Connection con;
   
    private boolean sucesso;

    // Inserir produtos na tabela de Compras
    public boolean inserirProduto(Produto produtoComprado, Usuario usuarioOnline) {
        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDb();
        con = connection.getCon(); 
        
        String sql = "INSERT INTO compras(codigo, tipo, preco, marca, modelo, cor, titulo, quantidade, imagem, data_compra, email_usuario)"
                + " values (?,?,?,?,?,?,?,?,?,?,?)";

        Calendar c = Calendar.getInstance(); // Instanciando a classe calendario para pegar a data atual
        String dia;
        String mes;
        String ano;

        // Pegando o dia, mes e ano da data atual
        if (c.get(Calendar.DAY_OF_MONTH) < 10) {
            dia = "0" + String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        } else {
            dia = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        }
        if (c.get(Calendar.MONTH) < 10) {
            mes = "0" + String.valueOf((c.get(Calendar.MONTH) + 1));
        } else {
            mes = String.valueOf((c.get(Calendar.MONTH) + 1));
        }
        ano = String.valueOf(c.get(Calendar.YEAR));

        String dataAtual = dia + "/" + mes + "/" + ano; // Pegando a data atual

        try {
            pst = con.prepareStatement(sql);

            pst.setInt(1, produtoComprado.getCodigo());
            pst.setString(2, produtoComprado.getTipo());
            pst.setFloat(3, produtoComprado.getPreco());
            pst.setString(4, produtoComprado.getMarca());
            pst.setString(5, produtoComprado.getModelo());
            pst.setString(6, produtoComprado.getCor());
            pst.setString(7, produtoComprado.getTitulo());
            pst.setInt(8, produtoComprado.getQuantidadeCompra());
            pst.setBytes(9, produtoComprado.getImagem());
            pst.setString(10, dataAtual);
            pst.setString(11, usuarioOnline.getEmail());

            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                new TelaAlerta("O sistema retornou um erro insperado, tente novamente mais tarde.", 2).setVisible(true);
            }
        }
        return sucesso;
    }

    // Buscar produtos na tabela de compras sem filtro
    public ArrayList<Compras> buscarProdutosSemFiltro() {
        ArrayList<Compras> listaDeCompras = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDb();
        con = connection.getCon(); 
       
        String sql = "SELECT compras.*, usuario.nome AS nome_usuario FROM compras, usuario "
                + "WHERE usuario.email = compras.email_usuario ORDER BY compras.data_compra DESC";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Compras compraTemp = new Compras(rs.getInt("codigo"), rs.getString("tipo"), rs.getFloat("preco"),
                        rs.getString("marca"), rs.getString("modelo"), rs.getString("cor"), rs.getString("titulo"),
                        rs.getInt("quantidade"), rs.getBytes("imagem"), rs.getString("nome_usuario"), rs.getString("data_compra"));

                listaDeCompras.add(compraTemp);

            }
            sucesso = true;

        } catch (SQLException ex) {
            new TelaAlerta("DOcorreu um erro ao buscar os produtos! Por favor, tentar novamente.", 2).setVisible(true);
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                new TelaAlerta("DOcorreu um erro ao buscar os produtos! Por favor, tentar novamente.", 2).setVisible(true);
            }

        }
        return listaDeCompras;
    }

    // Buscar usuarios no Banco de Dados com Filtro
    public ArrayList<Compras> buscarComprasComFiltro(String emailUsuario) {
        ArrayList<Compras> listaDeCompras = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDb();
        con = connection.getCon(); 
        
        String sql = "SELECT * FROM compras WHERE email_usuario = '" + emailUsuario + "'";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Compras comprasTemp = new Compras(rs.getInt("codigo"), rs.getString("tipo"), rs.getFloat("preco"),
                        rs.getString("marca"), rs.getString("modelo"), rs.getString("cor"), rs.getString("titulo"),
                        rs.getInt("quantidade"), rs.getBytes("imagem"), emailUsuario, rs.getString("data_compra"));

                listaDeCompras.add(comprasTemp);

            }
            sucesso = true;

        } catch (SQLException ex) {
            new TelaAlerta("DOcorreu um erro ao buscar os produtos! Por favor, tentar novamente.", 2).setVisible(true);
            System.out.println("Erro:\n" + ex);
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                new TelaAlerta("DOcorreu um erro ao buscar os produtos! Por favor, tentar novamente.", 2).setVisible(true);
                System.out.println("Erro:\n" + ex);
            }

        }

        return listaDeCompras;
    }

}
