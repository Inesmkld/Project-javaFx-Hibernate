package org.example.projectjavafxhibernate.Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.projectjavafxhibernate.Model.Patient;
import org.example.projectjavafxhibernate.Service.PatientService;

import java.sql.Date;

public class PatientController {

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private DatePicker dateNaissancePicker;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtEmail;
    @FXML
    private ChoiceBox<String> choiceSexe;
    @FXML
    private ChoiceBox<String> choiceGsanguin;
    @FXML
    private ChoiceBox<String> choiceSituation;
    @FXML
    private TableView<Patient> tablePatients;
    @FXML
    private TableColumn<Patient, String> colNom;
    @FXML
    private TableColumn<Patient, String> colPrenom;

    private PatientService patientService = new PatientService();
    private ObservableList<Patient> patientList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        choiceSexe.getItems().addAll("M", "F");
        choiceGsanguin.getItems().addAll("A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-");
        choiceSituation.getItems().addAll("Célibataire", "Marié", "Divorcé", "Veuf");

        colNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        colPrenom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));

        loadPatients();
    }

    private void loadPatients() {
        patientList.clear();
        patientList.addAll(patientService.getAllPatients());
        tablePatients.setItems(patientList);
    }

    @FXML
    private void addPatient() {
        Patient patient = new Patient(
            txtNom.getText(),
            txtPrenom.getText(),
            Date.valueOf(dateNaissancePicker.getValue()),
            txtAdresse.getText(),
            txtTel.getText(),
            txtEmail.getText(),
            choiceSexe.getValue(),
            choiceGsanguin.getValue(),
            choiceSituation.getValue()
        );

        patientService.addPatient(patient);
        loadPatients();
    }

    @FXML
    private void deletePatient() {
        Patient selectedPatient = tablePatients.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            patientService.deletePatient(selectedPatient.getId());
            loadPatients();
        }
    }
}
