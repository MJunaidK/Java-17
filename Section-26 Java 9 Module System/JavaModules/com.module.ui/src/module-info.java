module com.module.ui {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.module.db;
    requires javafx.swt;

    exports com.module.ui to javafx.graphics;
    opens com.module.ui to javafx.fxml;
}