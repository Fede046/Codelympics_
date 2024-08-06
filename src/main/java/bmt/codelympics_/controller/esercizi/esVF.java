package bmt.codelympics_.controller.esercizi;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class esVF extends ChangeStage{

    @FXML
    private ToggleGroup VF;

    @FXML
    private Button btn_Conferma;

    @FXML
    private Button btn_ConfermaExit;

    @FXML
    private Button lb_domanda;

    @FXML
    private RadioButton rb_falso;

    @FXML
    private RadioButton rb_vero;

    DataSingleton data = DataSingleton.getInstance();

    @FXML
    void func_ConfermaExit(MouseEvent event) throws Exception{
    // -----------------cambio stage AbbandonaGame--------------------
    fuc_changeStage(btn_ConfermaExit, "/bmt/codelympics_/fxml/transizioni/AbbandonaGame.fxml");
    }

    void Risposta(){
        data.setNumEsercizio(data.getNumEsercizio()+1);
        int temp = 0;

        if(rb_vero.isSelected())  temp=1;
        if(rb_falso.isSelected())  temp=2;

        int[] risp = new int[]{temp};
        data.addarrayDirisposte(data.risposta(data.getnumMacroEsercizio(), data.getNumEsercizio(),risp));
    }
    @FXML
    void func_Conferma(MouseEvent event)throws Exception {
        //Risposta();
    // -----------------cambio stage ConfermaEs--------------------
    fuc_changeStage(btn_Conferma, "/bmt/codelympics_/fxml/transizioni/ConfermaEs.fxml");
    }

   

}
