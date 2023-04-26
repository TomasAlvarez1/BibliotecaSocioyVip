package PatronDecoradorPrueba;

/**
 *
 * @author tomas
 */
public class Interfaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Socio s = new Socio("Tomas", 1001, "Mil años de soledad");
        
        I_Biblioteca Socio = new NotificarCorreo();
        I_Biblioteca InformacionSocio = new InformarSocioDecorador(Socio);
        
        //Notificar prestamo del libro
        InformacionSocio.notificarPrestamo(s);
    }
    
}
