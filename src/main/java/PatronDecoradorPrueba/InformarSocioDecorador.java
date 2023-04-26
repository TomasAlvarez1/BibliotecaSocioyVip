/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronDecoradorPrueba;

/**
 *
 * @author tomas
 */
public class InformarSocioDecorador extends SocioDecorador{
    
    public InformarSocioDecorador(I_Biblioteca SocioDecorador){
        super(SocioDecorador);
    }
 
    @Override
    public void notificarPrestamo(Socio s){
        SocioDecorador.notificarPrestamo(s);
        agregarNotificacion(s);
    }
    
    public void agregarNotificacion(Socio s){
        System.out.println("Se notifico al cliente " + s.getNombre() + " la entrega del prestamo " + s.getLibroOrevista());
    }
}
