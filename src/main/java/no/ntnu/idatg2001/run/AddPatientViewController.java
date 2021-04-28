package no.ntnu.idatg2001.run;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.ntnu.idatg2001.patient.Patient;

import java.io.IOException;

public class AddPatientViewController {


    public Button doneButton;
    public Button cancelButton;
    public TextField firstNameField;
    public TextField lastNameField;
    public TextField ssnField;
    public TextField nameOfDoctorField;


    @FXML
    public void handleCreateButton(ActionEvent event) throws IOException {
        firstNameField.setStyle("-fx-border-color: lightgrey;");
        lastNameField.setStyle("-fx-border-color: lightgrey;");
        ssnField.setStyle("-fx-border-color: lightgrey;");
        nameOfDoctorField.setStyle("-fx-border-color: lightgrey;");


        if (firstNameField.getText().isEmpty()) {
            firstNameField.setStyle("-fx-border-color: red;");
        }
        if (lastNameField.getText().isEmpty()) {
            lastNameField.setStyle("-fx-border-color: red;");
        }
        if (ssnField.getText().isEmpty()) {
            ssnField.setStyle("-fx-border-color: red;");
        }
        if (nameOfDoctorField.getText().isEmpty()) {
            nameOfDoctorField.setStyle("-fx-border-color: red;");
        }

        else {
            App.patientRegister.addPatient(new Patient(firstNameField.getText(), lastNameField.getText(), ssnField.getText()
                    ,nameOfDoctorField.getText()));
            closePopup(event);
        }
    }

    @FXML
    public void closeWindow(ActionEvent event){
        closePopup(event);
    }

    public void closePopup(ActionEvent event){
        Stage popupStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        popupStage.close();
    }
}
