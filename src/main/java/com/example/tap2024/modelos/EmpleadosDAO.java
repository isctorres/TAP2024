package com.example.tap2024.modelos;

public class EmpleadosDAO {
    int idEmpleado;
    String nomEmpleado;
    String rfcEmpleado;
    float salario;
    String telefono;
    String direccion;

    public void INSERTAR(){
        String query = "INSERT INTO Empleado(nomEmpleado," +
                "rfcEmpleado,salario,telefono,direccion) " +
                "VALUES('"++"','"++"',"++",'"++"','"++"')";
    }
    public void ACTUALIZAR(){}
    public void ELIMINAR(){}
    public void CONSULTAR(){}
}
