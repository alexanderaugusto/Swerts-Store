package br.inatel.swertsstore.view;

import br.inatel.swertsstore.controller.ProdutoDAO;
import br.inatel.swertsstore.model.Produto;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TelaInserirProduto extends javax.swing.JFrame {

    //FileInputStream imagem;
    BufferedImage imagemBuffer = null;
    ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
    byte[] byteArray;

    public TelaInserirProduto() {
        initComponents();
    }

    public boolean verificaDados() {
        if (textoCodigo.getText().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
            new TelaAlerta("Por favor, preencha todos os campos de forma válida!", 2).setVisible(true);
            return false;
        } else if (textoMarca.getText().isEmpty()) {
            new TelaAlerta("Por favor, preencha todos os campos de forma válida!", 2).setVisible(true);
            return false;
        } else if (textoTipo.getText().isEmpty()) {
            new TelaAlerta("Por favor, preencha todos os campos de forma válida!", 2).setVisible(true);
            return false;
        } else if (textoModelo.getText().isEmpty()) {
            new TelaAlerta("Por favor, preencha todos os campos de forma válida!", 2).setVisible(true);
            return false;
        } else if (textoPreco.getText().isEmpty() || textoPreco.getText().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
            new TelaAlerta("Por favor, preencha todos os campos de forma válida!", 2).setVisible(true);
            return false;
        } else if (textoCor.getText().isEmpty()) {
            new TelaAlerta("Por favor, preencha todos os campos de forma válida!", 2).setVisible(true);
            return false;
        } else if (textoTitulo.getText().isEmpty()) {
            new TelaAlerta("Por favor, preencha todos os campos de forma válida!", 2).setVisible(true);
            return false;
        } else if (textoQuantidade.getText().isEmpty()) {
            new TelaAlerta("Por favor, preencha todos os campos de forma válida!", 2).setVisible(true);
            return false;
        }

        try {
            ImageIO.write(imagemBuffer, "jpg", bytesImg);
            bytesImg.flush();
            byteArray = bytesImg.toByteArray();
            bytesImg.close();
        } catch (IOException ex1) {
            new TelaAlerta("Desculpa! Ocorreu um erro ao carregar as imagens!", 2).setVisible(true);
            return false;
        } catch (IllegalArgumentException ex2) {
            new TelaAlerta("A imagem do produto é obrigatória!", 2).setVisible(true);

            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelTelaCadastroProduto = new javax.swing.JPanel();
        textoCodigo = new javax.swing.JTextField();
        labelCodigo = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        textoTipo = new javax.swing.JTextField();
        labelPreco = new javax.swing.JLabel();
        textoPreco = new javax.swing.JTextField();
        labelMarca = new javax.swing.JLabel();
        textoMarca = new javax.swing.JTextField();
        labelModelo = new javax.swing.JLabel();
        textoModelo = new javax.swing.JTextField();
        labelCor = new javax.swing.JLabel();
        textoCor = new javax.swing.JTextField();
        textoQuantidade = new javax.swing.JTextField();
        labelTitulo = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JLabel();
        imagemSelector = new javax.swing.JLabel();
        imagemSelecionada = new javax.swing.JLabel();
        labelTitulo1 = new javax.swing.JLabel();
        textoTitulo = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelTelaCadastroProduto.setBackground(new java.awt.Color(255, 255, 255));
        panelTelaCadastroProduto.setPreferredSize(new java.awt.Dimension(545, 800));

        textoCodigo.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoCodigo.setForeground(new java.awt.Color(153, 153, 153));
        textoCodigo.setMargin(new java.awt.Insets(2, 10, 2, 2));

        labelCodigo.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelCodigo.setText("Código:");

        labelTipo.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelTipo.setText("Tipo:");

        textoTipo.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoTipo.setForeground(new java.awt.Color(153, 153, 153));
        textoTipo.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoTipoFocusLost(evt);
            }
        });

        labelPreco.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelPreco.setText("Preço:");

        textoPreco.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoPreco.setForeground(new java.awt.Color(153, 153, 153));
        textoPreco.setMargin(new java.awt.Insets(2, 10, 2, 2));

        labelMarca.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelMarca.setText("Marca:");

        textoMarca.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoMarca.setForeground(new java.awt.Color(153, 153, 153));
        textoMarca.setMargin(new java.awt.Insets(2, 10, 2, 2));

        labelModelo.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelModelo.setText("Modelo:");

        textoModelo.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoModelo.setForeground(new java.awt.Color(153, 153, 153));
        textoModelo.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoModelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoModeloFocusGained(evt);
            }
        });

        labelCor.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelCor.setText("Cor:");

        textoCor.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoCor.setForeground(new java.awt.Color(153, 153, 153));
        textoCor.setMargin(new java.awt.Insets(2, 10, 2, 2));

        textoQuantidade.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoQuantidade.setForeground(new java.awt.Color(153, 153, 153));
        textoQuantidade.setMargin(new java.awt.Insets(2, 10, 2, 2));

        labelTitulo.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelTitulo.setText("Descrição:");

        botaoCadastrar.setBackground(new java.awt.Color(0, 0, 238));
        botaoCadastrar.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        botaoCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        botaoCadastrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.setOpaque(true);
        botaoCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoCadastrarMouseClicked(evt);
            }
        });

        imagemSelector.setBackground(new java.awt.Color(0, 255, 153));
        imagemSelector.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        imagemSelector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addImage.png"))); // NOI18N
        imagemSelector.setText("Adicionar Imagem");
        imagemSelector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagemSelectorMouseClicked(evt);
            }
        });

        labelTitulo1.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelTitulo1.setText("Quantidade:");

        textoTitulo.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoTitulo.setForeground(new java.awt.Color(153, 153, 153));
        textoTitulo.setMargin(new java.awt.Insets(2, 10, 2, 2));

        javax.swing.GroupLayout panelTelaCadastroProdutoLayout = new javax.swing.GroupLayout(panelTelaCadastroProduto);
        panelTelaCadastroProduto.setLayout(panelTelaCadastroProdutoLayout);
        panelTelaCadastroProdutoLayout.setHorizontalGroup(
            panelTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTelaCadastroProdutoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitulo)
                    .addGroup(panelTelaCadastroProdutoLayout.createSequentialGroup()
                        .addGroup(panelTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPreco)
                            .addComponent(textoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTipo)
                            .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCodigo)
                            .addComponent(textoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTitulo1)
                            .addComponent(textoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(panelTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCor)
                            .addComponent(textoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelModelo)
                            .addComponent(textoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMarca)
                            .addComponent(imagemSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imagemSelecionada, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTelaCadastroProdutoLayout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        panelTelaCadastroProdutoLayout.setVerticalGroup(
            panelTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTelaCadastroProdutoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelTelaCadastroProdutoLayout.createSequentialGroup()
                        .addComponent(labelMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelCor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTelaCadastroProdutoLayout.createSequentialGroup()
                        .addComponent(labelCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelPreco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imagemSelector)
                    .addComponent(textoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagemSelecionada, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTelaCadastroProdutoLayout.createSequentialGroup()
                        .addComponent(labelTitulo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTelaCadastroProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTelaCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textoModeloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoModeloFocusGained

    }//GEN-LAST:event_textoModeloFocusGained

    private void imagemSelectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagemSelectorMouseClicked

        try {
            JFileChooser busca_foto = new JFileChooser();
            busca_foto.setFileFilter(new FileNameExtensionFilter("Imagem", "bmp", "png", "jpg", "jpeg"));
            busca_foto.setAcceptAllFileFilterUsed(false);
            busca_foto.setDialogTitle("Selecionar imagem");
            busca_foto.showOpenDialog(this);

            String caminho = "" + busca_foto.getSelectedFile().getAbsolutePath();

            imagemBuffer = ImageIO.read(new File(caminho));

            Image diminuirImagem = imagemBuffer.getScaledInstance(200, 140, 0);
            imagemSelecionada.setIcon(new ImageIcon(diminuirImagem));
        } catch (IOException ex) {
            System.out.println("Erro = " + ex);
        } catch (NullPointerException ex1) {
            System.out.println("Erro = " + ex1);
        }

    }//GEN-LAST:event_imagemSelectorMouseClicked

    private void textoTipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoTipoFocusLost

    }//GEN-LAST:event_textoTipoFocusLost

    private void botaoCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCadastrarMouseClicked
        botaoCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        if (verificaDados()) {
            textoPreco.setText(textoPreco.getText().replace(",", "."));
            try {
                // Pegando a quantidade de produto
                String quantidade = textoQuantidade.getText();
                int quantidadeInt = Integer.parseInt(quantidade.replaceAll("[^0-9]", ""));

                Produto novoProduto = new Produto(Integer.parseInt(textoCodigo.getText()), textoTipo.getText(), Float.parseFloat(textoPreco.getText()),
                        textoMarca.getText(), textoModelo.getText(), textoCor.getText(), textoTitulo.getText(), quantidadeInt, byteArray);

                ProdutoDAO dao = new ProdutoDAO();
                boolean deuCerto = dao.inserirProduto(novoProduto);

                if (deuCerto == true) {
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
            } catch (Exception e) {
                new TelaAlerta("Por favor, preencha todos os campos de forma válida!", 2).setVisible(true);
            }

        }
        botaoCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botaoCadastrarMouseClicked

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
            java.util.logging.Logger.getLogger(TelaInserirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInserirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInserirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInserirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInserirProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botaoCadastrar;
    private javax.swing.JLabel imagemSelecionada;
    private javax.swing.JLabel imagemSelector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelCor;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelModelo;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTitulo1;
    private javax.swing.JPanel panelTelaCadastroProduto;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoCor;
    private javax.swing.JTextField textoMarca;
    private javax.swing.JTextField textoModelo;
    private javax.swing.JTextField textoPreco;
    private javax.swing.JTextField textoQuantidade;
    private javax.swing.JTextField textoTipo;
    private javax.swing.JTextField textoTitulo;
    // End of variables declaration//GEN-END:variables
}
