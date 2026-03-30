package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    private static final String ADMIN_EMAIL = "Admin";
    private static final String ADMIN_PASSWORD = "1234";

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
        showInfo("Forgot Password", "Password recovery is not implemented yet.");
    }

    @FXML
    void btnLoginAction(ActionEvent event) {
        String email = txtEmail.getText() == null ? "" : txtEmail.getText().trim();
        String password = txtPassword.getText() == null ? "" : txtPassword.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showError("Please enter both email and password.");
            return;
        }

        if (isValidCredentials(email, password)) {
            loadDashboard(event);
            txtEmail.clear();
            txtPassword.clear();
        } else {
            showError("Invalid email or password.");
            txtPassword.clear();
        }
    }

    @FXML
    void btnSingUpAction(ActionEvent event) {
        showInfo("Sign Up", "Sign up is not implemented yet.");
    }

    @FXML
    void btnGuestLoginAction(ActionEvent event) {
        loadDashboard(event);
    }

    private boolean isValidCredentials(String email, String password) {
        return ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password);
    }

    private void loadDashboard(ActionEvent event) {
        URL resource = getClass().getResource("/view/dashboard.fxml");
        if (resource == null) {
            showError("Dashboard view was not found.");
            return;
        }

        try {
            Parent root = FXMLLoader.load(resource);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
        } catch (IOException e) {
            showError("Error loading dashboard.");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
