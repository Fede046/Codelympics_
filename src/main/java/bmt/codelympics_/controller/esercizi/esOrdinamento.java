package bmt.codelympics_.controller.esercizi;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class esOrdinamento extends ChangeStage implements Initializable {

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_Conferma;

    @FXML
    private Button btn_ConfermaExit;

    @FXML
    private Spinner<?> sp_1;

    @FXML
    private Spinner<?> sp_2;

    @FXML
    private Spinner<?> sp_3;

    @FXML
    private Spinner<?> sp_4;

    @FXML
    private Spinner<?> sp_5;

    @FXML
    private Spinner<?> sp_6;

    DataSingleton data = DataSingleton.getInstance();

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

    void Risposta() throws Exception {
        data.setNumEsercizio(data.getNumEsercizio() + 1);
        boolean temp = false;
        ObjectMapper objectMapper = new ObjectMapper();

        // ------------------- aggiunto

        try (InputStream inputStream = getClass().getResourceAsStream(
                "/bmt/codelympics_/EserciziDoc/RisposteMultiple/RisposteRM.json")) {
            if (inputStream == null) {
                throw new IOException("File JSON non trovato!");
            }

            JsonNode rootNode = objectMapper.readTree(inputStream);

            switch (data.getStringaMedaglia()) {
                case 22:
                    JsonNode baseNode = rootNode.path("base");
                    String c = baseNode.get(data.getNumEsercizio() - 1).path("sol").asText();

                    System.err.println(temp);
                    break;
                case 23:
                    JsonNode baseNode2 = rootNode.path("intermedio");
                    String c2 = baseNode2.get(data.getNumEsercizio() - 1).path("sol").asText();

                    break;
                case 24:
                    JsonNode baseNode3 = rootNode.path("difficile");
                    String c3 = baseNode3.get(data.getNumEsercizio() - 1).path("sol").asText();

                    break;
            }

            data.addarrayDirisposte(temp);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int max = 0;
        List<String> solution = new ArrayList<>(Arrays.asList("r1", "r2", "r3", "r4", "r5", "r6"));

        ObjectMapper objectMapper = new ObjectMapper();
        // --------aggiunto per leggere il file quando uso il .jar (InputStream serve
        // per leggere un file all'interno del .jar)
        try (InputStream inputStream = getClass()
                .getResourceAsStream("/bmt/codelympics_/EserciziDoc/Ordinamento/RisposteO.json")) {
            if (inputStream == null) {
                throw new IOException("File JSON non trovato!");
            }

            JsonNode rootNode = objectMapper.readTree(inputStream);

            switch (data.getStringaMedaglia()) {
                case 22:
                    solution.remove(5);
                    solution.remove(4);
                    Collections.shuffle(solution);
                    JsonNode baseNode = rootNode.path("base");
                    btn_1.setText(baseNode.get(data.getNumEsercizio()).path(solution.get(0)).asText());
                    btn_2.setText(baseNode.get(data.getNumEsercizio()).path(solution.get(1)).asText());
                    btn_3.setText(baseNode.get(data.getNumEsercizio()).path(solution.get(2)).asText());
                    btn_4.setText(baseNode.get(data.getNumEsercizio()).path(solution.get(3)).asText());
                    btn_5.setVisible(false);
                    sp_5.setVisible(false);
                    btn_6.setVisible(false);
                    sp_6.setVisible(false);
                    max = 4;
                    break;
                case 23:
                    solution.remove(5);
                    Collections.shuffle(solution);
                    JsonNode baseNode2 = rootNode.path("intermedio");
                    btn_1.setText(baseNode2.get(data.getNumEsercizio()).path(solution.get(0)).asText());
                    btn_2.setText(baseNode2.get(data.getNumEsercizio()).path(solution.get(1)).asText());
                    btn_3.setText(baseNode2.get(data.getNumEsercizio()).path(solution.get(2)).asText());
                    btn_4.setText(baseNode2.get(data.getNumEsercizio()).path(solution.get(3)).asText());
                    btn_5.setText(baseNode2.get(data.getNumEsercizio()).path(solution.get(4)).asText());
                    btn_6.setVisible(false);
                    sp_6.setVisible(false);
                    max = 5;
                    break;
                case 24:
                    Collections.shuffle(solution);
                    JsonNode baseNode3 = rootNode.path("difficile");
                    btn_1.setText(baseNode3.get(data.getNumEsercizio()).path(solution.get(0)).asText());
                    btn_2.setText(baseNode3.get(data.getNumEsercizio()).path(solution.get(1)).asText());
                    btn_3.setText(baseNode3.get(data.getNumEsercizio()).path(solution.get(2)).asText());
                    btn_4.setText(baseNode3.get(data.getNumEsercizio()).path(solution.get(3)).asText());
                    btn_5.setText(baseNode3.get(data.getNumEsercizio()).path(solution.get(4)).asText());
                    btn_6.setText(baseNode3.get(data.getNumEsercizio()).path(solution.get(5)).asText());
                    max = 6;
                    break;
            }
            Spinner[] spinners = new Spinner[] { sp_1, sp_2, sp_3, sp_4, sp_5, sp_6 };
            // caso 6 scelte
            for (Spinner e : spinners)
                e.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, max, 1));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
