package bmt.codelympics_.controller.regole;

import bmt.codelympics_.model.ChangeStage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class RegoleVF extends ChangeStage {

    @FXML
    private Button btn_DifficileVF;

    @FXML
    private Button btn_GoHome;

    @FXML
    private Button btn_princVF;

    @FXML
    private Label lb_title;


    @FXML
    void func_Home(MouseEvent event) throws Exception{
         // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome,"/bmt/codelympics_/fxml/playGames.fxml");
    }


    @FXML
    void func_DifficileVF(MouseEvent event) {

    }

    @FXML
    void func_IntVF(MouseEvent event) {

    }

    @FXML
    void func_PrincVF(MouseEvent event) {

    }

}
