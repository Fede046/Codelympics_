package bmt.codelympics_.controller.transizioni;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import bmt.codelympics_.model.Time;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

// Classe che gestisce le transizioni di stato quando un gioco viene abbandonato
public class transAbbandonaGame extends ChangeStage {

    // Riferimento al bottone "Annulla Conferma" nel file FXML
    @FXML
    private Button btn_AnnullaConferma;

    // Riferimento al bottone "Conferma" nel file FXML
    @FXML
    private Button btn_Conferma;

    // Singleton per la gestione dei dati globali dell'applicazione
    DataSingleton data = DataSingleton.getInstance();

    // Singleton per la gestione del tempo
    Time time = Time.getInstance();

    // Metodo che viene chiamato quando l'utente clicca sul bottone "Annulla Conferma"
    @FXML
    void func_AnnullaConferma(MouseEvent event) throws Exception {
        // Verifica il valore di `getStringaMedaglia` e cambia lo stage di conseguenza

        if (data.getStringaMedaglia() < 7) {
            // Cambio stage a esercizio con risposta multipla
            fuc_changeStage(btn_AnnullaConferma, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
        } else if (data.getStringaMedaglia() < 13) {
            // Cambio stage a esercizio vero/falso
            fuc_changeStage(btn_AnnullaConferma, "/bmt/codelympics_/fxml/esercizi/EsVF.fxml");
        } else if (data.getStringaMedaglia() < 19) {
            // Cambio stage a esercizio trova errore
            fuc_changeStage(btn_AnnullaConferma, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
        } else {
            // Cambio stage a esercizio di ordinamento
            fuc_changeStage(btn_AnnullaConferma, "/bmt/codelympics_/fxml/esercizi/EsOrdinamento.fxml");
        }
    }

    // Metodo che viene chiamato quando l'utente clicca sul bottone "Conferma"
    @FXML
    void func_Conferma(MouseEvent event) throws Exception {
        // Resetta il tempo a "0:0:0"
        time.setTime("0:0:0");

        // Resetta i dati relativi all'esercizio nel singleton DataSingleton
        data.setNumEsercizio(0);
        data.setValue(0);

        // Cambio stage alla home dei giochi
        fuc_changeStage(btn_Conferma, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

}
