package cliente;

import static cliente.MainCliente.cifrado13;
import java.awt.event.KeyEvent;

public class InterfazCliente extends javax.swing.JFrame {

    public InterfazCliente() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtip = new javax.swing.JTextField();
        PeticionCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoCliente = new javax.swing.JTextArea();
        CONECTAR = new javax.swing.JButton();
        BotonEnviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtipKeyPressed(evt);
            }
        });

        PeticionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PeticionClienteActionPerformed(evt);
            }
        });
        PeticionCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PeticionClienteKeyPressed(evt);
            }
        });

        textoCliente.setColumns(20);
        textoCliente.setRows(5);
        jScrollPane1.setViewportView(textoCliente);

        CONECTAR.setText("CONECTAR");
        CONECTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONECTARActionPerformed(evt);
            }
        });

        BotonEnviar.setText("ENVIAR");
        BotonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEnviarActionPerformed(evt);
            }
        });

        jLabel1.setText("Direccion IP destino");

        jLabel2.setText("DICCIONARIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtip, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CONECTAR)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(BotonEnviar)
                        .addGap(18, 18, 18)
                        .addComponent(PeticionCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtip, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CONECTAR)
                        .addComponent(jLabel1)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PeticionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonEnviar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEnviarActionPerformed

       try{
        String Autor="";
        String NombreLibro="";
        String buscar="";
        String total="";
        Autor=txtAutor.getText();
        NombreLibro=txtNombreLibro.getText();
        buscar=txtbuscar.getText();
        total=Autor+"/"+NombreLibro+"-"+buscar;
        textoCliente.setText(textoCliente.getText()+" \n Peticion:"+total);
        MainCliente.cliente.MandaServidor(total);        
        txtAutor.setText("");
        txtNombreLibro.setText("");
        txtbuscar.setText("");
       }catch(Exception e)
       {
       JOptionPane.showMessageDialog(null, "No se ha conectado");
       }
      
    }       
      
    }//GEN-LAST:event_BotonEnviarActionPerformed

    private void CONECTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONECTARActionPerformed
        MainCliente.initCliente(this.txtip.getText());// TODO add your handling code here:
    }//GEN-LAST:event_CONECTARActionPerformed

    private void PeticionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PeticionClienteActionPerformed
        
    }//GEN-LAST:event_PeticionClienteActionPerformed

    private void PeticionClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PeticionClienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BotonEnviarActionPerformed(null);
        }
    }//GEN-LAST:event_PeticionClienteKeyPressed

    private void txtipKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtipKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CONECTARActionPerformed(null);
        }
    }//GEN-LAST:event_txtipKeyPressed

    
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
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEnviar;
    private javax.swing.JButton CONECTAR;
    private javax.swing.JTextField PeticionCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea textoCliente;
    private javax.swing.JTextField txtip;
    // End of variables declaration//GEN-END:variables
}
