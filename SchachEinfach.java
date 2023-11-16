public class SchachEinfach {
    private static char[][] spielBrett = new char[10][10];

    private static char[][] brettAufbauen() {
        char dunkel = '\u2593'; // unicode für eine dunkle fläche
        char hell = '\u2591'; // unicode für eine helle fläche
        for (int zeile = 0; zeile < spielBrett.length; zeile++) {
            for (int spalte = 0; spalte < spielBrett[zeile].length; spalte++) {
                switch (zeile) {
                    case 0:
                    case 9:
                        if (spalte >= 1 && spalte <= 8) {
                            spielBrett[zeile][spalte] = (char) (64 + spalte);
                        } else {
                            spielBrett[zeile][spalte] = ' ';
                        }
                        break;
                    default:
                        if (spalte >= 1 && spalte <= 8) {
                            spielBrett[zeile][spalte] = (zeile + spalte) % 2 == 0 ? hell : dunkel;
                        } else {
                            spielBrett[zeile][spalte] = (char) (57 - zeile);
                        }
                        break;
                }
            }
        }
        return spielBrett;
    }

    private static void brettAnzeigen() {
        for (int zeile = 0; zeile < spielBrett.length; zeile++) {
            for (int spalte = 0; spalte < spielBrett[zeile].length; spalte++) {
                System.out.print(spielBrett[zeile][spalte]);
            }
            System.out.println();
        }
    }

    private static void brettDrehen(char[][] spielBrett) {
        int groesse = spielBrett.length;
        char[][] gedrehtesBrett = new char[groesse][groesse];

        for (int zeile = 0; zeile < groesse; zeile++) {
            for (int spalte = 0; spalte < groesse; spalte++) {
                gedrehtesBrett[zeile][spalte] = spielBrett[groesse - 1 - zeile][groesse - 1 - spalte];
            }
        }

        for (int zeile = 0; zeile < groesse; zeile++) {
            for (int spalte = 0; spalte < groesse; spalte++) {
                spielBrett[zeile][spalte] = gedrehtesBrett[zeile][spalte];
            }
        }
        System.out.println("Gedrehtes Spielbrett:");

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

    public static void main(String[] args) {
        spielBrett = brettAufbauen();
        figurenSetzen();
        brettAnzeigen();
        brettDrehen(spielBrett);
        brettAnzeigen();
    }
}
