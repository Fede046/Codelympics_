package bmt.codelympics_.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PageAccedi {

    @FXML
    private Button btn_accediGo;

    @FXML
    private Button btn_annullaAcc;

    @FXML
    void func_Home(MouseEvent event) throws Exception {
        Stage stage1 = (Stage) btn_annullaAcc.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/home.fxml"));
        Parent root = loader.load();
        stage1.setScene(new Scene(root));
    }

    @FXML
    void func_goPlayHome(MouseEvent event) {

    }

}
