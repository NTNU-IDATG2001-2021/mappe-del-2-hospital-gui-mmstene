package no.ntnu.idatg2001.run;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import no.ntnu.idatg2001.file.ReadFromCSV;
import no.ntnu.idatg2001.patient.Patient;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * The type Primary register view controller.
 */
public class PrimaryRegisterViewController implements Initializable {
    @FXML
    private TableView<Patient> tableView;
    @FXML
    private TableColumn<Patient, String> firstNameColumn;
    @FXML
    private TableColumn<Patient, String> lastNameColumn;
    @FXML
    private TableColumn<Patient, String> socialSecurityNumberColumn;
    @FXML
    private TableColumn<Patient, String> nameOfDoctorColumn;
    @FXML
    private TableColumn<Patient, String> diagnosisColumn;

    /**
     * Remove patient.
     */
    @FXML
    public void removePatient() {
        try {
            Patient patient = tableView.getSelectionModel().getSelectedItem();
            if (patient != null) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Removing the patient");
                alert.setHeaderText("Do you really want to remove " + patient + " from the registry?");
                alert.setContentText("Are you really ok with this?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    App.patientRegister.removePatient(patient);
                    getPatients();
                } else {
                    alert.close();
                }
            } else {
                noPatientSelected("remove");
            }
        } catch (NullPointerException e){

        }
    }

    /**
     * Handle add button.
     *
     * @throws IOException the io exception
     */
    @FXML
    public void handleAddButton() throws IOException {
        FXMLLoader addPatientWindow = new FXMLLoader(getClass().getClassLoader().getResource("AddPatientView.fxml"));
        Scene addPatient = new Scene(addPatientWindow.load());
        Stage stage = new Stage();
        stage.setScene(addPatient);
        stage.showAndWait();
        getPatients(); // This is for updating the tableview after adding a new Patient
    }

    /**
     * Handle edit button.
     *
     * @throws IOException the io exception
     */
    @FXML
    public void handleEditButton() throws IOException {
        try {
            Patient patient = tableView.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("EditPatientView.fxml"));
            Parent parent = loader.load();

            EditPatientViewController popupEdit = loader.getController();
            popupEdit.initData(patient);

            Scene addP = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(addP);
            stage.showAndWait();
            getPatients();
        } catch (NullPointerException ignored) {
            noPatientSelected("edit");
        }
    }

    @FXML
    private void handleExitButton() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Do you really want to exit the application?");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        } else {
            alert.close();
        }
    }

    /**
     * Handle about.
     */
    @FXML
    public void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the software");
        alert.setHeaderText("Patient register v1");
        alert.setContentText("This is a fantastic program created by\n" + "(C)Martin Stene\n" + "2021");
        alert.showAndWait();
    }

    @FXML
    private void getPatients() {
        ObservableList<Patient> patientsObservableList = FXCollections.observableArrayList();
        patientsObservableList.addAll(App.patientRegister.getPatientArrayList());

        tableView.setItems(patientsObservableList);
    }

    /**
     * Select file.
     *
     * @throws FileNotFoundException the file not found exception
     */
    @FXML
    public void selectFile() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files", "*.csv"));
        Stage stage = new Stage();
        File selectedFile = fileChooser.showOpenDialog(stage);
        ReadFromCSV.read(selectedFile);
        getPatients();
    }

    /**
     * Save as csv.
     */
    @FXML
    public void saveAsCSV() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as");
        fileChooser.setInitialFileName("");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV files", "*.csv"));
        Stage stage = new Stage();
        File file = fileChooser.showSaveDialog(stage);
        fileChooser.setInitialDirectory(file.getParentFile());
        if (file != null) {
            ReadFromCSV.saveListToFile(file);
        }
    }

    /**
     * No patient selected.
     *
     * @param message the message
     */
    public void noPatientSelected(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("No patient selected");
        alert.setHeaderText("You didn't select a patient to " + message + "!");
        alert.setContentText("Please select a patient if you want to " + message + " them.");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        socialSecurityNumberColumn.setCellValueFactory(new PropertyValueFactory<>("socialSecurityNumber"));
        nameOfDoctorColumn.setCellValueFactory(new PropertyValueFactory<>("generalPractitioner"));
        diagnosisColumn.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        getPatients();
    }
}
