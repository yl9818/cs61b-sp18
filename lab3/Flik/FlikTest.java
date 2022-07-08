import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class FlikTest {

    @Test
    public void testIsSameNumber() {
        Integer i = 128;
        Integer j = 128;
        assertTrue(Flik.isSameNumber(i, j));

        int a = 128;
        int b = 128;
        assertTrue(Flik.isSameNumber(a, b));
    }
}
