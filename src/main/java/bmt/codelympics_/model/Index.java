package bmt.codelympics_.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Index extends Application {

    SalvaDimensioni salvaDimensioni = SalvaDimensioni.getInstance();

    @Override
    public void start(Stage Home) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/home/home.fxml"));
        Parent root = loader.load();
        Home.setTitle("CODELYMPICS");

        Double[] dimensions = new Double[] { 870.0, 600.0 };
        /*
         * if (dimensions[0] == null || dimensions[1] == null) {
         * // Se le dimensioni non sono valide, usa valori predefiniti
         * dimensions = new Double[]{850.0, 500.0};
         * }
         */

        Home.setScene(new Scene(root, dimensions[0], dimensions[1]));
        Home.show();
        Home.setOnCloseRequest(event -> salvaDimensioni.setArray(new Double[] { Home.getWidth(), Home.getHeight() }));
    }

    public static void main(String[] args) {
        launch();
    }
}
