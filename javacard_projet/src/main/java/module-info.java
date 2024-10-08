module fr.afpa {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive com.fasterxml.jackson.databind;
    requires transitive com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires javafx.base;
    requires java.desktop;
    requires transitive java.sql;

    opens fr.afpa to javafx.fxml, com.fasterxml.jackson.databind, javafx.base, java.desktop, java.sql;
    exports fr.afpa;
}
