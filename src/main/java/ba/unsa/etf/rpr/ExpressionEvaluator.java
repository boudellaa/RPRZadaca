package ba.unsa.etf.rpr;

import java.util.Stack;

import static java.lang.Double.parseDouble;

/**
 * ExpressionEvaluator je klasa koja koristi dvije instance klase java.util.Stack
 * kako bi izracunala izraz koristenjem Dijkstra algorithm
 */
public class ExpressionEvaluator {
    private static final Stack<String> operatori = new Stack<>();
    private static final Stack<Double> vrijednosti = new Stack<>();

    /**
     * metoda evaluate prima string i racuna njegovu vrijednost koristeci Dijkstra algorithm
     */
    public static double evaluate(String str){
        if(str.isEmpty()) throw new RuntimeException();
        operatori.clear();
        vrijednosti.clear();
        int br_otvorenih_zagrada = 0, br_zatvorenih_zagrada = 0;
        int br_operatora = 0, br_op_u_zagradi = 0;
        for(String pomocni : str.split(" ")){
            if(pomocni.equals("(")) {br_otvorenih_zagrada++; br_op_u_zagradi = 0;}
            else if(pomocni.equals("+")) { operatori.push(pomocni); br_operatora++; br_op_u_zagradi++;}
            else if(pomocni.equals("-")) { operatori.push(pomocni); br_operatora++; br_op_u_zagradi++;}
            else if(pomocni.equals("*")) { operatori.push(pomocni); br_operatora++; br_op_u_zagradi++;}
            else if(pomocni.equals("/")) { operatori.push(pomocni); br_operatora++; br_op_u_zagradi++;}
            else if(pomocni.equals("sqrt")) { operatori.push(pomocni); br_operatora++; br_op_u_zagradi++;}
            else if(pomocni.equals(")")){
                br_zatvorenih_zagrada++;
                if(br_op_u_zagradi != 1) throw new RuntimeException();
                String op = operatori.pop();
                double v = vrijednosti.pop();
                if (op.equals("+")) v = vrijednosti.pop() + v;
                else if (op.equals("-")) v = vrijednosti.pop() - v;
                else if (op.equals("*")) v = vrijednosti.pop() * v;
                else if (op.equals("/")) v = vrijednosti.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vrijednosti.push(v);
            }
            else vrijednosti.push(parseDouble(pomocni));
        }
        if(br_otvorenih_zagrada != br_operatora || br_otvorenih_zagrada != br_zatvorenih_zagrada) throw new RuntimeException();
        return vrijednosti.pop();
    }


}
