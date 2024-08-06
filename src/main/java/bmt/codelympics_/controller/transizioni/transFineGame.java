package bmt.codelympics_.controller.transizioni;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import com.opencsv.CSVReader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.HashMap;

public class transFineGame extends ChangeStage{

    @FXML
    private Button btn_GoHome;

    @FXML
    private Label lb_punti1;

    @FXML
    private Label lb_punti2;

    DataSingleton data = DataSingleton.getInstance();
   // HashMaps<String,String>

    //c'è da aggiungere quante risposte giuste e il punteggio in base a esso e al tempo
    //aggiorna medaglie e punti dell'eserczio specifico
    //devo 42 ci dice il tipo di esercizio e il tipo di difficoltà
    /*void updateProfile()throws  Exception{
        String filePath = "C:\\playproj\\props.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            loginInfo.clear();
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length >= 2) {
                    loginInfo.put(line[0], line[1]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new IOException("File CSV non trovato: " + filePath);
        }


    }*/


    @FXML
    void func_Home(MouseEvent event) throws Exception{
        data.scriviPunteggioeMedagliaEserczio();
        String filePath = "C:\\playproj\\props.csv";
        //obbiettivo trovare la parte giusta
       /* try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
            writer.write(username + "," + encryptor.encryptString(password) + "," + email + "," + colore + ","+"0.0.0"+","+"0.0.0"+","+"0.0.0"+","+"0.0.0"+","+"0.0.0"+","+"0.0.0"+","+"0.0.0"+","+"0.0.0"+"\n");

        }catch (Exception e){
            e.getStackTrace();
        }*/

        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

}
