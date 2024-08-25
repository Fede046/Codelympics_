
package bmt.codelympics_.controller.esercizi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.util.Duration;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import bmt.codelympics_.model.Time;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class esRispMult extends ChangeStage implements Initializable {
    @FXML
    private Text txt_timer;

    @FXML
    private ToggleGroup RM;

    @FXML
    private Button btn_Conferma;

    @FXML
    private Button btn_ConfermaExit;

    @FXML
    private Button btn_r1;

    @FXML
    private Button btn_r2;

    @FXML
    private Button btn_r3;

    @FXML
    private Button btn_r4;

    @FXML
    private ImageView img_RM;

    @FXML
    private Label lb_domanda;

    @FXML
    private RadioButton rb_r1;

    @FXML
    private RadioButton rb_r2;

    @FXML
    private RadioButton rb_r3;

    @FXML
    private RadioButton rb_r4;

    DataSingleton data = DataSingleton.getInstance();

    // impostazione timer
    Time time = Time.getInstance();
    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> {

                time.oneSecondPassed();
                txt_timer.setText(time.getCurrentTime());
            }));

    // -------------------------------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // time
        txt_timer.setText(time.getCurrentTime());
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        ObjectMapper objectMapper = new ObjectMapper();

        // aggiunto per leggere il file quando uso il .jar (InputStream serve per
        // leggere un file all'interno del .jar)
        try (InputStream inputStream = getClass()
                .getResourceAsStream("/bmt/codelympics_/EserciziDoc/RisposteMultiple/RisposteRM.json")) {
            if (inputStream == null) {
                throw new IOException("File JSON non trovato!");
            }

            JsonNode rootNode = objectMapper.readTree(inputStream);

            // impostazione della schermata di gioco
            switch (data.getStringaMedaglia()) {
                case 4:
                    // --------------------------
                    JsonNode baseNode = rootNode.path("base");
                    String c = baseNode.get(data.getNumEsercizio()).path("domanda").asText();
                    lb_domanda.setText(c);

                    btn_r1.setText(baseNode.get(data.getNumEsercizio()).path("r1").asText());
                    btn_r2.setText(baseNode.get(data.getNumEsercizio()).path("r2").asText());
                    btn_r3.setText(baseNode.get(data.getNumEsercizio()).path("r3").asText());
                    btn_r4.setText(baseNode.get(data.getNumEsercizio()).path("r4").asText());

                    String image = baseNode.get(data.getNumEsercizio()).path("img").asText();
                    InputStream inStream = getClass()
                            .getResourceAsStream("/bmt/codelympics_/EserciziDoc/RisposteMultiple/base/" + image);
                    Image imageObject = new Image(inStream);
                    img_RM.setImage(imageObject);

                    break;

                case 5:

                    JsonNode baseNode2 = rootNode.path("intermedio");
                    String c2 = baseNode2.get(data.getNumEsercizio()).path("domanda").asText();
                    lb_domanda.setText(c2);
                    btn_r1.setText(baseNode2.get(data.getNumEsercizio()).path("r1").asText());
                    btn_r2.setText(baseNode2.get(data.getNumEsercizio()).path("r2").asText());
                    btn_r3.setText(baseNode2.get(data.getNumEsercizio()).path("r3").asText());
                    btn_r4.setText(baseNode2.get(data.getNumEsercizio()).path("r4").asText());

                    String image21 = baseNode2.get(data.getNumEsercizio()).path("img").asText();
                    InputStream inStream2 = getClass().getResourceAsStream(
                            "/bmt/codelympics_/EserciziDoc/RisposteMultiple/Intermedio/" + image21);
                    Image imageObject2 = new Image(inStream2);
                    img_RM.setImage(imageObject2);
                    break;

                case 6:
                    JsonNode baseNode3 = rootNode.path("difficile");
                    String c3 = baseNode3.get(data.getNumEsercizio()).path("domanda").asText();
                    lb_domanda.setText(c3);
                    btn_r1.setText(baseNode3.get(data.getNumEsercizio()).path("r1").asText());
                    btn_r2.setText(baseNode3.get(data.getNumEsercizio()).path("r2").asText());
                    btn_r3.setText(baseNode3.get(data.getNumEsercizio()).path("r3").asText());
                    btn_r4.setText(baseNode3.get(data.getNumEsercizio()).path("r4").asText());

                    String image23 = baseNode3.get(data.getNumEsercizio()).path("img").asText();
                    InputStream inStream3 = getClass()
                            .getResourceAsStream("/bmt/codelympics_/EserciziDoc/RisposteMultiple/Difficile/" + image23);
                    Image imageObject3 = new Image(inStream3);
                    img_RM.setImage(imageObject3);
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void func_ConfermaExit(MouseEvent event) throws Exception {
        timeline.stop();
        // -----------------cambio stage AbbandonaGame--------------------
        fuc_changeStage(btn_ConfermaExit, "/bmt/codelympics_/fxml/transizioni/AbbandonaGame.fxml");
    }

    // metodo per leggere le risposte
    void Risposta() throws Exception {
        data.setNumEsercizio(data.getNumEsercizio() + 1);
        boolean temp = false;
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream inputStream = getClass().getResourceAsStream(
                "/bmt/codelympics_/EserciziDoc/RisposteMultiple/RisposteRM.json")) {
            if (inputStream == null) {
                throw new IOException("File JSON non trovato!");
            }

            JsonNode rootNode = objectMapper.readTree(inputStream);
            // impostazione delle risposte
            switch (data.getStringaMedaglia()) {
                case 4:
                    JsonNode baseNode = rootNode.path("base");
                    String c = baseNode.get(data.getNumEsercizio() - 1).path("sol").asText();

                    if (rb_r1.isSelected() && c.equals(btn_r1.getText()))
                        temp = true;
                    if (rb_r2.isSelected() && c.equals(btn_r2.getText()))
                        temp = true;
                    if (rb_r3.isSelected() && c.equals(btn_r3.getText()))
                        temp = true;
                    if (rb_r4.isSelected() && c.equals(btn_r4.getText()))
                        temp = true;
                    break;
                case 5:
                    JsonNode baseNode2 = rootNode.path("intermedio");
                    String c2 = baseNode2.get(data.getNumEsercizio() - 1).path("sol").asText();
                    if (rb_r1.isSelected() && c2.equals(btn_r1.getText()))
                        temp = true;
                    if (rb_r2.isSelected() && c2.equals(btn_r2.getText()))
                        temp = true;
                    if (rb_r3.isSelected() && c2.equals(btn_r3.getText()))
                        temp = true;
                    if (rb_r4.isSelected() && c2.equals(btn_r4.getText()))
                        temp = true;
                    break;
                case 6:
                    JsonNode baseNode3 = rootNode.path("difficile");
                    String c3 = baseNode3.get(data.getNumEsercizio() - 1).path("sol").asText();
                    if (rb_r1.isSelected() && c3.equals(btn_r1.getText()))
                        temp = true;
                    if (rb_r2.isSelected() && c3.equals(btn_r2.getText()))
                        temp = true;
                    if (rb_r3.isSelected() && c3.equals(btn_r3.getText()))
                        temp = true;
                    if (rb_r4.isSelected() && c3.equals(btn_r4.getText()))
                        temp = true;
                    break;
            }

            data.addarrayDirisposte(temp);
        }

    }

    @FXML
    void func_Conferma(MouseEvent event) throws Exception {
        if (rb_r1.isSelected() || rb_r2.isSelected() || rb_r3.isSelected() || rb_r4.isSelected()) {
            Risposta();
            timeline.stop();
            // -----------------cambio stage ConfermaEs--------------------
            fuc_changeStage(btn_Conferma, "/bmt/codelympics_/fxml/transizioni/ConfermaEs.fxml");
        }
    }
}
