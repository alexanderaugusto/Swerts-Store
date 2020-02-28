package br.inatel.swertsstore.util;

/*
    *** CLASSE Renderer List ***

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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

public class RendererList extends JPanel implements ListCellRenderer<Produto> {

    private JLabel lbImage = new JLabel();
    private JLabel lbDescricao = new JLabel();
    private JLabel lbPreco = new JLabel();
    private JPanel panelText;
    private JPanel panelIcon;

    public RendererList() {
        setLayout(new BorderLayout(5, 5));

        panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(lbDescricao);
        panelText.add(lbPreco);

        panelIcon = new JPanel();
        panelIcon.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelIcon.add(lbImage);

        add(panelIcon, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Produto> list,
            Produto produto, int index, boolean isSelected, boolean cellHasFocus) {

        // Variaveis auxiliares para pegar a imagem do produto
        BufferedImage imagemBuffer = null;
        imagemBuffer = null;

        try {
            // Pegando a imagem na lista de produtos
            imagemBuffer = ImageIO.read(new ByteArrayInputStream(produto.getImagem()));
        } catch (IOException ex) {
            new TelaAlerta("Ocorreu um erro ao carregar as imagens! Por favor, tentar novamente.", 2).setVisible(true);
        }
        Image diminuirImagem = imagemBuffer.getScaledInstance(70, 70, 0); // Redimencionando a imagem para o tamanho do jLabel
        
        lbImage.setIcon(new ImageIcon(diminuirImagem));
        lbDescricao.setText(produto.getTitulo());
        lbPreco.setText("R$ " + String.valueOf(produto.getPreco()));
        lbPreco.setForeground(new Color(0, 0, 238));

        // set Opaque to change background color of JLabel
        lbDescricao.setOpaque(true);
        lbPreco.setOpaque(true);
        lbImage.setOpaque(true);
        lbPreco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPreco.setBorder(new EmptyBorder(0, 0, 0, 0));

        // when select item
        if (isSelected) {
            lbDescricao.setBackground(list.getSelectionBackground());
            lbPreco.setBackground(list.getSelectionBackground());
            lbImage.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
            panelIcon.setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbDescricao.setBackground(list.getBackground());
            lbPreco.setBackground(list.getBackground());
            lbImage.setBackground(list.getBackground());
            setBackground(list.getBackground());
            panelIcon.setBackground(list.getBackground());
        }
        return this;
    }
}
