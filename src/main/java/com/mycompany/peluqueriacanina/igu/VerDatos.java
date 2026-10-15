package com.mycompany.peluqueriacanina.igu;

import com.mycompany.peluqueriacanina.logica.Controladora;
import com.mycompany.peluqueriacanina.logica.Mascota;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VerDatos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VerDatos.class.getName());

    Controladora control = null;
   
    public VerDatos() {
        control= new Controladora(); 
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMascota = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Visualizacion De Datos");

        tablaMascota.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablaMascota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMascota);

        jLabel1.setText("Datos De Macota");

        btnEliminar.setText("Elimar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnEliminar)
                        .addGap(32, 32, 32)
                        .addComponent(btnEditar)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
     // Controlar que la tabla no esté vacía (> 0 en lugar de < 0)
    if (tablaMascota.getRowCount() > 0) {
        
        // Controlar que se haya seleccionado una fila
        if (tablaMascota.getSelectedRow() != -1) {
            
            // Obtener el ID de la mascota a eliminar
            int num_cliente = Integer.parseInt(String.valueOf(tablaMascota.getValueAt(tablaMascota.getSelectedRow(), 0)));
            
            // Llamar al método borrar
            control.borrarMascota(num_cliente);
            
            // Avisar al usuario y recargar la tabla
            mostrarMensajes("Mascota eliminada correctamente", "Info", "Borrada de Mascota");
            cargarTabla();
            
        } else {
            mostrarMensajes("No seleccionó ninguna mascota", "Error", "Error al eliminar");
        }
        
    } else {
        mostrarMensajes("No hay nada para eliminar en la tabla", "Error", "Error al eliminar");
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        //controla que la tablano este vacia
        if(tablaMascota.getRowCount()>0){
            //controla que se alla seleccionado una mascota 
            if(tablaMascota.getSelectedRow()!=-1){
                //obten la ide de la mascota a editar
                int num_cliente = Integer.parseInt(String.valueOf(tablaMascota.getValueAt(tablaMascota.getSelectedRow(), 0)));
            ModificarDatos pantallaModif = new ModificarDatos(num_cliente);
            pantallaModif.setVisible(true);
            pantallaModif.setLocationRelativeTo(null);
                    this.dispose();
            }
            else{
                mostrarMensajes("No selecciono ninguna Mascota",  "Error", "Error al eliminar");
            }       
        }
       else{
                    mostrarMensajes("No hay nada para eliminar en la tabla ", "Error", "Error al eliminar");
        
         }  
    }//GEN-LAST:event_btnEditarActionPerformed

   
    public void mostrarMensajes(String mensaje, String tipo, String titulo){
         
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);

        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMascota;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
//definir el modelo que quieres que tenga la tabla

       DefaultTableModel modelotTbla = new  DefaultTableModel(){
           //impide que columna y filas sean iditable
           @Override
           public boolean isCellEditable(int row, int column){
               return false;
           }   
        };

           //establecer nombres de las columnas
           String titulo [] = {"num", "Nombre", "color", "raza", "alergico", "at. especial", "dueño", "cel"};
           modelotTbla.setColumnIdentifiers(titulo);
           
       //carga de datos desde la base de datos
      List <Mascota> listaMascotas  = control.traerMascotas();
      
      //recorres la lista mostrar cada uno de los elementos
    
      if (listaMascotas!=null){
          for (Mascota masco : listaMascotas ){
             Object[] objeto = {masco.getNum_cliente(),masco.getNombre(), 
                 masco.getColor(), masco.getRaza(),masco.getAlergico(),
                 masco.getAtencion_especial(), masco.getUnDuenio().getNombre(), 
                 masco.getUnDuenio().getCelDuenio()};
             
             modelotTbla.addRow(objeto);
          }
          
      }
      
      tablaMascota.setModel(modelotTbla);
    }
}
