package com.saguado.modelo;

public class Empleado {

    private String nombre;
    private String fechaNacimiento;
    private float salario;

    public Empleado() {
    }

//    public Empleado(String nombre, String fechaNacimiento, float salario) {
//        this.nombre = nombre;
//        this.fechaNacimiento = fechaNacimiento;
//        this.salario = salario;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString(){
        return String.format(" - Nombre: %s - Salario: %.2f - Fecha nacimiento: %s",this.getNombre(),this.getSalario(),this.getFechaNacimiento());
    }
}
