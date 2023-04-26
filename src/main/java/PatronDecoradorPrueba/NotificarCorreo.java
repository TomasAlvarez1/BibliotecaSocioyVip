package PatronDecoradorPrueba;

/**
 *
 * @author tomas
 */
public class NotificarCorreo implements I_Biblioteca{

    @Override
    public void notificarPrestamo(Socio s) {
        System.out.println("________________________________");
        System.out.println("Nueva notificacion del correo!");
        System.out.println("Señor " + s.getNombre());
        System.out.println("Numero de biblioteca " + s.getId());
        System.out.println("Tiene un dia para devolver el libro " + s.getLibroOrevista());
    }
    
}
