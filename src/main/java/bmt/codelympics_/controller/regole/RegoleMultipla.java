/*package bmt.codelympics_.controller.regole;
import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class RegoleMultipla extends ChangeStage {

    @FXML
    private Button btn_intMult;

    @FXML
    private Button btn_difficileMult;

    @FXML
    private Button btn_GoHome;

    @FXML
    private Button btn_princMult;

    @FXML
    private Label lb_title;

    DataSingleton data = DataSingleton.getInstance();

    @FXML
    void func_Home(MouseEvent event)throws Exception {
         // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }


    @FXML
    void func_DifficileMult(MouseEvent event) throws Exception{
       // data.setNumMacroEsercizio(13);
        // -----------------cambio stage esRispMult--------------------
        fuc_changeStage(btn_difficileMult, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
    }

    @FXML
    void func_IntMult(MouseEvent event) throws Exception {
      //  data.setNumMacroEsercizio(12);
        // -----------------cambio stage esRispMult--------------------
        fuc_changeStage(btn_intMult, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
    }

    @FXML
    void func_PrincMult(MouseEvent event) throws Exception{
       // data.setNumMacroEsercizio(11);
        // -----------------cambio stage esRispMult--------------------
        fuc_changeStage(btn_princMult, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
    }

}
*/