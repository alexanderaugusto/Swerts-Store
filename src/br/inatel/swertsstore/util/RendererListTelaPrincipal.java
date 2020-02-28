package br.inatel.swertsstore.util;

/*
    *** CLASSE Renderer List Tela Principal ***

Objetivo: . 

 */
import br.inatel.swertsstore.model.Produto;
import br.inatel.swertsstore.view.TelaAlerta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class RendererListTelaPrincipal extends JPanel implements ListCellRenderer<Produto> {

    private JLabel lbIcone = new JLabel();
    private JLabel lbNome = new JLabel();
    private JLabel lbValor = new JLabel();
    private JLabel lbQuantidade = new JLabel();
    private JPanel panelText;
    private JPanel panelIcon;
    private JPanel panelPreco;

    public RendererListTelaPrincipal() {
        setLayout(new BorderLayout(5, 5));

        panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(lbNome);
        panelText.add(lbQuantidade);
        Border borda = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
        panelText.setBorder(borda);

        panelIcon = new JPanel();
        panelIcon.setBorder(new EmptyBorder(0, 0, 0, 0));
        panelIcon.add(lbIcone);
        panelIcon.setBorder(borda);

        panelPreco = new JPanel(new GridLayout(0, 1));
        panelPreco.add(lbValor);
        panelPreco.setBorder(borda);

        add(panelIcon, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
        add(panelPreco, BorderLayout.EAST);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Produto> list, Produto produto, int index, boolean isSelected,
            boolean cellHasFocus) {

// Variaveis auxiliares para pegar a imagem do produto
        BufferedImage imagemBuffer = null;
        imagemBuffer = null;

        try {
            // Pegando a imagem na lista de produtos
            imagemBuffer = ImageIO.read(new ByteArrayInputStream(produto.getImagem()));
        } catch (IOException ex) {
            new TelaAlerta("Ocorreu um erro ao carregar as imagens! Por favor, tentar novamente.", 2).setVisible(true);
        }
        Image diminuirImagem = imagemBuffer.getScaledInstance(150, 125, 0); // Redimencionando a imagem para o tamanho do jLabel

        lbIcone.setIcon(new ImageIcon(diminuirImagem));
        lbNome.setText("    " + produto.getTitulo());
        if (produto.getQuantidade() == 1) {
            lbQuantidade.setText("    " + produto.getQuantidade() + " produto disponível");
        } else {
            lbQuantidade.setText("    " + produto.getQuantidade() + " produtos disponíveis");
        }
        lbValor.setText("    R$ " + String.valueOf(produto.getPreco()) + "    ");
        lbValor.setForeground(new Color(0, 100, 0));

        lbNome.setOpaque(true);
        lbValor.setOpaque(true);
        lbQuantidade.setOpaque(true);
        lbIcone.setOpaque(true);

        if (isSelected) {
            lbNome.setBackground(list.getSelectionBackground());
            lbValor.setBackground(list.getSelectionBackground());
            lbQuantidade.setBackground(list.getSelectionBackground());
            lbIcone.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
            panelIcon.setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbNome.setBackground(list.getBackground());
            lbValor.setBackground(list.getBackground());
            lbQuantidade.setBackground(list.getBackground());
            lbIcone.setBackground(list.getBackground());
            setBackground(list.getBackground());
            panelIcon.setBackground(list.getBackground());
        }
        return this;
    }

}
