/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronDecoradorPrueba;

/**
 *
 * @author tomas
 */
public abstract class SocioDecorador implements I_Biblioteca{
    
    protected I_Biblioteca SocioDecorador;

    public SocioDecorador(I_Biblioteca SocioDecorador) {
        this.SocioDecorador = SocioDecorador;
    }

    @Override
    public void notificarPrestamo(Socio s) {
        this.SocioDecorador.notificarPrestamo(s);
    }
    
}
