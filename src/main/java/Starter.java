import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Starter extends Application {
    private static final Logger LOGGER = Logger.getLogger(Starter.class.getName());
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        URL resource = getClass().getResource("/view/login.fxml");
        if (resource == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Startup Error");
            alert.setHeaderText(null);
            alert.setContentText("Cannot find login.fxml resource. Make sure resources are packaged under /view.");
            alert.showAndWait();
            return;
        }

        try {
            Parent root = FXMLLoader.load(resource);
            stage.setScene(new Scene(root));
            stage.setTitle("Pharmacy Inventory - Login");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Startup Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to load the login view: " + e.getMessage());
            alert.showAndWait();
            LOGGER.log(Level.SEVERE, "Failed to load login view", e);
        }
    }
}
