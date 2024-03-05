package com.example.tap2024.vistas;

import com.example.tap2024.modelos.EmpleadosDAO;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmpleadoTaqueria extends Stage {

    private VBox vbxPrincipal;
    private ToolBar tlbMenu;
    private Scene escena;
    private TableView<EmpleadosDAO> tbvEmpleados;
    public EmpleadoTaqueria(){
        CrearUI();
        this.setTitle("Taqueria Los Inges :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        tlbMenu = new ToolBar();
        CrearTable();
        vbxPrincipal = new VBox(tlbMenu,tbvEmpleados);
        escena = new Scene(vbxPrincipal, 300, 200);
    }

    private void CrearTable(){
        tbvEmpleados = new TableView<EmpleadosDAO>();
        TableColumn<EmpleadosDAO,String> tbcNomEmp = new TableColumn<>("Empleado");
        TableColumn<EmpleadosDAO,String> tbcRfcEmp = new TableColumn<>("RFC");
        TableColumn<EmpleadosDAO,Float> tbcSueldoEmp= new TableColumn<>("Sueldo");
        TableColumn<EmpleadosDAO,String> tbcTelEmp = new TableColumn<>("Telefono");
        TableColumn<EmpleadosDAO,String> tbcDirEmp = new TableColumn<>("Direccion");
        ///.....
        tbvEmpleados.getColumns().addAll(tbcNomEmp,tbcRfcEmp,tbcSueldoEmp,tbcTelEmp,tbcDirEmp);
    }
}
