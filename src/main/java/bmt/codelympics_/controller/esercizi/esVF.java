package bmt.codelympics_.controller.esercizi;

import bmt.codelympics_.model.ChangeStage;
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
    private Label lb_domanda;

    @FXML
    private Label lb_title;

    @FXML
    private RadioButton rb_falso;

    @FXML
    private RadioButton rb_vero;

    
    @FXML
    void func_ConfermaExit(MouseEvent event) throws Exception{
    // -----------------cambio stage AbbandonaGame--------------------
    fuc_changeStage(btn_Conferma, "/bmt/codelympics_/fxml/transizioni/AbbandonaGame.fxml");
    }

    @FXML
    void func_Conferma(MouseEvent event)throws Exception {
    // -----------------cambio stage ConfermaEs--------------------
    fuc_changeStage(btn_Conferma, "/bmt/codelympics_/fxml/transizioni/ConfermaEs.fxml");
    }

   

}
