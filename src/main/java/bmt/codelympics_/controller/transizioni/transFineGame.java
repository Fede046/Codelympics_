package bmt.codelympics_.controller.transizioni;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import bmt.codelympics_.model.Time;
import com.opencsv.CSVReader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;

import java.util.ResourceBundle;

public class transFineGame extends ChangeStage implements Initializable {

    @FXML
    private Button btn_GoHome;

    @FXML
    private ImageView img_medal;
    @FXML
    private ImageView img_medal2;

    @FXML
    private Label lb_punti1;

    @FXML
    private Label lb_punti2;

    @FXML
    private Label lbl_textDown;

    @FXML
    private Label lbl_textUp;

    DataSingleton data = DataSingleton.getInstance();
    Time time = Time.getInstance();

    public int nRisposteCorrette() {
        int temp = 0;
        for (boolean e : data.getArrayRisposte()) {
            if (e) {
                temp++;
            }
        }
        return temp;
    }

    int pt = nRisposteCorrette();

    int nuovoPunteggio() {
        String[] array = time.getCurrentTime().split(":");
        int variabileTempoINT = Integer.parseInt(array[0]) * 200 + Integer.parseInt(array[1]) * 25
                + Integer.parseInt(array[2]) / 2;
        if (pt * 200 - variabileTempoINT < 0)
            return 0;

        return pt * 200 - variabileTempoINT;// varia secondo quanto tempo ci metto
                                            // -------------------------------------------
    }

    @FXML
    void func_Home(MouseEvent event) throws Exception {

        String[] nuovoArrayUtente = data.getArrayUtente();

        int stringaPunti = data.getStringaMedaglia() + 3;
        if (Integer.parseInt(nuovoArrayUtente[stringaPunti]) < nuovoPunteggio()) {

            // il nuomero di risposte giuste corrisponde alla medaglia
            // (5=oro,4=aregento,3=bronzo)
            nuovoArrayUtente[data.getStringaMedaglia()] = Integer.toString(pt);

            nuovoArrayUtente[stringaPunti] = Integer.toString(nuovoPunteggio());

            // --------------------------------------------------------------------------------
            // metodi di scrittura/salvataggio dei nuovi dati
            String filePath2 = System.getProperty("user.home") + "/playproj/props2.csv";
            String filePath = System.getProperty("user.home") + "/playproj/props.csv";

            File file2 = new File(filePath2);
            try (FileWriter writer = new FileWriter(file2)) {
                try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
                    String[] line;

                    while ((line = reader.readNext()) != null) {

                        for (int i = 0; i < line.length; i++) {
                            if (line[0].equals(nuovoArrayUtente[0])) {
                                if (i == line.length - 1) {
                                    writer.append(nuovoArrayUtente[i]).append("\n");

                                } else {
                                    writer.append(nuovoArrayUtente[i]).append(",");

                                }
                            } else if (i == line.length - 1) {
                                writer.append(line[i]).append("\n");

                            } else {
                                writer.append(line[i]).append(",");

                            }

                        }

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

                            } else {
                                writer.append(line[i]).append(",");

                            }
                        }

                    }

                } catch (FileNotFoundException e) {
                    throw new IOException("File CSV non trovato: " + filePath);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // stop timer
        time.setTime("0:0:0");
        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lb_punti1.setText("Hai fatto " + pt + " risposte giuste su 5.");
        lb_punti2.setText("HAI OTTENUTO\n" + nuovoPunteggio() + " PUNTI!\n" + "TEMPO\n" + time.getCurrentTime());

        switch (pt) {
            case 3:
                lbl_textUp.setText("Medaglia di Bronzo!");
                img_medal.setImage(
                        new Image(getClass().getResourceAsStream("/bmt/codelympics_/img/home/medagliaBronzo.png")));
                img_medal2.setImage(
                        new Image(getClass().getResourceAsStream("/bmt/codelympics_/img/home/medagliaBronzo.png")));
                StringaFinale();
                break;
            case 4:
                lbl_textUp.setText("Medaglia d'Argento!");
                img_medal.setImage(
                        new Image(getClass().getResourceAsStream("/bmt/codelympics_/img/home/medagliaArgento.png")));
                img_medal2.setImage(
                        new Image(getClass().getResourceAsStream("/bmt/codelympics_/img/home/medagliaArgento.png")));
                StringaFinale();
                break;

            case 5:
                lbl_textUp.setText("Medaglia d'Oro!");
                img_medal.setImage(
                        new Image(getClass().getResourceAsStream("/bmt/codelympics_/img/home/medagliaOro.png")));
                img_medal2.setImage(
                        new Image(getClass().getResourceAsStream("/bmt/codelympics_/img/home/medagliaOro.png")));
                StringaFinale();
                break;
            default:
                lbl_textUp.setText("Nessuna Medaglia!");
                lbl_textDown.setText("Non sei pronto per passare al prossimo livello.\nRiprova!");
                img_medal.setVisible(false);
                break;
        }

    }

    public void StringaFinale() {
        if (data.getStringaMedaglia() == 6 || data.getStringaMedaglia() == 12 || data.getStringaMedaglia() == 18
                || data.getStringaMedaglia() == 24) {
            lbl_textDown.setText("Ora sei pronto per passare al prossimo gioco.\nChe l'avventura continui!");

        }
    }

}
