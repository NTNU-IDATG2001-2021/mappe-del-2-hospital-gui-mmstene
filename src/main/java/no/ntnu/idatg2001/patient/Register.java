package no.ntnu.idatg2001.patient;

import java.util.List;

/**
 * The interface Register.
 */
public interface Register {
    /**
     * Add a patient to the list of patients.
     *
     * @param newPatient the new patient to be added
     */
    void addPatient(Patient newPatient);

    /**
     * Remove a patient from the list of patients.
     *
     * @param patient the patient to be removed
     */
    void removePatient(Patient patient);

    /**
     * Gets patient array list.
     *
     * @return the patient array list
     */
    List<Patient> getPatientArrayList();
}
