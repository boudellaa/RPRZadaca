package ba.unsa.etf.rpr;

/**
 * App klasa sa ispisom rjesenja
 */
public class App {
    /**
     * metoda main koja prima string
     */
    public static void main(String[] args) {
        String str = args[0];
        str.trim();
        try{
            ExpressionEvaluator izraz = new ExpressionEvaluator();
            Double kraj = izraz.evaluate(str);
            System.out.print("Rjesenje zadatka je: ");
            System.out.println(kraj);
        }
        catch(RuntimeException izuzetak){
            System.out.println("Nije ispravan izraz!");
        }

    }
}

