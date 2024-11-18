module org.prodigy_sd_02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.prodigy_sd_02 to javafx.fxml;
    exports org.prodigy_sd_02;
}