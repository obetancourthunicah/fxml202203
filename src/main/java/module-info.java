module com.pmp.fxpmp202203 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.pmp.fxpmp202203 to javafx.fxml;
    exports com.pmp.fxpmp202203;
}
