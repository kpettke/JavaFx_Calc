package kp.calc.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;


public class HistoryController {

    @FXML
    private ListView historyList;

    public void  initCalculations(ArrayList<String> calculationHistory){
        calculationHistory.forEach((calculation)-> {
            historyList.getItems().add(calculation);
        } );

    }


}
