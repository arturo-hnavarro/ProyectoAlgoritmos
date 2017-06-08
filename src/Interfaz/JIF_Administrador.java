/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import TDA.lista.ListaCircularEnlazadaDoble;
import TDA.lista.ListaException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import dominio.Agencia;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import logica.AerolineaData;
import logica.AgenciaData;

/**
 *
 * @author Usuario
 */
public class JIF_Administrador extends javax.swing.JFrame {

    JIF_IngresarAgencia ingresarAgencia;
    JIF_ConsultarAgencias consultarAgenciasJIF;
    JIF_AerolineaTemp jIF_AerolineaTemp;
    AerolineaData aerolineaData;

    public JIF_Administrador() {
        initComponents();
        ingresarAgencia = new JIF_IngresarAgencia();
        consultarAgenciasJIF = new JIF_ConsultarAgencias();
        jIF_AerolineaTemp = new JIF_AerolineaTemp();
        
        try {
            aerolineaData = new AerolineaData("aerolineas.dat");
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo");
            Logger.getLogger(JIF_Administrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ListaException ex) {
            Logger.getLogger(JIF_Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopAdministrador = new javax.swing.JDesktopPane();
        JMB_MenuAdministrador = new javax.swing.JMenuBar();
        JMB_aerolineas = new javax.swing.JMenu();
        JBM_Agencias = new javax.swing.JMenu();
        MI_agregaAgencia = new javax.swing.JMenuItem();
        MI_modificarAgencia = new javax.swing.JMenuItem();
        MI_supimirAgencia = new javax.swing.JMenuItem();
        MI_consultaAgencia = new javax.swing.JMenuItem();
        MI_imprimirAgencia = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido Administrador");

        javax.swing.GroupLayout DesktopAdministradorLayout = new javax.swing.GroupLayout(DesktopAdministrador);
        DesktopAdministrador.setLayout(DesktopAdministradorLayout);
        DesktopAdministradorLayout.setHorizontalGroup(
            DesktopAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );
        DesktopAdministradorLayout.setVerticalGroup(
            DesktopAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        JMB_MenuAdministrador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JMB_MenuAdministrador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        JMB_aerolineas.setText("Aerolíneas");
        JMB_aerolineas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        JMB_aerolineas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JMB_aerolineasMouseClicked(evt);
            }
        });
        JMB_MenuAdministrador.add(JMB_aerolineas);

        JBM_Agencias.setText("Agencias de viaje");
        JBM_Agencias.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        MI_agregaAgencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        MI_agregaAgencia.setText("Agregar");
        MI_agregaAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_agregaAgenciaActionPerformed(evt);
            }
        });
        JBM_Agencias.add(MI_agregaAgencia);

        MI_modificarAgencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        MI_modificarAgencia.setText("Modificar");
        MI_modificarAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_modificarAgenciaActionPerformed(evt);
            }
        });
        JBM_Agencias.add(MI_modificarAgencia);

        MI_supimirAgencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        MI_supimirAgencia.setText("Eliminar");
        JBM_Agencias.add(MI_supimirAgencia);

        MI_consultaAgencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        MI_consultaAgencia.setText("Consultar");
        MI_consultaAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_consultaAgenciaActionPerformed(evt);
            }
        });
        JBM_Agencias.add(MI_consultaAgencia);

        MI_imprimirAgencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        MI_imprimirAgencia.setText("Imprimir");
        MI_imprimirAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_imprimirAgenciaActionPerformed(evt);
            }
        });
        JBM_Agencias.add(MI_imprimirAgencia);

        JMB_MenuAdministrador.add(JBM_Agencias);

        setJMenuBar(JMB_MenuAdministrador);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopAdministrador)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopAdministrador)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void agregarJInternalFrame(JInternalFrame jinternalFrame) {
        DesktopAdministrador.add(jinternalFrame);
        jinternalFrame.setVisible(true);
    }

    private void JMB_aerolineasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMB_aerolineasMouseClicked
        if (jIF_AerolineaTemp.isShowing() == false) {
            actualizarTabla();
            agregarJInternalFrame(jIF_AerolineaTemp);//Agrego el JInternalFrame al JDesktopPane
        }else
            jIF_AerolineaTemp.toFront(); // Si ya está abierta y no se ve la traigo al frente, que se muestre
    }//GEN-LAST:event_JMB_aerolineasMouseClicked

    private void MI_agregaAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_agregaAgenciaActionPerformed
        if (ingresarAgencia.isShowing() == false) {
            agregarJInternalFrame(ingresarAgencia);
        }else
            ingresarAgencia.toFront();

//        agregarAgencia agencia = new agregarAgencia();
//        int x = (DesktopAdministrador.getWidth() / 2) - agencia.getWidth() / 2;
//        int y = (DesktopAdministrador.getHeight() / 2) - agencia.getHeight() / 2;
//        DesktopAdministrador.add(agencia);
//        agencia.setLocation(x, y);
//        agencia.show();
    }//GEN-LAST:event_MI_agregaAgenciaActionPerformed

    private void MI_modificarAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_modificarAgenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MI_modificarAgenciaActionPerformed

    private void MI_imprimirAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_imprimirAgenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MI_imprimirAgenciaActionPerformed

    private void MI_consultaAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_consultaAgenciaActionPerformed
        try {
            AgenciaData agenciaData = new AgenciaData("agencias.dat");
            ListaCircularEnlazadaDoble lista = agenciaData.obtenerTodasLasAgencias();
            int n = lista.getSize();
            String datos[][] = new String[n][5];
            // TODO add your handling code here:
            ;
            for (int i = 1; i <= n; i++) {
                Agencia a = (Agencia) lista.getNodo(i).getElemento();
                datos[i - 1][0] = "" + a.getCodigo();
                datos[i - 1][1] = a.getNombre();
                datos[i - 1][2] = a.getUbicacion();
                datos[i - 1][3] = a.getTelefonos().toString();
                datos[i - 1][4] = a.getCorreo();

            }

            String columnas[] = {"Código", "Nombre", "Ubicación", "Teléfonos", "Correo"};
            JIF_ConsultarAgencias.DTM_listado = new DefaultTableModel(datos, columnas);
            JIF_ConsultarAgencias.jTable1.setModel(JIF_ConsultarAgencias.DTM_listado);

            agregarJInternalFrame(consultarAgenciasJIF);
        } catch (IOException ex) {
            Logger.getLogger(JIF_Administrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ListaException ex) {
            Logger.getLogger(JIF_Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_MI_consultaAgenciaActionPerformed

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
            java.util.logging.Logger.getLogger(JIF_Administrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JIF_Administrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JIF_Administrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JIF_Administrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JIF_Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane DesktopAdministrador;
    private javax.swing.JMenu JBM_Agencias;
    private javax.swing.JMenuBar JMB_MenuAdministrador;
    private javax.swing.JMenu JMB_aerolineas;
    private javax.swing.JMenuItem MI_agregaAgencia;
    private javax.swing.JMenuItem MI_consultaAgencia;
    private javax.swing.JMenuItem MI_imprimirAgencia;
    private javax.swing.JMenuItem MI_modificarAgencia;
    private javax.swing.JMenuItem MI_supimirAgencia;
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
