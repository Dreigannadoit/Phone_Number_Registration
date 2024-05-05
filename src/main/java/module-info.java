module org.example.phone_numer_register {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.phone_numer_register to javafx.fxml;
    exports org.example.phone_numer_register;
}