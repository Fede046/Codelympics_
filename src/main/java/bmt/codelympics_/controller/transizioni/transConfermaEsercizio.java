
package bmt.codelympics_.controller.transizioni;

import java.net.URL;

import java.util.ResourceBundle;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

public class transConfermaEsercizio extends ChangeStage implements Initializable {

    MediaPlayer mediaPlayer;
    @FXML
    private Button btn_Avanti;

    @FXML
    private AnchorPane img_gif;

    @FXML
    private Label lbl_risultato;

    DataSingleton data = DataSingleton.getInstance();

    @FXML
    void func_Avanti(MouseEvent event) throws Exception {

        System.out.println(data.getNumEsercizio());
        for (boolean e : data.getArrayRisposte())
            System.out.print(e + " ");
        if (data.getNumEsercizio() > 4)
            TerminaMacroEsercizio();
        else
            ContinuaEsercizio();

    }

    void ContinuaEsercizio() throws Exception {

        if (data.getStringaMedaglia() < 7) {
            // -----------------cambio stage esercizio Multipla--------------------
            fuc_changeStage(btn_Avanti, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
        } else if (data.getStringaMedaglia() < 13) {
            // -----------------cambio stage esercizio VF--------------------
            fuc_changeStage(btn_Avanti, "/bmt/codelympics_/fxml/esercizi/EsVF.fxml");
        } else if (data.getStringaMedaglia() < 19) {
            // -----------------cambio stage esercizioTrovaErrore--------------------
            fuc_changeStage(btn_Avanti, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
        } else {
            // -----------------cambio stage esercizio Ordine--------------------
            fuc_changeStage(btn_Avanti, "/bmt/codelympics_/fxml/esercizi/EsOrdinamento.fxml");
        }
    }

    void TerminaMacroEsercizio() throws Exception {

        data.setNumEsercizio(0);
        data.setValue(0);

        // -----------------cambio stage FineGame--------------------
        fuc_changeStage(btn_Avanti, "/bmt/codelympics_/fxml/transizioni/FineGame.fxml");

    }

    // impostazione del suono
    private void playHitSound(String fileName) {
        URL resource = getClass().getResource("/bmt/codelympics_/" + fileName);
        if (resource == null) {
            System.err.println("File not found: " + fileName);
            return;
        }

        String path = resource.toExternalForm();
        Media media = new Media(path);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.play();

    }

    // ------------------------------------------------
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boolean ris = true;
        System.out.println(data.getArrayRisposte()[data.getNumEsercizio() - 1]);
        if (data.getArrayRisposte()[data.getNumEsercizio() - 1]) {
            // aggiungo qua il sound
            String fileName = "sound/soundVince.mp3";
            playHitSound(fileName);
            lbl_risultato.setText("CORRETTO!");
            lbl_risultato.setTextFill(Color.GREEN);
            ris = true;
        } else {
            // aggiungo qua il sound
            String fileName = "sound/soundPerde.mp3";
            playHitSound(fileName);
            lbl_risultato.setText("SBAGLIATO!");
            lbl_risultato.setTextFill(Color.RED);
            ris = false;

        }
        // impostazioni delle gif
        switch (data.getStringaMedaglia()) {
            case 4, 5, 6:
                if (!ris)
                    img_gif.setId("img_gifError");
                else
                    img_gif.setId("img_gif2");
                break;
            case 10, 11, 12:
                if (!ris)
                    img_gif.setId("img_gifError");
                else
                    img_gif.setId("img_gif3");
                break;
            case 16, 17, 18:
                if (!ris)
                    img_gif.setId("img_gifError");
                else
                    img_gif.setId("img_gif");
                break;
            case 22, 23, 24:
                if (!ris)
                    img_gif.setId("img_gifError");
                else
                    img_gif.setId("img_gif4");
                break;
        }
    }
}
