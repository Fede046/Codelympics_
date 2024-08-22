package bmt.codelympics_.controller.transizioni;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import bmt.codelympics_.model.Time;
import com.opencsv.CSVReader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class transFineGame extends ChangeStage implements Initializable {

    @FXML
    private Button btn_GoHome;

    @FXML
    private Label lb_punti1;

    @FXML
    private Label lb_punti2;

    DataSingleton data = DataSingleton.getInstance();
    Time time = Time.getInstance();

    int nRisposteCorrette() {
        int temp = 0;
        for (boolean e : data.getArrayRisposte()) {
            if (e) {
                temp++;
            }
        }
        return temp;
    }

    int nuovoPunteggio() {
        String[] array = time.getCurrentTime().split(":");
        int variabileTempoINT = Integer.parseInt(array[0])*200+Integer.parseInt(array[1])*25+Integer.parseInt(array[2])/2;
        if(nRisposteCorrette()*200-variabileTempoINT<0) return 0;
        System.out.println(nRisposteCorrette() * 200-variabileTempoINT);
        return nRisposteCorrette() * 200-variabileTempoINT ;//varia secondo quanto tempo ci metto -------------------------------------------
    }

    @FXML
    void func_Home(MouseEvent event) throws Exception {
        String[] nuovoArrayUtente = data.getArrayUtente();
        int stringaPunti = data.getStringaMedaglia() + 3;

        System.out.println(data.getArrayUtente()[data.getStringaMedaglia()]);
        System.out.println(data.getArrayUtente()[stringaPunti]);
        System.out.println();
        //il nuomero di risposte giuste corrisponde alla medaglia (5=oro,4=aregento,3=bronzo)
        nuovoArrayUtente[data.getStringaMedaglia()] = Integer.toString(nRisposteCorrette());



        nuovoArrayUtente[stringaPunti] = Integer.toString(nuovoPunteggio());

        // --------------------------------------------------------------------------------
        //metodi di scrittura/salvataggio dei nuovi dati
        String filePath2 = System.getProperty("user.home") + "/playproj/props2.csv";
        String filePath = System.getProperty("user.home") + "/playproj/props.csv";

        //String filePath2 = "C:\\playproj\\props2.csv";
        //String filePath = "C:\\playproj\\props.csv";

        File file2 = new File(filePath2);
        try (FileWriter writer = new FileWriter(file2)) {
            try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
                String[] line;

                while ((line = reader.readNext()) != null) {
                    System.out.println(line[0]);

                    for (int i = 0; i < line.length; i++) {
                        if (line[0].equals(nuovoArrayUtente[0])) {
                            if (i == line.length - 1) {
                                writer.append(nuovoArrayUtente[i]).append("\n");
                                System.out.print(nuovoArrayUtente[i]);
                            } else {
                                writer.append(nuovoArrayUtente[i]).append(",");
                                System.out.print(nuovoArrayUtente[i] + ",");
                            }
                        }

                        else if (i == line.length - 1) {
                            writer.append(line[i]).append("\n");
                            System.out.print(line[i]);
                        } else {
                            writer.append(line[i]).append(",");
                            System.out.print(line[i] + ",");
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
        // --------------------------------

        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file)) {
            try (CSVReader reader = new CSVReader(new FileReader(filePath2))) {
                String[] line;

                while ((line = reader.readNext()) != null) {
                    for (int i = 0; i < line.length; i++) {
                        if (i == line.length - 1) {
                            writer.append(line[i]).append("\n");
                            System.out.print(line[i]);
                        } else {
                            writer.append(line[i]).append(",");
                            System.out.print(line[i] + ",");
                        }
                    }

                }

            } catch (FileNotFoundException e) {
                throw new IOException("File CSV non trovato: " + filePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //stoppa timer
        time.setTime("0:0:0");
        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lb_punti1.setText("Hai fatto " + nRisposteCorrette() + " risposte giuste su 5.");
        lb_punti2.setText("HAI OTTENUTO\n" + nuovoPunteggio() + " PUNTI!\n"+"TEMPO\n"+time.getCurrentTime());
    }

}
