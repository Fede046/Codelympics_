module bmt.codelympics_ {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens bmt.codelympics_ to javafx.fxml;
    exports bmt.codelympics_;
    exports bmt.codelympics_.controller;
    opens bmt.codelympics_.controller to javafx.fxml;
}