package bmt.codelympics_.controller.homes;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GamesHome extends ChangeStage implements Initializable {

    @FXML
    private Button btn_GoHome;

    @FXML
    private Button btn_goMedagliere;

    @FXML
    private Button btn_startErrore;

    @FXML
    private Button btn_startMultiple;

    @FXML
    private Button btn_startVF;
    @FXML
    private Button btn_startRiordinamento;

    @FXML
    private BorderPane img_1;

    @FXML
    private BorderPane img_2;

    @FXML
    private BorderPane img_3;

    @FXML
    private BorderPane img_4;

    @FXML
    private ProgressBar prgbar_VF;

    @FXML
    private ProgressBar prgbar_errore;

    @FXML
    private ProgressBar prgbar_multiple;

    @FXML
    private ProgressBar prgbar_riordinamento;

    DataSingleton data = DataSingleton.getInstance();

    @FXML
    void func_Home(MouseEvent event) throws Exception {

        // -----------------cambio stage home--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/home/home.fxml");

    }

    @FXML
    void func_goMedagliere(MouseEvent event) throws Exception {

        // -----------------cambio stage Medagliere--------------------
        fuc_changeStage(btn_goMedagliere, "/bmt/codelympics_/fxml/classifica/Medagliere.fxml");

    }

    @FXML
    void func_startErrore(MouseEvent event) throws Exception {
        data.setStringaMedaglia(16);
        // -----------------cambio stage trovaErrore--------------------
        fuc_changeStage(btn_startErrore, "/bmt/codelympics_/fxml/regoleGioco/RegoleGioco.fxml");

    }

    @FXML
    void func_startMultiplo(MouseEvent event) throws Exception {
        data.setStringaMedaglia(4);
        // -----------------cambio stage Ris Multiple--------------------
        fuc_changeStage(btn_startMultiple, "/bmt/codelympics_/fxml/regoleGioco/RegoleGioco.fxml");

    }

    @FXML
    void func_startRiordina(MouseEvent event) throws Exception {
        data.setStringaMedaglia(22);
        // -----------------cambio stage Riordinamento--------------------
        fuc_changeStage(btn_startRiordinamento, "/bmt/codelympics_/fxml/regoleGioco/RegoleGioco.fxml");

    }

    @FXML
    void func_startVF(MouseEvent event) throws Exception {
        data.setStringaMedaglia(10);
        // -----------------cambio stage trovaErrore--------------------
        fuc_changeStage(btn_startVF, "/bmt/codelympics_/fxml/regoleGioco/RegoleGioco.fxml");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] arrayUtente = data.getArrayUtente();
        prgbar_VF.setStyle("-fx-accent:gold");
        prgbar_errore.setStyle("-fx-accent:gold");
        prgbar_multiple.setStyle("-fx-accent:gold");
        prgbar_riordinamento.setStyle("-fx-accent:gold");

        Double pVF = 0.0;
        Double pRM = 0.0;
        Double pE = 0.0;
        Double pO = 0.0;

        if (!arrayUtente[7].equals("0")) {
            pRM += 0.33;
            prgbar_multiple.setProgress(pRM);
        }
        if (!arrayUtente[8].equals("0")) {
            pRM += 0.33;
            prgbar_multiple.setProgress(pRM);
        }
        if (!arrayUtente[9].equals("0")) {
            pRM += 0.33;
            prgbar_multiple.setProgress(pRM);
        }

        if (!arrayUtente[13].equals("0")) {
            pVF += 0.33;
            prgbar_VF.setProgress(pVF);
        }
        if (!arrayUtente[14].equals("0")) {
            pVF += 0.33;
            prgbar_VF.setProgress(pVF);
        }
        if (!arrayUtente[15].equals("0")) {
            pVF += 0.33;
            prgbar_VF.setProgress(pVF);
        }

        if (!arrayUtente[19].equals("0")) {
            pE += 0.33;
            prgbar_errore.setProgress(pE);
        }
        if (!arrayUtente[20].equals("0")) {
            pE += 0.33;
            prgbar_errore.setProgress(pE);
        }
        if (!arrayUtente[21].equals("0")) {
            pE += 0.33;
            prgbar_errore.setProgress(pE);
        }

        if (!arrayUtente[25].equals("0")) {
            pO += 0.33;
            prgbar_riordinamento.setProgress(pO);
        }
        if (!arrayUtente[26].equals("0")) {
            pO += 0.33;
            prgbar_riordinamento.setProgress(pO);
        }
        if (!arrayUtente[27].equals("0")) {
            pO += 0.33;
            prgbar_riordinamento.setProgress(pO);
        }

    }

}
