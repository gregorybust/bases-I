/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import controller.Controladora;
import java.sql.Connection;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author GREGORIO-PC
 */
public class Equipo extends javax.swing.JFrame {
Controladora control = new Controladora();
String nombreUsuario="";
    /**
     * Creates new form Equipo
     */
    public Equipo() {
        initComponents();
    }
    public Equipo(String nombreUsuario) {
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ensamblaje = new javax.swing.JButton();
        pruebaPieza = new javax.swing.JButton();
        pruebaMaterial = new javax.swing.JButton();
        atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Equipo Mas Eficiente");

        ensamblaje.setText("Ensamblajes de Piezas");
        ensamblaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ensamblajeActionPerformed(evt);
            }
        });

        pruebaPieza.setText("Pruebas de Piezas");
        pruebaPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruebaPiezaActionPerformed(evt);
            }
        });

        pruebaMaterial.setText("Pruebas de Matariales");
        pruebaMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruebaMaterialActionPerformed(evt);
            }
        });

        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(atras))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pruebaPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pruebaMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ensamblaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(ensamblaje)
                .addGap(28, 28, 28)
                .addComponent(pruebaPieza)
                .addGap(32, 32, 32)
                .addComponent(pruebaMaterial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(atras)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        Reportes ventana = new Reportes(nombreUsuario);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_atrasActionPerformed

    private void ensamblajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ensamblajeActionPerformed
        try{
                Connection conexion = control.conexion();
                
                JasperReport reporte;
                String path="C:\\Users\\GREGORIO-PC\\Documents\\NetBeansProjects\\airUcab\\build\\classes\\reporte\\EquipoMasEficienteEnsamblajes.jasper";
                reporte=(JasperReport) JRLoader.loadObjectFromFile(path);

                JasperPrint jprint=JasperFillManager.fillReport(reporte,null, conexion);
                JasperViewer viewer=new JasperViewer(jprint,false);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                viewer.setVisible(true);
                
            }
            catch(JRException e){
                System.out.println("Error");
            }
    }//GEN-LAST:event_ensamblajeActionPerformed

    private void pruebaPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruebaPiezaActionPerformed
         try{
                Connection conexion = control.conexion();
                
                JasperReport reporte;
                String path="C:\\Users\\GREGORIO-PC\\Documents\\NetBeansProjects\\airUcab\\build\\classes\\reporte\\EquipoMasEficienteEnPruebasPiezas.jasper";
                reporte=(JasperReport) JRLoader.loadObjectFromFile(path);

                JasperPrint jprint=JasperFillManager.fillReport(reporte,null, conexion);
                JasperViewer viewer=new JasperViewer(jprint,false);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                viewer.setVisible(true);
                
            }
            catch(JRException e){
                System.out.println("Error");
            }
    }//GEN-LAST:event_pruebaPiezaActionPerformed

    private void pruebaMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruebaMaterialActionPerformed
            try{
                Connection conexion = control.conexion();
                
                JasperReport reporte;
                String path="C:\\Users\\GREGORIO-PC\\Documents\\NetBeansProjects\\airUcab\\build\\classes\\reporte\\EquipoMasEficientePruebasMateriales.jasper";
                reporte=(JasperReport) JRLoader.loadObjectFromFile(path);

                JasperPrint jprint=JasperFillManager.fillReport(reporte,null, conexion);
                JasperViewer viewer=new JasperViewer(jprint,false);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                viewer.setVisible(true);
                
            }
            catch(JRException e){
                System.out.println("Error");}
    }//GEN-LAST:event_pruebaMaterialActionPerformed

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
            java.util.logging.Logger.getLogger(Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Equipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JButton ensamblaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton pruebaMaterial;
    private javax.swing.JButton pruebaPieza;
    // End of variables declaration//GEN-END:variables
}