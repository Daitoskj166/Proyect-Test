package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuPrincipalController {

    @FXML
    private Button btnCesion;

    @FXML
    private Button btnRegistro;

    @FXML
    private VBox root;

    @FXML
    void goToCesionMenu(ActionEvent event) {
        Main.loadScene("InicioSesion.fxml");
    }

    @FXML
    void goToRegistroMenu(ActionEvent event) {
        Main.loadScene("Registro.fxml");
    }
}
