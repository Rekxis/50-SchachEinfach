public class SchachEinfach {

    private static char[][] brettAufbauen(char[][] spielBrett) {
        char dunkel = '\u2593'; // unicode für eine dunkle fläche
        char hell = '\u2591'; // unicode für eine helle fläche
        for (int zeile = 0; zeile < spielBrett.length; zeile++) {
            for (int spalte = 0; spalte < spielBrett[0].length; spalte++) {
                if ((zeile + spalte) % 2 == 0) {
                    spielBrett[zeile][spalte] = hell;
                } else {
                    spielBrett[zeile][spalte] = dunkel;
                }
            }
        }
        return spielBrett;
    }

    private static void brettAnzeigen(char[][] spielBrett) {
        System.out.print("  abcdefgh\n");

        for (int zeile = 0; zeile < spielBrett.length; zeile++) {
            System.out.print((zeile + 1) + " ");
            for (int spalte = 0; spalte < spielBrett[zeile].length; spalte++) {
                System.out.print(spielBrett[zeile][spalte]);
            }

            System.out.println(" " + (8 - zeile));
        }
        System.out.print("  abcdefgh\n");
    }

    private static char[][] brettDrehen(char[][] spielBrett) {
        int groesse = spielBrett.length;
        char[][] gedrehtesBrett = new char[groesse][groesse];

        for (int zeile = 0; zeile < groesse; zeile++) {
            for (int spalte = 0; spalte < groesse; spalte++) {
                gedrehtesBrett[zeile][spalte] = spielBrett[groesse - 1 - zeile][groesse - 1 - spalte];
            }
        }
        System.out.println("Gedrehtes Spielbrett:");
        return gedrehtesBrett;
    }

    public static void main(String[] args) {
        char[][] spielBrett = new char[8][8];
        spielBrett = brettAufbauen(spielBrett);
        spielBrett[5][1] = 'a'; // zur darstellung das brettDrehen richtig funktioniert
        brettAnzeigen(spielBrett);
        brettAnzeigen(brettDrehen(spielBrett));
    }
}
