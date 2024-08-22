package bmt.codelympics_.controller.homes;

import bmt.codelympics_.model.ChangeStage;
import bmt.codelympics_.model.SalvaDimensioni;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home extends ChangeStage implements Initializable {

    @FXML
    private Button btn_accedi;

    @FXML
    private Button btn_iscriviti;

    @FXML
    void func_accedi(MouseEvent event) throws Exception {

        // -----------------cambio stage accedi--------------------
        fuc_changeStage(btn_accedi, "/bmt/codelympics_/fxml/log/accedi.fxml");

    }

    @FXML
    void func_iscriviti(MouseEvent event) throws Exception {
        // -----------------cambio stage iscriviti--------------------
        fuc_changeStage(btn_iscriviti, "/bmt/codelympics_/fxml/log/iscriviti.fxml");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // String directoryPath =System.getProperty("user.home") +
        // "/playproj/props.csv";
        String directoryPath = System.getProperty("user.home") + "\\playproj";
        String filePath = directoryPath+"\\props.csv";

       // String directoryPath = "C:\\playproj";
       // String filePath = directoryPath + "\\props.csv";

        // Crea la cartella se non esiste
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Crea il file CSV se non esiste
        File file = new File(filePath);
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                // Scrivi l'intestazione del CSV (ad esempio, se serve)
                writer.append(
                        "ale,f7a3803365a55b197a3b43bc64aacc13,ale,0xffffffff,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n");
                writer.append(
                        ",d41d8cd98f00b204e9800998ecf8427e,,0xffffffff,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n");
                writer.append(
                        "OlympicFlame, d02bebfbff8ae05e612af49ad0f1d4b5, OlympicFlame, #FF0000, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0\n");
                writer.append(
                        "GoldMedalist, 8c793e43b67731c27f4b2a30a97f4bb0, GoldMedalist, #FFFF00, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0\n");
                writer.append(
                        "OlympicFlame, d02bebfbff8ae05e612af49ad0f1d4b5, OlympicFlame, #FF0000, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0\n");
                writer.append(
                        "VictoryPodium, 20ea8bd14888fdf0d985c22846ed3356, VictoryPodium, #00FF00, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0\n");
                writer.append(
                        "TorchBearer, 797e5013d5a5ea46fe94d7f910d96fe4, TorchBearer, #FFB380, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0\n");
                writer.append(
                        "RingChampion, 8158e10ab6171faa3bfb4b196caf41a3, RingChampion, #99CCCC, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0\n");
                writer.append(
                        "MarathonMaster, fd895a176530426787cdda0c6577bf40, MarathonMaster, #000000, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0\n");
                writer.append(
                        "SprintKing, f56000d36deaca1e2d76e87c3a5682d0, SprintKing, #0000FF, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0\n");
                writer.append(
                        "MedalChaser, 671f3c423178ff6bbe2da9097b638cc6, MedalChaser, #00FFFF, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0\n");
                writer.append(
                        "DecathlonHero, 46bfb0bdc6c315211a098a987600d4ab, DecathlonHero, #4D8080, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0\n");
                writer.append(
                        "OlympusRival, cb9dec095870401bdad2b97e4da4597f, OlympusRival, #FF00FF, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
