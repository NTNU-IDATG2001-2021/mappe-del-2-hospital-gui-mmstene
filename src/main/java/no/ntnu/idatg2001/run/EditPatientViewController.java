package no.ntnu.idatg2001.run;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.ntnu.idatg2001.patient.Patient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditPatientViewController implements Initializable {

    public Button doneButton;
    public Button cancelButton;
    public TextField firstNameField;
    public TextField lastNameField;
    public TextField ssnField;
    public TextField nameOfDoctorField;
    private Patient selectedPatient;

    @FXML
    public void handleUpdatePatientButton(ActionEvent event) throws IOException {
        if (!firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty() &&
                !ssnField.getText().isEmpty() && !nameOfDoctorField.getText().isEmpty()) {
            // Apply changes to task
            this.selectedPatient.setFirstName(firstNameField.getText());
            this.selectedPatient.setLastName(lastNameField.getText());
            this.selectedPatient.setSocialSecurityNumber(ssnField.getText());
            this.selectedPatient.setGeneralPractitioner(nameOfDoctorField.getText());

            Patient editedPatient = new Patient(firstNameField.getText(), lastNameField.getText(),
                    ssnField.getText(), nameOfDoctorField.getText());

            App.patientRegister.getPatientArrayList().remove(selectedPatient);
            App.patientRegister.getPatientArrayList().add(editedPatient);


            closePopup(event);
        }
    }

    @FXML
    public void closeWindow(ActionEvent event) {
        closePopup(event);
    }

    public void closePopup(ActionEvent event) {
        Stage popupStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        popupStage.close();
    }

    public void initData(Patient patient) {
        this.selectedPatient = patient;

        firstNameField.setText(patient.getFirstName());
        lastNameField.setText(patient.getLastName());
        ssnField.setText(patient.getSocialSecurityNumber());
        nameOfDoctorField.setText(patient.getGeneralPractitioner());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
