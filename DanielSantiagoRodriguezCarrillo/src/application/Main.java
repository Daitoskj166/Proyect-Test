package application;

import javafx.application.Application;
import javafx.stage.Stage;
import model.User;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.fxml.FXMLLoader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private static Stage primaryStage;
    private static List<User> usuariosRegistrados = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        try {
            Main.primaryStage = primaryStage;
            URL fxmlResource = getClass().getResource("/view/MenuPrincipal.fxml");
            if (fxmlResource == null) {
                throw new RuntimeException("No se pudo encontrar el archivo FXML: /view/MenuPrincipal.fxml");
            }
            
            Parent root = FXMLLoader.load(fxmlResource);
            Scene scene = new Scene(root, 600, 600);

            URL cssResource = getClass().getResource("application.css");
            if (cssResource != null) {
                scene.getStylesheets().add(cssResource.toExternalForm());
            } else {
                System.err.println("Advertencia: No se encontró application.css en /application.css");
            }
            
            primaryStage.setScene(scene);
            primaryStage.setTitle("Sistema de Biblioteca");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Error al iniciar", "No se pudo cargar la interfaz principal", 
                          "Detalles: " + e.getMessage());
        }
    }

    public static void loadScene(String fxmlFile) {
        try {
            String normalizedPath = fxmlFile.startsWith("/view/") ? fxmlFile : "/view/" + fxmlFile;
            
            URL fxmlResource = Main.class.getResource(normalizedPath);
            if (fxmlResource == null) {
                throw new RuntimeException("No se encontró el archivo: " + normalizedPath);
            }
            
            Parent root = FXMLLoader.load(fxmlResource);
            Scene scene = primaryStage.getScene();
            
            if (scene == null) {
                scene = new Scene(root, 600, 600);
                URL cssUrl = Main.class.getResource("/application.css");
                if (cssUrl != null) {
                    scene.getStylesheets().add(cssUrl.toExternalForm());
                }
                primaryStage.setScene(scene);
            } else {
                scene.setRoot(root);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Error al cambiar vista", "No se pudo cargar: " + fxmlFile, 
                          e.getMessage());
        }
    }

    private static void showErrorDialog(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void agregarUsuarioRegistrado(User usuario) {
        usuariosRegistrados.add(usuario);
    }

    public static List<User> getUsuariosRegistrados() {
        return new ArrayList<>(usuariosRegistrados); 
    }

    public static void main(String[] args) {
        launch(args);
    }
}