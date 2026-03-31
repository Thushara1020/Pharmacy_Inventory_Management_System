Pharmacy Inventory Management System - Quick Setup (macOS)

This README contains quick commands to set up your development environment, build, and run the JavaFX application on macOS (zsh).

Prerequisites
- Homebrew (optional, helpful for installing OpenJDK and Maven)

Install Homebrew (if missing):
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

Install OpenJDK 22 and Maven (recommended):
brew install openjdk@22
brew install maven

Add OpenJDK 22 to your PATH and set JAVA_HOME (zsh):
echo 'export PATH="$(brew --prefix openjdk@22)/bin:$PATH"' >> ~/.zshrc
echo 'export JAVA_HOME="$(/usr/libexec/java_home -v22)"' >> ~/.zshrc
source ~/.zshrc

Verify tools:
java -version
javac -version
mvn -v

Build the project:
cd "$(pwd)"
mvn clean compile

Run the application (if javafx plugin configured):
mvn javafx:run

If you don't have javafx plugin configured, run with the main class:
mvn exec:java -Dexec.mainClass=Starter

Notes:
- Database configuration is read from src/main/resources/config.properties. If not configured, the app will attempt to connect to a local MySQL instance using defaults.
- If you run into resource loading errors, ensure resources are located under src/main/resources and paths (e.g. /view/login.fxml) are correct and case sensitive.

Contact: maintainers

