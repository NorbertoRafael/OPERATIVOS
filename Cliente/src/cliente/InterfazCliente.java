package com.epn.sistemas;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class InterfazCliente extends javax.swing.JFrame {
    
    public InterfazCliente() {
        initComponents();
        textoCliente.setEditable(false);
        combobLibro.addItem("");
        //combobLibro.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txtip = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoCliente = new javax.swing.JTextArea();
        CONECTAR = new javax.swing.JButton();
        BotonEnviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        ComboAutor = new javax.swing.JComboBox();
        combobLibro = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtipKeyPressed(evt);
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("CONTEO DE PALABRAS");

        jLabel3.setText("Autor:");

        jLabel4.setText("Nombre del Libro :");

        jLabel5.setText("Letra a buscar :");

        txtbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtbuscarMouseClicked(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });

        ComboAutor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".", "Alighieri y Dante", "Benito Pérez Galdos", "Eduardo Acevedo Diaz", "Sofocles", "Vicente Blasco Ibanez" }));
        ComboAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboAutorMouseClicked(evt);
            }
        });
        ComboAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAutorActionPerformed(evt);
            }
        });

        combobLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combobLibroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtip, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(68, 68, 68)
                                        .addComponent(CONECTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtbuscar)
                                    .addComponent(combobLibro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(80, 80, 80))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CONECTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combobLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void BotonEnviarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
        try {
            String aux = "";
            String aux1 = "";
            aux = (String) ComboAutor.getSelectedItem();
            
            System.out.println(aux);
            if (aux.equals("Sofocles")) {
//             combobLibro.addItem("Edipo Rey");
//             combobLibro.setVisible(true);
                aux1 = (String) combobLibro.getSelectedItem();
                
            }
            if (aux.equals("Benito Pérez Galdos")) {
//         combobLibro.addItem("El audaz");
//         combobLibro.addItem("La Fontana de Oro");
//         combobLibro.addItem("Prueba");
                
                aux1 = (String) combobLibro.getSelectedItem();
            }
            if (aux.equals("Eduardo Acevedo Diaz")) {
//         combobLibro.addItem("Desde el tronco de un ombu");
                aux1 = (String) combobLibro.getSelectedItem();
            }
            if (aux.equals("Alighieri y Dante")) {
//         combobLibro.addItem("La Divina Comedia");
                aux1 = (String) combobLibro.getSelectedItem();
            }
            if (aux.equals("Vicente Blasco Ibanez")) {
//         combobLibro.addItem("Arroz y Tartana");
//         combobLibro.addItem("La Catedral");
                aux1 = (String) combobLibro.getSelectedItem();
            }
            
            String buscar = "";
            String total = "";
        //Autor=txtAutor.getText();
            //NombreLibro=txtNombreLibro.getText();
            buscar = txtbuscar.getText();
            total = aux + "/" + aux1 + "-" + buscar;
            textoCliente.setText(textoCliente.getText() + " \n Peticion:" + total);
            MainCliente.cliente.MandaServidor(total);            
            System.out.println(total);
            
            txtbuscar.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha conectado");
        }
        
    }                                           

    private void CONECTARActionPerformed(java.awt.event.ActionEvent evt) {                                         
        MainCliente.IniciarHilos(this.txtip.getText());
    }                                        

    private void txtipKeyPressed(java.awt.event.KeyEvent evt) {                                 
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CONECTARActionPerformed(null);
        }
    }                                

    private void ComboAutorMouseClicked(java.awt.event.MouseEvent evt) {                                        
        String aux = "";
        
        aux = (String) ComboAutor.getSelectedItem();
        
        if (aux.equals("Sofocles")) {
            combobLibro.removeAllItems();
            combobLibro.addItem("Edipo Rey");
            
        }
        if (aux.equals("Benito Pérez Galdos")) {
            combobLibro.removeAllItems();
            combobLibro.addItem("El audaz");
            combobLibro.addItem("La Fontana de Oro");
            combobLibro.addItem("Prueba");
        }
        if (aux.equals("Eduardo Acevedo Diaz")) {
            combobLibro.removeAllItems();
            combobLibro.addItem("Desde el tronco de un ombu");
            
        }
        if (aux.equals("Alighieri y Dante")) {
            combobLibro.removeAllItems();
            combobLibro.addItem("La Divina Comedia");
            
        }
        if (aux.equals("Vicente Blasco Ibanez")) {
            combobLibro.removeAllItems();
            combobLibro.addItem("Arroz y Tartana");
            combobLibro.addItem("La Catedral");
            
        }
        combobLibro.setSelectedItem(aux);
        
    }                                       

    private void combobLibroMouseClicked(java.awt.event.MouseEvent evt) {                                         
        ComboAutorMouseClicked(evt);
    }                                        

    private void ComboAutorActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void txtbuscarMouseClicked(java.awt.event.MouseEvent evt) {                                       
        
    }                                      

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {                                     
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BotonEnviarActionPerformed(null);
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

    // Variables declaration - do not modify                     
    private javax.swing.JButton BotonEnviar;
    private javax.swing.JButton CONECTAR;
    private javax.swing.JComboBox ComboAutor;
    private javax.swing.JComboBox combobLibro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea textoCliente;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtip;
    // End of variables declaration                   
}
