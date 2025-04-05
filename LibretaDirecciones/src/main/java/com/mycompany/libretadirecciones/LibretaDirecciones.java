package com.mycompany.libretadirecciones;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;


public class LibretaDirecciones extends Application 
{


    private static Scene escenaPrincipal;

    private BorderPane layoutPrincipal;

    private AnchorPane vistaPersona,vistaEstadisticas;
    
    private ObservableList datosPersona=FXCollections.observableArrayList();
    
    
    public LibretaDirecciones(){
        datosPersona.add(new Persona("Jairo","García Rincón"));
        
        datosPersona.add(new Persona("Juan", "Pérez Martínez"));

        datosPersona.add(new Persona("Andrea", "Chenier López"));

        datosPersona.add(new Persona("Emilio", "González Pla"));

        datosPersona.add(new Persona("Mónica", "de Santos Sánchez"));
    }
    
    //Método para devolver los datos como lista observable de persona
    public ObservableList getDatosPersona() {

        return datosPersona;

    }

    @Override
    public void start(Stage escenarioPrincipal) throws IOException {
        
        
        FXMLLoader vista = new FXMLLoader(LibretaDirecciones.class.getResource("VistaPrincipal.fxml"));
            
        layoutPrincipal = vista.load();

        escenaPrincipal = new Scene(layoutPrincipal);

        escenarioPrincipal.setScene(escenaPrincipal);

        escenarioPrincipal.setTitle("Libreta de direcciones");

        //Establezco el icono de aplicación

        escenarioPrincipal.getIcons().add(new Image("file:./src/main/resources/com/mycompany/libretadirecciones/icono32.png")); //Ojo con la ruta!!


        //Doy acceso al controlador VistaPersonaCOntroller a LibretaDirecciones

        VistaPrincipalController controller = vista.getController();

        controller.setLibretaDirecciones(this);


        escenarioPrincipal.show();

        muestraVistaPersona();
    }
    
    public Scene getEscenaPrincipal(){
        return this.escenaPrincipal;
    }

    //Cargo personas de un fichero

    public void cargaPersonas(File archivo){


        try {

            //Contexto

            JAXBContext context = JAXBContext.newInstance(Empaquetador.class);

            Unmarshaller um = context.createUnmarshaller();


            //Leo XML del archivo y hago unmarshall

            Empaquetador empaquetador = (Empaquetador) um.unmarshal(archivo);


            //Borro los anteriores

            datosPersona.clear();

            datosPersona.addAll(empaquetador.getPersonas());



        } catch (Exception e) {

            //Muestro alerta

            Alert alerta = new Alert(Alert.AlertType.ERROR);

            alerta.setTitle("Error");

            alerta.setHeaderText("No se pueden cargar datos de la ruta "+ archivo.getPath());

            alerta.setContentText(e.toString());

            alerta.showAndWait();


        }


    }


    //Guardo personas en un fichero

    public void guardaPersonas(File archivo) {


        try {

            //Contexto

            JAXBContext context = JAXBContext.newInstance(Empaquetador.class);

            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            //Empaqueto los datos de las personas

            Empaquetador empaquetador = new Empaquetador();

            empaquetador.setPersonas(datosPersona);


            //Marshall y guardo XML a archivo

            m.marshal(empaquetador, archivo);



        } catch (Exception e) { // catches ANY exception

            //Muestro alerta

            Alert alerta = new Alert(Alert.AlertType.ERROR);

            alerta.setTitle("Error");

            alerta.setHeaderText("No se puede guardar en el archivo "+ archivo.getPath());

            alerta.setContentText(e.toString());

            alerta.showAndWait();

        }

    }
    
