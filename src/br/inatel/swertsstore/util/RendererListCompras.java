package br.inatel.swertsstore.util;

import br.inatel.swertsstore.model.Compras;
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


public class RendererListCompras extends JPanel implements ListCellRenderer<Compras> {

    private JLabel lbIcone = new JLabel();
    private JLabel lbTitulo = new JLabel();
    private JLabel lbData = new JLabel();
    private JLabel lbPreco = new JLabel();
    private JPanel panelText;
    private JPanel panelIcon;
     private JPanel panelPreco;

    public RendererListCompras() {
        setLayout(new BorderLayout(5, 5));

        panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(lbTitulo);
        panelText.add(lbPreco);
        Border borda = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
        panelText.setBorder(borda);

        panelIcon = new JPanel();
        panelIcon.setBorder(new EmptyBorder(0, 0, 0, 0));
        panelIcon.add(lbIcone);
        panelIcon.setBorder(borda);
        
        panelPreco = new JPanel(new GridLayout(0,1));
        panelPreco.add(lbData);
        panelPreco.setBorder(borda);
        

        add(panelIcon, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
        add(panelPreco, BorderLayout.EAST);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Compras> list, Compras produto, int index, boolean isSelected, 
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
        lbTitulo.setText("    " + produto.getTitulo());
        lbPreco.setText("    R$ " + String.valueOf(produto.getPreco()));

        lbData.setText("    " + produto.getDataCompra() + "    ");
        lbData.setForeground(new Color(139, 26, 26));

        lbTitulo.setOpaque(true);
        lbData.setOpaque(true);
        lbPreco.setOpaque(true);
        lbIcone.setOpaque(true);

        return this;
    }

}
