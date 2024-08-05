package bmt.codelympics_.controller.homes;

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
        String directoryPath = "C:\\playproj";
        String filePath = directoryPath + "\\props.csv";

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
                writer.append("ale,f7a3803365a55b197a3b43bc64aacc13,ale,0xffffffff\n");
                // Scrivi i dati iniziali (se necessario)
                writer.append(",d41d8cd98f00b204e9800998ecf8427e,,0xffffffff\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
