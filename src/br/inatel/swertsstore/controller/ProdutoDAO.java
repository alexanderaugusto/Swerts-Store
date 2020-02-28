package br.inatel.swertsstore.controller;

/*
    *** CLASSE PRODUTOS DAO ***

Objetivo: Classe para realizar a conexão com o servidor do BANCO DE DADOS, afim de armazenar os dados dos produtos.  

 */
import br.inatel.swertsstore.model.Produto;
import br.inatel.swertsstore.view.TelaAlerta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// Faz a conexão com o Banco de Dados
public class ProdutoDAO {

    private PreparedStatement pst; // objeto responsável por preparar as consultas DINAMICAS
    private Statement st; // objeto responsável por executar as consultas STATICAS
    private ResultSet rs; // objeto responsável por referencia a tabela resultante da busca
    private Connection con;

    private boolean sucesso;

    // Inserir produtos no Banco de Dados
    public boolean inserirProduto(Produto novoProduto) {
        DatabaseConnection connection = new DatabaseConnection(); 
        connection.connectToDb();
        con = connection.getCon(); 

        String sql = "INSERT INTO produto(codigo, tipo, preco, marca, modelo, cor, titulo, quantidade, imagem) values (?,?,?,?,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);

            pst.setInt(1, novoProduto.getCodigo());
            pst.setString(2, novoProduto.getTipo());
            pst.setFloat(3, novoProduto.getPreco());
            pst.setString(4, novoProduto.getMarca());
            pst.setString(5, novoProduto.getModelo());
            pst.setString(6, novoProduto.getCor());
            pst.setString(7, novoProduto.getTitulo());
            pst.setInt(8, novoProduto.getQuantidade());
            pst.setBytes(9, novoProduto.getImagem());

            pst.execute();

            sucesso = true;
            new TelaAlerta("O produto foi cadastrado com sucesso!", 1).setVisible(true);

        } catch (SQLException ex) {
            new TelaAlerta("Ocorreu um erro ao cadastrar os produtos! Por favor, tentar novamente.", 2).setVisible(true);
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                new TelaAlerta("Ocorreu um erro ao cadastrar os produtos! Por favor, tentar novamente.", 2).setVisible(true);
            }
        }
        return sucesso;
    }

    // Buscar produtos no Banco de Dados
    public ArrayList<Produto> buscarProdutosSemFiltro() {
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDb();
        con = connection.getCon(); 

        String sql = "SELECT * FROM produto";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Produto produtoTemp = new Produto(rs.getInt("codigo"), rs.getString("tipo"), rs.getFloat("preco"),
                        rs.getString("marca"), rs.getString("modelo"), rs.getString("cor"), rs.getString("titulo"),
                        rs.getInt("quantidade"), rs.getBytes("imagem"));

                listaDeProdutos.add(produtoTemp);

            }
            sucesso = true;

        } catch (SQLException ex) {
            new TelaAlerta("Ocorreu um erro ao buscar os produtos! Por favor, tentar novamente.", 2).setVisible(true);
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                new TelaAlerta("Ocorreu um erro ao buscar os produtos! Por favor, tentar novamente.", 2).setVisible(true);
            }

        }
        return listaDeProdutos;
    }

    // Buscar produtos no Banco de Dados com Filtro
    public ArrayList<Produto> buscarProdutosComFiltro(String mensagemBusca) {
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection(); 
        connection.connectToDb();
        con = connection.getCon(); 
        
        String sql = "SELECT * FROM produto";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString("titulo").toLowerCase().contains(mensagemBusca.toLowerCase()) && !"".equals(mensagemBusca)) {
                    Produto produtoTemp = new Produto(rs.getInt("codigo"), rs.getString("tipo"), rs.getFloat("preco"),
                            rs.getString("marca"), rs.getString("modelo"), rs.getString("cor"), rs.getString("titulo"),
                            rs.getInt("quantidade"), rs.getBytes("imagem"));

                    listaDeProdutos.add(produtoTemp);
                }
            }
            sucesso = true;

        } catch (SQLException ex) {
            new TelaAlerta("Ocorreu um erro ao buscar os produtos! Por favor, tentar novamente.", 2).setVisible(true);
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                new TelaAlerta("Ocorreu um erro ao buscar os produtos! Por favor, tentar novamente.", 2).setVisible(true);
            }

        }

        return listaDeProdutos;
    }

    // Metodo para verificar se a quantidade da compra é igual a quantidade de produto existente no banco de dados
    public boolean verificaProduto(Produto produto, int quantidade) {
        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDb();
        con = connection.getCon(); 
        
        CallableStatement callableStatement = null;

        try {
            callableStatement = con.prepareCall("{CALL verificaQuantidadeCompra(" + produto.getCodigo() + "," + quantidade + ")}");

            callableStatement.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;

        } finally {
            try {
                con.close();

            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }

        return sucesso;
    }

}
