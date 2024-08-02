package bmt.codelympics_.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChangeStage {
    public void fuc_changeStage(Button bottone,String resource)throws Exception{
    Stage stage1 = (Stage) bottone.getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
    Parent root = loader.load();
    stage1.setScene(new Scene(root));
    }

}
