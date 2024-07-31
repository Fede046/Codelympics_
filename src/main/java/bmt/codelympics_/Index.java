package bmt.codelympics_;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Index extends Application {
    @Override
    public void start(Stage Home) throws IOException {
        FXMLLoader loader = new FXMLLoader((getClass().getResource("fxml/home.fxml")));
        Parent root = loader.load();
        Home.setTitle(STYLESHEET_CASPIAN);
        Home.setScene(new Scene(root));
        Home.show();
    }

    public static void main(String[] args) {
        launch();
    }
}