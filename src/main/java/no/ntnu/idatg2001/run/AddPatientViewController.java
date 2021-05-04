package no.ntnu.idatg2001.run;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.ntnu.idatg2001.patient.Patient;

import java.io.IOException;

/**
 * The type Add patient view controller.
 */
public class AddPatientViewController {
    @FXML
    private Button doneButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField ssnField;
    @FXML
    private TextField nameOfDoctorField;
    @FXML
    private TextField diagnosisField;


    /**
     * Handle create button.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void handleCreateButton(ActionEvent event) throws IOException {
        String greyColour = "-fx-border-color: lightgrey;";
        String redColour = "-fx-border-color: red;";

        firstNameField.setStyle(greyColour);
        lastNameField.setStyle(greyColour);
        ssnField.setStyle(greyColour);
        nameOfDoctorField.setStyle(greyColour);
        diagnosisField.setStyle(greyColour);

        if (firstNameField.getText().isEmpty()) {
            firstNameField.setStyle(redColour);
        }
        if (lastNameField.getText().isEmpty()) {
            lastNameField.setStyle(redColour);
        }
        if (ssnField.getText().isEmpty() || ssnField.getCharacters().length() != 11) {
            ssnField.setStyle(redColour);
        }
        if (nameOfDoctorField.getText().isEmpty()) {
            nameOfDoctorField.setStyle(redColour);
        } else {
            if (ssnField.getCharacters().length() == 11) {
                App.patientRegister.addPatient(new Patient(firstNameField.getText(), lastNameField.getText(), ssnField.getText()
                        , nameOfDoctorField.getText(), diagnosisField.getText()));
                closePopup(event);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Wrong digit count");
                alert.setHeaderText("You did not enter a valid social security number!");
                alert.setContentText("Please enter a valid ssn, 11 digits.");
                alert.showAndWait();
            }
        }
    }

    /**
     * Close window.
     *
     * @param event the event
     */
    @FXML
    public void closeWindow(ActionEvent event) {
        closePopup(event);
    }

    /**
     * Close popup.
     *
     * @param event the event
     */
    public void closePopup(ActionEvent event) {
        Stage popupStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        popupStage.close();
    }
}
