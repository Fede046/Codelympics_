package bmt.codelympics_.controller.homes;

import java.net.URL;
import java.util.ResourceBundle;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import bmt.codelympics_.model.User;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class medagliere extends ChangeStage implements Initializable {

    @FXML
    private Button btn_GoHome;

    @FXML
    private AnchorPane p_1;

    @FXML
    private TableView<DataSingleton> tb_User;

    @FXML
    private TableView<User> tb_allUsers;

    @FXML
    private TableColumn<String, String> tbc_Data;

    @FXML
    private TableColumn<User, String> tbc_DataAll;

    @FXML
    private TableColumn<User, String> tbc_EsAll;

    @FXML
    private TableColumn<String, String> tbc_User;
    @FXML
    private TableColumn<User, String> tbc_UserAll;

    @FXML
    private TableColumn<String, String> tbc_arg;

    @FXML
    private TableColumn<User, String> tbc_argAll;

    @FXML
    private TableColumn<String, String> tbc_bro;

    @FXML
    private TableColumn<User, String> tbc_broAll;

    @FXML
    private TableColumn<String, String> tbc_oro;

    @FXML
    private TableColumn<User, String> tbc_oroAll;

    @FXML
    private TableColumn<String, String> tbc_pt;

    @FXML
    private TableColumn<User, String> tbc_ptAll;

    @FXML
    private TableColumn<String, String> tbc_time;

    @FXML
    private TableColumn<User, String> tbc_timeAll;

    DataSingleton data = DataSingleton.getInstance();

    @FXML
    void btn_GoHome(MouseEvent event) throws Exception {
        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

    String[] arrayUtente = data.getArrayUtente();

    ObservableList<String> list2 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<User> list2 = FXCollections.observableArrayList(
                new User(arrayUtente[0], arrayUtente[1], arrayUtente[2],
                        arrayUtente[3], arrayUtente[4], arrayUtente[5],
                        arrayUtente[6], arrayUtente[7]));

        // Configurazione delle colonne
        tbc_UserAll.setCellValueFactory(new PropertyValueFactory<>("user"));
        tbc_ptAll.setCellValueFactory(new PropertyValueFactory<>("pt"));
        tbc_argAll.setCellValueFactory(new PropertyValueFactory<>("arg"));
        tbc_broAll.setCellValueFactory(new PropertyValueFactory<>("bro"));
        tbc_oroAll.setCellValueFactory(new PropertyValueFactory<>("oro"));
        tbc_timeAll.setCellValueFactory(new PropertyValueFactory<>("time"));
        tbc_DataAll.setCellValueFactory(new PropertyValueFactory<>("data"));
        tbc_EsAll.setCellValueFactory(new PropertyValueFactory<>("es"));

        // Imposta gli elementi nella TableView
        tb_allUsers.setItems(list2);
    }

}
