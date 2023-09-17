import java.util.ArrayList;
public abstract class Rute {
    public Labyrint labyrint;
    public int antRader;
    public int antKolonner;
    public Rute nord, sor, oest, vest;
    public boolean besokt = false;
    
  
    
    public Rute(Labyrint labyrint, int antRader, int antKolonner){
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        this.labyrint = labyrint;
    }

    

    public void settNord(Rute nord){
        this.nord = nord;
    }
    public void settSor(Rute sor){
        this.sor = sor;
    }
    public void settOest(Rute oest){
        this.oest = oest;
    }
    public void settVest(Rute vest){
        this.vest = vest;
    }

    public abstract char tilTegn();


    public void finn(Rute fra) {
        if (besokt) {
            // Vi har allerede vært i denne ruten, avbryt for å unngå uendelig løkke
            return;
        }
        

        besokt = true;
        
        // Utforsk nabo-rutene (inkludert sorte ruter) unntatt den som er i retningen kallet kom fra
        if (nord != null && nord != fra) {
            nord.finn(this); // Kaller finn() på nord-ruten
        }
        if (sor != null && sor != fra) {
            sor.finn(this); // Kaller finn() på sor-ruten
        }
        if (oest != null && oest != fra) {
            oest.finn(this); // Kaller finn() på ost-ruten
        }
        if (vest != null && vest != fra) {
            vest.finn(this); // Kaller finn() på vest-ruten
        }
            
        besokt = false;

        
    }


  

    public Labyrint getLabyrint() {
        return labyrint;
    }

}
