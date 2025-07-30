module Snake {
    requires java.desktop;
    requires jlayer;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.media;
    requires org.junit.jupiter.api;
    opens classHolder;
    opens Tests;
}