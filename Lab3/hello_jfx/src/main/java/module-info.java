module example.com {
    requires javafx.controls;
    requires javafx.fxml;

    opens example.com to javafx.fxml;
    exports example.com;
}
