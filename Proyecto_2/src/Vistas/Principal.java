/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Clases.ListaUsuarios;
import Clases.Usuario;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class Principal extends javax.swing.JFrame {

    ListaUsuarios listaUsuarios = new ListaUsuarios();
    Usuario usuarioActual;

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);

        File carpetaTemporal = new File(System.getProperty("user.home") + "/Desktop/Temporal");

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent ant) {
               
                if (carpetaTemporal.exists()) {
                    try {
                        Files.walk(carpetaTemporal.toPath())
                                .sorted(Comparator.reverseOrder())
                                .map(Path::toFile)
                                .forEach(File::delete);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btnIngresarBiblioteca = new javax.swing.JButton();
        btnConvertidor = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnIngresarEditor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ugallery");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(30, 30, 30));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(225, 225, 225));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Menú");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(410, 110, 160, 50);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(320, 100, 20, 230);

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(225, 225, 225));
        jLabel3.setText("Usuario:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 200, 60, 17);

        txtUsuario.setBackground(new java.awt.Color(30, 30, 30));
        txtUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(225, 225, 225));
        txtUsuario.setBorder(null);
        jPanel1.add(txtUsuario);
        txtUsuario.setBounds(100, 190, 170, 28);

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(100, 220, 170, 20);

        btnIngresarBiblioteca.setBackground(new java.awt.Color(0, 128, 255));
        btnIngresarBiblioteca.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnIngresarBiblioteca.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresarBiblioteca.setText("Ingresar");
        btnIngresarBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarBibliotecaActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresarBiblioteca);
        btnIngresarBiblioteca.setBounds(80, 260, 160, 30);

        btnConvertidor.setBackground(new java.awt.Color(0, 128, 255));
        btnConvertidor.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnConvertidor.setForeground(new java.awt.Color(255, 255, 255));
        btnConvertidor.setText("Convertidor");
        btnConvertidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertidorActionPerformed(evt);
            }
        });
        jPanel1.add(btnConvertidor);
        btnConvertidor.setBounds(430, 230, 120, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Bk", 1, 34)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ugallery");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(240, 30, 160, 50);

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(225, 225, 225));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Biblioteca");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 110, 160, 50);

        btnIngresarEditor.setBackground(new java.awt.Color(0, 128, 255));
        btnIngresarEditor.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnIngresarEditor.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresarEditor.setText("Editor");
        btnIngresarEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarEditorActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresarEditor);
        btnIngresarEditor.setBounds(430, 180, 120, 30);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarBibliotecaActionPerformed
        String nombre = txtUsuario.getText();
        
        if(!(nombre.isEmpty())){
        Usuario usuarioIngresado = listaUsuarios.find(nombre);

        if (usuarioIngresado != null) {
            this.usuarioActual = usuarioIngresado;
            JOptionPane.showMessageDialog(null, "Bienvenido " + usuarioIngresado.getNombreUsuario());
        } else {
            Usuario usuarioNuevo = new Usuario(nombre);
            this.usuarioActual = usuarioNuevo;
            listaUsuarios.add(usuarioNuevo);
            JOptionPane.showMessageDialog(null, "Se creó el usuario " + this.usuarioActual.getNombreUsuario());
        }

        Biblioteca biblioteca = new Biblioteca(this, this.usuarioActual);
        txtUsuario.setText("");
        System.out.println("");
        listaUsuarios.imprimir();
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del usuario");
        }
    }//GEN-LAST:event_btnIngresarBibliotecaActionPerformed

    private void btnIngresarEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarEditorActionPerformed
        Editor editor = new Editor(this);
    }//GEN-LAST:event_btnIngresarEditorActionPerformed

    private void btnConvertidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertidorActionPerformed
        Convertidor convertidor = new Convertidor(this,listaUsuarios);
    }//GEN-LAST:event_btnConvertidorActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConvertidor;
    private javax.swing.JButton btnIngresarBiblioteca;
    private javax.swing.JButton btnIngresarEditor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
