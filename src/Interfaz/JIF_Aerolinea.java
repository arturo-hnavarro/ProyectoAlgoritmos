/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Archivos.Archivos;
import TDA.lista.ListaEnlazada;
import TDA.lista.ListaException;
import java.awt.Dimension;
import java.io.File;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Logica.TableCellRendererColor;

public class JIF_Aerolinea extends javax.swing.JFrame implements Serializable {

    private DefaultTableModel modelo;
    TableCellRendererColor estado = new TableCellRendererColor(1, 2, 3, 4, -1, -1, -1);

    ListaEnlazada lista;
    dominio.Aerolinea aero;
    Archivos a;
    Object arreglo[];
    File f;

    /**
     * Creates new form Aerolinea
     */
    public JIF_Aerolinea() {
        setVisible(true);
        this.setTitle("Aerolíneas");

        initComponents();
        this.setMinimumSize(new Dimension(fondo.getWidth(), fondo.getHeight()));
        this.setResizable(false);
        lista = new ListaEnlazada();
        f = new File("aerolineas.dat");
        a = new Archivos();
        IniciarComponentes();

        tableroAerolinea.setModel(modelo);

    }

    public void IniciarComponentes() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Sitio Web");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Contáctenos");

        arreglo = new Object[5];
        if (!f.exists()) {

        } else {
            mostrarAerolineas();
        }
    }

    public void mostrarAerolineas() {

        try {
            reseteo();
            ListaEnlazada usuario = (ListaEnlazada) a.leerArchivo("aerolineas.dat");
            for (int i = 1; i <= usuario.getSize(); i++) {
                dominio.Aerolinea u = (dominio.Aerolinea) usuario.getNodo(i).elemento;
                arreglo[0] = u.getCodigo();
                arreglo[1] = u.getNombre();
                arreglo[2] = u.getSitioWeb();
                arreglo[3] = u.getTelefono();
                arreglo[4] = u.getCorreo();

                tableroAerolinea.setDefaultRenderer(Object.class, estado);

                modelo.addRow(arreglo);

            }
        } catch (ListaException ex) {
            Logger.getLogger(JIF_Aerolinea.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void reseteo() {
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }

    }

    public void Modifica() throws TDA.lista.ListaException {
        ListaEnlazada lista = new ListaEnlazada();
        ListaEnlazada aero = (ListaEnlazada) a.leerArchivo("aerolineas.dat");
        int filas = tableroAerolinea.getRowCount();
        for (int i = 1; i <= filas; i++) {
            dominio.Aerolinea ae = (dominio.Aerolinea) aero.getNodo(i).elemento;
            
            String nombre = tableroAerolinea.getValueAt(i - 1, 1).toString();
            String sitio = tableroAerolinea.getValueAt(i - 1, 2).toString();
            String telef = tableroAerolinea.getValueAt(i - 1, 3).toString();
            String correo = tableroAerolinea.getValueAt(i - 1, 4).toString();

            lista.insertar(new dominio.Aerolinea(ae.getCodigo(), nombre, sitio, telef, correo));

        }
        a.escribirArchivo(lista, "aerolineas.dat");

    }

    public void eliminar() throws TDA.lista.ListaException {
        ListaEnlazada lista = new ListaEnlazada();
        int filaE = tableroAerolinea.getSelectedRow();
        int resp;
        if (filaE == -1) {
            JOptionPane.showMessageDialog(null, "No hay fila seleccionada para Eliminar");
        } else {
            resp = JOptionPane.showConfirmDialog(null, "Estas Seguro de eliminar este elemento?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {

                modelo.removeRow(filaE);
                ListaEnlazada ae = (ListaEnlazada) a.leerArchivo("aerolineas.dat");
                if (filaE + 1 > 1) {

                    for (int i = 1; i <= ae.getSize(); i++) {
                        dominio.Aerolinea aer = (dominio.Aerolinea) ae.getNodo(i).elemento;

                        if (filaE + 1 != i) {

                            lista.insertar(new dominio.Aerolinea((short) i, aer.getNombre(), aer.getSitioWeb(), aer.getCorreo(), aer.getTelefono()));
                        }
                    }

                    a.escribirArchivo(lista, "aerolineas.dat");
                }
                if (filaE + 1 == 1 && modelo.getRowCount() > 0) {
                    for (int i = 2; i <= ae.getSize(); i++) {
                        dominio.Aerolinea aer = (dominio.Aerolinea) ae.getNodo(i).elemento;

                        lista.insertar(new dominio.Aerolinea((short) i, aer.getNombre(), aer.getSitioWeb(), aer.getCorreo(), aer.getTelefono()));

                    }

                    a.escribirArchivo(lista, "aerolineas.dat");
                }
                if (filaE + 1 == 1 && modelo.getRowCount() == 0) {
                    f.delete();
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableroAerolinea = new javax.swing.JTable();
        JB_agregar = new javax.swing.JButton();
        JB_eliminar = new javax.swing.JButton();
        JB_modificar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tableroAerolinea.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tableroAerolinea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableroAerolinea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(50, 60, 650, 230);

        JB_agregar.setBackground(new java.awt.Color(153, 153, 153));
        JB_agregar.setText("Agregar ");
        JB_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(JB_agregar);
        JB_agregar.setBounds(120, 330, 110, 30);

        JB_eliminar.setBackground(new java.awt.Color(153, 153, 153));
        JB_eliminar.setText("Eliminar");
        JB_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(JB_eliminar);
        JB_eliminar.setBounds(320, 330, 90, 30);

        JB_modificar.setBackground(new java.awt.Color(153, 153, 153));
        JB_modificar.setText("Modificar");
        JB_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(JB_modificar);
        JB_modificar.setBounds(520, 330, 90, 30);
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 740, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_agregarActionPerformed
        JIF_AgregaAerolinea agregaAerolinea = new JIF_AgregaAerolinea();
        agregaAerolinea.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_JB_agregarActionPerformed

    private void JB_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_eliminarActionPerformed
        try {
            eliminar();
        } catch (ListaException ex) {
            Logger.getLogger(JIF_Aerolinea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JB_eliminarActionPerformed

    private void JB_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_modificarActionPerformed
        try {
            Modifica();
        } catch (ListaException ex) {
            Logger.getLogger(JIF_Aerolinea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JB_modificarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(JIF_Aerolinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JIF_Aerolinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JIF_Aerolinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JIF_Aerolinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JIF_Aerolinea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_agregar;
    private javax.swing.JButton JB_eliminar;
    private javax.swing.JButton JB_modificar;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableroAerolinea;
    // End of variables declaration//GEN-END:variables
}
