package Socio;

import com.mycompany.observador.IaccionesObservador;
import java.util.ArrayList;

/**
 *
 * @author tomas
 */
public class Socio implements IaccionesObservador {

    private ArrayList<String> librosPrestados = new ArrayList<>();
    private String nombre;
    private String libro;
    private int id;

    public Socio(String nombre, String libro, int id) {
        this.nombre = nombre;
        this.libro = libro;
        this.librosPrestados.add(libro);
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLibro() {
        return libro;
    }

    ////////////////////////////////////
    @Override
    public void añadirUsuario(String nombre, int id) {
        System.out.println("Se añadio un nuevo Socio " + nombre + ", con numero de identidad " + id);
    }
    
    @Override
    public void eliminarUsuario(String nombre) {
        System.out.println("Se eliminó el socio " + nombre);
    }

    @Override
    public void notificar(String libro) {
        System.out.println("Usted lleva 5 libros y con el libro " + libro + " en total son 6 no puede solicitar mas libros");
    }

    @Override
    public void recibirLibro(String libro, String nombre) {
        System.out.println("Se recibió el libro " + libro + " a nombre del socio " + nombre);
    }

    @Override
    public String toString() {
        return "Socio nombre: " + nombre + " ,identificacion: " + id ;
    }

}
