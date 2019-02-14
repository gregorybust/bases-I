/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import controller.Controladora;
import controller.Validacion;
import interfaz.Menu_Proveedores;


import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat; //MANEJO DE FECHAS


public class AgregarProveedor extends javax.swing.JFrame {

Controladora control =new Controladora();
  String nombreUsuario="";   
    /**
     * Creates new form AgregarProveedor
     */
    public AgregarProveedor() {
        initComponents();
 control.llenar_pais(PaisCombo);
          this.setLocationRelativeTo(null);
        this.setResizable(false); 
      
    }
       public AgregarProveedor(String nombreUsuario) {
        initComponents();
 control.llenar_pais(PaisCombo);
          this.setLocationRelativeTo(null);
        this.setResizable(false); 
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

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        agregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Atras = new javax.swing.JButton();
        NombreTxt = new javax.swing.JTextField();
        pagWebTxt = new javax.swing.JTextField();
        montoAcreditadoTxt = new javax.swing.JTextField();
        Tlf1Txt = new javax.swing.JTextField();
        home = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        calendar = new com.toedter.calendar.JDateChooser();
        Correo = new javax.swing.JLabel();
        CorreoTxt = new javax.swing.JTextField();
        PaisCombo = new javax.swing.JComboBox();
        EstadoCombo = new javax.swing.JComboBox();
        MunicipioCombo = new javax.swing.JComboBox();
        Parroquia = new javax.swing.JLabel();
        ParroquiaCombo = new javax.swing.JComboBox();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel2.setText("Página web:");

        jLabel3.setText("Teléfono:");

        jLabel7.setText("País:");

        jLabel8.setText("Estado:");

        jLabel9.setText("Municipio:");

        jLabel10.setText("Monto Acreditado:");

        Atras.setText("Atrás");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });

        NombreTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreTxtActionPerformed(evt);
            }
        });

        pagWebTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagWebTxtActionPerformed(evt);
            }
        });

        Tlf1Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tlf1TxtActionPerformed(evt);
            }
        });

        home.setText("home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        jLabel14.setText("Fecha  Contrato:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Agregar Proveedor");

        Correo.setText("Correo:");

        PaisCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione País" }));
        PaisCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PaisComboItemStateChanged(evt);
            }
        });
        PaisCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaisComboActionPerformed(evt);
            }
        });

        EstadoCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Estado" }));
        EstadoCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EstadoComboItemStateChanged(evt);
            }
        });
        EstadoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadoComboActionPerformed(evt);
            }
        });

        MunicipioCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Municipio", " " }));
        MunicipioCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MunicipioComboItemStateChanged(evt);
            }
        });
        MunicipioCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MunicipioComboActionPerformed(evt);
            }
        });

        Parroquia.setText("Parroquia");

        ParroquiaCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Parroquia", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(home)
                    .addComponent(Atras))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Correo)
                                .addGap(9, 9, 9))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Parroquia, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tlf1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(montoAcreditadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar)
                            .addComponent(NombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pagWebTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CorreoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(PaisCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EstadoCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MunicipioCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ParroquiaCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(calendar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pagWebTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(PaisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(EstadoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(MunicipioCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Parroquia)
                    .addComponent(ParroquiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montoAcreditadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tlf1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CorreoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Correo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregar)
                .addGap(5, 5, 5)
                .addComponent(Atras)
                .addContainerGap())
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

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
          Menu_Proveedores ventana = new Menu_Proveedores(nombreUsuario);
          ventana.setLocationRelativeTo(null);
          ventana.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_AtrasActionPerformed

    private void NombreTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreTxtActionPerformed

    private void pagWebTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagWebTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagWebTxtActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
// String fecha =" ";
  //  fecha = comboDia.getSelectedItem()+"-"+comboMes.getSelectedItem()+"-"+comboAño.getSelectedItem();
   try{
    int muni = control.BuscarLugarID(ParroquiaCombo.getSelectedItem().toString(),"Parroquia");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

String date = sdf.format(calendar.getDate());

   int fk = 0;
  if ((control.buscarProveedor((NombreTxt.getText()))!= 1 )&& (control.buscarTelefono((Tlf1Txt.getText()))!= 1 )){
    
      int verificarAgregar, verificarAgregar2=0,verificarAgregar3=0;
      verificarAgregar= control.agregarProveedor( NombreTxt.getText(),pagWebTxt.getText(),date,Integer.parseInt(montoAcreditadoTxt.getText()),muni);
         
      if (verificarAgregar == 1)
    fk = control.buscarProveedorID((NombreTxt.getText()));
     verificarAgregar2 =control.agregarTelefono(Tlf1Txt.getText(),fk );
      verificarAgregar3 = control.agregarCorreo(CorreoTxt.getText(), fk);
     
      
      
      if ((verificarAgregar == 1) && (verificarAgregar2 == 1) && (verificarAgregar3 == 1) ){
          JOptionPane.showMessageDialog(null, "Proveedor " +NombreTxt.getText(), " agregado con exito!", JOptionPane.INFORMATION_MESSAGE);
           Menu_Proveedores ventana = new Menu_Proveedores(nombreUsuario);
           ventana.setLocationRelativeTo(null);
           ventana.setVisible(true);
           this.dispose(); 
      }
           
      else
         if (verificarAgregar == 0)
         JOptionPane.showMessageDialog(null, "Proveedor " + NombreTxt.getText(), " No se pudo agregar!", JOptionPane.ERROR_MESSAGE);
   }
    else
         JOptionPane.showMessageDialog(null, "Proveedor " + NombreTxt.getText(), " Error", JOptionPane.ERROR_MESSAGE);
   

   }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Ocurrio un error!", " Error", JOptionPane.ERROR_MESSAGE);
   }
    }//GEN-LAST:event_agregarActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
          Home ventana = new Home(nombreUsuario);
          ventana.setLocationRelativeTo(null);
          ventana.setVisible(true);
          this.dispose();
      
    }//GEN-LAST:event_homeActionPerformed

    private void Tlf1TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tlf1TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tlf1TxtActionPerformed

    private void EstadoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadoComboActionPerformed
   
    }//GEN-LAST:event_EstadoComboActionPerformed

    private void MunicipioComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MunicipioComboActionPerformed

    }//GEN-LAST:event_MunicipioComboActionPerformed

    private void PaisComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaisComboActionPerformed

    }//GEN-LAST:event_PaisComboActionPerformed

    private void EstadoComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EstadoComboItemStateChanged
