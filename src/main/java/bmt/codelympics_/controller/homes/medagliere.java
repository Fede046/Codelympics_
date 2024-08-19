package bmt.codelympics_.controller.homes;

import java.net.URL;
import java.util.ResourceBundle;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class medagliere extends ChangeStage implements Initializable {

    @FXML
    private Button btn_GoHome;

    @FXML
    private AnchorPane p_1;

    @FXML
    private TableView<String> tb_User;

    @FXML
    private TableView<String> tb_allUsers;

    @FXML
    private TableColumn<DataSingleton, String> tbc_Data;

    @FXML
    private TableColumn<?, ?> tbc_DataAll;

    @FXML
    private TableColumn<?, ?> tbc_EsAll;

    @FXML
    private TableColumn<?, ?> tbc_User;

    @FXML
    private TableColumn<?, ?> tbc_arg;

    @FXML
    private TableColumn<?, ?> tbc_argAll;

    @FXML
    private TableColumn<?, ?> tbc_bro;

    @FXML
    private TableColumn<?, ?> tbc_broAll;

    @FXML
    private TableColumn<?, ?> tbc_oro;

    @FXML
    private TableColumn<?, ?> tbc_oroAll;

    @FXML
    private TableColumn<?, ?> tbc_pt;

    @FXML
    private TableColumn<?, ?> tbc_ptAll;

    @FXML
    private TableColumn<?, ?> tbc_time;

    @FXML
    private TableColumn<?, ?> tbc_timeAll;

    DataSingleton data = DataSingleton.getInstance();

    @FXML
    void btn_GoHome(MouseEvent event) throws Exception {
        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] arrayUtente = data.getArrayUtente();

        // String[] newArray= new
        // String[]{arrayUtente[0],arrayUtente[4],arrayUtente[2],arrayUtente[0],arrayUtente[4],arrayUtente[2]};
        // tb_User.setItems(newArray);
    }

}
