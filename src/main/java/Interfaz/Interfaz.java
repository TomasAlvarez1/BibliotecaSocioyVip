package Interfaz;

import com.mycompany.observador.BibliotecaObservador;
import com.mycompany.decorador.IdecoradorSocio;
import com.mycompany.decorador.IdecoradorVip;
import com.mycompany.decorador.InformacionSocioDecorador;
import com.mycompany.decorador.InformacionVipDecorador;

import com.mycompany.decorador.NotificarSocioCorreo;
import com.mycompany.decorador.NotificarVipCelular;

import Socio.Socio;
import Vip.Vip;
import adts.ColaReTopcopianew;
import java.util.Scanner;

/**
 *
 * @author tomas
 */
public class Interfaz {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        BibliotecaObservador biblioteca = new BibliotecaObservador();

        IdecoradorSocio deSocio = new NotificarSocioCorreo();
        IdecoradorVip deVip = new NotificarVipCelular();

        IdecoradorSocio InformacionSocio = new InformacionSocioDecorador(deSocio);
        IdecoradorVip InformacionVip = new InformacionVipDecorador(deVip);

        ColaReTopcopianew<Socio> datosSocios = new ColaReTopcopianew<>();
        ColaReTopcopianew<Vip> datosVip = new ColaReTopcopianew<>();

        String nombre = "";
        String libro = "";
        String revista = "";
        int prestamo;
        int id = 0;

        while (true) {
            System.out.println("__________BIENVENIDO A LA BIBLIOTECA__________");
            System.out.println("1. Registrar un nuevo socio");
            System.out.println("2. Registar un nuevo vip");
            System.out.println("3. Eliminar a un socio");
            System.out.println("4. Eliminar a un Vip");
            System.out.println("5. Ver socios");
            System.out.println("6. Ver VIP");
            System.out.println("7. Solicitar un libro");
            System.out.println("8. Solicitar una revista");
            System.out.println("9. Salir");
            int Opcion = in.nextInt();
            in.nextLine();

            switch (Opcion) {
                case 1:
                    System.out.println("Ingrese el nombre para el nuevo socio");
                    nombre = in.nextLine();
                    System.out.println("Ingrese su numero de identificacion: ");
                    id = in.nextInt();
                    Socio sañadir = new Socio(nombre, libro, id);
                    datosSocios.enqueue(sañadir);
                    biblioteca.agregarReceptor(sañadir);
                    sañadir.añadirUsuario(nombre, id);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre para el nuevo Vip");
                    nombre = in.nextLine();
                    System.out.println("Ingrese su numero de identificacion: ");
                    id = in.nextInt();
                    Vip vañadir = new Vip(nombre, revista, id);
                    datosVip.enqueue(vañadir);
                    biblioteca.agregarReceptor(vañadir);
                    vañadir.añadirUsuario(nombre, id);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre para el socio que desea eliminar:");
                    nombre = in.nextLine();
                    Socio socioAEliminar = null;
                    for (Socio socio : datosSocios) {
                        if (socio.getNombre().equals(nombre)) {
                            socioAEliminar = socio;
                            break;
                        }
                    }
                    if (socioAEliminar != null) {
                        datosSocios.dequeue();
                        biblioteca.eliminarReceptor(socioAEliminar);
                        socioAEliminar.eliminarUsuario(nombre);
                    } else {
                        System.out.println("El socio no se encuentra registrado.");
                    }

                    break;
                case 4:

                    System.out.print("Ingrese el nombre para el vip que desea eliminar:");
                    nombre = in.nextLine();
                    Vip vipAEliminar = null;
                    for (Vip socio : datosVip) {
                        if (socio.getNombre().equals(nombre)) {
                            vipAEliminar = socio;
                            break;
                        }
                    }

                    if (vipAEliminar != null) {
                        datosVip.dequeue();
                        biblioteca.eliminarReceptor(vipAEliminar);
                        vipAEliminar.eliminarUsuario(nombre);
                    } else {
                        System.out.println("El Vip no se encuentra registrado.");
                    }
                    break;
                case 5:
                    if (!datosSocios.isEmpty()) {
                        System.out.println("Los socios registrados son: ");
                        for (Socio x : datosSocios) {
                            System.out.println(x.toString());
                        }
                    } else {
                        System.out.println("No hay Socios registrados");
                    }

                    break;
                case 6:   
                    if (!datosVip.isEmpty()) {
                        System.out.println("los vip registrados son: ");
                        for (Vip z : datosVip) {
                            System.out.println(z.toString());
                        }
                    } else{
                        System.out.println("No hay vip registrados");
                    }

                    break;
                case 7:
                    System.out.println("Cual es el nombre del socio: ");
                    nombre = in.nextLine();

                    

                    if (biblioteca.comprobarSocio(nombre)) {
                        
                        System.out.println("Cual es el libro que lleva el socio " + nombre + ":");
                        libro = in.nextLine();
                        
                        Socio sverlibro = new Socio(nombre, libro, id);
                        biblioteca.agregarReceptor(sverlibro);
                        
                        System.out.println("Cuantos libros lleva prestados: ");
                        prestamo = in.nextInt();
                        in.nextLine();
                        
                        if (prestamo < 6) {
                            if (biblioteca.comprobarLibro(libro)) {
                                sverlibro.recibirLibro(libro, nombre);
                                biblioteca.verRecibirLibro(libro);
                                
                                InformacionSocio.notificarLibro(sverlibro);
                            } else {
                                System.out.println("La revista no se encuentra por el momento");
                            }
                        } else {
                            System.out.println("No se le pueden prestar mas libros ya que alcanzo su capacidad");
                        }
                    } else {
                        System.out.println(nombre + " no es socio");
                        System.exit(0);
                    }
                    break;
                case 8:

                    System.out.println("Cual es el nombre del vip: ");
                    nombre = in.nextLine();

                    if (biblioteca.comprobarVip(nombre)) {
                        
                         System.out.println("Cual es la revista que lleva el vip " + nombre + ":");
                        revista = in.nextLine();
                        
                        Vip vVerRevista = new Vip(nombre, revista, id); 
                        biblioteca.agregarReceptor(vVerRevista);
                     
                        System.out.println("Cuantas revistas lleva prestados: ");
                        prestamo = in.nextInt();
                        in.nextLine();
                        
                        if (prestamo < 12) {
                            if (biblioteca.comprobarEstadoRevista(revista)) {
                                vVerRevista.recibirLibro(revista, nombre);
                                biblioteca.verRecibirRevista(revista);
                                
                                InformacionVip.notificarRevista(vVerRevista);
                            } else {
                                System.out.println("La revista no se encuentra por el momento");
                            }
                        } else {
                            System.out.println("No se le pueden prestar mas revistas ya que alcanzo su capacidad");
                        }
                    } else {
                        System.out.println(nombre + " no es vip");
                        System.exit(0);
                    }

                    break;
                case 9:

                    System.out.println("Usted a salido de la biblioteca");
                    System.exit(0);

                    break;
                default:
                    System.out.println("La opcion que ingreso no es valida");
                    break;
            }
        }
    }
}

