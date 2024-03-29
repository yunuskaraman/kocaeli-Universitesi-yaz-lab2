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
public class EnCokDinlenen extends javax.swing.JFrame {

    /** Creates new form EnCokDinlenen */
    
    ArrayList<Integer> sarki_iliski_Id = new ArrayList<Integer>();
    
    
    public EnCokDinlenen() {
        initComponents();
        
        sqlListele();
        
    }
 
    
    void sqlListele(){
        
        DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        String[] kolonlar= {"Şarki Adi","Sanatçı","Süresi","Dinlenme Sayisi","Şarki Türü","Albüm Adi","Ülke Adi","Tarih"};
        Object[] satirlar = new Object[9];
        model.setColumnCount(0);
        model.setRowCount(0);
        model.setColumnIdentifiers(kolonlar);

        ResultSet rs;
        String sorgu= "select sarki.sarki_adi,sanatci.sanatci_adi,sarki.suresi,sarki.dinlenme_sayisi,"+
        "tur.sarki_turu,album.album_adi,ulke.ulke_adi,album.tarih,sarki_iliski.id,sarki.sar_id\n" +
        "from sarki_iliski\n" +
        "inner join sarki on sarki.sar_id=sarki_iliski.sar_id\n" +
        "inner join album on album.alb_id=sarki_iliski.alb_id\n" +
        "inner join tur on tur.tur_id=album.tur_id\n" +
        "inner join sanatci on sanatci.san_id=sarki_iliski.san_id\n" +
        "inner join ulke on ulke.ulke_id=sanatci.ulke_id\n" +
        "group by sarki.sarki_adi,album.album_adi,sarki_turu,suresi,ulke.ulke_adi,"+
        "sarki.dinlenme_sayisi,album.tarih,sanatci.sanatci_adi,sarki_iliski.id,sarki.sar_id\n" +
        "order by dinlenme_sayisi desc;";
        veritabani.baglan();
        rs=veritabani.listele(sorgu);
        int i=0;
        try {
            while(rs.next()){
               
               
                //System.out.println(rs.getString("kul_id")+rs.getString("kullanici_adi")+rs.getString("sifre")+"\n"+rs.getString("premium"));   
                satirlar[0]=rs.getString("sarki_adi");
                satirlar[1]=rs.getString("sanatci_adi");
                satirlar[2]=rs.getString("suresi");
                satirlar[3]=rs.getString("dinlenme_sayisi");
                satirlar[4]=rs.getString("sarki_turu");
                satirlar[5]=rs.getString("album_adi");
                satirlar[6]=rs.getString("ulke_adi");
                satirlar[7]=rs.getString("tarih");
                sarki_iliski_Id.add(Integer.parseInt(rs.getString("id")));
                //sarkiId.add(Integer.parseInt(rs.getString("sar_id")));
                model.addRow(satirlar);
                 if(i==9){
                    break;
                }
                 i++;
            }
            jTable1.setModel(model);
        }
        catch (SQLException ex) {
            Logger.getLogger(Giris.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lbl_kayitSayisi.setText("Toplam Kayıt Sayısı : "+jTable1.getRowCount());
        
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_Ekle = new javax.swing.JButton();
        btn_Ekle1 = new javax.swing.JButton();
        lbl_kayitSayisi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
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
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);

        btn_Ekle.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_Ekle.setText("Müzik Listeme Ekle");
        btn_Ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EkleActionPerformed(evt);
            }
        });

        btn_Ekle1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_Ekle1.setText("Anasayfa");
        btn_Ekle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Ekle1ActionPerformed(evt);
            }
        });

        lbl_kayitSayisi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_kayitSayisi.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Ekle1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_kayitSayisi)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Ekle1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_kayitSayisi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EkleActionPerformed

        if(jTable1.getSelectedRowCount()==1){

           Giris frm = new Giris();
                ResultSet rs;
                String sorgu= "select * from kullanici_sarki where kul_id="+frm.ID+" order by sar_iliski_id";
                
                int id=-1;
                rs=veritabani.listele(sorgu);

                try {
                    while(rs.next()){
                        //System.out.println(rs.getString("kul_id")+rs.getString("kullanici_adi")+rs.getString("sifre")+"\n"+rs.getString("premium"));   
                        id=Integer.parseInt(rs.getString("sar_iliski_id"));
                        System.out.println(id);
                        if(id==sarki_iliski_Id.get(jTable1.getSelectedRow())){
                            id=0;
                            break;
                        }

                    }
                    
                }
                catch (SQLException ex) {
                    Logger.getLogger(Giris.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(id!=0){
                    
        
                    sorgu = "insert into kullanici_sarki(kul_id,sar_iliski_id) values ("+frm.ID+","+sarki_iliski_Id.get(jTable1.getSelectedRow())+")";

                    veritabani.kayitEkle(sorgu);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Şarkı Listede var");
                }
           
        }
        else{
            JOptionPane.showMessageDialog(this,"Herhangi bir şarkı seçilmedi");
        }

    }//GEN-LAST:event_btn_EkleActionPerformed

    private void btn_Ekle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Ekle1ActionPerformed
        
        AnaSayfa frm = new AnaSayfa();
        this.setVisible(false);
        frm.setVisible(true);
        
    }//GEN-LAST:event_btn_Ekle1ActionPerformed

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
            java.util.logging.Logger.getLogger(EnCokDinlenen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnCokDinlenen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnCokDinlenen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnCokDinlenen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnCokDinlenen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ekle;
    private javax.swing.JButton btn_Ekle1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_kayitSayisi;
    // End of variables declaration//GEN-END:variables

}
