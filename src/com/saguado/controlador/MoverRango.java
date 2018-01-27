package com.saguado.controlador;

import com.saguado.modelo.Director;
import com.saguado.modelo.Empleado;
import com.saguado.modelo.Gerente;
import java.util.Scanner;

/**
 * Clase que contiene los metodos necesarios para cambiar el rango de un empleado
 */
public class MoverRango {

    private static Scanner sc = new Scanner(System.in);

    /**
     * Modifica el rango de cualquier empleado a Gerente
     * @param emp empleado seleccionado
     * @return objeto Gerente
     */
    public static Gerente aGerente(Empleado emp){
        Gerente gerente = new Gerente();
        gerente.setNombre(emp.getNombre());
        gerente.setSalario(salarioBase(emp));
        gerente.incentivo();
        gerente.setFechaNacimiento(emp.getFechaNacimiento());
        System.out.println("De que Departamento?");
        gerente.setDepartamento(sc.next());
        return gerente;
    }

    /**
     * Modifica el rango de cualquier empleado a Director
     * @param emp empleado seleccionado
     * @return objeto Director
     */
    public static Director aDirector(Empleado emp){
        Director director = new Director();
        director.setNombre(emp.getNombre());
        director.setSalario(salarioBase(emp));
        director.incentivo();
        director.setFechaNacimiento(emp.getFechaNacimiento());
        System.out.print("De que departamento? ");
        director.setDepartamento(sc.next());
        System.out.print("Matricula coche de empresa: ");
        director.setMatricula(sc.next());
        return director;
    }

    /**
     * Modifica el rango de cualquier empleado a Trabajador
     * @param emp empleado seleccionado
     * @return objeto Empleado
     */
    public static Empleado aTrabajador(Empleado emp){
        Empleado empleado = new Empleado();
        empleado.setNombre(emp.getNombre());
        empleado.setSalario(salarioBase(emp));
        empleado.setFechaNacimiento(emp.getFechaNacimiento());
        return empleado;
    }

    /**
     * Metodo que elimina los incentivos que tuviera el empleado para realizar el cambio de rango
     * @param empleado empleado seleccionado
     * @return float del salario sin incentivos
     */
    private static float salarioBase(Empleado empleado){
        float salario =0;
        if (empleado.getClass().getSimpleName().equals("Gerente")){
            salario = empleado.getSalario() / 1.05f;
            return salario;
        }else if (empleado.getClass().getSimpleName().equals("Director")){
            salario = empleado.getSalario() / 1.10f;
        }else{
            System.out.println(empleado.getClass().getSimpleName());
            salario = empleado.getSalario();
            return salario;
        }
        return salario;
    }
}
