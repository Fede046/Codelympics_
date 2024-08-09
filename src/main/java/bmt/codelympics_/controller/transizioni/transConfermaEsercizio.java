
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
import javafx.scene.paint.Color;

public class transConfermaEsercizio extends ChangeStage implements Initializable {

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

        // -----------------cambio stage esercizio Multipla--------------------
        // fuc_changeStage(btn_Avanti,
        // "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(data.getArrayRisposte()[data.getNumEsercizio() - 1]);
        if (data.getArrayRisposte()[data.getNumEsercizio() - 1]) {
            lbl_risultato.setText("CORRETTO!");
            lbl_risultato.setTextFill(Color.GREEN);
        } else {
            lbl_risultato.setText("SBAGLIATO!");
            lbl_risultato.setTextFill(Color.RED);

        }
        switch (data.getStringaMedaglia()) {
            case 4, 5, 6:
                img_gif.setId("img_gif2");
                break;
            case 10, 11, 12:
                img_gif.setId("img_gif3");
                break;
            case 16, 17, 18:
                img_gif.setId("img_gif");
                break;
            case 22, 23, 24:
                img_gif.setId("img_gif4");
                break;
        }
    }
}
