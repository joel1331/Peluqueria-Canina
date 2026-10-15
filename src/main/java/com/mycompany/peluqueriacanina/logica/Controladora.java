package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String nombreDue, String alergico, String atencionEspecial, String celDue, String observaciiones) {
        //creamos el dueño y asignamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDue);
        duenio.setCelDuenio(celDue);
        
        //creamos el dueño y le asignamos los valores 
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atencionEspecial);
        masco.setObservaciones(observaciiones);
        masco.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio,masco);
    }

    public List<Mascota> traerMascotas() {
      return controlPersis.traerMascotas();
      
 
    }

    public void borrarMascota(int num_cliente) {
// 1. Traer la mascota para obtener la referencia al dueño
    Mascota masco = controlPersis.traerMascota(num_cliente);
    
    if (masco != null) {
        int id_duenio = masco.getUnDuenio().getId_duenio();
        
        // 2. Borrar la mascota primero (para liberar la clave foránea)
        controlPersis.borrarMascota(num_cliente);
        
        // 3. Borrar el dueño asociado
        controlPersis.borrarDuenio(id_duenio);
    }
    }
    public Mascota traerMascota(int num_cliente) {
    return  controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco,
            String raza, String color, String observaciiones, String alergico,
            String atencionEspecial, String nombreDue, String celDue) {
       
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciiones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atencionEspecial);
        //modifico la mascota
        controlPersis.modificarMascota(masco);
        
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        dueno.setCelDuenio(celDue);
        dueno.setNombre(nombreDue);
        //llamar a modificar dueño
        this.modificarDuenio(dueno);
        

    }

    private Duenio buscarDuenio(int id_duenio) {
return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
controlPersis.modificarDuenio(dueno);
    }
}
