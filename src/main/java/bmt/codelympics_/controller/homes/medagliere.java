package bmt.codelympics_.controller.homes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.opencsv.CSVReader;

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
    private TableView<User> tb_User;

    @FXML
    private TableView<User> tb_allUsers;
    @FXML
    private TableColumn<User, String> tbc_idAll;
    @FXML
    private TableColumn<User, String> tbc_AvatarAll;
    @FXML
    private TableColumn<User, String> tbc_Avatar;
    @FXML
    private TableColumn<User, String> tbc_User;

    @FXML
    private TableColumn<User, String> tbc_UserAll;

    @FXML
    private TableColumn<User, String> tbc_arg;

    @FXML
    private TableColumn<User, String> tbc_argAll;

    @FXML
    private TableColumn<User, String> tbc_bro;

    @FXML
    private TableColumn<User, String> tbc_broAll;

    @FXML
    private TableColumn<User, String> tbc_oro;

    @FXML
    private TableColumn<User, String> tbc_oroAll;

    @FXML
    private TableColumn<User, String> tbc_pt;

    @FXML
    private TableColumn<User, String> tbc_ptAll;

    DataSingleton data = DataSingleton.getInstance();

    @FXML
    void btn_GoHome(MouseEvent event) throws Exception {
        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

    String[] arrayUtente = data.getArrayUtente();

    ObservableList<User> list2 = FXCollections.observableArrayList();

    public String[] CatchUsers() throws Exception {
        String filePath = System.getProperty("user.home") + "/playproj/props.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            String[] line;

            while ((line = reader.readNext()) != null) {
                System.out.println(Arrays.toString(line));
                data.setArrayUtenti(line);
            }

            return line;
        } catch (FileNotFoundException e) {
            throw new IOException("File CSV non trovato: " + filePath);
        }

    }

    public int calcolaPunti(String[] array) {
        System.out.println(array[0]);
        int tot = 0;
        int[] n = { 7, 8, 9, 13, 14, 15, 19, 20, 21, 25, 26, 27 };
        for (int i = 0; i < n.length; i++) {
            if (n[i] < array.length) { // Assicurati che l'indice sia valido
                tot += Integer.parseInt(array[n[i]]);
            }
        }
        return tot;
    }

    /*********************************************************************************************/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            CatchUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] utenti = data.getArrayUtenti();
        String[] arrayUtente = data.getArrayUtente();

        ObservableList<User> list = FXCollections.observableArrayList(
                new User(arrayUtente[3], arrayUtente[0], calcolaPunti(arrayUtente), arrayUtente[4], arrayUtente[5],
                        arrayUtente[3]));
        for (int i = 0; i < utenti.length; i++) {
            String[] array2 = utenti[i].split(",");
            System.out.println(utenti);

            ObservableList<User> list2 = FXCollections.observableArrayList(
                    new User(1, arrayUtente[3], arrayUtente[0], calcolaPunti(array2),
                            arrayUtente[4], arrayUtente[5],
                            arrayUtente[3]));

        }
        // Configurazione delle colonne
        tbc_idAll.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbc_AvatarAll.setCellValueFactory(new PropertyValueFactory<>("avatar"));
        tbc_UserAll.setCellValueFactory(new PropertyValueFactory<>("user"));
        tbc_ptAll.setCellValueFactory(new PropertyValueFactory<>("pt"));
        tbc_argAll.setCellValueFactory(new PropertyValueFactory<>("arg"));
        tbc_broAll.setCellValueFactory(new PropertyValueFactory<>("bro"));
        tbc_oroAll.setCellValueFactory(new PropertyValueFactory<>("oro"));

        // -------------------
        tbc_Avatar.setCellValueFactory(new PropertyValueFactory<>("avatar"));
        tbc_User.setCellValueFactory(new PropertyValueFactory<>("user"));
        tbc_pt.setCellValueFactory(new PropertyValueFactory<>("pt"));
        tbc_arg.setCellValueFactory(new PropertyValueFactory<>("arg"));
        tbc_bro.setCellValueFactory(new PropertyValueFactory<>("bro"));
        tbc_oro.setCellValueFactory(new PropertyValueFactory<>("oro"));

        // Imposta gli elementi nella TableView
        tb_User.setItems(list);
        tb_allUsers.setItems(list2);

    }

}
