package HanYo;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiController {

    @FXML
    private Button btn_pantA;

    @FXML
    private Button btn_pantB;

    @FXML
    private Button btn_pantC;

    @FXML
    private Button btn_CreateDB;

    @FXML
    private Button btn_getPant;

    @FXML
    private Label lbl_kronarz;


    @FXML
    private void handleButtonAction(ActionEvent e) {

        //Man ligger en ting ind med Pant A.
        if (e.getSource()==btn_pantA){
            System.out.println("Pant A");

        }

        //Man ligger en ting ind med Pant B.
        if (e.getSource()==btn_pantB){
            System.out.println("Pant B");
        }

        //Man ligger en ting ind med Pant C.
        if (e.getSource()==btn_pantC){
            System.out.println("Pant C");
        }


        //Printer total i danske donalders aka. pant
        if (e.getSource()==btn_getPant){
            System.out.println("Getter panteren");
        }


        //Laver DB.
        if (e.getSource()==btn_CreateDB){
            System.out.println("Lavede en db");
        }


    }

}
