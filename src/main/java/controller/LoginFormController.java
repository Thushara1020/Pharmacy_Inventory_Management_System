package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private Button btnLogin;

    @FXML
    private Hyperlink btnforgot;

    @FXML
    private Hyperlink btnsignup;

    @FXML
    private CheckBox chkRemember;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnForgotpasswordActiton(ActionEvent event) {

    }

    @FXML
    void btnLoginAction(ActionEvent event) {
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        if (email.equals("thushara@gmail.com") && password.equals("1234")) {
            // Proceed to dashboard
            try {
            Stage stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/login.fxml")));
            stage.setScene(scene);
            stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
                showError("Error loading dashboard.fxml");
            }
            txtEmail.clear();
            txtPassword.clear();
        } else {
            showError("Invalid Email or Password");
            txtEmail.clear();
            txtPassword.clear();
        }

    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void btnSingUpAction(ActionEvent event) {

    }

}
