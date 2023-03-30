/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML // fx:id="helloBtn"
    private Button helloBtn; // Value injected by FXMLLoader

    @FXML // fx:id="helloTF"
    private TextField helloTF; // Value injected by FXMLLoader

    @FXML
    void sayHello(ActionEvent event) {
        helloTF.setText("Hello World!");
    }

}
