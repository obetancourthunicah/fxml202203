module com.pmp.fxpmp202203 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    

    opens com.pmp.fxpmp202203 to javafx.fxml;
    opens com.pmp.fxpmp202203.dao to javafx.base;
    exports com.pmp.fxpmp202203;
}
