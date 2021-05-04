package no.ntnu.idatg2001.file;

import javafx.scene.control.Alert;
import no.ntnu.idatg2001.patient.Patient;
import no.ntnu.idatg2001.run.App;

import java.io.*;

/**
 * The type Read from csv.
 */
public class ReadFromCSV {


    /**
     * A default private constructor
     */
    private ReadFromCSV() {
    }

    /**
     * Read from a selected file.
     *
     * @param file the file
     */
    public static void read(File file) throws IOException {
        String line;
        final String seperator = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] tempArray;
            while ((line = br.readLine()) != null) {
                tempArray = line.split(seperator);
                Patient patient = new Patient(tempArray[0], tempArray[1], tempArray[3], tempArray[2], "");
                App.patientRegister.getPatientArrayList().add(patient);
            }
        } catch (IOException e) {
            e.getCause();
        } catch (ArrayIndexOutOfBoundsException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Incorrect file formatting!");
            alert.setHeaderText("Incorrect formatting of .csv file");
            alert.setContentText("To import a .csv file you will need it on the format: " +
                    "firstname;lastname;generalPractitioner;socialSecurityNumber;diagnosis");
            alert.showAndWait();
        }
    }

    /**
     * Save list to file.
     *
     * @param file the file
     */
    public static void saveListToFile(File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            getPatientsToWrite(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getPatientsToWrite(PrintWriter writer){
        try {
            for (Patient person : App.patientRegister.getPatientArrayList()) {
                String text = person.getFirstName() + ","
                        + person.getLastName() + ","
                        + person.getSocialSecurityNumber()
                        + "," + person.getGeneralPractitioner()
                        + "," + person.getDiagnosis() + "\n";
                writer.write(text);
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
}
