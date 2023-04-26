package PatronDecoradorPrueba;

/**
 *
 * @author tomas
 */
public class NotificarMovil implements I_Biblioteca{

    @Override
    public void notificarPrestamo(Socio s) {
        System.out.println("________________________________");
        System.out.println("Nueva notificacion de SMS!");
        System.out.println("Señor Socio: " + s.getNombre());
        System.out.println("Numero de biblioteca " + s.getId());
        System.out.println("Tiene un dia para devolver el libro " + s.getLibroOrevista());
    }
    
}
