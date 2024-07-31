package bmt.codelympics_.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Home {

    @FXML
    private Button btn_accedi;

    @FXML
    private Button btn_iscriviti;

    @FXML
    void func_accedi(MouseEvent event) throws Exception {
        Stage stage1 = (Stage) btn_accedi.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/accedi.fxml"));
        Parent root = loader.load();
        stage1.setScene(new Scene(root));
    }

    @FXML
    void func_iscriviti(MouseEvent event) throws Exception {
        Stage stage1 = (Stage) btn_iscriviti.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/iscriviti.fxml"));
        Parent root = loader.load();
        stage1.setScene(new Scene(root));
    }

}
