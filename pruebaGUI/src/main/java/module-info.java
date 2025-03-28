module com.mycompany.pruebagui {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.pruebagui to javafx.fxml;
    exports com.mycompany.pruebagui;
}
