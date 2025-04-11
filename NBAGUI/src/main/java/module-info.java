module com.mycompany.nbagui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires jakarta.xml.bind;
    requires org.apache.pdfbox;
    requires java.sql;
    
    opens com.mycompany.nbagui to javafx.fxml,jakarta.xml.bind;
    exports com.mycompany.nbagui;
}
