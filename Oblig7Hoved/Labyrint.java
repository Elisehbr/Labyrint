import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Labyrint{

    public String filepath;
    public int antRader;
    public int antKolonner;
    Rute[][] ruter;
    
    public Labyrint(String fil){
        this.filepath = fil;
        lesFraFil(fil);
    }  

    public Rute hentRute(int rad, int kol){
        return ruter[rad][kol];
    }

    public int hentAntKol(){
        return antKolonner;
    }

    public int hentAntRader(){
        return antRader;
    }

   
    public void finnUtveiFra(int rad, int kol) {
        System.out.println("Utvei fra startkoordinatene (" + rad + ", " + kol + "):");
        Rute startRute = ruter[rad][kol];
        if(startRute.tilTegn() == '#'){
            System.out.println("Kan ikke starte på en sort rute!");
        }else{
            startRute.finn(null);
        }

    }

    public void lesFraFil(String filnavn){
        try {
            Scanner scanner = new Scanner(new File(filnavn));

            antRader = scanner.nextInt();
            antKolonner = scanner.nextInt();
            ruter = new Rute[antRader][antKolonner];

            scanner.nextLine(); // Leser bort linjeskiftet etter første linje

            for (int rad = 0; rad < antRader; rad++) {
                String linje = scanner.nextLine();
                for (int kolonne = 0; kolonne < antKolonner; kolonne++) {
                    char tegn = linje.charAt(kolonne);

                    if((tegn == '.') && (rad == 0 || rad == antRader-1 || kolonne == 0 || kolonne == antKolonner -1)){
                        ruter[rad][kolonne] = new Aapning(this, rad, kolonne);
                    }else if(tegn == '.'){
                        ruter[rad][kolonne] = new HvitRute(this, rad, kolonne);
                    }else if(tegn == '#'){
                        ruter[rad][kolonne] = new SortRute(this, rad, kolonne);
                    }
                }
            }

            kobleNaboer();

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Finner ikke filen " + filnavn);
        }

 
    }



    public void kobleNaboer(){
       // Legg til nabo-referanser for hver rute
        for (int rad = 0; rad < antRader; rad++) {
            for (int kolonne = 0; kolonne < antKolonner; kolonne++) {
                Rute rute = ruter[rad][kolonne];
                leggTilNaboNord(rute, rad, kolonne);
                leggTilNaboSor(rute, rad, kolonne);
                leggTilNaboVest(rute, rad, kolonne);
                leggTilNaboOest(rute, rad, kolonne);
            }
        }
    }

    private void leggTilNaboNord(Rute rute, int rad, int kolonne) {
        if (rad > 0) {
            Rute nabo = ruter[rad - 1][kolonne];
            rute.settNord(nabo);
        }
    }
    
    private void leggTilNaboSor(Rute rute, int rad, int kolonne) {
        if (rad < antRader - 1) {
            Rute nabo = ruter[rad + 1][kolonne];
            rute.settSor(nabo);
        }
    }
    
    private void leggTilNaboVest(Rute rute, int rad, int kolonne) {
        if (kolonne > 0) {
            Rute nabo = ruter[rad][kolonne - 1];
            rute.settVest(nabo);
        }
    }
    
    private void leggTilNaboOest(Rute rute, int rad, int kolonne) {
        if (kolonne < antKolonner - 1) {
            Rute nabo = ruter[rad][kolonne + 1];
            rute.settOest(nabo);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < antRader; i++) {
            for (int j = 0; j < antKolonner; j++) {
                Rute rute = ruter[i][j];
                sb.append(rute.tilTegn());
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}