package no.ntnu.idatg2001.run;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import no.ntnu.idatg2001.patient.Patient;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

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
    public void handleAddButton() throws IOException {
        FXMLLoader addPatientWindow = new FXMLLoader(getClass().getClassLoader().getResource("AddPatientView.fxml"));
        Scene addP = new Scene(addPatientWindow.load());
        Stage stage = new Stage();
        stage.setScene(addP);
        stage.showAndWait();
    }

    @FXML
    public void handleEditButton() throws IOException {
        FXMLLoader addPatientWindow = new FXMLLoader(getClass().getClassLoader().getResource("EditPatientView.fxml"));
        Scene addP = new Scene(addPatientWindow.load());
        Stage stage = new Stage();
        stage.setScene(addP);
        stage.showAndWait();
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

    @FXML
    public void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the software");
        alert.setHeaderText("Patient register v1");
        alert.setContentText("This is a fantastic program created by\n" + "(C)Martin Stene\n" + "2021");
        alert.showAndWait();
    }

    /*public void updateTasks() {
        // Get tasks from database
        App.patientRegister = App.patientRegister.getPatientArrayList();

        // Set tasks to list view
        ObservableList<String> listOfTaskNames = FXCollections.observableArrayList(new ArrayList<>());
        for (Task task : App.tasksCurrentlyShown) {
            listOfTaskNames.add(task.getTaskName());
        }
        listOfTasks.setItems(listOfTaskNames);
    }*/

    @FXML
    private void getPatients() {

        ObservableList<Patient> patientsObservableList = FXCollections.observableArrayList();
        patientsObservableList.addAll(App.patientRegister.getPatientArrayList());

        tableView.setItems(patientsObservableList);
    }

    public void setTableContent(ArrayList<Patient> patientArrayList) {
        tableView.getItems().setAll(patientArrayList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
        socialSecurityNumberColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("socialSecurityNumber"));
        nameOfDoctorColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("generalPractitioner"));
        getPatients();
    }
}
