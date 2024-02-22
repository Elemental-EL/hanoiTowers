module org.example.hanoitowers {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.hanoitowers to javafx.fxml;
    exports org.example.hanoitowers;
}