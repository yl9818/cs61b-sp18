package synthesizer;

import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> bq = new ArrayRingBuffer<>();
        assertTrue(bq.isEmpty());
        bq.enqueue(9.3);
        bq.enqueue(15.1);
        bq.enqueue(31.2);
        assertFalse(bq.isFull());
        bq.enqueue(-3.1);
        assertTrue(bq.isFull());
        try {
            bq.enqueue(1.2);
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
        assertEquals((Double) 9.3, bq.dequeue());
        assertEquals((Double) 15.1, bq.peek());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }

}
