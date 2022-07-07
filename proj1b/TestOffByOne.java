import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    OffByOne obo = new OffByOne();

    @Test
    public void testEqualChars() {
        assertFalse(obo.equalChars('a', 'a'));
        assertTrue(obo.equalChars('a', 'b'));
        assertTrue(obo.equalChars('r', 'q'));
        assertFalse(obo.equalChars('a', 'e'));
    }
}
