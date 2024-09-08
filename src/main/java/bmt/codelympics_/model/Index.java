package bmt.codelympics_.model;

// Import delle classi necessarie da JavaFX e dalle librerie Java standard
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

// Definizione della classe principale dell'applicazione, che estende Application di JavaFX
public class Index extends Application {

    // Dichiarazione di un'istanza di SalvaDimensioni usando il pattern Singleton
    SalvaDimensioni salvaDimensioni = SalvaDimensioni.getInstance();

    // Metodo principale che viene chiamato quando l'applicazione JavaFX viene avviata
    @Override
    public void start(Stage Home) throws IOException {
        // Carica l'interfaccia utente definita nel file FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/home/home.fxml"));
        Parent root = loader.load(); // Carica il file FXML e crea la struttura della GUI
        Home.setTitle("CODELYMPICS"); // Imposta il titolo della finestra principale

        // Definizione delle dimensioni iniziali della finestra
        Double[] dimensions = new Double[] { 900.0, 600.0 };
        // Imposta la scena principale della finestra con le dimensioni specificate
        Home.setScene(new Scene(root, dimensions[0], dimensions[1]));
        Home.show(); // Mostra la finestra principale

        // Registra un listener per l'evento di chiusura della finestra
        // Quando la finestra viene chiusa, salva le dimensioni correnti
        salvaDimensioni.setScermoIntero(Home.isFullScreen());
        Home.setOnCloseRequest(event -> salvaDimensioni.setArray(new Double[] { Home.getWidth(), Home.getHeight() }));
    }

    // Metodo main dell'applicazione, punto di ingresso del programma
    public static void main(String[] args) {
        launch(); // Metodo statico per avviare l'applicazione JavaFX
    }
}

