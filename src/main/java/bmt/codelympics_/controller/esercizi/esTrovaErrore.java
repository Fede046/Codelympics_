package bmt.codelympics_.controller.esercizi;

import bmt.codelympics_.model.ChangeStage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class esTrovaErrore extends ChangeStage{

    @FXML
    private Button btn_Conferma;

    @FXML
    private Button btn_ConfermaExit;

    @FXML
    private ImageView img_r1;

    @FXML
    private ImageView img_r2;

    @FXML
    private ImageView img_r3;

    @FXML
    private ImageView img_r4;

    @FXML
    private Label lb_title;

    @FXML
    private RadioButton rb_r1;

    @FXML
    private RadioButton rb_r2;

    @FXML
    private RadioButton rb_r3;

    @FXML
    private RadioButton rb_r4;

    @FXML
    private Rectangle rec_r1;

    @FXML
    private Rectangle rec_r2;

    @FXML
    private Rectangle rec_r3;

    @FXML
    private Rectangle rec_r4;

    @FXML
    private ToggleGroup risposte;
    
    @FXML
    void func_ConfermaExit(MouseEvent event)throws Exception {
// -----------------cambio stage AbbandonaGame--------------------
fuc_changeStage(btn_ConfermaExit, "/bmt/codelympics_/fxml/transizioni/AbbandonaGame.fxml");
    }

    @FXML
    void func_Conferma(MouseEvent event) throws Exception{
    // -----------------cambio stage ConfermaEs--------------------
    fuc_changeStage(btn_Conferma, "/bmt/codelympics_/fxml/transizioni/ConfermaEs.fxml");
    }

   

}
