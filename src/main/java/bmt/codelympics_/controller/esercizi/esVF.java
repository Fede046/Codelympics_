package bmt.codelympics_.controller.esercizi;

import javafx.util.Duration;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import bmt.codelympics_.model.Time;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class esVF extends ChangeStage implements Initializable {
    @FXML
    private Text txt_timer;
    Time time = new Time("00:00:00");

    @FXML
    private ToggleGroup VF;

    @FXML
    private Button btn_Conferma;

    @FXML
    private Button btn_ConfermaExit;

    @FXML
    private Label lb_domanda;

    @FXML
    private RadioButton rb_falso;

    @FXML
    private RadioButton rb_vero;

    DataSingleton data = DataSingleton.getInstance();
    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1),
                    e -> {

                        time.oneSecondPassed();
                        txt_timer.setText(time.getCurrentTime());
                    }));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txt_timer.setText(time.getCurrentTime());

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        ObjectMapper objectMapper = new ObjectMapper();
        // --------aggiunto per leggere il file quando uso il .jar (InputStream serve
        // per leggere un file all'interno del .jar)
        try (InputStream inputStream = getClass()
                .getResourceAsStream("/bmt/codelympics_/EserciziDoc/VeroFalso/RisposteVF.json")) {
            if (inputStream == null) {
                throw new IOException("File JSON non trovato!");
            }

            JsonNode rootNode = objectMapper.readTree(inputStream);

            switch (data.getStringaMedaglia()) {
                case 10:
                    JsonNode baseNode = rootNode.path("base");
                    String c = baseNode.get(data.getNumEsercizio()).path("domanda").asText();
                    lb_domanda.setText(c);
                    break;
                case 11:
                    JsonNode baseNode2 = rootNode.path("intermedio");
                    String c2 = baseNode2.get(data.getNumEsercizio()).path("domanda").asText();
                    lb_domanda.setText(c2);
                    System.err.println(c2);
                    break;
                case 12:
                    JsonNode baseNode3 = rootNode.path("difficile");
                    String c3 = baseNode3.get(data.getNumEsercizio()).path("domanda").asText();
                    lb_domanda.setText(c3);
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void Risposta() throws Exception {
        data.setNumEsercizio(data.getNumEsercizio() + 1);
        boolean temp = false;
        ObjectMapper objectMapper = new ObjectMapper();

        // ------------------- aggiunto

        try (InputStream inputStream = getClass()
                .getResourceAsStream("/bmt/codelympics_/EserciziDoc/VeroFalso/RisposteVF.json")) {
            if (inputStream == null) {
                throw new IOException("File JSON non trovato!");
            }

            JsonNode rootNode = objectMapper.readTree(inputStream);

            switch (data.getStringaMedaglia()) {
                case 10:
                    System.out.println(data.getNumEsercizio());
                    JsonNode baseNode = rootNode.path("base");
                    String c = baseNode.get(data.getNumEsercizio() - 1).path("sol").asText();
                    if (rb_vero.isSelected() && c.equals("true"))
                        temp = true;
                    if (rb_falso.isSelected() && c.equals("false"))
                        temp = true;

                    break;
                case 11:
                    JsonNode baseNode2 = rootNode.path("intermedio");
                    String c2 = baseNode2.get(data.getNumEsercizio() - 1).path("sol").asText();
                    if (rb_vero.isSelected() && c2.equals("true"))
                        temp = true;
                    if (rb_falso.isSelected() && c2.equals("false"))
                        temp = true;
                    break;
                case 12:
                    JsonNode baseNode3 = rootNode.path("difficile");
                    String c3 = baseNode3.get(data.getNumEsercizio() - 1).path("sol").asText();
                    if (rb_vero.isSelected() && c3.equals("true"))
                        temp = true;
                    if (rb_falso.isSelected() && c3.equals("false"))
                        temp = true;
                    break;
            }

            // int[] risp = new int[] { temp };
            data.addarrayDirisposte(temp);
            // data.risposta(data.getNumEsercizio(), risp));
        }
        // ---------------------
    }

    @FXML
    void func_ConfermaExit(MouseEvent event) throws Exception {

        // -----------------cambio stage AbbandonaGame--------------------
        fuc_changeStage(btn_ConfermaExit, "/bmt/codelympics_/fxml/transizioni/AbbandonaGame.fxml");
    }

    @FXML
    void func_Conferma(MouseEvent event) throws Exception {
        Risposta();
        // -----------------cambio stage ConfermaEs--------------------
        fuc_changeStage(btn_Conferma, "/bmt/codelympics_/fxml/transizioni/ConfermaEs.fxml");
    }

}
