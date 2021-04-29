package no.ntnu.idatg2001.patient;

import java.util.ArrayList;
import java.util.List;

public class PatientRegister implements Register{

    List<Patient> patientArrayList;

    public PatientRegister() {
        patientArrayList = new ArrayList<>();
        addSomePatients();
    }

    public void setPatientArrayList(List<Patient> patientArrayList) {
        this.patientArrayList = patientArrayList;
    }

    @Override
    public void addSomePatients(){
        patientArrayList.add(new Patient("Martin", "Stene",
                "08059964537", "Taknæs"));
    }

    @Override
    public void addPatient(Patient newPatient) {
        patientArrayList.add(newPatient);
    }

    @Override
    public void removePatient(Patient patient) {
        patientArrayList.remove(patient);
    }

    @Override
    public List<Patient> getPatientArrayList() {
        return patientArrayList;
    }
}
