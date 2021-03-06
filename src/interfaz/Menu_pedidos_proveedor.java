/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;


import controller.Controladora;
import interfaz.AgregarPedido;
import interfaz.ListarPedidos;

import interfaz.PagosProveedor;
import javax.swing.JOptionPane;

/**
 *
 * @author Michele
 */
public class Menu_pedidos_proveedor extends javax.swing.JFrame {
Controladora control = new Controladora();
String nombreUsuario ="";
String nombreEntidad="cliente";
String instruccion="";
 int permiso=0;
    /**
     * Creates new form PedidosProveedor
     */
    public Menu_pedidos_proveedor() {
        initComponents();
         this.setLocationRelativeTo(null);
        this.setResizable(false); 
    }
       public Menu_pedidos_proveedor(String nombreUsuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false); 
        this.nombreUsuario=nombreUsuario;
        lblUsuario.setText(nombreUsuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pedirMaterial = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        listarPedidos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pagar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pedirMaterial.setText("Pedir material");
        pedirMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedirMaterialActionPerformed(evt);
            }
        });

        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        listarPedidos.setText("Listar pedidos");
        listarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarPedidosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Pedidos Proveedor");

        pagar.setText("Pagar Pedido");
        pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Usuario:");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(listarPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pedirMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(pagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(lblUsuario)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Home)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(92, 92, 92))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Home))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblUsuario))
                .addGap(23, 23, 23)
                .addComponent(pedirMaterial)
                .addGap(18, 18, 18)
                .addComponent(listarPedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pagar)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
         Home ventana = new Home(nombreUsuario);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeActionPerformed

    private void listarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarPedidosActionPerformed
       
     instruccion="consultar";
      if (control.buscarPermiso(instruccion, nombreEntidad,nombreUsuario)==1){    
        ListarPedidos ventana = new ListarPedidos(nombreUsuario);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        this.dispose();
      }
      else
           JOptionPane.showMessageDialog(null, "Su Usuario no tiene  el Privilegio  \n De consultar Pedidos del Proveedor "  , "Acceso No Permitido", JOptionPane.ERROR_MESSAGE); 
        // TODO add your handling code here:
    }//GEN-LAST:event_listarPedidosActionPerformed

    private void pedirMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedirMaterialActionPerformed
      instruccion="agregar";
      if (control.buscarPermiso(instruccion, nombreEntidad,nombreUsuario)==1){       
         AgregarPedido ventana = new AgregarPedido(nombreUsuario);
         ventana.setLocationRelativeTo(null);
         ventana.setVisible(true);
         this.dispose();
      }
      else
          JOptionPane.showMessageDialog(null, "Su Usuario no tiene  el Privilegio  \n De agregar Pedidos del Proveedor "  , "Acceso No Permitido", JOptionPane.ERROR_MESSAGE); 
          
    }//GEN-LAST:event_pedirMaterialActionPerformed

    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
      instruccion="modificar";
      if (control.buscarPermiso(instruccion, nombreEntidad,nombreUsuario)==1){       
          PagosProveedor ventana = new PagosProveedor(nombreUsuario);
          ventana.setLocationRelativeTo(null);
          ventana.setVisible(true);
          this.dispose();        // TODO add your handling code here:
      }
      else
          JOptionPane.showMessageDialog(null, "Su Usuario no tiene  el Privilegio  \n De modificar(pagar) Pedidos del Proveedor "  , "Acceso No Permitido", JOptionPane.ERROR_MESSAGE); 
    }//GEN-LAST:event_pagarActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_pedidos_proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_pedidos_proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_pedidos_proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_pedidos_proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_pedidos_proveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JButton listarPedidos;
    private javax.swing.JButton pagar;
    private javax.swing.JButton pedirMaterial;
    // End of variables declaration//GEN-END:variables
}
