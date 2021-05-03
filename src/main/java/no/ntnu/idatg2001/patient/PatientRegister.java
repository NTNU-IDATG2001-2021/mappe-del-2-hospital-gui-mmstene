package no.ntnu.idatg2001.patient;

import java.util.ArrayList;
import java.util.List;

public class PatientRegister implements Register{

    List<Patient> patientArrayList;

    public PatientRegister() {
        patientArrayList = new ArrayList<>();
        addSomePatients();
    }

    @Override
    public void addSomePatients(){
        patientArrayList.add(new Patient("Martin", "Stene",
                "08059964537", "Taknæs"));
        patientArrayList.add(new Patient("Martinus", "Stenesen",
                "08059964666", "Taknæs"));
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
