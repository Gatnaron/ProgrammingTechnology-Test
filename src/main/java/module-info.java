module com.example.programmingtechnologytest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.programmingtechnologytest to javafx.fxml;
    exports com.example.programmingtechnologytest;
}