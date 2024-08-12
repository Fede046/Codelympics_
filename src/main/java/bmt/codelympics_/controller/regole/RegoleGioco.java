package bmt.codelympics_.controller.regole;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

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

        switch (data.getStringaMedaglia()) {
            case 4:
                if (arrayUtente[4].equals("0"))
                    btn_int.setDisable(true);
                else
                    btn_int.setDisable(false);
                if (arrayUtente[5].equals("0"))
                    btn_difficile.setDisable(true);
                else
                    btn_difficile.setDisable(false);
                bp_img.setId("bodyRegolePesi");
                lb_nameGame.setText("Risposta Multipla");
                lb_txtRegole.setText(
                        "Ti verrà posta una domanda e dovrai scegliere la risposta corretta tra le opzioni disponibili.\n"
                                +
                                " Solo una è quella giusta!\n" +
                                " Conferma la tua scelta e scopri subito se hai indovinato.\n" +
                                " Attenzione, non c'è possibilità di tornare indietro.\n " +
                                "Preparati a dimostrare quanto sei bravo!");
                break;
            case 10:
                if (arrayUtente[10].equals("0"))
                    btn_int.setDisable(true);
                else
                    btn_int.setDisable(false);
                if (arrayUtente[11].equals("0"))
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
                if (arrayUtente[16].equals("0"))
                    btn_int.setDisable(true);
                else
                    btn_int.setDisable(false);
                if (arrayUtente[17].equals("0"))
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
                if (arrayUtente[22].equals("0"))
                    btn_int.setDisable(true);
                else
                    btn_int.setDisable(false);
                if (arrayUtente[23].equals("0"))
                    btn_difficile.setDisable(true);
                else
                    btn_difficile.setDisable(false);
                bp_img.setId("bodyRegoleArco");
                lb_nameGame.setText("Riordinamento");
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
