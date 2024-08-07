package bmt.codelympics_.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChangeStage {

    SalvaDimensioni salvaDimensioni = SalvaDimensioni.getInstance();

    public void fuc_changeStage(Button bottone, String resource) throws Exception {
        Stage stage1 = (Stage) bottone.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        Parent root = loader.load();

        Double[] dimensions = salvaDimensioni.getArray();
        if (dimensions[0] == null || dimensions[1] == null) {
            // Se le dimensioni non sono valide, usa valori predefiniti
            dimensions = new Double[] { 870.0, 600.0 };
        }

        // Store the current width and height of the stage
        double width = stage1.getWidth();
        double height = stage1.getHeight();

        stage1.setScene(new Scene(root, width, height));

        stage1.setOnCloseRequest(
                event -> salvaDimensioni.setArray(new Double[] { width, height }));
    }
}
