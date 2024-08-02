package bmt.codelympics_.controller.regole;
import bmt.codelympics_.controller.utility.ChangeStage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class RegoleMultipla extends ChangeStage {

    @FXML
    private Button btn_DifficileMult;

    @FXML
    private Button btn_GoHome;

    @FXML
    private Button btn_princMult;

    @FXML
    private Label lb_title;

    @FXML
    void func_DifficileMult(MouseEvent event) {

    }

    @FXML
    void func_Home(MouseEvent event)throws Exception {
        fuc_changeStage(btn_GoHome,"/bmt/codelympics_/fxml/playGames.fxml");
    }

    @FXML
    void func_IntMult(MouseEvent event) {

    }

    @FXML
    void func_PrincMult(MouseEvent event) {

    }

}
