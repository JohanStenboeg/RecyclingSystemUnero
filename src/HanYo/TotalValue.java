package HanYo;

public class  TotalValue {
  int antalA = 0;
  int antalB = 0;
  int antalC = 0;

  double totalAmountOfMoneyYouGet = 0;

  PantVærdier pantVærdier = new PantVærdier();

  //Når man panter et item.
  void addOnePantItem(EnumPantTyper typer){
      if(typer == EnumPantTyper.pantA){
          totalAmountOfMoneyYouGet += pantVærdier.getPantA();
          antalA++;
      }
      if(typer == EnumPantTyper.pantB){
          totalAmountOfMoneyYouGet += pantVærdier.getPantB();
          antalB++;
      }
      if(typer == EnumPantTyper.pantC){
          totalAmountOfMoneyYouGet += pantVærdier.getPantC();
          antalC++;
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
    void resetAlleVærdier() {
        antalA = 0;
        antalB = 0;
        antalC = 0;
        totalAmountOfMoneyYouGet = 0;
    }
}
