package no.ntnu.idatg2001.run;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class PrimaryRegisterViewController {
    @FXML
    private TableColumn firstNameColumn;
    @FXML
    private TableColumn lastNameColumn;
    @FXML
    private TableColumn socialSecurityNumberColumn;
    @FXML
    private TableColumn nameOfDoctorColumn;


    @FXML
    private Button addPatientButton;
    @FXML
    private Button editPatientButton;
    @FXML
    private Button removePatientButton;


    @FXML
    private MenuItem importFromCSV;
    @FXML
    private MenuItem exportToCSV;
    @FXML
    private MenuItem exitButton;
    @FXML
    private MenuItem addPatient;
    @FXML
    private MenuItem editPatient;
    @FXML
    private MenuItem removePatient;
    @FXML
    private MenuItem aboutApp;

    @FXML
    private void handleExitButton(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Do you really want to exit the application?");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.exit(0);
        } else {
            alert.close();
        }
    }
}
