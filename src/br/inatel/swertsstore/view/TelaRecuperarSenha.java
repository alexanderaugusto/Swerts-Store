package br.inatel.swertsstore.view;

import br.inatel.swertsstore.controller.UsuarioDAO;
import br.inatel.swertsstore.model.Usuario;
import br.inatel.swertsstore.util.RecuperarSenha;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

public class TelaRecuperarSenha extends javax.swing.JFrame {

    private boolean validSenha = false;
    private boolean validConfirmaSenha = false;
    private Usuario usuario = new Usuario();
    private RecuperarSenha recupera = new RecuperarSenha();

    public TelaRecuperarSenha() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelMain = new javax.swing.JPanel();
        painelEnviar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botaoEnviar = new javax.swing.JButton();
        textoEmail = new javax.swing.JTextField();
        icon = new javax.swing.JLabel();
        painelAlterar = new javax.swing.JPanel();
        codigo = new javax.swing.JTextField();
        botaoAlterar = new javax.swing.JButton();
        textoSenha = new javax.swing.JPasswordField();
        textoConfirmarSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        painelMain.setBackground(new java.awt.Color(255, 255, 255));
        painelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelEnviar.setBackground(new java.awt.Color(255, 255, 255));
        painelEnviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        jLabel1.setText("Digite seu email:");

