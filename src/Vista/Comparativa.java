/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import conexion.ConexionBd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TOSHIBA
 */
public class Comparativa extends javax.swing.JFrame {

    /**
     * Creates new form Comparativa
     */
    private String dato;
    
    public Comparativa() {
        initComponents();
    }
    
   public void setDato(String dato){
        this.dato = dato;
        jTextCC.setText(dato);
        System.out.println("desde comp" + dato);
    }
   
   public void limpiarCajas(){
        TxtFechaDesde.setCalendar(null);
        TxtFechaHasta.setCalendar(null);
        
    }
   
   public void mostar(String cc) throws SQLException{
    
        String query = "SELECT ingreso_id, ingreso_valor, ingreso_descripcion, ingreso_fecha FROM ingreso "
                + "WHERE ingreso_usuario_id = '"+cc+"' ";
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("VALOR");
        dtm.addColumn("DESCRIPCION");
        dtm.addColumn("FECHA");
        
        jTable1.setModel(dtm);
        
        String [] datos = new String[4];
        try {
            Statement st = ConexionBd.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                dtm.addRow(datos);
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN LA CONSULTA" + ex);
        }
    
    }
   
   
   public void mostarGastos(String cc) throws SQLException{
    
        String query = "SELECT gasto_id, gasto_valor, gasto_descripcion, gasto_fecha FROM gasto "
                + "WHERE gasto_usuario_id = '"+cc+"' ";
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("VALOR");
        dtm.addColumn("DESCRIPCION");
        dtm.addColumn("FECHA");
        
        jTable3.setModel(dtm);
        
        String [] datos = new String[4];
        try {
            Statement st = ConexionBd.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                dtm.addRow(datos);
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN LA CONSULTA" + ex);
        }
    
    }
    
    public void mostarFechaGastos(String cc,String fecha,String fecha1) throws SQLException{
    
        String query = "SELECT gasto_id, gasto_valor, gasto_descripcion, gasto_fecha FROM gasto "
                + "WHERE gasto_usuario_id = '"+cc+"' and gasto_fecha between '"+fecha+"' and '"+fecha1+"'"
                + "order by gasto_fecha desc ";
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("VALOR");
        dtm.addColumn("DESCRIPCION");
        dtm.addColumn("FECHA");
        
        jTable3.setModel(dtm);
        
        String [] datos = new String[4];
        try {
            Statement st = ConexionBd.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                dtm.addRow(datos);
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN LA CONSULTA" + ex);
        }
    
    }
   
    public void mostarFechaIngresos(String cc,String fecha,String fecha1) throws SQLException{
    
        String query = "SELECT ingreso_id, ingreso_valor, ingreso_descripcion, ingreso_fecha FROM ingreso "
                + "WHERE ingreso_usuario_id = '"+cc+"' and ingreso_fecha between '"+fecha+"' and '"+fecha1+"'"
                + "order by ingreso_fecha desc ";
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("VALOR");
        dtm.addColumn("DESCRIPCION");
        dtm.addColumn("FECHA");
        
        jTable1.setModel(dtm);
        
        String [] datos = new String[4];
        try {
            Statement st = ConexionBd.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                dtm.addRow(datos);
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN LA CONSULTA" + ex);
        }
    
    }
    
    public void mostaTotalesIngresos(String cc) throws SQLException{
    
        String query = "SELECT sum(ingreso_valor) FROM ingreso "
                + "WHERE  ingreso_usuario_id = '"+cc+"'";
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Ingresos Totales");
       
        jTable2.setModel(dtm);
        
        String [] datos = new String[1];
        try {
            Statement st = ConexionBd.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                datos[0] = rs.getString(1);
                dtm.addRow(datos);
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN LA CONSULTA" + ex);
        }
    
    }
    
    public void mostaTotalesGastos(String cc) throws SQLException{
    
        String query = "SELECT sum(gasto_valor) FROM gasto "
                + "WHERE  gasto_usuario_id = '"+cc+"'";
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Gasto Totales");
       
        jTable4.setModel(dtm);
        
        String [] datos = new String[1];
        try {
            Statement st = ConexionBd.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                datos[0] = rs.getString(1);
                dtm.addRow(datos);
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN LA CONSULTA" + ex);
        }
    
    }
    
