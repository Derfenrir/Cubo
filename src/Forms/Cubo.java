/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 *
 * @author 52934
 */
public class Cubo extends javax.swing.JFrame {
 Graphics lapiz;
    private int horizontal, vertical;
    private int derecha, izquierda;
     private int tamaño=50;
     private int altop, largop;
     
     private void refrescar(){
         lapiz.setColor(Color.decode("#ffffff"));
         lapiz.fillRect(0, 0, largop, altop);
         lapiz.setColor(Color.decode("#171717"));
         
     }
     private void crearCubo(){
         lapiz.drawRect(horizontal + derecha, (tamaño/2) + vertical, tamaño, tamaño);
         lapiz.drawRect((tamaño / 2) + horizontal + izquierda, vertical, tamaño, tamaño);
         
         lapiz.drawLine(horizontal+derecha,(tamaño/2)+vertical,(tamaño/2)+horizontal+izquierda,vertical);
         lapiz.drawLine(tamaño+horizontal+derecha, (tamaño/2)+vertical, (tamaño+(tamaño/2))+horizontal+izquierda,vertical);
         lapiz.drawLine(tamaño+horizontal+derecha,(tamaño+(tamaño/2))+vertical, tamaño+(tamaño/2)+horizontal+izquierda, tamaño+vertical);
         lapiz.drawLine(horizontal+derecha, (tamaño+(tamaño/2))+vertical, (tamaño/2)+horizontal+izquierda, tamaño+vertical);
         
     }
     public void limites(){
         int limite;
         if (tamaño>altop-(tamaño/2)||tamaño>largop-(tamaño/2)){
             tamaño=largop-(tamaño/2);
         }
         limite=largop-(tamaño+(tamaño/2));
         if(horizontal>limite){
             horizontal = limite -1;
         }
         limite=altop-(tamaño+(tamaño/2));
         if (vertical > limite){
             vertical = limite -1;
         }
     }
     
    /**
     * Creates new form Cubo
     */
          int izq=1,der=1;
    public Cubo() {
        this.setResizable(false);
        initComponents();
        this.setLocationRelativeTo(null);
        
        lapiz = Fondo.getGraphics();
        altop = Fondo.getHeight();
        largop = Fondo.getWidth();
        horizontal = 0;
        vertical = 0;
        derecha = 0;
        izquierda = 0;
        btnCrear.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyChar() == '+'){
                    refrescar();
                    tamaño += 10;
                    crearCubo();
                    limites();
                }
                else if (e.getKeyChar() =='-'){
                    refrescar();
                    tamaño=tamaño>10? (tamaño-10): 10;
                    crearCubo();
                }
                else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                    refrescar();
                    horizontal +=10;
                    limites();
                    crearCubo();
                }
                else if (e.getKeyCode()==KeyEvent.VK_LEFT){
                    refrescar();
                    horizontal=horizontal>0?(horizontal-10):0;
                    crearCubo();
                
                }
                else if (e.getKeyCode()==KeyEvent.VK_UP){
                    refrescar();
                    vertical=vertical>0?(vertical-10):0;
                    crearCubo();
                }
                else if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    refrescar();
                    vertical+=10;
                    limites();
                    crearCubo();
                }
                else if (e.getKeyChar()=='q'){
                    refrescar();
                    if (izquierda > - (tamaño/2) && izq == 1){
                        izquierda -=2;
                        derecha+=2;
                        
                    }
                    else if (izq==0){
                        izq =1;
                        
                    }
                else{
                        izquierda +=2;
                        derecha -=2;
                                
                    }
                    limites();
                    crearCubo();
                }
                else if (e.getKeyChar()=='w'){
                    refrescar();
                    if (izquierda < 0 && der == 1){
                        izquierda +=2;
                        derecha-=2;
                        
                    }
                    else if (der==0){
                        der =1;
                        
                    }
                else{
                        izquierda -=2;
                        derecha +=2;
                                
                    }
                    limites();
                    crearCubo();
                }
            }
        }); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Fondo = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        Fondo.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        btnCrear.setBackground(new java.awt.Color(204, 204, 255));
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(btnCrear)
                .addGap(0, 33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnCrear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
      refrescar();
    }//GEN-LAST:event_btnCrearActionPerformed

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
            java.util.logging.Logger.getLogger(Cubo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cubo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cubo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cubo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cubo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton btnCrear;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
