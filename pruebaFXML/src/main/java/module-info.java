module com.mycompany.pruebafxml {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.pruebafxml to javafx.fxml;
    exports com.mycompany.pruebafxml;
}
