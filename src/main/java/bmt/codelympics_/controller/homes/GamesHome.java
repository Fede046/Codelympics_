package bmt.codelympics_.controller.homes;

import bmt.codelympics_.model.ChangeStage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class GamesHome extends ChangeStage {

    @FXML
    private Button btn_GoHome;

    @FXML
    private Button btn_goMedagliere;

    @FXML
    private Button btn_startErrore;

    @FXML
    private Button btn_startMultiple;

    @FXML
    private Button btn_startRiordinamento;

    @FXML
    private Button btn_startVF;

    @FXML
    private ImageView img_pesi;

    @FXML
    private ImageView img_scherma;

    @FXML
    private Label lb_title;

    @FXML
    private ProgressBar prgbar_VF;

    @FXML
    private ProgressBar prgbar_errore;

    @FXML
    private ProgressBar prgbar_multiple;

    @FXML
    private ProgressBar prgbar_riordinamento;

    @FXML
    private Rectangle rect1;

    @FXML
    private Rectangle rect3;

    @FXML
    private Rectangle rect4;

    @FXML
    private Rectangle rect41;

    @FXML
    void func_Home(MouseEvent event) throws Exception{
    // -----------------cambio stage home--------------------
    fuc_changeStage(btn_GoHome, "/bmt/codelympics_/fxml/home/home.fxml");
        
    }

    @FXML
    void func_goMedagliere(MouseEvent event) throws Exception{
    // -----------------cambio stage Medagliere--------------------
    fuc_changeStage(btn_goMedagliere, "/bmt/codelympics_/fxml/classifica/Medagliere.fxml");
    
    }

    @FXML
    void func_startErrore(MouseEvent event) throws Exception{
        // -----------------cambio stage trovaErrore--------------------
        fuc_changeStage(btn_startErrore, "/bmt/codelympics_/fxml/regoleGioco/RegoleErrore.fxml");
        
    }

    @FXML
    void func_startMultiplo(MouseEvent event)throws Exception {
 // -----------------cambio stage Ris Multiple--------------------
 fuc_changeStage(btn_startMultiple, "/bmt/codelympics_/fxml/regoleGioco/RegoleMultipla.fxml");
    
    }

    @FXML
    void func_startRiordina(MouseEvent event) throws Exception{
        // -----------------cambio stage Riordinamento--------------------
        fuc_changeStage(btn_startRiordinamento, "/bmt/codelympics_/fxml/regoleGioco/RegoleRio.fxml");
    
    }

    @FXML
    void func_startVF(MouseEvent event) throws Exception{
        // -----------------cambio stage trovaErrore--------------------
        fuc_changeStage(btn_startVF, "/bmt/codelympics_/fxml/regoleGioco/RegoleVF.fxml");

    }

}
