package com.mycompany.decorador;
import com.mycompany.decorador.IdecoradorSocio;
import Socio.Socio;

/**
 *
 * @author tomas
 */
public class InformacionSocioDecorador extends SocioDecorador{
    
    public InformacionSocioDecorador(IdecoradorSocio socioDecorador){
        super(socioDecorador);
    }
    
    @Override
    public void notificarLibro(Socio s){
        SocioDecorador.notificarLibro(s);
        agregarNotificacion(s);
    }
    
    public void agregarNotificacion(Socio s){
        System.out.println("Se notifico al cliente " + s.getNombre() + " la entrga del prestamo del libro " + s.getLibro());
    }
}
