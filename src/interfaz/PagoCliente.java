/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import controller.Controladora;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class PagoCliente extends javax.swing.JFrame {
Controladora control =  new Controladora (); 
   int idPedidoCliente_1; 
   String nombreUsuario="";
    /**C
     * Creates new form SolicitudesProveedor
     */
    public PagoCliente( int idPedidoCliente) {
        
        initComponents();
         
         this.setLocationRelativeTo(null);
        this.setResizable(false); 
//        control.llenarTablaPago(tablaSolicitudes);
       idPedidoCliente_1 = idPedidoCliente;
     pagoCombo.removeAllItems();
     
        pagoCombo.addItem("Seleccione Forma de Pago");
        pagoCombo.addItem("transferencia");
        pagoCombo.addItem("tarjeta");
        bancoTxt.setVisible(false);
        cuentaTxt.setVisible(false);
        transTxt.setVisible(false);
        jLabel4.setVisible(false);
        numC.setVisible(false);
       jLabel5.setVisible(false);
calendar.setVisible(false);
    }
      public PagoCliente( int idPedidoCliente,String nombreUsuario) {
        
        initComponents();
         
         this.setLocationRelativeTo(null);
        this.setResizable(false); 
//        control.llenarTablaPago(tablaSolicitudes);
       idPedidoCliente_1 = idPedidoCliente;
     pagoCombo.removeAllItems();
     
        pagoCombo.addItem("Seleccione Forma de Pago");
        pagoCombo.addItem("transferencia");
        pagoCombo.addItem("tarjeta");
        bancoTxt.setVisible(false);
        cuentaTxt.setVisible(false);
        transTxt.setVisible(false);
        jLabel4.setVisible(false);
        numC.setVisible(false);
       jLabel5.setVisible(false);
calendar.setVisible(false);
this.nombreUsuario=nombreUsuario;

    }

    private PagoCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Atras2 = new javax.swing.JButton();
        pagar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pagoCombo = new javax.swing.JComboBox();
        bancoTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cuentaTxt = new javax.swing.JTextField();
        transTxt = new javax.swing.JTextField();
        numC = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        calendar = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Pagar Pedido cliente");

        Atras2.setText("Atrás");
        Atras2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Atras2ActionPerformed(evt);
            }
        });

        pagar.setText("Pagar");
        pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarActionPerformed(evt);
            }
        });

        jLabel3.setText("Forma de pago:");

        pagoCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pagoCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pagoComboItemStateChanged(evt);
            }
        });

        jLabel4.setText("Banco:");

        cuentaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuentaTxtActionPerformed(evt);
            }
        });

        numC.setText("Número de cuenta:");

        jLabel5.setText("Numero de Transferencia:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(Atras2)
                            .addGap(254, 254, 254)
                            .addComponent(pagar))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bancoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                        .addComponent(pagoCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(numC)
                                        .addComponent(jLabel5))
                                    .addGap(25, 25, 25)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(transTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cuentaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pagoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(bancoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numC)
                            .addComponent(cuentaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(transTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(Atras2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pagar)
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Atras2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Atras2ActionPerformed
        ListarPedidosClienteNueva ventana = new ListarPedidosClienteNueva(nombreUsuario);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Atras2ActionPerformed

    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
        //try {
       String fecha_pago= control.devolverFechaFinalEnsamblajeAvionPago(idPedidoCliente_1);
    
        
         
         
  int verificar = 0;       
        int ver ;
       if ( (pagoCombo.getSelectedItem().equals("transferencia"))){
           
            String monto = control.DevolvermontoPedidoCliente(idPedidoCliente_1);
            ver = control.agregarFormaDePagoAvion(idPedidoCliente_1,pagoCombo.getSelectedItem().toString(), Integer.parseInt(transTxt.getText()), bancoTxt.getText(), Integer.parseInt(cuentaTxt.getText()), 0, null,monto);
            System.out.println(ver);
       if (ver == 1) 
       verificar =  control.modificarFechadePagoAvion(idPedidoCliente_1, fecha_pago);
       JOptionPane.showMessageDialog(null, "El pago se a realizado con éxito ", " Pago realizado", JOptionPane.INFORMATION_MESSAGE);
       }
       else
       if ( (pagoCombo.getSelectedItem().equals("tarjeta"))){

           String monto = control.DevolvermontoPedidoCliente(idPedidoCliente_1);
            ver = control.agregarFormaDePagoAvion(idPedidoCliente_1,pagoCombo.getSelectedItem().toString(), 0, bancoTxt.getText(), 0,  Integer.parseInt(cuentaTxt.getText()),fecha_pago,monto);
            if (ver == 1) 
              verificar =  control.modificarFechadePagoAvion(idPedidoCliente_1, fecha_pago);
            if (verificar == 1){
                    JOptionPane.showMessageDialog(null, "El pago se a realizado con éxito ", " Pago realizado", JOptionPane.INFORMATION_MESSAGE);
           
      }
      else 
                  JOptionPane.showMessageDialog(null, "ERROR, pago fallido " , "ERROR", JOptionPane.ERROR_MESSAGE);
       }

 //}
//catch(Exception e)
        //{
                 // JOptionPane.showMessageDialog(null, "ERROR, pago fallido " , "ERROR", JOptionPane.ERROR_MESSAGE);
            //
  //}                                     

     
    }//GEN-LAST:event_pagarActionPerformed

    private void cuentaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuentaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuentaTxtActionPerformed

    private void pagoComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pagoComboItemStateChanged

  if (evt.getStateChange()== ItemEvent.SELECTED)
       {
         if (pagoCombo.getSelectedItem().equals("transferencia")){
        bancoTxt.setVisible(true);
        cuentaTxt.setVisible(true);
        transTxt.setVisible(true);
        jLabel4.setVisible(true);
         calendar.setVisible(false);
            
            jLabel5.setText("Numero de transferencia");

            numC.setText("Numero de cuenta");

        numC.setVisible(true);
       jLabel5.setVisible(true);}
       else 
        if (pagoCombo.getSelectedItem().equals("tarjeta"))
        {
        bancoTxt.setVisible(true);
        jLabel4.setVisible(true);
        numC.setVisible(true);
        numC.setText("Numero de Tarjeta");
        transTxt.setVisible(false);
        jLabel5.setVisible(true);
            calendar.setVisible(true);
            cuentaTxt.setVisible(true);
            jLabel5.setText("Fecha de Vencimiento");

        }
       
       }
  

    }//GEN-LAST:event_pagoComboItemStateChanged

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
            java.util.logging.Logger.getLogger(PagoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PagoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras2;
    private javax.swing.JTextField bancoTxt;
    private com.toedter.calendar.JDateChooser calendar;
    private javax.swing.JTextField cuentaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel numC;
    private javax.swing.JButton pagar;
    private javax.swing.JComboBox pagoCombo;
    private javax.swing.JTextField transTxt;
    // End of variables declaration//GEN-END:variables
}
