module com.mycompany.mavenproject2pruebajavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.mavenproject2pruebajavafx to javafx.fxml;
    exports com.mycompany.mavenproject2pruebajavafx;
}
