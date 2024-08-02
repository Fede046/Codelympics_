package bmt.codelympics_.controller.homes;

import bmt.codelympics_.model.ChangeStage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Home extends ChangeStage {
     
    @FXML
    private Button btn_accedi;

    @FXML
    private Button btn_iscriviti;

    @FXML
    void func_accedi(MouseEvent event) throws Exception {
         // -----------------cambio stage accedi--------------------
         fuc_changeStage(btn_accedi, "/bmt/codelympics_/fxml/accedi.fxml");
        
    }

    @FXML
    void func_iscriviti(MouseEvent event) throws Exception {
         // -----------------cambio stage iscriviti--------------------
         fuc_changeStage(btn_iscriviti, "/bmt/codelympics_/fxml/iscriviti.fxml");
        
    }

}
