package bmt.codelympics_.controller.regole;

import bmt.codelympics_.model.ChangeStage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class RegoleVF extends ChangeStage {

    @FXML
    private Button btn_difficileVF;

    @FXML
    private Button btn_GoHome;

    @FXML
    private Button btn_intVF;

    @FXML
    private Button btn_princVF;

    @FXML
    private Label lb_title;


    @FXML
    void func_Home(MouseEvent event) throws Exception{
         // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }


    @FXML
    void func_DifficileVF(MouseEvent event) throws Exception{
        // -----------------cambio stage esRispMult--------------------
        fuc_changeStage(btn_difficileVF, "/bmt/codelympics_/fxml/esercizi/EsVF.fxml");
    }

    @FXML
    void func_IntVF(MouseEvent event) throws Exception{
        // -----------------cambio stage esRispMult--------------------
        fuc_changeStage(btn_intVF, "/bmt/codelympics_/fxml/esercizi/EsVF.fxml");
    }

    @FXML
    void func_PrincVF(MouseEvent event) throws Exception{
        // -----------------cambio stage esRispMult--------------------
        fuc_changeStage(btn_princVF, "/bmt/codelympics_/fxml/esercizi/EsVF.fxml");
    }

}
