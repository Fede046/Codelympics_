package bmt.codelympics_.controller.transizioni;
import bmt.codelympics_.model.ChangeStage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class transConfermaEsercizio extends ChangeStage{

    @FXML
    private Button btn_Avanti;

    @FXML
    private ImageView img_gif;

    @FXML
    private Label lbl_risultato;

    @FXML
    void func_Avanti(MouseEvent event)throws Exception {
         // -----------------cambio stage esercizioTrovaErrore--------------------
         fuc_changeStage(btn_Avanti, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
    }

}
