/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;


import controller.Controladora;
import controller.Validacion;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author GREGORIO-PC
 */
public class ModificarPersonal extends javax.swing.JFrame {
    Controladora control = new Controladora();
    Validacion valida = new Validacion();
    int cedulaActual;
    private JFrame ventana; 
     public ModificarPersonal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false); 
       
        
    }
    public ModificarPersonal(int cedula) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false); 
        control.llenarVentaModificar( cedula,txtCedulaModificar, txtPrimerNombre, txtSegundoNombre, txtPrimerApellido, txtSegundoApellido, txtFecha, txtOtroDato);
        cedulaActual= cedula;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonHome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSegundoApellido = new javax.swing.JTextField();
        txtPrimerApellido = new javax.swing.JTextField();
        txtPrimerNombre = new javax.swing.JTextField();
        txtCedulaModificar = new javax.swing.JTextField();
        txtSegundoNombre = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        txtTelefono1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCorreo1 = new javax.swing.JTextField();
        txtTelefono2 = new javax.swing.JTextField();
        txtTitulacion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtOtroDato = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtBeneficiario1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtbeneficiario1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        txtMunicipio = new javax.swing.JTextField();
        txtOtro = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtReb1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        comboDia = new javax.swing.JComboBox<>();
        comboMes = new javax.swing.JComboBox<>();
        comboAño = new javax.swing.JComboBox<>();
        txtBeneficiario3 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        botonAtras = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        botonHome.setText("HOME");
        botonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHomeActionPerformed(evt);
            }
        });
        jPanel1.add(botonHome);
        botonHome.setBounds(10, 11, 61, 37);

        jLabel1.setText("Cedula nueva :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 62, 73, 14);

        jLabel2.setText("Primer nombre:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(358, 62, 73, 14);

        jLabel3.setText("Segundo Nombre:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 106, 86, 14);

        jLabel4.setText("Primer apellido: ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(355, 115, 76, 14);

        jLabel5.setText("Segundo apellido:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 152, 85, 14);

        jLabel6.setText("Titulación: ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(355, 232, 52, 14);
        jPanel1.add(txtSegundoApellido);
        txtSegundoApellido.setBounds(146, 149, 113, 20);

        txtPrimerApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrimerApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrimerApellido);
        txtPrimerApellido.setBounds(462, 112, 104, 20);
        jPanel1.add(txtPrimerNombre);
        txtPrimerNombre.setBounds(462, 59, 99, 20);

        txtCedulaModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCedulaModificarMousePressed(evt);
            }
        });
        txtCedulaModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaModificarActionPerformed(evt);
            }
        });
        jPanel1.add(txtCedulaModificar);
        txtCedulaModificar.setBounds(147, 59, 112, 20);
        jPanel1.add(txtSegundoNombre);
        txtSegundoNombre.setBounds(146, 103, 112, 20);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(462, 59, 99, 20);
        jPanel1.add(txtTelefono1);
        txtTelefono1.setBounds(462, 150, 100, 20);

        jLabel9.setText("telefono 1:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(355, 150, 53, 14);

        jLabel10.setText("telefono 2:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(50, 197, 53, 14);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(417, 175, 0, 77);

        jLabel12.setText("Correo 2:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(50, 235, 63, 14);

        jLabel13.setText("Correo 1:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(355, 197, 46, 14);
        jPanel1.add(txtCorreo1);
        txtCorreo1.setBounds(462, 188, 100, 20);
        jPanel1.add(txtTelefono2);
        txtTelefono2.setBounds(146, 194, 113, 20);
        jPanel1.add(txtTitulacion);
        txtTitulacion.setBounds(462, 232, 100, 20);

        jLabel14.setText("Fecha  Contrato:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(50, 394, 82, 14);

        jLabel15.setText("Otro dato:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(50, 270, 51, 14);
        jPanel1.add(txtOtroDato);
        txtOtroDato.setBounds(146, 270, 113, 20);

        jLabel16.setText("Beneficiario 1:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(355, 273, 68, 14);
        jPanel1.add(txtBeneficiario1);
        txtBeneficiario1.setBounds(462, 59, 100, 20);

        jLabel17.setText("Beneficiario 2:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(50, 316, 70, 14);
        jPanel1.add(txtbeneficiario1);
        txtbeneficiario1.setBounds(462, 270, 100, 20);
        jPanel1.add(jLabel18);
        jLabel18.setBounds(276, 357, 68, 0);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Modificar Personal");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(215, 0, 143, 22);
        jPanel1.add(txtCorreo2);
        txtCorreo2.setBounds(146, 232, 113, 20);

        jLabel8.setText("Direccion : ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 432, 53, 14);
        jPanel1.add(txtEstado);
        txtEstado.setBounds(142, 429, 90, 20);
        jPanel1.add(txtMunicipio);
        txtMunicipio.setBounds(250, 429, 110, 20);
        jPanel1.add(txtOtro);
        txtOtro.setBounds(378, 429, 113, 20);

        jLabel23.setText(" Dia");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(156, 394, 18, 14);

        jLabel24.setText("Mes");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(239, 394, 19, 14);

        jLabel25.setText("Año");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(323, 394, 19, 14);

        jLabel20.setText("Estado");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(166, 460, 33, 14);

        jLabel21.setText("Municipio");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(274, 460, 43, 14);

        jLabel22.setText("Av / calle");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(430, 460, 44, 14);

        jLabel26.setText("Red social 1:");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(360, 310, 61, 14);
        jPanel1.add(txtReb1);
        txtReb1.setBounds(463, 310, 100, 20);

        jLabel27.setText("Red social 2:");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(50, 354, 61, 20);

        comboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel1.add(comboDia);
        comboDia.setBounds(184, 391, 37, 20);

        comboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));
        jPanel1.add(comboMes);
        comboMes.setBounds(268, 391, 37, 20);

        comboAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018" }));
        jPanel1.add(comboAño);
        comboAño.setBounds(352, 391, 49, 20);
        jPanel1.add(txtBeneficiario3);
        txtBeneficiario3.setBounds(146, 313, 113, 20);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(149, 350, 110, 20);

        botonAtras.setText("Atrás");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(botonAtras);
        botonAtras.setBounds(10, 509, 59, 23);

        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        jPanel1.add(botonModificar);
        botonModificar.setBounds(481, 503, 75, 23);
        jPanel1.add(txtFecha);
        txtFecha.setBounds(430, 390, 110, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonHomeActionPerformed
        Home ventana = new Home();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonHomeActionPerformed

    private void txtPrimerApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrimerApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrimerApellidoActionPerformed

    private void txtCedulaModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaModificarMousePressed

    }//GEN-LAST:event_txtCedulaModificarMousePressed

    private void txtCedulaModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaModificarActionPerformed

    }//GEN-LAST:event_txtCedulaModificarActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        MenuPersonal ventana = new MenuPersonal();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
     if (Integer.parseInt(txtCedulaModificar.getText()) !=0 ){      
       if (control.buscarPersonal(Integer.parseInt(txtCedulaModificar.getText())) !=1) {
           int verificar = control.modificarPersonal(cedulaActual,Integer.parseInt(txtCedulaModificar.getText()), txtPrimerNombre.getText(), txtSegundoNombre.getText(), txtPrimerApellido.getText(), txtSegundoApellido.getText(), txtFecha.getText(), txtOtroDato.getText());
    
            if (verificar == 1){
              JOptionPane.showMessageDialog(null, "Personal " + txtPrimerNombre.getText(), " Modificado con exito!", JOptionPane.INFORMATION_MESSAGE);
              MenuPersonal ventana = new MenuPersonal();
              ventana.setLocationRelativeTo(null);
              ventana.setVisible(true);
              this.dispose();
            }
            else{
               JOptionPane.showMessageDialog(null, "Personal " + txtPrimerNombre.getText(), "No se pudo Modificar!", JOptionPane.ERROR_MESSAGE);
                MenuPersonal ventana = new MenuPersonal();
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
                this.dispose();
             }
        }
     
       else{
             if (control.devolverCedula(Integer.parseInt(txtCedulaModificar.getText())) ==cedulaActual){ 
                 int verificar = control.modificarPersonal(cedulaActual,Integer.parseInt(txtCedulaModificar.getText()), txtPrimerNombre.getText(), txtSegundoNombre.getText(), txtPrimerApellido.getText(), txtSegundoApellido.getText(), txtFecha.getText(), txtOtroDato.getText());
                   if (verificar == 1){
                   JOptionPane.showMessageDialog(null, "Personal " + txtPrimerNombre.getText(), " Modificado con exito!", JOptionPane.INFORMATION_MESSAGE);
                    MenuPersonal ventana = new MenuPersonal();
                  ventana.setLocationRelativeTo(null);
                  ventana.setVisible(true);
                 this.dispose();
                 }
             else{
               JOptionPane.showMessageDialog(null, "Personal " + txtPrimerNombre.getText(), "No se pudo Modificar!", JOptionPane.ERROR_MESSAGE);
                MenuPersonal ventana = new MenuPersonal();
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
                this.dispose();
             }
                  
             }
             else
                 JOptionPane.showMessageDialog(null, "Personal " + txtPrimerNombre.getText(), "cedula ya registrada", JOptionPane.ERROR_MESSAGE);
       }
     }
     else
         
      JOptionPane.showMessageDialog(null, "Error  ", "la cedula no puede ser 0", JOptionPane.ERROR_MESSAGE);
            
             
    }//GEN-LAST:event_botonModificarActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonHome;
    private javax.swing.JButton botonModificar;
    private javax.swing.JComboBox<String> comboAño;
    private javax.swing.JComboBox<String> comboDia;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtBeneficiario1;
    private javax.swing.JTextField txtBeneficiario3;
    private javax.swing.JTextField txtCedulaModificar;
    private javax.swing.JTextField txtCorreo1;
    private javax.swing.JTextField txtCorreo2;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtOtro;
    private javax.swing.JTextField txtOtroDato;
    private javax.swing.JTextField txtPrimerApellido;
    private javax.swing.JTextField txtPrimerNombre;
    private javax.swing.JTextField txtReb1;
    private javax.swing.JTextField txtSegundoApellido;
    private javax.swing.JTextField txtSegundoNombre;
    private javax.swing.JTextField txtTelefono1;
    private javax.swing.JTextField txtTelefono2;
    private javax.swing.JTextField txtTitulacion;
    private javax.swing.JTextField txtbeneficiario1;
    // End of variables declaration//GEN-END:variables
}
