package bmt.codelympics_.controller.log;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import bmt.codelympics_.model.Encryptor;
import com.opencsv.CSVReader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;

// Classe controller per la schermata di login
public class PageAccedi extends ChangeStage {

    // Definizione dei componenti FXML
    @FXML
    private Button btn_accediGo; // Bottone per effettuare il login

    @FXML
    private Button btn_annullaAcc; // Bottone per annullare il login e tornare indietro

    @FXML
    private CheckBox checkbox_show; // Checkbox per mostrare/nascondere la password

    @FXML
    private PasswordField hiddentxtField_psw; // Campo per la password nascosta

    @FXML
    private AnchorPane img_avatar; // Pane per gestire l'avatar dell'utente

    @FXML
    private AnchorPane img_avatar2; // Pane alternativo per l'avatar, utilizzato per la visibilità della password

    @FXML
    private Label lbl_error; // Label per visualizzare errori di login

    @FXML
    private TextField txtField_psw; // Campo per la password visibile

    @FXML
    private TextField txtField_username; // Campo per inserire l'username

    // Singleton per gestire i dati utente e Encryptor per cifrare le password
    DataSingleton data = DataSingleton.getInstance();
    HashMap<String, String> loginInfo = new HashMap<>();
    Encryptor encryptor = new Encryptor();

    // Metodo per gestire l'evento di click sul bottone "Annulla", torna alla schermata principale
    @FXML
    void func_Home(MouseEvent event) throws Exception {
        fuc_changeStage(btn_annullaAcc, "/bmt/codelympics_/fxml/home/home.fxml");
    }

    // Metodo per gestire il login dell'utente e passare alla schermata dei giochi
    @FXML
    void func_goPlayHome(MouseEvent event) throws Exception {
        String filePath = System.getProperty("user.home") + "/playproj/props.csv"; // Percorso al file CSV con i dati utente
        String username = txtField_username.getText();
        String password = hiddentxtField_psw.getText();
        updateLoginUsernamesAndPasswords(); // Aggiorna la mappa degli username e delle password

        String encryptedPassword = loginInfo.get(username);
        // Verifica se la password inserita, una volta cifrata, corrisponde a quella salvata
        if (encryptor.encryptString(password).equals(encryptedPassword) && controlloSeEsisteUtente(username)) {
            System.out.println("Login successful!");

            try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
                String[] line;
                while ((line = reader.readNext()) != null) {

                    if (line[0].equals(username)) {
                        data.setArrayUtente(line); // Setta i dati utente nel singleton

                    }
                }
            } catch (FileNotFoundException e) {
                throw new IOException("File CSV non trovato: " + filePath); // Gestione eccezione se il file non esiste
            }

            // Cambio di scena verso la schermata dei giochi
            fuc_changeStage(btn_accediGo, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
        } else {
            // Gestione errori di login
            lbl_error.setVisible(true);
            if (!controlloSeEsisteUtente(username)) {
                lbl_error.setText("Errore utente inesistente");
            } else {
                lbl_error.setText("Errore password errata");
            }
        }
    }

    // Metodo per verificare se l'utente esiste nel file CSV
    boolean controlloSeEsisteUtente(String username) throws Exception {
        String filePath = System.getProperty("user.home") + "/playproj/props.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].equals(username)) return true;
            }
            return false;
        } catch (FileNotFoundException e) {
            throw new IOException("File CSV non trovato: " + filePath); // Gestione eccezione se il file non esiste
        }
    }

    // Metodo per cambiare la visibilità della password
    @FXML
    void func_changeVisibility(MouseEvent event) {
        if (checkbox_show.isSelected()) {
            txtField_psw.setText(hiddentxtField_psw.getText()); // Mostra la password
            txtField_psw.setVisible(true);
            hiddentxtField_psw.setVisible(false);
            img_avatar.setVisible(false); // Cambia avatar
            img_avatar2.setVisible(true);
        } else {
            hiddentxtField_psw.setText(txtField_psw.getText()); // Nasconde la password
            hiddentxtField_psw.setVisible(true);
            txtField_psw.setVisible(false);
            img_avatar2.setVisible(false); // Cambia avatar
            img_avatar.setVisible(true);
        }
    }

    // Metodo per aggiornare la mappa degli username e delle password dal file CSV
    private void updateLoginUsernamesAndPasswords() throws Exception {
        String filePath = System.getProperty("user.home") + "/playproj/props.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            loginInfo.clear(); // Pulisce la mappa prima di caricare nuovi dati
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length >= 2) {
                    loginInfo.put(line[0], line[1]); // Popola la mappa con username e password cifrata
                }
            }
        } catch (FileNotFoundException e) {
            throw new IOException("File CSV non trovato: " + filePath); // Gestione eccezione se il file non esiste
        }
    }

    // Metodo di inizializzazione della classe, carica gli username e le password all'avvio
    @FXML
    public void initialize() {
        try {
            updateLoginUsernamesAndPasswords(); // Carica i dati di login dal file CSV
        } catch (Exception e) {
            e.printStackTrace();
            lbl_error.setVisible(true); // Mostra un errore se c'è un problema nel caricamento
        }
    }
}

// https://chatgpt.com/share/a3883244-1901-4ce6-9d9b-e17cbfeed365
