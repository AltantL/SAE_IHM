module com.example.sae_2012 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.sae_2012 to javafx.fxml;
    exports com.example.sae_2012;
}