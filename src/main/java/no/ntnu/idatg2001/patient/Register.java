package no.ntnu.idatg2001.patient;

import java.util.List;

public interface Register {
    void addPatient(Patient newPatient);
    void removePatient(Patient patient);
    void addSomePatients();
    List<Patient> getPatientArrayList();
}
