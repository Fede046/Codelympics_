package bmt.codelympics_.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class RegoleRio extends ChangeStage{

    @FXML
    private Button btn_DifficileRio;

    @FXML
    private Button btn_GoHome;

    @FXML
    private Button btn_princRio;

    @FXML
    private Label lb_title;

    @FXML
    void func_DifficileRio(MouseEvent event) {
        
    }

    @FXML
    void func_Home(MouseEvent event) throws Exception{
        fuc_changeStage(btn_GoHome,"/bmt/codelympics_/fxml/playGames.fxml");
    }

    @FXML
    void func_IntRio(MouseEvent event) {

    }

    @FXML
    void func_PrincRio(MouseEvent event) {

    }

}
