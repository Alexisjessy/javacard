module fr.afpa {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive com.fasterxml.jackson.databind;
    requires transitive com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires javafx.base;

    opens fr.afpa to javafx.fxml, com.fasterxml.jackson.databind;
    exports fr.afpa;
}
