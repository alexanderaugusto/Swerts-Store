package br.inatel.swertsstore.view;

import br.inatel.swertsstore.controller.CarrinhoDAO;
import br.inatel.swertsstore.controller.ComprasDAO;
import br.inatel.swertsstore.controller.ProdutoDAO;
import br.inatel.swertsstore.util.FinalizarCompra;
import br.inatel.swertsstore.model.Produto;
import br.inatel.swertsstore.model.Usuario;
import java.awt.Cursor;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class TelaComprar extends javax.swing.JFrame {

    // Objetos auxiliares para usar nesta classe
    public ArrayList<Produto> listaDeProdutos = new ArrayList<>();
    public Usuario usuarioOnline;
    public FinalizarCompra compraFinal;

    public TelaComprar(ArrayList produtos, Usuario usuario, FinalizarCompra compraFinal) {
        listaDeProdutos = produtos;
        usuarioOnline = usuario;
        this.compraFinal = compraFinal;

        initComponents();
        configPainel();
    }

    private void configPainel() {
        textRua.setText(usuarioOnline.getRua() + " " + usuarioOnline.getNumero());
        textEndereco.setText(usuarioOnline.getCidade() + ", " + usuarioOnline.getEstado() + " - " + usuarioOnline.getCep());

        textTempoEnvio.setText("Levará " + compraFinal.getPrazoEnvio() + " dia(s) para chegar sua encomenda");
        textTipoEnvio.setText(compraFinal.getTipoEnvio());

        textUsuario.setText(usuarioOnline.getNome() + " " + usuarioOnline.getSobrenome() + " - " + usuarioOnline.getCpf());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        painelScrollCompra = new javax.swing.JScrollPane();
        painelCompra = new javax.swing.JPanel();
        painelTipoPagamento = new javax.swing.JPanel();
        painelBoleto = new javax.swing.JPanel();
        iconBoleto = new javax.swing.JLabel();
        textBoleto = new javax.swing.JLabel();
        labelTipoPagamento = new javax.swing.JLabel();
        painelCard = new javax.swing.JPanel();
        iconCard = new javax.swing.JLabel();
        textCard = new javax.swing.JLabel();
        textCard2 = new javax.swing.JLabel();
        painelDetalhes = new javax.swing.JPanel();
        painelNota = new javax.swing.JPanel();
        iconNota = new javax.swing.JLabel();
        textUsuario = new javax.swing.JLabel();
        textNota = new javax.swing.JLabel();
        painelPagamento = new javax.swing.JPanel();
        iconTipoPagamento = new javax.swing.JLabel();
        textTipoPagamento = new javax.swing.JLabel();
        textPrecoPagamento = new javax.swing.JLabel();
        painelCidadeEnvio = new javax.swing.JPanel();
        iconLocal = new javax.swing.JLabel();
        textRua = new javax.swing.JLabel();
        textEndereco = new javax.swing.JLabel();
        painelFrete = new javax.swing.JPanel();
        iconCaminhao = new javax.swing.JLabel();
        textTempoEnvio = new javax.swing.JLabel();
        textTipoEnvio = new javax.swing.JLabel();
        labelDetalhesPagamento = new javax.swing.JLabel();
        labelDetalhesEnvio = new javax.swing.JLabel();
        botaoFinalizarCompra = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        painelScrollCompra.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        painelCompra.setBackground(new java.awt.Color(255, 255, 255));
        painelCompra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelTipoPagamento.setBackground(new java.awt.Color(255, 255, 255));

        painelBoleto.setBackground(new java.awt.Color(255, 255, 255));
        painelBoleto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        painelBoleto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        painelBoleto.setPreferredSize(new java.awt.Dimension(232, 75));
        painelBoleto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelBoletoMouseClicked(evt);
            }
        });

        iconBoleto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boleto.png"))); // NOI18N

        textBoleto.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        textBoleto.setText("Boleto Bancário");

        javax.swing.GroupLayout painelBoletoLayout = new javax.swing.GroupLayout(painelBoleto);
        painelBoleto.setLayout(painelBoletoLayout);
        painelBoletoLayout.setHorizontalGroup(
            painelBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBoletoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(textBoleto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelBoletoLayout.setVerticalGroup(
            painelBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBoletoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textBoleto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconBoleto, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addContainerGap())
        );

        labelTipoPagamento.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        labelTipoPagamento.setText("Escolha o tipo de pagamento:");

        painelCard.setBackground(new java.awt.Color(255, 255, 255));
        painelCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        painelCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        painelCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelCardMouseClicked(evt);
            }
        });

        iconCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card.png"))); // NOI18N

        textCard.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        textCard.setText("Cartão de Crédito");
        textCard.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        textCard2.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        textCard2.setForeground(new java.awt.Color(51, 255, 51));
        textCard2.setText("Em até 12x sem juros");
        textCard2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout painelCardLayout = new javax.swing.GroupLayout(painelCard);
        painelCard.setLayout(painelCardLayout);
        painelCardLayout.setHorizontalGroup(
            painelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconCard, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(painelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textCard2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelCardLayout.setVerticalGroup(
            painelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCardLayout.createSequentialGroup()
                        .addComponent(textCard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCard2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelCardLayout.createSequentialGroup()
                        .addComponent(iconCard, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout painelTipoPagamentoLayout = new javax.swing.GroupLayout(painelTipoPagamento);
        painelTipoPagamento.setLayout(painelTipoPagamentoLayout);
        painelTipoPagamentoLayout.setHorizontalGroup(
            painelTipoPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTipoPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelTipoPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelCard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelBoleto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addComponent(labelTipoPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelTipoPagamentoLayout.setVerticalGroup(
            painelTipoPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTipoPagamentoLayout.createSequentialGroup()
                .addComponent(labelTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        painelCompra.add(painelTipoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 660, 220));

        painelDetalhes.setBackground(new java.awt.Color(255, 255, 255));
        painelDetalhes.setVisible(false);

        painelNota.setBackground(new java.awt.Color(255, 255, 255));
        painelNota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        painelNota.setPreferredSize(new java.awt.Dimension(633, 87));

        iconNota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nota.png"))); // NOI18N

        textUsuario.setFont(new java.awt.Font("Leelawadee UI", 0, 13)); // NOI18N
        textUsuario.setForeground(new java.awt.Color(102, 102, 102));
        textUsuario.setText("jLabel3");

        textNota.setFont(new java.awt.Font("Leelawadee UI", 0, 13)); // NOI18N
        textNota.setText("Dados da nota fiscal");

        javax.swing.GroupLayout painelNotaLayout = new javax.swing.GroupLayout(painelNota);
        painelNota.setLayout(painelNotaLayout);
        painelNotaLayout.setHorizontalGroup(
            painelNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconNota, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(painelNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNota, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addComponent(textUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelNotaLayout.setVerticalGroup(
            painelNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconNota, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNotaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textNota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textUsuario)
                .addGap(24, 24, 24))
        );

        painelPagamento.setBackground(new java.awt.Color(255, 255, 255));
        painelPagamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        iconTipoPagamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconTipoPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card.png"))); // NOI18N

        textTipoPagamento.setFont(new java.awt.Font("Leelawadee UI", 0, 13)); // NOI18N
        textTipoPagamento.setText("jLabel3");

        textPrecoPagamento.setFont(new java.awt.Font("Leelawadee UI", 0, 13)); // NOI18N
        textPrecoPagamento.setForeground(new java.awt.Color(102, 102, 102));
        textPrecoPagamento.setText("jLabel3");

        javax.swing.GroupLayout painelPagamentoLayout = new javax.swing.GroupLayout(painelPagamento);
        painelPagamento.setLayout(painelPagamentoLayout);
        painelPagamentoLayout.setHorizontalGroup(
            painelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(painelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textTipoPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textPrecoPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelPagamentoLayout.setVerticalGroup(
            painelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconTipoPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPagamentoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textTipoPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPrecoPagamento)
                .addGap(25, 25, 25))
        );

        painelCidadeEnvio.setBackground(new java.awt.Color(255, 255, 255));
        painelCidadeEnvio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        iconLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/local.png"))); // NOI18N

        textRua.setFont(new java.awt.Font("Leelawadee UI", 0, 13)); // NOI18N
        textRua.setText("jLabel3");

        textEndereco.setFont(new java.awt.Font("Leelawadee UI", 0, 13)); // NOI18N
        textEndereco.setForeground(new java.awt.Color(102, 102, 102));
        textEndereco.setText("jLabel3");

        javax.swing.GroupLayout painelCidadeEnvioLayout = new javax.swing.GroupLayout(painelCidadeEnvio);
        painelCidadeEnvio.setLayout(painelCidadeEnvioLayout);
        painelCidadeEnvioLayout.setHorizontalGroup(
            painelCidadeEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCidadeEnvioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(painelCidadeEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textRua, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                    .addComponent(textEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelCidadeEnvioLayout.setVerticalGroup(
            painelCidadeEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCidadeEnvioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCidadeEnvioLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(textRua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textEndereco)
                .addGap(25, 25, 25))
        );

        painelFrete.setBackground(new java.awt.Color(255, 255, 255));
        painelFrete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        iconCaminhao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconCaminhao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caminhao.png"))); // NOI18N

        textTempoEnvio.setFont(new java.awt.Font("Leelawadee UI", 0, 13)); // NOI18N
        textTempoEnvio.setText("jLabel3");

        textTipoEnvio.setFont(new java.awt.Font("Leelawadee UI", 0, 13)); // NOI18N
        textTipoEnvio.setForeground(new java.awt.Color(102, 102, 102));
        textTipoEnvio.setText("jLabel3");

        javax.swing.GroupLayout painelFreteLayout = new javax.swing.GroupLayout(painelFrete);
        painelFrete.setLayout(painelFreteLayout);
        painelFreteLayout.setHorizontalGroup(
            painelFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFreteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconCaminhao, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(painelFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textTempoEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addComponent(textTipoEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelFreteLayout.setVerticalGroup(
            painelFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFreteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconCaminhao, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(painelFreteLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(textTempoEnvio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTipoEnvio)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        labelDetalhesPagamento.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
        labelDetalhesPagamento.setText("Detalhes do Pagamento:");

        labelDetalhesEnvio.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
        labelDetalhesEnvio.setText("Detalhes do Envio:");

        botaoFinalizarCompra.setBackground(new java.awt.Color(0, 0, 238));
        botaoFinalizarCompra.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        botaoFinalizarCompra.setForeground(new java.awt.Color(255, 255, 255));
        botaoFinalizarCompra.setText("Confirmar Compra");
        botaoFinalizarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoFinalizarCompraMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelDetalhesLayout = new javax.swing.GroupLayout(painelDetalhes);
        painelDetalhes.setLayout(painelDetalhesLayout);
        painelDetalhesLayout.setHorizontalGroup(
            painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDetalhesLayout.createSequentialGroup()
                        .addGap(0, 248, Short.MAX_VALUE)
                        .addComponent(botaoFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212))
                    .addGroup(painelDetalhesLayout.createSequentialGroup()
                        .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(painelPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(painelNota, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE))
                            .addComponent(labelDetalhesEnvio)
                            .addComponent(labelDetalhesPagamento))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelDetalhesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painelCidadeEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
            .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelDetalhesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painelFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        painelDetalhesLayout.setVerticalGroup(
            painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDetalhesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelDetalhesEnvio)
                .addGap(223, 223, 223)
                .addComponent(labelDetalhesPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(botaoFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelDetalhesLayout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(painelCidadeEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(522, Short.MAX_VALUE)))
            .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelDetalhesLayout.createSequentialGroup()
                    .addGap(138, 138, 138)
                    .addComponent(painelFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(430, Short.MAX_VALUE)))
        );

        painelCompra.add(painelDetalhes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 226, -1, -1));

        painelScrollCompra.setViewportView(painelCompra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelScrollCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelScrollCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void painelCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelCardMouseClicked

        CartaoDeCredito card = new CartaoDeCredito(painelDetalhes);
        card.setVisible(true);

        iconTipoPagamento.setIcon(new ImageIcon("src\\img\\card.png"));
        textTipoPagamento.setText("Cartão de Crédito");
        textPrecoPagamento.setText("Você pagará " + compraFinal.getPrecoTotal());
    }//GEN-LAST:event_painelCardMouseClicked

    private void painelBoletoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelBoletoMouseClicked
        iconTipoPagamento.setIcon(new ImageIcon("src\\img\\boleto.png"));
        textTipoPagamento.setText("Boleto");
        textPrecoPagamento.setText("Você pagará " + compraFinal.getPrecoTotal());
        painelDetalhes.setVisible(true);
    }//GEN-LAST:event_painelBoletoMouseClicked

    private void botaoFinalizarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoFinalizarCompraMouseClicked
        botaoFinalizarCompra.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        // Inserindo os produtos comprados nas compras do usuario
        for (Produto listaDeProduto : listaDeProdutos) {
            ComprasDAO comprasDAO = new ComprasDAO();
            boolean inseriu = comprasDAO.inserirProduto(listaDeProduto, usuarioOnline);

            if (inseriu) {
                CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
                carrinhoDAO.deletarProdutoCarrinho(usuarioOnline, listaDeProduto);

                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.verificaProduto(listaDeProduto, listaDeProduto.getQuantidadeCompra());
            } else {
                new TelaAlerta("O sistema retornou um erro insperado com o " + listaDeProduto.getTipo(), 2).setVisible(true);
            }
        }
        new TelaAlerta("Olá, " + usuarioOnline.getNome() + "! Obrigado por confiar em nossos produtos, "
                + "sua compra em breve estará a caminho e logo chegará até você!", 1).setVisible(true);
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
        botaoFinalizarCompra.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botaoFinalizarCompraMouseClicked

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
            java.util.logging.Logger.getLogger(TelaComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFinalizarCompra;
    private javax.swing.JLabel iconBoleto;
    private javax.swing.JLabel iconCaminhao;
    private javax.swing.JLabel iconCard;
    private javax.swing.JLabel iconLocal;
    private javax.swing.JLabel iconNota;
    private javax.swing.JLabel iconTipoPagamento;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labelDetalhesEnvio;
    private javax.swing.JLabel labelDetalhesPagamento;
    private javax.swing.JLabel labelTipoPagamento;
    private javax.swing.JPanel painelBoleto;
    private javax.swing.JPanel painelCard;
    private javax.swing.JPanel painelCidadeEnvio;
    private javax.swing.JPanel painelCompra;
    private javax.swing.JPanel painelDetalhes;
    private javax.swing.JPanel painelFrete;
    private javax.swing.JPanel painelNota;
    private javax.swing.JPanel painelPagamento;
    private javax.swing.JScrollPane painelScrollCompra;
    private javax.swing.JPanel painelTipoPagamento;
    private javax.swing.JLabel textBoleto;
    private javax.swing.JLabel textCard;
    private javax.swing.JLabel textCard2;
    private javax.swing.JLabel textEndereco;
    private javax.swing.JLabel textNota;
    private javax.swing.JLabel textPrecoPagamento;
    private javax.swing.JLabel textRua;
    private javax.swing.JLabel textTempoEnvio;
    private javax.swing.JLabel textTipoEnvio;
    private javax.swing.JLabel textTipoPagamento;
    private javax.swing.JLabel textUsuario;
    // End of variables declaration//GEN-END:variables
}
