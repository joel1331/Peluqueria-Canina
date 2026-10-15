package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;


public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new  DuenioJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        //craer en la base de datos el dueño
        duenioJpa.create(duenio);
        //crear en la base de datos la mascota
        mascoJpa.create(masco);
    }

    public List<Mascota> traerMascotas() {
     return mascoJpa.findMascotaEntities();

    }

    public void borrarMascota(int num_cliente) {
        try {
            mascoJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public Mascota traerMascota(int num_cliente) {
return mascoJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio dueno) {
        try {
            duenioJpa.edit(dueno);
        } catch (Exception ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void borrarDuenio(int id_duenio) {
try {
        duenioJpa.destroy(id_duenio);
    } catch (NonexistentEntityException ex) {
        System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    }
    }
    
    
    
    
}
