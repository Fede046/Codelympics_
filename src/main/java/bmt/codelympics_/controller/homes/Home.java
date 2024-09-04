package bmt.codelympics_.controller.homes;

// Import delle classi necessarie da altri pacchetti e librerie
import bmt.codelympics_.model.ChangeStage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Classe che estende ChangeStage e implementa Initializable, utilizzata per controllare la finestra "Home"
public class Home extends ChangeStage implements Initializable {

    @FXML
    private Button btn_accedi; // Bottone per l'accesso

    @FXML
    private Button btn_iscriviti; // Bottone per l'iscrizione

    // Metodo chiamato quando il bottone "Accedi" viene cliccato
    @FXML
    void func_accedi(MouseEvent event) throws Exception {
        // Cambia lo stage all'interfaccia di login (accedi.fxml)
        fuc_changeStage(btn_accedi, "/bmt/codelympics_/fxml/log/accedi.fxml");
    }

    // Metodo chiamato quando il bottone "Iscriviti" viene cliccato
    @FXML
    void func_iscriviti(MouseEvent event) throws Exception {
        // Cambia lo stage all'interfaccia di iscrizione (iscriviti.fxml)
        fuc_changeStage(btn_iscriviti, "/bmt/codelympics_/fxml/log/iscriviti.fxml");
    }

    // Metodo initialize, chiamato automaticamente alla creazione del controller
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Percorso della cartella utente dove verrà salvato il file
        String directoryPath = System.getProperty("user.home") +  File.separator+"playproj";
        // Percorso completo del file CSV
        String filePath = directoryPath + "\\props.csv";

        // Crea la cartella se non esiste
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs(); // Crea la cartella
        }

        // Crea il file CSV se non esiste
        File file = new File(filePath);
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                // Scrivi delle righe predefinite nel file CSV
                writer.append(
                        "ale,f7a3803365a55b197a3b43bc64aacc13,ale,0xffffffff,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n");
                writer.append(
                        ",d41d8cd98f00b204e9800998ecf8427e,,0xffffffff,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n");
                writer.append(
                        "OlympicFlame,d02bebfbff8ae05e612af49ad0f1d4b5, OlympicFlame,#800080,4,5,2,791,903,374,5,2,0,981,398,0,5,2,0,964,313,0,5,4,2,974,729,312\n");
                writer.append(
                        "GoldMedalist, 8c793e43b67731c27f4b2a30a97f4bb0, GoldMedalist,#FFFF00,2,0,0,347,0,0,5,4,3,987,770,547,2,0,0,336,0,0,4,4,4,738,723,725\n");
                writer.append(
                        "OlympicFlame, d02bebfbff8ae05e612af49ad0f1d4b5, OlympicFlame,#FF0000,2,0,0,386,0,0,4,4,3,705,734,561,3,3,4,531,569,740,2,0,0,375,0,0\n");
                writer.append(
                        "VictoryPodium, 20ea8bd14888fdf0d985c22846ed3356, VictoryPodium,#00FF00,5,3,5,903,522,913,4,5,3,778,954,568,3,2,0,534,334,0,5,2,0,999,380,0\n");
                writer.append(
                        "TorchBearer, 797e5013d5a5ea46fe94d7f910d96fe4, TorchBearer,#FFB380,2,0,0,327,0,0,2,0,0,314,0,0,5,4,4,905,753,786,3,2,0,524,312,0,\n");
                writer.append(
                        "RingChampion, 8158e10ab6171faa3bfb4b196caf41a3, RingChampion,#99CCCC,4,3,2,726,531,329,2,0,0,384,0,0,2,0,0,350,0,0,2,0,0,334,0,0\n");
                writer.append(
                        "MarathonMaster, fd895a176530426787cdda0c6577bf40, MarathonMaster,#000000,4,2,0,738,337,0,4,4,4,781,771,778,3,4,2,536,782,323,2,0,0,368,0,0\n");
                writer.append(
                        "SprintKing, f56000d36deaca1e2d76e87c3a5682d0, SprintKing,#0000FF,3,3,2,519,587,364,3,4,4,569,751,706,2,0,0,392,0,0,2,0,0,371,0,0\n");
                writer.append(
                        "MedalChaser, 671f3c423178ff6bbe2da9097b638cc6, MedalChaser,#00FFFF,3,3,4,593,594,771,3,4,3,588,778,549,2,0,0,319,0,0,4,3,4,783,584,713\n");
                writer.append(
                        "DecathlonHero, 46bfb0bdc6c315211a098a987600d4ab, DecathlonHero,#4D8080,2,0,0,380,0,0,2,0,0,381,0,0,4,2,0,785,357,0,5,5,5,958,924,976\n");
                writer.append(
                        "OlympusRival, cb9dec095870401bdad2b97e4da4597f, OlympusRival,#FF00FF,2,0,0,314,0,0,2,0,0,333,0,0,5,4,3,932,727,528,4,3,2,743,580,396\n");
            } catch (IOException e) {
                e.printStackTrace(); // Stampa lo stack trace in caso di errore
            }
        }
    }
}
