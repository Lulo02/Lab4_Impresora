
package lab4_impresora;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class SimuladorImpresora extends javax.swing.JFrame {

    static Queue<String> nombre = new LinkedList<String>();
    static Queue<Integer> paginas = new LinkedList<Integer>();
    final int TIEMPO_IMPRESION_PAGINA = 1;
    private String Tnombre;
    private int Tpaginas;
    
   
    
    
    public SimuladorImpresora() {
        initComponents();
         
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BtnAgregarArchivo = new javax.swing.JButton();
        BtnIniciar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        PRest = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NomDo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre del archivo: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 25));

        BtnAgregarArchivo.setText("Agregar Archivo");
        BtnAgregarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarArchivoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAgregarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        BtnIniciar.setText("Iniciar");
        BtnIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnIniciarMouseClicked(evt);
            }
        });
        BtnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gigimpresora.gif"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, 90));
        jPanel1.add(PRest, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 140, 30));

        jLabel3.setText("Paginas restantes:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, 20));
        jPanel1.add(NomDo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarArchivoActionPerformed
         Agregar n1=new Agregar();
        n1.setVisible(true);
        
    }//GEN-LAST:event_BtnAgregarArchivoActionPerformed

    private void BtnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIniciarActionPerformed

        
        try {
            Importar();
        } catch (InterruptedException ex) {
            Logger.getLogger(SimuladorImpresora.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }//GEN-LAST:event_BtnIniciarActionPerformed

    private void BtnIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIniciarMouseClicked
      
    }//GEN-LAST:event_BtnIniciarMouseClicked
    
    

    
    public void Importar() throws InterruptedException{
        
        try{
            
            CsvReader leerDoc=new CsvReader("CaracteristicasDocumentos.csv");
            leerDoc.readHeaders();
            
            while (leerDoc.readRecord()){
                 Tnombre=leerDoc.get(0);
                 Tpaginas=Integer.parseInt(leerDoc.get(1));
                 
                 nombre.add(Tnombre);
                 paginas.add(Tpaginas);
            }
            
            leerDoc.close(); //cerrar el archivo 
            
            while(!nombre.isEmpty()&&!paginas.isEmpty()){
                int numPag=paginas.peek();
            String nombArch=nombre.peek();
            System.out.println("Nombre del archivo: " +nombre.peek());
           
            
            for(int i=numPag; i>0;i--){
                System.out.println("Faltan "+numPag+" paginas");
                NomDo.setText(nombArch);
                numPag--;
                Thread.sleep(1*TIEMPO_IMPRESION_PAGINA*1000);
            }
        nombre.poll();
        paginas.poll();
              
            }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    

 
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
            java.util.logging.Logger.getLogger(SimuladorImpresora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimuladorImpresora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimuladorImpresora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimuladorImpresora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
      
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimuladorImpresora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarArchivo;
    private javax.swing.JButton BtnIniciar;
    private javax.swing.JLabel NomDo;
    private javax.swing.JLabel PRest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
