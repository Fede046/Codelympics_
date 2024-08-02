package bmt.codelympics_.controller.esercizi;

import bmt.codelympics_.model.ChangeStage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;

public class esOrdinamento extends ChangeStage{

    @FXML
    private Button btn_Conferma;

    @FXML
    private Button btn_ConfermaExit;

    @FXML
    private Label lb_r1;

    @FXML
    private Label lb_r2;

    @FXML
    private Label lb_r3;

    @FXML
    private Label lb_r4;

    @FXML
    private Label lb_r5;

    @FXML
    private Label lb_r6;

    @FXML
    private Label lb_title;

    @FXML
    private Spinner<?> sp_1;

    @FXML
    private Spinner<?> sp_2;

    @FXML
    private Spinner<?> sp_3;

    @FXML
    private Spinner<?> sp_4;

    @FXML
    private Spinner<?> sp_5;

    @FXML
    private Spinner<?> sp_6;

    @FXML
    void func_Conferma(MouseEvent event) throws Exception{
// -----------------cambio stage AbbandonaGame--------------------
fuc_changeStage(btn_ConfermaExit, "/bmt/codelympics_/fxml/transizioni/AbbandonaGame.fxml");
    }

    @FXML
    void func_ConfermaExit(MouseEvent event) throws Exception{
// -----------------cambio stage ConfermaEs--------------------
fuc_changeStage(btn_Conferma, "/bmt/codelympics_/fxml/transizioni/ConfermaEs.fxml");
    }

}
