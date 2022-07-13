import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestArrayDequeGold {

    @Test
    public void test() {
        StudentArrayDeque<Integer> saq = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StringBuilder msg = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 5 == 0) {
                msg.append("size()\n");
                assertEquals(msg.toString(), ads.size(), saq.size());
            }
            int switcher = StdRandom.uniform(4);
            if (switcher == 0) {
                    msg.append("addFirst("+i+")");
                    saq.addFirst(i);
                    ads.addFirst(i);
                    counter++;
                    assertEquals(msg.toString(), ads.get(0), saq.get(0));
                    break;
            } else if (switcher == 1) {
                    msg.append("addLast("+i+")");
                    saq.addLast(i);
                    ads.addLast(i);
                    counter++;
                    assertEquals(ads.get(counter - 1), saq.get(counter - 1));
            } else if (switcher == 2) {
                if (ads.isEmpty()) {
                    assertTrue(saq.isEmpty());
                    continue;
                }
                msg.append("removeFirst()");
                Integer adsFirst = ads.removeFirst();
                Integer saqFirst = saq.removeFirst();
                counter--;
                assertEquals(msg.toString(), adsFirst, saqFirst);
            } else if (switcher == 3) {
                if (ads.isEmpty()) {
                    assertTrue(saq.isEmpty());
                    continue;
                }
                Integer adsLast = ads.removeLast();
                Integer saqLast = saq.removeLast();
                msg.append("removeLast()");
                counter--;
                assertEquals(msg.toString(), adsLast, saqLast);
            }
        }
    }

}
