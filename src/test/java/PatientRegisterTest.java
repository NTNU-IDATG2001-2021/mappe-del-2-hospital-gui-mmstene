import no.ntnu.idatg2001.patient.Patient;
import no.ntnu.idatg2001.patient.PatientRegister;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientRegisterTest {

    PatientRegister patientRegister;
    Patient patient;

    @BeforeEach
    void setUp() {
        System.out.println("Entering new patients");
        patientRegister = new PatientRegister();
        patient = new Patient("Heihei", "Svein",
                "12345678901", "Hansen");
        patientRegister.getPatientArrayList().add(patient);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Clearing list");
        patientRegister.getPatientArrayList().clear();
    }

    @Test
    @DisplayName("Checking to see if a patient is added sucsessfully")
    void addPatient() {
        int beforeAdd = patientRegister.getPatientArrayList().size();
        patientRegister.addPatient(patient);
        int afterAdd = patientRegister.getPatientArrayList().size();

        assertNotEquals(beforeAdd, afterAdd);
    }

    @Test
    @DisplayName("Checking to see if a person is removed correctly")
    void removePatient() {
        int beforeAdd = patientRegister.getPatientArrayList().size();
        patientRegister.removePatient(patient);
        int afterAdd = patientRegister.getPatientArrayList().size();

        assertNotEquals(beforeAdd, afterAdd);
    }

    @Test
    @DisplayName("Checking to see if a patient is added sucsessfully, negative test")
    void addPatientNegative(){
        try {
            int beforeAdd = patientRegister.getPatientArrayList().size();
            patientRegister.addPatient(patient);
            int afterAdd = patientRegister.getPatientArrayList().size();
            fail("Should not be the same!");
        } catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("Checking to see if a person is removed correctly, negative test")
    void removePatientNegative(){
        try {
            int beforeAdd = patientRegister.getPatientArrayList().size();
            patientRegister.removePatient(patient);
            int afterAdd = patientRegister.getPatientArrayList().size();
            fail("Should not be the same!");
        } catch (Exception e){
            assertTrue(true);
        }
    }

}