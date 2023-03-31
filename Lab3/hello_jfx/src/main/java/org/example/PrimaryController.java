/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML // fx:id="ctrTF"
    private TextField ctrTF; // Value injected by FXMLLoader

    @FXML // fx:id="helloBtn"
    private Button helloBtn; // Value injected by FXMLLoader

    @FXML // fx:id="helloTF"
    private TextField helloTF; // Value injected by FXMLLoader

    @FXML
    public void initialize() {
        // Set the initial value of ctrTF to zero
        ctrTF.setText("0");
    }
    @FXML
    void sayHello(ActionEvent event) {
        int ctr = Integer.parseInt(ctrTF.getText());
        if (ctr % 2 == 0){
            helloTF.setText("Hello Word!");
        }
        else {
            helloTF.setText("");
        }
        ctrTF.setText(Integer.toString((++ctr)));
    }

}
