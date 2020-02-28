package br.inatel.swertsstore.controller;

/*
    *** CLASSE CARRINHO DAO ***

Objetivo: Criar objeto para conectar com o servidor do BANCO DE DADOS, afim de armazenar os dados do carrinho.  

*/ 

import br.inatel.swertsstore.model.Carrinho;
import br.inatel.swertsstore.model.Produto;
import br.inatel.swertsstore.model.Usuario;
import br.inatel.swertsstore.view.TelaAlerta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarrinhoDAO {
    private PreparedStatement pst; // objeto responsável por preparar as consultas DINAMICAS
    private Statement st; // objeto responsável por executar as consultas STATICAS
    private ResultSet rs; // objeto responsável por referencia a tabela resultante da busca
    private Connection con;
   
    private boolean sucesso;

    // Metodo para verificar se um produto ja se encontra no carrinho do usuario
    public boolean verificaProduto(Usuario usuarioOnline, Produto produto, int quantidade) {
        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDb();
        con = connection.getCon(); 
        
        Integer existeNoCarrinho = -1;
        CallableStatement callableStatement = null;

        try {

            callableStatement = con.prepareCall("{CALL verificaProduto(" + produto.getCodigo() + ", '"
                    + usuarioOnline.getEmail() + "', ?)}");

            callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
            callableStatement.execute();

            existeNoCarrinho = callableStatement.getInt(1);

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());

        } finally {
            try {
                con.close();

            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }

        if (existeNoCarrinho == 0) {
            inserirProdutoCarrinho(usuarioOnline, produto, quantidade);
            sucesso = true;
        } else if (existeNoCarrinho == 1) {          
            sucesso = false;
        } else {
            new TelaAlerta("Erro ao inserir produto no carrinho, por favor tente novamente!", 2).setVisible(true);
            sucesso = false;
        }

        return sucesso;
    }

    // Inserir produtos no carrinho do Banco de Dados
    public boolean inserirProdutoCarrinho(Usuario usuarioOnline, Produto produto, int quantidade) {
        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDb();
        con = connection.getCon(); 

        String sql = "INSERT INTO carrinho_has_produto (email_usuario, codigo_produto, quantidade) VALUES (?,?,?)";

        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, usuarioOnline.getEmail());
            pst.setInt(2, produto.getCodigo());
            pst.setInt(3, quantidade);
            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }

        }

        return sucesso;
    }

    // Buscar produtos no carrinho do Banco de Dados
    public Carrinho buscarProdutosNoCarrinho(Usuario usuarioOnline) {
        
        Carrinho carrinho = new Carrinho();

        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDb();
        con = connection.getCon(); 

        String sql = "SELECT produto.*, carrinho_has_produto.quantidade AS quantidadeCarrinho FROM carrinho_has_produto \n"
                + "INNER JOIN produto ON carrinho_has_produto.codigo_produto = produto.codigo "
                + "&& carrinho_has_produto.email_usuario = '" + usuarioOnline.getEmail() + "'";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                //System.out.println(rs.getInt("codigo"));
                Produto produtoTemp = new Produto(rs.getInt("codigo"), rs.getString("tipo"), rs.getFloat("preco"),
                        rs.getString("marca"), rs.getString("modelo"), rs.getString("cor"), rs.getString("titulo"),
                        rs.getInt("quantidade"), rs.getBytes("imagem"), rs.getInt("quantidadeCarrinho"));
               
                carrinho.add(produtoTemp);
            }
            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }

        }
        return carrinho;
    }

    // Atualizar carrinho no Banco de Dados
    public boolean alterarProdutoCarrinho(Usuario usuarioOnline, Produto produto, int quantidade) {
        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDb();
        con = connection.getCon(); 

        String sql = "UPDATE carrinho_has_produto SET quantidade = ? WHERE email_usuario = '" + usuarioOnline.getEmail() + "'"
                + " && codigo_produto = " + produto.getCodigo();

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, quantidade);

            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }

        return sucesso;
    }

    // Deletar produto do carrinho no Banco de Dados
    public boolean deletarProdutoCarrinho(Usuario usuarioOnline, Produto produto) {
        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDb();
        con = connection.getCon(); 

        String sql = "DELETE FROM carrinho_has_produto WHERE email_usuario = '" + usuarioOnline.getEmail()
                + "' && codigo_produto = " + produto.getCodigo();

        try {
            pst = con.prepareStatement(sql);

            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }

        }

        return sucesso;
    }
}
