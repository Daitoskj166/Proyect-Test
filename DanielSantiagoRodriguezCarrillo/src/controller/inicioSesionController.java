package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

public class inicioSesionController {

    @FXML
    private Button btnIngreso;

    @FXML
    private Button btnMenuP;

    @FXML
    private PasswordField txtContraseña;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    void IngresoUsuario(ActionEvent event) {
        String nombreUsuario = txtNombreUsuario.getText().trim();
        String contraseña = txtContraseña.getText().trim();

        if (nombreUsuario.isEmpty() || contraseña.isEmpty()) {
            mostrarAlerta("Error", "Campos vacíos", "Por favor, complete todos los campos.");
            return;
        }

      
        boolean credencialesValidas = false;
        for (User usuario : Main.getUsuariosRegistrados()) {
            if (usuario.validarCredenciales(nombreUsuario, contraseña)) {
                credencialesValidas = true;
                break;
            }
        }

        if (credencialesValidas) {
            Main.loadScene("/view/menuBook.fxml");
        } else {
            mostrarAlerta("Error", "Credenciales incorrectas", "El nombre de usuario o la contraseña son incorrectos.");
        }
    }

    @FXML
    void goToMainMenuPrincipal(ActionEvent event) {
        Main.loadScene("/view/MenuPrincipal.fxml");
    }

    private void mostrarAlerta(String titulo, String cabecera, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecera);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}