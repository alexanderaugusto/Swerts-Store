package br.inatel.swertsstore.view;

import br.inatel.swertsstore.controller.UsuarioDAO;
import br.inatel.swertsstore.model.Usuario;
import java.awt.Color;
import java.awt.Cursor;
import static java.lang.Thread.sleep;

public class TelaLogin extends javax.swing.JFrame {

    public int xMouse; // VARIAVEL PARA GUARDAR A POSICAO EM X DA TELA
    public int yMouse; // VARIAVEL PARA GUARDAR A POSICAO EM Y DA TELA

    public TelaLogin() {
        initComponents();

        textoEmail.setFocusable(true);
        textoEmail.grabFocus();
        textoSenha.setFocusable(true);
        textoSenha.grabFocus();

        botaoEntrar.grabFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTelaLogin = new javax.swing.JPanel();
        painelImg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        painelLogin = new javax.swing.JPanel();
        textoSenha = new javax.swing.JPasswordField();
        labelEsqueceuSenha = new javax.swing.JLabel();
        labelExit = new javax.swing.JLabel();
        labelImg = new javax.swing.JLabel();
        labelNaoPossuiConta = new javax.swing.JLabel();
        labelCadastrar = new javax.swing.JLabel();
        textoEmail = new javax.swing.JTextField();
        barraDeProgresso = new javax.swing.JProgressBar();
        botaoEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(810, 475));
        setName("TelaLogin"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        painelTelaLogin.setBackground(new java.awt.Color(255, 255, 255));
        painelTelaLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelTelaLogin.setMinimumSize(new java.awt.Dimension(800, 475));
        painelTelaLogin.setPreferredSize(new java.awt.Dimension(800, 475));

        painelImg.setBackground(new java.awt.Color(0, 0, 238));
        painelImg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                painelImgMouseDragged(evt);
            }
        });
        painelImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                painelImgMousePressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgInicio.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html>\n<center> <p>\nExperimente comprar em uma das lojas mais conceituadas do Brasil! Fazemos de tudo para trazer os melhores produtos para você.\n</p> </center>\n</html>");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("v. 1.0");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logotipoInicio.png"))); // NOI18N

        javax.swing.GroupLayout painelImgLayout = new javax.swing.GroupLayout(painelImg);
        painelImg.setLayout(painelImgLayout);
        painelImgLayout.setHorizontalGroup(
            painelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImgLayout.createSequentialGroup()
                .addGroup(painelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelImgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(painelImgLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(painelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        painelImgLayout.setVerticalGroup(
            painelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelImgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        painelLogin.setBackground(new java.awt.Color(255, 255, 255));
        painelLogin.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                painelLoginMouseDragged(evt);
            }
        });
        painelLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                painelLoginMousePressed(evt);
            }
        });

        textoSenha.setForeground(new java.awt.Color(153, 153, 153));
        textoSenha.setText("Senha");
        textoSenha.setFocusable(false);
        textoSenha.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoSenha.setSelectionColor(new java.awt.Color(0, 250, 154));
        textoSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoSenhaFocusLost(evt);
            }
        });
        textoSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textoSenhaMouseClicked(evt);
            }
        });

        labelEsqueceuSenha.setText("<html>\n<a href = \"#\" > Esqueceu sua senha? </a>\n</html>");
        labelEsqueceuSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelEsqueceuSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEsqueceuSenhaMouseClicked(evt);
            }
        });

        labelExit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelExit.setForeground(new java.awt.Color(0, 0, 238));
        labelExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelExit.setText("x");
        labelExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelExitMouseClicked(evt);
            }
        });

        labelImg.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelImg.setForeground(new java.awt.Color(79, 79, 79));
        labelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logotipo.jpg"))); // NOI18N

        labelNaoPossuiConta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelNaoPossuiConta.setForeground(new java.awt.Color(79, 79, 79));
        labelNaoPossuiConta.setText("Não possui uma conta?");

        labelCadastrar.setText("<html>\n<a href = \"#\"> Cadastrar </a>\n</html>");
        labelCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCadastrarMouseClicked(evt);
            }
        });

        textoEmail.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoEmail.setFocusable(false);
        textoEmail.setForeground(new java.awt.Color(153, 153, 153));
        textoEmail.setText("Email");
        textoEmail.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoEmail.setSelectionColor(new java.awt.Color(0, 250, 154));
        textoEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoEmailFocusLost(evt);
            }
        });
        textoEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textoEmailMouseClicked(evt);
            }
        });

        barraDeProgresso.setVisible(false);
        barraDeProgresso.setBackground(new java.awt.Color(255, 255, 255));
        barraDeProgresso.setFont(new java.awt.Font("Leelawadee UI", 1, 11)); // NOI18N
        barraDeProgresso.setForeground(new java.awt.Color(255, 51, 0));
        barraDeProgresso.setStringPainted(true);

        botaoEntrar.setBackground(new java.awt.Color(0, 0, 238));
        botaoEntrar.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        botaoEntrar.setForeground(new java.awt.Color(255, 255, 255));
        botaoEntrar.setText("Entrar");
        botaoEntrar.setToolTipText("");
        botaoEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoEntrar.setRequestFocusEnabled(false);
        botaoEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoEntrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelLoginLayout = new javax.swing.GroupLayout(painelLogin);
        painelLogin.setLayout(painelLoginLayout);
        painelLoginLayout.setHorizontalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textoEmail)
                    .addComponent(textoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addComponent(labelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barraDeProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelLoginLayout.createSequentialGroup()
                                .addComponent(botaoEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelEsqueceuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelLoginLayout.createSequentialGroup()
                                .addComponent(labelNaoPossuiConta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        painelLoginLayout.setVerticalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNaoPossuiConta)
                    .addComponent(labelCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(textoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEsqueceuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(barraDeProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout painelTelaLoginLayout = new javax.swing.GroupLayout(painelTelaLogin);
        painelTelaLogin.setLayout(painelTelaLoginLayout);
        painelTelaLoginLayout.setHorizontalGroup(
            painelTelaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaLoginLayout.createSequentialGroup()
                .addComponent(painelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelTelaLoginLayout.setVerticalGroup(
            painelTelaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTelaLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTelaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelExitMouseClicked
        System.exit(0); // FECHANDO PROJETO
    }//GEN-LAST:event_labelExitMouseClicked

    private void textoSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoSenhaFocusGained
        if (textoSenha.getText().equals("Senha")) {
            textoSenha.setText("");
            textoSenha.setEchoChar('\u2022');
            textoSenha.setForeground(new Color(79, 79, 79));
        }
    }//GEN-LAST:event_textoSenhaFocusGained

    private void textoSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoSenhaFocusLost
        if (textoSenha.getText().equals("")) {
            textoSenha.setText("Senha");
            textoSenha.setEchoChar('\u0000');
            textoSenha.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoSenhaFocusLost

    private void painelLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelLoginMousePressed

    }//GEN-LAST:event_painelLoginMousePressed

    private void painelLoginMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelLoginMouseDragged

    }//GEN-LAST:event_painelLoginMouseDragged
    // PEGA AS POSICOES X E Y DO PONTEIRO DO MOUSE
    private void painelImgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelImgMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_painelImgMousePressed
    // ARRASTA A TELA PARA ONDE O CURSOR DO MOSUE IR
    private void painelImgMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelImgMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_painelImgMouseDragged

    private void labelCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCadastrarMouseClicked
        new TelaCadastro().setVisible(true);
    }//GEN-LAST:event_labelCadastrarMouseClicked

    private void textoSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoSenhaMouseClicked
        textoSenha.setFocusable(true);
        textoSenha.grabFocus();
    }//GEN-LAST:event_textoSenhaMouseClicked

    private void textoEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoEmailFocusGained
        if (textoEmail.getText().equals("Email")) {
            textoEmail.setText("");
            textoEmail.setForeground(new Color(79, 79, 79));
        }
    }//GEN-LAST:event_textoEmailFocusGained

    private void textoEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoEmailFocusLost
        if (textoEmail.getText().equals("")) {
            textoEmail.setText("Email");
            textoEmail.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoEmailFocusLost

    private void textoEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoEmailMouseClicked
        textoEmail.setFocusable(true);
        textoEmail.grabFocus();
    }//GEN-LAST:event_textoEmailMouseClicked
    boolean clicou; // Variavel auxiliar para verificar se o usuario clicou no botao
    private void botaoEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoEntrarMouseClicked
        botaoEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            if ("admin".equals(textoEmail.getText()) && "admin".equals(textoSenha.getText())) {
                new TelaEstoque().setVisible(true);
                dispose();
            } else {
                UsuarioDAO usuarioDAO = new UsuarioDAO(); // Instanciando a classe usuarioDAO para usar a busca pelo email
                Usuario usuarioOnline = usuarioDAO.buscarUsuarioPeloEmail(textoEmail.getText()); // Buscando usuario pelo email
                // Se a senha retornada pela busca do email for igual a senha que for digitada na caixa de texto, loga no sistema
                if (usuarioOnline.getSenha() == null ? textoSenha.getText() == null : usuarioOnline.getSenha().equals(textoSenha.getText())) {
                    if (!clicou) {
                        clicou = true;
                        barraDeProgresso.setVisible(true);
                        // Isso serve para fazer a barra de progresso carregar de 0 a 100%
                        new Thread() {
                            @Override
                            public void run() {
                                for (int i = 1; i <= 100; i++) {

                                    try {
                                        sleep(10);
                                        barraDeProgresso.setValue(i);
                                    } catch (InterruptedException ex) {
                                        System.out.println("Erro = " + ex);
                                    }
                                }

                                // Depois de carregar a barra de progesso abre a tela principal
                                new TelaPrincipal(usuarioOnline).setVisible(true);
                                dispose(); // Fecha a Tela Inicial
                            }
                        }.start();
                    }
                } else {
                    new TelaAlerta("O email ou a senha estão incorretos!", 2).setVisible(true);
                }
            }
        } catch (Exception ex) {
            new TelaAlerta("Um erro inesperado ocorreu! Por favor, tente novamente mais tarde.", 2).setVisible(true);
        }
        botaoEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botaoEntrarMouseClicked

    private void labelEsqueceuSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEsqueceuSenhaMouseClicked
        TelaRecuperarSenha recuperar = new TelaRecuperarSenha();
        recuperar.setVisible(true);
    }//GEN-LAST:event_labelEsqueceuSenhaMouseClicked

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
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraDeProgresso;
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelCadastrar;
    private javax.swing.JLabel labelEsqueceuSenha;
    private javax.swing.JLabel labelExit;
    private javax.swing.JLabel labelImg;
    private javax.swing.JLabel labelNaoPossuiConta;
    private javax.swing.JPanel painelImg;
    private javax.swing.JPanel painelLogin;
    private javax.swing.JPanel painelTelaLogin;
    private javax.swing.JTextField textoEmail;
    private javax.swing.JPasswordField textoSenha;
    // End of variables declaration//GEN-END:variables

}
