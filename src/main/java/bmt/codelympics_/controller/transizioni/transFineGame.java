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

public class transFineGame extends ChangeStage {

    @FXML
    private Button btn_GoHome;

    @FXML
    private Button lb_punti1;

    @FXML
    private Button lb_punti2;

    DataSingleton data = DataSingleton.getInstance();


    @FXML
    void func_Home(MouseEvent event) throws Exception {
        String[] nuovoArrayUtente = data.getArrayUtente();
        int stringaPunti = data.getStringaMedaglia() + 3;

        System.out.println(data.getArrayUtente()[data.getStringaMedaglia()]);
        System.out.println(data.getArrayUtente()[stringaPunti]);
        System.out.println();

        int nuovaMedaglia = 0;
        for (boolean e : data.getArrayRisposte()) {
            if (e) {
                nuovaMedaglia++;
            }
        }
        nuovoArrayUtente[data.getStringaMedaglia()] = Integer.toString(nuovaMedaglia);

        int nuovoPunteggio = (nuovaMedaglia * 200)+700;
        //aggiungere la variabile tempo se si vuole

        nuovoArrayUtente[stringaPunti] = Integer.toString(nuovoPunteggio);
//--------------------------------------------------------------------------------


        String filePath2 = "C:\\playproj\\props2.csv";
        String filePath = "C:\\playproj\\props.csv";

        File file2 = new File(filePath2);

        try (FileWriter writer = new FileWriter(file2)) {
            try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
                String[] line;

                while ((line = reader.readNext()) != null) {
                    System.out.println(line[0]);

                    for(int i=0;i<line.length;i++){
                        if(line[0].equals(nuovoArrayUtente[0])){
                            if(i== line.length-1){
                                writer.append(nuovoArrayUtente[i]).append("\n");
                                System.out.print(nuovoArrayUtente[i]);
                            }else {
                                writer.append(nuovoArrayUtente[i]).append(",");
                                System.out.print(nuovoArrayUtente[i]+",");
                            }
                        }


                        else if(i== line.length-1){
                            writer.append(line[i]).append("\n");
                            System.out.print(line[i]);
                        }else {
                            writer.append(line[i]).append(",");
                            System.out.print(line[i]+",");
                        }

                    }
                    System.out.println();

                }


            } catch (FileNotFoundException e) {
                throw new IOException("File CSV non trovato: " + filePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//--------------------------------

        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file)) {
            try (CSVReader reader = new CSVReader(new FileReader(filePath2))) {
                String[] line;

                while ((line = reader.readNext()) != null) {
                   for(int i=0;i<line.length;i++){
                       if(i== line.length-1){
                           writer.append(line[i]).append("\n");
                           System.out.print(line[i]);
                       }else {
                           writer.append(line[i]).append(",");
                           System.out.print(line[i]+",");
                       }
                   }

                }


            } catch (FileNotFoundException e) {
                throw new IOException("File CSV non trovato: " + filePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    // -----------------cambio stage gamesHome--------------------
    fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
}






}
