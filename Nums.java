import java.util.HashMap;
import java.util.Map;

/**
 * La classe Nums fournit des méthodes pour effectuer des conversions de nombres,
 * notamment la conversion d'entiers en leur équivalent en français et la conversion
 * de chiffres romains en entiers.
 *
 * @author JeongHan-Bae
 * @version 1.0
 */

public class Nums {
    static final Map<Character, Short> roToIntMap = new HashMap<>();
    static {
        roToIntMap.put('I', (short) 1);
        roToIntMap.put('V', (short) 5);
        roToIntMap.put('X', (short) 10);
        roToIntMap.put('L', (short) 50);
        roToIntMap.put('C', (short) 100);
        roToIntMap.put('D', (short) 500);
        roToIntMap.put('M', (short) 1000);
    }

    private static String[] bases = {"", "Un ", "Deux ", "Trois ", "Quatre ", "Cinq ", "Six ", "Sept ", "Huit ", "Neuf ", "Dix ", "Onze ", "Douze ", "Treize ", "Quatorze ", "Quinze ", "Seize ", "Dix-sept ", "Dix-huit ", "Dix-neuf "};
    private static String[] dizanes = {"", "", "Vingt ", "Trente ", "Quarante ", "Cinquante ", "Soixante ", "", "Quatre-Vingt-"};
    private static String[] echelles_un = {"Un", "Mille ", "Un Million ", "Un Milliard "};
    private static String[] echelles = {"", "Milles ", "Millions ", "Milliards "};

    public static String intToFr(int numero){
        if (numero == 0){ return "Zéro";}
        return (numero < 0) ? intToFr(-numero, "Moins ").trim(): intToFr(numero, "").trim();
    }

    private static String intToFr(int numero, String s){
        if (numero == 0){ return s;}
        byte echelle = (byte) (Math.log10(numero) / 3);
        int entier = numero / (int) (Math.pow(10, 3 * echelle));
        numero -= (int) (Math.pow(10, 3 * echelle)) * entier;
        if (entier == 0){ return intToFr(numero, s);}
        if (entier == 1){
            s += echelles_un[echelle];
            return intToFr(numero, s);
        }
        byte centaine = (byte) (entier / 100);
        if (centaine != 0){
            s += (centaine == 1) ? "Cent " : bases[centaine] + "Cents ";
        }
        byte reste = (byte) (entier - centaine * 100);
        if (reste == 80){
            s += "Quatre-Vingt ";
        } else {
            byte dizaine = (byte) ((reste/10 == 7 || reste/10 == 9 || reste/10 == 1) ? reste/10 - 1 : reste / 10);
            reste -= (byte) (dizaine * 10);
            s += dizanes[dizaine];
            if ((reste == 1 || reste == 11) && (dizaine != 0 && dizaine != 8)){ s += "et ";}
            s += bases[reste];
        }
        s += echelles[echelle];
        return intToFr(numero, s);
    }

    public static int romainToInt(String s){
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }
        int somme = 0;
        short val = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!roToIntMap.containsKey(c)) {
                return -1; // Invalid
            }
            short currentVal = roToIntMap.get(c);
            if (currentVal < val) {
                somme -= currentVal;
            } else {
                somme += currentVal;
            }
            val = currentVal;
        }
        return somme;
    }
}
