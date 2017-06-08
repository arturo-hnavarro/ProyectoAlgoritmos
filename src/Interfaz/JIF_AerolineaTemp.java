/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import TDA.lista.ListaException;
import dominio.Aerolinea;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import logica.AerolineaData;

/**
 *
 * @author Arturo
 */
public class JIF_AerolineaTemp extends javax.swing.JInternalFrame {

    JIF_AgregaAerolineaTemp jIF_AgregaAerolinea;
    AerolineaData aerolineaData;
    public static DefaultTableModel DTM_listado;

    public JIF_AerolineaTemp() {
        initComponents();
        try {
            aerolineaData = new AerolineaData("aerolineas.dat");
        } catch (IOException | ClassNotFoundException | ListaException ex) {
            Logger.getLogger(JIF_AerolineaTemp.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            jIF_AgregaAerolinea = new JIF_AgregaAerolineaTemp();
        } catch (IOException | ClassNotFoundException | ListaException ex) {
            Logger.getLogger(JIF_AerolineaTemp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaAgencias = new javax.swing.JTable();
        JBN_Agregar = new javax.swing.JButton();
        JBN_Modificar = new javax.swing.JButton();
        JBN_Eliminar = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);

        jTableListaAgencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Sitio web", "Teléfonos", "Contactenos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableListaAgencias);
        if (jTableListaAgencias.getColumnModel().getColumnCount() > 0) {
            jTableListaAgencias.getColumnModel().getColumn(0).setResizable(false);
        }

        JBN_Agregar.setText("Agregar");
        JBN_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBN_AgregarActionPerformed(evt);
            }
        });

        JBN_Modificar.setText("Modificar");
        JBN_Modificar.setToolTipText("Posicionese sobre la celda que desea modificar y luego presione modificar.");
        JBN_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBN_ModificarActionPerformed(evt);
            }
        });

        JBN_Eliminar.setText("Eliminar");
        JBN_Eliminar.setToolTipText("Posicionese sobre la celda que desea eliminar y luego presione eliminar.");
        JBN_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBN_EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(JBN_Agregar)
                        .addGap(29, 29, 29)
                        .addComponent(JBN_Modificar)
                        .addGap(41, 41, 41)
                        .addComponent(JBN_Eliminar)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBN_Agregar)
                    .addComponent(JBN_Modificar)
                    .addComponent(JBN_Eliminar))
                .addGap(0, 147, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBN_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBN_AgregarActionPerformed

        if (!jIF_AgregaAerolinea.isVisible()) {
            jIF_AgregaAerolinea.setVisible(true);
            JIF_Administrador.DesktopAdministrador.add(jIF_AgregaAerolinea);
        }
        jIF_AgregaAerolinea.toFront();
    }//GEN-LAST:event_JBN_AgregarActionPerformed

    private void JBN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBN_ModificarActionPerformed
        int codigo = Integer.parseInt((String) jTableListaAgencias.getValueAt(jTableListaAgencias.getSelectedRow(), 0));
        
        String nuevoNombre = (String) jTableListaAgencias.getValueAt(jTableListaAgencias.getSelectedRow(), 1);
        String nuevoSitioWeb = (String) jTableListaAgencias.getValueAt(jTableListaAgencias.getSelectedRow(), 2);
        String nuevoTelefonos = (String) jTableListaAgencias.getValueAt(jTableListaAgencias.getSelectedRow(), 3);
        String nuevoContactenos = (String) jTableListaAgencias.getValueAt(jTableListaAgencias.getSelectedRow(), 4);
        Aerolinea aerolineaNueva = new Aerolinea(codigo, nuevoNombre, nuevoSitioWeb, nuevoTelefonos, nuevoContactenos);
        try {
            aerolineaData.modificarAerolinea(aerolineaNueva, codigo);
        } catch (ListaException ex) {
            Logger.getLogger(JIF_AerolineaTemp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JIF_AerolineaTemp.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizarTabla();
    }//GEN-LAST:event_JBN_ModificarActionPerformed

    private void JBN_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBN_EliminarActionPerformed
        int codigo = Integer.parseInt((String) jTableListaAgencias.getValueAt(jTableListaAgencias.getSelectedRow(), 0));
        
        String nuevoNombre = (String) jTableListaAgencias.getValueAt(jTableListaAgencias.getSelectedRow(), 1);
        String nuevoSitioWeb = (String) jTableListaAgencias.getValueAt(jTableListaAgencias.getSelectedRow(), 2);
        String nuevoTelefonos = (String) jTableListaAgencias.getValueAt(jTableListaAgencias.getSelectedRow(), 3);
        String nuevoContactenos = (String) jTableListaAgencias.getValueAt(jTableListaAgencias.getSelectedRow(), 4);
        Aerolinea aerolinea = new Aerolinea(codigo, nuevoNombre, nuevoSitioWeb, nuevoTelefonos, nuevoContactenos);
        
        try {
            aerolineaData.eliminarAerolinea(aerolinea);
        } catch (ListaException ex) {
            Logger.getLogger(JIF_AerolineaTemp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JIF_AerolineaTemp.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizarTabla();
    }//GEN-LAST:event_JBN_EliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBN_Agregar;
    private javax.swing.JButton JBN_Eliminar;
    private javax.swing.JButton JBN_Modificar;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableListaAgencias;
    // End of variables declaration//GEN-END:variables
     //Metodos utilitarios
    private void actualizarTabla(){
         //Actualizo la información de la tabla
        //Almacena los datos de la ListaEnlazada en un arreglo para que pueda ser mostrado en la tabla
        String datos[][] = null;
        try {
            datos = aerolineaData.getMostrarAerolineas();
        } catch (ListaException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(JIF_Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Establesco la cabezera de la tabla
        String columnas[] = {"Código", "Nombre", "Sitio web", "Teléfono(s)", "Contáctenos"};
        //Le envio al contenido de la tabla estatica en el JInternalFrame
        JIF_AerolineaTemp.DTM_listado = new DefaultTableModel(datos, columnas);
        //Muestro el contenido en la tabla
        JIF_AerolineaTemp.jTableListaAgencias.setModel(JIF_AerolineaTemp.DTM_listado);
    }
    
}
