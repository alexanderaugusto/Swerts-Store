package br.inatel.swertsstore.view;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class CartaoDeCredito extends javax.swing.JFrame {

    JPanel painel = new JPanel();

    public CartaoDeCredito(JPanel painel) {
        initComponents();
        this.painel = painel;
    }

    public boolean verificaDados() {

        if (texotNumeroCartao.getText().equals("                      ")) {
            new TelaAlerta("Por favor, preencha todos os dados de forma válida!", 2).setVisible(true);
            return false;
        } else if (textoNome.getText().length() < 3 || !textoNome.getText().matches("[A-Z a-z Çç]{" + textoNome.getText().length()
                + "}")) {
            new TelaAlerta("Por favor, preencha todos os dados de forma válida!", 2).setVisible(true);
            return false;
        } else if (textoValidade.getText().equals("  /  ")) {
            new TelaAlerta("Por favor, preencha todos os dados de forma válida!", 2).setVisible(true);
            return false;
        } else if (!textoValidade.getText().matches("(0[1-9]|10|11|12)/2[0-9]{1}$")) {
            new TelaAlerta("Por favor, preencha todos os dados de forma válida!", 2).setVisible(true);
            return false;
        } else if (textoCodigoSeguranca.getText().equals("   ")) {
            new TelaAlerta("Por favor, preencha todos os dados de forma válida!", 2).setVisible(true);
            return false;
        } else if (textoCpf.getText().equals("   .   .   -  ")) {
            new TelaAlerta("Por favor, preencha todos os dados de forma válida!", 2).setVisible(true);
            return false;
        } else if (textoCpf.getText().equals("000.000.000-00") || textoCpf.getText().equals("111.111.111-11") || textoCpf.getText().equals("222.222.222.22") || textoCpf.getText().equals("333.333.333-33")
                || textoCpf.getText().equals("444.444.444-44") || textoCpf.getText().equals("555.555.555-55") || textoCpf.getText().equals("666.666.666-66") || textoCpf.getText().equals("777.777.777-77")
                || textoCpf.getText().equals("888.888.888-88") || textoCpf.getText().equals("999.999.999-99")) {
            new TelaAlerta("Por favor, preencha todos os dados de forma válida!", 2).setVisible(true);
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTelaCartao = new javax.swing.JPanel();
        painelDadosCartao = new javax.swing.JPanel();
        labelNumeroCartao = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        textoNome = new javax.swing.JTextField();
        labelDataVencimento = new javax.swing.JLabel();
        labelCpf = new javax.swing.JLabel();
        labelCodigoSeguranca = new javax.swing.JLabel();
        codigoSeguranca = new javax.swing.JLabel();
        numeroCartao = new javax.swing.JLabel();
        nomeSobrenome = new javax.swing.JLabel();
        validade = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        cardImagem = new javax.swing.JLabel();
        texotNumeroCartao = new javax.swing.JFormattedTextField();
        textoCodigoSeguranca = new javax.swing.JFormattedTextField();
        textoValidade = new javax.swing.JFormattedTextField();
        textoCpf = new javax.swing.JFormattedTextField();
        botaoContinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        painelTelaCartao.setBackground(new java.awt.Color(255, 255, 255));

        painelDadosCartao.setBackground(new java.awt.Color(255, 255, 255));
        painelDadosCartao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        painelDadosCartao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNumeroCartao.setText("Número do Cartão:");
        painelDadosCartao.add(labelNumeroCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 28, 280, -1));

        labelNome.setText("Nome e Sobrenome:");
        painelDadosCartao.add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 84, 280, -1));

        textoNome.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoNomeFocusLost(evt);
            }
        });
        textoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoNomeKeyPressed(evt);
            }
        });
        painelDadosCartao.add(textoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 104, 280, 30));

        labelDataVencimento.setText("Data de Vencimento:");
        painelDadosCartao.add(labelDataVencimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 152, 135, -1));

        labelCpf.setText("CPF do titular do cartão:");
        painelDadosCartao.add(labelCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 226, 200, -1));

        labelCodigoSeguranca.setText("Código de Segurança");
        painelDadosCartao.add(labelCodigoSeguranca, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 152, 135, -1));

        codigoSeguranca.setFont(new java.awt.Font("Leelawadee UI", 1, 11)); // NOI18N
        codigoSeguranca.setForeground(new java.awt.Color(102, 102, 102));
        codigoSeguranca.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        codigoSeguranca.setText("COD");
        painelDadosCartao.add(codigoSeguranca, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 80, 20));

        numeroCartao.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        numeroCartao.setForeground(new java.awt.Color(102, 102, 102));
        numeroCartao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroCartao.setText("****  ****  ****   ****");
        painelDadosCartao.add(numeroCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 170, 20));

        nomeSobrenome.setFont(new java.awt.Font("Leelawadee UI", 1, 11)); // NOI18N
        nomeSobrenome.setForeground(new java.awt.Color(102, 102, 102));
        nomeSobrenome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nomeSobrenome.setText("NOME SOBRENOME");
        painelDadosCartao.add(nomeSobrenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 170, 20));

        validade.setFont(new java.awt.Font("Leelawadee UI", 1, 11)); // NOI18N
        validade.setForeground(new java.awt.Color(102, 102, 102));
        validade.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        validade.setText("MM/YY");
        painelDadosCartao.add(validade, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 80, 20));

        tipo.setBackground(new java.awt.Color(204, 204, 204));
        tipo.setOpaque(true);
        painelDadosCartao.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 50, 30));

        cardImagem.setBackground(new java.awt.Color(255, 255, 255));
        cardImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/creditCard.jpg"))); // NOI18N
        painelDadosCartao.add(cardImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 71, -1, -1));

        try {
            texotNumeroCartao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####  ####  ####  ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        texotNumeroCartao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                texotNumeroCartaoFocusLost(evt);
            }
        });
        texotNumeroCartao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                texotNumeroCartaoKeyPressed(evt);
            }
        });
        painelDadosCartao.add(texotNumeroCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 280, 30));
        texotNumeroCartao.setMargin(new java.awt.Insets(2, 10, 2, 2));

        try {
            textoCodigoSeguranca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textoCodigoSeguranca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoCodigoSegurancaFocusLost(evt);
            }
        });
        textoCodigoSeguranca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoCodigoSegurancaKeyPressed(evt);
            }
        });
        painelDadosCartao.add(textoCodigoSeguranca, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 130, 30));
        textoCodigoSeguranca.setMargin(new java.awt.Insets(2, 10, 2, 2));

        try {
            textoValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textoValidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoValidadeFocusLost(evt);
            }
        });
        textoValidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoValidadeKeyPressed(evt);
            }
        });
        painelDadosCartao.add(textoValidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 135, 30));
        textoValidade.setMargin(new java.awt.Insets(2, 10, 2, 2));

        try {
            textoCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        painelDadosCartao.add(textoCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 280, 30));
        textoCpf.setMargin(new java.awt.Insets(2, 10, 2, 2));

        botaoContinuar.setBackground(new java.awt.Color(0, 0, 238));
        botaoContinuar.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        botaoContinuar.setForeground(new java.awt.Color(255, 255, 255));
        botaoContinuar.setText("Continuar");
        botaoContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoContinuarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelTelaCartaoLayout = new javax.swing.GroupLayout(painelTelaCartao);
        painelTelaCartao.setLayout(painelTelaCartaoLayout);
        painelTelaCartaoLayout.setHorizontalGroup(
            painelTelaCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaCartaoLayout.createSequentialGroup()
                .addContainerGap(437, Short.MAX_VALUE)
                .addComponent(botaoContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(painelTelaCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelTelaCartaoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painelDadosCartao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        painelTelaCartaoLayout.setVerticalGroup(
            painelTelaCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTelaCartaoLayout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addComponent(botaoContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(painelTelaCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelTelaCartaoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painelDadosCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(82, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelTelaCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTelaCartao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoContinuarMouseClicked
        if (verificaDados()) {
            new TelaAlerta("Cartao cadastrado com sucesso!", 1).setVisible(true);
            painel.setVisible(true);
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
        }
    }//GEN-LAST:event_botaoContinuarMouseClicked

    private void texotNumeroCartaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texotNumeroCartaoKeyPressed
        numeroCartao.setText(texotNumeroCartao.getText());
    }//GEN-LAST:event_texotNumeroCartaoKeyPressed

    private void textoNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNomeKeyPressed
        nomeSobrenome.setText(textoNome.getText().toUpperCase());
    }//GEN-LAST:event_textoNomeKeyPressed

    private void textoValidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoValidadeKeyPressed
        validade.setText(textoValidade.getText());
    }//GEN-LAST:event_textoValidadeKeyPressed

    private void textoCodigoSegurancaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCodigoSegurancaKeyPressed
        codigoSeguranca.setText(textoCodigoSeguranca.getText());
    }//GEN-LAST:event_textoCodigoSegurancaKeyPressed

    private void texotNumeroCartaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_texotNumeroCartaoFocusLost
        numeroCartao.setText(texotNumeroCartao.getText());
    }//GEN-LAST:event_texotNumeroCartaoFocusLost

    private void textoNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoNomeFocusLost
        nomeSobrenome.setText(textoNome.getText().toUpperCase());
    }//GEN-LAST:event_textoNomeFocusLost

    private void textoValidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoValidadeFocusLost
        validade.setText(textoValidade.getText());
    }//GEN-LAST:event_textoValidadeFocusLost

    private void textoCodigoSegurancaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoCodigoSegurancaFocusLost
        codigoSeguranca.setText(textoCodigoSeguranca.getText());
    }//GEN-LAST:event_textoCodigoSegurancaFocusLost

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
            java.util.logging.Logger.getLogger(CartaoDeCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CartaoDeCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CartaoDeCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CartaoDeCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new CartaoDeCredito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoContinuar;
    private javax.swing.JLabel cardImagem;
    private javax.swing.JLabel codigoSeguranca;
    private javax.swing.JLabel labelCodigoSeguranca;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelDataVencimento;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNumeroCartao;
    private javax.swing.JLabel nomeSobrenome;
    private javax.swing.JLabel numeroCartao;
    private javax.swing.JPanel painelDadosCartao;
    private javax.swing.JPanel painelTelaCartao;
    private javax.swing.JFormattedTextField texotNumeroCartao;
    private javax.swing.JFormattedTextField textoCodigoSeguranca;
    private javax.swing.JFormattedTextField textoCpf;
    private javax.swing.JTextField textoNome;
    private javax.swing.JFormattedTextField textoValidade;
    private javax.swing.JLabel tipo;
    private javax.swing.JLabel validade;
    // End of variables declaration//GEN-END:variables
}
