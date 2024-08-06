package bmt.codelympics_.controller.transizioni;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class transFineGame extends ChangeStage{

    @FXML
    private Button btn_GoHome;

    @FXML
    private Label lb_punti1;

    @FXML
    private Label lb_punti2;

    DataSingleton data = DataSingleton.getInstance();

    //c'è da aggiungere quante risposte giuste e il punteggio in base a esso e al tempo

    @FXML
    void func_Home(MouseEvent event) throws Exception{
        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

}
