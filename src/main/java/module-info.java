module pl.lublin.wsei.java.cwiczenia.lab6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens pl.lublin.wsei.java.cwiczenia.lab6 to javafx.fxml;
    exports pl.lublin.wsei.java.cwiczenia.lab6;
    exports pl.lublin.wsei.java.cwiczenia.lab6.test;
    opens pl.lublin.wsei.java.cwiczenia.lab6.test to javafx.fxml;
}