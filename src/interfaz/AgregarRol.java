/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;


import controller.Controladora;
import javax.swing.JOptionPane;

/**
 *
 * @author GREGORIO-PC
 */
public class AgregarRol extends javax.swing.JFrame {
Controladora control = new Controladora();
int primeraVez =0;
String nombreUsuario="";
    /**
     * Creates new form AgregarRol
     */
    public AgregarRol() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
//        control.llenarTablaAgregarRol(tablaAgregarRol, txtNombreRol.getText());
        
    }
        public AgregarRol(String nombreUsuario) {
           initComponents();
           this.setLocationRelativeTo(null);
           this.setResizable(false);
           this.nombreUsuario=nombreUsuario;
//        control.llenarTablaAgregarRol(tablaAgregarRol, txtNombreRol.getText());
        
    }
       public AgregarRol(String nombreRol,String nombreUsuario) {
          initComponents();
          this.setLocationRelativeTo(null);
          this.setResizable(false);
          control.llenarTablaAgregarRol(tablaAgregarRol, nombreRol);
          txtNombreRol.setText(nombreRol);
          this.nombreUsuario=nombreUsuario;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreRol = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAgregarRol = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        agregarPermiso = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        agregarRol = new javax.swing.JButton();
        HOME = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Agregar Rol");

        jLabel2.setText("Rol:");

        txtNombreRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreRolActionPerformed(evt);
            }
        });

        tablaAgregarRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID del Permiso", "Nombre de la Entidad", "Nombre de la Instrucción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAgregarRol);

        agregarPermiso.setText("Agregar Permiso");
        agregarPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPermisoActionPerformed(evt);
            }
        });

        atras.setText("Atrás");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        agregarRol.setText("Agregar Rol");
        agregarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarRolActionPerformed(evt);
            }
        });

        HOME.setText("HOME");
        HOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HOMEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(HOME)
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(agregarPermiso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))))
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(atras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregarRol)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(HOME))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 34, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(agregarPermiso))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atras)
                    .addComponent(agregarRol))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPermisoActionPerformed
       if (txtNombreRol.getText().isEmpty() ==false ){
        int buscar=control.buscarRol(txtNombreRol.getText());    
       
        if (buscar!=1){
           int verificar = control.agregarRol(txtNombreRol.getText());
           if (verificar==1){
              AsignarPermiso ventana = new AsignarPermiso(txtNombreRol.getText(),nombreUsuario);
              ventana.setLocationRelativeTo(null);
              ventana.setVisible(true);
              this.dispose(); 
            }
           else
               JOptionPane.showMessageDialog(null, "Error" , "Ha ocorrido un Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
              AsignarPermiso ventana = new AsignarPermiso(txtNombreRol.getText(),nombreUsuario);
              ventana.setLocationRelativeTo(null);
              ventana.setVisible(true);
              this.dispose(); 
        }
       }
       else
            JOptionPane.showMessageDialog(null, "Debe indicar el nombre del rol", " Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_agregarPermisoActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
           control.eliminarRol(txtNombreRol.getText());   
           MenuRol ventana = new MenuRol(nombreUsuario);
           ventana.setLocationRelativeTo(null);
           ventana.setVisible(true);
           this.dispose(); 
    }//GEN-LAST:event_atrasActionPerformed

    private void agregarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarRolActionPerformed

       if (txtNombreRol.getText().isEmpty() ==false ){
           System.out.println(control.devolverRolSinPermiso(txtNombreRol.getText()));
         if (control.devolverRolSinPermiso(txtNombreRol.getText()) ==0){
           JOptionPane.showMessageDialog(null, "Agregado" , "Se ha agregado con Exito el Rol", JOptionPane.INFORMATION_MESSAGE);
           MenuRol ventana = new MenuRol(nombreUsuario);
           ventana.setLocationRelativeTo(null);
           ventana.setVisible(true);
           this.dispose(); 
         }
         else
             JOptionPane.showMessageDialog(null, "Debe Asignar algun Permiso", " Error", JOptionPane.ERROR_MESSAGE);
       }
        else
            JOptionPane.showMessageDialog(null, "Debe Indicar el Nombre del Rol", " Error", JOptionPane.ERROR_MESSAGE);
       
    }//GEN-LAST:event_agregarRolActionPerformed

    private void HOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HOMEActionPerformed
        control.eliminarRol(txtNombreRol.getText());  
        Home ventana = new Home(nombreUsuario);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_HOMEActionPerformed

    private void txtNombreRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreRolActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarRol().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HOME;
    private javax.swing.JButton agregarPermiso;
    private javax.swing.JButton agregarRol;
    private javax.swing.JButton atras;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAgregarRol;
    private javax.swing.JTextField txtNombreRol;
    // End of variables declaration//GEN-END:variables
}
