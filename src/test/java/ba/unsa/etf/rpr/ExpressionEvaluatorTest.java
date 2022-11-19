
package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ExpressionEvaluatorTest {

    /**
     * trivijalan test ispravnosti bez ikakvih faktora
     */
    @Test
    void Test1() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate(" ");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("( )");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("( + )");
        });
    }

    /**
     * neispravan broj zagrada
     */
    @Test
    void Test2() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("( 2 + 4 + 6 )");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("( ( 7 + 8 ) )");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("3 + ( 3 )");
        });
    }

    /**
     * test na razmake
     */
    @Test
    void Test3() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("( 7+8 )");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("(4+2)");
        });
    }

    /**
     *testiranje par nekih trivijalnih izraza
     */
    @Test
    void Test4() {
        Assertions.assertEquals(400, ExpressionEvaluator.evaluate("( 20 * 20 )"));
        Assertions.assertEquals(15, ExpressionEvaluator.evaluate("( 8 + 7 )"));
        Assertions.assertEquals(32, ExpressionEvaluator.evaluate("( 64 / 2 )"));
        Assertions.assertEquals(11, ExpressionEvaluator.evaluate("( 121 / 11 )"));
        Assertions.assertEquals(0, ExpressionEvaluator.evaluate("( 5 - 5 )"));
    };

    /**
     * ako ne baca izuzetak radi kako treba
     */
    @Test
    void Test5() {
        Assertions.assertEquals(101,ExpressionEvaluator.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
    }

}

