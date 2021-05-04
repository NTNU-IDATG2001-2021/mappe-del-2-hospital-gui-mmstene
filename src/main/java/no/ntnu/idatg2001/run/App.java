package no.ntnu.idatg2001.run;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.idatg2001.patient.PatientRegister;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    /**
     * The constant patientRegister. This is to use the same list over the whole project.
     */
    public static PatientRegister patientRegister = new PatientRegister();

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("PrimaryRegisterView"));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Sets root.
     *
     * @param fxml the fxml
     * @throws IOException the io exception
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getClassLoader().getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}