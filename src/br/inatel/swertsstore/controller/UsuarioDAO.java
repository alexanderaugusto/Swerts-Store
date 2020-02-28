package br.inatel.swertsstore.controller;

/*
    *** CLASSE USUARIO DAO ***

Objetivo: Classe para realizar a conexão com o servidor do BANCO DE DADOS, afim de armazenar os dados do usuário.  

*/

import br.inatel.swertsstore.model.Usuario;
import br.inatel.swertsstore.view.TelaAlerta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {

    private PreparedStatement pst; // objeto responsável por preparar as consultas DINAMICAS
    private Statement st; // objeto responsável por executar as consultas STATICAS
    private ResultSet rs; // objeto responsável por referencia a tabela resultante da busca
    private Connection con;
   
    private boolean sucesso;

    // Inserir usuarios no Banco de Dados
    public boolean inserirUsuario(Usuario novoUsuario) {
        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDb();
        con = connection.getCon(); 
        
        String sql = "INSERT INTO usuario (nome, sobrenome, cpf, sexo, data_de_nascimento, telefone, email, senha,"
                + "rua, bairro, numero, complemento, cep, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, novoUsuario.getNome());
            pst.setString(2, novoUsuario.getSobrenome());
            pst.setString(3, novoUsuario.getCpf());
            pst.setString(4, novoUsuario.getSexo());
            pst.setString(5, novoUsuario.getDataDeNascimento());
            pst.setString(6, novoUsuario.getTelefone());
            pst.setString(7, novoUsuario.getEmail());
            pst.setString(8, novoUsuario.getSenha());
            pst.setString(9, novoUsuario.getRua());
            pst.setString(10, novoUsuario.getBairro());
            pst.setInt(11, novoUsuario.getNumero());
            pst.setString(12, novoUsuario.getComplemento());
            pst.setString(13, novoUsuario.getCep());
            pst.setString(14, novoUsuario.getCidade());
            pst.setString(15, novoUsuario.getEstado());
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
        
        if(sucesso)
            criarCarrinho(novoUsuario.getEmail());
        
        return sucesso;
    }

    public void criarCarrinho(String email) {
        DatabaseConnection connection = new DatabaseConnection(); 
        connection.connectToDb();
        con = connection.getCon();

        String sql = "INSERT INTO carrinho (email_usuario) values (?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
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
    }

    // Buscar usuarios no Banco de Dados
    public ArrayList<Usuario> buscarUsuariosSemFiltro() {
        ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection(); 
        connection.connectToDb();
        con = connection.getCon();

        String sql = "SELECT * FROM usuario";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de usuarios: ");
            while (rs.next()) {
                Usuario usuarioTemp = new Usuario(rs.getString("nome"), rs.getString("sobrenome"), rs.getString("cpf"), rs.getString("sexo"),
                        rs.getString("data_de_nascimento"), rs.getString("telefone"), rs.getString("email"), rs.getString("senha"),
                        rs.getString("rua"), rs.getString("bairro"), rs.getInt("numero"), rs.getString("complemento"),
                        rs.getString("cep"), rs.getString("cidade"), rs.getString("estado"));

                System.out.println("Nome = " + usuarioTemp.getNome());
                System.out.println("Sobrenome = " + usuarioTemp.getSobrenome());
                System.out.println("Cpf = " + usuarioTemp.getCpf());
                System.out.println("Sexo = " + usuarioTemp.getSexo());
                System.out.println("Data De Nascimento = " + usuarioTemp.getDataDeNascimento());
                System.out.println("Telefone = " + usuarioTemp.getTelefone());
                System.out.println("Email = " + usuarioTemp.getEmail());
                System.out.println("Senha = " + usuarioTemp.getSenha());
                System.out.println("Rua = " + usuarioTemp.getRua());
                System.out.println("Bairro = " + usuarioTemp.getBairro());
                System.out.println("Numero = " + usuarioTemp.getNumero());
                System.out.println("Complemento = " + usuarioTemp.getComplemento());
                System.out.println("Cep = " + usuarioTemp.getCep());
                System.out.println("Cidade = " + usuarioTemp.getCidade());
                System.out.println("Estado = " + usuarioTemp.getEstado());

                System.out.println("---------------------------------");

                listaDeUsuarios.add(usuarioTemp);

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
        return listaDeUsuarios;
    }

    // Buscar usuarios no Banco de Dados pelo email
    public Usuario buscarUsuarioPeloEmail(String emailUsuario) {
        //String senha = null;
        Usuario usuarioOnline = new Usuario();

        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDb();
        con = connection.getCon(); 

        String sql = "SELECT * FROM usuario WHERE email = '" + emailUsuario + "'";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                // Guardando informacoes retornadas do banco na classe usuario
                Usuario usuarioTemporario = new Usuario(rs.getString("nome"), rs.getString("sobrenome"), rs.getString("cpf"),
                        rs.getString("sexo"), rs.getString("data_de_nascimento"), rs.getString("telefone"),
                        rs.getString("email"), rs.getString("senha"), rs.getString("rua"), rs.getString("bairro"),
                        rs.getInt("numero"), rs.getString("complemento"), rs.getString("cep"),
                        rs.getString("cidade"), rs.getString("estado"));
                usuarioOnline = usuarioTemporario; // usuario online recebe as informacoes do banco
                //senha = rs.getString("senha");
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

        return usuarioOnline;
    }

    // Atualizar usuarios no Banco de Dados
    public boolean alterarUsuario(Usuario novoUsuario, String email) {
        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDb();
        con = connection.getCon(); 

        String sql = "UPDATE usuario SET nome = ?, sobrenome = ?, cpf = ?, sexo = ?, data_de_nascimento = ?, telefone = ?, "
                + "email = ?, senha = ?, rua = ?, bairro = ?, numero = ?, complemento = ?, cep = ?, cidade = ?, estado = ? "
                + "WHERE email = ?;";

        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, novoUsuario.getNome());
            pst.setString(2, novoUsuario.getSobrenome());
            pst.setString(3, novoUsuario.getCpf());
            pst.setString(4, novoUsuario.getSexo());
            pst.setString(5, novoUsuario.getDataDeNascimento());
            pst.setString(6, novoUsuario.getTelefone());
            pst.setString(7, novoUsuario.getEmail());
            pst.setString(8, novoUsuario.getSenha());
            pst.setString(9, novoUsuario.getRua());
            pst.setString(10, novoUsuario.getBairro());
            pst.setInt(11, novoUsuario.getNumero());
            pst.setString(12, novoUsuario.getComplemento());
            pst.setString(13, novoUsuario.getCep());
            pst.setString(14, novoUsuario.getCidade());
            pst.setString(15, novoUsuario.getEstado());
            pst.setString(16, email);
            pst.execute();

            sucesso = true;
            new TelaAlerta("Seus dados foram atualizados com sucesso!", 1).setVisible(true);

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
