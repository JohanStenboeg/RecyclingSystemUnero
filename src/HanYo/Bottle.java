package HanYo;

public class Bottle {
    private String type;
    private String materiale;
    private String størrelse;

    //Default constructor, med kun enum pant typer
    public Bottle(EnumPantTyper pantTyper) {
    }
    private Bottle(EnumPantTyper pantTyper, String type) {
        this.type = type;
    }
    private Bottle(EnumPantTyper pantTyper,String type, String størrelse){
        this.type = type;
        this.størrelse = størrelse;
    }

    private Bottle(EnumPantTyper pantTyper,String type, String materiale, String størrelse){
        this.type = type;
        this.størrelse = størrelse;
        this.materiale = materiale;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public String getStørrelse() {
        return størrelse;
    }

    public void setStørrelse(String størrelse) {
        this.størrelse = størrelse;
    }
}

