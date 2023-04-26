package com.mycompany.decorador;
import Vip.Vip;
import com.mycompany.decorador.IdecoradorVip;

/**
 *
 * @author tomas
 */
public abstract class VipDecorador implements IdecoradorVip{

    protected IdecoradorVip VipDecorador;
    
    public VipDecorador(IdecoradorVip VipDecorador){
        this.VipDecorador = VipDecorador;
    }
    
    @Override
    public void notificarRevista(Vip v) {
        this.VipDecorador.notificarRevista(v);
    }
    
    
}
