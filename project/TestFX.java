// TestFX.java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestFX extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("JavaFX works!");
        Scene scene = new Scene(new StackPane(label), 300, 200);
        stage.setScene(scene);
        stage.setTitle("Test JavaFX");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}