package br.inatel.swertsstore.util;
/*
    *** CLASSE PRODUTO TABLE MODEL  ***

*/

import br.inatel.swertsstore.model.Compras;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

//Classe filha da classe AbstractTabelModel 
public class ProdutoTableModel extends AbstractTableModel {
    
    // Lista do tipo compras 
    private List<Compras> dados = new ArrayList<>();
    //Determinando colunas da tabela 
    private String[] colunas = {"Código","Produto","Quantidade", "Preço", "Cliente", "Data"};

    //Sobrescreve os métodos da classe mãe
    @Override
    public String getColumnName(int column) {
        return colunas[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return dados.get(linha).getCodigo();
            case 1:
                return dados.get(linha).getTipo();
            case 2:
                return dados.get(linha).getQuantidade();
            case 3:
                return dados.get(linha).getPreco();
            case 4:
                return dados.get(linha).getNomeUsuario();
            case 5:
                return dados.get(linha).getDataCompra();
        }

        return null;

    }
    
    //Adiciona uma linha na tabela.
    public void addRow(Compras estoque) {
        this.dados.add(estoque);
        this.fireTableDataChanged();
    }
    //Remove uma linha na tabela.
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

}
