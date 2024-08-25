package bmt.codelympics_.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

// Classe per cambiare lo stage attuale dell'applicazione
public class ChangeStage {

    // Istanza della classe SalvaDimensioni per salvare le dimensioni della finestra
    SalvaDimensioni salvaDimensioni = SalvaDimensioni.getInstance();

    // Metodo per cambiare lo stage, accetta un bottone che ha scatenato l'evento e il percorso alla nuova risorsa FXML
    public void fuc_changeStage(Button bottone, String resource) throws Exception {
        // Ottiene l'attuale stage (finestra) a partire dal bottone
        Stage stage1 = (Stage) bottone.getScene().getWindow();

        // Carica la nuova risorsa FXML specificata
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        Parent root = loader.load();

        // Ottiene le dimensioni salvate dalla classe SalvaDimensioni
        Double[] dimensions = salvaDimensioni.getArray();
        if (dimensions[0] == null || dimensions[1] == null) {
            // Se le dimensioni salvate non sono valide, utilizza valori predefiniti
            dimensions = new Double[] { 870.0, 600.0 };
        }

        // Salva la larghezza e l'altezza corrente dello stage, con un piccolo aggiustamento
        double width = stage1.getWidth() - 16;
        double height = stage1.getHeight() - 39;

        // Imposta la nuova scena con il root caricato e le dimensioni calcolate
        stage1.setScene(new Scene(root, width, height));

        // Imposta un listener che salva le dimensioni della finestra quando viene chiusa
        stage1.setOnCloseRequest(
                event -> salvaDimensioni.setArray(new Double[] { width, height }));
    }
}
