package no.ntnu.idatg2001.run;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.ntnu.idatg2001.patient.Patient;

/**
 * The type Add patient view controller.
 */
public class AddPatientViewController {
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
     * Creates a new patient and adds them if certain conditions are fulfilled.
     * Adds them to the static list which gets updated after adding.
     *
     * @param event the event to close the window
     */
    @FXML
    public void handleCreateButton(ActionEvent event) {
        String greyColour = "-fx-border-color: lightgrey;";
        String redColour = "-fx-border-color: red;";

        firstNameField.setStyle(greyColour);
        lastNameField.setStyle(greyColour);
        ssnField.setStyle(greyColour);
        nameOfDoctorField.setStyle(greyColour);
        diagnosisField.setStyle(greyColour);

        if (!checkIfFieldsAreGood(redColour, firstNameField, lastNameField, ssnField, nameOfDoctorField,diagnosisField)
                && ssnField.getText().chars().allMatch(Character::isDigit) && ssnField.getCharacters().length() == 11) {
            App.patientRegister.addPatient(new Patient(firstNameField.getText(), lastNameField.getText(), ssnField.getText()
                    , nameOfDoctorField.getText(), diagnosisField.getText()));
            closePopup(event);
        }
    }


    /**
     * Checking each field to see if they are empty or to see if they have the correct data type
     * inserted in the textField.
     *
     * @param redColour         color of the textfield
     * @param firstNameField    first name textfield
     * @param lastNameField     last name textfield
     * @param ssnField          has an extra layer of code because I want the user to know that ssn requires 11 digits.
     * @param nameOfDoctorField name of dcotor textfield
     * @return the boolean as true if a condition goes through
     */
    static boolean checkIfFieldsAreGood(String redColour, TextField firstNameField, TextField lastNameField, TextField ssnField, TextField nameOfDoctorField, TextField diagnosisField) {
        boolean wrongTextFlag = false;
        if (firstNameField.getText().isEmpty() ||
                !firstNameField.getText().chars().filter(s -> !Character.isSpaceChar(s)).allMatch(Character::isLetter)) {
            firstNameField.setStyle(redColour);
            wrongTextFlag = true;
        }
        if (lastNameField.getText().isEmpty() ||
                !lastNameField.getText().chars().filter(s -> !Character.isSpaceChar(s)).allMatch(Character::isLetter)) {
            lastNameField.setStyle(redColour);
            wrongTextFlag = true;
        }
        if (ssnField.getText().isEmpty() || ssnField.getText().length() != 11) {
            ssnField.setStyle(redColour);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wrong digit count");
            alert.setHeaderText("You did not enter a valid social security number!");
            alert.setContentText("Please enter a valid ssn, 11 digits. These need to be integers.");
            alert.showAndWait();
            wrongTextFlag = true;
        }
        if (nameOfDoctorField.getText().isEmpty() ||
                !nameOfDoctorField.getText().chars().filter(s -> !Character.isSpaceChar(s)).allMatch(Character::isLetter)) {
            nameOfDoctorField.setStyle(redColour);
            wrongTextFlag = true;
        }

        if (!diagnosisField.getText().chars().filter(s -> !Character.isSpaceChar(s)).allMatch(Character::isLetter)){
            diagnosisField.setStyle(redColour);
            wrongTextFlag = true;
        }
        return wrongTextFlag;
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
