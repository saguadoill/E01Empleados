package com.saguado.modelo;

public class Gerente extends Empleado {

    private String departamento;

    public Gerente(){

    }
//
//    public Gerente(String departamento) {
//        this.departamento = departamento;
//    }
//
//    public Gerente(String nombre, String fechaNacimiento, float salario, String departamento) {
//        super(nombre, fechaNacimiento, salario);
//        this.departamento = departamento;
//    }

    public void incentivo(){
        this.setSalario(this.getSalario()*1.05f);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return String.format(" - Nombre: %s - Salario: %.2f - Fecha nacimiento: %s - Departamento: %s",this.getNombre(),this.getSalario(),this.getFechaNacimiento(),this.getDepartamento());
    }
}
