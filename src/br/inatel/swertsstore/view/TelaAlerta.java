package br.inatel.swertsstore.view;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaAlerta extends javax.swing.JFrame {

    public TelaAlerta(String texto, int tipo) {
        initComponents();

        labelTexto.setText("<html><body><center>" + texto + "<br&gtcom HTML!</center></body></html>");

        if (tipo == 1) {
            successAlert.setVisible(true);
        } else {
            errorAlert.setVisible(true);
        }

        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaAlerta.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose(); // Fecha a Tela Inicial
            }
        }.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelMain = new javax.swing.JPanel();
        successAlert = new javax.swing.JLabel();
        errorAlert = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        labelTexto = new javax.swing.JLabel();
        botaoOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        painelMain.setBackground(new java.awt.Color(255, 255, 255));
        painelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        painelMain.setPreferredSize(new java.awt.Dimension(430, 350));
        painelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        successAlert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sucessAlert.png"))); // NOI18N
        painelMain.add(successAlert, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 100, 100));
        successAlert.setVisible(false);

        errorAlert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/errorAlert.png"))); // NOI18N
        painelMain.add(errorAlert, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 100, 100));
        errorAlert.setVisible(false);

        titulo.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(51, 51, 51));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Swerts Store");
        painelMain.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 143, 408, -1));

        labelTexto.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        labelTexto.setForeground(new java.awt.Color(51, 51, 51));
        labelTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTexto.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        painelMain.add(labelTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 193, 260, 130));

        botaoOk.setBackground(new java.awt.Color(0, 0, 238));
        botaoOk.setFont(new java.awt.Font("Leelawadee UI", 1, 11)); // NOI18N
        botaoOk.setForeground(new java.awt.Color(255, 255, 255));
        botaoOk.setText("OK");
        botaoOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoOkMouseClicked(evt);
            }
        });
        painelMain.add(botaoOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 140, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoOkMouseClicked
        dispose();
    }//GEN-LAST:event_botaoOkMouseClicked

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
            java.util.logging.Logger.getLogger(TelaAlerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlerta("Testando...", 1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoOk;
    private javax.swing.JLabel errorAlert;
    private javax.swing.JLabel labelTexto;
    private javax.swing.JPanel painelMain;
    private javax.swing.JLabel successAlert;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
