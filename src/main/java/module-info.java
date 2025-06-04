module vue {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens vue to javafx.fxml;
    exports vue;
}