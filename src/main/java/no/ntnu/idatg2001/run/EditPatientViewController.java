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

/**
 * The type Edit patient view controller.
 */
public class EditPatientViewController implements Initializable {

    /**
     * The Done button.
     */
    public Button doneButton;
    /**
     * The Cancel button.
     */
    public Button cancelButton;
    /**
     * The First name field.
     */
    public TextField firstNameField;
    /**
     * The Last name field.
     */
    public TextField lastNameField;
    /**
     * The Ssn field.
     */
    public TextField ssnField;
    /**
     * The Name of doctor field.
     */
    public TextField nameOfDoctorField;
    /**
     * The Diagnosis field.
     */
    public TextField diagnosisField;
    private Patient selectedPatient;

    /**
     * Handle update patient button.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void handleUpdatePatientButton(ActionEvent event) throws IOException {
        if (!firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty() &&
                !ssnField.getText().isEmpty() && !nameOfDoctorField.getText().isEmpty()) {
            // Apply changes to task
            this.selectedPatient.setFirstName(firstNameField.getText());
            this.selectedPatient.setLastName(lastNameField.getText());
            this.selectedPatient.setSocialSecurityNumber(ssnField.getText());
            this.selectedPatient.setGeneralPractitioner(nameOfDoctorField.getText());
            this.selectedPatient.setDiagnosis(diagnosisField.getText());

            Patient editedPatient = new Patient(firstNameField.getText(), lastNameField.getText(),
                    ssnField.getText(), nameOfDoctorField.getText(), diagnosisField.getText());

            App.patientRegister.getPatientArrayList().remove(selectedPatient);
            App.patientRegister.getPatientArrayList().add(editedPatient);


            closePopup(event);
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

    /**
     * Init data.
     *
     * @param patient the patient
     */
    public void initData(Patient patient) {
        this.selectedPatient = patient;

        firstNameField.setText(patient.getFirstName());
        lastNameField.setText(patient.getLastName());
        ssnField.setText(patient.getSocialSecurityNumber());
        nameOfDoctorField.setText(patient.getGeneralPractitioner());
        diagnosisField.setText(patient.getDiagnosis());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
