package com.mycompany.decorador;
import Socio.Socio;
import com.mycompany.decorador.IdecoradorSocio;

/**
 *
 * @author tomas
 */
public abstract class SocioDecorador implements IdecoradorSocio{

    protected IdecoradorSocio SocioDecorador;
    
    public SocioDecorador(IdecoradorSocio socioDecorador){
        this.SocioDecorador = socioDecorador;
    }
    
    @Override
    public void notificarLibro(Socio s) {
        this.SocioDecorador.notificarLibro(s);
    }
    
    
}
