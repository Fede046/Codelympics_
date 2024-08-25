package bmt.codelympics_.controller.homes;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

// Classe controller per la schermata "Games Home"
public class GamesHome extends ChangeStage implements Initializable {

    // Definizione dei bottoni e dei componenti FXML
    @FXML
    private Button btn_GoHome;

    @FXML
    private Button btn_goMedagliere;

    @FXML
    private Button btn_startErrore;

    @FXML
    private Button btn_startMultiple;

    @FXML
    private Button btn_startVF;

    @FXML
    private Button btn_startRiordinamento;

    @FXML
    private BorderPane img_1;

    @FXML
    private BorderPane img_2;

    @FXML
    private BorderPane img_3;

    @FXML
    private BorderPane img_4;

    @FXML
    private ProgressBar prgbar_VF;

    @FXML
    private ProgressBar prgbar_errore;

    @FXML
    private ProgressBar prgbar_multiple;

    @FXML
    private ProgressBar prgbar_riordinamento;

    // Istanza del singleton DataSingleton per condividere i dati globali
    DataSingleton data = DataSingleton.getInstance();

    // Metodo per gestire l'evento di click sul bottone "Home"
    @FXML
    void func_Home(MouseEvent event) throws Exception {
        // Cambia lo stage alla schermata "home"
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/home/home.fxml");
    }

    // Metodo per gestire l'evento di click sul bottone "Medagliere"
    @FXML
    void func_goMedagliere(MouseEvent event) throws Exception {
        // Cambia lo stage alla schermata "Medagliere"
        fuc_changeStage(btn_goMedagliere, "/bmt/codelympics_/fxml/classifica/Medagliere.fxml");
    }

    // Metodo per gestire l'evento di click sul bottone "Errore"
    @FXML
    void func_startErrore(MouseEvent event) throws Exception {
        data.setStringaMedaglia(16); // Imposta un valore specifico nel DataSingleton
        // Cambia lo stage alla schermata di gioco "trovaErrore"
        fuc_changeStage(btn_startErrore, "/bmt/codelympics_/fxml/regoleGioco/RegoleGioco.fxml");
    }

    // Metodo per gestire l'evento di click sul bottone "Multiplo"
    @FXML
    void func_startMultiplo(MouseEvent event) throws Exception {
        data.setStringaMedaglia(4); // Imposta un valore specifico nel DataSingleton
        // Cambia lo stage alla schermata di gioco "Ris Multiple"
        fuc_changeStage(btn_startMultiple, "/bmt/codelympics_/fxml/regoleGioco/RegoleGioco.fxml");
    }

    // Metodo per gestire l'evento di click sul bottone "Riordina"
    @FXML
    void func_startRiordina(MouseEvent event) throws Exception {
        data.setStringaMedaglia(22); // Imposta un valore specifico nel DataSingleton
        // Cambia lo stage alla schermata di gioco "Riordinamento"
        fuc_changeStage(btn_startRiordinamento, "/bmt/codelympics_/fxml/regoleGioco/RegoleGioco.fxml");
    }

    // Metodo per gestire l'evento di click sul bottone "VF"
    @FXML
    void func_startVF(MouseEvent event) throws Exception {
        data.setStringaMedaglia(10); // Imposta un valore specifico nel DataSingleton
        // Cambia lo stage alla schermata di gioco "VF"
        fuc_changeStage(btn_startVF, "/bmt/codelympics_/fxml/regoleGioco/RegoleGioco.fxml");
    }

    // Metodo di inizializzazione chiamato automaticamente quando la schermata viene caricata
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Ottiene l'array utente dal DataSingleton
        String[] arrayUtente = data.getArrayUtente();

        // Imposta il colore delle barre di progresso
        prgbar_VF.setStyle("-fx-accent:gold");
        prgbar_errore.setStyle("-fx-accent:gold");
        prgbar_multiple.setStyle("-fx-accent:gold");
        prgbar_riordinamento.setStyle("-fx-accent:gold");

        // Variabili per tracciare il progresso nei diversi giochi
        Double pVF = 0.0;
        Double pRM = 0.0;
        Double pE = 0.0;
        Double pO = 0.0;

        // Logica per aggiornare la barra di progresso per il gioco "Risposte Multiple"
        if (Integer.parseInt(arrayUtente[4]) >= 3) {
            pRM += 0.33;
            prgbar_multiple.setProgress(pRM);
        }
        if (Integer.parseInt(arrayUtente[5]) >= 3) {
            pRM += 0.33;
            prgbar_multiple.setProgress(pRM);
        }
        if (Integer.parseInt(arrayUtente[6]) >= 3) {
            pRM += 0.33;
            prgbar_multiple.setProgress(pRM);
        }

        // Logica per aggiornare la barra di progresso per il gioco "Vero o Falso"
        if (Integer.parseInt(arrayUtente[10]) >= 3) {
            pVF += 0.33;
            prgbar_VF.setProgress(pVF);
        }
        if (Integer.parseInt(arrayUtente[11]) >= 3) {
            pVF += 0.33;
            prgbar_VF.setProgress(pVF);
        }
        if (Integer.parseInt(arrayUtente[12]) >= 3) {
            pVF += 0.33;
            prgbar_VF.setProgress(pVF);
        }

        // Logica per aggiornare la barra di progresso per il gioco "Trova l'Errore"
        if (Integer.parseInt(arrayUtente[16]) >= 3) {
            pE += 0.33;
            prgbar_errore.setProgress(pE);
        }
        if (Integer.parseInt(arrayUtente[17]) >= 3) {
            pE += 0.33;
            prgbar_errore.setProgress(pE);
        }
        if (Integer.parseInt(arrayUtente[18]) >= 3) {
            pE += 0.33;
            prgbar_errore.setProgress(pE);
        }

        // Logica per aggiornare la barra di progresso per il gioco "Riordinamento"
        if (Integer.parseInt(arrayUtente[22]) >= 3) {
            pO += 0.33;
            prgbar_riordinamento.setProgress(pO);
        }
        if (Integer.parseInt(arrayUtente[23]) >= 3) {
            pO += 0.33;
            prgbar_riordinamento.setProgress(pO);
        }
        if (Integer.parseInt(arrayUtente[24]) >= 3) {
            pO += 0.33;
            prgbar_riordinamento.setProgress(pO);
        }
    }
}
