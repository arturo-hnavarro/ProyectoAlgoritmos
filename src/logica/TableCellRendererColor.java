/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class TableCellRendererColor extends DefaultTableCellRenderer {

    private int valor;
    private int valor1;
    private int valor2;
    private int valor3;
    private int valor4;
    private int valor5;
    private int valor6;

    public TableCellRendererColor(int valor, int valor1, int valor2, int valor3, int valor4, int valor5, int valor6) {
        this.valor = valor;
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3;
        this.valor4 = valor4;
        this.valor5 = valor5;
        this.valor6 = valor6;

    }

    private Component componente;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground(Color.white);
        table.setForeground(Color.black);
        componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (valor != -1) {
            if (!Utilidades.validaTexto((String) table.getValueAt(row, valor))) {
                componente.setBackground(Color.white);
            }
        }

        if (valor2 != -1) {
            if (!Utilidades.validaNumero((String) table.getValueAt(row, valor2))) {
                componente.setBackground(Color.white);
            }
        }
        if (valor4 != -1) {
            if (!Utilidades.validaTextoNumero((String) table.getValueAt(row, valor4))) {
                componente.setBackground(Color.white);
            }
        }
        if (valor5 != -1) {
            if (!Utilidades.validaTexto((String) table.getValueAt(row, valor5))) {
                componente.setBackground(Color.white);
            }
        }
        if (valor6 != -1) {
            if (!Utilidades.validaTextoNumero((String) table.getValueAt(row, valor6))) {
                componente.setBackground(Color.white);
            }
        }

        return componente;
    }
}
