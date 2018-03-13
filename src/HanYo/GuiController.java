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

    TotalValue totalValue = new TotalValue();

    @FXML
    private void handleButtonAction(ActionEvent e) {

        //Man ligger en ting ind med Pant A.
        if (e.getSource()==btn_pantA){
            System.out.println("Pant A");
            totalValue.addOnePantItem(EnumPantTyper.pantA);
            lbl_kronarz.setText(totalValue.totalAmountOfMoneyYouGet+" kr.");

        }

        //Man ligger en ting ind med Pant B.
        if (e.getSource()==btn_pantB){
            System.out.println("Pant B");
            totalValue.addOnePantItem(EnumPantTyper.pantB);
            lbl_kronarz.setText(totalValue.totalAmountOfMoneyYouGet+" kr.");


        }

        //Man ligger en ting ind med Pant C.
        if (e.getSource()==btn_pantC){
            System.out.println("Pant C");
            totalValue.addOnePantItem(EnumPantTyper.pantC);
            lbl_kronarz.setText(totalValue.totalAmountOfMoneyYouGet+" kr.");
        }


        //Printer total i danske donalders aka. pant
        if (e.getSource()==btn_getPant){
            System.out.println("Getter panteren");
            lbl_kronarz.setText("Du har nu doneret til os");
            totalValue.resetAlleVærdier();

        }


        //Laver DB.
        if (e.getSource()==btn_CreateDB){
            System.out.println("Lavede en db");

        }



    }

}
