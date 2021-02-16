package kp.calc.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CalcController {

    @FXML
    private Label calculations;

    public void onMouseClick(MouseEvent mouseEvent) {

        Button button = (Button) mouseEvent.getSource();
        String number = button.getText();

        insertNumber(number);
    }

    public void insertNumber (String number){
        calculations.setText(calculations.getText() + number);

    }
}
