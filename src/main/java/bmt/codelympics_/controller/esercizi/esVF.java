package bmt.codelympics_.controller.esercizi;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class esVF extends ChangeStage implements Initializable {

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

    public void initialize(URL location, ResourceBundle resources) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Leggi il file JSON
            JsonNode rootNode = objectMapper.readTree(new File(
                    "src/main/resources/bmt/codelympics_/EserciziDoc/VeroFalso/RisposteVF.json"));
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
        JsonNode rootNode = objectMapper.readTree(new File(
                "src/main/resources/bmt/codelympics_/EserciziDoc/VeroFalso/RisposteVF.json"));

        switch (data.getStringaMedaglia()) {
            case 10:
                System.out.println(data.getNumEsercizio() + " veropooodoapod");
                JsonNode baseNode = rootNode.path("base");
                String c = baseNode.get(data.getNumEsercizio() - 1).path("sol").asText();
                System.out.println("Certo che vaadasadsadasdasasd");
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
