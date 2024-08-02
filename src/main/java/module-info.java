module bmt.codelympics_ {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens bmt.codelympics_ to javafx.fxml;
    exports bmt.codelympics_;
    exports bmt.codelympics_.controller.homes;
    opens bmt.codelympics_.controller.homes to javafx.fxml;
    exports bmt.codelympics_.controller.log;
    opens bmt.codelympics_.controller.log to javafx.fxml;
    exports bmt.codelympics_.controller.utility;
    opens bmt.codelympics_.controller.utility to javafx.fxml;
    exports bmt.codelympics_.controller.regole;
    opens bmt.codelympics_.controller.regole to javafx.fxml;
}