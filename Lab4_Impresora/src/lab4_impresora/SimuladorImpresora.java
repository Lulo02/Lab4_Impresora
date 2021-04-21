
package lab4_impresora;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class SimuladorImpresora extends javax.swing.JFrame {

    Queue<String> nombre = new LinkedList<String>();
    Queue<Integer> paginas = new LinkedList<Integer>();
    final int TIEMPO_IMPRESION_PAGINA = 1;
    String Tnombre;
    int Tpaginas;
    
    
    
    
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
        NomDoc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre del archivo: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 31, -1, 25));

        BtnAgregarArchivo.setText("Agregar Archivo");
        BtnAgregarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarArchivoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAgregarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

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
        jPanel1.add(BtnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gigimpresora.gif"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 120, 90));
        jPanel1.add(NomDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 70, 30));

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

    private void BtnAgregarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarArchivoActionPerformed
        Tnombre=JOptionPane.showInputDialog("Ingrese el nombre del documento");
        
          Tpaginas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de paginas"));
         
         nombre.add(Tnombre);
         paginas.add(Tpaginas);
    }//GEN-LAST:event_BtnAgregarArchivoActionPerformed

    private void BtnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIniciarActionPerformed

        
        
        
        while(!paginas.isEmpty()&&!nombre.isEmpty()){
            
            int numPag=paginas.peek();
            String nombArch=nombre.peek();
            NomDoc.setText(nombre.peek());
           
            try {
                Imprimir();
            } catch (InterruptedException ex) {
                Logger.getLogger(SimuladorImpresora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       

        

    }//GEN-LAST:event_BtnIniciarActionPerformed

    private void BtnIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIniciarMouseClicked
       
    }//GEN-LAST:event_BtnIniciarMouseClicked
    
    
 public void Imprimir() throws InterruptedException{
        int numPag= paginas.peek();
        Thread.sleep(numPag*TIEMPO_IMPRESION_PAGINA*1000);
        nombre.poll();
        paginas.poll();
    }
   
   /* public void Mostrar(){
       String nombArch=null;
      
       while(!paginas.isEmpty()){
            numPag=paginas.peek();
       }
       while(!nombre.isEmpty()){
            nombArch=nombre.peek();
       }
       
       NombreDoc.setText(nombArch);
       
   }*/
    
    
    
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
    private javax.swing.JLabel NomDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
