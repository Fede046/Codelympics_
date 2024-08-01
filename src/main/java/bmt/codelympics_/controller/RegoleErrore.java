package bmt.codelympics_.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegoleErrore {

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
        Stage stage1 = (Stage) btn_GoHome.getScene().getWindow();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/playGames.fxml"));
         Parent root = loader.load();
         stage1.setScene(new Scene(root));
    }

    @FXML
    void func_IntErrore(MouseEvent event) {

    }

    @FXML
    void func_PrincErrore(MouseEvent event) {

    }

}
