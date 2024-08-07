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
            dimensions = new Double[]{850.0, 600.0};
        }

        stage1.setScene(new Scene(root, dimensions[0], dimensions[1]));

        stage1.setOnCloseRequest(event -> salvaDimensioni.setArray(new Double[]{stage1.getWidth(), stage1.getHeight()}));
    }
}
