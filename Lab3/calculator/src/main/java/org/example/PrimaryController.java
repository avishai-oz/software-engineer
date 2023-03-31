/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

package org.example;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="A_Btn"
    private Button A_Btn; // Value injected by FXMLLoader


    @FXML // fx:id="B_Btn"
    private Button B_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="C_Btn"
    private Button C_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="D_Btn"
    private Button D_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="Div_Btn"
    private Button Div_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="E_Btn"
    private Button E_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="Eight_Btn"
    private Button Eight_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="Equal_Btn"
    private Button Equal_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="F_Btn"
    private Button F_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="Five_Btn"
    private Button Five_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="Four_Btn"
    private Button Four_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="Minus_Btn"
    private Button Minus_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="Mul_Btn"
    private Button Mul_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="Nine_Btn"
    private Button Nine_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="One_Btn"
    private Button One_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="Plus_Btn"
    private Button Plus_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="Screen"
    private TextField Screen; // Value injected by FXMLLoader

    @FXML // fx:id="Seven_Btn"
    private Button Seven_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="Six_Btn"
    private Button Six_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="Two_Btn"
    private Button Two_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="Zero_Btn"
    private Button Zero_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="clear_Btn"
    private Button clear_Btn; // Value injected by FXMLLoader

    @FXML // fx:id="listBox"
    private ComboBox<String> listBox; // Value injected by FXMLLoader

    @FXML // fx:id="three_Btn"
    private Button Three_Btn; // Value injected by FXMLLoader

    private List<Button> buttonList;

    @FXML
    void chooseFromList(ActionEvent event) {
        if (listBox.getValue().equals("BIN")) {
            for (int i = 0; i < buttonList.size(); i++) {
                buttonList.get(i).setDisable(i >= 2);
            }
        } else if (listBox.getValue().equals("OCT")) {
            for (int i = 0; i < buttonList.size(); i++) {
                buttonList.get(i).setDisable(i >= 8);
            }
        } else if (listBox.getValue().equals("DEC")) {
            for (int i = 0; i < buttonList.size(); i++) {
                buttonList.get(i).setDisable(i >= 10);
            }
        } else if (listBox.getValue().equals("HEX")) {
            for (Button button : buttonList) {
                button.setDisable(false);
            }
        } else {

        }
    }
    @FXML
    void push(ActionEvent event) {
        Button num = (Button) event.getTarget(); // which button pressed

        if (num.getText().equals("Clear")){ //which spacial button
           Screen.clear();
        }
        else if(num.getText() == "="){
            int j=0;
            String expr = Screen.getText();
            int base;
            if (listBox.equals("Bin")){ //which base
                base = 2;
            }
            else if(listBox.equals("OCT")){
                base = 8;
            }
            else if(listBox.equals("DEC")){
                base = 10;
            }
            else if(listBox.equals("HEX")){
                base = 16;
            }
            for(int i=0; i<expr.length(); i++){
                char temp = expr.charAt(i);
                if (temp == '+' || temp == '-' || temp == '*' || temp == '/'){
                    if(i == j){
                        //System.out.println("Error: invalid expression: \"\"");
                        Screen.setText("Error: invalid expression:");
                        //return "-1";
                    }
                    String tempStr = expr.substring(j,i).trim();
                    try{
                        Integer.parseInt(tempStr, base);
                    }catch (NumberFormatException e) {
                        String baseCharset = charset.substring(0,base);
                        for(int index=0; index<tempStr.length(); index++){
                            if(baseCharset.indexOf(tempStr.charAt(index)) == -1){
                                System.out.println("Error: invalid expression: \"" + tempStr.charAt(index) + "\"");
                                return "-1";
                            }
                        }
                        System.out.println("Error: invalid expression: \"\"");
                        return "-1";
                    }
                    j = i+1;
                    list.add(tempStr);
                    list.add(temp + "");
                }
            }
        }
        else {
            Screen.setText(Screen.getText() + num.getText());
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert A_Btn != null : "fx:id=\"A_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert B_Btn != null : "fx:id=\"B_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert C_Btn != null : "fx:id=\"C_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert D_Btn != null : "fx:id=\"D_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert Div_Btn != null : "fx:id=\"Div_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert E_Btn != null : "fx:id=\"E_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert Eight_Btn != null : "fx:id=\"Eight_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert Equal_Btn != null : "fx:id=\"Equal_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert F_Btn != null : "fx:id=\"F_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert Five_Btn != null : "fx:id=\"Five_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert Four_Btn != null : "fx:id=\"Four_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert Minus_Btn != null : "fx:id=\"Minus_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert Mul_Btn != null : "fx:id=\"Mul_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert Nine_Btn != null : "fx:id=\"Nine_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert One_Btn != null : "fx:id=\"One_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert Plus_Btn != null : "fx:id=\"Plus_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert Screen != null : "fx:id=\"Screen\" was not injected: check your FXML file 'primary.fxml'.";
        assert Seven_Btn != null : "fx:id=\"Seven_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert Six_Btn != null : "fx:id=\"Six_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert Two_Btn != null : "fx:id=\"Two_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert Zero_Btn != null : "fx:id=\"Zero_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert clear_Btn != null : "fx:id=\"clear_Btn\" was not injected: check your FXML file 'primary.fxml'.";
        assert listBox != null : "fx:id=\"listBox\" was not injected: check your FXML file 'primary.fxml'.";
        assert Three_Btn != null : "fx:id=\"three_Btn\" was not injected: check your FXML file 'primary.fxml'.";

        listBox.getItems().add("BIN");
        listBox.getItems().add("OCT");
        listBox.getItems().add("DEC");
        listBox.getItems().add("HEX");

        buttonList = new ArrayList<>();

        buttonList.add(Zero_Btn);
        buttonList.add(One_Btn);
        buttonList.add(Two_Btn);
        buttonList.add(Three_Btn);
        buttonList.add(Four_Btn);
        buttonList.add(Five_Btn);
        buttonList.add(Six_Btn);
        buttonList.add(Seven_Btn);
        buttonList.add(Eight_Btn);
        buttonList.add(Nine_Btn);
        buttonList.add(A_Btn);
        buttonList.add(B_Btn);
        buttonList.add(C_Btn);
        buttonList.add(D_Btn);
        buttonList.add(E_Btn);
        buttonList.add(F_Btn);

    }

}
