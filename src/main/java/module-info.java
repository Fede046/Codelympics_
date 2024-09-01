module bmt.codelympics_ {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    requires com.opencsv;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;

    exports bmt.codelympics_.controller.homes;
    opens bmt.codelympics_.controller.homes to javafx.fxml;
    exports bmt.codelympics_.controller.log;
    opens bmt.codelympics_.controller.log to javafx.fxml;
    exports bmt.codelympics_.controller.regole;
    opens bmt.codelympics_.controller.regole to javafx.fxml;
    exports bmt.codelympics_.model;
    opens bmt.codelympics_.model to javafx.fxml;

    exports bmt.codelympics_.controller.esercizi;
    opens bmt.codelympics_.controller.esercizi to javafx.fxml;
    exports bmt.codelympics_.controller.transizioni;
    opens bmt.codelympics_.controller.transizioni to javafx.fxml;
    exports bmt.codelympics_;
    opens bmt.codelympics_ to javafx.fxml;
}