        botaoEnviar.setBackground(new java.awt.Color(0, 0, 238));
        botaoEnviar.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        botaoEnviar.setForeground(new java.awt.Color(255, 255, 255));
        botaoEnviar.setText("Enviar");
        botaoEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoEnviarMouseClicked(evt);
            }
        });

        textoEmail.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoEmail.setForeground(new java.awt.Color(153, 153, 153));
        textoEmail.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoEmailFocusLost(evt);
            }
        });

        javax.swing.GroupLayout painelEnviarLayout = new javax.swing.GroupLayout(painelEnviar);
        painelEnviar.setLayout(painelEnviarLayout);
        painelEnviarLayout.setHorizontalGroup(
            painelEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEnviarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelEnviarLayout.setVerticalGroup(
            painelEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEnviarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        painelMain.add(painelEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 400, -1));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/forgotPassword.png"))); // NOI18N
        painelMain.add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        painelAlterar.setBackground(new java.awt.Color(255, 255, 255));
        painelAlterar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelAlterar.setVisible(false);
        painelAlterar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigo.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        codigo.setForeground(new java.awt.Color(153, 153, 153));
        codigo.setText("Código recebido");
        codigo.setMargin(new java.awt.Insets(2, 10, 2, 2));
        codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                codigoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoFocusLost(evt);
            }
        });
        painelAlterar.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 21, 200, 30));

        botaoAlterar.setBackground(new java.awt.Color(0, 0, 238));
        botaoAlterar.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        botaoAlterar.setForeground(new java.awt.Color(255, 255, 255));
        botaoAlterar.setText("Alterar");
        botaoAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoAlterarMouseClicked(evt);
            }
        });
        painelAlterar.add(botaoAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 165, 100, 30));

        textoSenha.setForeground(new java.awt.Color(153, 153, 153));
        textoSenha.setText("Nova senha");
        textoSenha.setEchoChar('\u0000');
        textoSenha.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoSenhaFocusLost(evt);
            }
        });
        painelAlterar.add(textoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 69, 200, 30));

        textoConfirmarSenha.setForeground(new java.awt.Color(153, 153, 153));
        textoConfirmarSenha.setText("Confirmar nova senha");
        textoConfirmarSenha.setEchoChar('\u0000');
        textoConfirmarSenha.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoConfirmarSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoConfirmarSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoConfirmarSenhaFocusLost(evt);
            }
        });
        painelAlterar.add(textoConfirmarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 117, 200, 30));

        painelMain.add(painelAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 174, 400, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void codigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFocusGained
        if (codigo.getText().equals("Código recebido")) {
            codigo.setText("");
            codigo.setForeground(new Color(79, 79, 79));
        }
    }//GEN-LAST:event_codigoFocusGained

    private void codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFocusLost
        if (codigo.getText().equals("")) {
            codigo.setText("Código recebido");
            codigo.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_codigoFocusLost

    private void textoSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoSenhaFocusGained
        if (textoSenha.getText().equals("Nova senha")) {
            textoSenha.setEchoChar('\u2022');
            textoSenha.setText("");
            textoSenha.setForeground(new Color(79, 79, 79));
        }
    }//GEN-LAST:event_textoSenhaFocusGained

    private void textoSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoSenhaFocusLost
        if (textoSenha.getText().length() < 8) {
            textoSenha.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(new Color(255, 255, 255),
                    new Color(255, 0, 0)), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
            validSenha = false;
        } else {
            textoSenha.setForeground(new Color(79, 79, 79));
            textoSenha.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(new Color(255, 255, 255),
                    new Color(153, 153, 153)), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
            validSenha = true;
        }
        if (textoSenha.getText().equals("")) {
            textoSenha.setText("Nova senha");
            textoSenha.setEchoChar('\u0000');
            textoSenha.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoSenhaFocusLost

    private void textoConfirmarSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoConfirmarSenhaFocusGained
        if (textoConfirmarSenha.getText().equals("Confirmar nova senha")) {
            textoConfirmarSenha.setEchoChar('\u2022');
            textoConfirmarSenha.setText("");
            textoConfirmarSenha.setForeground(new Color(79, 79, 79));
        }
    }//GEN-LAST:event_textoConfirmarSenhaFocusGained

    private void textoConfirmarSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoConfirmarSenhaFocusLost
        if (textoConfirmarSenha.getText().equals("")) {
            textoConfirmarSenha.setText("Confirmar nova senha");
            textoConfirmarSenha.setEchoChar('\u0000');
            textoConfirmarSenha.setForeground(new Color(153, 153, 153));
        }

        if (textoConfirmarSenha.getText().equals(textoSenha.getText()) == false) {
            textoConfirmarSenha.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(new Color(255, 255, 255),
                    new Color(255, 0, 0)), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
            validConfirmaSenha = false;
        } else {
            textoConfirmarSenha.setForeground(new Color(79, 79, 79));
            textoConfirmarSenha.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(new Color(255, 255, 255),
                    new Color(153, 153, 153)), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
            validConfirmaSenha = true;
        }
    }//GEN-LAST:event_textoConfirmarSenhaFocusLost

    private void botaoEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoEnviarMouseClicked
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuario = usuarioDAO.buscarUsuarioPeloEmail(textoEmail.getText());

        if (usuario.getEmail() != null) {
            recupera.setEmail(textoEmail.getText());
            recupera.setUsuario(usuario);
            recupera.start();

            new TelaAlerta("Olá, " + usuario.getNome() + "! Em breve você receberá um email contendo o código para recuperar "
                    + "sua senha.", 1).setVisible(true);
            painelAlterar.setVisible(true);
            icon.setVisible(false);
        } else {
            new TelaAlerta("Desculpa! Este email não está cadastrado no sistema.", 2).setVisible(true);
        }
    }//GEN-LAST:event_botaoEnviarMouseClicked

    private void botaoAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAlterarMouseClicked

        if (validSenha && validConfirmaSenha && recupera.getCodigo().equals(codigo.getText())) {
            usuario.setSenha(textoSenha.getText());
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.alterarUsuario(usuario, recupera.getEmail());
            new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TelaAlerta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose();
                }
            }.start();
        } else {
            new TelaAlerta("Desculpa! O código inserido ou a nova senha esão incorretos.", 2).setVisible(true);
        }
    }//GEN-LAST:event_botaoAlterarMouseClicked

    private void textoEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoEmailFocusGained
        textoEmail.setForeground(new Color(79, 79, 79));
    }//GEN-LAST:event_textoEmailFocusGained

    private void textoEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoEmailFocusLost
        textoEmail.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_textoEmailFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRecuperarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRecuperarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRecuperarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRecuperarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRecuperarSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoEnviar;
    private javax.swing.JTextField codigo;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel painelAlterar;
    private javax.swing.JPanel painelEnviar;
    private javax.swing.JPanel painelMain;
    private javax.swing.JPasswordField textoConfirmarSenha;
    private javax.swing.JTextField textoEmail;
    private javax.swing.JPasswordField textoSenha;
    // End of variables declaration//GEN-END:variables
}
