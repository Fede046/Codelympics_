package bmt.codelympics_.controller.regole;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class RegoleGioco extends ChangeStage{

    @FXML
    private Button btn_GoHome;

    @FXML
    private Button btn_difficile;

    @FXML
    private Button btn_int;

    @FXML
    private Button btn_princ;

    @FXML
    private Button btn_txtNome;

    @FXML
    private Button btn_txtRegole;

     DataSingleton data = DataSingleton.getInstance();

    @FXML
    void func_DifficileErrore(MouseEvent event) throws Exception{
        data.setNumMacroEsercizio(13);
        // -----------------cambio stage esRispMult--------------------
        fuc_changeStage(btn_difficile, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
    }

    @FXML
    void func_Home(MouseEvent event)throws Exception {
  // -----------------cambio stage gamesHome--------------------
  fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

    @FXML
    void func_IntErrore(MouseEvent event)throws Exception {
        data.setNumMacroEsercizio(12);
        // -----------------cambio stage esRispMult--------------------
        fuc_changeStage(btn_int, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
    }

    @FXML
    void func_PrincErrore(MouseEvent event) throws Exception{
        data.setNumMacroEsercizio(11);
        // -----------------cambio stage esRispMult--------------------
        fuc_changeStage(btn_princ, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
    }

}
