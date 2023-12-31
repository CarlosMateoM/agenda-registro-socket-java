package agenda.registro.vista;

import agenda.registro.cliente.Cliente;
import agenda.registro.modelo.Persona;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class InicioForm extends javax.swing.JPanel {

    private final String usuario;
    private final Cliente socketCliente;
    private final DefaultTableModel tablaContactos;

    public InicioForm(String usuario, Cliente sokectCliente) {
        initComponents();
        this.socketCliente = sokectCliente;
        this.usuario = usuario;
        tablaContactos = (DefaultTableModel) jTableContactos.getModel();
        cargarDatosUsuario();
        
    }

    public String getUsuario() {
        return usuario;
    }
    
    

    private void cargarDatosUsuario() {
        usuariosLb.setText("Usuarios:   " + usuario);
        cargarListaContactos();
    }

    public void cargarListaContactos() {
        tablaContactos.setRowCount(0);
        
        List<Persona> contactos = socketCliente.listar(usuario);

        for (Persona persona : contactos) {
            String rowData [] = {
                "" + persona.getId(),
                persona.getNombre(),
                persona.getCorreo(),
                persona.getTelefono()
            };
            tablaContactos.addRow(rowData);
        }

        System.out.println("termino listado contactos cliente");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuariosLb = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContactos = new javax.swing.JTable();
        nombreTxt = new javax.swing.JTextField();
        correoTxt = new javax.swing.JTextField();
        telefonoTxt = new javax.swing.JTextField();
        botonAtras = new javax.swing.JButton();
        usuariosLb1 = new javax.swing.JLabel();
        usuariosLb2 = new javax.swing.JLabel();
        usuariosLb3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(825, 436));

        usuariosLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        usuariosLb.setForeground(new java.awt.Color(255, 255, 255));
        usuariosLb.setText(" Usuario: anonimo");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONTACTOS");

        jTableContactos.setBackground(new java.awt.Color(153, 153, 153));
        jTableContactos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableContactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "CORREO", "TELEFONO"
            }
        ));
        jScrollPane1.setViewportView(jTableContactos);

        nombreTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTxtActionPerformed(evt);
            }
        });

        correoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoTxtActionPerformed(evt);
            }
        });

        telefonoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoTxtActionPerformed(evt);
            }
        });

        botonAtras.setBackground(new java.awt.Color(0, 204, 255));
        botonAtras.setFont(new java.awt.Font("Leelawadee UI", 3, 12)); // NOI18N
        botonAtras.setForeground(new java.awt.Color(255, 255, 255));
        botonAtras.setText("INGRESAR");
        botonAtras.setToolTipText("");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        usuariosLb1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 10)); // NOI18N
        usuariosLb1.setForeground(new java.awt.Color(255, 255, 255));
        usuariosLb1.setText(" Nombre:");

        usuariosLb2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 10)); // NOI18N
        usuariosLb2.setForeground(new java.awt.Color(255, 255, 255));
        usuariosLb2.setText(" Correo:");

        usuariosLb3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 10)); // NOI18N
        usuariosLb3.setForeground(new java.awt.Color(255, 255, 255));
        usuariosLb3.setText("Telefono:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(correoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(telefonoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(usuariosLb1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(usuariosLb2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(usuariosLb3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(usuariosLb, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(usuariosLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuariosLb1)
                    .addComponent(usuariosLb2)
                    .addComponent(usuariosLb3))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(correoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(telefonoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nombreTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTxtActionPerformed

    private void correoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoTxtActionPerformed

    private void telefonoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoTxtActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        String nombre = nombreTxt.getText();
        String correo = correoTxt.getText();
        String telefono = telefonoTxt.getText();
        
        Persona persona = new Persona(nombre, correo, telefono);
        socketCliente.agregar(usuario, persona);

        cargarListaContactos();
        
        nombreTxt.setText("");
        correoTxt.setText("");
        telefonoTxt.setText("");
    }//GEN-LAST:event_botonAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JTextField correoTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContactos;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JTextField telefonoTxt;
    private javax.swing.JLabel usuariosLb;
    private javax.swing.JLabel usuariosLb1;
    private javax.swing.JLabel usuariosLb2;
    private javax.swing.JLabel usuariosLb3;
    // End of variables declaration//GEN-END:variables
}
