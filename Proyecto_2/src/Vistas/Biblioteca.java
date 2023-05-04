/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Clases.Categoria;
import Clases.Imagen;
import Clases.ListaImagenes;
import Clases.NodoDoble;
import Clases.Usuario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Fernando
 */
public class Biblioteca extends javax.swing.JFrame {

    /**
     * Creates new form Biblioteca
     */
    Principal principal;
    Usuario usuarioActual;
    ListaImagenes listaImagenes;
    boolean primerCambio = true;
    NodoDoble actual;

    public Biblioteca(Principal principal, Usuario usuarioActual) {
        initComponents();
        setLocationRelativeTo(null);
        this.principal = principal;
        this.usuarioActual = usuarioActual;
        principal.setVisible(false);

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent ant) {
                principal.setVisible(true);
            }
        });

        this.lblNombreUsuario.setText(this.usuarioActual.getNombreUsuario());
        this.setVisible(true);

        llenarCategorias();
        obtenerListaImagenes("General");
        llenarImagenes();
        lstCategorias.setSelectedIndex(0);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList<>();
        lblNombreUsuario = new javax.swing.JLabel();
        txtNombreImagen = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btnEliminarCategoria = new javax.swing.JButton();
        btnAgregarCategoria = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        btnAnterior = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtGeneral = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstImagenes = new javax.swing.JList<>();
        btnEliminarImagen = new javax.swing.JButton();
        btnAgregarImagen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Biblioteca");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(30, 30, 30));
        jPanel1.setLayout(null);

        lstCategorias.setBackground(new java.awt.Color(30, 30, 30));
        lstCategorias.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lstCategorias.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lstCategorias.setForeground(new java.awt.Color(255, 255, 255));
        lstCategorias.setSelectionBackground(new java.awt.Color(0, 128, 255));
        lstCategorias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCategoriasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstCategorias);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 60, 110, 100);

        lblNombreUsuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreUsuario.setText("Usuario");
        jPanel1.add(lblNombreUsuario);
        lblNombreUsuario.setBounds(570, 20, 100, 17);

        txtNombreImagen.setEditable(false);
        txtNombreImagen.setBackground(new java.awt.Color(30, 30, 30));
        txtNombreImagen.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombreImagen.setForeground(new java.awt.Color(225, 225, 225));
        txtNombreImagen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreImagen.setText("Nombre de la imagen");
        txtNombreImagen.setBorder(null);
        jPanel1.add(txtNombreImagen);
        txtNombreImagen.setBounds(320, 40, 210, 28);

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(30, 400, 90, 20);

        btnEliminarCategoria.setBackground(new java.awt.Color(0, 128, 255));
        btnEliminarCategoria.setFont(new java.awt.Font("Roboto Bk", 0, 11)); // NOI18N
        btnEliminarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCategoria.setText("Eliminar categoria");
        btnEliminarCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarCategoria);
        btnEliminarCategoria.setBounds(270, 370, 130, 30);

        btnAgregarCategoria.setBackground(new java.awt.Color(0, 128, 255));
        btnAgregarCategoria.setFont(new java.awt.Font("Roboto Bk", 0, 11)); // NOI18N
        btnAgregarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCategoria.setText("Agregar categoria");
        btnAgregarCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarCategoria);
        btnAgregarCategoria.setBounds(130, 370, 130, 30);

        jPanel2.setBackground(new java.awt.Color(60, 60, 60));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(190, 70, 450, 280);

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Flecha izquierda.png"))); // NOI18N
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnteriorMouseClicked(evt);
            }
        });
        jPanel1.add(btnAnterior);
        btnAnterior.setBounds(160, 180, 30, 50);

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Flecha derecha.png"))); // NOI18N
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseClicked(evt);
            }
        });
        jPanel1.add(btnSiguiente);
        btnSiguiente.setBounds(650, 180, 40, 50);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Categorias");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 30, 90, 17);

        txtGeneral.setBackground(new java.awt.Color(30, 30, 30));
        txtGeneral.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtGeneral.setForeground(new java.awt.Color(225, 225, 225));
        txtGeneral.setBorder(null);
        jPanel1.add(txtGeneral);
        txtGeneral.setBounds(30, 370, 90, 28);

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Imagenes");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 200, 90, 17);

        lstImagenes.setBackground(new java.awt.Color(30, 30, 30));
        lstImagenes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lstImagenes.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lstImagenes.setForeground(new java.awt.Color(255, 255, 255));
        lstImagenes.setSelectionBackground(new java.awt.Color(0, 128, 255));
        jScrollPane2.setViewportView(lstImagenes);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(30, 230, 110, 100);

        btnEliminarImagen.setBackground(new java.awt.Color(0, 128, 255));
        btnEliminarImagen.setFont(new java.awt.Font("Roboto Bk", 0, 11)); // NOI18N
        btnEliminarImagen.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarImagen.setText("Eliminar Imagen");
        btnEliminarImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarImagenActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarImagen);
        btnEliminarImagen.setBounds(560, 370, 130, 30);

        btnAgregarImagen.setBackground(new java.awt.Color(0, 128, 255));
        btnAgregarImagen.setFont(new java.awt.Font("Roboto Bk", 0, 11)); // NOI18N
        btnAgregarImagen.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarImagen.setText("Agregar Imagen");
        btnAgregarImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImagenActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarImagen);
        btnAgregarImagen.setBounds(428, 370, 120, 30);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaActionPerformed
        String nombre = txtGeneral.getText();
        boolean existe = false;
        Categoria categoriaEliminar = null;
        for (Categoria categoria : usuarioActual.getCategorias()) {
            if (categoria.getNombreCategoria().equals(nombre)) {
                categoriaEliminar = categoria;
                existe = true;
                break;
            }
        }

        if (existe && !(nombre.isEmpty()) && !(nombre.equals("General"))) {
            usuarioActual.getCategorias().remove(categoriaEliminar);
            llenarCategorias();
            lstCategorias.setSelectedIndex(0);
            obtenerListaImagenes("General");
            txtGeneral.setText("");
            JOptionPane.showMessageDialog(null, "Se eliminó la categoria " + nombre);
        } else if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escriba el nombre de la categoria que desea eliminar en el campo correspondiente");
        } else if (nombre.equals("General")) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar la categoría General");
        } else if (!existe) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna categoria con el nombre indicado");
        }
    }//GEN-LAST:event_btnEliminarCategoriaActionPerformed

    private void btnAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCategoriaActionPerformed
        String nombre = txtGeneral.getText();
        boolean existe = false;

        for (Categoria categoria : usuarioActual.getCategorias()) {
            if (categoria.getNombreCategoria().equals(nombre)) {
                existe = true;
                break;
            }
        }

        if (!existe && !(nombre.isEmpty())) {
            usuarioActual.getCategorias().add(new Categoria(nombre));
            llenarCategorias();
            lstCategorias.setSelectedIndex(0);
            obtenerListaImagenes("General");
            txtGeneral.setText("");
            JOptionPane.showMessageDialog(null, "Se creó la categoria");
        } else if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escriba el nombre de la categoria que desea crear en el campo correspondiente");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe una categoria con el nombre indicado");
        }

    }//GEN-LAST:event_btnAgregarCategoriaActionPerformed

    private void btnEliminarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarImagenActionPerformed
        try {

            String nombre = lstImagenes.getSelectedValue();
            if (nombre != null) {
                if (listaImagenes.findNode(nombre) != null) {
                    listaImagenes.delete(listaImagenes.findNode(nombre));
                    llenarImagenes();
                    lblImagen.setIcon(null);
                    this.primerCambio = true;
                    txtNombreImagen.setText("Nombre de la imagen");
                    JOptionPane.showMessageDialog(null, "La imagen fue eliminada");

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ninguna imagen con el nombre " + nombre + " en la categoria " + lstCategorias.getSelectedValue()
                            + "\n Asegurese de haber seleccionado la imagen que desea eliminar de la lista IMAGENES");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione la imagen que desea eliminar de la lista IMAGENES");
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_btnEliminarImagenActionPerformed

    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagenActionPerformed
        if (lstCategorias.getSelectedValue() != null) {
            obtenerListaImagenes(lstCategorias.getSelectedValue());
            String ruta = null;
            String nombre = null;
            BufferedImage imagenBuff = null;
            JFileChooser seleccionarFoto = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, JPEG", "jpg", "jpeg");
            seleccionarFoto.setFileFilter(filtro);
            seleccionarFoto.setMultiSelectionEnabled(true); // habilitar selección múltiple
            int seleccion = seleccionarFoto.showOpenDialog(this);

            if (seleccion == seleccionarFoto.APPROVE_OPTION) {
                File[] archivosSeleccionados = seleccionarFoto.getSelectedFiles(); // obtener archivos seleccionados
                for (File archivo : archivosSeleccionados) {
                    ruta = archivo.getPath();
                    nombre = archivo.getName();
                    try {
                        imagenBuff = ImageIO.read(archivo);
                    } catch (IOException ex) {
                        Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Imagen imagen = new Imagen(imagenBuff, nombre, ruta);
                    this.listaImagenes.add(imagen); // agregar imagen a la lista
                }
                llenarImagenes();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione la categoria en la que desea agregar la imagen");
        }

    }//GEN-LAST:event_btnAgregarImagenActionPerformed

    private void lstCategoriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCategoriasValueChanged

        obtenerListaImagenes(lstCategorias.getSelectedValue());
        lblImagen.setIcon(null);
        this.primerCambio = true;
        txtNombreImagen.setText("Nombre de la imagen");
        llenarImagenes();


    }//GEN-LAST:event_lstCategoriasValueChanged

    private void btnSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMouseClicked
        if (primerCambio) {
            if (listaImagenes.getSize() != 0) {
                this.actual = (NodoDoble) listaImagenes.peek();
                primerCambio = false;
            }
        } else {
            if (actual.siguiente != null) {
                this.actual = actual.siguiente;
            }
        }

        cargarImagen();
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void btnAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMouseClicked
        if (primerCambio) {
            if (listaImagenes.getSize() != 0) {

                this.actual = (NodoDoble) listaImagenes.peek();
                primerCambio = false;
            }
        } else {
            if (actual.anterior != null) {
                this.actual = actual.anterior;
            }
        }
        cargarImagen();

    }//GEN-LAST:event_btnAnteriorMouseClicked

    private void cargarImagen() {
        System.out.println(listaImagenes.getSize());
        if (listaImagenes.getSize() != 0) {
            System.out.println("Entro");
            Imagen imagenActual = (Imagen) this.actual.getImagen();

            ImageIcon icono = new ImageIcon(imagenActual.getImagen().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
            lblImagen.setIcon(icono);
            txtNombreImagen.setText(imagenActual.getNombre());
        }
    }

    private void llenarCategorias() {
        DefaultListModel modelo = new DefaultListModel();

        for (Categoria categoria : this.usuarioActual.getCategorias()) {
            modelo.addElement(categoria.getNombreCategoria());
        }

        lstCategorias.setModel(modelo);
    }

    private void obtenerListaImagenes(String nombreCategoria) {

        for (Categoria categoria : this.usuarioActual.getCategorias()) {

            if (categoria.getNombreCategoria().equals(nombreCategoria)) {
                this.listaImagenes = categoria.getImagenes();
            }

        }
    }

    private void llenarImagenes() {
        DefaultListModel modelo = new DefaultListModel();
        int codigoNodo = 0;

        for (NodoDoble nodo = ((NodoDoble)this.listaImagenes.peek()); nodo!=null; nodo=nodo.siguiente) {
            modelo.addElement(((Imagen) nodo.getImagen()).getNombre());
            nodo.setIndice(codigoNodo);
            codigoNodo++;
        }

        lstImagenes.setModel(modelo);
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCategoria;
    private javax.swing.JButton btnAgregarImagen;
    private javax.swing.JLabel btnAnterior;
    private javax.swing.JButton btnEliminarCategoria;
    private javax.swing.JButton btnEliminarImagen;
    private javax.swing.JLabel btnSiguiente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JList<String> lstCategorias;
    private javax.swing.JList<String> lstImagenes;
    private javax.swing.JTextField txtGeneral;
    private javax.swing.JTextField txtNombreImagen;
    // End of variables declaration//GEN-END:variables
}
