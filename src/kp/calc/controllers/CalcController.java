package kp.calc.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CalcController {

    @FXML
    private Label calculations;

    @FXML
    private Label result;

    String operationType;

    public void onMouseClick(MouseEvent mouseEvent) {

        Button button = (Button) mouseEvent.getSource();
        String buttonText = button.getText();

        switch (buttonText){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                insertNumber(buttonText);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                insertOperator(buttonText);

                break;
            case "Clear":
                clear();
                break;
            case "del":
            case "=":
                double result = changeString.evaluate(this.getCalculations().getText());
                setResult(String.valueOf(result));


        }


    }

    public void insertNumber (String number){

        calculations.setText(calculations.getText() + number);

    }

    public void insertOperator (String operator){

        calculations.setText(calculations.getText() + " " + operator + " ");
    }

    public void clear ()
    {
        calculations.setText(" ");
    }

    public Label getCalculations(){
    return calculations ;
    }

    public Label getResult(){
        return result;
    }

    public void setResult(String newResult){
        this.result.setText("=" + newResult);
    }


}
