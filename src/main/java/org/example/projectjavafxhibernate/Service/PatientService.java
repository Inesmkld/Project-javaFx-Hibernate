package org.example.projectjavafxhibernate.Service;

import org.example.projectjavafxhibernate.DAO.PatientDAO;
import org.example.projectjavafxhibernate.Model.Patient;

import java.util.List;

public class PatientService {

    private PatientDAO patientDAO = new PatientDAO();

    public void addPatient(Patient patient) {
        patientDAO.savePatient(patient);
    }

    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    public void updatePatient(Patient patient) {
        patientDAO.updatePatient(patient);
    }

    public void deletePatient(Long id) {
        patientDAO.deletePatient(id);
    }
}