    public void crearGrafico() {

        //Cargo la vista estadísticas
       
         try {
            Scene escenaGrafico;
            FXMLLoader vista = new FXMLLoader(LibretaDirecciones.class.getResource("VistaEstadisticas.fxml"));
            escenaGrafico = new Scene(vista.load());
            
             //Inicializo un nuevo escenario y asigno el principal
            Stage escenarioEstadisticas = new Stage();
            escenarioEstadisticas.setScene(escenaGrafico);
            escenarioEstadisticas.setTitle("Estadísticas");
            
            escenarioEstadisticas.getIcons().add(new Image("file:./src/main/resources/com/mycompany/LibretaDirecciones/iconoStats32.png")); //Ojo con la ruta!!
                
            escenarioEstadisticas.initModality(Modality.WINDOW_MODAL);
            
            //Asigno el controlador
            VistaEstadisticasController controller = vista.getController();
            
            controller.setDatosPersona(datosPersona);
            
            //Muestro el escenario
            escenarioEstadisticas.show();
            
         } catch (Exception ex) {
             System.out.println(ex.getMessage());
         }
          
    }
    
    public void crearPDF() throws IOException{

        //Creo un nuevo documento, una página y la añado
        PDDocument documento = new PDDocument();
        PDPage pagina = new PDPage();
        documento.addPage(pagina);
        documento.getPage(0);

        //Inicio un nuevo stream de contenido
        PDPageContentStream contentStream = new PDPageContentStream(documento, pagina);

        //Establezco la posición Y de la primera líena y el tipo de fuente
        int linea = 700;
        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);

        //Recorro la lista de personas
        List<Persona> personas = datosPersona;
        for (Persona p : personas) {
            //Inicio un nuevo texto y escribo los datos
            contentStream.beginText();
                contentStream.newLineAtOffset(25, linea);
                contentStream.showText(p.getNombre()+" ");
                contentStream.showText(p.getApellidos()+" ");
                contentStream.showText(p.getDireccion()+" ");
                contentStream.showText(UtilidadDeFechas.formato(p.getFechaDeNacimiento())+" ");
            contentStream.endText();
            //Cambio de línea
            linea -= 25;
        }

        //Cierro el content stream
        contentStream.close();

        //INicio el file chooser
        FileChooser fileChooser = new FileChooser();

        //Filtro para la extensión
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "PDF files (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);

        //Muestro el diálogo de guardar
        File archivo = fileChooser.showSaveDialog(getEscenaPrincipal().getWindow());


        if (archivo != null) {

            //Me aseguro de que tiene la extensión correcta y si no la cambio
            String extension = "";
            if (!archivo.getPath().endsWith(extension)){
                extension = ".pdf";
            }
            //Escribo en el archivo y lo cierro
            archivo = new File(archivo.getPath() + extension);
            documento.save(archivo);
            documento.close();

        }
    }
    
    public void muestraVistaPersona(){
     
         try {
             FXMLLoader vista = new FXMLLoader(LibretaDirecciones.class.getResource("VistaPersona.fxml"));
             
             vistaPersona=vista.load();
             
             layoutPrincipal.setCenter(vistaPersona);
             
              
             //Doy acceso al controlador VistaPersonaCOntroller a LibretaDirecciones

             VistaPersonaController controller = vista.getController();

             controller.setLibretaDirecciones(this);

         } catch (Exception ex) {
             System.out.println(ex.getMessage());
                     
         }      
    }
    
    public boolean muestraEditarPersona(Persona persona) 
{

        boolean resul=false;
        
         try {
            Scene escenaEdicion;
            FXMLLoader vista = new FXMLLoader(LibretaDirecciones.class.getResource("EditarPersona.fxml"));
            escenaEdicion = new Scene(vista.load());
             
            Stage escenarioEdicion=new Stage();
            escenarioEdicion.setScene(escenaEdicion);
            escenarioEdicion.setTitle("Editar Persona");
            escenarioEdicion.getIcons().add(new Image("file:./src/main/resources/com/mycompany/libretadirecciones/icono32.png")); //Ojo con la ruta!!
            escenarioEdicion.initModality(Modality.WINDOW_MODAL);
            
             //Asigno el escenario de edición y la persona seleccionada al controlador

            EditarPersonaController controller = vista.getController();

            controller.setEscenarioEdicion(escenarioEdicion);

            controller.setPersona(persona);

            escenarioEdicion.showAndWait();
        
            resul=controller.isGuardarClicked();
            
         } catch (Exception ex) {
             ex.printStackTrace();
         }
               
        //devuelvo el botón pulsado

        return resul;
    }



    //Método main

    public static void main(String[] args) {

        launch(args);

    }


}