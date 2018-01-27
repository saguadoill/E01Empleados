package com.saguado.controlador;

import com.saguado.modelo.Director;
import com.saguado.modelo.Empleado;
import com.saguado.modelo.Gerente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que realia todas las funciones operativas de la aplicacion
 */
public class GestionApp {

    List<Empleado> empleados = new ArrayList<>();

    /**
     * Metodo que muestra el menu principal de la aplicacion
     */
    public void showMenu(){
        Scanner entrada = new Scanner(System.in);

        int opcion = 0;


        do {
            System.out.println();
            System.out.println("--- Gestion Empleados ---");
            System.out.println("=========================");
            System.out.println("1 - Añadir empleado");
            System.out.println("2 - Ver datos empleados");
            System.out.println("3 - Promover/Denigrar");
            System.out.println("0 - SALIR");
            System.out.print(">");
            opcion = Integer.parseInt(entrada.next());

            gestionarOpcion(opcion);
        }while (opcion !=0);

    }

    /**
     * metodo que gestiona la opcion que elige el usuario
     * @param opcion  opcion del menu
     */
    public void gestionarOpcion(int opcion){

        switch (opcion){
            case 1:
                addEmpleado();
                break;
            case 2:
                showEmpleados();
                break;
            case 3:
                moverEmpleado();
                break;
            default:
                System.out.println("Opcion no encontrada!!");
                break;
        }

    }

    /**
     * metodo que acrea y añade un empleado(Trabajador/Gerente/Director) a la lista de empleados
     */
    private void addEmpleado(){
        Scanner entrada = new Scanner(System.in);
        int seleccionPuesto =0;

        String[] datosPersonales = pedirDatosPersonales();

        System.out.println("Que puesto va a desempleñar?");
        System.out.println("1 - Trabajador");
        System.out.println("2 - Gerente");
        System.out.println("3 - Director");
        System.out.print(">");
        seleccionPuesto = entrada.nextInt();

        switch (seleccionPuesto){
            case 1:
                Empleado empleado = new Empleado();
                addDatosPersonales(empleado,datosPersonales);
                empleados.add(empleado);
                break;
            case 2:
                Gerente gerente = new Gerente();
                addDatosPersonales(gerente,datosPersonales);
                gerente.incentivo();
                System.out.print("De que departamento? ");
                gerente.setDepartamento(entrada.next());
                empleados.add(gerente);
                break;
            case 3:
                Director director = new Director();
                addDatosPersonales(director,datosPersonales);
                director.incentivo();
                System.out.print("De que departamento? "); // se puede eliminar este paso si suponemos que va a ser director del MISMO departamento que estaba como gerente
                director.setDepartamento(entrada.next());
                System.out.print("Matricula coche de empresa: ");
                director.setMatricula(entrada.next());
                empleados.add(director);
                break;
            default:
                System.out.println("ELECCION ERRONEA!!"); break;
        }
    }

    /**
     * Metodo que pide los datos personales comunes a todos los empleados
     * @return String[] con los datos del empleado
     */
    private String[] pedirDatosPersonales(){
        Scanner sc = new Scanner(System.in);
        String[] datosPersonales = new String[3];

        System.out.println();
        System.out.print("Nombre del empleado: ");
        datosPersonales[0] = sc.nextLine();
        System.out.print("Salario nuevo empleado: ");
        datosPersonales[1] = sc.next();
        System.out.print("Fecha de nacimiento: ");
        datosPersonales[2] = sc.next();
        return datosPersonales;
    }

    /**
     * metodo que añade los datos personales una vez que sabemos que tipo de empleado va a ser
     * @param empleado empleado ya sea Trabajador, Gerente o Director
     * @param datosPersonales  String[] con los datos personales del empleado
     */
    private void addDatosPersonales(Empleado empleado, String[] datosPersonales){
        empleado.setNombre(datosPersonales[0]);
        empleado.setSalario(Float.parseFloat(datosPersonales[1]));
        empleado.setFechaNacimiento(datosPersonales[2]);
    }

    /**
     * Metodo que muestra una lista con todos los empleados y sus datos correspondientes
     * En este caso se usa una expresion lambda por su simplicidad
     */
    private void showEmpleados(){

        empleados.forEach(e-> System.out.println(empleados.indexOf(e)+" "+e.toString()));

    }

    /**
     * metodo que solicita un rango al usuario y cambia el rango dentro de la empresa del empleado eleguido
     */
    private void moverEmpleado(){
        Scanner entrada = new Scanner(System.in);
        int empleadoSeleccionado = 0;
        int rangosSeleccionado = 0;

        System.out.println("Seleccionar empleado: ");
        showEmpleados();
        empleadoSeleccionado = entrada.nextInt();

        System.out.println("A que rango deseas cambiarlo?");
        System.out.println("1- Trabajador");
        System.out.println("2- Gerente");
        System.out.println("3- Director");
        rangosSeleccionado = entrada.nextInt();

        switch (rangosSeleccionado){
            case 1:
                empleados.set(empleadoSeleccionado, MoverRango.aTrabajador(empleados.get(empleadoSeleccionado))); break;
            case 2:
                empleados.set(empleadoSeleccionado, MoverRango.aGerente(empleados.get(empleadoSeleccionado))); break;
            case 3:
                empleados.set(empleadoSeleccionado, MoverRango.aDirector(empleados.get(empleadoSeleccionado))); break;
            default:
                System.out.println("SELECCION ERRONEA !!"); break;
        }
    }

}
