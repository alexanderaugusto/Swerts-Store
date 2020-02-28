package br.inatel.swertsstore.view;

import br.inatel.swertsstore.controller.CarrinhoDAO;
import br.inatel.swertsstore.controller.ProdutoDAO;
import br.inatel.swertsstore.util.BuscaCep;
import br.inatel.swertsstore.util.CalculaFretePrazo;
import br.inatel.swertsstore.model.Carrinho;
import br.inatel.swertsstore.util.FinalizarCompra;
import br.inatel.swertsstore.model.Produto;
import br.inatel.swertsstore.util.RendererList;
import br.inatel.swertsstore.model.Usuario;
import br.inatel.swertsstore.util.Webservicecep;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.xml.bind.JAXBException;

public class InternalTelaCarrinho extends javax.swing.JInternalFrame {

    private Usuario usuarioOnline; // Atributi para guardar o usuario que esta online
    private JList<Produto> listProduto = new JList<Produto>(); // Lista para guardar os produtos e mostrar no painel
    private DefaultListModel<Produto> model = new DefaultListModel<>(); // Lista model para adicionar produtos na lista de produtos 
    private Carrinho carrinhoUsuario = new Carrinho(); // Objeto para guardar os produtos do carrinho

    // Variaveis para guardar o total e quantidade da compra
    private float total = 0;
    private int quantidadeTotal = 0;

    // Atributos auxiliares para calculo de frete e prazo
    public String fretePAC = "0,00";
    public String prazoPAC;
    public String freteSEDEX = "0,00";
    public String prazoSEDEX;

    JPanel layoutPrincipal; // Variavel para pegar o painel da tela anterior
    TelaPrincipal telaPrincipalThis;

