package no.ntnu.idatg2001.run;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.idatg2001.patient.Patient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditPatientViewController implements Initializable {

    /*@FXML
    public void handleUpdateTaskButton() throws IOException {
        if(!taskDescriptionFieldShort.getText().isEmpty() && !taskDescriptionField.getText().isEmpty() &&
                comboBoxPriority.getValue() != null && comboBoxCategory.getValue() != null &&
                deadlineTaskCalendar.getValue() != null)
        {
            // Get task object to be changed
            Patient tempTask = App.taskList.getTaskById(App.getSelectedIndex());

            // Apply changes to task
            tempTask.setCategory(comboBoxCategory.getValue());
            tempTask.changePriority(comboBoxPriority.getValue());
            tempTask.setTaskName(taskDescriptionFieldShort.getText());
            tempTask.setTaskDescription(taskDescriptionField.getText());
            tempTask.setDeadline(deadlineTaskCalendar.getValue());

            // Update task in database
            App.taskList.updateTask(tempTask);

            // Return to main menu
            Parent root = FXMLLoader.load((getClass().getClassLoader().getResource("MainMenuView.fxml")));
            Stage window = (Stage) markTaskAsDoneButton.getScene().getWindow();
            window.setScene(new Scene(root));
        }
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
