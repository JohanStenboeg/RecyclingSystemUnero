package HanYo;

public class TestClass {
    public static void main(String[] args) {
        TotalValue totalValue = new TotalValue();
        //Når man sætter en flaske ind
        totalValue.addOnePantItem(EnumPantTyper.pantA);
        totalValue.addOnePantItem(EnumPantTyper.pantB);

        System.out.println(totalValue.getTotalAmountOfMoneyYouGet());
    }

}
