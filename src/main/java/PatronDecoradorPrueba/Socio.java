package PatronDecoradorPrueba;

/**
 *
 * @author tomas
 */
public class Socio {
    
    private String nombre;
    private int id;
    private String libroOrevista;

    public Socio(String nombre, int id, String libroOrevista) {
        this.nombre = nombre;
        this.id = id;
        this.libroOrevista = libroOrevista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibroOrevista() {
        return libroOrevista;
    }

    public void setLibroOrevista(String libroOrevista) {
        this.libroOrevista = libroOrevista;
    }
    
    
}
