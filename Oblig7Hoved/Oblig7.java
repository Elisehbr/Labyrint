import java.util.Scanner;

public class Oblig7 {

    public static void main(String[] args){
        if (args.length == 0) {
            System.out.println("Du må oppgi filnavn som argument");
            return;
        }
    
        String fil = args[0];
        Labyrint lab = new Labyrint(fil);
        System.out.println("\nSlik ser labyrinten ut:\n");
        System.out.print(lab);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Skriv inn start-koordinater <rad> <kolonne> ('-1' for aa avslutte)");
            int rad = scanner.nextInt();
            if (rad == -1) {
                break;
            }

            int kol = scanner.nextInt();
            if (kol == -1) {
                break;
            }
            scanner.nextLine();
            if(rad < 0 || rad >= lab.hentAntRader() || kol < 0 || kol >= lab.hentAntKol()){
                System.out.println("Ugyldige koordinater. Prov igjen.");
                continue;
            }

            lab.finnUtveiFra(rad, kol);            
            //System.out.println(lab.ruter[rad][kol].toString());
        }
        
        scanner.close();
        
    }
}
