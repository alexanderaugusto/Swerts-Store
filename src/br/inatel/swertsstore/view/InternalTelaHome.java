package br.inatel.swertsstore.view;

import br.inatel.swertsstore.controller.CarrinhoDAO;
import br.inatel.swertsstore.controller.ProdutoDAO;
import br.inatel.swertsstore.util.BuscaCep;
import br.inatel.swertsstore.util.CalculaFretePrazo;
import br.inatel.swertsstore.model.Produto;
import br.inatel.swertsstore.util.RendererListTelaPrincipal;
import br.inatel.swertsstore.model.Usuario;
import br.inatel.swertsstore.util.Webservicecep;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.xml.bind.JAXBException;

public class InternalTelaHome extends javax.swing.JInternalFrame {

    public ArrayList<Produto> listaDeProdutos = new ArrayList<>(); // Lista de produtos auxiliar
    public Usuario usuarioOnline; // Usuario auxiliar para usar nesta classe 
    private JList<Produto> listProduto = new JList<Produto>(); // Lista para guardar os produtos e mostrar no painel
    private DefaultListModel<Produto> model = new DefaultListModel<>(); // Lista model para adicionar produtos na lista de produtos 
    public JPanel layoutPrincipal;
    TelaPrincipal telaPrincipalThis;

    // Atributos para calcular o frete
    String prazoPAC;
    String prazoSEDEX;
    String fretePAC;
    String freteSEDEX;

    public InternalTelaHome(Usuario usuario, JPanel layoutPrincipal, TelaPrincipal telaPrincipalThis) {
        initComponents();
        initComponentsList();

        
        usuarioOnline = usuario;
        this.layoutPrincipal = layoutPrincipal; // Atribuindo o layout da tela principal para um atributo desta classe
        this.telaPrincipalThis = telaPrincipalThis;

        // Pegando os dados do produto do banco de dados
        ProdutoDAO dao = new ProdutoDAO();
        listaDeProdutos = dao.buscarProdutosSemFiltro();

        // Configurando a listProduto para colocar os produtos dentro
        listProduto.setModel(model);
        listProduto.setCellRenderer(new RendererListTelaPrincipal());
        listProduto.setBackground(new Color(255, 255, 255));
        //listProduto.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        //listProduto.setVisibleRowCount(-1);
        listaProdutos.add(new JScrollPane(listProduto), BorderLayout.CENTER);
        listaProdutos.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Percorrendo a lista de produtos e adicionando no painel da lista
        for (Produto elementoDaLista : listaDeProdutos) {
            model.addElement(elementoDaLista);
        }
        listaProdutos.setVisible(true);
    }

