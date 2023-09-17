
public class HvitRute extends Rute {
    public HvitRute(Labyrint labyrint, int antRader, int antKolonner){
        super(labyrint, antRader, antKolonner);
    }

    @Override
    public char tilTegn(){
        return '.';
    }

    @Override
    public void finn(Rute fra) {
        super.finn(fra); // Kaller finn() på superklassen Rute
    }


    @Override
    public String toString() {
        return  ".";
    }

}
