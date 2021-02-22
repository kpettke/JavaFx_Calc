package kp.calc.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import kp.calc.Main;

import java.io.IOException;
import java.util.ArrayList;

public class CalcController {

    @FXML
    private Label calculations;

    @FXML
    private Label result;

    private ArrayList<String> calculationHistory = new ArrayList();


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
                int result = changeString.evaluate(this.getCalculations().getText());
                setResult(String.valueOf(result));
                addCalculation(this.getCalculations().getText(), String.valueOf(result));
                break;

            case "ANS":
                insertAns(getResult().getText().substring(1));
                break;

            case "Del":
                deleteLast();
                break;

            case "History":
                openHistoryWindow();
                break;

        }


    }

    public void insertNumber (String number){

        calculations.setText(calculations.getText() + number);

    }

    public void insertOperator (String operator){

        calculations.setText(calculations.getText() + " " + operator + " ");
    }

    public void clear () {
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

    public void insertAns(String ans){
        calculations.setText(calculations.getText() + ans);
    }

    public void deleteLast(){
        if (!getCalculations().getText().isEmpty()) {

            StringBuilder text = new StringBuilder(getCalculations().getText());
            text.deleteCharAt(text.length()-1);
            getCalculations().setText(text.toString());

        }
    }

    public void openHistoryWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/kp/calc/resources/history.fxml"));
            Parent root = loader.load();

            Main.getHistoryStage().setScene(new Scene(root));

           HistoryController historyController = loader.getController();
           historyController.initCalculations(calculationHistory);

            Main.getHistoryStage().show();

        }catch (IOException ex){
            System.out.println(ex);
        }
    }

    public void addCalculation(String calculation, String result){
        this.calculationHistory.add(calculation + "=" + result);
    }


}
