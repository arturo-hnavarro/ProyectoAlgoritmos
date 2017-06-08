/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica.Utilidades;
import TDA.lista.ListaException;
import dominio.Aerolinea;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import logica.AerolineaData;

/**
 *
 * @author Arturo
 */
public class JIF_AgregaAerolineaTemp extends javax.swing.JInternalFrame {

    AerolineaData aerolineaData;

    public JIF_AgregaAerolineaTemp() throws IOException, ClassNotFoundException, ListaException {
        initComponents();
        aerolineaData = new AerolineaData("aerolineas.dat");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jL_Nombre = new javax.swing.JLabel();
        jL_SitioWeb = new javax.swing.JLabel();
        jL_Telefonos = new javax.swing.JLabel();
        jL_Contactenos = new javax.swing.JLabel();
        jBtn_Agregar = new javax.swing.JButton();
        jBtn_Cancelar = new javax.swing.JButton();
        jTF_Nombre = new javax.swing.JTextField();
        jTF_SitioWeb = new javax.swing.JTextField();
        jTF_Telefonos = new javax.swing.JTextField();
        jTF_Contactenos = new javax.swing.JTextField();
        jL_mensajeAgregada = new javax.swing.JLabel();

        jL_Nombre.setText("Nombre");

        jL_SitioWeb.setText("Sitio web");

        jL_Telefonos.setText("Teléfonos(s)");

        jL_Contactenos.setText("Contáctenos");

        jBtn_Agregar.setText("Agregar");
        jBtn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_AgregarActionPerformed(evt);
            }
        });

        jBtn_Cancelar.setText("Cancelar");
        jBtn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_CancelarActionPerformed(evt);
            }
        });

        jL_mensajeAgregada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jL_mensajeAgregada.setForeground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jL_Nombre)
                            .addComponent(jL_SitioWeb)
                            .addComponent(jL_Telefonos)
                            .addComponent(jL_Contactenos))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTF_Nombre)
                            .addComponent(jTF_SitioWeb)
                            .addComponent(jTF_Telefonos)
                            .addComponent(jTF_Contactenos, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jBtn_Agregar)
                        .addGap(30, 30, 30)
                        .addComponent(jBtn_Cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jL_mensajeAgregada)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_Nombre)
                    .addComponent(jTF_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_SitioWeb)
                    .addComponent(jTF_SitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_Telefonos)
                    .addComponent(jTF_Telefonos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_Contactenos)
                    .addComponent(jTF_Contactenos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn_Agregar)
                    .addComponent(jBtn_Cancelar))
                .addGap(18, 18, 18)
                .addComponent(jL_mensajeAgregada)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jL_mensajeAgregada.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtn_CancelarActionPerformed

    private void jBtn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_AgregarActionPerformed
        jL_mensajeAgregada.setVisible(false);
        int codigo = 0;
        String nombre = jTF_Nombre.getText();
        String sitioWeb = jTF_SitioWeb.getText();
        String telefonos = jTF_Telefonos.getText();
        String contactenos = jTF_Contactenos.getText();
        if (!nombre.equals("") && !contactenos.equals("")) {
            //NOTA:--Esta validacion no permite que el nombre contenga números o caracteres especiales!!!
            if (Utilidades.validaNumero(telefonos) && Utilidades.validaTexto(nombre.toLowerCase())) {
                try {
                    codigo = aerolineaData.getCodigoUltimaAerolinea() + 1;//Obtengo el ultimo codigo y lo aumento
                } catch (ListaException ex) {
                    Logger.getLogger(JIF_AgregaAerolineaTemp.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    boolean agregada = aerolineaData.agregarAeorlinea(new Aerolinea(codigo, nombre, sitioWeb, telefonos, contactenos));
                    if (!agregada) {//Muestro una etiqueta cuando está registrada y no se puede agregar
                        jL_mensajeAgregada.setText("Aerolinea ya está registrada. No se puede agregar.");
                        jL_mensajeAgregada.setVisible(true);
                        jTF_Nombre.setText("");
                        jTF_SitioWeb.setText("");
                        jTF_Telefonos.setText("");
                        jTF_Contactenos.setText("");
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(JIF_AgregaAerolineaTemp.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                jL_mensajeAgregada.setText("Datos incorrectos. Ingrese de nuevo la información.");
                jL_mensajeAgregada.setVisible(true);
            }
        } else {
            jL_mensajeAgregada.setText("Datos incorrectos. Ingrese de nuevo la información.");
            jL_mensajeAgregada.setVisible(true);
        }
        actualizarTabla();//Actualizo la información de la tabla
    }//GEN-LAST:event_jBtn_AgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_Agregar;
    private javax.swing.JButton jBtn_Cancelar;
    private javax.swing.JLabel jL_Contactenos;
    private javax.swing.JLabel jL_Nombre;
    private javax.swing.JLabel jL_SitioWeb;
    private javax.swing.JLabel jL_Telefonos;
    private javax.swing.JLabel jL_mensajeAgregada;
    private javax.swing.JTextField jTF_Contactenos;
    private javax.swing.JTextField jTF_Nombre;
    private javax.swing.JTextField jTF_SitioWeb;
    private javax.swing.JTextField jTF_Telefonos;
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

