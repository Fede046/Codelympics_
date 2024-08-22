package bmt.codelympics_.controller.homes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private List<String[]> utenti = new ArrayList<>();

    String[] arrayUtente = data.getArrayUtente();

    ObservableList<User> list2 = FXCollections.observableArrayList();

    public void CatchUsers() throws Exception {
        String filePath = System.getProperty("user.home") + "/playproj/props.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                utenti.add(line); // Aggiungi la riga all'array di array
            }

            // Stampa per verifica
            for (String[] utente : utenti) {
                System.out.println(Arrays.toString(utente));
            }

        } catch (FileNotFoundException e) {
            throw new IOException("File CSV non trovato: " + filePath);
        }
    }

    public String[][] getArrayUtenti() {
        // Converte la List in un array bidimensionale
        return utenti.toArray(new String[0][]);
    }

    int calcolaPunti(String[] array) {
        System.out.println(array[0]);
        int tot = 0;
        int[] n = { 7, 8, 9, 13, 14, 15, 19, 20, 21, 25, 26, 27 };
        for (int i = 0; i < n.length; i++) {
            if (n[i] < array.length) {
                tot += Integer.parseInt(array[n[i]]);
            }
        }
        return tot;
    }

    int calcolaMedaglieOro(String[] array) {
        System.out.println(array[0]);
        int tot = 0;
        int[] n = { 4, 5, 6, 10, 11, 12, 16, 17, 18, 22, 23, 24 };
        for (int i = 0; i < n.length; i++) {
            if (n[i] < array.length) {
                if (Integer.parseInt(array[n[i]]) == 5)
                    tot++;
            }
        }
        return tot;
    }

    int calcolaMedaglieArg(String[] array) {
        System.out.println(array[0]);
        int tot = 0;
        int[] n = { 4, 5, 6, 10, 11, 12, 16, 17, 18, 22, 23, 24 };
        for (int i = 0; i < n.length; i++) {
            if (n[i] < array.length) {
                if (Integer.parseInt(array[n[i]]) == 4)
                    tot++;
            }
        }
        return tot;
    }

    int calcolaMedaglieBro(String[] array) {
        System.out.println(array[0]);
        int tot = 0;
        int[] n = { 4, 5, 6, 10, 11, 12, 16, 17, 18, 22, 23, 24 };
        for (int i = 0; i < n.length; i++) {
            if (n[i] < array.length) {
                if (Integer.parseInt(array[n[i]]) == 3)
                    tot++;
            }
        }
        return tot;
    }

    /*********************************************************************************************/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // metodo per prendere tutti gli utenti iscritti
        try {
            CatchUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[][] utentiArray = getArrayUtenti();
        String[] arrayUtente = data.getArrayUtente();

        for (String[] utente : utentiArray) {
            System.out.println(Arrays.toString(utente));
        }
        // contatore per id progressivo
        int idCounter = 1;

        ObservableList<User> list = FXCollections.observableArrayList(
                new User(arrayUtente[3], arrayUtente[0], calcolaPunti(arrayUtente), calcolaMedaglieOro(arrayUtente),
                        calcolaMedaglieArg(arrayUtente),
                        calcolaMedaglieBro(arrayUtente)));

        for (int i = 0; i < utentiArray.length; i++) {
            list2.add(
                    new User(idCounter++, utentiArray[i][0], utentiArray[i][0], calcolaPunti(utentiArray[i]),
                            calcolaMedaglieOro(utentiArray[i]),
                            calcolaMedaglieArg(utentiArray[i]), calcolaMedaglieBro(utentiArray[i])));
        }
        
        // Configurazione delle colonne
        tbc_idAll.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbc_AvatarAll.setCellValueFactory(new PropertyValueFactory<>("avatar"));
        tbc_UserAll.setCellValueFactory(new PropertyValueFactory<>("user"));
        tbc_ptAll.setCellValueFactory(new PropertyValueFactory<>("pt"));
        tbc_oroAll.setCellValueFactory(new PropertyValueFactory<>("oro"));
        tbc_argAll.setCellValueFactory(new PropertyValueFactory<>("arg"));
        tbc_broAll.setCellValueFactory(new PropertyValueFactory<>("bro"));

        // -------------------
        tbc_Avatar.setCellValueFactory(new PropertyValueFactory<>("avatar"));
        tbc_User.setCellValueFactory(new PropertyValueFactory<>("user"));
        tbc_pt.setCellValueFactory(new PropertyValueFactory<>("pt"));
        tbc_oro.setCellValueFactory(new PropertyValueFactory<>("oro"));
        tbc_arg.setCellValueFactory(new PropertyValueFactory<>("arg"));
        tbc_bro.setCellValueFactory(new PropertyValueFactory<>("bro"));

        // Imposta gli elementi nella TableView
        tb_User.setItems(list);
        tb_allUsers.setItems(list2);

    }

    @FXML
    void btn_GoHome(MouseEvent event) throws Exception {
        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }
}
