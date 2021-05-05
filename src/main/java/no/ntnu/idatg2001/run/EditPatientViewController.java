package no.ntnu.idatg2001.run;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.ntnu.idatg2001.patient.Patient;

/**
 * The type Edit patient view controller.
 */
public class EditPatientViewController {

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
    @FXML
    private Patient selectedPatient;

    /**
     * Edits an existing patient.
     * Gets the info about the patient from initData() used in the primarycontroller.
     * Uses this info an sets the text in the fields, if all requirements are met the
     * patient will be removed and a new one with the updated details will be added to the list.
     *
     * @param event the event
     */
    @FXML
    public void handleUpdatePatientButton(ActionEvent event) {
        String redColour = "-fx-border-color: red;";
        try {
            if (!firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty() &&
                    !ssnField.getText().isEmpty() && !nameOfDoctorField.getText().isEmpty()) {
                // Apply changes to task
                this.selectedPatient.setFirstName(firstNameField.getText());
                this.selectedPatient.setLastName(lastNameField.getText());
                this.selectedPatient.setSocialSecurityNumber(ssnField.getText());
                this.selectedPatient.setGeneralPractitioner(nameOfDoctorField.getText());
                this.selectedPatient.setDiagnosis(diagnosisField.getText());


                if (!AddPatientViewController.checkIfFieldsAreGood(redColour, firstNameField, lastNameField, ssnField, nameOfDoctorField,diagnosisField)
                        && ssnField.getText().chars().allMatch(Character::isDigit) && ssnField.getText().length() == 11) {

                    Patient editedPatient = new Patient(firstNameField.getText(), lastNameField.getText(),
                            ssnField.getText(), nameOfDoctorField.getText(), diagnosisField.getText());

                    App.patientRegister.getPatientArrayList().remove(selectedPatient);
                    App.patientRegister.getPatientArrayList().add(editedPatient);
                    closePopup(event);
                }
            }
        } catch (NullPointerException e) {
            e.getCause();
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
     * Initializing the data of the selected patient.
     *
     * @param patient the patient selected from the tableview
     */
    public void initData(Patient patient) {
        this.selectedPatient = patient;

        firstNameField.setText(patient.getFirstName());
        lastNameField.setText(patient.getLastName());
        ssnField.setText(patient.getSocialSecurityNumber());
        nameOfDoctorField.setText(patient.getGeneralPractitioner());
        diagnosisField.setText(patient.getDiagnosis());
    }
}
