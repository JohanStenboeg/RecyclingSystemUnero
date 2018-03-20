package GUI;

import Entity.EnumPantTyper;
import Entity.Kvittering;
import Entity.TotalValue;
import Database.mySQL_DBstatements;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.text.DecimalFormat;

public class GuiController {
    DecimalFormat df = new DecimalFormat("####0.00");
    Kvittering kvittering = new Kvittering();

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
    mySQL_DBstatements mySQL_dBstatements = new mySQL_DBstatements();

    @FXML
    private void handleButtonAction(ActionEvent e) {
        mySQL_dBstatements.useDB();

        //Man ligger en ting ind med Pant A.
        if (e.getSource()==btn_pantA){
            System.out.println("Pant A");
            totalValue.addOnePantItem(EnumPantTyper.pantA);
            lbl_kronarz.setText(totalValue.totalAmountOfMoneyYouGet+" kr.");
            mySQL_dBstatements.pantIndiDB(EnumPantTyper.pantA);

        }

        //Man ligger en ting ind med Pant B.
        if (e.getSource()==btn_pantB){
            System.out.println("Pant B");
            totalValue.addOnePantItem(EnumPantTyper.pantB);
            lbl_kronarz.setText(totalValue.totalAmountOfMoneyYouGet+" kr.");
            mySQL_dBstatements.pantIndiDB(EnumPantTyper.pantB);


        }

        //Man ligger en ting ind med Pant C.
        if (e.getSource()==btn_pantC){
            System.out.println("Pant C");
            totalValue.addOnePantItem(EnumPantTyper.pantC);
            lbl_kronarz.setText(totalValue.totalAmountOfMoneyYouGet+" kr.");
            mySQL_dBstatements.pantIndiDB(EnumPantTyper.pantC);

        }


        //Printer total i danske donalders aka. pant
        if (e.getSource()==btn_getPant){
            System.out.println("Getter panteren");
            lbl_kronarz.setText("Du har nu doneret "+df.format(totalValue.getTotalAmountOfMoneyYouGet())+" kr. til  os.");
            kvittering.printkvitbro(totalValue.getTotalAmountOfMoneyYouGet());
            totalValue.resetAlleVærdier();

        }


        //Laver DB.
        if (e.getSource()==btn_CreateDB){
            mySQL_dBstatements.antalFlaskerTableCreate();
            mySQL_dBstatements.InsertITable2();
            System.out.println("Lavede en db");

        }



    }

}