int     estado = 0;
    if (evt.getStateChange()== ItemEvent.SELECTED)
         estado = control.BuscarLugarID(EstadoCombo.getSelectedItem().toString(),"Estado");
        
     control.llenar_muni(MunicipioCombo,estado);
    }//GEN-LAST:event_EstadoComboItemStateChanged

    private void PaisComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PaisComboItemStateChanged
int     pais = 0;
    if (evt.getStateChange()== ItemEvent.SELECTED)
         pais = control.BuscarLugarID(PaisCombo.getSelectedItem().toString(),"Pais");
     control.llenar_est(EstadoCombo,pais);
    }//GEN-LAST:event_PaisComboItemStateChanged

    private void MunicipioComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MunicipioComboItemStateChanged
     int     muni = 0;
    if (evt.getStateChange()== ItemEvent.SELECTED)
         muni = control.BuscarLugarID(MunicipioCombo.getSelectedItem().toString(),"Municipio");
  
     control.llenar_parro(ParroquiaCombo,muni);
    }//GEN-LAST:event_MunicipioComboItemStateChanged


    

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
            java.util.logging.Logger.getLogger(AgregarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras;
    private javax.swing.JLabel Correo;
    private javax.swing.JTextField CorreoTxt;
    private javax.swing.JComboBox EstadoCombo;
    private javax.swing.JComboBox MunicipioCombo;
    private javax.swing.JTextField NombreTxt;
    private javax.swing.JComboBox PaisCombo;
    private javax.swing.JLabel Parroquia;
    private javax.swing.JComboBox ParroquiaCombo;
    private javax.swing.JTextField Tlf1Txt;
    private javax.swing.JButton agregar;
    private com.toedter.calendar.JDateChooser calendar;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField montoAcreditadoTxt;
    private javax.swing.JTextField pagWebTxt;
    // End of variables declaration//GEN-END:variables
}
