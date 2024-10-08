package bmt.codelympics_.controller.regole;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class RegoleGioco extends ChangeStage implements Initializable {

    @FXML
    private BorderPane bp_img;

    @FXML
    private Button btn_GoHome;

    @FXML
    private Button btn_difficile;

    @FXML
    private Button btn_int;
    @FXML
    private Label lb_nameGame;

    @FXML
    private Button btn_princ;

    @FXML
    private Label lb_txtRegole;

    DataSingleton data = DataSingleton.getInstance();

    @FXML
    void func_Difficile(MouseEvent event) throws Exception {
        // risp mult
        switch (data.getStringaMedaglia()) {
            case 4:
                data.setStringaMedaglia(4 + 2);
                // -----------------cambio stage esRispMult diff--------------------
                fuc_changeStage(btn_difficile, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
                break;
            case 10:
                data.setStringaMedaglia(10 + 2);
                // -----------------cambio stage esVF diff--------------------
                fuc_changeStage(btn_difficile, "/bmt/codelympics_/fxml/esercizi/EsVF.fxml");
                break;
            case 16:
                data.setStringaMedaglia(16 + 2);
                // -----------------cambio stage esErr diff--------------------
                fuc_changeStage(btn_difficile, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
                break;
            case 22:
                data.setStringaMedaglia(22 + 2);
                // -----------------cambio stage esOrd diff--------------------
                fuc_changeStage(btn_difficile, "/bmt/codelympics_/fxml/esercizi/EsOrdinamento.fxml");
                break;
        }

    }

    @FXML
    void func_Home(MouseEvent event) throws Exception {
        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

    @FXML
    void func_Int(MouseEvent event) throws Exception {
        switch (data.getStringaMedaglia()) {
            case 4:
                data.setStringaMedaglia(4 + 1);
                // -----------------cambio stage esRispMult int--------------------
                fuc_changeStage(btn_int, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
                break;
            case 10:
                data.setStringaMedaglia(10 + 1);
                // -----------------cambio stage esVF int--------------------
                fuc_changeStage(btn_int, "/bmt/codelympics_/fxml/esercizi/EsVF.fxml");
                break;
            case 16:
                data.setStringaMedaglia(16 + 1);
                // -----------------cambio stage esErr int--------------------
                fuc_changeStage(btn_int, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
                break;
            case 22:
                data.setStringaMedaglia(22 + 1);
                // -----------------cambio stage esOrd int--------------------
                fuc_changeStage(btn_int, "/bmt/codelympics_/fxml/esercizi/EsOrdinamento.fxml");
                break;
        }
    }

    @FXML
    void func_Princ(MouseEvent event) throws Exception {
        switch (data.getStringaMedaglia()) {
            case 4:

                // -----------------cambio stage esRispMult princ--------------------
                fuc_changeStage(btn_princ, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
                break;
            case 10:

                // -----------------cambio stage esVF princ--------------------
                fuc_changeStage(btn_princ, "/bmt/codelympics_/fxml/esercizi/EsVF.fxml");
                break;
            case 16:

                // -----------------cambio stage esErr princ--------------------
                fuc_changeStage(btn_princ, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
                break;
            case 22:

                // -----------------cambio stage esOrd princ--------------------
                fuc_changeStage(btn_princ, "/bmt/codelympics_/fxml/esercizi/EsOrdinamento.fxml");
                break;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] arrayUtente = data.getArrayUtente();
        lb_txtRegole.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.BOLD, 14)); // Usare il Font di JavaFX per il grassetto
        switch (data.getStringaMedaglia()) {
            case 4:
                if (Integer.parseInt(arrayUtente[4]) < 3)
                    btn_int.setDisable(true);
                else
                    btn_int.setDisable(false);
                if (Integer.parseInt(arrayUtente[5]) < 3)
                    btn_difficile.setDisable(true);
                else
                    btn_difficile.setDisable(false);
                bp_img.setId("bodyRegolePesi");
                lb_nameGame.setText("Risposta Multipla");
                lb_txtRegole.setText(
                        "Ti verrà posta una domanda \n" +
                                "dovrai scegliere la risposta corretta tra le opzioni disponibili.\n"
                                +
                                " Solo una è quella giusta!\n" +
                                " Conferma la tua scelta e scopri subito se hai indovinato.\n" +
                                " Attenzione, non c'è possibilità di tornare indietro.\n " +
                                "Preparati a dimostrare quanto sei bravo!");
                break;
            case 10:
                if (Integer.parseInt(arrayUtente[10]) < 3)
                    btn_int.setDisable(true);
                else
                    btn_int.setDisable(false);
                if (Integer.parseInt(arrayUtente[11]) < 3)
                    btn_difficile.setDisable(true);
                else
                    btn_difficile.setDisable(false);
                bp_img.setId("bodyRegoleBoxe");
                lb_nameGame.setText("Vero o Falso");
                lb_txtRegole.setText("Il gioco ti presenterà una serie di affermazioni.\n" +
                        " Dovrai decidere se ciascuna è vera o falsa.\n" +
                        "Conferma la tua scelta e scopri se hai risposto correttamente.\n" +
                        " Ricorda, una volta fatta la tua scelta,non potrai cambiare idea.\n " +
                        "Pronto a mettere alla prova la tua conoscenza?");
                break;
            case 16:
                if (Integer.parseInt(arrayUtente[16]) < 3)
                    btn_int.setDisable(true);
                else
                    btn_int.setDisable(false);
                if (Integer.parseInt(arrayUtente[17]) < 3)
                    btn_difficile.setDisable(true);
                else
                    btn_difficile.setDisable(false);
                bp_img.setId("bodyRegoleScherma");
                lb_nameGame.setText("Trova l'Errore");
                lb_txtRegole.setText("Il gioco ti mostrerà 4 codici, ma solo uno di essi \n" +
                        "è sbagliato, trovalo!\n" +
                        "Conferma la tua scelta e scopri se hai risposto corretto. \n" +
                        "Attenzione, non si torna indietro. \n" +
                        "Che la sfida abbia inizio!");
                break;
            case 22:
                if (Integer.parseInt(arrayUtente[22]) < 3)
                    btn_int.setDisable(true);
                else
                    btn_int.setDisable(false);
                if (Integer.parseInt(arrayUtente[23]) < 3)
                    btn_difficile.setDisable(true);
                else
                    btn_difficile.setDisable(false);
                bp_img.setId("bodyRegoleArco");
                lb_nameGame.setText("Ordinamento");
                lb_txtRegole.setText("Il gioco ti mostrerà una serie di linee di codice disordinate.\n " +
                        "Il tuo compito è rimetterle nell'ordine corretto.\n " +
                        "Quando pensi di aver trovato la sequenza giusta, conferma la tua scelta.\n " +
                        "Scopri subito se hai ricomposto il codice correttamente.\n " +
                        "Non si può tornare indietro, quindi pensa bene prima di confermare. \n" +
                        "Inizia la sfida!");
                break;

        }
    }
}
