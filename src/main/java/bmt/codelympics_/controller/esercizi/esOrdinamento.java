package bmt.codelympics_.controller.esercizi;

import bmt.codelympics_.model.ChangeStage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class esOrdinamento extends ChangeStage implements Initializable {

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
    private Spinner<Integer> sp_1;

    @FXML
    private Spinner<Integer> sp_2;

    @FXML
    private Spinner<Integer> sp_3;

    @FXML
    private Spinner<Integer> sp_4;

    @FXML
    private Spinner<Integer> sp_5;

    @FXML
    private Spinner<Integer> sp_6;





    @FXML
    void func_ConfermaExit(MouseEvent event) throws Exception{
// -----------------cambio stage AbbandonaGame--------------------
fuc_changeStage(btn_ConfermaExit, "/bmt/codelympics_/fxml/transizioni/AbbandonaGame.fxml");
    }

    @FXML
    void func_Conferma(MouseEvent event) throws Exception{
// -----------------cambio stage ConfermaEs--------------------
fuc_changeStage(btn_Conferma, "/bmt/codelympics_/fxml/transizioni/ConfermaEs.fxml");
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Spinner[] spinners = new Spinner[]{sp_1,sp_2,sp_3,sp_4,sp_5,sp_6};
        //caso 6 scelte
        for(Spinner e:spinners) e.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,6,1));

    }



}
