package bmt.codelympics_.controller.log;

import bmt.codelympics_.model.ChangeStage;
import com.opencsv.CSVReader;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import bmt.codelympics_.model.Encryptor;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

// Classe controller per la schermata di registrazione degli utenti
public class PageIscriviti extends ChangeStage {

    // Definizione dei componenti FXML
    @FXML
    private Button btn_annullaAcc;

    @FXML
    private Button btn_iscrivitiGo;

    @FXML
    private CheckBox checkbox_show;

    @FXML
    private Circle colorAvatar;

    @FXML
    private ColorPicker colorChange;

    @FXML
    private PasswordField hiddentxtField_psw;

    @FXML
    private Label lbl_error;

    @FXML
    private TextField txtField_email;

    @FXML
    private TextField txtField_psw;

    @FXML
    private TextField txtField_username;

    // Instanza di Encryptor per cifrare le password
    Encryptor encryptor = new Encryptor();

    // HashMap per salvare temporaneamente le informazioni di login lette dal file CSV
    HashMap<String, String> loginInfo = new HashMap<>();

    // Metodo per gestire l'evento di click sul bottone "Annulla", che torna alla schermata principale
    @FXML
    void func_Home(MouseEvent event) throws Exception {
        fuc_changeStage(btn_annullaAcc, "/bmt/codelympics_/fxml/home/home.fxml");
    }

    // Metodo per gestire la visibilità della password quando la checkbox è selezionata
    @FXML
    void func_changeVisibility(MouseEvent event) {
        if (checkbox_show.isSelected()) {
            txtField_psw.setText(hiddentxtField_psw.getText()); // Mostra il testo in chiaro
            txtField_psw.setVisible(true);
            hiddentxtField_psw.setVisible(false);
        } else {
            hiddentxtField_psw.setText(txtField_psw.getText()); // Nasconde il testo
            hiddentxtField_psw.setVisible(true);
            txtField_psw.setVisible(false);
        }
    }

    // Metodo per gestire l'evento di click sul bottone "Iscriviti", che valida i dati e passa alla schermata di accesso
    @FXML
    void func_goPlayHome(MouseEvent event) throws Exception {
        String username = txtField_username.getText();
        String mail = txtField_email.getText();
        String password = txtField_psw.getText();
        // Controlla se l'username e l'email sono validi e se il formato è corretto
        if (controlEqualsUsernameAndMail(username, mail) && ContrlUsPswMail(username, password, mail)) {
            writeToFile(); // Scrive i dati utente nel file CSV
            fuc_changeStage(btn_iscrivitiGo, "/bmt/codelympics_/fxml/log/accedi.fxml");
        }
    }

    // Metodo per leggere i dati esistenti da un file CSV e popolare la HashMap loginInfo
    private void seeUsernameAndMail() throws Exception {
        String filePath = System.getProperty("user.home") + "/playproj/props.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            loginInfo.clear(); // Pulisce la HashMap prima di caricare nuovi dati
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length >= 2) {
                    loginInfo.put(line[0], line[2]); // Salva username ed email
                }
            }
        } catch (FileNotFoundException e) {
            throw new IOException("File CSV non trovato: " + filePath); // Gestione eccezione se il file non esiste
        }
    }

    // Metodo per verificare la validità dell'username, della password e dell'email
    boolean ContrlUsPswMail(String username, String password, String mail) {
        if (!username.matches("[a-zA-Z0-9 ]*")) { // Verifica se l'username è valido
            lbl_error.setText("Errore Username non valido");
            lbl_error.setVisible(true);
            return false;
        }
        if (password.isBlank()) { // Verifica se la password non è vuota
            lbl_error.setText("Errore password non valida");
            lbl_error.setVisible(true);
            return false;
        }
        if (!mail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) { // Verifica il formato dell'email
            lbl_error.setText("Errore mail non valida");
            lbl_error.setVisible(true);
            return false;
        }

        return true;
    }

    // Metodo per verificare se l'username o l'email sono già presenti nel file CSV
    boolean controlEqualsUsernameAndMail(String username, String mail) throws Exception {
        seeUsernameAndMail(); // Carica i dati dal file
        if (loginInfo.containsKey(username)) { // Controlla se l'username esiste già
            lbl_error.setText("Errore username già in uso");
            lbl_error.setVisible(true);
            return false;
        }
        if (loginInfo.containsValue(mail)) { // Controlla se l'email esiste già
            lbl_error.setText("Errore mail già in uso");
            lbl_error.setVisible(true);
            return false;
        }
        return true;
    }

    // Metodo per scrivere i nuovi dati utente nel file CSV
    void writeToFile() throws Exception {
        String username = txtField_username.getText();
        String password = hiddentxtField_psw.getText();
        String email = txtField_email.getText();
        Color colore = (Color) colorAvatar.getFill(); // Ottiene il colore selezionato per l'avatar

        // Converti il colore in formato esadecimale per salvarlo nel file CSV
        String coloreHex = String.format("#%02X%02X%02X",
                (int) (colore.getRed() * 255),
                (int) (colore.getGreen() * 255),
                (int) (colore.getBlue() * 255));

        String filePath = System.getProperty("user.home") + "/playproj/props.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Scrive i dati nel formato CSV
            writer.write(username + "," + encryptor.encryptString(password) + "," + email + "," + coloreHex + "," + "0"
                    + "," + "0" + "," + "0" + "," + "0" + "," + "0" + "," + "0" + "," + "0" + "," + "0" + ","
                    + "0" + "," + "0" + "," + "0" + "," + "0" + "," + "0" + "," + "0" + "," + "0" + "," + "0"
                    + "," + "0" + "," + "0" + "," + "0" + "," + "0" + "," + "0" + "," + "0" + "," + "0" + ","
                    + "0" + "\n");

        } catch (Exception e) {
            e.printStackTrace(); // Gestisce eventuali errori durante la scrittura
        }
    }

    // Metodo per cambiare il colore dell'avatar basato sul valore selezionato nel ColorPicker
    @FXML
    void setColor(ActionEvent event) {
        Color colore = colorChange.getValue();
        colorAvatar.setFill(colore); // Imposta il colore del cerchio/avatar
    }
}
