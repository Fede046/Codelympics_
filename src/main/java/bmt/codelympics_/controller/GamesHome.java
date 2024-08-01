package bmt.codelympics_.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GamesHome {

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
        Stage stage1 = (Stage) btn_goMedagliere.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/home.fxml"));
        Parent root = loader.load();
        stage1.setScene(new Scene(root));
    }

    @FXML
    void func_goMedagliere(MouseEvent event) throws Exception{
    // -----------------cambio stage Medagliere--------------------
    Stage stage1 = (Stage) btn_goMedagliere.getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/home.fxml"));
    Parent root = loader.load();
    stage1.setScene(new Scene(root));
    }

    @FXML
    void func_startErrore(MouseEvent event) throws Exception{
        // -----------------cambio stage trovaErrore--------------------
        Stage stage1 = (Stage) btn_startErrore.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/RegoleErrore.fxml"));
        Parent root = loader.load();
        stage1.setScene(new Scene(root));
    }

    @FXML
    void func_startMultiplo(MouseEvent event)throws Exception {
 // -----------------cambio stage Ris Multiple--------------------
    Stage stage1 = (Stage) btn_startMultiple.getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/home.fxml"));
    Parent root = loader.load();
    stage1.setScene(new Scene(root));
    }

    @FXML
    void func_startRiordina(MouseEvent event) throws Exception{
        // -----------------cambio stage Riordinamento--------------------
        Stage stage1 = (Stage) btn_startRiordinamento.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/home.fxml"));
        Parent root = loader.load();
        stage1.setScene(new Scene(root));
    }

    @FXML
    void func_startVF(MouseEvent event) throws Exception{
        // -----------------cambio stage trovaErrore--------------------
        Stage stage1 = (Stage) btn_startVF.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/home.fxml"));
        Parent root = loader.load();
        stage1.setScene(new Scene(root));
    }

}
