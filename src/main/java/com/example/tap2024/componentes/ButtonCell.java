package com.example.tap2024.componentes;

import com.example.tap2024.modelos.EmpleadosDAO;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class ButtonCell extends TableCell<EmpleadosDAO,String> {
    Button btnCelda;

    public ButtonCell(){
        btnCelda = new Button("Editar");
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if( !empty )
            this.setGraphic(btnCelda);
    }
}
