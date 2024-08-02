package  bmt.codelympics_.controller.transizioni;

import bmt.codelympics_.model.ChangeStage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class transAbbandonaGame extends ChangeStage{

    @FXML
    private Button btn_AnnullaConferma;

    @FXML
    private Button btn_Conferma;

    @FXML
    void func_AnnullaConferma(MouseEvent event) throws Exception{
        // -----------------cambio stage esercizioTrovaErrore--------------------
        fuc_changeStage(btn_AnnullaConferma, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
    }

    @FXML
    void func_Conferma(MouseEvent event) throws Exception{
        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_Conferma, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

}
