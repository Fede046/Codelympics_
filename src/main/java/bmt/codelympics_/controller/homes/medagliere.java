package bmt.codelympics_.controller.homes;

import bmt.codelympics_.model.ChangeStage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class medagliere extends ChangeStage {

    @FXML
    private Button btn_GoHome;

    @FXML
    private Label lb_title;

    @FXML
    private TableView<?> tb_User;

    @FXML
    private TableView<?> tb_allUsers;

    @FXML
    void func_Home(MouseEvent event)throws  Exception {
        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

}
