package bmt.codelympics_.controller.regole;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
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

    DataSingleton data = DataSingleton.getInstance();
    @FXML
    void func_Home(MouseEvent event) throws Exception {

        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
        
    }
    @FXML
    void func_DifficileErrore(MouseEvent event) throws Exception{
        //data.setNumMacroEsercizio(33);
        // -----------------cambio stage esTrovaErrore diff--------------------
        fuc_changeStage(btn_difficileErrore, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
    }

    @FXML
    void func_IntErrore(MouseEvent event)throws Exception {
       // data.setNumMacroEsercizio(32);
         // -----------------cambio stage esTrovaErrore intermedio--------------------
        fuc_changeStage(btn_intErrore, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
    }

    @FXML
    void func_PrincErrore(MouseEvent event)throws Exception {
      //  data.setNumMacroEsercizio(31);
         // -----------------cambio stage esTrovaErrore facile--------------------
        fuc_changeStage(btn_princErrore, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
    }

}
