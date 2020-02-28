package br.inatel.swertsstore.view;

import br.inatel.swertsstore.controller.ComprasDAO;
import br.inatel.swertsstore.model.Compras;
import br.inatel.swertsstore.util.ProdutoTableModel;
import java.util.ArrayList;

public class TelaEstoque extends javax.swing.JFrame {

    private ProdutoTableModel tableModel = new ProdutoTableModel(); // Criando um novo modelo de tabelas de produtos
    //Lista de Compras para mostrar produtos vendidos na loja. 
    private ArrayList <Compras> listaDeCompras = new ArrayList<>();
    
    public TelaEstoque() {
        initComponents();
        
        tabelaProdutos.setModel(tableModel); // Setando o modelo da tabela
        //Acessando a lista de produtos do Banco de Dados 
        ComprasDAO comprasDAO = new ComprasDAO();
        listaDeCompras = comprasDAO.buscarProdutosSemFiltro();
        
        float precoTotal = 0;
        //Percorrendo a lista para calcular total
        for (Compras listaDeCompra : listaDeCompras) {
            tableModel.addRow(listaDeCompra);
            precoTotal = precoTotal + (listaDeCompra.getPreco() * listaDeCompra.getQuantidade());          
        }
        
        labelTotal.setText("R$ " + precoTotal);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelEstoque = new javax.swing.JPanel();
        painelTabela = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        labelTotalVendas = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        botaoCadastrarProdutos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 580));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        painelEstoque.setBackground(new java.awt.Color(255, 255, 255));
        painelEstoque.setPreferredSize(new java.awt.Dimension(900, 580));

        tabelaProdutos.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null, null}
            },
            new String [] {
                "Código", "Produto", "Quantidade", "Preço", "Cliente", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaProdutos.setEnabled(false);
        tabelaProdutos.setRowHeight(40);
        tabelaProdutos.getTableHeader().setResizingAllowed(false);
        tabelaProdutos.getTableHeader().setReorderingAllowed(false);
        painelTabela.setViewportView(tabelaProdutos);

        labelTotalVendas.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        labelTotalVendas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalVendas.setText("Total das Vendas:");

        labelTotal.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        labelTotal.setText("R$ 00,00");

        botaoCadastrarProdutos.setBackground(new java.awt.Color(0, 0, 238));
        botaoCadastrarProdutos.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        botaoCadastrarProdutos.setForeground(new java.awt.Color(255, 255, 255));
        botaoCadastrarProdutos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botaoCadastrarProdutos.setText("Cadastrar Produtos");
        botaoCadastrarProdutos.setOpaque(true);
        botaoCadastrarProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoCadastrarProdutosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelEstoqueLayout = new javax.swing.GroupLayout(painelEstoque);
        painelEstoque.setLayout(painelEstoqueLayout);
        painelEstoqueLayout.setHorizontalGroup(
            painelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEstoqueLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(painelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelEstoqueLayout.createSequentialGroup()
                        .addComponent(botaoCadastrarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTotalVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotal))
                    .addComponent(painelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        painelEstoqueLayout.setVerticalGroup(
            painelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEstoqueLayout.createSequentialGroup()
                        .addGroup(painelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTotalVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(282, 282, 282))
                    .addGroup(painelEstoqueLayout.createSequentialGroup()
                        .addComponent(botaoCadastrarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCadastrarProdutosMouseClicked
        TelaInserirProduto telaInserir = new TelaInserirProduto();
        telaInserir.setVisible(true);
    }//GEN-LAST:event_botaoCadastrarProdutosMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        dispose();
        new TelaLogin().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botaoCadastrarProdutos;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTotalVendas;
    private javax.swing.JPanel painelEstoque;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JTable tabelaProdutos;
    // End of variables declaration//GEN-END:variables
}
