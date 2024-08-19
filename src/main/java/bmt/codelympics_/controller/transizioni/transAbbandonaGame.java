package  bmt.codelympics_.controller.transizioni;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.DataSingleton;
import bmt.codelympics_.model.Time;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class transAbbandonaGame extends ChangeStage{

    @FXML
    private Button btn_AnnullaConferma;

    @FXML
    private Button btn_Conferma;

    DataSingleton data = DataSingleton.getInstance();
    Time time = Time.getInstance();

    @FXML
    void func_AnnullaConferma(MouseEvent event) throws Exception{

      //  if(data.getnumMacroEsercizio()<20) {
            // -----------------cambio stage esercizio Multipla--------------------
            fuc_changeStage(btn_AnnullaConferma, "/bmt/codelympics_/fxml/esercizi/EsRispMult.fxml");
      //  }else if(data.getnumMacroEsercizio()<30){
            // -----------------cambio stage esercizio VF--------------------
      /*      fuc_changeStage(btn_AnnullaConferma, "/bmt/codelympics_/fxml/esercizi/EsVF.fxml");
        }else if(data.getnumMacroEsercizio()<40){
            // -----------------cambio stage esercizioTrovaErrore--------------------
            fuc_changeStage(btn_AnnullaConferma, "/bmt/codelympics_/fxml/esercizi/EsErrore.fxml");
        }else {
            // -----------------cambio stage esercizio Ordine--------------------
            fuc_changeStage(btn_AnnullaConferma, "/bmt/codelympics_/fxml/esercizi/EsOrdinamento.fxml");
        }*/
    }

    @FXML
    void func_Conferma(MouseEvent event) throws Exception{
        time.setTime("0:0:0");
       data.setNumEsercizio(0);
       data.setValue(0);
        System.out.println(data.getNumEsercizio());
        // -----------------cambio stage gamesHome--------------------
        fuc_changeStage(btn_Conferma, "/bmt/codelympics_/fxml/gamesHome/playGames.fxml");
    }

}
