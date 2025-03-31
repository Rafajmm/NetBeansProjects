module com.mycompany.GUIenBlanco {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.GUIenBlanco to javafx.fxml;
    exports com.mycompany.GUIenBlanco;
}
