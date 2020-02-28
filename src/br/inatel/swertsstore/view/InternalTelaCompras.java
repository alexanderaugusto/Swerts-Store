package br.inatel.swertsstore.view;

import br.inatel.swertsstore.controller.ComprasDAO;
import br.inatel.swertsstore.model.Compras;

import br.inatel.swertsstore.util.RendererListCompras;
import br.inatel.swertsstore.model.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import static br.inatel.swertsstore.model.Compras.data;
import static br.inatel.swertsstore.model.Compras.descricao;
import static br.inatel.swertsstore.model.Compras.maiorPreco;
import static br.inatel.swertsstore.model.Compras.menorPreco;

public class InternalTelaCompras extends javax.swing.JInternalFrame {

    private Usuario usuarioOnline; // Atributi para guardar o usuario que esta online
    private JList<Compras> listCompras = new JList<>(); // Lista para guardar os produtos e mostrar no painel
    private DefaultListModel<Compras> model = new DefaultListModel<>(); // Lista model para adicionar produtos na lista de produtos 
    private ArrayList<Compras> listaDeCompras = new ArrayList<>();

    JPanel layoutPrincipal;

    public InternalTelaCompras(Usuario usuario) {
        initComponents();
        initComponentsList();

        usuarioOnline = usuario;
        this.layoutPrincipal = layoutPrincipal;

        // Pegando os produtos do carrinho do usuario online
        ComprasDAO comprasDAO = new ComprasDAO();
        listaDeCompras = comprasDAO.buscarComprasComFiltro(usuarioOnline.getEmail());

        // Configurando a listProduto para colocar os produtos dentro
        listCompras.setModel(model);
        listCompras.setCellRenderer(new RendererListCompras());
        listCompras.setBackground(new Color(255, 255, 255));
        PainelListaCompras.add(new JScrollPane(listCompras), BorderLayout.CENTER);
        PainelListaCompras.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Percorrendo a lista de produtos e adicionando no painel da lista
        for (Compras elementoDaLista : listaDeCompras) {
            model.addElement(elementoDaLista);
        }
    }

    private void initComponentsList() {
        listCompras = new javax.swing.JList<>();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelComprasTopo = new javax.swing.JPanel();
        LabelCompras = new javax.swing.JLabel();
        boxSort = new javax.swing.JComboBox<>();
        labelOrdena = new javax.swing.JLabel();
        PainelComprasCabecalho = new javax.swing.JPanel();
        LabelDescricao = new javax.swing.JLabel();
        LabelData = new javax.swing.JLabel();
        PainelListaCompras = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(1346, 600));

        PainelComprasTopo.setBackground(new java.awt.Color(237, 238, 237));
        PainelComprasTopo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 238), 2));

        LabelCompras.setBackground(new java.awt.Color(229, 234, 234));
        LabelCompras.setFont(new java.awt.Font("Leelawadee UI", 0, 36)); // NOI18N
        LabelCompras.setText("Histórico de Compras");

        boxSort.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        boxSort.setForeground(new java.awt.Color(51, 51, 51));
        boxSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data", "Maior Preço", "Menor Preço", "Descrição" }));
        boxSort.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxSortItemStateChanged(evt);
            }
        });

        labelOrdena.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        labelOrdena.setForeground(new java.awt.Color(51, 51, 51));
        labelOrdena.setText("Ordenar por");

        javax.swing.GroupLayout PainelComprasTopoLayout = new javax.swing.GroupLayout(PainelComprasTopo);
        PainelComprasTopo.setLayout(PainelComprasTopoLayout);
        PainelComprasTopoLayout.setHorizontalGroup(
            PainelComprasTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelComprasTopoLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(LabelCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
                .addComponent(labelOrdena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PainelComprasTopoLayout.setVerticalGroup(
            PainelComprasTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelComprasTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelComprasTopoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PainelComprasTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelOrdena, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PainelComprasCabecalho.setBackground(new java.awt.Color(0, 0, 238));
        PainelComprasCabecalho.setBorder(new javax.swing.border.MatteBorder(null));
        PainelComprasCabecalho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PainelComprasCabecalhoMouseClicked(evt);
            }
        });

        LabelDescricao.setBackground(new java.awt.Color(0, 0, 238));
        LabelDescricao.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        LabelDescricao.setForeground(new java.awt.Color(255, 255, 255));
        LabelDescricao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelDescricao.setText("Descrição");
        LabelDescricao.setAutoscrolls(true);

        LabelData.setBackground(new java.awt.Color(0, 0, 238));
        LabelData.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        LabelData.setForeground(new java.awt.Color(255, 255, 255));
        LabelData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelData.setText("Data");
        LabelData.setToolTipText("");
        LabelData.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LabelData.setName(""); // NOI18N
        LabelData.setOpaque(true);

        javax.swing.GroupLayout PainelComprasCabecalhoLayout = new javax.swing.GroupLayout(PainelComprasCabecalho);
        PainelComprasCabecalho.setLayout(PainelComprasCabecalhoLayout);
        PainelComprasCabecalhoLayout.setHorizontalGroup(
            PainelComprasCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelComprasCabecalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PainelComprasCabecalhoLayout.setVerticalGroup(
            PainelComprasCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelComprasCabecalhoLayout.createSequentialGroup()
                .addGroup(PainelComprasCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PainelListaCompras.setBackground(new java.awt.Color(255, 255, 255));
        PainelListaCompras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 238), 2));
        PainelListaCompras.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PainelComprasTopo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PainelComprasCabecalho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PainelListaCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelComprasTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelComprasCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelListaCompras, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PainelComprasCabecalhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PainelComprasCabecalhoMouseClicked

    }//GEN-LAST:event_PainelComprasCabecalhoMouseClicked

    private void boxSortItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxSortItemStateChanged
        if (boxSort.getSelectedIndex() == 0) {
            Collections.sort(listaDeCompras, data);
            model.removeAllElements();
            for (Compras listaDeCompra : listaDeCompras) {
                model.addElement(listaDeCompra);
            }
        } else if (boxSort.getSelectedIndex() == 1) {
            Collections.sort(listaDeCompras, maiorPreco);
            model.removeAllElements();
            for (Compras listaDeCompra : listaDeCompras) {
                model.addElement(listaDeCompra);
            }
        } else if (boxSort.getSelectedIndex() == 2) {
            Collections.sort(listaDeCompras, menorPreco);
            model.removeAllElements();
            for (Compras listaDeCompra : listaDeCompras) {
                model.addElement(listaDeCompra);
            }
        } else if (boxSort.getSelectedIndex() == 3) {
            Collections.sort(listaDeCompras, descricao);
            model.removeAllElements();
            for (Compras listaDeCompra : listaDeCompras) {
                model.addElement(listaDeCompra);
            }
        }
    }//GEN-LAST:event_boxSortItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCompras;
    private javax.swing.JLabel LabelData;
    private javax.swing.JLabel LabelDescricao;
    private javax.swing.JPanel PainelComprasCabecalho;
    private javax.swing.JPanel PainelComprasTopo;
    private javax.swing.JPanel PainelListaCompras;
    private javax.swing.JComboBox<String> boxSort;
    private javax.swing.JLabel labelOrdena;
    // End of variables declaration//GEN-END:variables
}
