/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import controller.Controladora;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;


public class ListarPedidos extends javax.swing.JFrame {
Controladora control= new Controladora();
String nombreUsuario="";
    /**
     * Creates new form ListarPedidos
     */
    public ListarPedidos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false); 
        control.llenarProveedorBox(pedidoBox);
        control.llenarTablaPedidos(Tablapedidos);
        pedidoBox.addItem("Todas");
    }
      public ListarPedidos(String nombreUsuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false); 
        control.llenarProveedorBox(pedidoBox);
        control.llenarTablaPedidos(Tablapedidos);
        pedidoBox.addItem("Todas");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablapedidos = new javax.swing.JTable();
        Atras2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pedidoBox = new javax.swing.JComboBox();
        aplicar = new javax.swing.JButton();
        idTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Pedidos");

        Tablapedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id pedido", "Nombre", "Material", "Fecha de Pedido", "Fecha de Entrega", "Estatus"
            }
        ));
        jScrollPane1.setViewportView(Tablapedidos);

        Atras2.setText("Atrás");
        Atras2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Atras2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Empresa:");

        pedidoBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", " " }));
        pedidoBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pedidoBoxItemStateChanged(evt);
            }
        });
        pedidoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoBoxActionPerformed(evt);
            }
        });

        aplicar.setText("Aplicar Prueba");
        aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarActionPerformed(evt);
            }
        });

        jLabel3.setText("Id del material:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pedidoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(Atras2)
                                .addGap(190, 190, 190))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)))
                        .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(aplicar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pedidoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(Atras2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aplicar)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Atras2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Atras2ActionPerformed
        Menu_pedidos_proveedor ventana = new Menu_pedidos_proveedor(nombreUsuario);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Atras2ActionPerformed

    private void pedidoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoBoxActionPerformed

    }//GEN-LAST:event_pedidoBoxActionPerformed

    private void pedidoBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pedidoBoxItemStateChanged
     String nombre="";
        if (evt.getStateChange()== ItemEvent.SELECTED)
         nombre= pedidoBox.getSelectedItem().toString();
        control.llenarTablaPedidos(Tablapedidos, nombre);
          if (evt.getStateChange()== ItemEvent.SELECTED)
        if(pedidoBox.getSelectedItem().toString().equals("Todas"))
                {
                        control.llenarTablaPedidos(Tablapedidos);
                } 
    }//GEN-LAST:event_pedidoBoxItemStateChanged

    private void aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarActionPerformed
    Date fecha = new Date() ;
    Date fecha2 = new Date() ;
    Calendar cal =Calendar.getInstance();
    cal.add(Calendar.MONTH,1);
    fecha2=cal.getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(fecha);
    String date2 = sdf.format(fecha2);
    
    int pk=Integer.parseInt(idTxt.getText());
    
    int verificarAgregar=control.agregarPruebaMaterial(pk,date,date2);
    if (verificarAgregar==1){
        control.insertarUbicacionPrueba(pk,date,date2,"VARGAS");
        pk=control.devolverUltimaPrueba();
        int planta=control.BuscaPlantaID("VARGAS");
        if(control.agregarPersonalPrueba(pk,"no",planta)==1){
            control.modificarEncargadoPruebaMaterial(pk);
        }
        JOptionPane.showMessageDialog(null,"Se han enviado los materiales a pruebas","Enviado!",JOptionPane.INFORMATION_MESSAGE);
    }
    else{
            if (verificarAgregar==0)
                JOptionPane.showMessageDialog(null,"Fallido","No se pudo enviar!",JOptionPane.ERROR_MESSAGE);
            }
       
    }//GEN-LAST:event_aplicarActionPerformed

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
            java.util.logging.Logger.getLogger(ListarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras2;
    private javax.swing.JTable Tablapedidos;
    private javax.swing.JButton aplicar;
    private javax.swing.JTextField idTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox pedidoBox;
    // End of variables declaration//GEN-END:variables
}
