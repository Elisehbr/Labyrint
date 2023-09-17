public class Aapning extends HvitRute{
    public Aapning(Labyrint labyrint, int antRader, int antKolonner){
        super(labyrint, antRader, antKolonner);
    }
    
        @Override
        public void finn(Rute fra){
            System.out.println("Utvei: (" + antRader + "," + antKolonner + ")");
        }
    
        @Override
        public String toString() {
            return "O"; 
        }
    }
    

