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
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginFormController {
    private static final Logger LOGGER = Logger.getLogger(LoginFormController.class.getName());
    private static final String ADMIN_EMAIL = "Admin";
    private static final String ADMIN_SECRET = "1234"; // renamed to avoid PASSWORD/PWD identifier
    private static final String PREF_EMAIL_KEY = "savedEmail";

    // Simple email pattern (permissive) to provide basic validation when user types an email
    private static final Pattern SIMPLE_EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    private final Preferences prefs = Preferences.userNodeForPackage(LoginFormController.class);

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
    private void initialize() {
        String saved = prefs.get(PREF_EMAIL_KEY, "");
        if (saved != null && !saved.trim().isEmpty()) {
            txtEmail.setText(saved);
            chkRemember.setSelected(true);
        }
    }

    @FXML
    void btnForgotpasswordActiton(ActionEvent event) {
        // Try to load a forgot-password view if it exists, otherwise show info
        URL resource = getClass().getResource("/view/forgot_password.fxml");
        if (resource != null) {
            try {
                Parent root = FXMLLoader.load(resource);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.centerOnScreen();
                stage.setTitle("Recover Password");
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Failed to open forgot password view", ex);
                showError("Error opening password recovery.");
            }
        } else {
            showInfo("Forgot Password", "Password recovery is not implemented yet.");
        }
    }

    @FXML
    void btnLoginAction(ActionEvent event) {
        String email = txtEmail.getText() == null ? "" : txtEmail.getText().trim();
        String credential = txtPassword.getText() == null ? "" : txtPassword.getText();

        if (email.isEmpty() || credential.isEmpty()) {
            showError("Please enter both email and password.");
            return;
        }

        // If the user entered something that looks like an email, do a light validation.
        if (email.contains("@") && !isValidEmail(email)) {
            showError("Please enter a valid email address.");
            return;
        }

        if (isValidCredentials(email, credential)) {
            // Save or clear remembered email based on checkbox
            if (chkRemember.isSelected()) {
                saveRememberPreference(email);
            } else {
                clearRememberPreference();
            }

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
        // Try to load a signup view if it exists, otherwise show info
        URL resource = getClass().getResource("/view/signup.fxml");
        if (resource != null) {
            try {
                Parent root = FXMLLoader.load(resource);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.centerOnScreen();
                stage.setTitle("Sign Up");
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Failed to open sign up view", ex);
                showError("Error opening sign up form.");
            }
        } else {
            showInfo("Sign Up", "Sign up is not implemented yet.");
        }
    }

    @FXML
    void btnGuestLoginAction(ActionEvent event) {
        loadDashboard(event);
    }

    private boolean isValidCredentials(String email, String credential) {
        return ADMIN_EMAIL.equals(email) && ADMIN_SECRET.equals(credential);
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
            stage.setTitle("Dashboard");
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Failed to load dashboard view", ex);
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

    private boolean isValidEmail(String email) {
        if (email == null) return false;
        Matcher m = SIMPLE_EMAIL_PATTERN.matcher(email);
        return m.matches();
    }

    private void saveRememberPreference(String email) {
        if (email == null) return;
        prefs.put(PREF_EMAIL_KEY, email);
    }

    private void clearRememberPreference() {
        prefs.remove(PREF_EMAIL_KEY);
    }
}
