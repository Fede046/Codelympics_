package bmt.codelympics_.controller.regole;

import bmt.codelympics_.model.ChangeStage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class RegoleErrore extends ChangeStage {

    @FXML
    private Button btn_difficileErrore;

    @FXML
    private Button btn_GoHome;

    @FXML
    private Button btn_princErrore;

    @FXML
    private Button btn_intErrore;

    @FXML
    private Label lb_title;


    @FXML
    void func_Home(MouseEvent event) throws Exception {
    // -----------------cambio stage gamesHome--------------------
    fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
        
    }
    @FXML
    void func_DifficileErrore(MouseEvent event) throws Exception{
        // -----------------cambio stage esTrovaErrore--------------------
        fuc_changeStage(btn_difficileErrore, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
    }

    @FXML
    void func_IntErrore(MouseEvent event)throws Exception {
         // -----------------cambio stage esTrovaErrore--------------------
        fuc_changeStage(btn_intErrore, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
    }

    @FXML
    void func_PrincErrore(MouseEvent event)throws Exception {
         // -----------------cambio stage esTrovaErrore--------------------
        fuc_changeStage(btn_princErrore, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
    }

}
