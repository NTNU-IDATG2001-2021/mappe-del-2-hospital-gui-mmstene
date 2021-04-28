package no.ntnu.idatg2001.patient;

import java.util.ArrayList;

public class PatientRegister {

    ArrayList<Patient> patientArrayList;

    public PatientRegister() {
        patientArrayList = new ArrayList<>();
        addFunny();
    }

    public void addPatient(Patient newPatient) {
        patientArrayList.add(newPatient);
    }

    public void removePatient(Patient patient) {
        patientArrayList.remove(patient);
    }

    public ArrayList<Patient> getPatientArrayList() {
        return patientArrayList;
    }

    public void setPatientArrayList(ArrayList<Patient> patientArrayList) {
        this.patientArrayList = patientArrayList;
    }

    public void addFunny(){
        patientArrayList.add(new Patient("Hei", "Moro",
                "123", "Hansen"));
    }
}
