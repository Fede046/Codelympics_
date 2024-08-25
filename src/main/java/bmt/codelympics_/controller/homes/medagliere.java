package bmt.codelympics_.controller.homes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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
import javafx.scene.control.Labeled;
import javafx.scene.control.TableCell;
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

    // List di tutti gli utenti registrati
    private List<String[]> utenti = new ArrayList<>();
    // array dell'utente che ha eseguito l'accesso
    String[] arrayUtente = data.getArrayUtente();

    ObservableList<User> list2 = FXCollections.observableArrayList();

    // metodo per leggere tutti gli utenti registrati
    public void CatchUsers() throws Exception {
        String filePath = System.getProperty("user.home") + "/playproj/props.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                utenti.add(line);
            }

        } catch (FileNotFoundException e) {
            throw new IOException("File CSV non trovato: " + filePath);
        }
    }

    // Converte la List in un array bidimensionale
    public String[][] getArrayUtenti() {
        return utenti.toArray(new String[0][]);
    }

    // metodo per calcolare i pt totali
    int calcolaPunti(String[] array) {
        int tot = 0;
        int[] n = { 7, 8, 9, 13, 14, 15, 19, 20, 21, 25, 26, 27 };
        for (int i = 0; i < n.length; i++) {
            if (n[i] < array.length) {
                tot += Integer.parseInt(array[n[i]]);
            }
        }
        return tot;
    }

    // metodo per calcolare il numero di medaglie
    // ---------------------------------------------------------------------------
    int calcolaMedaglieOro(String[] array) {
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

    // metodo per ordinare la lista degli utenti in ordine di punteggio
    public void bubbleSort(String[][] matrice) {
        int n = matrice.length;
        boolean scambiato;

        // Bubble sort sulla seconda colonna (indice 1)
        for (int i = 0; i < n - 1; i++) {
            scambiato = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (calcolaPunti(matrice[j]) < calcolaPunti(matrice[j + 1])) {
                    // Scambia le righe
                    String[] temp = matrice[j];
                    matrice[j] = matrice[j + 1];
                    matrice[j + 1] = temp;
                    scambiato = true;
                }
            }
            // Se non ci sono stati scambi, l'array è già ordinato
            if (!scambiato) {
                break;
            }
        }
    }

    // --------------------------------------------------------------------------
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // metodo per prendere tutti gli utenti iscritti
        try {
            CatchUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // array All
        String[][] utentiArray = getArrayUtenti();

        // array personale
        String[] arrayUtente = data.getArrayUtente();

        for (String[] utente : utentiArray) {
            System.out.println(Arrays.toString(utente));
        }
        // ordina matroice in base al punteggio
        bubbleSort(utentiArray);
        // contatore per id progressivo
        int idCounter = 1;

        ObservableList<User> list = FXCollections.observableArrayList(
                new User(arrayUtente[3], arrayUtente[0], calcolaPunti(arrayUtente), calcolaMedaglieOro(arrayUtente),
                        calcolaMedaglieArg(arrayUtente),
                        calcolaMedaglieBro(arrayUtente)));

        for (int i = 0; i < utentiArray.length; i++) {
            list2.add(
                    new User(idCounter++, utentiArray[i][3], utentiArray[i][0], calcolaPunti(utentiArray[i]),
                            calcolaMedaglieOro(utentiArray[i]),
                            calcolaMedaglieArg(utentiArray[i]), calcolaMedaglieBro(utentiArray[i])));
        }
        tbc_oroAll.getStyleClass().add("oro-header");
        tbc_argAll.getStyleClass().add("argento-header");
        tbc_broAll.getStyleClass().add("bronzo-header");
        tbc_oro.getStyleClass().add("oro-header");
        tbc_arg.getStyleClass().add("argento-header");
        tbc_bro.getStyleClass().add("bronzo-header");

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

        tbc_AvatarAll.setCellFactory(column -> new TableCell<User, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || item.trim().isEmpty()) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item);
                    // Converte il formato ARGB in RGB hex
                    try {
                        if (item.startsWith("0x")) {
                            String hexColor = item.substring(2);
                            String rgbColor = hexColor.substring(2); // Rimuove i primi 2 caratteri (Alpha)
                            setStyle("-fx-background-color: #" + rgbColor + ";" + "-fx-text-fill: #" + rgbColor + ";");
                        } else {
                            javafx.scene.paint.Color color = javafx.scene.paint.Color.web(item);
                            setStyle("-fx-background-color: " + item + ";" + "-fx-text-fill:" + item + ";");
                        }
                    } catch (IllegalArgumentException e) {
                        setStyle("");
                    }
                }
            }
        });
        tbc_Avatar.setCellFactory(column -> new TableCell<User, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item);

                    // Converte il formato ARGB in RGB hex
                    try {
                        if (item.startsWith("0x")) {
                            // Rimuove il prefisso "0x" e aggiunge "#" all'inizio
                            String hexColor = item.substring(2);
                            // Converti l'ARGB in RGB
                            String rgbColor = hexColor.substring(2); // Rimuove i primi 2 caratteri (Alpha)
                            setStyle("-fx-background-color: #" + rgbColor + ";" + "-fx-text-fill: #" + rgbColor + ";");
                        } else {
                            // Gestisce i colori nel formato esadecimale normale
                            javafx.scene.paint.Color color = javafx.scene.paint.Color.web(item);
                            setStyle("-fx-background-color: " + item + ";" + "-fx-text-fill:" + item + ";");

                        }
                    } catch (IllegalArgumentException e) {
                        // Se il codice colore non è valido, non applicare alcun colore
                        setStyle("");
                    }
                }
            }
        });
    }

    @FXML
    void btn_GoHome(MouseEvent event) throws Exception {
        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }
}
