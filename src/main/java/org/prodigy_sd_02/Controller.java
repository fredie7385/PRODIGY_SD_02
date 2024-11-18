package org.prodigy_sd_02;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {
    @FXML
    private TextField textFieldAddNumber;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnTryAgain;

    @FXML
    private Label labelHint;

    @FXML
    private Label labelCounter;

    @FXML
    private ComboBox selectLevel;

    private int randomNumber;
    private int attempts;

    @FXML
    public void initialize() {
        // Initialize the game with default settings
        attempts = 0;
        labelCounter.setText("Select a level to start.");
        labelHint.setText("Hint: Please select a level.");
        btnTryAgain.setDisable(true);
    }

    @FXML
    public void handleLevelSelection() {
        String selectedLevel = (String) selectLevel.getValue();
        switch (selectedLevel) {
            case "Easy":
                attempts = 15;
                randomNumber = new Random().nextInt(50) + 1;
                break;
            case "Medium":
                attempts = 10;
                randomNumber = new Random().nextInt(100) + 1;
                break;
            case "Hard":
                attempts = 5;
                randomNumber = new Random().nextInt(100) + 1;
                break;
            default:
                return;
        }
        labelCounter.setText("Attempts remaining: " + attempts);
        labelHint.setText("Hint: Start guessing!");
        btnTryAgain.setDisable(true);
        textFieldAddNumber.clear();
        btnSubmit.setDisable(false);
    }

    @FXML
    private void handleSubmit() {
        String input = textFieldAddNumber.getText();
        try {
            int guessedNumber = Integer.parseInt(input);
            attempts--;
            labelCounter.setText("Attempts remaining: " + attempts);

            if (guessedNumber < 1 || guessedNumber > 100) {
                labelHint.setText("Guess a number between 1 and 100.");
            } else if (guessedNumber < randomNumber) {
                labelHint.setText("sorry, Too low! Try again.");
            } else if (guessedNumber > randomNumber) {
                labelHint.setText("Sorry, Too high! Try again.");
            } else {
                labelHint.setText("Congratulations! You guessed it right!");
                btnSubmit.setDisable(true);
                btnTryAgain.setDisable(false);
            }


            if (attempts <= 0) {
                labelHint.setText("Game Over! The number was: " + randomNumber);
                btnSubmit.setDisable(true);
                btnTryAgain.setDisable(false);
            }
        } catch (NumberFormatException e) {
            labelHint.setText("Invalid input! Please enter a number.");
        }

        textFieldAddNumber.clear();
    }

    @FXML
    private void handleTryAgain() {
        String selectedLevel = (String) selectLevel.getValue();
        if (selectedLevel == null) {
            labelHint.setText("Please select a level first.");
            return;
        }

        switch (selectedLevel) {
            case "Easy":
                attempts = 15;
                randomNumber = new Random().nextInt(100) + 1;
                break;
            case "Medium":
                attempts = 10;
                randomNumber = new Random().nextInt(100) + 1;
                break;
            case "Hard":
                attempts = 5;
                randomNumber = new Random().nextInt(100) + 1;
                break;
            default:
                return;
        }
        labelCounter.setText("Attempts remaining: " + attempts);
        labelHint.setText("Hint: Input Any Number");
        textFieldAddNumber.clear();
        btnSubmit.setDisable(false);
        btnTryAgain.setDisable(true);
    }

    @FXML
    private void handleExit() {
        Platform.exit();
        System.exit(0);
    }
}