package Entity;

public class  TotalValue {
  int antalA = 0;
  int antalB = 0;
  int antalC = 0;

  public double totalAmountOfMoneyYouGet = 0;

  PantVærdier pantVærdier = new PantVærdier();

  //Når man panter et item.
  public void addOnePantItem(EnumPantTyper typer){
      if(typer == EnumPantTyper.pantA){
          totalAmountOfMoneyYouGet += pantVærdier.getPantA();
          antalA++;
          //Insert SQL Statement method here
      }
      if(typer == EnumPantTyper.pantB){
          totalAmountOfMoneyYouGet += pantVærdier.getPantB();
          antalB++;
          //Insert SQL Statement method here
      }
      if(typer == EnumPantTyper.pantC){
          totalAmountOfMoneyYouGet += pantVærdier.getPantC();
          antalC++;
          //Insert SQL Statement method here
      }

  }

  //Gettere af antal type.
    public int getAntalA() {
        return antalA;
    }

    public int getAntalB() {
        return antalB;
    }

    public int getAntalC() {
        return antalC;
    }

    public double getTotalAmountOfMoneyYouGet(){
        return totalAmountOfMoneyYouGet;
    }


    //Resetter værdier, (når man slår på print)
    public void resetAlleVærdier() {
        antalA = 0;
        antalB = 0;
        antalC = 0;
        totalAmountOfMoneyYouGet = 0;
    }
}