    // Metodo para iniciar a listProduto e configurar
    private void initComponentsList() {
        listProduto = new javax.swing.JList<>();

        listProduto.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listProdutoValueChanged(evt);
            }
        });
    }

    public void calculaPrecoFrete() {
        //Instanciando a classe CalculaFretePrazo
        CalculaFretePrazo calcFrete = new CalculaFretePrazo();

        //variváveis para guardar os valores dos calculos 
        // PARAMETROS PARA DETERMINAR QUAL O TIPO DE SERVIÇO 
        //SEDEX = "40010"
        //PAC = "41106";
        String quantidade = quantidadeProduto.getSelectedItem().toString();
        int quantidadeInt = Integer.parseInt(quantidade.replaceAll("[^0-9]", ""));
        double quant = quantidadeInt;

        //Armazenando os valores do prazo e frete do serviço PAC 
        calcFrete.calculaFrete(textoCalculaFrete.getText(), "41106", quant);
        prazoPAC = calcFrete.getPrazoEntregaProduto();
        fretePAC = calcFrete.getValorEntregaProduto();

        //Armazenando os valores do prazo e frete do serviço SEDEX
        calcFrete.calculaFrete(textoCalculaFrete.getText(), "40010", quant);
        freteSEDEX = calcFrete.getValorEntregaProduto();
        prazoSEDEX = calcFrete.getPrazoEntregaProduto();

        //Mostrando os resultados do calculo na interface
        labelFretePAC.setText("R$ " + fretePAC);
        labelPrazoPAC.setText(prazoPAC + " dia(s) úteis");
        labelFreteSedex.setText("R$ " + freteSEDEX);
        labelPrazoSedex.setText(prazoSEDEX + " dia(s) úteis");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTelaHome = new javax.swing.JPanel();
        painelComprar = new javax.swing.JPanel();
        imgProduto = new javax.swing.JLabel();
        precoProduto = new javax.swing.JLabel();
        tituloProduto = new javax.swing.JLabel();
        quantidadeProduto = new javax.swing.JComboBox<>();
        labelCalculaFrete = new javax.swing.JLabel();
        textoCalculaFrete = new javax.swing.JFormattedTextField();
        painelMostraFrete = new javax.swing.JPanel();
        labelEntrega = new javax.swing.JLabel();
        labelPrazo = new javax.swing.JLabel();
        labelFrete = new javax.swing.JLabel();
        labelPAC = new javax.swing.JLabel();
        labelSedex = new javax.swing.JLabel();
        labelFretePAC = new javax.swing.JLabel();
        labelFreteSedex = new javax.swing.JLabel();
        labelPrazoPAC = new javax.swing.JLabel();
        labelPrazoSedex = new javax.swing.JLabel();
        botaoComprar = new javax.swing.JButton();
        addCarrinho = new javax.swing.JButton();
        botaoCalculaFrete = new javax.swing.JButton();
        listaProdutos = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setToolTipText("Oi");
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(1346, 600));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        painelTelaHome.setBackground(new java.awt.Color(255, 255, 255));
        painelTelaHome.setPreferredSize(new java.awt.Dimension(1346, 650));
        painelTelaHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelTelaHomeMouseClicked(evt);
            }
        });

        painelComprar.setBackground(new java.awt.Color(255, 255, 255));
        painelComprar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelComprar.setVisible(false);
        painelComprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelComprarMouseClicked(evt);
            }
        });

        imgProduto.setBackground(new java.awt.Color(255, 255, 255));
        imgProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/semImagem.jpg"))); // NOI18N
        imgProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        imgProduto.setOpaque(true);

        precoProduto.setBackground(new java.awt.Color(255, 255, 255));
        precoProduto.setFont(new java.awt.Font("Leelawadee UI", 0, 20)); // NOI18N
        precoProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        precoProduto.setText("R$ 2998.99 ");

        tituloProduto.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        tituloProduto.setText("<html>\n<p>\nNotebook Dell Inspiron I15-3584-m10p 15.6 Ci3 4gb 1tb Win10\n</p> \n</html>");

        quantidadeProduto.setBackground(new java.awt.Color(204, 204, 204));
        quantidadeProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 unidade", "2 unidades", "3 unidades", "4 unidades", "5 unidades", "+ de 5 unidades" }));
        quantidadeProduto.setToolTipText("");
        quantidadeProduto.setBorder(null);
        quantidadeProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                quantidadeProdutoItemStateChanged(evt);
            }
        });
        quantidadeProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantidadeProdutoMouseClicked(evt);
            }
        });

        labelCalculaFrete.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelCalculaFrete.setText("Calcular Frete:");

        try {
            textoCalculaFrete.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelEntrega.setFont(new java.awt.Font("Leelawadee UI", 1, 11)); // NOI18N
        labelEntrega.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelEntrega.setText("Entrega");

        labelPrazo.setFont(new java.awt.Font("Leelawadee UI", 1, 11)); // NOI18N
        labelPrazo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPrazo.setText("Prazo");

        labelFrete.setFont(new java.awt.Font("Leelawadee UI", 1, 11)); // NOI18N
        labelFrete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelFrete.setText("Frete");

        labelPAC.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        labelPAC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPAC.setText("PAC");

        labelSedex.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        labelSedex.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelSedex.setText("Sedex");

        labelFretePAC.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        labelFretePAC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelFretePAC.setText("R$ 28,78");

        labelFreteSedex.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        labelFreteSedex.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelFreteSedex.setText("R$ 35,09");

        labelPrazoPAC.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        labelPrazoPAC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPrazoPAC.setText("10 dia(s) úteis");

        labelPrazoSedex.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        labelPrazoSedex.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPrazoSedex.setText("3 dia(s) úteis");

        javax.swing.GroupLayout painelMostraFreteLayout = new javax.swing.GroupLayout(painelMostraFrete);
        painelMostraFrete.setLayout(painelMostraFreteLayout);
        painelMostraFreteLayout.setHorizontalGroup(
            painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMostraFreteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelMostraFreteLayout.createSequentialGroup()
                        .addComponent(labelEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelMostraFreteLayout.createSequentialGroup()
                        .addGroup(painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelPAC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelSedex, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFretePAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelFreteSedex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMostraFreteLayout.createSequentialGroup()
                        .addComponent(labelPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(labelPrazoPAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPrazoSedex, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelMostraFreteLayout.setVerticalGroup(
            painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMostraFreteLayout.createSequentialGroup()
                .addGroup(painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEntrega)
                    .addComponent(labelPrazo)
                    .addComponent(labelFrete))
                .addGap(18, 18, 18)
                .addGroup(painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPAC)
                    .addComponent(labelFretePAC)
                    .addComponent(labelPrazoPAC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSedex)
                    .addComponent(labelFreteSedex)
                    .addComponent(labelPrazoSedex))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        botaoComprar.setBackground(new java.awt.Color(0, 0, 238));
        botaoComprar.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        botaoComprar.setForeground(new java.awt.Color(255, 255, 255));
        botaoComprar.setText("Comprar");
        botaoComprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoComprarMouseClicked(evt);
            }
        });

        addCarrinho.setBackground(new java.awt.Color(255, 255, 255));
        addCarrinho.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        addCarrinho.setForeground(new java.awt.Color(0, 0, 238));
        addCarrinho.setText("Adicionar ao carrinho");
        addCarrinho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 238)));
        addCarrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCarrinhoMouseClicked(evt);
            }
        });

        botaoCalculaFrete.setBackground(new java.awt.Color(0, 0, 238));
        botaoCalculaFrete.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        botaoCalculaFrete.setForeground(new java.awt.Color(255, 255, 255));
        botaoCalculaFrete.setText("Calcular");
        botaoCalculaFrete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoCalculaFreteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelComprarLayout = new javax.swing.GroupLayout(painelComprar);
        painelComprar.setLayout(painelComprarLayout);
        painelComprarLayout.setHorizontalGroup(
            painelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelComprarLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(painelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tituloProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCalculaFrete)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelComprarLayout.createSequentialGroup()
                        .addComponent(precoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quantidadeProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(imgProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelComprarLayout.createSequentialGroup()
                        .addComponent(textoCalculaFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCalculaFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(painelMostraFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addCarrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(106, 106, 106))
        );
        painelComprarLayout.setVerticalGroup(
            painelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelComprarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(tituloProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(precoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(addCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelCalculaFrete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoCalculaFrete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoCalculaFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelMostraFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        painelMostraFrete.setVisible(false);

        listaProdutos.setBackground(new java.awt.Color(255, 255, 255));
        listaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaProdutosMouseClicked(evt);
            }
        });
        listaProdutos.setLayout(new java.awt.BorderLayout());
        listaProdutos.setVisible(false);

        javax.swing.GroupLayout painelTelaHomeLayout = new javax.swing.GroupLayout(painelTelaHome);
        painelTelaHome.setLayout(painelTelaHomeLayout);
        painelTelaHomeLayout.setHorizontalGroup(
            painelTelaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaHomeLayout.createSequentialGroup()
                .addComponent(listaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelTelaHomeLayout.setVerticalGroup(
            painelTelaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listaProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTelaHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelTelaHome, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quantidadeProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_quantidadeProdutoItemStateChanged
        quantidadeProduto.setFocusable(true);

        if (quantidadeProduto.getSelectedIndex() == 5) {
            quantidadeProduto.setEditable(true);
            quantidadeProduto.setSelectedItem(null);
        } else if (quantidadeProduto.getSelectedIndex() == 4) {
            quantidadeProduto.setEditable(false);
        } else if (quantidadeProduto.getSelectedIndex() == 3) {
            quantidadeProduto.setEditable(false);
        } else if (quantidadeProduto.getSelectedIndex() == 2) {
            quantidadeProduto.setEditable(false);
        } else if (quantidadeProduto.getSelectedIndex() == 1) {
            quantidadeProduto.setEditable(false);
        } else if (quantidadeProduto.getSelectedIndex() == 0) {
            quantidadeProduto.setEditable(false);
        }
    }//GEN-LAST:event_quantidadeProdutoItemStateChanged

    private void painelComprarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelComprarMouseClicked
        quantidadeProduto.setFocusable(false);
        telaPrincipalThis.hideComponents();

    }//GEN-LAST:event_painelComprarMouseClicked

    private void quantidadeProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantidadeProdutoMouseClicked
        quantidadeProduto.setFocusable(true);
    }//GEN-LAST:event_quantidadeProdutoMouseClicked

    private void botaoComprarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoComprarMouseClicked
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        quantidadeProduto.setFocusable(false);

        try {
            String quantidade = quantidadeProduto.getSelectedItem().toString();
            int quantidadeInt = Integer.parseInt(quantidade.replaceAll("[^0-9]", ""));

            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            boolean inseriu = carrinhoDAO.verificaProduto(usuarioOnline, listaDeProdutos.get(listProduto.getSelectedIndex()), quantidadeInt);

            if (inseriu == false) {
                carrinhoDAO.alterarProdutoCarrinho(usuarioOnline, listaDeProdutos.get(listProduto.getSelectedIndex()), quantidadeInt);
            }

            // Abrindo a Tela Carrinho para continuar com a compra
            InternalTelaCarrinho telaCarrinho = new InternalTelaCarrinho(usuarioOnline, layoutPrincipal, telaPrincipalThis);
            telaCarrinho.show();
            ((BasicInternalFrameUI) telaCarrinho.getUI()).setNorthPane(null); // TIRANDO A PARTE SUPERIOR DO JInternalFrame
            layoutPrincipal.removeAll();
            layoutPrincipal.add(telaCarrinho);
            layoutPrincipal.repaint();
            layoutPrincipal.revalidate();
        } catch (Exception e) {
            new TelaAlerta("A quantidade do(s) produto(s) está incorreta!", 2).setVisible(true);
        }
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_botaoComprarMouseClicked

    private void addCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCarrinhoMouseClicked
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            String quantidade = quantidadeProduto.getSelectedItem().toString();
            int quantidadeInt = Integer.parseInt(quantidade.replaceAll("[^0-9]", ""));

            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            boolean adicionou = carrinhoDAO.verificaProduto(usuarioOnline, listaDeProdutos.get(listProduto.getSelectedIndex()), quantidadeInt);

            if (adicionou == false) {
                new TelaAlerta("Desculpa! Você já adicionou este produto ao seu carrinho!", 2).setVisible(true);
            }
        } catch (NumberFormatException ex) {
            new TelaAlerta("Por favor! Digite uma quantidade válida para este produto.", 2).setVisible(true);
        }
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_addCarrinhoMouseClicked

    private void botaoCalculaFreteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCalculaFreteMouseClicked
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Webservicecep ws = new Webservicecep(); // Insanciando classe Webservecep para guardar informacoes do cep buscado
        BuscaCep buscandoCep = new BuscaCep(); // Instanciando classe BuscaCep para buscar a cidade e estado do cep inserido
        try {
            ws = BuscaCep.getEndereco(textoCalculaFrete.getText()); // Guardando informacoes do cep inserido no objeto ws
        } catch (JAXBException ex) {
            System.out.println("Erro = " + ex);
        } catch (MalformedURLException ex) {
            System.out.println("Erro = " + ex);
        }

        if (!"0".equals(ws.getResultado())) {
            quantidadeProduto.setFocusable(false);
            calculaPrecoFrete();
            painelMostraFrete.setVisible(true);
        } else {
            new TelaAlerta("Por favor! Digite um CEP válido.", 2).setVisible(true);
        }
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botaoCalculaFreteMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        telaPrincipalThis.hideComponents(); // Oculta todas as listas dropdowns do menu
    }//GEN-LAST:event_formMouseClicked

    private void painelTelaHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelTelaHomeMouseClicked
        telaPrincipalThis.hideComponents(); // Oculta todas as listas dropdowns do menu
    }//GEN-LAST:event_painelTelaHomeMouseClicked

    private void listaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProdutosMouseClicked
        telaPrincipalThis.hideComponents(); // Oculta todas as listas dropdowns do menu
    }//GEN-LAST:event_listaProdutosMouseClicked

    private void listProdutoValueChanged(javax.swing.event.ListSelectionEvent evt) {
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        painelComprar.setVisible(true);
        telaPrincipalThis.hideComponents();

        // Variaveis auxiliares para pegar a imagem do produto
        BufferedImage imagemBuffer = null;
        imagemBuffer = null;

        try {
            // Pegando a imagem na lista de produtos
            imagemBuffer = ImageIO.read(new ByteArrayInputStream(listaDeProdutos.get(listProduto.getSelectedIndex()).getImagem()));
        } catch (IOException ex) {
            new TelaAlerta("Desculpa! Ocorreu um erro ao carregar as imagens!", 2).setVisible(true);
        }
        Image diminuirImagem = imagemBuffer.getScaledInstance(327, 184, 0); // Redimencionando a imagem para o tamanho do jLabel

        // Setando os dados do produto
        imgProduto.setIcon(new ImageIcon(diminuirImagem));
        tituloProduto.setText("<html> <p> " + listaDeProdutos.get(listProduto.getSelectedIndex()).getTitulo() + " </p>  </html>");
        precoProduto.setText("R$ " + String.valueOf(listaDeProdutos.get(listProduto.getSelectedIndex()).getPreco()));
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCarrinho;
    private javax.swing.JButton botaoCalculaFrete;
    private javax.swing.JButton botaoComprar;
    private javax.swing.JLabel imgProduto;
    private javax.swing.JLabel labelCalculaFrete;
    private javax.swing.JLabel labelEntrega;
    private javax.swing.JLabel labelFrete;
    private javax.swing.JLabel labelFretePAC;
    private javax.swing.JLabel labelFreteSedex;
    private javax.swing.JLabel labelPAC;
    private javax.swing.JLabel labelPrazo;
    private javax.swing.JLabel labelPrazoPAC;
    private javax.swing.JLabel labelPrazoSedex;
    private javax.swing.JLabel labelSedex;
    private javax.swing.JPanel listaProdutos;
    private javax.swing.JPanel painelComprar;
    private javax.swing.JPanel painelMostraFrete;
    private javax.swing.JPanel painelTelaHome;
    private javax.swing.JLabel precoProduto;
    private javax.swing.JComboBox<String> quantidadeProduto;
    private javax.swing.JFormattedTextField textoCalculaFrete;
    private javax.swing.JLabel tituloProduto;
    // End of variables declaration//GEN-END:variables
}
