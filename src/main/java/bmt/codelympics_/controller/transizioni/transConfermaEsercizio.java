package bmt.codelympics_.controller.transizioni;
import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
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


    DataSingleton data = DataSingleton.getInstance();

    @FXML
    void func_Avanti(MouseEvent event)throws Exception {

        if(data.getnumMacroEsercizio()<20) {
            // -----------------cambio stage esercizio Multipla--------------------
            fuc_changeStage(btn_Avanti, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
        }else if(data.getnumMacroEsercizio()<30){
            // -----------------cambio stage esercizio VF--------------------
            fuc_changeStage(btn_Avanti, "/bmt/codelympics_/fxml/esercizi/EsVF.fxml");
        }else if(data.getnumMacroEsercizio()<40){
            // -----------------cambio stage esercizioTrovaErrore--------------------
            fuc_changeStage(btn_Avanti, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
        }else {
            // -----------------cambio stage esercizio Ordine--------------------
            fuc_changeStage(btn_Avanti, "/bmt/codelympics_/fxml/esercizi/EsOrdinamento.fxml");
        }
    }

}
