package bmt.codelympics_.controller.esercizi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.util.Duration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class esTrovaErrore extends ChangeStage implements Initializable {
    @FXML
    private Text txt_timer;

    @FXML
    private ToggleGroup Errore;

    @FXML
    private Button btn_Conferma;

    @FXML
    private Button btn_ConfermaExit;

    @FXML
    private ImageView img_1;

    @FXML
    private ImageView img_2;

    @FXML
    private ImageView img_3;

    @FXML
    private ImageView img_4;

    @FXML
    private RadioButton rb_r1;

    @FXML
    private RadioButton rb_r2;

    @FXML
    private RadioButton rb_r3;

    @FXML
    private RadioButton rb_r4;

    Time time = Time.getInstance();
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
                .getResourceAsStream("/bmt/codelympics_/EserciziDoc/TrovaErrore/RisposteE.json")) {
            if (inputStream == null) {
                throw new IOException("File JSON non trovato!");
            }

            JsonNode rootNode = objectMapper.readTree(inputStream);

            switch (data.getStringaMedaglia()) {
                case 16:
                    JsonNode baseNode = rootNode.path("base");

                    String image11 = baseNode.get(data.getNumEsercizio()).path("img1").asText();
                    String image12 = baseNode.get(data.getNumEsercizio()).path("img2").asText();
                    String image13 = baseNode.get(data.getNumEsercizio()).path("img3").asText();
                    String image14 = baseNode.get(data.getNumEsercizio()).path("img4").asText();

                    InputStream inStream = getClass()
                            .getResourceAsStream("/bmt/codelympics_/EserciziDoc/TrovaErrore/base/" + image11);
                    Image imageObject = new Image(inStream);
                    ImageView image2 = new ImageView(imageObject);
                    img_1.setImage(imageObject);

                    InputStream inStream12 = getClass()
                            .getResourceAsStream("/bmt/codelympics_/EserciziDoc/TrovaErrore/base/" + image12);
                    Image imageObject12 = new Image(inStream12);
                    ImageView image212 = new ImageView(imageObject12);
                    img_2.setImage(imageObject12);

                    InputStream inStream13 = getClass()
                            .getResourceAsStream("/bmt/codelympics_/EserciziDoc/TrovaErrore/base/" + image13);
                    Image imageObject13 = new Image(inStream13);
                    ImageView image213 = new ImageView(imageObject13);
                    img_3.setImage(imageObject13);

                    InputStream inStream14 = getClass()
                            .getResourceAsStream("/bmt/codelympics_/EserciziDoc/TrovaErrore/base/" + image14);
                    Image imageObject14 = new Image(inStream14);
                    ImageView image214 = new ImageView(imageObject14);
                    img_4.setImage(imageObject14);

                    break;
                case 17:
                    JsonNode baseNode2 = rootNode.path("intermedio");

                    String image21 = baseNode2.get(data.getNumEsercizio()).path("img1").asText();
                    String image22 = baseNode2.get(data.getNumEsercizio()).path("img2").asText();
                    String image23 = baseNode2.get(data.getNumEsercizio()).path("img3").asText();
                    String image24 = baseNode2.get(data.getNumEsercizio()).path("img4").asText();

                    InputStream inStream21 = getClass()
                            .getResourceAsStream(
                                    "/bmt/codelympics_/EserciziDoc/TrovaErrore/intermedio/" + image21);
                    Image imageObject21 = new Image(inStream21);
                    ImageView image221 = new ImageView(imageObject21);
                    img_1.setImage(imageObject21);

                    InputStream inStream22 = getClass()
                            .getResourceAsStream(
                                    "/bmt/codelympics_/EserciziDoc/TrovaErrore/intermedio/" + image22);
                    Image imageObject22 = new Image(inStream22);
                    ImageView image222 = new ImageView(imageObject22);
                    img_2.setImage(imageObject22);

                    InputStream inStream23 = getClass()
                            .getResourceAsStream(
                                    "/bmt/codelympics_/EserciziDoc/TrovaErrore/intermedio/" + image23);
                    Image imageObject23 = new Image(inStream23);
                    ImageView image223 = new ImageView(imageObject23);
                    img_3.setImage(imageObject23);

                    InputStream inStream24 = getClass()
                            .getResourceAsStream(
                                    "/bmt/codelympics_/EserciziDoc/TrovaErrore/intermedio/" + image24);
                    Image imageObject24 = new Image(inStream24);
                    ImageView image224 = new ImageView(imageObject24);
                    img_4.setImage(imageObject24);
                    break;
                case 18:
                    JsonNode baseNode3 = rootNode.path("difficile");

                    String image31 = baseNode3.get(data.getNumEsercizio()).path("img1").asText();
                    String image32 = baseNode3.get(data.getNumEsercizio()).path("img2").asText();
                    String image33 = baseNode3.get(data.getNumEsercizio()).path("img3").asText();
                    String image34 = baseNode3.get(data.getNumEsercizio()).path("img4").asText();

                    InputStream inStream31 = getClass()
                            .getResourceAsStream("/bmt/codelympics_/EserciziDoc/TrovaErrore/difficile/" + image31);
                    Image imageObject31 = new Image(inStream31);
                    ImageView image231 = new ImageView(imageObject31);
                    img_1.setImage(imageObject31);

                    InputStream inStream32 = getClass()
                            .getResourceAsStream("/bmt/codelympics_/EserciziDoc/TrovaErrore/difficile/" + image32);
                    Image imageObject32 = new Image(inStream32);
                    ImageView image322 = new ImageView(imageObject32);
                    img_2.setImage(imageObject32);

                    InputStream inStream33 = getClass()
                            .getResourceAsStream("/bmt/codelympics_/EserciziDoc/TrovaErrore/difficile/" + image33);
                    Image imageObject33 = new Image(inStream33);
                    ImageView image233 = new ImageView(imageObject33);
                    img_3.setImage(imageObject33);

                    InputStream inStream34 = getClass()
                            .getResourceAsStream("/bmt/codelympics_/EserciziDoc/TrovaErrore/difficile/" + image34);
                    Image imageObject34 = new Image(inStream34);
                    ImageView image234 = new ImageView(imageObject34);
                    img_4.setImage(imageObject34);
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
                .getResourceAsStream("/bmt/codelympics_/EserciziDoc/TrovaErrore/RisposteE.json")) {
            if (inputStream == null) {
                throw new IOException("File JSON non trovato!");
            }

            JsonNode rootNode = objectMapper.readTree(inputStream);

            switch (data.getStringaMedaglia()) {
                case 16:
                    JsonNode baseNode = rootNode.path("base");
                    String c = baseNode.get(data.getNumEsercizio() - 1).path("sol").asText();

                    if (rb_r1.isSelected() && c.equals("r1"))
                        temp = true;
                    if (rb_r2.isSelected() && c.equals("r2"))
                        temp = true;
                    if (rb_r3.isSelected() && c.equals("r3"))
                        temp = true;
                    if (rb_r4.isSelected() && c.equals("r4"))
                        temp = true;
                    System.err.println(temp);

                    break;
                case 17:
                    JsonNode baseNode2 = rootNode.path("intermedio");
                    String c2 = baseNode2.get(data.getNumEsercizio() - 1).path("sol").asText();
                    if (rb_r1.isSelected() && c2.equals("r1"))
                        temp = true;
                    if (rb_r2.isSelected() && c2.equals("r2"))
                        temp = true;
                    if (rb_r3.isSelected() && c2.equals("r3"))
                        temp = true;
                    if (rb_r4.isSelected() && c2.equals("r4"))
                        temp = true;
                    break;
                case 18:
                    JsonNode baseNode3 = rootNode.path("difficile");
                    String c3 = baseNode3.get(data.getNumEsercizio() - 1).path("sol").asText();
                    if (rb_r1.isSelected() && c3.equals("r1"))
                        temp = true;
                    if (rb_r2.isSelected() && c3.equals("r2"))
                        temp = true;
                    if (rb_r3.isSelected() && c3.equals("r3"))
                        temp = true;
                    if (rb_r4.isSelected() && c3.equals("r4"))
                        temp = true;
                    break;
            }

            data.addarrayDirisposte(temp);
        }

    }

    @FXML
    void func_Conferma(MouseEvent event) throws Exception {
        if (rb_r1.isSelected() || rb_r2.isSelected() || rb_r3.isSelected() || rb_r4.isSelected()) {

            timeline.stop();
            Risposta();
            // -----------------cambio stage ConfermaEs--------------------
            fuc_changeStage(btn_Conferma, "/bmt/codelympics_/fxml/transizioni/ConfermaEs.fxml");
        }
    }

    @FXML
    void func_ConfermaExit(MouseEvent event) throws Exception {
        timeline.stop();
        // -----------------cambio stage AbbandonaGame--------------------
        fuc_changeStage(btn_ConfermaExit, "/bmt/codelympics_/fxml/transizioni/AbbandonaGame.fxml");
    }
}
