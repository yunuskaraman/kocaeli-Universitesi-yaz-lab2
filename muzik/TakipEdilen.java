/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muzikdosyam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YunusKARAMAN
 */
public class TakipEdilen extends javax.swing.JFrame {

    /**
     * Creates new form TakipEdilen
     */
   static int  tId;
    
    
    ArrayList<Integer> kullanici_takip_Id = new ArrayList<Integer>();
    ArrayList<Integer> kullanici_takip_tId = new ArrayList<Integer>();
    
    public TakipEdilen() {
        initComponents();
        
        sqlTakipEdilenler();
    }
    
    void sqlTakipEdilenler( ){
        
        kullanici_takip_Id.clear();
        
        Giris frm = new Giris();
        
        DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        String[] kolonlar= {"Kullanici Adi"};
        Object[] satirlar = new Object[1];
        model.setColumnCount(0);
        model.setRowCount(0);
        model.setColumnIdentifiers(kolonlar);

        ResultSet rs;
        String sorgu= "select kullanici.kullanici_adi,kullanici_takip.id,kullanici_takip.tkul_id from kullanici inner join kullanici_takip \n" +
        "on kullanici_takip.tkul_id=kullanici.kul_id\n" +
        "where kullanici_takip.kul_id=("+frm.ID+")\n" +
        "group by kullanici.kullanici_adi,kullanici_takip.id,kullanici_takip.tkul_id";
        veritabani.baglan();
        rs=veritabani.listele(sorgu);
        
        try {
            while(rs.next()){
                //System.out.println(rs.getString("kul_id")+rs.getString("kullanici_adi")+rs.getString("sifre")+"\n"+rs.getString("premium"));   
                satirlar[0]=rs.getString("kullanici_adi");
                kullanici_takip_Id.add(Integer.parseInt(rs.getString("id")));
                kullanici_takip_tId.add(Integer.parseInt(rs.getString("tkul_id")));
                model.addRow(satirlar);
            }
            jTable1.setModel(model);
        }
        catch (SQLException ex) {
            Logger.getLogger(Giris.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_anasayfa = new javax.swing.JButton();
        btn_takipBirak = new javax.swing.JButton();
        btn_muzikListesi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btn_anasayfa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_anasayfa.setText("Anasayfa");
        btn_anasayfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anasayfaActionPerformed(evt);
            }
        });

        btn_takipBirak.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_takipBirak.setText("Takibi Bırak");
        btn_takipBirak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_takipBirakActionPerformed(evt);
            }
        });

        btn_muzikListesi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_muzikListesi.setText("Muzik Listesini Gör");
        btn_muzikListesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_muzikListesiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_takipBirak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_muzikListesi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_anasayfa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_anasayfa, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btn_takipBirak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_muzikListesi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_anasayfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anasayfaActionPerformed

        AnaSayfa frm = new AnaSayfa();
        this.setVisible(false);
        frm.setVisible(true);

    }//GEN-LAST:event_btn_anasayfaActionPerformed

    private void btn_takipBirakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_takipBirakActionPerformed

        if(jTable1.getSelectedRowCount()==1){
            veritabani.baglan();

            String sorgu= "delete from kullanici_takip where id = ("+kullanici_takip_Id.get(jTable1.getSelectedRow())+")";
            System.out.println(kullanici_takip_Id.get(jTable1.getSelectedRow()));
            veritabani.KayitSil(sorgu);

            sqlTakipEdilenler();
        }
        else{
            JOptionPane.showMessageDialog(this,"Herhangi bir Kullanici seçilmedi");
        }
    }//GEN-LAST:event_btn_takipBirakActionPerformed

    private void btn_muzikListesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_muzikListesiActionPerformed
        
        if(jTable1.getSelectedRowCount()==1){
                
            tId =kullanici_takip_tId.get(jTable1.getSelectedRow());
        
            TakipMuzikListesi frm = new TakipMuzikListesi();
            this.setVisible(false);
            frm.setVisible(true);
            
        }
        else{
            JOptionPane.showMessageDialog(this,"Herhangi bir Kullanici seçilmedi");
        }
        
        
        
        
    }//GEN-LAST:event_btn_muzikListesiActionPerformed

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
            java.util.logging.Logger.getLogger(TakipEdilen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakipEdilen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakipEdilen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakipEdilen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakipEdilen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anasayfa;
    private javax.swing.JButton btn_muzikListesi;
    private javax.swing.JButton btn_takipBirak;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
