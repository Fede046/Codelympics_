package bmt.codelympics_.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegoleErrore extends ChangeStage{

    @FXML
    private Button btn_DifficileErrore1;

    @FXML
    private Button btn_GoHome;

    @FXML
    private Button btn_princErrore;

    @FXML
    private Button btn_princErrore2;

    @FXML
    private Label lb_title;

    @FXML
    void func_DifficileErrore(MouseEvent event) {

    }

    @FXML
    void func_Home(MouseEvent event) throws Exception {
    // -----------------cambio stage gamesHome--------------------
    fuc_changeStage(btn_GoHome,"/bmt/codelympics_/fxml/playGames.fxml");
        
    }

    @FXML
    void func_IntErrore(MouseEvent event) {

    }

    @FXML
    void func_PrincErrore(MouseEvent event) {

    }

}