    public void mostaTotalesFechaIngreso(String cc,String fecha,String fecha1) throws SQLException{
    
        String query = "SELECT IFNULL(sum(ingreso_valor), 0.00) FROM ingreso "
                + "WHERE ingreso_usuario_id = '"+cc+"'"
                + "and ingreso_fecha between '"+fecha+"' and '"+fecha1+"'";
                
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Ingresos Por Fecha");

        jTable2.setModel(dtm);
        
        String [] datos = new String[1];
        try {
            Statement st = ConexionBd.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("estra al query total por fecha " + query);
            while(rs.next()){
                datos[0] = rs.getString(1);
                dtm.addRow(datos);
                System.out.println("estra al query total por fecha- datos   " + datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN LA CONSULTA" + dtm);
        }
    
    }
    
    public void mostaTotalesFechaGastos(String cc,String fecha,String fecha1) throws SQLException{
    
        String query = "SELECT IFNULL(sum(gasto_valor),0.00) FROM gasto "
                + "WHERE gasto_usuario_id = '"+cc+"'"
                + "and gasto_fecha between '"+fecha+"' and '"+fecha1+"'";
                
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Gastos Por Fecha");

        jTable4.setModel(dtm);
        
        String [] datos = new String[1];
        try {
            Statement st = ConexionBd.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("estra al query total por fecha " + query);
            while(rs.next()){
                datos[0] = rs.getString(1);
                dtm.addRow(datos);
                System.out.println("estra al query total por fecha- datos   " + datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN LA CONSULTA" + dtm);
        }
    
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
        jTable3 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextCC = new javax.swing.JTextField();
        jBtnCargar = new javax.swing.JButton();
        jBtnDevolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtFechaDesde = new com.toedter.calendar.JDateChooser();
        TxtFechaHasta = new com.toedter.calendar.JDateChooser();
        jBtnConsultaFecha = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("INFORMACIÓN FINANCIERA");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable3);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Ingresos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Gastos");

        jTextCC.setEditable(false);
        jTextCC.setEnabled(false);
        jTextCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCCActionPerformed(evt);
            }
        });

        jBtnCargar.setBackground(new java.awt.Color(255, 0, 0));
        jBtnCargar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnCargar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnCargar.setText("Cargar");
        jBtnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCargarActionPerformed(evt);
            }
        });

        jBtnDevolver.setBackground(new java.awt.Color(255, 0, 0));
        jBtnDevolver.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnDevolver.setForeground(new java.awt.Color(255, 255, 255));
        jBtnDevolver.setText("Devolver");
        jBtnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDevolverActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Filtrar por fecha:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Desde:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Hasta:");

        TxtFechaDesde.setDateFormatString("yyyy-MM-dd");

        TxtFechaHasta.setDateFormatString("yyyy-MM-dd");

        jBtnConsultaFecha.setBackground(new java.awt.Color(255, 0, 0));
        jBtnConsultaFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnConsultaFecha.setForeground(new java.awt.Color(255, 255, 255));
        jBtnConsultaFecha.setText("Consulta Por Fecha");
        jBtnConsultaFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConsultaFechaActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Ingresos Totales"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Gastos Totales"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(184, 184, 184))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnDevolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnCargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextCC, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnConsultaFecha))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel1)
                .addContainerGap(254, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnCargar)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jBtnDevolver)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnConsultaFecha)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCCActionPerformed

    private void jBtnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCargarActionPerformed
        String cc = jTextCC.getText();
        try {
            mostar(cc);
            mostarGastos(cc);
            mostaTotalesIngresos(cc);
            mostaTotalesGastos(cc);
            limpiarCajas();
        } catch (SQLException ex) {
            Logger.getLogger(ListIngresos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_jBtnCargarActionPerformed

    private void jBtnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDevolverActionPerformed
        // TODO add your handling code here:
        Cuenta cuenta = new Cuenta();
        cuenta.setDato(jTextCC.getText());
        cuenta.setVisible(true);
    }//GEN-LAST:event_jBtnDevolverActionPerformed

    private void jBtnConsultaFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConsultaFechaActionPerformed
        // TODO add your handling code here:
        String cc = jTextCC.getText();
        String fecha = ((JTextField)TxtFechaDesde.getDateEditor().getUiComponent()).getText();
        String fecha1 = ((JTextField)TxtFechaHasta.getDateEditor().getUiComponent()).getText();
        try {
            mostaTotalesFechaIngreso(cc, fecha, fecha1);
            mostaTotalesFechaGastos(cc, fecha, fecha1);
            mostarFechaIngresos(cc, fecha, fecha1);
            System.out.println("traer por fecha" + cc + fecha +fecha1 );
            mostarFechaGastos(cc, fecha, fecha1);
            
        } catch (SQLException ex) {
            Logger.getLogger(Comparativa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnConsultaFechaActionPerformed

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
            java.util.logging.Logger.getLogger(Comparativa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comparativa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comparativa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comparativa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser TxtFechaDesde;
    private com.toedter.calendar.JDateChooser TxtFechaHasta;
    private javax.swing.JButton jBtnCargar;
    private javax.swing.JButton jBtnConsultaFecha;
    private javax.swing.JButton jBtnDevolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    public javax.swing.JTable jTable3;
    public javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextCC;
    // End of variables declaration//GEN-END:variables
}
