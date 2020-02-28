package br.inatel.swertsstore.util;

import br.inatel.swertsstore.controller.UsuarioDAO;
import br.inatel.swertsstore.model.Usuario;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RecuperarSenha extends Thread {

    private String codigo = null;
    private String email;
    private Usuario usuario = new Usuario();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public void run() {
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("swerts.store@gmail.com", "store1010java");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        //session.setDebug(true);
        
        // Gerando sequencia de caracteres aleatorios
        String sequencia; //String a ser impressa
        StringBuffer sb = new StringBuffer(); //StringBuffer para o append
        int qtdChars = 1; //Qtd de chars na String
        while (qtdChars <= 10) { //String tem que ter 16 chars

            int charInt = (int) (Math.random() * 71); //Random para  gerar um número aleatório até 70
            //70, porque na tabela ASCII o maior caracter que será necessário é o de nro 70 (F)

            if (((charInt >= 48) && (charInt <= 57)) || ((charInt >= 65) && (charInt <= 70))) {
                //Chars de 48 a 57 são os números
                //Chars de 65 a 70 são: A, B, C, D, F
                char c = (char) charInt; //Gerando um caracter de acordo com o ASCII gerado pelo random		
                sb.append(c); //Adiciona o char gerado no StringBuffer

                qtdChars++; //Incremente nro de chars no String
            }
        }

        sequencia = sb.toString(); //String recebe o StringBuffer que tem a sentença de 16 bytes nesse momento		

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("swerts.store@gmail.com"));
            //Remetente

            Address[] toUser = InternetAddress.parse(email);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Swerts Store - Recuperação de senha");//Assunto
            message.setText("Olá, " + usuario.getNome() + " " + usuario.getSobrenome() + "\n\nSegue abaixo o código para recuperar sua senha, "
                    + "basta digita-lo na caixa de texto na aplicação e escolher uma nova senha. \n\n                                   " 
                    + sequencia + "\n\nobrigada, \n"
                    + "Equipe da Swerts Store.");
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);
            /*
            usuario.setSenha(sequencia);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.recuperarSenha(usuario, email);
            */
            this.codigo = sequencia;

        } catch (MessagingException e1) {
            throw new RuntimeException(e1);
        } catch (NullPointerException e2) {
            System.out.println(e2);
        }
    }

}
