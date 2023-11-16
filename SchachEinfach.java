import java.util.Scanner;

public class SchachEinfach {
    private static char[][] spielBrett = new char[10][10];
    private final static String[] spieler = {"Schwarz", "Weiß"};
    private final static char dunkel = '\u2593'; // unicode für eine dunkle fläche
    private final static char hell = '\u2591'; // unicode für eine helle fläche
    private static int zugNr = 1;

    private static char[][] brettAufbauen() {
        for (int zeile = 0; zeile < spielBrett.length; zeile++) {
            for (int spalte = 0; spalte < spielBrett[zeile].length; spalte++) {
                switch (zeile) {
                    case 0:
                    case 9:
                        spielBrett[zeile][spalte] = (char) (spalte >= 1 && spalte <= 8 ? 64 + spalte : 32);
                        break;
                    default:
                        if (spalte >= 1 && spalte <= 8) {
                            spielBrett[zeile][spalte] = (zeile + spalte) % 2 == 0 ? hell : dunkel;
                        } else {
                            spielBrett[zeile][spalte] = (char) (57 - zeile);
                        }
                }
            }
        }
        return spielBrett;
    }

    private static void brettDarstellen(boolean richtung) {
        for (int zeile = 0; zeile < spielBrett.length; zeile++) {
            for (int spalte = 0; spalte < spielBrett[zeile].length; spalte++) {
                int z = (richtung) ? zeile : (spielBrett.length - 1 - zeile);
                int s = (richtung) ? spalte : (spielBrett.length - 1 - spalte);
                System.out.print(spielBrett[z][s]);
            }
            System.out.println();
        }
    }

    private static void figurenSetzen() {
        char[][] figuren = { { 'T', 'S', 'L', 'K', 'D', 'L', 'S', 'T' }, 
                            { 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B' } };
        for (int zeile = 0; zeile < figuren.length ; zeile++) {
            for (int spalte = 0; spalte < figuren[zeile].length; spalte++) {
                spielBrett[zeile + 1][spalte + 1] = figuren[zeile][spalte];
                spielBrett[8 - zeile][spalte + 1] = Character.toLowerCase(figuren[zeile][spalte]);
            }
        }  
    }

    private static void figurBewegen(boolean wer) {
        System.out.println((wer ? spieler[0] : spieler[1]) + " ist am Zug");
        Scanner sc = new Scanner(System.in);
        String eingabe = sc.nextLine();
        int zeileVon, spalteVon, zeileNach, spalteNach;

        zeileVon =  9 - eingabe.charAt(1) + 48;  
        spalteVon =     eingabe.charAt(0) - 64; 
        zeileNach = 9 - eingabe.charAt(3) + 48;
        spalteNach =    eingabe.charAt(2) - 64;

        spielBrett[zeileNach][spalteNach] = spielBrett[zeileVon][spalteVon];
        spielBrett[zeileVon][spalteVon] = ((zeileVon + spalteVon) % 2 == 0) ? hell : dunkel;
    }


    public static int getZugNr() {
        return zugNr;
    }

    public static void main(String[] args) {
        spielBrett = brettAufbauen();
        figurenSetzen();

        do {
            brettDarstellen(true);
            figurBewegen(getZugNr() % 2 == 0);
            System.out.println("\n\n\n\n");
            brettDarstellen(false);
            figurBewegen(getZugNr() % 2 == 0);
        } while (getZugNr() < 6);
    }
}
