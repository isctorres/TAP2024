package com.example.tap2024.vistas;

import com.example.tap2024.componentes.ButtonCell;
import com.example.tap2024.modelos.EmpleadosDAO;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class EmpleadoTaqueria extends Stage {

    private Panel pnlPrincipal;
    private BorderPane bpnPrincipal;
    private ToolBar tlbMenu;
    private Scene escena;
    private Button btnAgregarEmpleado;
    private TableView<EmpleadosDAO> tbvEmpleados;
    public EmpleadoTaqueria(){
        CrearUI();
        this.setTitle("Taqueria Los Inges :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        ImageView imvEmp = new ImageView(
                getClass().getResource("/images/employee.png").toString()
        );
        imvEmp.setFitHeight(50);
        imvEmp.setFitWidth(50);
        btnAgregarEmpleado = new Button();
        btnAgregarEmpleado.setOnAction(event -> new EmpleadosForm(tbvEmpleados));
        btnAgregarEmpleado.setPrefSize(50,50);
        btnAgregarEmpleado.setGraphic(imvEmp);
        tlbMenu = new ToolBar(btnAgregarEmpleado);

        CrearTable();
        bpnPrincipal = new BorderPane();
        bpnPrincipal.setTop(tlbMenu);
        bpnPrincipal.setCenter(tbvEmpleados);
        pnlPrincipal = new Panel("Taqueria");
        pnlPrincipal.getStyleClass().add("panel-primary");
        pnlPrincipal.setBody(bpnPrincipal);
        escena = new Scene( pnlPrincipal, 700, 400);
        escena.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
    }

    private void CrearTable(){
        EmpleadosDAO objEmp = new EmpleadosDAO();
        tbvEmpleados = new TableView<EmpleadosDAO>();
        TableColumn<EmpleadosDAO,String> tbcNomEmp = new TableColumn<>("Empleado");
        tbcNomEmp.setCellValueFactory(new PropertyValueFactory<>("nomEmpleado"));

        TableColumn<EmpleadosDAO,String> tbcRfcEmp = new TableColumn<>("RFC");
        tbcRfcEmp.setCellValueFactory(new PropertyValueFactory<>("rfcEmpleado"));

        TableColumn<EmpleadosDAO,Float> tbcSueldoEmp= new TableColumn<>("Sueldo");
        tbcSueldoEmp.setCellValueFactory(new PropertyValueFactory<>("salario"));

        TableColumn<EmpleadosDAO,String> tbcTelEmp = new TableColumn<>("Telefono");
        tbcTelEmp.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        TableColumn<EmpleadosDAO,String> tbcDirEmp = new TableColumn<>("Direccion");
        tbcDirEmp.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        TableColumn<EmpleadosDAO,String> tbcEditar = new TableColumn<EmpleadosDAO,String>("EDITAR");
        tbcEditar.setCellFactory(
                new Callback<TableColumn<EmpleadosDAO, String>, TableCell<EmpleadosDAO, String>>() {
                    @Override
                    public TableCell<EmpleadosDAO, String> call(TableColumn<EmpleadosDAO, String> param) {
                        return new ButtonCell();
                    }
                }
        );

        tbvEmpleados.getColumns().addAll(tbcNomEmp,tbcRfcEmp,tbcSueldoEmp,tbcTelEmp,tbcDirEmp,tbcEditar);
        tbvEmpleados.setItems(objEmp.CONSULTAR());
    }
}
