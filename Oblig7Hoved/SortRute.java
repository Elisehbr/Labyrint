public class SortRute extends Rute {

    public SortRute(Labyrint labyrint, int antRader, int antKolonner){
        super(labyrint, antRader, antKolonner);
    }
    
    @Override
    public char tilTegn(){
        return '#';
    }

    @Override
    public void finn(Rute fra) {
        return;
    }

  
    @Override
    public String toString() {
        return "#";
    }
   
}
