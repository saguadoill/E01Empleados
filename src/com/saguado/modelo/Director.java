package com.saguado.modelo;

public class Director extends Gerente{

    private String matricula;

    public Director() {
    }

//    public Director(String departamento, String matricula) {
//        super(departamento);
//        this.matricula = matricula;
//    }
//
//    public Director(String nombre, String fechaNacimiento, float salario, String departamento, String matricula) {
//        super(nombre, fechaNacimiento, salario, departamento);
//        this.matricula = matricula;
//    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public void incentivo() {
        this.setSalario(this.getSalario()*1.10f);
    }

    @Override
    public String toString(){

        return String.format(" - Nombre: %s - Salario: %.2f - Fecha nacimiento: %s - Departamento: %s - Matricula: %s",this.getNombre(),this.getSalario(),this.getFechaNacimiento(),this.getDepartamento(),this.getMatricula());
    }
}
