package no.ntnu.idatg2001.patient;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Patient register.
 */
public class PatientRegister implements Register{

    /**
     * The Patient array list.
     */
    List<Patient> patientArrayList;

    /**
     * Instantiates a new Patient register.
     */
    public PatientRegister() {
        patientArrayList = new ArrayList<>();
    }

    @Override
    public void addPatient(Patient newPatient) {
        patientArrayList.add(newPatient);
    }

    @Override
    public void removePatient(Patient patientToBeRemoved) {
        patientArrayList.remove(patientToBeRemoved);
    }

    @Override
    public List<Patient> getPatientArrayList() {
        return patientArrayList;
    }
}
