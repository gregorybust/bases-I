/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import controller.Controladora;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Michele
 */
public class Menu_Proveedores extends javax.swing.JFrame {
Controladora control = new Controladora();
String nombreUsuario ="";
String nombreEntidad="proveedor";
String instruccion="";
 int permiso=0;
 

    /**
     * Creates new form CrudProveedores
     */
    public Menu_Proveedores() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false); 
    }
     public Menu_Proveedores(String nombreUsurario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false); 
        this.nombreUsuario=nombreUsurario;
        lblUsuario.setText(nombreUsurario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ListarPro = new javax.swing.JButton();
        AgregarPro = new javax.swing.JButton();
        MoCoPro = new javax.swing.JButton();
        EliminarPro = new javax.swing.JButton();
        botonHome = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Proveedores");

        ListarPro.setText("Listar proveedores");
        ListarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarProActionPerformed(evt);
            }
        });

        AgregarPro.setText("Agregar proveedor");
        AgregarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarProActionPerformed(evt);
            }
        });

        MoCoPro.setText("Modificar/Consultar");
        MoCoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoCoProActionPerformed(evt);
            }
        });

        EliminarPro.setText("Eliminar proveedor");
        EliminarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProActionPerformed(evt);
            }
        });

        botonHome.setText("Home");
        botonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHomeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Usuario:");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ListarPro)
                                .addComponent(AgregarPro)
                                .addComponent(MoCoPro)
                                .addComponent(EliminarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addGap(33, 33, 33)
                        .addComponent(lblUsuario)))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(botonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblUsuario))
                .addGap(19, 19, 19)
                .addComponent(ListarPro)
                .addGap(18, 18, 18)
                .addComponent(AgregarPro)
                .addGap(18, 18, 18)
                .addComponent(MoCoPro)
                .addGap(18, 18, 18)
                .addComponent(EliminarPro)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EliminarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProActionPerformed
      instruccion="eliminar";
      if (control.buscarPermiso(instruccion, nombreEntidad,nombreUsuario)==1){ 
          EliminarProveedor ventana = new EliminarProveedor(nombreUsuario);
          ventana.setLocationRelativeTo(null);
          ventana.setVisible(true);
          this.dispose();
      }
       else
       JOptionPane.showMessageDialog(null, "Su Usuario no tiene  el Privilegio  \n De agregar Proveedor "  , "Acceso No Permitido", JOptionPane.ERROR_MESSAGE); 
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarProActionPerformed

    private void AgregarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarProActionPerformed
          
        instruccion="agregar";
      if (control.buscarPermiso(instruccion, nombreEntidad,nombreUsuario)==1){
          AgregarProveedor ventana = new AgregarProveedor(nombreUsuario);
          ventana.setLocationRelativeTo(null);
          ventana.setVisible(true);
          this.dispose();
      }
      else
          JOptionPane.showMessageDialog(null, "Su Usuario no tiene  el Privilegio  \n De agregar Proveedor "  , "Acceso No Permitido", JOptionPane.ERROR_MESSAGE); 
    }//GEN-LAST:event_AgregarProActionPerformed

    private void ListarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarProActionPerformed

       instruccion="consultar";
      if (control.buscarPermiso(instruccion, nombreEntidad,nombreUsuario)==1){
          ListarProveedores ventana = new ListarProveedores(nombreUsuario);
          ventana.setLocationRelativeTo(null);
          ventana.setVisible(true);
          this.dispose();
      }
      else
          JOptionPane.showMessageDialog(null, "Su Usuario no tiene  el Privilegio  \n De Consultar Proveedor "  , "Acceso No Permitido", JOptionPane.ERROR_MESSAGE); 
    }//GEN-LAST:event_ListarProActionPerformed

    private void MoCoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoCoProActionPerformed
           
      instruccion="consultar";
      if (control.buscarPermiso(instruccion, nombreEntidad,nombreUsuario)==1){  
          PedirRif ventana = new PedirRif(nombreUsuario);
          ventana.setLocationRelativeTo(null);
          ventana.setVisible(true);
          this.dispose();
      }
      else
           JOptionPane.showMessageDialog(null, "Su Usuario no tiene  el Privilegio  \n De Consultar Proveedor "  , "Acceso No Permitido", JOptionPane.ERROR_MESSAGE); 
    }//GEN-LAST:event_MoCoProActionPerformed

    private void botonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonHomeActionPerformed
          Home ventana = new Home(nombreUsuario);
          ventana.setLocationRelativeTo(null);
          ventana.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_botonHomeActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarPro;
    private javax.swing.JButton EliminarPro;
    private javax.swing.JButton ListarPro;
    private javax.swing.JButton MoCoPro;
    private javax.swing.JButton botonHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}