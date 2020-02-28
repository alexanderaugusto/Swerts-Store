package br.inatel.swertsstore.view;

import br.inatel.swertsstore.controller.CarrinhoDAO;
import br.inatel.swertsstore.controller.ProdutoDAO;
import br.inatel.swertsstore.model.Carrinho;
import br.inatel.swertsstore.model.Produto;
import br.inatel.swertsstore.util.RendererList;
import br.inatel.swertsstore.model.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class TelaPrincipal extends javax.swing.JFrame {

    Usuario usuarioOnline = new Usuario(); // Instanciando usuario para guardar o usuario online e utilizar nesta classe
    private JList<Produto> listProduto = new JList<Produto>(); // Lista para guardar os produtos e mostrar no painel
    private DefaultListModel<Produto> model = new DefaultListModel<>(); // Lista model para adicionar produtos na lista de produtos 
    private ArrayList<Produto> listaDeProdutos = new ArrayList<>();

    public TelaPrincipal(Usuario usuario) {
        initComponents();
        initComponentsList();

        // Pegando a resolução do PC
        setLocationRelativeTo(null);
        pegarResolucao();
        this.setExtendedState(MAXIMIZED_BOTH); // Iniciando a tela em tela cheia

        // Verificando se tem produtos na loja
        ArrayList<Produto> temProduto = new ArrayList<>();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        temProduto = produtoDAO.buscarProdutosSemFiltro();

        // Configurando a listProduto para colocar os produtos dentro
        listProduto.setModel(model);
        listProduto.setCellRenderer(new RendererList());
        listProduto.setBackground(new Color(255, 255, 255));
        painelListaProdutos.add(new JScrollPane(listProduto), BorderLayout.CENTER);
        painelListaProdutos.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Verificando se a lista de produtos está vazia
        if (temProduto.isEmpty()) {
            // INICIALMENTE A TELA VAZIA ESTARÁ INSTANCIADA
            LojaVazia lojaVazia = new LojaVazia();
            lojaVazia.show();
            layoutPrincipal.add(lojaVazia);
            ((BasicInternalFrameUI) lojaVazia.getUI()).setNorthPane(null); // Tirando a parte superior do JInternalFrame
        } else {
            // INICIALMENTE A TELA HOME (PRODUTOS) ESTARÁ INSTANCIADA
            InternalTelaHome telaHome = new InternalTelaHome(usuario, layoutPrincipal, this);
            telaHome.show();
            layoutPrincipal.add(telaHome);
            ((BasicInternalFrameUI) telaHome.getUI()).setNorthPane(null); // Tirando a parte superior do JInternalFrame
        }

        // Colocando o nome do usuario no labelNomeUsuario
        usuarioOnline = usuario; // pegando o usuario online
        labelNomeUsuario.setText(usuarioOnline.getNome() + " " + usuarioOnline.getSobrenome());
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

    // METODO PARA PEGAR A RESULUCAO DA TELA DO PC
    private void pegarResolucao() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension dimensao = t.getScreenSize();
        this.setSize((dimensao.width + 5), (dimensao.height - 38));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTelaPrincipal = new javax.swing.JPanel();
        painelListaConta = new javax.swing.JScrollPane();
        listaConta = new javax.swing.JList<>();
        painelListaConta.setVisible(false);
        listaConta.setBorder(new EmptyBorder(5,5,5,5));
        painelListaProdutos = new javax.swing.JPanel();
        painelNotificacoes = new javax.swing.JPanel();
        labelAviso = new javax.swing.JLabel();
        labelNotificacoes = new javax.swing.JLabel();
        painelMenu = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        labelNomeUsuario = new javax.swing.JLabel();
        botaoCarrinho = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        painelBuscar = new javax.swing.JPanel();
        textoBuscar = new javax.swing.JTextField();
        botaoBuscar = new javax.swing.JLabel();
        botaoNotificacoes = new javax.swing.JLabel();
        layoutPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        painelTelaPrincipal.setBackground(new java.awt.Color(0, 0, 238));
        painelTelaPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelTelaPrincipal.setPreferredSize(new java.awt.Dimension(1366, 768));
        painelTelaPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelListaConta.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelListaConta.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        listaConta.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        listaConta.setForeground(new java.awt.Color(51, 51, 51));
        listaConta.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Dados da conta", "Compras", "Sair", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaConta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaConta.setFixedCellHeight(25);
        listaConta.setSelectionBackground(new java.awt.Color(0, 102, 102));
        listaConta.setSelectionForeground(new java.awt.Color(0, 0, 0));
        listaConta.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaContaValueChanged(evt);
            }
        });
        painelListaConta.setViewportView(listaConta);

        painelTelaPrincipal.add(painelListaConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(859, 79, 200, 90));

        painelListaProdutos.setBackground(new java.awt.Color(255, 255, 255));
        painelListaProdutos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        painelListaProdutos.setLayout(new java.awt.BorderLayout());
        painelListaProdutos.setVisible(false);
        painelTelaPrincipal.add(painelListaProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 560, 270));

        painelNotificacoes.setBackground(new java.awt.Color(255, 255, 255));
        painelNotificacoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        painelNotificacoes.setVisible(false);

        labelAviso.setBackground(new java.awt.Color(255, 255, 255));
        labelAviso.setFont(new java.awt.Font("Leelawadee UI", 1, 13)); // NOI18N
        labelAviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAviso.setText("Avisos");

        labelNotificacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNotificacoes.setText("Você não possui notificações!");
        labelNotificacoes.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout painelNotificacoesLayout = new javax.swing.GroupLayout(painelNotificacoes);
        painelNotificacoes.setLayout(painelNotificacoesLayout);
        painelNotificacoesLayout.setHorizontalGroup(
            painelNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
        painelNotificacoesLayout.setVerticalGroup(
            painelNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNotificacoesLayout.createSequentialGroup()
                .addComponent(labelAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
        );

        painelTelaPrincipal.add(painelNotificacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 80, 180, 130));

        painelMenu.setBackground(new java.awt.Color(0, 0, 238));
        painelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelMenu.setPreferredSize(new java.awt.Dimension(1366, 100));
        painelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelMenuMouseClicked(evt);
            }
        });
        painelMenu.setLayout(null);

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logotipoInicio.png"))); // NOI18N
        labelLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLogoMouseClicked(evt);
            }
        });
        painelMenu.add(labelLogo);
        labelLogo.setBounds(23, 9, 190, 80);

        labelNomeUsuario.setBackground(new java.awt.Color(255, 255, 255));
        labelNomeUsuario.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        labelNomeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelNomeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/expandirIcon.png"))); // NOI18N
        labelNomeUsuario.setText("Nome Sobrenome");
        labelNomeUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelNomeUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        labelNomeUsuario.setMaximumSize(new java.awt.Dimension(300, 25));
        labelNomeUsuario.setPreferredSize(new java.awt.Dimension(220, 25));
        labelNomeUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelNomeUsuarioMouseClicked(evt);
            }
        });
        painelMenu.add(labelNomeUsuario);
        labelNomeUsuario.setBounds(883, 42, 180, 25);

        botaoCarrinho.setBackground(new java.awt.Color(255, 255, 255));
        botaoCarrinho.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
        botaoCarrinho.setForeground(new java.awt.Color(255, 255, 255));
        botaoCarrinho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botaoCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrinhoIcon.png"))); // NOI18N
        botaoCarrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCarrinho.setIconTextGap(8);
        botaoCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoCarrinhoMouseClicked(evt);
            }
        });
        painelMenu.add(botaoCarrinho);
        botaoCarrinho.setBounds(1176, 37, 40, 30);

        labelUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuarioIcon.png"))); // NOI18N
        painelMenu.add(labelUsuario);
        labelUsuario.setBounds(852, 0, 25, 100);

        painelBuscar.setBackground(new java.awt.Color(255, 255, 255));
        painelBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        textoBuscar.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        textoBuscar.setForeground(new java.awt.Color(153, 153, 153));
        textoBuscar.setText("O que você deseja buscar?");
        textoBuscar.setAlignmentX(0.0F);
        textoBuscar.setAlignmentY(0.0F);
        textoBuscar.setBorder(null);
        textoBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textoBuscar.setFocusable(false);
        textoBuscar.setMargin(new java.awt.Insets(2, 20, 2, 2));
        textoBuscar.setBorder(BorderFactory.createCompoundBorder(textoBuscar.getBorder(),
            BorderFactory.createEmptyBorder(5, 15, 5, 5))); // MUDANDO O PADDING DA CAIXA DE TEXTO
    textoBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            textoBuscarFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            textoBuscarFocusLost(evt);
        }
    });
    textoBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            textoBuscarMouseClicked(evt);
        }
    });

    botaoBuscar.setBackground(new java.awt.Color(0, 0, 238));
    botaoBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    botaoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisarIcon.png"))); // NOI18N
    botaoBuscar.setAlignmentX(0.5F);
    botaoBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoBuscar.setOpaque(true);
    botaoBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            botaoBuscarMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout painelBuscarLayout = new javax.swing.GroupLayout(painelBuscar);
    painelBuscar.setLayout(painelBuscarLayout);
    painelBuscarLayout.setHorizontalGroup(
        painelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelBuscarLayout.createSequentialGroup()
            .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(botaoBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
    );
    painelBuscarLayout.setVerticalGroup(
        painelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelBuscarLayout.createSequentialGroup()
            .addGroup(painelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(textoBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(botaoBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(0, 0, Short.MAX_VALUE))
    );

    painelMenu.add(painelBuscar);
    painelBuscar.setBounds(258, 30, 565, 42);

    botaoNotificacoes.setBackground(new java.awt.Color(255, 255, 255));
    botaoNotificacoes.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
    botaoNotificacoes.setForeground(new java.awt.Color(255, 255, 255));
    botaoNotificacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    botaoNotificacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notificacaoIcon.png"))); // NOI18N
    botaoNotificacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoNotificacoes.setIconTextGap(8);
    botaoNotificacoes.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            botaoNotificacoesMouseClicked(evt);
        }
    });
    painelMenu.add(botaoNotificacoes);
    botaoNotificacoes.setBounds(1234, 34, 40, 38);

    painelTelaPrincipal.add(painelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1364, -1));

    layoutPrincipal.setBackground(new java.awt.Color(255, 255, 255));
    layoutPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
    layoutPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    layoutPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            layoutPrincipalMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout layoutPrincipalLayout = new javax.swing.GroupLayout(layoutPrincipal);
    layoutPrincipal.setLayout(layoutPrincipalLayout);
    layoutPrincipalLayout.setHorizontalGroup(
        layoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 1342, Short.MAX_VALUE)
    );
    layoutPrincipalLayout.setVerticalGroup(
        layoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 596, Short.MAX_VALUE)
    );

    painelTelaPrincipal.add(layoutPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1346, 600));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(painelTelaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(painelTelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textoBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoBuscarFocusGained
        if (textoBuscar.getText().equals("O que você deseja buscar?")) {
            textoBuscar.setText("");
            textoBuscar.setForeground(new Color(79, 79, 79));
        }
    }//GEN-LAST:event_textoBuscarFocusGained

    private void textoBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoBuscarFocusLost
        if (textoBuscar.getText().equals("")) {
            textoBuscar.setText("O que você deseja buscar?");
            textoBuscar.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoBuscarFocusLost

    private void textoBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoBuscarMouseClicked
        hideComponents();
        textoBuscar.setFocusable(true);
        textoBuscar.grabFocus();
    }//GEN-LAST:event_textoBuscarMouseClicked
    // QUANDO CLICAR EM QUALQUER PARTE DO PAINEL
    private void painelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelMenuMouseClicked
        hideComponents();
    }//GEN-LAST:event_painelMenuMouseClicked
    // QUANDO CLICAR EM QUALQUER PARTE DO FORM
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        hideComponents();
    }//GEN-LAST:event_formMouseClicked

    private void labelLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLogoMouseClicked
        labelLogo.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        // Verificando se tem produtos na loja
        ArrayList<Produto> temProduto = new ArrayList<>();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        temProduto = produtoDAO.buscarProdutosSemFiltro();
        if (temProduto.isEmpty()) {
            // INICIALMENTE A TELA HOME (PRODUTOS) ESTARÁ INSTANCIADA
            LojaVazia lojaVazia = new LojaVazia();
            lojaVazia.show();
            ((BasicInternalFrameUI) lojaVazia.getUI()).setNorthPane(null); // Tirando a parte superior do JInternalFrame
            layoutPrincipal.removeAll();
            layoutPrincipal.add(lojaVazia);
            layoutPrincipal.repaint();
            layoutPrincipal.revalidate();

        } else {
            // INSTANCIANDO A TELA HOME (PRODUTOS) E ADICIONANDO AO PAINEL PRINCIPAL
            InternalTelaHome telaHome = new InternalTelaHome(usuarioOnline, layoutPrincipal, this);

            telaHome.show();
            ((BasicInternalFrameUI) telaHome.getUI()).setNorthPane(null); // TIRANDO A PARTE SUPERIOR DO JInternalFrame
            layoutPrincipal.removeAll();
            layoutPrincipal.add(telaHome);
            layoutPrincipal.repaint();
            layoutPrincipal.revalidate();
        }
        
        hideComponents();
        listaConta.clearSelection(); // Retirando a seleção da lista de dados do usuario
        labelLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_labelLogoMouseClicked

    private void botaoCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCarrinhoMouseClicked
        botaoCarrinho.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        // INSTANCIANDO A TELA CARRINHO E ADICIONANDO AO PAINEL PRINCIPAL
        InternalTelaCarrinho telaCarrinho = new InternalTelaCarrinho(usuarioOnline, layoutPrincipal, this);
        telaCarrinho.show();
        ((BasicInternalFrameUI) telaCarrinho.getUI()).setNorthPane(null); // TIRANDO A PARTE SUPERIOR DO JInternalFrame
        layoutPrincipal.removeAll();
        layoutPrincipal.add(telaCarrinho);
        layoutPrincipal.repaint(); 
        layoutPrincipal.revalidate();

        listaConta.clearSelection(); // Retirando a seleção da lista de dados do usuario
        hideComponents();
        botaoCarrinho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_botaoCarrinhoMouseClicked

    private void labelNomeUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelNomeUsuarioMouseClicked
        // SE CLICAR NO NOME DE USUARIO EXPANDIR A LISTA SE NAO ESTIVER EXPANDIDA E RECOLHER SE ESTIVER EXPANDIDA
        if (painelListaConta.isVisible() == false) {
            painelListaConta.setVisible(true);
        } else {
            painelListaConta.setVisible(false);
        }
        if (painelListaProdutos.isVisible()) {
            painelListaProdutos.setVisible(false);
        }
        if (painelNotificacoes.isVisible()) {
            painelNotificacoes.setVisible(false);
        }
        if(textoBuscar.isFocusable()){
            textoBuscar.setFocusable(false);
        }
    }//GEN-LAST:event_labelNomeUsuarioMouseClicked

    private void listaContaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaContaValueChanged
        listaConta.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        // INSTANCIANDO A TELA DADOS DA CONTA E ADICIONANDO AO PAINEL PRINCIPAL SE CLICAR NO ELEMENTO 0
        if (listaConta.getSelectedIndex() == 0) {
            InternalTelaDadosDaConta telaDadosDaConta = new InternalTelaDadosDaConta(usuarioOnline, this);
            telaDadosDaConta.show();
            ((BasicInternalFrameUI) telaDadosDaConta.getUI()).setNorthPane(null); // TIRANDO A PARTE SUPERIOR DO JInternalFrame
            layoutPrincipal.removeAll();
            layoutPrincipal.add(telaDadosDaConta);
            layoutPrincipal.repaint();
            layoutPrincipal.revalidate();
        } // INSTANCIANDO A TELA COMPRAS E ADICIONANDO AO PAINEL PRINCIPAL SE CLICAR NO ELEMENTO 1
        else if (listaConta.getSelectedIndex() == 1) {
            InternalTelaCompras telaCompras = new InternalTelaCompras(usuarioOnline);
            telaCompras.show();
            ((BasicInternalFrameUI) telaCompras.getUI()).setNorthPane(null); // TIRANDO A PARTE SUPERIOR DO JInternalFrame
            layoutPrincipal.removeAll();
            layoutPrincipal.add(telaCompras);
            layoutPrincipal.repaint();
            layoutPrincipal.revalidate();
        } // SAINDO DA CONTA SE CLICAR NO ELEMENTO 3
        else if (listaConta.getSelectedIndex() == 2) {
            dispose();
            new TelaLogin().setVisible(true);
        }
        
        hideComponents();
        listaConta.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_listaContaValueChanged

    private void botaoBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoBuscarMouseClicked
        botaoBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        ProdutoDAO produtoDAO = new ProdutoDAO();

        listaDeProdutos = produtoDAO.buscarProdutosComFiltro(textoBuscar.getText());

        if (listaDeProdutos.isEmpty() == false) {
            model.removeAllElements();

            // Percorrendo a lista de produtos e adicionando no painel da lista
            for (Produto elementoDaLista : listaDeProdutos) {
                model.addElement(elementoDaLista);
            }
            painelListaProdutos.setVisible(true);
            textoBuscar.setFocusable(false);
            painelListaConta.setVisible(false);
        } else {
            new TelaAlerta("Desculpa! Não há produtos com estas características!", 2).setVisible(true);
        }
        botaoBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_botaoBuscarMouseClicked

    private void botaoNotificacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoNotificacoesMouseClicked
        botaoNotificacoes.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Carrinho carrinhoTemp = new Carrinho();
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        carrinhoTemp = carrinhoDAO.buscarProdutosNoCarrinho(usuarioOnline);

        if (carrinhoTemp.getListaDeProduto().isEmpty() == false) {
            labelNotificacoes.setText("<html> \n"
                    + "<p> Olá, " + usuarioOnline.getNome() + "! Gostaria de te lembrar que você possui "
                    + carrinhoTemp.getListaDeProduto().size() + " iten(s) no carrinho "
                    + "esperando por você! </p>\n" + "</html>");

        } else {
            labelNotificacoes.setText("Você não possui notificações!");
        }

        painelListaConta.setVisible(false);
        painelListaProdutos.setVisible(false);
        textoBuscar.setFocusable(false);

        if (painelNotificacoes.isVisible()) {
            painelNotificacoes.setVisible(false);
        } else {
            painelNotificacoes.setVisible(true);
        }
        botaoNotificacoes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_botaoNotificacoesMouseClicked

    private void layoutPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_layoutPrincipalMouseClicked
        hideComponents();
    }//GEN-LAST:event_layoutPrincipalMouseClicked

    private void listProdutoValueChanged(javax.swing.event.ListSelectionEvent evt) {
        listProduto.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (listProduto.getSelectedIndex() != -1) {
            System.out.println(listProduto.getSelectedIndex());
            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            //System.out.println(listaDeProdutos.get(listProduto.getSelectedIndex()));
            boolean inseriu = carrinhoDAO.verificaProduto(usuarioOnline, listaDeProdutos.get(listProduto.getSelectedIndex()), 1);

            // Abrindo a Tela Carrinho para continuar com a compra
            InternalTelaCarrinho telaCarrinho = new InternalTelaCarrinho(usuarioOnline, layoutPrincipal, this);
            telaCarrinho.show();
            ((BasicInternalFrameUI) telaCarrinho.getUI()).setNorthPane(null); // TIRANDO A PARTE SUPERIOR DO JInternalFrame
            layoutPrincipal.removeAll();
            layoutPrincipal.add(telaCarrinho);
            layoutPrincipal.repaint();
            layoutPrincipal.revalidate();
        }
        hideComponents();
        listProduto.clearSelection();
        listProduto.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    public void hideComponents() {
        if (painelListaProdutos.isVisible()) {
            painelListaProdutos.setVisible(false);
        }
        if (painelListaConta.isVisible()) {
            painelListaConta.setVisible(false);
        }
        if (painelNotificacoes.isVisible()) {
            painelNotificacoes.setVisible(false);
        }
        if (textoBuscar.isFocusable()) {
            textoBuscar.setFocusable(false);
        }
    }

    // FUNCAO QUE EXECUTA TODO METODO PRINPCIPAL
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TelaPrincipal().setVisible(true); // INSTANCIANDO A TELA PRINCIPAL E MOSTRANDO
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botaoBuscar;
    private javax.swing.JLabel botaoCarrinho;
    private javax.swing.JLabel botaoNotificacoes;
    private javax.swing.JLabel labelAviso;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelNomeUsuario;
    private javax.swing.JLabel labelNotificacoes;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel layoutPrincipal;
    private javax.swing.JList<String> listaConta;
    private javax.swing.JPanel painelBuscar;
    private javax.swing.JScrollPane painelListaConta;
    private javax.swing.JPanel painelListaProdutos;
    private javax.swing.JPanel painelMenu;
    private javax.swing.JPanel painelNotificacoes;
    private javax.swing.JPanel painelTelaPrincipal;
    private javax.swing.JTextField textoBuscar;
    // End of variables declaration//GEN-END:variables
}
