module DanielSantiagoRodriguezCarrillo {
    requires javafx.controls;
    requires javafx.fxml;

    opens application to javafx.graphics;
    opens controller to javafx.fxml;
    opens model to javafx.base;
    opens view to javafx.fxml;
    
  
}