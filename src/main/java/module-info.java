module com.example.f21comp1011gcw2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.f21comp1011gcw2 to javafx.fxml;
    exports com.example.f21comp1011gcw2;
}