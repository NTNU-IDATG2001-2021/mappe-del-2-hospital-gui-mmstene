package no.ntnu.idatg2001.patient;

import java.util.Objects;

public class Patient {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private transient String diagnosis;
    private String generalPractitioner;

    public Patient(String firstName, String lastName, String socialSecurityNumber, String generalPractitioner) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        //this.diagnosis = diagnosis;
        this.generalPractitioner = generalPractitioner;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getGeneralPractitioner() {
        return generalPractitioner;
    }

    public void setGeneralPractitioner(String generalPractitioner) {
        this.generalPractitioner = generalPractitioner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return socialSecurityNumber.equals(patient.socialSecurityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socialSecurityNumber);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