    public InternalTelaCarrinho(Usuario usuario, JPanel layoutPrincipal, TelaPrincipal telaPrincipalThis) {
        initComponents();
        initComponentsList();

        usuarioOnline = usuario;
        this.layoutPrincipal = layoutPrincipal;
        this.telaPrincipalThis = telaPrincipalThis;

        // Pegando os produtos do carrinho do usuario online
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        carrinhoUsuario = carrinhoDAO.buscarProdutosNoCarrinho(usuarioOnline);

        // Configurando a listProduto para colocar os produtos dentro
        listProduto.setModel(model);
        listProduto.setCellRenderer(new RendererList());
        listProduto.setBackground(new Color(255, 255, 255));
        listaProdutos.add(new JScrollPane(listProduto), BorderLayout.CENTER);
        listaProdutos.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Percorrendo a lista de produtos e adicionando no painel da lista
        for (Produto elementoDaLista : carrinhoUsuario.getListaDeProduto()) {
            model.addElement(elementoDaLista);
        }

        calculaPrecoProduto();

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

    //Método para calcular o preço dos produtos
    public void calculaPrecoProduto() {
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        carrinhoUsuario = carrinhoDAO.buscarProdutosNoCarrinho(usuarioOnline);

        //Caso carrinho esteja vazio, mostrar imagem. 
        if (carrinhoUsuario.getListaDeProduto().isEmpty()) {
            painelCarrinhoVazio.setVisible(true);
            listaProdutos.setVisible(false);
        } else {
            painelCarrinhoVazio.setVisible(false);
            listaProdutos.setVisible(true);
        }

        total = 0;
        quantidadeTotal = 0;
        float totalCompra = 0;

        //Percorre a lista de produtos para calcular o preço total. 
        for (Produto listaDeProduto : carrinhoUsuario.getListaDeProduto()) {
            total = total + (listaDeProduto.getPreco() * listaDeProduto.getQuantidadeCompra());
            quantidadeTotal = quantidadeTotal + listaDeProduto.getQuantidadeCompra();
        }

        //Mostra o resultado na tela
        precoProduto.setText("R$ " + String.valueOf(total));
        labelSubTotal.setText("Subtotal (" + quantidadeTotal + " produto(s))");

        //Calcula o preço final com o tipo de Envio selecionado 
        if (tipoEnvio.getSelectedIndex() == 0) {
            precoTotal.setText("R$ " + String.valueOf(total));
        } else if (tipoEnvio.getSelectedIndex() == 1) {
            totalCompra = total + Float.parseFloat(fretePAC.replace(",", "."));
            precoTotal.setText("R$ " + String.valueOf(totalCompra));
        } else if (tipoEnvio.getSelectedIndex() == 2) {
            totalCompra = total + Float.parseFloat(freteSEDEX.replace(",", "."));
            precoTotal.setText("R$ " + String.valueOf(totalCompra));
        }
    }

    public void calculaPrecoFrete() {
        //Instanciando a classe CalculaFretePrazo
        CalculaFretePrazo calcFrete = new CalculaFretePrazo();

        // PARAMETROS PARA DETERMINAR QUAL O TIPO DE SERVIÇO 
        //SEDEX = "40010"
        //PAC = "41106";
        double quant = quantidadeTotal;

        //Armazenando os valores do prazo e frete do serviço PAC 
        calcFrete.calculaFrete(textoCep.getText(), "41106", quant);
        prazoPAC = calcFrete.getPrazoEntregaProduto();
        fretePAC = calcFrete.getValorEntregaProduto();

        //Armazenando os valores do prazo e frete do serviço SEDEX
        calcFrete.calculaFrete(textoCep.getText(), "40010", quant);
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

        painelTelaCarrinho = new javax.swing.JPanel();
        painelTotalProdutos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        labelSubTotal = new javax.swing.JLabel();
        precoProduto = new javax.swing.JLabel();
        precoFrete = new javax.swing.JLabel();
        precoTotal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        botaoFinalizarCompra = new javax.swing.JButton();
        botaoContinuarCompra = new javax.swing.JButton();
        labelFreteSelecionado = new javax.swing.JLabel();
        painelListaProdutos = new javax.swing.JPanel();
        listaProdutos = new javax.swing.JPanel();
        configuracoesProduto = new javax.swing.JPanel();
        textoQuantidade = new javax.swing.JTextField();
        labelQuantidade = new javax.swing.JLabel();
        botaoSalvarQuantidade = new javax.swing.JButton();
        botaoExcluirProduto = new javax.swing.JButton();
        painelCarrinhoVazio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        painelCalculaFrete = new javax.swing.JPanel();
        labelCep = new javax.swing.JLabel();
        textoCep = new javax.swing.JFormattedTextField();
        botaoCalculaFrete = new javax.swing.JButton();
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
        painelEnvio = new javax.swing.JPanel();
        labelCidadeEnvio = new javax.swing.JLabel();
        cidadeEnvio = new javax.swing.JLabel();
        tipoEnvio = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(1346, 600));

        painelTelaCarrinho.setBackground(new java.awt.Color(255, 255, 255));
        painelTelaCarrinho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelTotalProdutos.setBackground(new java.awt.Color(255, 255, 255));
        painelTotalProdutos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 238)));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel5.setText("Resumo do Pedido ");

        labelTotal.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        labelTotal.setText("Total");

        labelSubTotal.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        labelSubTotal.setText("Subtotal (\"quantidade\" produto) ");

        precoProduto.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        precoProduto.setText("PRECO TOTAL DOS PROD");

        precoFrete.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        precoFrete.setText("Selecione um CEP no painel abaixo");

        precoTotal.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        precoTotal.setText("preco final");

        botaoFinalizarCompra.setBackground(new java.awt.Color(0, 0, 238));
        botaoFinalizarCompra.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        botaoFinalizarCompra.setForeground(new java.awt.Color(255, 255, 255));
        botaoFinalizarCompra.setText("Finalizar Compra");
        botaoFinalizarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoFinalizarCompraMouseClicked(evt);
            }
        });

        botaoContinuarCompra.setBackground(new java.awt.Color(0, 0, 238));
        botaoContinuarCompra.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        botaoContinuarCompra.setForeground(new java.awt.Color(255, 255, 255));
        botaoContinuarCompra.setText("Continuar comprando ");
        botaoContinuarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoContinuarCompraMouseClicked(evt);
            }
        });

        labelFreteSelecionado.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        labelFreteSelecionado.setText("Frete (não selecionado)");

        javax.swing.GroupLayout painelTotalProdutosLayout = new javax.swing.GroupLayout(painelTotalProdutos);
        painelTotalProdutos.setLayout(painelTotalProdutosLayout);
        painelTotalProdutosLayout.setHorizontalGroup(
            painelTotalProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTotalProdutosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelTotalProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTotalProdutosLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelTotalProdutosLayout.createSequentialGroup()
                        .addGroup(painelTotalProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelTotalProdutosLayout.createSequentialGroup()
                                .addGroup(painelTotalProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelTotal)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelFreteSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(44, 44, 44)
                                .addGroup(painelTotalProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(precoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(precoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(precoFrete))
                                .addGap(0, 17, Short.MAX_VALUE))
                            .addGroup(painelTotalProdutosLayout.createSequentialGroup()
                                .addComponent(botaoContinuarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        painelTotalProdutosLayout.setVerticalGroup(
            painelTotalProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTotalProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(painelTotalProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubTotal)
                    .addComponent(precoProduto))
                .addGap(32, 32, 32)
                .addGroup(painelTotalProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precoFrete)
                    .addComponent(labelFreteSelecionado))
                .addGap(53, 53, 53)
                .addGroup(painelTotalProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal)
                    .addComponent(precoTotal))
                .addGap(88, 88, 88)
                .addComponent(jLabel15)
                .addGap(33, 33, 33)
                .addGroup(painelTotalProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoContinuarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelTelaCarrinho.add(painelTotalProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, 440, 355));

        painelListaProdutos.setBackground(new java.awt.Color(255, 255, 255));
        painelListaProdutos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 238)));
        painelListaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelListaProdutosMouseClicked(evt);
            }
        });
        painelListaProdutos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaProdutos.setBackground(new java.awt.Color(255, 255, 255));
        listaProdutos.setLayout(new java.awt.BorderLayout());
        listaProdutos.setVisible(false);
        painelListaProdutos.add(listaProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 580, 350));

        configuracoesProduto.setBackground(new java.awt.Color(255, 255, 255));
        configuracoesProduto.setVisible(false);

        textoQuantidade.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoQuantidade.setText("0");
        textoQuantidade.setMargin(new java.awt.Insets(2, 10, 2, 2));

        labelQuantidade.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelQuantidade.setText("Quantidade:");

        botaoSalvarQuantidade.setBackground(new java.awt.Color(0, 0, 238));
        botaoSalvarQuantidade.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        botaoSalvarQuantidade.setForeground(new java.awt.Color(255, 255, 255));
        botaoSalvarQuantidade.setText("Salvar");
        botaoSalvarQuantidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoSalvarQuantidadeMouseClicked(evt);
            }
        });

        botaoExcluirProduto.setBackground(new java.awt.Color(0, 0, 238));
        botaoExcluirProduto.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        botaoExcluirProduto.setForeground(new java.awt.Color(255, 255, 255));
        botaoExcluirProduto.setText("Excluir Produto");
        botaoExcluirProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoExcluirProdutoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout configuracoesProdutoLayout = new javax.swing.GroupLayout(configuracoesProduto);
        configuracoesProduto.setLayout(configuracoesProdutoLayout);
        configuracoesProdutoLayout.setHorizontalGroup(
            configuracoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configuracoesProdutoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(configuracoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelQuantidade)
                    .addComponent(textoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSalvarQuantidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configuracoesProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoExcluirProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        configuracoesProdutoLayout.setVerticalGroup(
            configuracoesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configuracoesProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelQuantidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSalvarQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addComponent(botaoExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelListaProdutos.add(configuracoesProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 1, 222, 350));

        painelCarrinhoVazio.setBackground(new java.awt.Color(255, 255, 255));
        painelCarrinhoVazio.setVisible(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrinhoVazio.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 238));
        jLabel2.setText("<html>\n<h1> Seu carrinho de compras está vazio! </h1>\n</html>");

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("<html>\n<h3> Para adicionar produtos ao seu carrinho, navegue pela loja. Quando encontrar os itens desejados clique no botão FINALIZAR COMPRA. </h3>\n</html>");

        javax.swing.GroupLayout painelCarrinhoVazioLayout = new javax.swing.GroupLayout(painelCarrinhoVazio);
        painelCarrinhoVazio.setLayout(painelCarrinhoVazioLayout);
        painelCarrinhoVazioLayout.setHorizontalGroup(
            painelCarrinhoVazioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCarrinhoVazioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(painelCarrinhoVazioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelCarrinhoVazioLayout.setVerticalGroup(
            painelCarrinhoVazioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCarrinhoVazioLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(painelCarrinhoVazioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelCarrinhoVazioLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(71, 71, 71))
        );

        painelListaProdutos.add(painelCarrinhoVazio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 3, 790, 335));

        painelTelaCarrinho.add(painelListaProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 810, 355));

        painelCalculaFrete.setBackground(new java.awt.Color(255, 255, 255));
        painelCalculaFrete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 238)));
        painelCalculaFrete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelCep.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelCep.setText("Calcule frete e prazo");
        painelCalculaFrete.add(labelCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, -1, 31));

        try {
            textoCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        painelCalculaFrete.add(textoCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 13, 139, 30));

        botaoCalculaFrete.setBackground(new java.awt.Color(0, 0, 238));
        botaoCalculaFrete.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        botaoCalculaFrete.setForeground(new java.awt.Color(255, 255, 255));
        botaoCalculaFrete.setText("Calcular");
        botaoCalculaFrete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoCalculaFreteMouseClicked(evt);
            }
        });
        painelCalculaFrete.add(botaoCalculaFrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 12, -1, 30));

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

        labelFreteSedex.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        labelFreteSedex.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        labelPrazoPAC.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        labelPrazoPAC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        labelPrazoSedex.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        labelPrazoSedex.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

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
                            .addComponent(labelFreteSedex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelFretePAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMostraFreteLayout.createSequentialGroup()
                        .addComponent(labelPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                .addGroup(painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelPAC)
                        .addComponent(labelPrazoPAC))
                    .addComponent(labelFretePAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPrazoSedex, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelMostraFreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelSedex)
                        .addComponent(labelFreteSedex)))
                .addGap(0, 35, Short.MAX_VALUE))
        );

        painelCalculaFrete.add(painelMostraFrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 49, 357, -1));
        painelMostraFrete.setVisible(false);

        painelEnvio.setBackground(new java.awt.Color(255, 255, 255));
        painelEnvio.setVisible(false);

        labelCidadeEnvio.setFont(new java.awt.Font("Leelawadee UI", 1, 11)); // NOI18N
        labelCidadeEnvio.setText("Cidade de envio:");

        cidadeEnvio.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        cidadeEnvio.setText("Santa Rita do Sapucaí - MG");

        tipoEnvio.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        tipoEnvio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Envio", "PAC", "Sedex" }));
        tipoEnvio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoEnvioItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout painelEnvioLayout = new javax.swing.GroupLayout(painelEnvio);
        painelEnvio.setLayout(painelEnvioLayout);
        painelEnvioLayout.setHorizontalGroup(
            painelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEnvioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCidadeEnvio)
                    .addComponent(cidadeEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        painelEnvioLayout.setVerticalGroup(
            painelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEnvioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tipoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelEnvioLayout.createSequentialGroup()
                        .addComponent(labelCidadeEnvio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cidadeEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelCalculaFrete.add(painelEnvio, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 49, -1, 109));

        painelTelaCarrinho.add(painelCalculaFrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 810, 183));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelTelaCarrinho, javax.swing.GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelTelaCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoFinalizarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoFinalizarCompraMouseClicked
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        boolean achou = false;
        // Validação para finalizar a compra - Verifica se a loja possui a quantidade de produtos exigida pelo cliente. 
        for (Produto listaDeProdutos : carrinhoUsuario.getListaDeProduto()) {
            if (listaDeProdutos.getQuantidadeCompra() > listaDeProdutos.getQuantidade()) {
                new TelaAlerta("O " + listaDeProdutos.getTipo() + listaDeProdutos.getMarca() + 
                        " não possui " + listaDeProdutos.getQuantidadeCompra() + " unidade(s)!", 2).setVisible(true);
                achou = true;
            }
        }
        //Validação para finalizar a compra - Verifica se o usuário selecionou um tipo de envio. 
        if (tipoEnvio.getSelectedIndex() == 0 && achou == false) {
            achou = true;
            new TelaAlerta("Por favor! Selecione o tipo de envio.", 2).setVisible(true);
        }
        // Finalização a compra 
        if (achou == false) {
            FinalizarCompra compraFinal = null;
            if (tipoEnvio.getSelectedIndex() == 1) {
                FinalizarCompra fc = new FinalizarCompra(precoTotal.getText(), tipoEnvio.getSelectedItem().toString(),
                        prazoPAC, fretePAC);
                compraFinal = fc;

            } else if (tipoEnvio.getSelectedIndex() == 2) {
                FinalizarCompra fc = new FinalizarCompra(precoTotal.getText(), tipoEnvio.getSelectedItem().toString(),
                        prazoSEDEX, freteSEDEX);
                compraFinal = fc;
            }

            if (compraFinal != null) {
                TelaComprar telaComprar = new TelaComprar(carrinhoUsuario.getListaDeProduto(), usuarioOnline, compraFinal);
                telaComprar.setVisible(true);
            }
        }
        telaPrincipalThis.hideComponents(); // Oculta todas as listas dropdowns do menu
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botaoFinalizarCompraMouseClicked

    private void botaoContinuarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoContinuarCompraMouseClicked
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
            // Abrindo a Tela Home para continuar com a compra
            InternalTelaHome telaHome = new InternalTelaHome(usuarioOnline, layoutPrincipal, telaPrincipalThis);
            telaHome.show();
            ((BasicInternalFrameUI) telaHome.getUI()).setNorthPane(null); // TIRANDO A PARTE SUPERIOR DO JInternalFrame
            layoutPrincipal.removeAll();
            layoutPrincipal.add(telaHome);
            layoutPrincipal.repaint();
            layoutPrincipal.revalidate();
        }
        telaPrincipalThis.hideComponents(); // Oculta todas as listas dropdowns do menu
    }//GEN-LAST:event_botaoContinuarCompraMouseClicked

    boolean excluindo = false;
    private void botaoExcluirProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoExcluirProdutoMouseClicked
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Exclui o produto do carrinho caso o botão EXCLUIR seja cliclado. 
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        excluindo = carrinhoDAO.deletarProdutoCarrinho(usuarioOnline,
                carrinhoUsuario.getListaDeProduto().get(listProduto.getSelectedIndex()));

        if (excluindo == true) {
            model.removeElementAt(listProduto.getSelectedIndex());
            configuracoesProduto.setVisible(false);
            calculaPrecoProduto();
        }
        // Garantindo que o usuario calcule o frete novamente com as novas quantidades de produtos
        painelEnvio.setVisible(false);
        precoFrete.setText("Selecione um CEP no painel abaixo");
        labelFreteSelecionado.setText("Frete (não selecionado)");
        tipoEnvio.setSelectedIndex(0);

        telaPrincipalThis.hideComponents(); // Oculta todas as listas dropdowns do menu
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botaoExcluirProdutoMouseClicked

    private void botaoSalvarQuantidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSalvarQuantidadeMouseClicked
        //Validação da quantidade de produtos digitada, aceita apenas números 
        if (textoQuantidade.getText().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
            new TelaAlerta("Por favor! Digite uma quantidade válida para o produto.", 2).setVisible(true);
        } else {
            try {
                layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                String quantidade = textoQuantidade.getText();
                int quantidadeInt = Integer.parseInt(quantidade.replaceAll("[^0-9]", ""));

                CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
                carrinhoDAO.alterarProdutoCarrinho(usuarioOnline,
                        carrinhoUsuario.getListaDeProduto().get(listProduto.getSelectedIndex()), quantidadeInt);

                calculaPrecoProduto();

            } catch (Exception e) {
                new TelaAlerta("Por favor! Digite uma quantidade válida para o produto.", 2).setVisible(true);               
            }
            // Garantindo que o usuario calcule o frete novamente com as novas quantidades de produtos
            painelEnvio.setVisible(false);
            precoFrete.setText("Selecione um CEP no painel abaixo");
            labelFreteSelecionado.setText("Frete (não selecionado)");
            tipoEnvio.setSelectedIndex(0);

            telaPrincipalThis.hideComponents(); // Oculta todas as listas dropdowns do menu
            layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        }
    }//GEN-LAST:event_botaoSalvarQuantidadeMouseClicked

    private void botaoCalculaFreteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCalculaFreteMouseClicked
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Webservicecep ws = new Webservicecep(); // Insanciando classe Webservecep para guardar informacoes do cep buscado
        BuscaCep buscandoCep = new BuscaCep(); // Instanciando classe BuscaCep para buscar a cidade e estado do cep inserido
        try {
            ws = BuscaCep.getEndereco(textoCep.getText()); // Guardando informacoes do cep inserido no objeto ws
        } catch (JAXBException ex) {
            System.out.println("Erro = " + ex);
        } catch (MalformedURLException ex) {
            System.out.println("Erro = " + ex);
        }
        //Validação do CEP - Caso seja válido retorna "0". 
        if (!"0".equals(ws.getResultado())) {
            if (quantidadeTotal <= 24) {
                calculaPrecoFrete();

                painelMostraFrete.setVisible(true);
                painelEnvio.setVisible(true);
                cidadeEnvio.setText(ws.getCidade() + " - " + ws.getUf());
                tipoEnvio.setSelectedIndex(0);
            }else{
                new TelaAlerta("A quantidade do produto ultrapassou o limite permitido pelos correios!", 2).setVisible(true);
            }
        } else {
            new TelaAlerta("Por favor! Digite um CEP válido.", 2).setVisible(true);
        }
        telaPrincipalThis.hideComponents(); // Oculta todas as listas dropdowns do menu
        layoutPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_botaoCalculaFreteMouseClicked

    private void tipoEnvioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoEnvioItemStateChanged
        float totalCompra = 0;

        if (tipoEnvio.getSelectedIndex() == 0) {
            labelFreteSelecionado.setText("Frete (Não selecionado)");
        } else if (tipoEnvio.getSelectedIndex() == 1) {
            //calculaPrecoProduto();
            precoFrete.setText("R$ " + fretePAC.replace(",", "."));
            totalCompra = total + Float.parseFloat(fretePAC.replace(",", "."));
            precoTotal.setText("R$ " + String.valueOf(totalCompra));
            labelFreteSelecionado.setText("Frete (" + tipoEnvio.getSelectedItem() + ")");

        } else if (tipoEnvio.getSelectedIndex() == 2) {
            //calculaPrecoProduto();
            precoFrete.setText("R$ " + freteSEDEX.replace(",", "."));
            totalCompra = total + Float.parseFloat(freteSEDEX.replace(",", "."));
            precoTotal.setText("R$ " + String.valueOf(totalCompra));
            labelFreteSelecionado.setText("Frete (" + tipoEnvio.getSelectedItem() + ")");
        }
        telaPrincipalThis.hideComponents(); // Oculta todas as listas dropdowns do menu
    }//GEN-LAST:event_tipoEnvioItemStateChanged

    private void painelListaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelListaProdutosMouseClicked
        telaPrincipalThis.hideComponents(); // Oculta todas as listas dropdowns do menu
    }//GEN-LAST:event_painelListaProdutosMouseClicked

    private void listProdutoValueChanged(javax.swing.event.ListSelectionEvent evt) {
        if (excluindo == false) {
            String quantidade = String.valueOf(carrinhoUsuario.getListaDeProduto().get(listProduto.getSelectedIndex()).getQuantidadeCompra());
            textoQuantidade.setText(quantidade);

            configuracoesProduto.setVisible(true);
        } else {
            excluindo = false;
        }

        telaPrincipalThis.hideComponents(); // Oculta todas as listas dropdowns do menu
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCalculaFrete;
    private javax.swing.JButton botaoContinuarCompra;
    private javax.swing.JButton botaoExcluirProduto;
    private javax.swing.JButton botaoFinalizarCompra;
    private javax.swing.JButton botaoSalvarQuantidade;
    private javax.swing.JLabel cidadeEnvio;
    private javax.swing.JPanel configuracoesProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelCep;
    private javax.swing.JLabel labelCidadeEnvio;
    private javax.swing.JLabel labelEntrega;
    private javax.swing.JLabel labelFrete;
    private javax.swing.JLabel labelFretePAC;
    private javax.swing.JLabel labelFreteSedex;
    private javax.swing.JLabel labelFreteSelecionado;
    private javax.swing.JLabel labelPAC;
    private javax.swing.JLabel labelPrazo;
    private javax.swing.JLabel labelPrazoPAC;
    private javax.swing.JLabel labelPrazoSedex;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JLabel labelSedex;
    private javax.swing.JLabel labelSubTotal;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JPanel listaProdutos;
    private javax.swing.JPanel painelCalculaFrete;
    private javax.swing.JPanel painelCarrinhoVazio;
    private javax.swing.JPanel painelEnvio;
    private javax.swing.JPanel painelListaProdutos;
    private javax.swing.JPanel painelMostraFrete;
    private javax.swing.JPanel painelTelaCarrinho;
    private javax.swing.JPanel painelTotalProdutos;
    private javax.swing.JLabel precoFrete;
    private javax.swing.JLabel precoProduto;
    private javax.swing.JLabel precoTotal;
    private javax.swing.JFormattedTextField textoCep;
    private javax.swing.JTextField textoQuantidade;
    private javax.swing.JComboBox<String> tipoEnvio;
    // End of variables declaration//GEN-END:variables
}
