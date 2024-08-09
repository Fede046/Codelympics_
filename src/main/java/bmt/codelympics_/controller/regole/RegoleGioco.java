package bmt.codelympics_.controller.regole;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class RegoleGioco extends ChangeStage implements Initializable {

    @FXML
    private Button btn_GoHome;

    @FXML
    private Button btn_difficile;

    @FXML
    private Button btn_int;
    @FXML
    private Label lb_nameGame;

    @FXML
    private Button btn_princ;

    @FXML
    private Label lb_txtRegole;

    DataSingleton data = DataSingleton.getInstance();

    void cambiaLabel(){



    }
    
    @FXML
    void func_Difficile(MouseEvent event) throws Exception {
        // risp mult
        switch (data.getStringaMedaglia()) {
            case 4:
                data.setStringaMedaglia(4 + 2);
                // -----------------cambio stage esRispMult diff--------------------
                fuc_changeStage(btn_difficile, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
                break;
            case 10:
                data.setStringaMedaglia(10 + 2);
                // -----------------cambio stage esVF diff--------------------
                fuc_changeStage(btn_difficile, "/bmt/codelympics_/fxml/esercizi/EsVF.fxml");
                break;
            case 16:
                data.setStringaMedaglia(16 + 2);
                // -----------------cambio stage esErr diff--------------------
                fuc_changeStage(btn_difficile, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
                break;
            case 22:
                data.setStringaMedaglia(22 + 2);
                // -----------------cambio stage esOrd diff--------------------
                fuc_changeStage(btn_difficile, "/bmt/codelympics_/fxml/esercizi/EsOrdinamento.fxml");
                break;
        }

    }

    @FXML
    void func_Home(MouseEvent event) throws Exception {
        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

    @FXML
    void func_Int(MouseEvent event) throws Exception {
        switch (data.getStringaMedaglia()) {
            case 4:
                data.setStringaMedaglia(4 + 1);
                // -----------------cambio stage esRispMult int--------------------
                fuc_changeStage(btn_int, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
                break;
            case 10:
                data.setStringaMedaglia(10 + 1);
                // -----------------cambio stage esVF int--------------------
                fuc_changeStage(btn_int, "/bmt/codelympics_/fxml/esercizi/EsVF.fxml");
                break;
            case 16:
                data.setStringaMedaglia(16 + 1);
                // -----------------cambio stage esErr int--------------------
                fuc_changeStage(btn_int, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
                break;
            case 22:
                data.setStringaMedaglia(22 + 1);
                // -----------------cambio stage esOrd int--------------------
                fuc_changeStage(btn_int, "/bmt/codelympics_/fxml/esercizi/EsOrdinamento.fxml");
                break;
        }
    }

    @FXML
    void func_Princ(MouseEvent event) throws Exception {
        switch (data.getStringaMedaglia()) {
            case 4:

                // -----------------cambio stage esRispMult princ--------------------
                fuc_changeStage(btn_princ, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
                break;
            case 10:

                // -----------------cambio stage esVF princ--------------------
                fuc_changeStage(btn_princ, "/bmt/codelympics_/fxml/esercizi/EsVF.fxml");
                break;
            case 16:

                // -----------------cambio stage esErr princ--------------------
                fuc_changeStage(btn_princ, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
                break;
            case 22:

                // -----------------cambio stage esOrd princ--------------------
                fuc_changeStage(btn_princ, "/bmt/codelympics_/fxml/esercizi/EsOrdinamento.fxml");
                break;
        }
    }
}
