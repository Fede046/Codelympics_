
package bmt.codelympics_.controller.esercizi;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class esRispMult extends ChangeStage {

    @FXML
    private ToggleGroup RM;

    @FXML
    private Button btn_Conferma;

    @FXML
    private Button btn_ConfermaExit;

    @FXML
    private Button btn_r1;

    @FXML
    private Button btn_r2;

    @FXML
    private Button btn_r3;

    @FXML
    private Button btn_r4;

    @FXML
    private ImageView img_RM;

    @FXML
    private Label lb_domanda;

    @FXML
    private RadioButton rb_r1;

    @FXML
    private RadioButton rb_r2;

    @FXML
    private RadioButton rb_r3;

    @FXML
    private RadioButton rb_r4;

    DataSingleton data = DataSingleton.getInstance();

    @FXML
    void func_ConfermaExit(MouseEvent event) throws Exception {
        // -----------------cambio stage AbbandonaGame--------------------
        fuc_changeStage(btn_ConfermaExit, "/bmt/codelympics_/fxml/transizioni/AbbandonaGame.fxml");
    }

    void Risposta() {
        data.setNumEsercizio(data.getNumEsercizio() + 1);
        int temp = 0;

        if (rb_r1.isSelected())
            temp = 1;
        if (rb_r2.isSelected())
            temp = 2;
        if (rb_r3.isSelected())
            temp = 3;
        if (rb_r4.isSelected())
            temp = 4;

        int[] risp = new int[] { temp };
        data.addarrayDirisposte(data.risposta(data.getNumEsercizio(), risp));
    }

    @FXML
    void func_Conferma(MouseEvent event) throws Exception {
        Risposta();

        // -----------------cambio stage ConfermaEs--------------------
        fuc_changeStage(btn_Conferma, "/bmt/codelympics_/fxml/transizioni/ConfermaEs.fxml");
    }

}
