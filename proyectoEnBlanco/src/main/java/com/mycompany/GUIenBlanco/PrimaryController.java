package com.mycompany.GUIenBlanco;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController implements Initializable
{

    @FXML
    private Label lblTexto;
    
    @FXML
    private ImageView image;
    
    @FXML
    private Button butonButton;
    
    @FXML
    private CheckBox chMarca;
    
    public PrimaryController()
    //constructor del controlador
    {
        //en el constructor se puede ejecutar código que NO interactúe con la interfaz ya que los
        //controles todavía no están creados. Por ejemplo:
        
        List<Integer> l = new ArrayList<>();
        
        l.add(8);
        l.add(3);
        l.add(5);
        
        l.remove(0); //eliminamos el elemento en la posición 0
        
        System.out.println("Tamaño de la lista: " + l.size());
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    //location - The location used to resolve relative paths for the root object, or null if the location is not known.
    //resources - The resources used to localize the root object, or null if the root object was not localized. 
    //
    //Este método es llamado internamente justo después del constructor
    //En el constructor NO SE tiene acceso a las variables enlazadas con @FXML
    //En initialize() ya están las variables creadas y son accesibles
    {
        String cadena = "Para reutilizar este proyecto:\n\n"
                + "DESDE EL SISTEMA OPERATIVO:\n\n"
                + "0. (Opcional) Hacer una copia de la carpeta completa usando otro nombre\n\n"
                + "DESDE NETBEANS:\n\n"
                + "1. Cambiar nombre al proyecto con la opción 'rename' (botón derecho sobre él; cambiar las tres opciones)\n\n"
                + "2. Hacer refactor->rename del paquete com.mycompany.proyectoenblanco\n\n"
                + "    2.1. En Source Packages\n\n"
                + "    2.2. En Other Sources -> src/main/resources\n\n"
                + "3. En POM.XML actualizar la etiqueta <MainClass></MainClass>\n\n"
                + "4. En PRIMARY.FXML actualizar la etiqueta <Pane> para que apunte al controlador adecuado\n\n"
                + "5. En module-info.java (<default package>), actualizar la primera línea (module...)";
        
        lblTexto.setText(cadena);
        
        //la raíz de nuestro proyecto es donde están las carpetas 'src' y 'target'
        //Ahí existe una carpeta 'imagenes' que contiene una imagen de muestra
        image.setImage(new Image("file:.//imagenes//muestra.png"));
    }
    
}
